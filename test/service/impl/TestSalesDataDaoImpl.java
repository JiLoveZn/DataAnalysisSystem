package service.impl;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import entity.SalesData;
import junit.framework.Assert;
import service.SalesDataDao;

public class TestSalesDataDaoImpl {
	/*@Test
	public void testQueryAllSalesData(){
		SalesDataDao sdao = new SalesDataDaoImpl();
		List<SalesData> list = sdao.queryAllSalesData();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void testGetNewSid(){
		SalesDataDaoImpl sdao = new SalesDataDaoImpl();
		System.out.println(sdao.getNewSid());
	}
	
	@Test
	public void testAddSalesData(){
		SalesData s = new SalesData();
		s.setItem("¹ÞÍ·");
		s.setMoney(3);
		s.setMonth(6);
		SalesDataDao sdao = new SalesDataDaoImpl();
		Assert.assertEquals(true, sdao.addSalesData(s));
	}*/
	
	@Test
	public void testCountSalesData(){
		SalesDataDaoImpl sdao = new SalesDataDaoImpl();
		List<Integer> list = sdao.countSalesData();
		if(list!=null&&list.size()>0){
			System.out.println("²»Îª¿Õ");
			System.out.println(list.size());
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
