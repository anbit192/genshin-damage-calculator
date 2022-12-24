package character;

public class Ganyu extends Character {

    public Ganyu() {
        this.hp = 9796.0;
        this.baseAtk = 334.0;
        this.defense = 630.0;
        this.criticalDamage = 0.884;
    }


    @Override
    public void passive() {
        if (this.useUltimate) {
            this.setBonusPercentageDamage(0.2);
        } else {
            this.setBonusPercentageDamage(0);
        }
    }


}
