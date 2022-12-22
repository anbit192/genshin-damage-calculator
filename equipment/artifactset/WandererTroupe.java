package equipment.artifactset;

public class WandererTroupe extends ArtifactSet {

    @Override
    public void setEffectSet() {
        this.stats.put("damage bonus", 0.35);
        this.stats.put("elemental mastery", 80.0);
    }
}
