package equipment.artifact;

import equipment.Equipment;

public abstract class Artifact extends Equipment {
    private String substat1;
    private String substat2;
    private String substat3;
    private String substat4;

    public Artifact() {
        super();
    }

    public Artifact setSubstat1(String statName, Double value) {
        this.substat1 = statName;
        this.stats.put(statName, value);

        return this;
    }

    public Artifact setSubstat2(String statName, Double value) {
        this.substat2 = statName;
        this.stats.put(statName, value);

        return this;
    }

    public Artifact setSubstat3(String statName, Double value) {
        this.substat3 = statName;
        this.stats.put(statName, value);

        return this;
    }

    public Artifact setSubstat4(String statName, Double value) {
        this.substat4 = statName;
        this.stats.put(statName, value);

        return this;
    }

    public String getSubstat1() {
        return substat1 + this.stats.get(this.substat1);
    }

    public String getSubstat2() {
        return substat2 + this.stats.get(this.substat2);
    }

    public String getSubstat3() {
        return substat3 + this.stats.get(this.substat3);
    }

    public String getSubstat4() {
        return substat4 + this.stats.get(this.substat4);
    }

    @Override
    public String toString() {
        String mainStatName = this.mainStat;
        Double mainStatValue = this.stats.get(mainStatName);

        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("\n").append("* ");
        sb.append(mainStatName.toUpperCase()).append(" : ").append(mainStatValue).append(" *\n")
                .append(substat1).append(" : ").append(stats.get(substat1)).append("\n")
                .append(substat2).append(" : ").append(stats.get(substat2)).append("\n")
                .append(substat3).append(" : ").append(stats.get(substat3)).append("\n")
                .append(substat4).append(" : ").append(stats.get(substat4)).append("\n");
        return sb.toString();

    }

}
