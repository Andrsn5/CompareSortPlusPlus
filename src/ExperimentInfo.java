public class ExperimentInfo {
    private SortInfo[] bubbleSortResults;
    private SortInfo[] otherSortResults;

    public ExperimentInfo(int size) {
        bubbleSortResults = new SortInfo[size];
        otherSortResults = new SortInfo[size];
    }

    public int getSize() {
        return bubbleSortResults.length;
    }

    public SortInfo getBubbleResult(int index) {
        return bubbleSortResults[index];
    }

    public SortInfo getShakerResult(int index) {
        return otherSortResults[index];
    }

    public void setBubbleSortResult(int index, SortInfo si) throws Exception {
        if (index < 0 || index >= bubbleSortResults.length)
            throw new Exception("Incorrect size");
        bubbleSortResults[index] = si;
    }

    public void setOtherSortResult(int index, SortInfo si) throws Exception {
        if (index < 0 || index >= otherSortResults.length)
            throw new Exception("Incorrect size");
        otherSortResults[index] = si;
    }
}