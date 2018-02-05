package service;

import java.util.List;

import entity.EntryData;

//进项发票数据的业务逻辑口
public interface EntryDataDao {
	//获取数据总量
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql,int month);
	public int getAllRowCount(String hql,String item);
	//查询所有进项数据
	public List<EntryData> queryAllEntryData(String hql, int offset, int pageSize);
	//根据进项数据编号查询进项数据
	public EntryData queryEntryDataByEid(String eid);
	//根据进项数据月份查询进项数据
	public List<EntryData> queryEntryDataByMonth(int month,String hql, int offset, int pageSize);
	//根据进项数据项目查询进项数据
	public List<EntryData> queryEntryDataByItem(String item,String hql, int offset, int pageSize);
	//添加进项数据
	public boolean addEntryData(EntryData e);
	//修改进项数据
	public boolean updateEntryData(EntryData e);
	//删除进项数据
	public boolean deleteEntryData(String eid);
	//统计进项数据
	public List<EntryData> statisticsEntryData();
	
}
