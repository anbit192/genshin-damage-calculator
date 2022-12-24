package calculate;

import character.Character;
import equipment.artifactset.ArtifactSet;

public class RawDamage extends Damage {
    public RawDamage(Character character, double enemyResMult, double enemyDefMult,
                     double damageReduction, double skilldamage) {
        super(character, enemyResMult, enemyDefMult, damageReduction, skilldamage);
    }

    @Override
    public double calculate(VisitorCalculator visitor) {
        return visitor.visit(this);
    }
}
