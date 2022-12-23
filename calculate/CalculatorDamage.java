package calculate;

public class CalculatorDamage implements VisitorCalculator {
    @Override
    public double visit(RawDamage calculateRawDamage) {

        return calculateRawDamage.getTotalAtk() * (1 + calculateRawDamage.getTotalBonusPercentageDamage() - calculateRawDamage.getDamageReduction()) *
                (1 + calculateRawDamage.getTotalCriticalDamage()) * calculateRawDamage.getSkillPercentage() *
                (1 - calculateRawDamage.getEnemyDefMult()) * (1 - calculateRawDamage.getEnemyResMult());
    }

    @Override
    public double visit(ReactionDamage calculateReactionDamage) {
        return 0.0;
    }
}
