package org.drools.simple.candrink;

@javax.inject.Singleton()
public class PeopleRuleUnit extends org.kie.submarine.rules.impl.AbstractRuleUnit<org.drools.simple.candrink.People> {

    public org.drools.simple.candrink.PeopleRuleUnitInstance createInstance(org.drools.simple.candrink.People value) {
        return new org.drools.simple.candrink.PeopleRuleUnitInstance(this, value, org.drools.modelcompiler.builder.KieBaseBuilder.createKieBaseFromModel(java.util.Collections.singletonList(new Rulesb9ed8e547f7f4cd7a1422acc46c04acd())).newKieSession());
    }
}
