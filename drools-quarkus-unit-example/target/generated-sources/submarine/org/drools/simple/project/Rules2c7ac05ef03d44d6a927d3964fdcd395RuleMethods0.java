package org.drools.simple.project;

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
import static org.drools.simple.project.Rules2c7ac05ef03d44d6a927d3964fdcd395.*;

public class Rules2c7ac05ef03d44d6a927d3964fdcd395RuleMethods0 {

    /**
     * Rule name: R
     */
    public static org.drools.model.Rule rule_R() {
        final org.drools.model.Variable<org.submarine.quickstart.Result> var_$r = D.declarationOf(org.submarine.quickstart.Result.class,
                                                                                                  DomainClassesMetadata758333e4dc0c46eab3108acd6ac6f6ff.org_submarine_quickstart_Result_Metadata_INSTANCE,
                                                                                                  "$r");
        final org.drools.model.Variable<org.submarine.quickstart.Person> var_$p1 = D.declarationOf(org.submarine.quickstart.Person.class,
                                                                                                   DomainClassesMetadata758333e4dc0c46eab3108acd6ac6f6ff.org_submarine_quickstart_Person_Metadata_INSTANCE,
                                                                                                   "$p1");
        final org.drools.model.Variable<org.submarine.quickstart.Person> var_$p2 = D.declarationOf(org.submarine.quickstart.Person.class,
                                                                                                   DomainClassesMetadata758333e4dc0c46eab3108acd6ac6f6ff.org_submarine_quickstart_Person_Metadata_INSTANCE,
                                                                                                   "$p2");
        org.drools.model.Rule rule = D.rule("org.drools.simple.project",
                                            "R").build(D.pattern(var_$r),
                                                       D.pattern(var_$p1).expr("$expr$1$",
                                                                               (_this) -> org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getName(),
                                                                                                                                                         "Mark"),
                                                                               D.alphaIndexedBy(java.lang.String.class,
                                                                                                org.drools.model.Index.ConstraintType.EQUAL,
                                                                                                0,
                                                                                                _this -> _this.getName(),
                                                                                                "Mark"),
                                                                               D.reactOn("name")).watch("age"),
                                                       D.pattern(var_$p2).expr("$expr$2$",
                                                                               (_this) -> !org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getName(),
                                                                                                                                                          "Mark"),
                                                                               D.alphaIndexedBy(java.lang.String.class,
                                                                                                org.drools.model.Index.ConstraintType.NOT_EQUAL,
                                                                                                0,
                                                                                                _this -> _this.getName(),
                                                                                                "Mark"),
                                                                               D.reactOn("name")).expr("$expr$3$",
                                                                                                       var_$p1,
                                                                                                       (_this, $p1) -> _this.getAge() > $p1.getAge(),
                                                                                                       D.betaIndexedBy(int.class,
                                                                                                                       org.drools.model.Index.ConstraintType.GREATER_THAN,
                                                                                                                       1,
                                                                                                                       _this -> _this.getAge(),
                                                                                                                       $p1 -> $p1.getAge()),
                                                                                                       D.reactOn("age")),
                                                       D.on(var_$p1,
                                                            var_$p2,
                                                            var_$r).execute(($p1, $p2, $r) -> {
                                                           $r.setValue($p2.getName() + " is older than " + $p1.getName());
                                                       }));
        return rule;
    }
}
