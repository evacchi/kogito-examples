package org.drools.project.model;

import org.drools.model.Model;
import org.kie.api.KieBase;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.runtime.KieSession;

@javax.enterprise.context.ApplicationScoped
public class ProjectRuntime implements org.drools.modelcompiler.KieRuntimeBuilder {

    private java.util.Map<String, KieBase> kbases = new java.util.HashMap<>();

    public ProjectRuntime() {
        ProjectModel model = new ProjectModel();
        java.util.Map<String, KieBaseModel> kBaseModelMap = model.getKieModuleModel().getKieBaseModels();
        kbases.put("simpleKB", org.drools.modelcompiler.builder.KieBaseBuilder.createKieBaseFromModel( model.getModels(), kBaseModelMap.get( "simpleKB" ) ));
        kbases.put("canDrinkKB", org.drools.modelcompiler.builder.KieBaseBuilder.createKieBaseFromModel( model.getModels(), kBaseModelMap.get( "canDrinkKB" ) ));
    }

    @Override
    public KieSession newKieSession() {
        return newKieSession("simpleKS");
    }

    @Override
    public KieSession newKieSession(String sessionName) {
        return getKieBaseForSession(sessionName).newKieSession(getConfForSession(sessionName), null);
    }

    private KieBase getKieBaseForSession(String sessionName) {
        switch (sessionName) {
            case "canDrinkKS": return kbases.get("canDrinkKB");
            case "simpleKS": return kbases.get("simpleKB");
        }
        return null;
    }

    private org.kie.api.runtime.KieSessionConfiguration getConfForSession(String sessionName) {
        org.drools.core.SessionConfigurationImpl conf = new org.drools.core.SessionConfigurationImpl();
        switch (sessionName) {
            case "canDrinkKS":
{
    conf.setOption(org.kie.api.runtime.conf.ClockTypeOption.get("realtime"));
}                break;
            case "simpleKS":
{
    conf.setOption(org.kie.api.runtime.conf.ClockTypeOption.get("realtime"));
}                break;
        }
        return conf;
    }

}