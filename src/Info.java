import org.jfree.data.xy.XYSeries;

public class Info {
    public static XYSeries getBubbleCmpLine(ExperimentInfo info) {
        XYSeries series = new XYSeries("Bubble comparisons amount");
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getBubbleResult(i).getCmpCount());
        }

        return series;
    }
    public static XYSeries getShakerCmpLine(ExperimentInfo info) {
        XYSeries series = new XYSeries("Shaker comparisons amount");
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getShakerResult(i).getCmpCount());
        }

        return series;
    }

}
