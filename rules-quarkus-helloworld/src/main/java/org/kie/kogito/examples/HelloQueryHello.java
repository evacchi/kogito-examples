package org.kie.kogito.examples;

import java.util.List;
import java.util.Map;
import org.kie.kogito.rules.RuleUnitInstance;
import static java.util.stream.Collectors.toList;

public class HelloQueryHello implements org.kie.kogito.rules.RuleUnitQuery<List<java.lang.String>> {

    private final RuleUnitInstance<org.kie.kogito.examples.Hello> instance;

    public HelloQueryHello(RuleUnitInstance<org.kie.kogito.examples.Hello> instance) {
        this.instance = instance;
    }

    @Override
    public List<java.lang.String> execute() {
        return instance.executeQuery("hello").stream().map(this::toResult).collect(toList());
    }

    private java.lang.String toResult(Map<String, Object> tuple) {
        return (java.lang.String) tuple.get("$s");
    }
}
