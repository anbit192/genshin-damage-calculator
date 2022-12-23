package calculate;

public interface VisitorCalculator {
    double visit(CalculateRawDamage calculateRawDamage);
    double visit(CalculateReactionDamage calculateReactionDamage);
}
