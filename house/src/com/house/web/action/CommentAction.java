package com.house.web.action;

import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.house.domain.Comment;
import com.house.domain.House;
import com.house.domain.News;
import com.house.domain.PageBean;
import com.house.domain.User;
import com.house.service.CommentService;
import com.house.service.HouseService;
import com.house.service.NewService;
import com.house.service.UserService;
import com.house.utils.UploadUtil;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 评论控制器
 * @author ming
 *
 */
@SuppressWarnings("all")
public class CommentAction extends BaseAction implements ModelDriven<Comment>{
	private CommentService commentService;
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	private UserService userService;
	private NewService newService;
	private HouseService houseService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setNewService(NewService newService) {
		this.newService = newService;
	}
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	private Comment comment = new Comment();
	public Comment getModel() {
		return comment;
	}
	
	// 保存房子id
	private Long hid;
	public void setHid(Long hid) {
		this.hid = hid;
	}
	//保存用户id
	private long uid;
	public void setUid(long uid) {
		this.uid = uid;
	}
	//保存新闻id
	private long nid;
	public void setNid(long nid) {
		this.nid = nid;
	}

	private File upload;	// 要上传的文件
	private String uploadFileName;	// 文件的名称
	private String uploadContentType;	// 文件的MIME的类型
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	private static final String filepath = "/upload/comment/";

	/**
	 * 1. 保存
	 * @return
	 * @throws IOException 
	 */
	public String save() throws IOException{
		User user=userService.findById(uid);
		House house=houseService.findById(hid);
		News news=newService.findById(nid);
		comment.setHouse(house);
		comment.setNews(news);
		comment.setUser(user);
	
		if(uploadFileName != null){
			// 处理文件名称
			String uuidname = UploadUtil.getUUIDName(uploadFileName);
			// 获取文件路径
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getSession().getServletContext().getRealPath("upload/comment");			
			// 创建file对象
			File file = new File(path,uuidname);
			// 复制
			FileUtils.copyFile(upload, file);
				// 保存文件上传路径
			comment.setCimage(filepath+uuidname);
					}
		comment.setCtime(new Date());
		commentService.save(comment);
		return SAVE;
	}
	
	/**
	 * 2. 通过房屋id查找评论
	 * @return
	 */
	public String findByPage(){
		/**
		 * 1. 确定新闻id
		 * 
		 */
		DetachedCriteria criteria = DetachedCriteria.forClass(Comment.class);
		criteria.add(Restrictions.sqlRestriction("news_comment_id="+nid));
		
		/**
		 * 2. 判断是否带有条件
		 */
//		if(comment != null){
//			String content = comment.getContent();
//			if(content != null && !content.trim().isEmpty()){
//				criteria.add(Restrictions.like("content", "%"+content+"%"));
//			}
//		}
		int pageCode = getPageCode();
		int pageSize = 3;
		PageBean<Comment> pb = commentService.findByPage(pageCode, pageSize, criteria);
		setVs("pb", pb);

		// 保存房子id，方便进行下一页查询
		setVs("nid",nid);
		if(uid!=0){
				
		setVs("uid",uid);
		}
		
		return PAGE;
	}
	
	/**
	 * 3. 删除评论
	 * @return
	 */
	public String delete(){
		comment = commentService.findById(comment.getCid());
		String oldFilePath = comment.getCimage();
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath(oldFilePath);
		if(oldFilePath != null && !oldFilePath.trim().isEmpty()){
			File f = new File(path);
			f.delete();	// 删除原来的文件
		}
		commentService.delete(comment);
		// 设置房子id，在result结果集中传值
		setVs("hid", hid);
		return DELETE;
	}
	
	//跳到评论添加页面
	public String addUI(){
		setVs("uid", uid);
		setVs("hid", hid);
		setVs("nid", nid);
		return "addUI";
	}
	
}
