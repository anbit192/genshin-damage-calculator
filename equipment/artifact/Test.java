package equipment.artifact;

public class Test {
    public static void main(String[] args) {
        Artifact plume1 = new Plume();
        Artifact sand1 = new Sand();
        Artifact goblet1 = new Goblet();
        Artifact circlet1 = new Circlet();
        Artifact flower1 = new Flower();

        plume1.setSubstat1("critical rate", 0.15).setSubstat2("critical damage", 0.3)
                .setSubstat3("atk percentage", 0.15).setSubstat4("elemental mastery", 50.0);
        flower1.setSubstat1("critical rate" , 0.12).setSubstat2("critical damage", 0.24)
                .setSubstat3("atk percentage", 0.2).setSubstat4("elemental mastery", 30.0);
        sand1.setMainStat("atk percentage", 0.466);
        sand1.setSubstat1("critical rate", 0.078).setSubstat2("critical damage", 0.34)
                .setSubstat3("elemental mastery", 30.0).setSubstat4("atk percentage", 0.07);
        goblet1.setMainStat("cryo bonus", 0.466);
        goblet1.setSubstat1("critical rate", 0.078).setSubstat2("critical damage", 0.34)
                .setSubstat3("elemental mastery", 30.0).setSubstat4("atk percentage", 0.07);
        circlet1.setMainStat("critical damage", 0.616);
        circlet1.setSubstat1("critical rate", 0.078).setSubstat2("critical damage", 0.34)
                .setSubstat3("elemental mastery", 30.0).setSubstat4("atk percentage", 0.07);

        System.out.println(plume1);
        System.out.println(sand1);
        System.out.println(goblet1);
        System.out.println(circlet1);
        System.out.println(flower1);


    }
}
