package equipment.weapon.bow;

import equipment.weapon.Weapon;

public class AmosBow extends Bow {

    public AmosBow() {
        super(608);
        this.setSubstat("atk percentage", 0.496);
    }

    @Override
    public void setWeaponEffect() {
        this.stats.put("damage bonus", 0.52);
    }
}
