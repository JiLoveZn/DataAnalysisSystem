package action;

import java.util.List;

import bean.SalesDataPageBean;
import entity.SalesData;
import service.PageDao;
import service.SalesDataDao;
import service.impl.PageDaoImpl;
import service.impl.SalesDataDaoImpl;

//��������Action��
public class SalesDataAction extends SuperAction {
	private static final long serialVersionUID =1L;
	//��ѯ�����������ݵĶ���
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
	
	//ɾ���������ݶ���
	public String delete(){
		SalesDataDao sdao = new SalesDataDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteSalesData(sid);//����ɾ������
		return "deletesalesdata_success";
	}
	
	//����������ݶ���
	public String add(){
		SalesData s = new SalesData();
		s.setItem(request.getParameter("item"));
		s.setMoney(Double.valueOf(request.getParameter("money")));
		s.setMonth(Integer.parseInt(request.getParameter("month")));
		SalesDataDao sdao = new SalesDataDaoImpl();
		sdao.addSalesData(s);
		return "addsalesdata_success";
	}
	
	//�޸ĸ��������ݶ���
	public String modify(){
		//��ô��ݹ�����ѧ�����
		String sid = request.getParameter("sid");
		SalesDataDao sdao = new SalesDataDaoImpl();
		SalesData s = sdao.querySalesDataBySid(sid);
		//�����ڻỰ��
		session.setAttribute("modify_salesdata", s);
		return "modifysalesdata_success";
	}
	
	//�����޸ĺ���������ݶ���
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
	//ͳ�����Ʊ���ݶ���
	public String statistics(){
		SalesDataDao sdao = new SalesDataDaoImpl();
		List<SalesData> list = sdao.statisticsSalesData();
		//�Ž�Session��
		if(list!=null&&list.size()>0){
			session.setAttribute("statisticsSalesdata_list", list);
		}
		return "statisticsSalesData_success";
	}
}
