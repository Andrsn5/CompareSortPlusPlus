import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        DemoDialog dialog = new DemoDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static JFreeChart createChart(XYSeriesCollection series) {
        var renderer = new XYLineAndShapeRenderer();
        JFreeChart jFreeChart = ChartFactory.createXYLineChart(
                "сравнение и обмен",
                "Размер массива",
                "Количество",
                series
        );
        series.addSeries(new XYSeries("chg_shaker"));
        series.addSeries(new XYSeries("chg_bubble"));
        series.addSeries(new XYSeries("cmp_shaker"));
        series.addSeries(new XYSeries("cmp_bubble"));

        XYPlot plot = jFreeChart.getXYPlot();
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(2, new BasicStroke(1.0f));
        renderer.setSeriesPaint(2, Color.yellow);
        renderer.setSeriesStroke(3, new BasicStroke(1.0f));
        renderer.setSeriesPaint(3, Color.black);
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        return jFreeChart;
    }
}

