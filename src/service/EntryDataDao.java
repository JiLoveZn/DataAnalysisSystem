package service;

import java.util.List;

import entity.EntryData;

//���Ʊ���ݵ�ҵ���߼���
public interface EntryDataDao {
	//��ȡ��������
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql,int month);
	public int getAllRowCount(String hql,String item);
	//��ѯ���н�������
	public List<EntryData> queryAllEntryData(String hql, int offset, int pageSize);
	//���ݽ������ݱ�Ų�ѯ��������
	public EntryData queryEntryDataByEid(String eid);
	//���ݽ��������·ݲ�ѯ��������
	public List<EntryData> queryEntryDataByMonth(int month,String hql, int offset, int pageSize);
	//���ݽ���������Ŀ��ѯ��������
	public List<EntryData> queryEntryDataByItem(String item,String hql, int offset, int pageSize);
	//��ӽ�������
	public boolean addEntryData(EntryData e);
	//�޸Ľ�������
	public boolean updateEntryData(EntryData e);
	//ɾ����������
	public boolean deleteEntryData(String eid);
	//ͳ�ƽ�������
	public List<EntryData> statisticsEntryData();
	
}
