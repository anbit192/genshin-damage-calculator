package equipment.artifactset;

import equipment.Stats;

public abstract class ArtifactSet extends Stats {

    public ArtifactSet() {
        setEffectSet();
    }

    public abstract void setEffectSet();
}
