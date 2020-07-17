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

public class Rules471B42E068A21F8D5BEF529A54AE3B27_HelloRuleMethods0 {

    /**
     * Rule name: helloWorld
     */
    public static org.drools.model.Rule rule_helloWorld() {
        final org.drools.model.Variable<java.lang.String> var_$s = D.declarationOf(java.lang.String.class,
                                                                                   DomainClassesMetadata471B42E068A21F8D5BEF529A54AE3B27.java_lang_String_Metadata_INSTANCE,
                                                                                   "$s",
                                                                                   D.entryPoint("strings"));
        org.drools.model.Rule rule = D.rule("org.kie.kogito.examples",
                                            "helloWorld").unit(org.kie.kogito.examples.Hello.class)
                                                         .build(D.pattern(var_$s).expr("B7CAA03EC808C9E791FCB5A37669D56E",
                                                                                       (java.lang.String _this) -> org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this,
                                                                                                                                                                                  "hello")),
                                                                D.on(var_strings).execute((org.kie.kogito.rules.DataStore strings) -> {
                                                                    {
                                                                        strings.add("world");
                                                                    }
                                                                }));
        return rule;
    }
}
