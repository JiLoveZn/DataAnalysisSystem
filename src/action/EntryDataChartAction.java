package action;

import java.awt.Color;  
import java.awt.Font;
import java.util.Iterator;
import java.util.List; 
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.StandardChartTheme;  
import org.jfree.chart.axis.AxisLocation;  
import org.jfree.chart.labels.ItemLabelAnchor;  
import org.jfree.chart.labels.ItemLabelPosition;  
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.renderer.category.BarRenderer3D;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.ui.TextAnchor;  
  
import com.opensymphony.xwork2.ActionSupport;

import entity.EntryData;
import service.EntryDataDao;
import service.impl.EntryDataDaoImpl;
  
public class EntryDataChartAction extends ActionSupport {  
   
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;  
      
    public String execute(){  
        return SUCCESS;  
    }  
  
    public JFreeChart getChart() {
    	//����������ʽ    
    	StandardChartTheme standardChartTheme=new StandardChartTheme("CN");    
    	//���ñ�������    
        standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));    
        //����ͼ��������    
        standardChartTheme.setRegularFont(new Font("����",Font.PLAIN,12));    
        //�������������    
        standardChartTheme.setLargeFont(new Font("����",Font.ITALIC,8));    
        //Ӧ��������ʽ    
        ChartFactory.setChartTheme(standardChartTheme);  
             
        chart = ChartFactory.createBarChart3D("���Ʊ����ͳ�Ʒ���ͼ", "�·�",  
        "���",getDataSet(), PlotOrientation.VERTICAL,true,false,false); 
        CategoryPlot plot = chart.getCategoryPlot();  
        //�������񱳾���ɫ  
        plot.setBackgroundPaint(Color.white);  
        //��������������ɫ  
        plot.setDomainGridlinePaint(Color.pink);  
        //�������������ɫ  
        plot.setRangeGridlinePaint(Color.pink);  
        //��ʾÿ��������ֵ�����޸ĸ���ֵ����������  
  
        BarRenderer3D renderer = new BarRenderer3D();  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true);  
        //Ĭ�ϵ�������ʾ�������У�ͨ����������ɵ������ֵ���ʾ  
        //ע�⣺�˾�ܹؼ������޴˾䣬�����ֵ���ʾ�ᱻ���ǣ���������û����ʾ����������  
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));  
        renderer.setItemLabelAnchorOffset(10D);  
        renderer.setItemMargin(0.3);  
        plot.setRenderer(renderer);  
        plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);  
        return chart;  
    }  
   
    private CategoryDataset getDataSet() {  
        EntryDataDao edao = new EntryDataDaoImpl();
		List<EntryData> list = edao.statisticsEntryData();
        DefaultCategoryDataset data =new DefaultCategoryDataset() ;
        Object[] its = list.toArray();
        //Iterator it = list.iterator();
        //while(it.hasNext()){
        	//Object[][] results = (Object[][])it.next();
        	//data.setValue((Number) its[0], "��ַ1", "��ַ1");
        	//data.setValue((Number) results[1][1], "��ַ2", "��ַ2");
        	//data.setValue((Number) results[1][2], "��ַ3", "��ַ3");
        	//data.setValue((Number) results[1][3], "ѧУ", "ѧУ");
        	
        //}
        data.setValue(4.9, "1��", "1��");
        data.setValue(6.6, "2��", "2��");
        data.setValue(8.1, "3��", "3��");
        data.setValue(6.5, "4��", "4��");
        data.setValue(6.8, "5��", "5��");
        data.setValue(5.8, "6��", "6��");
        data.setValue(6.8, "7��", "7��");
        data.setValue(5.8, "8��", "8��");
        data.setValue(5.6, "9��", "9��");
        data.setValue(7.2, "10��", "10��");
        data.setValue(7.4, "11��", "11��");
        data.setValue(7.8, "12��", "12��");
        return data;  
    }
}