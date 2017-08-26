package com.house.test;


import org.junit.Test;

import com.house.dao.impl.BaseDaoImpl;
import com.house.domain.News;
import com.house.service.NewService;
import com.house.service.impl.NewServiceImpl;
import com.house.web.action.BaseAction;

@SuppressWarnings("all")
public class NewTest extends BaseAction {
	private NewService newService;

	public NewService getNewService() {
		return newService;
	}

	public void setNewService(NewService newService) {
		this.newService = newService;
	}
	private News news;
	
	
	
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Test
   public void save(){
	  news.setNcontent("3123123");
	  
	   newService.save(news);
   }
  
   
	
}
