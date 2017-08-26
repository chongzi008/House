package com.house.web.action;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.house.dao.HouseDao;
import com.house.domain.Comment;
import com.house.domain.House;
import com.house.domain.News;
import com.house.domain.PageBean;
import com.house.service.HouseService;
import com.house.service.NewService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 新闻控制器
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class NewsAction extends BaseAction implements ModelDriven<News>{
  
	private NewService newService;
	
	public void setNewService(NewService newService) {
		this.newService = newService;
	}

private HouseService houseService;

	public void setHouseService(HouseService houseService) {
	this.houseService = houseService;
}

	private News news=new News();
	
	//保存搜索信息
	private String content;
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public News getModel() {
		// TODO Auto-generated method stub
		return news;
	}
     //保存房屋id
	private Long hid;
	public void setHid(Long hid) {
		this.hid = hid;
	}
	
	//保存用户id
	private Long uid;
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String addUI(){
		setVs("hid", hid);
		return "addUI";
	}
	
  
	//保存新闻
	public String save(){
		House house=houseService.findById(hid);
		news.setHouse(house);
		news.setNtime(new Date());
	    newService.save(news);
	    
		return SAVE;
		
	}
	//在房源下删除新闻
	public String delete(){
		newService.delete(news);
		return "deleteByOne";
	}
	//在所有新闻视图下删除
	public String deleteByAll(){
		newService.delete(news);
		return "deleteByAll";
	}
	
		
    //查看房子下的新闻
	public String findByPage(){
		
		/**
		 * 1. 确定房子id
		 * 
		 */
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		criteria.add(Restrictions.sqlRestriction("house_news_id="+hid));
		System.out.println(hid);
		/**
		 * 2. 判断是否带有条件
		 */
		
		int pageCode = getPageCode();
		int pageSize = 3;
		PageBean<News> pb = newService.findByPage(pageCode, pageSize, criteria);
		setVs("pb", pb);

		// 保存房子id，方便进行下一页查询
		setVs("hid",hid);
		setVs("uid", uid);
		
		return PAGE;
	}	
   //查看所有新闻
	public String findByPageAll(){
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		int pageCode = getPageCode();
		int pageSize = 3;
		PageBean<News> pb = newService.findByPage(pageCode, pageSize, criteria);
		setVs("pb", pb);
		return "page_list";
	}
	
	//跳到新闻编辑页面
	public String edit(){
		News newInfo=newService.findById(news.getNid());
		setVs("newInfo", newInfo);
		
		return "editUI";
		
	}
	//更新新闻
	public String update(){
		House house=houseService.findById(hid);
		news.setHouse(house);
		news.setNtime(new Date());
		newService.update(news);
		return UPDATE;
	}
	//查找新闻
	public String findNews(){
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		criteria.add(Restrictions.sqlRestriction("house_news_id="+hid));
		criteria.add(Restrictions.sqlRestriction("ntitle like '"+"%"+content+"%"+"'"));
		System.out.println("sadasd"+hid);
		System.out.println(content);
		/**
		 * 2. 判断是否带有条件
		 */
		
		int pageCode = getPageCode();
		int pageSize = 3;
		PageBean<News> pb = newService.findByPage(pageCode, pageSize, criteria);
		setVs("pb", pb);

		// 保存房子id，方便进行下一页查询
		
		setVs("hid",hid);
		return PAGE;
		
	}
}
