package calculate;

import character.Character;
import equipment.artifact.Artifact;
import equipment.artifactset.ArtifactSet;

public abstract class Damage {
    private Character character;
    private double enemyResMult;
    private double enemyDefMult;
    private double damageReduction;
    private double skillPercentage;

    public Damage(Character character, double enemyResMult, double enemyDefMult
            , double damageReduction, double skillPercentage) {
        this.character = character;
        this.enemyDefMult = enemyDefMult;
        this.enemyResMult = enemyResMult;
        this.damageReduction = damageReduction;
        this.skillPercentage = skillPercentage;
    }

    public double getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(double damageReduction) {
        this.damageReduction = damageReduction;
    }

    public double getSkillPercentage() {
        return skillPercentage;
    }

    public void setSkillPercentage(double skillPercentage) {
        this.skillPercentage = skillPercentage;
    }

    public double getEnemyResMult() {
        return enemyResMult;
    }

    public void setEnemyResMult(double enemyResMult) {
        this.enemyResMult = enemyResMult;
    }

    public double getEnemyDefMult() {
        return enemyDefMult;
    }

    public void setEnemyDefMult(double enemyDefMult) {
        this.enemyDefMult = enemyDefMult;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public double getTotalAtk() {
        return character.getTotalAtk();
    }

    public double getTotalBonusPercentageDamage() {
        return character.getTotalBonusPercentageDamage();

    }

    public double getTotalCriticalDamage() {
        return character.getTotalCriticalDamage();
    }

    public abstract double calculate(VisitorCalculator visitor);


}
