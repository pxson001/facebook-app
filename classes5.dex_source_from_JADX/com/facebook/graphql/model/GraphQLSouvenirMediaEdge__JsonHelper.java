package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unsupported safe parcelable field converter class. */
public final class GraphQLSouvenirMediaEdge__JsonHelper {
    public static GraphQLSouvenirMediaEdge m21715a(JsonParser jsonParser) {
        GraphQLSouvenirMediaEdge graphQLSouvenirMediaEdge = new GraphQLSouvenirMediaEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLSouvenirMediaElement graphQLSouvenirMediaElement;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLSouvenirMediaElement = null;
                } else {
                    graphQLSouvenirMediaElement = GraphQLSouvenirMediaElement__JsonHelper.m21748a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLSouvenirMediaEdge.f13034d = graphQLSouvenirMediaElement;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaEdge, "node", graphQLSouvenirMediaEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSouvenirMediaEdge;
    }

    public static void m21716a(JsonGenerator jsonGenerator, GraphQLSouvenirMediaEdge graphQLSouvenirMediaEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSouvenirMediaEdge.m21711a() != null) {
            jsonGenerator.a("node");
            GraphQLSouvenirMediaElement__JsonHelper.m21749a(jsonGenerator, graphQLSouvenirMediaEdge.m21711a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
