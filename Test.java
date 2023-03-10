import calculate.CalculatorDamage;
import calculate.Damage;
import calculate.RawDamage;
import calculate.VisitorCalculator;
import character.Character;
import character.Ganyu;
import equipment.artifact.*;
import equipment.artifactset.WandererTroupe;
import equipment.weapon.bow.AmosBow;

public class Test {
    public static void main(String[] args) {
        Artifact plume1 = new Plume();
        Artifact sand1 = new Sand();
        Artifact goblet1 = new Goblet();
        Artifact circlet1 = new Circlet();
        Artifact flower1 = new Flower();


        plume1.setSubstat1("critical rate", 0.086).setSubstat2("critical damage", 0.155).setSubstat3("atk percentage", 0.058).setSubstat4("def fixed", 44.0);
        flower1.setSubstat1("critical rate", 0.07).setSubstat2("critical damage", 0.21).setSubstat3("atk fixed", 16.0).setSubstat4("def fixed", 44.0);
        sand1.setMainStat("atk percentage", 0.466);
        sand1.setSubstat1("critical rate", 0.097).setSubstat2("critical damage", 0.07).setSubstat3("atk fixed", 49.0).setSubstat4("def percentage", 0.066);
        goblet1.setMainStat("elemental bonus", 0.466);
        goblet1.setSubstat1("critical rate", 0.066).setSubstat2("critical damage", 0.155).setSubstat3("def percentage", 0.109).setSubstat4("hp fixed", 478.0);
        circlet1.setMainStat("critical damage", 0.622);
        circlet1.setSubstat1("critical rate", 0.136).setSubstat2("hp percentage", 0.053).setSubstat3("recharge", 0.117).setSubstat4("def percentage", 0.124);

        System.out.println(plume1);
        System.out.println(sand1);
        System.out.println(goblet1);
        System.out.println(circlet1);
        System.out.println(flower1);

        Character ganyu = new Ganyu();
        ganyu.equipArtifact(plume1);
        ganyu.equipArtifact(flower1);
        ganyu.equipArtifact(goblet1);
        ganyu.equipArtifact(circlet1);
        ganyu.equipArtifact(sand1);

        ganyu.setArtifactSet(new WandererTroupe());

        ganyu.equipWeapon(new AmosBow());
        ganyu.ultimateOn();
        ganyu.ultimateOff();
        ganyu.skillOn();
        ganyu.skillOff();
        ganyu.passive();

        System.out.println(ganyu);

        Damage damage = new RawDamage(ganyu, 0.1, 0.5, 0.0, 3.92);
        System.out.println("Total Atk: " + damage.getTotalAtk());
        System.out.println("Total Percentage Bonus: " + damage.getTotalBonusPercentageDamage());
        VisitorCalculator visitor = new CalculatorDamage();
        System.out.println("Raw Damage: " + damage.calculate(visitor));
    }
}
