package com.house.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.alibaba.fastjson.JSON;
import com.house.domain.House;
import com.house.domain.NewHouseConditionBean;
import com.house.domain.NewHouseConditionBean.Area;
import com.house.domain.PageBean;
import com.house.domain.NewHouseConditionBean.More;
import com.house.service.HouseService;
import com.house.utils.FastJsonUtil;

public class DataRequestAction extends BaseAction {
	private HouseService houseService;
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	public void getNearData()throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		 ServletOutputStream outputStream = response.getOutputStream();
		String path = request.getSession().getServletContext().getRealPath("assets/zhuhai.json");			
		  BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
	                path));
	   

	        byte[] bys = new byte[1024];
	        int len = 0;
	        while ((len = bis.read(bys)) != -1) {
	        	outputStream.write(bys, 0, len);
	        }


	        bis.close();    	
	        outputStream.close();
      		        
	}
	
	public void getWindowRequestData()throws IOException{
		System.out.println("访问到啦+++++++++++++++++++++++");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String parameter=request.getParameter("condition");
		System.out.println(parameter);
		NewHouseConditionBean bean=JSON.parseObject(parameter, NewHouseConditionBean.class);
		response.reset();
		System.out.println(bean);
		findByPage(bean);
		response.setContentType("text/html;charset=utf-8");
		response.reset();
		 ServletOutputStream outputStream = response.getOutputStream();
		String path = request.getSession().getServletContext().getRealPath("assets/zhuhai.json");			
		  BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
	                path));
	   
	        byte[] bys = new byte[1024];
	        int len = 0;
	        while ((len = bis.read(bys)) != -1) {
	        	outputStream.write(bys, 0, len);
	        }


	        bis.close();    	
	        outputStream.close();
      		        
	}
	
	/** 
     *  
     * @return WebRoot目录的绝对路径 
     */  
    public static String getWebRootAbsolutePath() {  
        String path = null;  
        String folderPath = DataRequestAction.class.getProtectionDomain().getCodeSource()  
                .getLocation().getPath();  
        if (folderPath.indexOf("WEB-INF") > 0) {  
            path = folderPath.substring(0, folderPath  
                    .indexOf("WEB-INF/classes"));  
        }  
        return path;  
    }
  
    public String findByPage(NewHouseConditionBean bean){

		
		String price=bean.getPrice();   			//价格
	    String room=bean.getRoom();					//户型
	    
	 
		/**
		 * 1. 判断条件是否存在
		 * 2. 查询
		 * 3. 压入栈中
		 */
		DetachedCriteria criteria = DetachedCriteria.forClass(House.class);
	
		Area haddress = bean.getArea();//地区
				if(haddress != null){
					String haddressAT=haddress.getQu();
		if(haddressAT != null && !haddressAT.trim().isEmpty()){
			if("不限".equals(haddressAT)||"附近".equals(haddressAT)){
				criteria.add(Restrictions.eq("haddress", "香洲区"));
				criteria.add(Restrictions.eq("haddress", "金湾区"));
				criteria.add(Restrictions.eq("haddress", "斗门区"));
			}else{
			String henFan=haddressAT+"区";
			criteria.add(Restrictions.eq("haddress", henFan));
		}
			}
		}
			
				//搜索价格
			if(price!=null && price.trim().isEmpty()){
					
					String area1=price.split("-")[0];
					String area2=price.split("-")[1];
					Double minPrice=Double.valueOf(area1);
					Double maxPrice=Double.valueOf(area2);
					criteria.add(Restrictions.gt("hprice", minPrice)).add(Restrictions.le("hprice", maxPrice));
						
					
				}
				//搜索户型
				if(room != null && !room.trim().isEmpty()){
					if("五室以上".equals(room)){
					criteria.add(Restrictions.eq("hshape", "五室"));
					}else if("二室".equals(room)){
						criteria.add(Restrictions.eq("hshape", "两室"));
					}
					else if("不限".equals(room)){
						criteria.add(Restrictions.eq("hshape", "一室"));
						criteria.add(Restrictions.eq("hshape", "二室"));
						criteria.add(Restrictions.eq("hshape", "三室"));
						criteria.add(Restrictions.eq("hshape", "四室"));
						criteria.add(Restrictions.eq("hshape", "五室"));
					}
					else
					{
						criteria.add(Restrictions.eq("hshape", room));
					}
					
				}				
		
	
	     More more=bean.getMore();		
		if(more != null){	
			   List<String> feature=bean.getMore().getFeature();//特色
			    List<String> work=bean.getMore().getWork(); //物业
			    List<String> hotTag=bean.getMore().getHottag(); //热门标签
			    List<String> area=bean.getMore().getSize();//面积
			    
				//搜索面积
		if(area!=null && area.size()!=0){
			for (String quar : area) {
				
				if(quar.equals("60以下")){
					
					Integer maxArea=60;
					criteria.add(Restrictions.le("harea", maxArea));

				}else if(quar.equals("200以上")){
					Integer minArea=200;
					criteria.add(Restrictions.gt("harea", minArea));

				}
				else {
				String area1=quar.split("-")[0];
				String area2=quar.split("-")[1];
				Integer minArea=Integer.valueOf(area1);
				Integer maxArea=Integer.valueOf(area2);
				criteria.add(Restrictions.gt("harea", minArea)).add(Restrictions.le("harea", maxArea));
				
			}
				}
		}
		
		
		//搜索特色
		if(feature!=null && feature.size()!=0){
			for (String quar : feature) {
				criteria.add(Restrictions.eq("subt1", quar));
				
			}
		}
		//搜索物业
		if(work!=null && work.size()!=0){
			for (String quar : work) {
				criteria.add(Restrictions.eq("subt2", quar));
				
			}
		}
		//热门标签
		if(hotTag!=null && hotTag.size()!=0){
			for (String quar : hotTag) {
				criteria.add(Restrictions.eq("hintroduction", quar));
				
			}
		}
	
		//价格
		if(price!=null && price.trim().isEmpty()){
			
			if(price.equals("不限")){
				Double minPrice=0.0;
				
				criteria.add(Restrictions.gt("hprice", minPrice));
			}else if(price.equals("优惠楼盘")){
				Double maxPrice=9000.0;
				criteria.add(Restrictions.le("hprice", maxPrice));
				
			}else{
				String area1=price.split("-")[0];
				String area2=price.split("-")[1];
				Double minPrice=Double.valueOf(area1);
				Double maxPrice=Double.valueOf(area2);
				criteria.add(Restrictions.gt("hprice", minPrice)).add(Restrictions.le("hprice", maxPrice));
			}
			
		}
		}
	 List<House> houseList=houseService.houseList(criteria);
	 String jsonList=JSON.toJSONString(houseList);
	 System.out.println(jsonList);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
	 FastJsonUtil.write_json(response, jsonList);
	
//		int pageCode = getPageCode();
//		int pageSize = 3;
//		PageBean<House> pb = houseService.findByPage(getPageCode(), getPageSize(), criteria);
//	
		
		return PAGE;
	}
   
}
