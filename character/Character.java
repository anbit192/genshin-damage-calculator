package character;

import equipment.artifact.Artifact;
import equipment.artifactset.ArtifactSet;
import equipment.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected int level;
    protected double hp;
    protected double baseAtk;
    protected double defense;
    protected double elementalMastery;
    protected double criticalRate;
    protected double criticalDamage;
    protected double recharge;
    protected List<Artifact> artifacts;
    protected Weapon weapon;
    protected double bonusElementalPercentage;
    protected double bonusPercentageDamage;
    protected boolean useSkill;
    protected boolean useUltimate;
    protected ArtifactSet artifactSet;


    public Character(double hp, double baseAtk, double defense, double elementalMastery, double criticalRate, double criticalDamage, double recharge) {
        this.artifacts = new ArrayList<>();
        this.hp = hp;
        this.baseAtk = baseAtk;
        this.defense = defense;
        this.elementalMastery = elementalMastery;
        this.criticalRate = criticalRate;
        this.criticalDamage = criticalDamage;
        this.recharge = recharge;
        this.useSkill = false;
        this.useUltimate = false;
    }


    public Character() {
        this.artifacts = new ArrayList<>();
        this.recharge = 100;
        this.criticalDamage = 0.5;
        this.useSkill = false;
        this.useUltimate = false;
        this.level = 90;
    }

    public double getBonusElementalPercentage() {
        return bonusElementalPercentage;
    }

    public void setBonusElementalPercentage(double bonusElementalPercentage) {
        this.bonusElementalPercentage = bonusElementalPercentage;
    }

    public boolean isUseSkill() {
        return useSkill;
    }

    public boolean isUseUltimate() {
        return useUltimate;
    }

    public double getBonusPercentageDamage() {
        return bonusPercentageDamage;
    }

    public void setBonusPercentageDamage(double bonusPercentageDamage) {
        this.bonusPercentageDamage = bonusPercentageDamage;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public ArtifactSet getArtifactSet() {
        return artifactSet;
    }

    public void setArtifactSet(ArtifactSet artifactSet) {
        this.artifactSet = artifactSet;
    }

    public void getArtifactsInfo() {
        for (Artifact artifact : artifacts) {
            System.out.println(artifact);
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getBaseAtk() {
        return baseAtk;
    }

    public void setBaseAtk(double baseAtk) {
        this.baseAtk = baseAtk;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getElementalMastery() {
        return elementalMastery;
    }

    public void setElementalMastery(double elementalMastery) {
        this.elementalMastery = elementalMastery;
    }

    public double getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(double criticalRate) {
        this.criticalRate = criticalRate;
    }

    public double getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    public double getRecharge() {
        return recharge;
    }

    public void setRecharge(double recharge) {
        this.recharge = recharge;
    }

    public void equipArtifact(Artifact artifact) {
        artifacts.add(artifact);

    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void skillOn() {
        this.useSkill = true;
    }

    public void skillOff() {
        this.useSkill = false;
    }

    public void ultimateOn() {
        this.useUltimate = true;
    }

    public void ultimateOff() {
        this.useUltimate = false;
    }

    public abstract void passive();

    public double getTotalAtk() {

        double characterBaseAtk = this.getBaseAtk();
        double weaponBaseAtk = this.getWeapon().getMainStat();
        double weaponAtkPercentage = this.getWeapon().getStats().get("atk percentage");
        double atkFixed = 0;
        double atkPercentage = 0;
        double sum = 0;


        for (Artifact artifact : this.getArtifacts()) {
            atkFixed += artifact.getStats().get("atk fixed");
            atkPercentage += artifact.getStats().get("atk percentage");
        }

        atkPercentage += weaponAtkPercentage;

        sum += (characterBaseAtk + weaponBaseAtk) * (1 + atkPercentage) + atkFixed;

        return sum;
    }

    public double getTotalBonusPercentageDamage() {

        double characterPercentageBonus = this.getBonusPercentageDamage();
        double characterElementalPercentage = this.getBonusElementalPercentage();
        double weaponBonusPercentage = this.getWeapon().getStats().get("damage bonus");
        double artifactBonusPercentage = 0;
        double artifactBonusPercentageFromSet = artifactSet.getStats().get("damage bonus");

        for (Artifact artifact : this.getArtifacts()) {
            artifactBonusPercentage += artifact.getStats().get("elemental bonus");
        }

        return characterPercentageBonus + weaponBonusPercentage + artifactBonusPercentageFromSet + artifactBonusPercentage +
                characterElementalPercentage;
    }

    public double getTotalCriticalDamage() {
        double criticalDamageFromArtifact = 0;
        double criticalDamageFromCharacter = this.getCriticalDamage();
        double criticalDamageFromWeapon = this.getWeapon().getStats().get("critical damage");
        double criticalDamageFromArtifactSet = artifactSet.getStats().get("critical damage");

        for (Artifact artifact : this.getArtifacts()) {
            criticalDamageFromArtifact += artifact.getStats().get("critical damage");
        }

        return criticalDamageFromArtifact + criticalDamageFromArtifactSet + criticalDamageFromCharacter + criticalDamageFromWeapon;
    }


    @Override
    public String toString() {
        return "Character{" +
                "hp=" + hp +
                ", baseAtk=" + baseAtk +
                ", defense=" + defense +
                ", elementalMastery=" + elementalMastery +
                ", criticalRate=" + criticalRate +
                ", criticalDamage=" + criticalDamage +
                ", recharge=" + recharge +
                ", bonusPercentageDamage=" + bonusPercentageDamage +
                ", useSkill=" + useSkill +
                ", useUltimate=" + useUltimate +
                '}';
    }
}
