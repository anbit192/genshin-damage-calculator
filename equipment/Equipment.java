package equipment;

import java.util.HashMap;
import java.util.Map;

public abstract class Equipment {
    protected Map<String, Double> stats;
    protected String mainStat;

    public Equipment() {
        stats = new HashMap<>();
        stats.put("hp percentage", 0.0);
        stats.put("hp fixed", 0.0);
        stats.put("atk percentage", 0.0);
        stats.put("atk fixed", 0.0);
        stats.put("def percentage", 0.0);
        stats.put("def fixed", 0.0);
        stats.put("critical rate", 0.0);
        stats.put("critical damage", 0.0);
        stats.put("recharge", 0.0);
        stats.put("elemental mastery", 0.0);
        stats.put("cryo bonus", 0.0);
        stats.put("pyro bonus", 0.0);
        stats.put("hydro bonus" , 0.0);
        stats.put("electro bonus", 0.0);
        stats.put("geo bonus", 0.0);
        stats.put("dendro bonus", 0.0);
        stats.put("anemo bonus", 0.0);
    }



    public Equipment setMainStat(String mainStatName, Double value) {
        this.mainStat = mainStatName;
        this.stats.put(this.mainStat, value);
        return this;
    }


    public Map<String, Double> getStats() {
        return this.stats;
    }

    public void printAllStats() {
        for (String statName : this.stats.keySet()) {
            System.out.printf("%s : %.3f\n", statName, this.stats.get(statName));
        }
    }


}
