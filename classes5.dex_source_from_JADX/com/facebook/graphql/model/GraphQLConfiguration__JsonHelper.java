package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: isPhotoContainer */
public final class GraphQLConfiguration__JsonHelper {
    public static GraphQLConfiguration m6859a(JsonParser jsonParser) {
        GraphQLConfiguration graphQLConfiguration = new GraphQLConfiguration();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            boolean z;
            if ("can_override".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLConfiguration.f3491d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLConfiguration, "can_override", graphQLConfiguration.a_, 0, false);
            } else if ("description".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLConfiguration.f3492e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLConfiguration, "description", graphQLConfiguration.a_, 1, false);
            } else if ("enabled".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLConfiguration.f3493f = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLConfiguration, "enabled", graphQLConfiguration.a_, 2, false);
            } else if ("hash_string".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLConfiguration.f3494g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLConfiguration, "hash_string", graphQLConfiguration.a_, 3, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLConfiguration.f3495h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLConfiguration, "name", graphQLConfiguration.a_, 4, false);
            } else if ("override_details".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLConfiguration.f3496i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLConfiguration, "override_details", graphQLConfiguration.a_, 5, false);
            } else if ("time_loaded".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLConfiguration.f3497j = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLConfiguration, "time_loaded", graphQLConfiguration.a_, 6, false);
            }
            jsonParser.f();
        }
        return graphQLConfiguration;
    }

    public static void m6860a(JsonGenerator jsonGenerator, GraphQLConfiguration graphQLConfiguration, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("can_override", graphQLConfiguration.m6850a());
        if (graphQLConfiguration.m6851j() != null) {
            jsonGenerator.a("description", graphQLConfiguration.m6851j());
        }
        jsonGenerator.a("enabled", graphQLConfiguration.m6852k());
        if (graphQLConfiguration.m6853l() != null) {
            jsonGenerator.a("hash_string", graphQLConfiguration.m6853l());
        }
        if (graphQLConfiguration.m6854m() != null) {
            jsonGenerator.a("name", graphQLConfiguration.m6854m());
        }
        if (graphQLConfiguration.m6855n() != null) {
            jsonGenerator.a("override_details", graphQLConfiguration.m6855n());
        }
        jsonGenerator.a("time_loaded", graphQLConfiguration.m6856o());
        if (z) {
            jsonGenerator.g();
        }
    }
}
