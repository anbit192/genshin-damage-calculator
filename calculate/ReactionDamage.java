package calculate;

import character.Character;
import equipment.artifactset.ArtifactSet;

public class ReactionDamage extends Damage{
    public ReactionDamage(Character character, ArtifactSet artifactSet, double enemyResMult, double enemyDefMult, double damageReduction, double skillPercentage) {
        super(character, artifactSet, enemyResMult, enemyDefMult, damageReduction, skillPercentage);
    }

    @Override
    public double calculate(VisitorCalculator visitor) {
        return 0;
    }
}
