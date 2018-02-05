package service;

import java.util.List;

import entity.SalesData;

//���Ʊ���ݵ�ҵ���߼���
public interface SalesDataDao {
	//��ȡ��������
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql,int month);
	public int getAllRowCount(String hql,String item);
	//��ѯ������������
	public List<SalesData> queryAllSalesData(String hql, int offset, int pageSize);
	//�����������ݱ�Ų�ѯ��������
	public SalesData querySalesDataBySid(String sid);
	//�������������·ݲ�ѯ��������
	public List<SalesData> querySalesDataByMonth(int month,String hql, int offset, int pageSize);
	//��������������Ŀ��ѯ��������
	public List<SalesData> querySalesDataByItem(String item,String hql, int offset, int pageSize);
	//�����������
	public boolean addSalesData(SalesData e);
	//�޸���������
	public boolean updateSalesData(SalesData e);
	//ɾ����������
	public boolean deleteSalesData(String sid);
	//ͳ�ƽ�������
	public List<SalesData> statisticsSalesData();
}
