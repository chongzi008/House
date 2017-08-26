package com.house.web.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.house.domain.Agent;
import com.house.domain.News;
import com.house.domain.PageBean;
import com.house.domain.User;
import com.house.service.UserService;
import com.house.utils.UploadUtil;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户控制层
 * @author ming
 */
@SuppressWarnings("all")
public class UserAction extends BaseAction implements ModelDriven<User> {
	// 通过模型驱动方式注入，提供get方法
	private User user = new User();
	public User getModel() {
		return user;
	}

	// 通过ioc容器创建service依赖对象，提供set方法
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 文件上传所需属性
	 */
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
	
	// 文件的保存路径
	private static final String filepath = "/upload/user/";
	

	/**
	 * 用户注册
	 * @return
	 * @throws IOException 
	 */
	public String regist() throws IOException{
		// 1. 封装数据
		// 2. 判断账户是否存在（在前端判断）
		// 3. 保存用户
		// 4. 发送验证码
		// 图片的上传，说明用户选择了上传的文件了
	    if(uploadFileName != null){
		// 处理文件名称
		String uuidname = UploadUtil.getUUIDName(uploadFileName);
		// 获取文件路径
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath("upload/user");			
		// 创建file对象
		File file = new File(path,uuidname);
		// 复制
		FileUtils.copyFile(upload, file);
			// 保存文件上传路径
		user.setUimage(filepath+uuidname);
				}
		userService.save(user);
		
		return "register";
	}

	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		User userInfo=userService.findUser(user.getUsername(), user.getUpassword());
		setVs("uid", userInfo.getUid());
		
		if(userInfo!=null){
			setVs("userInfo", userInfo);
		return "login";
		}else{
			return ERROR;
		}
	}
	
	//保存用户
	public String save() throws IOException{
		// 图片的上传，说明用户选择了上传的文件了
	    if(uploadFileName != null){
		// 处理文件名称
		String uuidname = UploadUtil.getUUIDName(uploadFileName);
		// 获取文件路径
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath("upload/agent");			
		// 创建file对象
		File file = new File(path,uuidname);
		// 复制
		FileUtils.copyFile(upload, file);
			// 保存文件上传路径
		user.setUimage(filepath+uuidname);
				}
		userService.save(user);
		return SAVE;
	}
	//查看用户列表
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		int pageCode = getPageCode();
		int pageSize = 3;
		PageBean<User> pb = userService.findByPage(pageCode, pageSize, criteria);
		setVs("pb", pb);
		
		return PAGE;
	}
	//更新用户视图
	public String editUI(){
		User userInfo=userService.findById(user.getUid());
		setVs("userInfo", userInfo);
		return "editUI";
	}
	//更新用户
	public String update() throws IOException{
		// 图片的上传，说明用户选择了上传的文件了
		if(uploadFileName != null){
			
			/**
			 * 1. 删除原来的文件
			 * 2. 保存新创建的文件
			 * 3. 更新数据库的文件路径
			 */
			// 获取原来文件路径
			String oldFilePath = user.getUimage();
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getSession().getServletContext().getRealPath(oldFilePath);
			if(oldFilePath != null && !oldFilePath.trim().isEmpty()){
				File f = new File(path);
				f.delete();	// 删除原来的文件
			}
			
			// 处理现文件名称
			String uuidname = UploadUtil.getUUIDName(uploadFileName);
		    path = request.getSession().getServletContext().getRealPath("upload/user");			
			// 创建file对象
			File file = new File(path,uuidname);
			// 简单方式
			FileUtils.copyFile(upload, file);
			// 保存文件上传路径
			user.setUimage(filepath+uuidname);
		}
		userService.update(user);
		return UPDATE;
	}
	//删除用户
	public String delete(){
		User userInfo=userService.findById(user.getUid());
		String oldFilePath = userInfo.getUimage();
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath(oldFilePath);
		if(oldFilePath != null && !oldFilePath.trim().isEmpty()){
			File f = new File(path);
			f.delete();	// 删除原来的文件
		}
		userService.delete(userInfo);
		return DELETE;
	}
    public String findByName(){
    	DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		
		criteria.add(Restrictions.sqlRestriction("username like '"+"%"+user.getUsername()+"%"+"'"));
	
		/**
		 * 2. 判断是否带有条件
		 */
		
		int pageCode = getPageCode();
		int pageSize = 3;
		PageBean<User> pb = userService.findByPage(pageCode, pageSize, criteria);
		setVs("pb", pb);

    	return PAGE;
    }
}
