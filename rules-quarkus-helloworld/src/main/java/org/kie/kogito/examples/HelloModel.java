package org.kie.kogito.examples;

import java.util.List;

public class HelloModel {

    List<String> strings;

    public HelloModel() {
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public List<String> getStrings() {
        return strings;
    }
}
