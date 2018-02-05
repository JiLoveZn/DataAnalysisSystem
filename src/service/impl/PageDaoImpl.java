package service.impl;

import java.util.List;

import bean.EntryDataPageBean;
import bean.SalesDataPageBean;
import service.EntryDataDao;
import service.PageDao;
import service.SalesDataDao;
import entity.EntryData;
import entity.SalesData;

public class PageDaoImpl implements PageDao{
	private EntryDataDao edao = new EntryDataDaoImpl();
	private SalesDataDao sdao = new SalesDataDaoImpl();
	 /**
     * pageSize为每页显示的记录数
     * page为当前显示的网页
     */
	@Override
    public EntryDataPageBean getEntryDateAllPageBean(int pageSize, int page){
		// TODO Auto-generated method stub
        EntryDataPageBean epageBean = new EntryDataPageBean();
        
        String hql = "from EntryData";
        
        int allRows = edao.getAllRowCount(hql);
        
        int totalPage = epageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = epageBean.getCurPage(page);
        
        int offset = epageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<EntryData> list = edao.queryAllEntryData(hql, offset, pageSize);
        
        epageBean.setList(list);
        epageBean.setAllRows(allRows);
        epageBean.setCurrentPage(currentPage);
        epageBean.setTotalPage(totalPage);
        
        return epageBean;
    }
	@Override
    public EntryDataPageBean getEntryDateByMonthPageBean(int month,int pageSize, int page){
		// TODO Auto-generated method stub
		EntryDataPageBean epageBean = new EntryDataPageBean();
        
        String hql = "from EntryData where month=?";
        
        int allRows = edao.getAllRowCount(hql,month);
        
        int totalPage = epageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = epageBean.getCurPage(page);
        
        int offset = epageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<EntryData> list = edao.queryEntryDataByMonth(month,hql, offset, pageSize);
        
        epageBean.setList(list);
        epageBean.setAllRows(allRows);
        epageBean.setCurrentPage(currentPage);
        epageBean.setTotalPage(totalPage);
        
        return epageBean;
    }
	@Override
    public EntryDataPageBean getEntryDateByItemPageBean(String item,int pageSize, int page){
		// TODO Auto-generated method stub
		EntryDataPageBean epageBean = new EntryDataPageBean();
        
        String hql = "from EntryData where item=?";
        
        int allRows = edao.getAllRowCount(hql,item);
        
        int totalPage = epageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = epageBean.getCurPage(page);
        
        int offset = epageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<EntryData> list = edao.queryEntryDataByItem(item,hql, offset, pageSize);
        
        epageBean.setList(list);
        epageBean.setAllRows(allRows);
        epageBean.setCurrentPage(currentPage);
        epageBean.setTotalPage(totalPage);
        
        return epageBean;
    }

	@Override
	public SalesDataPageBean getSalesDateAllPageBean(int pageSize, int page) {
		// TODO Auto-generated method stub
		SalesDataPageBean spageBean = new SalesDataPageBean();
        
        String hql = "from SalesData";
        
        int allRows = sdao.getAllRowCount(hql);
        
        int totalPage = spageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = spageBean.getCurPage(page);
        
        int offset = spageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<SalesData> list = sdao.queryAllSalesData(hql, offset, pageSize);
        
        spageBean.setList(list);
        spageBean.setAllRows(allRows);
        spageBean.setCurrentPage(currentPage);
        spageBean.setTotalPage(totalPage);
        
        return spageBean;
	}

	@Override
	public SalesDataPageBean getSalesDateByMonthPageBean(int month, int pageSize, int page) {
		// TODO Auto-generated method stub
		SalesDataPageBean spageBean = new SalesDataPageBean();
        
        String hql = "from SalesData where month=?";
        
        int allRows = sdao.getAllRowCount(hql,month);
        
        int totalPage = spageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = spageBean.getCurPage(page);
        
        int offset = spageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<SalesData> list = sdao.querySalesDataByMonth(month, hql, offset, pageSize);
        
        spageBean.setList(list);
        spageBean.setAllRows(allRows);
        spageBean.setCurrentPage(currentPage);
        spageBean.setTotalPage(totalPage);
        
        return spageBean;
	}

	@Override
	public SalesDataPageBean getSalesDateByItemPageBean(String item, int pageSize, int page) {
		// TODO Auto-generated method stub
		SalesDataPageBean spageBean = new SalesDataPageBean();
        
        String hql = "from SalesData where item=?";
        
        int allRows = sdao.getAllRowCount(hql,item);
        
        int totalPage = spageBean.getTotalPages(pageSize, allRows);
        
        int currentPage = spageBean.getCurPage(page);
        
        int offset = spageBean.getCurrentPageOffset(pageSize, currentPage);
        
        List<SalesData> list = sdao.querySalesDataByItem(item, hql, offset, pageSize);
        
        spageBean.setList(list);
        spageBean.setAllRows(allRows);
        spageBean.setCurrentPage(currentPage);
        spageBean.setTotalPage(totalPage);
        
        return spageBean;
	}
}
