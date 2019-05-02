package org.submarine;

import org.kie.submarine.Config;

@javax.inject.Singleton()
public class Application {

    public Config config() {
        return config;
    }

    public static org.kie.submarine.Config config = new org.kie.submarine.StaticConfig(null);

    public org.drools.simple.candrink.PeopleRuleUnit createPeopleRuleUnit() {
        return new org.drools.simple.candrink.PeopleRuleUnit();
    }
}
