package view;

import model.Histogram;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    private final Histogram histogram;

    public HistogramDisplay(Histogram histogram, String name, String titulo, String tituloX, String tituloY) {
        super(name);
        this.histogram = histogram;
        setContentPane(createPanel(titulo, tituloX, tituloY));
        pack();
     
    }

    public void execute() {
        setVisible(true);
    }

    private JPanel createPanel(String titulo, String tituloX, String tituloY) {
        ChartPanel panel = new ChartPanel(createChart(createDataSet(), titulo, tituloX, tituloY));
        setPreferredSize(new Dimension(500,400));
        return panel;
        
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet, String titulo, String tituloX, String tituloY) {
        JFreeChart chart = ChartFactory.createBarChart3D(titulo, tituloX, tituloY, 
                dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (Object key : this.histogram.keySet()) {
            dataSet.addValue(this.histogram.get(key), "", key.toString());
        }
        /*        
        dataSet.addValue(300, "", "ulpgc.es");
        dataSet.addValue(100, "", "dis.ulpgc.es");
        dataSet.addValue(500, "", "gmail.com");
        */
        return dataSet;
    }

}
