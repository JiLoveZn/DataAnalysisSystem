package bean;
import entity.EntryData;
import java.util.List;

public class EntryDataPageBean {
	private List<EntryData> list; //ͨ��hql�����ݿ��ҳ��ѯ������list����
    
    private int allRows; //�ܼ�¼��
    
    private int totalPage; //��ҳ��
    
    private int currentPage; //��ǰҳ

    public List<EntryData> getList()
    {
        return list;
    }

    public void setList(List<EntryData> list)
    {
        this.list = list;
    }

    public int getAllRows()
    {
        return allRows;
    }

    public void setAllRows(int allRows)
    {
        this.allRows = allRows;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }
 
    public int getTotalPages(int pageSize, int allRows)
    {
        int totalPage = (allRows % pageSize == 0)? (allRows / pageSize): (allRows / pageSize) + 1;
        
        return totalPage;
    }
    
    public int getCurrentPageOffset(int pageSize, int currentPage)
    {
        int offset = pageSize * (currentPage - 1);
        
        return offset;
    }
    
    public int getCurPage(int page)
    {
        int currentPage = (page == 0)? 1: page;
        
        return currentPage;
    }
    
}
