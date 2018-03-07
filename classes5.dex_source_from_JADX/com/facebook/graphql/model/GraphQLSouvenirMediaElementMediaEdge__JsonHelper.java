package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unspecified */
public final class GraphQLSouvenirMediaElementMediaEdge__JsonHelper {
    public static GraphQLSouvenirMediaElementMediaEdge m21745a(JsonParser jsonParser) {
        GraphQLSouvenirMediaElementMediaEdge graphQLSouvenirMediaElementMediaEdge = new GraphQLSouvenirMediaElementMediaEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLMedia graphQLMedia;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLMedia = null;
                } else {
                    graphQLMedia = GraphQLMedia__JsonHelper.m9078a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLSouvenirMediaElementMediaEdge.f13041d = graphQLMedia;
                FieldAccessQueryTracker.a(jsonParser, graphQLSouvenirMediaElementMediaEdge, "node", graphQLSouvenirMediaElementMediaEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSouvenirMediaElementMediaEdge;
    }

    public static void m21746a(JsonGenerator jsonGenerator, GraphQLSouvenirMediaElementMediaEdge graphQLSouvenirMediaElementMediaEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSouvenirMediaElementMediaEdge.m21741a() != null) {
            jsonGenerator.a("node");
            GraphQLMedia__JsonHelper.m9079a(jsonGenerator, graphQLSouvenirMediaElementMediaEdge.m21741a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
