package action;

import java.util.List;
import bean.EntryDataPageBean;
import entity.EntryData;
import service.EntryDataDao;
import service.PageDao;
import service.impl.EntryDataDaoImpl;
import service.impl.PageDaoImpl;

//进项数据Action类
public class EntryDataAction extends SuperAction {
	private static final long serialVersionUID =1L;
	//查询所有进项数据的动作
	private PageDao pdao = new PageDaoImpl();
    
    private int page;
    
    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }
    
	public String query(){
		EntryDataPageBean pageBean = pdao.getEntryDateAllPageBean(12, page);
        request.setAttribute("pageBean", pageBean);
        return "entrydataquery_success";
	}
	
	public String queryByMonth(){
		int month = Integer.parseInt(request.getParameter("month"));
		EntryDataPageBean pageBean = pdao.getEntryDateByMonthPageBean(month,8, page);
        request.setAttribute("pageBean", pageBean);
        return "queryByMonth_success";
	}
	
	public String queryByItem(){
		String item = request.getParameter("item");
		EntryDataPageBean pageBean = pdao.getEntryDateByItemPageBean(item,8, page);
        request.setAttribute("pageBean", pageBean);
        return "queryByItem_success";
	}
	
	//删除进项数据动作
	public String delete(){
		EntryDataDao edao = new EntryDataDaoImpl();
		String eid = request.getParameter("eid");
		edao.deleteEntryData(eid);//调用删除方法
		return "deleteentrydata_success";
	}
	
	//添加进项数据动作
	public String add(){
		EntryData e = new EntryData();
		e.setItem(request.getParameter("item"));
		e.setMoney(Double.valueOf(request.getParameter("money")));
		e.setMonth(Integer.parseInt(request.getParameter("month")));
		EntryDataDao edao = new EntryDataDaoImpl();
		edao.addEntryData(e);
		return "addentrydata_success";
	}
	
	//修改该进项数据动作
	public String modify(){
		//获得传递过来的学生编号
		String eid = request.getParameter("eid");
		EntryDataDao edao = new EntryDataDaoImpl();
		EntryData e = edao.queryEntryDataByEid(eid);
		//保存在会话中
		session.setAttribute("modify_entrydata", e);
		return "modifyentrydata_success";
	}
	
	//保存修改后的进项数据动作
	public String save(){
		EntryData e = new EntryData();
		e.setEid(request.getParameter("eid"));
		e.setItem(request.getParameter("item"));
		e.setMoney(Double.valueOf(request.getParameter("money")));
		e.setMonth(Integer.parseInt(request.getParameter("month")));
		EntryDataDao edao = new EntryDataDaoImpl();
		edao.updateEntryData(e);
		return "saveentrydata_success";
	}
	//统计进项发票数据动作
	public String statistics(){
		EntryDataDao edao = new EntryDataDaoImpl();
		List<EntryData> list = edao.statisticsEntryData();
		//放进Session中
		if(list!=null&&list.size()>0){
			session.setAttribute("statisticsEntrydata_list", list);
		}
		return "statisticsEntryData_success";
	}
}
