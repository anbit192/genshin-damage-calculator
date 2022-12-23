package calculate;

public interface VisitorCalculator {
    double visit(RawDamage calculateRawDamage);
    double visit(ReactionDamage calculateReactionDamage);
}
