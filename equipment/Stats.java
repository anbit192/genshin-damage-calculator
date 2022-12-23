package equipment;

import java.util.HashMap;
import java.util.Map;

public abstract class Stats {
    protected Map<String, Double> stats;

    public Stats() {
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
        stats.put("elemental bonus", 0.0);
        stats.put("damage bonus", 0.0);
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
