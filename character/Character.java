package character;

import equipment.artifact.Artifact;
import equipment.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private double hp;
    private double baseAtk;
    private double defense;
    private double elementalMastery;
    private double criticalRate;
    private double criticalDamage;
    private double recharge;
    private List<Artifact> artifacts;
    private Weapon weapon;

    private double bonusPercentageDamage;

    public Character(double hp, double baseAtk, double defense, double elementalMastery, double criticalRate, double criticalDamage, double recharge) {
        this.artifacts = new ArrayList<>();
        this.hp = hp;
        this.baseAtk = baseAtk;
        this.defense = defense;
        this.elementalMastery = elementalMastery;
        this.criticalRate = criticalRate;
        this.criticalDamage = criticalDamage;
        this.recharge = recharge;
    }

    public Character() {
        this.artifacts = new ArrayList<>();
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
}
