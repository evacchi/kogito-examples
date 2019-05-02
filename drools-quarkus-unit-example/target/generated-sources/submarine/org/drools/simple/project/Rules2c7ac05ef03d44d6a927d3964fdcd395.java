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
import org.drools.model.Model;

public class Rules2c7ac05ef03d44d6a927d3964fdcd395 implements Model {

    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtils.getDateFormatMask());

    @Override
    public String getName() {
        return "org.drools.simple.project";
    }

    public static Date string_2_date(String s) {
        return GregorianCalendar.from(LocalDate.parse(s,
                                                      DATE_TIME_FORMATTER).atStartOfDay(ZoneId.systemDefault()))
                                .getTime();
    }

    /**
     * With the following expression ID:
     * $expr$2$: org.submarine.quickstart.Person( name != "Mark" )
     * $expr$3$: org.submarine.quickstart.Person( age > $p1.age )
     * $expr$1$: org.submarine.quickstart.Person( name == "Mark" )
     */
    @Override
    public List<org.drools.model.Rule> getRules() {
        return rules;
    }

    @Override
    public List<org.drools.model.EntryPoint> getEntryPoints() {
        return Collections.emptyList();
    }

    @Override
    public List<org.drools.model.Global> getGlobals() {
        return globals;
    }

    @Override
    public List<org.drools.model.Query> getQueries() {
        return queries;
    }

    @Override
    public List<org.drools.model.TypeMetaData> getTypeMetaDatas() {
        return typeMetaDatas;
    }

    List<org.drools.model.Query> queries = Collections.emptyList();

    List<org.drools.model.Global> globals = Collections.emptyList();

    List<org.drools.model.TypeMetaData> typeMetaDatas = Collections.emptyList();

    public static List<Rule> rulesList = Arrays.asList(Rules2c7ac05ef03d44d6a927d3964fdcd395RuleMethods0.rule_R());

    List<org.drools.model.Rule> rules = rulesList;
}
