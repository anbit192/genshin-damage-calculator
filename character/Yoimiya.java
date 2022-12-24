package character;

public class Yoimiya extends Character {

    private double oldTotalAtk;

    public Yoimiya() {
        this.hp = 10164;
        this.baseAtk = 322;
        this.defense = 614;
        this.criticalRate = 0.192;
    }

    @Override
    public double getTotalAtk() {
        if (this.useSkill) {
            return super.getTotalAtk() * 1.617;
        }

        return super.getTotalAtk();
    }

    @Override
    public void passive() {
        if (this.useSkill) {
            this.setBonusElementalPercentage(0.2);
        } else {
            this.setBonusElementalPercentage(0);
        }
    }
}
