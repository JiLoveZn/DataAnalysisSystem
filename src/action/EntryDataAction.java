package action;

import java.util.List;
import bean.EntryDataPageBean;
import entity.EntryData;
import service.EntryDataDao;
import service.PageDao;
import service.impl.EntryDataDaoImpl;
import service.impl.PageDaoImpl;

//��������Action��
public class EntryDataAction extends SuperAction {
	private static final long serialVersionUID =1L;
	//��ѯ���н������ݵĶ���
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
	
	//ɾ���������ݶ���
	public String delete(){
		EntryDataDao edao = new EntryDataDaoImpl();
		String eid = request.getParameter("eid");
		edao.deleteEntryData(eid);//����ɾ������
		return "deleteentrydata_success";
	}
	
	//��ӽ������ݶ���
	public String add(){
		EntryData e = new EntryData();
		e.setItem(request.getParameter("item"));
		e.setMoney(Double.valueOf(request.getParameter("money")));
		e.setMonth(Integer.parseInt(request.getParameter("month")));
		EntryDataDao edao = new EntryDataDaoImpl();
		edao.addEntryData(e);
		return "addentrydata_success";
	}
	
	//�޸ĸý������ݶ���
	public String modify(){
		//��ô��ݹ�����ѧ�����
		String eid = request.getParameter("eid");
		EntryDataDao edao = new EntryDataDaoImpl();
		EntryData e = edao.queryEntryDataByEid(eid);
		//�����ڻỰ��
		session.setAttribute("modify_entrydata", e);
		return "modifyentrydata_success";
	}
	
	//�����޸ĺ�Ľ������ݶ���
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
	//ͳ�ƽ��Ʊ���ݶ���
	public String statistics(){
		EntryDataDao edao = new EntryDataDaoImpl();
		List<EntryData> list = edao.statisticsEntryData();
		//�Ž�Session��
		if(list!=null&&list.size()>0){
			session.setAttribute("statisticsEntrydata_list", list);
		}
		return "statisticsEntryData_success";
	}
}
