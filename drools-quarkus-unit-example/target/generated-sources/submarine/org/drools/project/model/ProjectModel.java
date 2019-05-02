package org.drools.project.model;

import org.drools.model.Model;
import org.kie.api.builder.ReleaseId;
import org.drools.compiler.kproject.ReleaseIdImpl;

public class ProjectModel implements org.drools.modelcompiler.CanonicalKieModuleModel {

    @Override
    public String getVersion() {
        return "8.0.0-SNAPSHOT";
    }

    @Override
    public java.util.List<Model> getModels() {
        return java.util.Arrays.asList(new org.drools.simple.project.Rules2c7ac05ef03d44d6a927d3964fdcd395(), new org.drools.simple.candrink.Rulesb9ed8e547f7f4cd7a1422acc46c04acd());
    }

    @Override
    public ReleaseId getReleaseId() {
        return new ReleaseIdImpl("org.submarine", "drools-quarkus-unit-example", "8.0.0-SNAPSHOT");
    }

@Override()
public org.kie.api.builder.model.KieModuleModel getKieModuleModel() {
    org.kie.api.builder.model.KieModuleModel kModuleModel = org.kie.api.KieServices.get().newKieModuleModel();
    org.kie.api.builder.model.KieBaseModel kieBaseModel_simpleKB = kModuleModel.newKieBaseModel("simpleKB");
    kieBaseModel_simpleKB.setEventProcessingMode(org.kie.api.conf.EventProcessingOption.CLOUD);
    kieBaseModel_simpleKB.addPackage("org.drools.simple.project");
    org.kie.api.builder.model.KieSessionModel kieSessionModel_simpleKS = kieBaseModel_simpleKB.newKieSessionModel("simpleKS");
    kieSessionModel_simpleKS.setDefault(true);
    kieSessionModel_simpleKS.setType(org.kie.api.builder.model.KieSessionModel.KieSessionType.STATEFUL);
    kieSessionModel_simpleKS.setClockType(org.kie.api.runtime.conf.ClockTypeOption.get("realtime"));
    org.kie.api.builder.model.KieBaseModel kieBaseModel_canDrinkKB = kModuleModel.newKieBaseModel("canDrinkKB");
    kieBaseModel_canDrinkKB.setEventProcessingMode(org.kie.api.conf.EventProcessingOption.CLOUD);
    kieBaseModel_canDrinkKB.addPackage("org.drools.simple.candrink");
    org.kie.api.builder.model.KieSessionModel kieSessionModel_canDrinkKS = kieBaseModel_canDrinkKB.newKieSessionModel("canDrinkKS");
    kieSessionModel_canDrinkKS.setType(org.kie.api.builder.model.KieSessionModel.KieSessionType.STATEFUL);
    kieSessionModel_canDrinkKS.setClockType(org.kie.api.runtime.conf.ClockTypeOption.get("realtime"));
    return kModuleModel;
}
}