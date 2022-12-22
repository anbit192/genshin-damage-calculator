package equipment.weapon;

import equipment.Equipment;

public abstract class Weapon extends Equipment {
    private String substat;

    public Weapon(double baseAtk) {
        this.mainStat = "atk fixed";
        this.stats.put("atk fixed", baseAtk);
    }

    public void setSubstat(String statName, Double value) {
        this.stats.put(statName, value);
    }

    public abstract void setWeaponEffect();


}
