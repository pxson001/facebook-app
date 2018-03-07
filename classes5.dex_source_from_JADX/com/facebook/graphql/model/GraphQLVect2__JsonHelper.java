package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TimelineAppCollectionMembershipStateInfo */
public final class GraphQLVect2__JsonHelper {
    public static GraphQLVect2 m22421a(JsonParser jsonParser) {
        GraphQLVect2 graphQLVect2 = new GraphQLVect2();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            double d = 0.0d;
            if ("x".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    d = jsonParser.G();
                }
                graphQLVect2.d = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLVect2, "x", graphQLVect2.a_, 0, false);
            } else if ("y".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    d = jsonParser.G();
                }
                graphQLVect2.e = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLVect2, "y", graphQLVect2.a_, 1, false);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLVect2;
    }

    public static void m22422a(JsonGenerator jsonGenerator, GraphQLVect2 graphQLVect2, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("x", graphQLVect2.a());
        jsonGenerator.a("y", graphQLVect2.b());
        if (z) {
            jsonGenerator.g();
        }
    }
}
