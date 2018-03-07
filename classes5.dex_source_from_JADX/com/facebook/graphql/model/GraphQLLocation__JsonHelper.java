package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fb_log_net_access */
public final class GraphQLLocation__JsonHelper {
    public static GraphQLLocation m8965a(JsonParser jsonParser) {
        GraphQLLocation graphQLLocation = new GraphQLLocation();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            double d;
            if ("latitude".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLLocation.d = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLLocation, "latitude", graphQLLocation.a_, 0, false);
            } else if ("longitude".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLLocation.e = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLLocation, "longitude", graphQLLocation.a_, 1, false);
            } else if ("timezone".equals(i)) {
                String o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLLocation.f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLLocation, "timezone", graphQLLocation.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLLocation;
    }

    public static void m8966a(JsonGenerator jsonGenerator, GraphQLLocation graphQLLocation, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("latitude", graphQLLocation.a());
        jsonGenerator.a("longitude", graphQLLocation.b());
        if (graphQLLocation.j() != null) {
            jsonGenerator.a("timezone", graphQLLocation.j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
