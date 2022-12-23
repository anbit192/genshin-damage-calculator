package calculate;

import character.Character;
import equipment.artifact.Artifact;
import equipment.artifactset.ArtifactSet;

public abstract class CalculateDamage {
    private Character character;
    private ArtifactSet artifactSet;
    private double enemyResMult;
    private double enemyDefMult;
    private double damageReduction;
    private double skillPercentage;

    public CalculateDamage(Character character, ArtifactSet artifactSet, double enemyResMult, double enemyDefMult
            , double damageReduction, double skillPercentage) {
        this.character = character;
        this.artifactSet = artifactSet;
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

    public ArtifactSet getArtifactSet() {
        return artifactSet;
    }

    public void setArtifactSet(ArtifactSet artifactSet) {
        this.artifactSet = artifactSet;
    }

    public double getTotalAtk() {

        double characterBaseAtk = character.getBaseAtk();
        double weaponBaseAtk = character.getWeapon().getMainStat();
        double weaponAtkPercentage = character.getWeapon().getStats().get("atk percentage");
        double atkFixed = 0;
        double atkPercentage = 0;
        double sum = 0;


        for (Artifact artifact : character.getArtifacts()) {
            atkFixed += artifact.getStats().get("atk fixed");
            atkPercentage += artifact.getStats().get("atk percentage");
        }

        atkPercentage += weaponAtkPercentage;

        sum += (characterBaseAtk + weaponBaseAtk) * (1 + atkPercentage) + atkFixed;


//        for (Artifact artifact : character.getArtifacts()) {
//            double atkPercentage = artifact.getStats().get("atk percentage");
//            double atkFixed = artifact.getStats().get("atk fixed");
//            sum = sum + (characterBaseAtk + weaponBaseAtk) *  atkPercentage + atkFixed;
//        }

//        sum = sum + (characterBaseAtk + weaponBaseAtk) * weaponSubstat;

//        return sum + (characterBaseAtk + weaponBaseAtk);

        return sum;
    }

    public double getTotalBonusPercentageDamage() {

        double characterPercentageBonus = character.getBonusPercentageDamage();
        double weaponBonusPercentage = character.getWeapon().getStats().get("damage bonus");
        double artifactBonusPercentage = 0;
        double artifactBonusPercentageFromSet = artifactSet.getStats().get("damage bonus");

        for (Artifact artifact : character.getArtifacts()) {
            artifactBonusPercentage += artifact.getStats().get("elemental bonus");
        }

        return characterPercentageBonus + weaponBonusPercentage + artifactBonusPercentageFromSet + artifactBonusPercentage;
    }

    public double getTotalCriticalDamage() {
        double criticalDamageFromArtifact = 0;
        double criticalDamageFromCharacter = this.character.getCriticalDamage();
        double criticalDamageFromWeapon = this.character.getWeapon().getStats().get("critical damage");
        double criticalDamageFromArtifactSet = artifactSet.getStats().get("critical damage");

        for (Artifact artifact : this.getCharacter().getArtifacts()) {
            criticalDamageFromArtifact += artifact.getStats().get("critical damage");
        }

        return criticalDamageFromArtifact + criticalDamageFromArtifactSet + criticalDamageFromCharacter + criticalDamageFromWeapon;
    }

    public abstract double calculate(VisitorCalculator visitor);


}
