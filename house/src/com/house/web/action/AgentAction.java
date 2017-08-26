package com.house.web.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.house.domain.Agent;
import com.house.domain.PageBean;
import com.house.service.AgentService;
import com.house.utils.FastJsonUtil;
import com.house.utils.UploadUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户控制层
 * @author ming
 */
@SuppressWarnings("all")
public class AgentAction extends BaseAction implements ModelDriven<Agent> {
	// 通过模型驱动方式注入，提供get方法
	private Agent agent = new Agent();
	
	public Agent getModel() {
		return agent;
	}

	public AgentAction(){
	}
	
	// 通过ioc容器创建service依赖对象，提供set方法
	private AgentService agentService;
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
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
	private static final String filepath = "/upload/agent/";
	
	/**
	 * 1. 保存经纪人
	 * @return
	 * @throws IOException 
	 */
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
			agent.setAimage(filepath+uuidname);
		}
		agentService.save(agent);
		return SAVE;
	}
	
	/**
	 * 2. 修改经纪人
	 * @return
	 * @throws IOException 
	 */
	public String update() throws IOException{
		// 图片的上传，说明用户选择了上传的文件了
		if(uploadFileName != null){
			
			/**
			 * 1. 删除原来的文件
			 * 2. 保存新创建的文件
			 * 3. 更新数据库的文件路径
			 */
			// 获取原来文件路径
			String oldFilePath = agent.getAimage();
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getSession().getServletContext().getRealPath(oldFilePath);
			if(oldFilePath != null && !oldFilePath.trim().isEmpty()){
				File f = new File(path);
				f.delete();	// 删除原来的文件
			}
			
			// 处理现文件名称
			String uuidname = UploadUtil.getUUIDName(uploadFileName);
		    path = request.getSession().getServletContext().getRealPath("upload/agent");			
			// 创建file对象
			File file = new File(path,uuidname);
			// 简单方式
			FileUtils.copyFile(upload, file);
			// 保存文件上传路径
			agent.setAimage(filepath+uuidname);
		}
		agentService.update(agent);
		return UPDATE;
	}
	
	/**
	 * 3. 删除
	 * @return
	 */
	public String delete(){
		
		agent = agentService.findById(agent.getAid());
		

		// 获取文件保存路径
		String oldFilePath = agent.getAimage();
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getSession().getServletContext().getRealPath(oldFilePath);
		if(oldFilePath != null && !oldFilePath.trim().isEmpty()){
			File f = new File(path);
			f.delete();	// 删除原来的文件
		}
		// 删除实体类
		agentService.delete(agent);
		
		// 删除文件
//		File f = new File(realPath);
//		if(f.exists()){
//			f.delete();
//		}
		return DELETE;
	}
	
	/**
	 * 4. 查询所有:通过json的方式返回
	 * @return
	 */
	public String findAll(){
		List<Agent> list = agentService.findAll();
		// 使用工具类将json转换成串
		String jsonString = FastJsonUtil.toJSONString(list);
		// 输出到浏览器中
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
	}
	
	/**
	 * 5. 通过区域名称查找
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String findByArea() throws UnsupportedEncodingException{
		// 获取ajax传递过来的区域名称
		HttpServletRequest request = getRequest();
		String area = request.getParameter("area");
		// 查找
		List<Agent> list = agentService.findByArea(area);
		String jsonString = FastJsonUtil.toJSONString(list);
		// 输出到浏览器中
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
		return NONE;
	}
	
	/**
	 * 返回到编辑页面
	 * @return
	 */
	public String editUI(){
		agent = agentService.findById(agent.getAid());
		return "editUI";
	}
	
	
	/**
	 * 根据条件查询所有
	 * @return
	 */
	public String findByPage(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Agent.class);
		/**
		 * 1. 拼接条件
		 * 2. 查询
		 * 3. 压入栈顶
		 * 4. 返回结果集
		 */
		String aname = agent.getAname();
		
		if(aname != null && !aname.trim().isEmpty()){
			criteria.add(Restrictions.like("aname", "%"+aname+"%"));
		}
		String acompany = agent.getAcompany();
		if(acompany != null && !aname.trim().isEmpty()){
			criteria.add(Restrictions.like("acompany", "%"+acompany+"%"));
		}
		
		PageBean<Agent> pb = agentService.findByPage(getPageCode(), getPageSize(), criteria);
		setVs("pb", pb);
		return PAGE;
	}
}
