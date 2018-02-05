package action;

import java.util.List;

import bean.SalesDataPageBean;
import entity.SalesData;
import service.PageDao;
import service.SalesDataDao;
import service.impl.PageDaoImpl;
import service.impl.SalesDataDaoImpl;

//销项数据Action类
public class SalesDataAction extends SuperAction {
	private static final long serialVersionUID =1L;
	//查询所有销项数据的动作
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
		SalesDataPageBean pageBean = pdao.getSalesDateAllPageBean(12, page);
        request.setAttribute("spageBean", pageBean);
        return "salesdataquery_success";
	}
	
	public String queryByMonth(){
		int month = Integer.parseInt(request.getParameter("month"));
		SalesDataPageBean pageBean = pdao.getSalesDateByMonthPageBean(month,8, page);
        request.setAttribute("spageBean", pageBean);
        return "salesdataqueryByMonth_success";
	}
	
	public String queryByItem(){
		String item = request.getParameter("item");
		SalesDataPageBean pageBean = pdao.getSalesDateByItemPageBean(item,8, page);
        request.setAttribute("spageBean", pageBean);
        return "salesdataqueryByItem_success";
	}
	
	//删除销项数据动作
	public String delete(){
		SalesDataDao sdao = new SalesDataDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteSalesData(sid);//调用删除方法
		return "deletesalesdata_success";
	}
	
	//添加销项数据动作
	public String add(){
		SalesData s = new SalesData();
		s.setItem(request.getParameter("item"));
		s.setMoney(Double.valueOf(request.getParameter("money")));
		s.setMonth(Integer.parseInt(request.getParameter("month")));
		SalesDataDao sdao = new SalesDataDaoImpl();
		sdao.addSalesData(s);
		return "addsalesdata_success";
	}
	
	//修改该销项数据动作
	public String modify(){
		//获得传递过来的学生编号
		String sid = request.getParameter("sid");
		SalesDataDao sdao = new SalesDataDaoImpl();
		SalesData s = sdao.querySalesDataBySid(sid);
		//保存在会话中
		session.setAttribute("modify_salesdata", s);
		return "modifysalesdata_success";
	}
	
	//保存修改后的销项数据动作
	public String save(){
		SalesData s = new SalesData();
		s.setSid(request.getParameter("sid"));
		s.setItem(request.getParameter("item"));
		s.setMoney(Double.valueOf(request.getParameter("money")));
		s.setMonth(Integer.parseInt(request.getParameter("month")));
		SalesDataDao sdao = new SalesDataDaoImpl();
		sdao.updateSalesData(s);
		return "savesalesdata_success";
	}
	//统计销项发票数据动作
	public String statistics(){
		SalesDataDao sdao = new SalesDataDaoImpl();
		List<SalesData> list = sdao.statisticsSalesData();
		//放进Session中
		if(list!=null&&list.size()>0){
			session.setAttribute("statisticsSalesdata_list", list);
		}
		return "statisticsSalesData_success";
	}
}
