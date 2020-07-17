package org.kie.kogito.examples;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.kie.kogito.rules.RuleUnit;
import org.kie.kogito.rules.RuleUnitInstance;
import org.kie.kogito.rules.units.AbstractRuleUnitInstance;

import static java.util.stream.Collectors.toList;

@Path("/hello")
public class HelloQueryHelloEndpoint {

    @Inject
    AbstractRuleUnitInstance<Hello> ruleUnitInstance;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<java.lang.String> executeQuery(org.kie.kogito.examples.HelloModel unitDTO) {
        unitDTO.strings.forEach(ruleUnitInstance.workingMemory().getStrings()::add);
        ruleUnitInstance.fire();
        return ruleUnitInstance.executeQuery(HelloQueryHello.class);
    }

}
