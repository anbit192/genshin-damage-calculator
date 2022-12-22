package equipment;

public abstract class Equipment extends Stats{
    protected String mainStat;

    public Equipment() {

    }

    public double getMainStat() {
        return this.stats.get(this.mainStat);
    }

    public void setMainStat(String mainStatName, Double value) {
        this.mainStat = mainStatName;
        this.stats.put(this.mainStat, value);
    }


}
