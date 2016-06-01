package skoczny.jedynak.poradnik.dataview;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Rotation;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Map;

/**
 * Created by Damian on 2016-01-11.
 */
public class ChartDrawer {
    public static String createPieChartImageURIFromData(Map<String, Double> categories, String tytul, boolean is3D,boolean legend) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry : categories.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart chart;
        if (is3D) {
            chart = ChartFactory.createPieChart3D(
                    tytul,
                    dataset,
                    legend,
                    false,
                    false);

            final PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(200);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            plot.setNoDataMessage("No data to display");
        } else {
            chart = ChartFactory.createPieChart(
                    tytul,
                    dataset,
                    legend,
                    false,
                    false);
        }

        int width = 620;
        int height = 430;

        return getImageUri(chart, width, height);
    }

    private static String getImageUri(JFreeChart chart, int width, int height) {
        BufferedImage bufferedImage = chart.createBufferedImage(width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] imageInByte = baos.toByteArray();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return "data:image/png;base64," + base64Encoder.encode(imageInByte);
    }

    public static String createBarChartImageURIFromData(Map<String, Double> categories, String tytul, String podTytulX, String podTytulY) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : categories.entrySet()) {
            dataset.addValue(entry.getValue(), "", entry.getKey());
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                tytul,
                podTytulX, podTytulY,
                dataset, PlotOrientation.VERTICAL,
                false, false, false);

        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setVisible(false);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.15);

        CategoryItemRenderer renderer = plot.getRenderer();
        CategoryItemLabelGenerator generator
                = new StandardCategoryItemLabelGenerator("{1}",
                NumberFormat.getInstance());
        renderer.setItemLabelGenerator(generator);
        renderer.setItemLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        renderer.setItemLabelsVisible(true);
        renderer.setPositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER,
                - Math.PI / 2));

        int width = 1900;
        int height = 380;

        return getImageUri(barChart, width, height);
    }

    public static String createLineChartImageURIFromData(Map<String, Double> categories, String tytul, String podTytulX, String podTytulY) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Double> entry : categories.entrySet()) {
            dataset.addValue(entry.getValue(), "", entry.getKey());
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                tytul, podTytulX,
                podTytulY,
                dataset, PlotOrientation.VERTICAL,
                false, false, false);

        int width = 620;
        int height = 430;

        return getImageUri(lineChartObject, width, height);
    }
}