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
    	//创建主题样式    
    	StandardChartTheme standardChartTheme=new StandardChartTheme("CN");    
    	//设置标题字体    
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));    
        //设置图例的字体    
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,12));    
        //设置轴向的字体    
        standardChartTheme.setLargeFont(new Font("宋书",Font.ITALIC,8));    
        //应用主题样式    
        ChartFactory.setChartTheme(standardChartTheme);  
             
        chart = ChartFactory.createBarChart3D("进项发票数据统计分析图", "月份",  
        "金额",getDataSet(), PlotOrientation.VERTICAL,true,false,false); 
        CategoryPlot plot = chart.getCategoryPlot();  
        //设置网格背景颜色  
        plot.setBackgroundPaint(Color.white);  
        //设置网格竖线颜色  
        plot.setDomainGridlinePaint(Color.pink);  
        //设置网格横线颜色  
        plot.setRangeGridlinePaint(Color.pink);  
        //显示每个柱的数值，并修改该数值的字体属性  
  
        BarRenderer3D renderer = new BarRenderer3D();  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true);  
        //默认的数字显示在柱子中，通过如下两句可调整数字的显示  
        //注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题  
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
        	//data.setValue((Number) its[0], "地址1", "地址1");
        	//data.setValue((Number) results[1][1], "地址2", "地址2");
        	//data.setValue((Number) results[1][2], "地址3", "地址3");
        	//data.setValue((Number) results[1][3], "学校", "学校");
        	
        //}
        data.setValue(4.9, "1月", "1月");
        data.setValue(6.6, "2月", "2月");
        data.setValue(8.1, "3月", "3月");
        data.setValue(6.5, "4月", "4月");
        data.setValue(6.8, "5月", "5月");
        data.setValue(5.8, "6月", "6月");
        data.setValue(6.8, "7月", "7月");
        data.setValue(5.8, "8月", "8月");
        data.setValue(5.6, "9月", "9月");
        data.setValue(7.2, "10月", "10月");
        data.setValue(7.4, "11月", "11月");
        data.setValue(7.8, "12月", "12月");
        return data;  
    }
}