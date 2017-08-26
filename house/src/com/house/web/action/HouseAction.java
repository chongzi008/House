package com.house.web.action;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;

import sun.management.resources.agent;

import com.house.domain.Agent;
import com.house.domain.House;
import com.house.domain.PageBean;
import com.house.service.AgentService;
import com.house.service.HouseService;
import com.house.utils.UploadUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class HouseAction extends BaseAction implements ModelDriven<House>{
	private House house = new House();
	public House getModel() {
		return house;
	}
	private HouseService houseService;
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	private AgentService agentService;
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	//保存用户id
	private Long uid;
	public void setUid(Long uid) {
		this.uid = uid;
	}
	private Long aid;
	public void setAid(Long aid) {
		this.aid = aid;
	}
	
  private String price;//价格
	public void setPrice(String price) {
	this.price = price;
}
	private String area;//面积
	public void setArea(String area) {
		this.area = area;
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
	
	private static final String filepath = "/upload/house/";
	
	/**
	 * 1. 保存房子
	 * @return
	 * @throws IOException 
	 */
	public String save() throws IOException{
		if(uploadFileName != null){
			String uuidName = UploadUtil.getUUIDName(uploadFileName);
			//获取文件的保存路径
			String realPath = getRequest().getServletContext().getRealPath("/upload/house");
			// 创建文件
			File file = new File(realPath,uuidName);
			FileUtils.copyFile(upload, file);
			// 保存文件路径
			house.setHimage("/upload/house/"+uuidName);
		}
	
	    Agent agent=agentService.findById(aid);
		house.setAgent(agent);
		
		houseService.save(house);
		return SAVE;
	}
	
	/**
	 * 3. 修改
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
			String oldFilePath = house.getHimage();
			HttpServletRequest request = ServletActionContext.getRequest();
			String path = request.getSession().getServletContext().getRealPath(oldFilePath);
			if(oldFilePath != null && !oldFilePath.trim().isEmpty()){
				File f = new File(path);
				f.delete();	// 删除原来的文件
			}
			
			// 处理现文件名称
			String uuidname = UploadUtil.getUUIDName(uploadFileName);
		    path = request.getSession().getServletContext().getRealPath("upload/house");			
			// 创建file对象
			File file = new File(path,uuidname);
			// 简单方式
			FileUtils.copyFile(upload, file);
			// 保存文件上传路径
			house.setHimage(filepath+uuidname);
		}
		houseService.update(house);
		return UPDATE;
	}
	
	
	/**
	 * 4. 删除
	 * @return
	 */
	public String delete(){
		house = houseService.findById(house.getHid());
		// 获取文件的实际路径
//		String realPath = this.getRealPath(house.getHimage());
		// 删除实体类
		houseService.delete(house);
		// 删除文件
//		File f = new File(realPath);
//		if(f.exists()){
//			f.delete();
//		}
		return DELETE;
	}
	
	
	/**
	 * 2. 分页查询
	 * @return
	 */
	public String findByPage(){
		/**
		 * 1. 判断条件是否存在
		 * 2. 查询
		 * 3. 压入栈中
		 */
		DetachedCriteria criteria = DetachedCriteria.forClass(House.class);
		String haddress = house.getHaddress();//地区
		if(haddress != null && !haddress.trim().isEmpty()){
			criteria.add(Restrictions.eq("haddress", haddress));
		}
		Integer harea = house.getHarea();//面积
		if(harea != null){
			criteria.add(Restrictions.eq("harea", harea));
		}
		String hshape = house.getHshape();//户型：一室
		if(hshape != null && !hshape.trim().isEmpty()){
			criteria.add(Restrictions.eq("hshape", hshape));
		}
		String subt1=house.getSubt1();//特色
		if(subt1 != null && !subt1.trim().isEmpty()){
			criteria.add(Restrictions.eq("subt1", subt1));
		}
		String subt2=house.getSubt2();//物业
		if(subt2 != null && !subt2.trim().isEmpty()){
			criteria.add(Restrictions.eq("subt2", subt2));
		}
		String hintroduction=house.getHintroduction();//热门标签
		if(hintroduction != null && !hintroduction.trim().isEmpty()){
			criteria.add(Restrictions.eq("hintroduction", hintroduction));
		}
		//面积
		if(area != null && !area.trim().isEmpty()){
			String area1=area.split("-")[0];
			String area2=area.split("-")[1];
			System.out.println(area1);
			Integer minArea=Integer.valueOf(area1);
			Integer maxArea=Integer.valueOf(area2);
			criteria.add(Restrictions.gt("harea", minArea)).add(Restrictions.le("harea", maxArea));
		}
		//价格
		if(price != null && !price.trim().isEmpty()){
			String price1=price.split("-")[0];
			String price2=price.split("-")[1];
			Double minPrice=Double.valueOf(price1);
			Double maxPrice=Double.valueOf(price2);
			criteria.add(Restrictions.gt("hprice", minPrice)).add(Restrictions.le("hprice", maxPrice));
		}
		
	
		
		int pageCode = getPageCode();
		int pageSize = 3;
		PageBean<House> pb = houseService.findByPage(getPageCode(), getPageSize(), criteria);
		setVs("pb", pb);
		setVs("uid", uid);
		System.out.println("111111111111111111"+uid);
		return PAGE;
	}
	
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	public String editUI(){
		house = houseService.findById(house.getHid());
		return "editUI";
	}
	
	
	
}
