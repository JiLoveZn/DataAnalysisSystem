package service;

import bean.EntryDataPageBean;
import bean.SalesDataPageBean;

public interface PageDao {
	public EntryDataPageBean getEntryDateAllPageBean(int pageSize, int page);
	public EntryDataPageBean getEntryDateByMonthPageBean(int month,int pageSize, int page);
	public EntryDataPageBean getEntryDateByItemPageBean(String item,int pageSize, int page);
	public SalesDataPageBean getSalesDateAllPageBean(int pageSize, int page);
	public SalesDataPageBean getSalesDateByMonthPageBean(int month,int pageSize, int page);
	public SalesDataPageBean getSalesDateByItemPageBean(String item,int pageSize, int page);
}
