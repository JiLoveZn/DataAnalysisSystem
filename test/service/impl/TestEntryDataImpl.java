package service.impl;

import java.util.List;

import org.junit.Test;

import entity.EntryData;
import junit.framework.Assert;
import service.EntryDataDao;

public class TestEntryDataImpl {
	/*@Test
	public void testQueryAllEntryData(){
		EntryDataDao edao = new EntryDataDaoImpl();
		List<EntryData> list = edao.queryAllEntryData();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}*/
	
	/*@Test
	public void testGetNewSid(){
		EntryDataDaoImpl edao = new EntryDataDaoImpl();
		System.out.println(edao.getNewEid());
	}
	
	@Test
	public void testAddEntryData(){
		EntryData e = new EntryData();
		e.setItem("ÍÁ¶¹");
		e.setMoney(4);
		e.setMonth(3);
		EntryDataDao edao = new EntryDataDaoImpl();
		Assert.assertEquals(true, edao.addEntryData(e));
	}*/
	@Test
	public void testStatisticEntryData(){
		EntryDataDao edao = new EntryDataDaoImpl();
		List<EntryData> list = edao.statisticsEntryData();
		if(list!=null&&list.size()>0){
			System.out.println("²»Îª¿Õ");
			System.out.println(list.size());
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
