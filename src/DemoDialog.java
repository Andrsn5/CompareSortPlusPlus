import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoDialog extends JDialog {
    private JPanel contentPane;
    private JButton StartExperiment;
    private JTextField maxSizeTF;
    private JPanel chartArea;
    private XYSeriesCollection series = new XYSeriesCollection();

    public DemoDialog() throws CloneNotSupportedException {
        setContentPane(contentPane);
        setModal(true);




        StartExperiment.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int size= 5;

                try {

                    size = Integer.parseInt(maxSizeTF.getText());
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null,
                            "He cannot fill", "Error",
                            JOptionPane.ERROR_MESSAGE);

                    return;
                }

                if (size <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input size", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

               try {


                    ExperimentInfo result = Experiment.experiment(size);
                    Experiment.applyShakeChgLine(result, series.getSeries(0));
                    Experiment.applyBubbleChgLine(result, series.getSeries(1));
                    Experiment.applyShakeCmpLine(result, series.getSeries(2));
                    Experiment.applyBubbleCmpLine(result, series.getSeries(3));




                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Problems occurred in experiment", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });


        ChartPanel panel = new ChartPanel(Main.createChart(series));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.white);

        chartArea.setLayout(new FlowLayout());

        chartArea.add(panel);


    }
}

