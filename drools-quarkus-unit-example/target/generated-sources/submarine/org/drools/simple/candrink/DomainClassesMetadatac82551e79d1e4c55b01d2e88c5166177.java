package org.drools.simple.candrink;
public class DomainClassesMetadatac82551e79d1e4c55b01d2e88c5166177 {

    public static final org.drools.model.DomainClassMetadata org_submarine_quickstart_Result_Metadata_INSTANCE = new org_submarine_quickstart_Result_Metadata();
    private static class org_submarine_quickstart_Result_Metadata implements org.drools.model.DomainClassMetadata {

        @Override
        public Class<?> getDomainClass() {
            return org.submarine.quickstart.Result.class;
        }

        @Override
        public int getPropertiesSize() {
            return 1;
        }

        @Override
        public int getPropertyIndex( String name ) {
            switch(name) {
                case "value": return 0;
             }
             throw new RuntimeException("Unknown property '" + name + "' for class class class org.submarine.quickstart.Result");
        }
    }

    public static final org.drools.model.DomainClassMetadata org_submarine_quickstart_Person_Metadata_INSTANCE = new org_submarine_quickstart_Person_Metadata();
    private static class org_submarine_quickstart_Person_Metadata implements org.drools.model.DomainClassMetadata {

        @Override
        public Class<?> getDomainClass() {
            return org.submarine.quickstart.Person.class;
        }

        @Override
        public int getPropertiesSize() {
            return 2;
        }

        @Override
        public int getPropertyIndex( String name ) {
            switch(name) {
                case "age": return 0;
                case "name": return 1;
             }
             throw new RuntimeException("Unknown property '" + name + "' for class class class org.submarine.quickstart.Person");
        }
    }

}