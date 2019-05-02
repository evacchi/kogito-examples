package org.drools.simple.candrink;

import java.util.*;
import org.drools.model.*;
import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import java.time.*;
import java.time.format.*;
import java.text.*;
import org.drools.core.util.*;
import org.submarine.quickstart.Person;
import org.submarine.quickstart.Result;
import static org.drools.simple.candrink.Rulesb9ed8e547f7f4cd7a1422acc46c04acd.*;

public class Rulesb9ed8e547f7f4cd7a1422acc46c04acdRuleMethods0 {

    /**
     * Rule name: R1
     */
    public static org.drools.model.Rule rule_R1() {
        final org.drools.model.Variable<org.submarine.quickstart.Result> var_$r = D.declarationOf(org.submarine.quickstart.Result.class,
                                                                                                  DomainClassesMetadatac82551e79d1e4c55b01d2e88c5166177.org_submarine_quickstart_Result_Metadata_INSTANCE,
                                                                                                  "$r");
        final org.drools.model.Variable<org.submarine.quickstart.Person> var_$p = D.declarationOf(org.submarine.quickstart.Person.class,
                                                                                                  DomainClassesMetadatac82551e79d1e4c55b01d2e88c5166177.org_submarine_quickstart_Person_Metadata_INSTANCE,
                                                                                                  "$p");
        org.drools.model.Rule rule = D.rule("org.drools.simple.candrink",
                                            "R1").build(D.pattern(var_$r),
                                                        D.pattern(var_$p).expr("$expr$4$",
                                                                               (_this) -> _this.getAge() >= 18,
                                                                               D.alphaIndexedBy(int.class,
                                                                                                org.drools.model.Index.ConstraintType.GREATER_OR_EQUAL,
                                                                                                1,
                                                                                                _this -> _this.getAge(),
                                                                                                18),
                                                                               D.reactOn("age")),
                                                        D.on(var_$p,
                                                             var_$r).execute(($p, $r) -> {
                                                            $r.setValue($p.getName() + " MIGHT drink");
                                                        }));
        return rule;
    }

    /**
     * Rule name: R2
     */
    public static org.drools.model.Rule rule_R2() {
        final org.drools.model.Variable<org.submarine.quickstart.Result> var_$r = D.declarationOf(org.submarine.quickstart.Result.class,
                                                                                                  DomainClassesMetadatac82551e79d1e4c55b01d2e88c5166177.org_submarine_quickstart_Result_Metadata_INSTANCE,
                                                                                                  "$r");
        final org.drools.model.Variable<org.submarine.quickstart.Person> var_$p = D.declarationOf(org.submarine.quickstart.Person.class,
                                                                                                  DomainClassesMetadatac82551e79d1e4c55b01d2e88c5166177.org_submarine_quickstart_Person_Metadata_INSTANCE,
                                                                                                  "$p");
        org.drools.model.Rule rule = D.rule("org.drools.simple.candrink",
                                            "R2").build(D.pattern(var_$r),
                                                        D.pattern(var_$p).expr("$expr$5$",
                                                                               (_this) -> _this.getAge() < 18,
                                                                               D.alphaIndexedBy(int.class,
                                                                                                org.drools.model.Index.ConstraintType.LESS_THAN,
                                                                                                1,
                                                                                                _this -> _this.getAge(),
                                                                                                18),
                                                                               D.reactOn("age")),
                                                        D.on(var_$p,
                                                             var_$r).execute(($p, $r) -> {
                                                            $r.setValue($p.getName() + " can NOT drink");
                                                        }));
        return rule;
    }
}
