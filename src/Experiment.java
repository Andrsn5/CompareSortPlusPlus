import org.jfree.data.xy.XYSeries;

import java.util.Arrays;
import java.util.Random;

public class Experiment {
    private static Integer[] generate(int size) {
        Integer[] array = new Integer[size];
        Random r = new Random();
        for (int i = 0; i < size; i++){array[i]=r.nextInt(size)+1;}
        return array;
    }

    public static ExperimentInfo experiment(int maxSize) throws Exception {
        ExperimentInfo ei = new ExperimentInfo(maxSize);
        for (int i = 0; i < maxSize; i++) {
            Integer[] arr = generate(i);
            ei.setBubbleSortResult(i, SortInfo.bubleSortInfo(Arrays.copyOfRange(arr,0,arr.length)));
            ei.setOtherSortResult(i, SortInfo.shakerSortInfo(arr));
        }

        return ei;
    }
    public static Integer[] cloneIntegerArray(Integer[] arr){
        Integer[] arr2 = new Integer[arr.length];
        for (int i =0 ; i< arr.length;i++){
            arr2[i]=arr[i];
        }
        return arr2;
    }

    public static void applyShakeChgLine(ExperimentInfo info, XYSeries series) throws CloneNotSupportedException {
        series.clone();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getShakerResult(i).getchangeCount());
        }
    }
    public static void applyBubbleChgLine(ExperimentInfo info, XYSeries series) throws CloneNotSupportedException {
        series.clone();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getBubbleResult(i).getchangeCount());
        }
    }

    public static void applyShakeCmpLine(ExperimentInfo info, XYSeries series) throws CloneNotSupportedException {
        series.clone();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getShakerResult(i).getCmpCount());
        }
    }
    public static void applyBubbleCmpLine(ExperimentInfo info, XYSeries series) throws CloneNotSupportedException {
        series.clone();
        int size = info.getSize();
        for (int i = 0; i < size; i++) {
            series.add(i, info.getBubbleResult(i).getCmpCount());
        }
    }}
