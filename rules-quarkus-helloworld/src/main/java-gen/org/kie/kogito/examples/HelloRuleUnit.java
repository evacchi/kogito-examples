package org.kie.kogito.examples;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.RuleEventListenerConfig;
import org.kie.kogito.rules.units.impl.AbstractRuleUnit;

@javax.inject.Singleton()
public class HelloRuleUnit extends AbstractRuleUnit<Hello> {

    public HelloRuleUnit() {
        this(new org.kie.kogito.app.Application());
    }

    @javax.inject.Inject()
    public HelloRuleUnit(org.kie.kogito.Application app) {
        super(app);
    }

    @Produces
    public org.kie.kogito.examples.HelloRuleUnitInstance internalCreateInstance(Hello value) {
        return new org.kie.kogito.examples.HelloRuleUnitInstance(this, value, createLegacySession());
    }

    private KieSession createLegacySession() {
        KieSession ks = app.ruleUnits().ruleRuntimeBuilder().newKieSession(Hello.class);
        ((org.drools.core.impl.StatefulKnowledgeSessionImpl) ks).setApplication(app);
        if (app.config() != null && app.config().rule() != null) {
            RuleEventListenerConfig ruleEventListenerConfig = app.config().rule().ruleEventListeners();
            ruleEventListenerConfig.agendaListeners().forEach(ks::addEventListener);
            ruleEventListenerConfig.ruleRuntimeListeners().forEach(ks::addEventListener);
        }
        return ks;
    }
}
