package org.kie.kogito.examples;

import java.util.*;
import org.drools.model.*;
import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import java.time.*;
import java.time.format.*;
import java.text.*;
import org.drools.core.util.*;
import static org.kie.kogito.examples.Rules471B42E068A21F8D5BEF529A54AE3B27.*;
import org.drools.model.Query;

public class Rules471B42E068A21F8D5BEF529A54AE3B27_Hello extends Rules471B42E068A21F8D5BEF529A54AE3B27 {

    @Override
    public String getName() {
        return super.getName() + ".Hello";
    }

    @Override
    public String getPackageName() {
        return super.getName();
    }

    /**
     * With the following expression ID:
     * org.drools.modelcompiler.builder.generator.DRLIdGenerator@5e80d5
     */
    @Override
    public java.util.List<org.drools.model.Rule> getRules() {
        return rules;
    }

    public java.util.List<Rule> getRulesList() {
        return Arrays.asList(Rules471B42E068A21F8D5BEF529A54AE3B27_HelloRuleMethods0.rule_helloWorld());
    }

    java.util.List<org.drools.model.Rule> rules = getRulesList();

    final Query query_hello = query_hello();

    @Override
    public java.util.List<org.drools.model.Query> getQueries() {
        return queries;
    }

    private org.drools.model.Query query_hello() {
        final org.drools.model.Variable<java.lang.String> var_$s = D.declarationOf(java.lang.String.class,
                                                                                   DomainClassesMetadata471B42E068A21F8D5BEF529A54AE3B27.java_lang_String_Metadata_INSTANCE,
                                                                                   "$s",
                                                                                   D.entryPoint("strings"));
        org.drools.model.Query hello_build = queryDef_hello.build(D.pattern(var_$s,
                                                                            D.entryPoint("strings")));
        return hello_build;
    }

    java.util.List<org.drools.model.Query> queries = new ArrayList<>();

    {
        queries.add(query_hello);
    }
}
