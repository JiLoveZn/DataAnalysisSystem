package service;

import java.util.List;

import entity.SalesData;

//销项发票数据的业务逻辑口
public interface SalesDataDao {
	//获取数据总量
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql,int month);
	public int getAllRowCount(String hql,String item);
	//查询所有销项数据
	public List<SalesData> queryAllSalesData(String hql, int offset, int pageSize);
	//根据销项数据编号查询销项数据
	public SalesData querySalesDataBySid(String sid);
	//根据销项数据月份查询进项数据
	public List<SalesData> querySalesDataByMonth(int month,String hql, int offset, int pageSize);
	//根据销项数据项目查询进项数据
	public List<SalesData> querySalesDataByItem(String item,String hql, int offset, int pageSize);
	//添加销项数据
	public boolean addSalesData(SalesData e);
	//修改销项数据
	public boolean updateSalesData(SalesData e);
	//删除销项数据
	public boolean deleteSalesData(String sid);
	//统计进项数据
	public List<SalesData> statisticsSalesData();
}
