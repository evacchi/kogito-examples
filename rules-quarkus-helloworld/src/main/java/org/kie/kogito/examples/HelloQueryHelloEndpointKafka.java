package org.kie.kogito.examples;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import org.kie.kogito.rules.DataStore;
import org.kie.kogito.rules.units.AbstractRuleUnitInstance;

@RequestScoped
public class HelloQueryHelloEndpointKafka {
    private static final Logger LOG = Logger.getLogger(HelloQueryHelloEndpointKafka.class);

    {
        LOG.info("Initializing HelloQueryHelloEndpointKafka.");
    }

    private ObjectMapper json = new ObjectMapper();

    @Inject
    Instance<AbstractRuleUnitInstance<Hello>> ruleUnitInstanceProvider;

    @Inject
    @Channel("responses")
    Emitter<String> emitter;

    @Incoming("greetings")
    public void executeQuery(String payload) throws JsonProcessingException {
        HelloModel unitDTO = json.readValue(payload, HelloModel.class);
        AbstractRuleUnitInstance<Hello> ruleUnitInstance = ruleUnitInstanceProvider.get();

        DataStore<String> strings = ruleUnitInstance.workingMemory().getStrings();
        unitDTO.getStrings().forEach(strings::add);

        ruleUnitInstance.fire();

        List<String> results = ruleUnitInstance.executeQuery(HelloQueryHello.class);
        results.forEach(emitter::send);
    }
}
