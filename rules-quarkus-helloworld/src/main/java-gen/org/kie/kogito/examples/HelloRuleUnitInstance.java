package org.kie.kogito.examples;

public class HelloRuleUnitInstance extends org.kie.kogito.rules.units.AbstractRuleUnitInstance<org.kie.kogito.examples.Hello> {

    public HelloRuleUnitInstance(org.kie.kogito.rules.RuleUnit<org.kie.kogito.examples.Hello> unit, org.kie.kogito.examples.Hello value, org.kie.api.runtime.KieSession session) {
        super(unit, value, session);
    }

    @Override()
    protected void bind(org.kie.api.runtime.KieSession runtime, org.kie.kogito.examples.Hello value) {
        value.getStrings().subscribe(new org.kie.kogito.rules.units.EntryPointDataProcessor(runtime.getEntryPoint("strings")));
        runtime.setGlobal("strings", value.getStrings());
    }

    @Override()
    protected <Q> org.kie.kogito.rules.RuleUnitQuery<Q> createRuleUnitQuery(Class<? extends org.kie.kogito.rules.RuleUnitQuery<Q>> query) {
        if (HelloQueryHello.class.equals(query))
            return (org.kie.kogito.rules.RuleUnitQuery<Q>) new HelloQueryHello(this);
        throw new IllegalArgumentException("Unknown query: " + query.getCanonicalName());
    }
}
