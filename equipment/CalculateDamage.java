package equipment;

import character.Character;
import equipment.artifact.Artifact;
import equipment.artifactset.ArtifactSet;

public class CalculateDamage {
    private Character character;
    private ArtifactSet artifactSet;

    public CalculateDamage(Character character, ArtifactSet artifactSet) {
        this.character = character;
        this.artifactSet = artifactSet;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public ArtifactSet getArtifactSet() {
        return artifactSet;
    }

    public void setArtifactSet(ArtifactSet artifactSet) {
        this.artifactSet = artifactSet;
    }

    public double getTotalAtk() {

        double characterBaseAtk = character.getBaseAtk();
        double weaponBaseAtk = character.getWeapon().getMainStat();
        double weaponSubstat = character.getWeapon().getStats().get("atk percentage");

        double sum = 0;

        for (Artifact artifact : character.getArtifacts()) {
            double atkPercentage = artifact.getStats().get("atk percentage");
            double atkFixed = artifact.getStats().get("atk fixed");
            sum = sum + (characterBaseAtk + weaponBaseAtk) *  atkPercentage + atkFixed;
        }

        sum = sum + (characterBaseAtk + weaponBaseAtk) * weaponSubstat;

        return sum + (characterBaseAtk + weaponBaseAtk);
    }


}
