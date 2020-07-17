package org.kie.kogito.examples;

import java.util.*;
import org.drools.model.*;
import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import java.time.*;
import java.time.format.*;
import java.text.*;
import org.drools.core.util.*;
import org.drools.model.Model;

public abstract class Rules471B42E068A21F8D5BEF529A54AE3B27 implements Model {

    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DateUtils.getDateFormatMask(),
                                                                                            Locale.ENGLISH);

    @Override
    public String getName() {
        return "org.kie.kogito.examples";
    }

    public static Date string_2_date(String s) {
        return GregorianCalendar.from(LocalDate.parse(s,
                                                      DATE_TIME_FORMATTER).atStartOfDay(ZoneId.systemDefault()))
                                .getTime();
    }

    @Override
    public java.util.List<org.drools.model.EntryPoint> getEntryPoints() {
        return Arrays.asList(D.entryPoint("strings"));
    }

    @Override
    public java.util.List<org.drools.model.Global> getGlobals() {
        return globals;
    }

    @Override
    public java.util.List<org.drools.model.TypeMetaData> getTypeMetaDatas() {
        return typeMetaDatas;
    }

    public static final org.drools.model.Global<org.kie.kogito.rules.DataStore> var_strings = D.globalOf(org.kie.kogito.rules.DataStore.class,
                                                                                                         "org.kie.kogito.examples",
                                                                                                         "strings");

    public static final org.drools.model.Query0Def queryDef_hello = D.query("org.kie.kogito.examples",
                                                                            "hello");

    java.util.List<org.drools.model.Global> globals = new ArrayList<>();

    java.util.List<org.drools.model.TypeMetaData> typeMetaDatas = Collections.emptyList();

    {
        globals.add(var_strings);
    }
}
