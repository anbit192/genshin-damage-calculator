package calculate;

public class VisitorDamage implements VisitorCalculator {
    @Override
    public double visit(CalculateRawDamage calculateRawDamage) {

        return calculateRawDamage.getTotalAtk() * (1 + calculateRawDamage.getTotalBonusPercentageDamage() - calculateRawDamage.getDamageReduction()) *
                (1 + calculateRawDamage.getTotalCriticalDamage()) * calculateRawDamage.getSkillPercentage() *
                (1 - calculateRawDamage.getEnemyDefMult()) * (1 - calculateRawDamage.getEnemyResMult());
    }

    @Override
    public double visit(CalculateReactionDamage calculateReactionDamage) {
        return 0.0;
    }
}
