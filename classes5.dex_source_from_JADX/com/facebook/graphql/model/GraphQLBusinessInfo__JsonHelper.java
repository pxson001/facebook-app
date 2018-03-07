package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLBusinessInfoType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_facecast_ready */
public final class GraphQLBusinessInfo__JsonHelper {
    public static GraphQLBusinessInfo m6705a(JsonParser jsonParser) {
        GraphQLBusinessInfo graphQLBusinessInfo = new GraphQLBusinessInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            if ("label".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLBusinessInfo.d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLBusinessInfo, "label", graphQLBusinessInfo.a_, 0, false);
            } else if ("type".equals(i)) {
                graphQLBusinessInfo.e = GraphQLBusinessInfoType.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLBusinessInfo, "type", graphQLBusinessInfo.a_, 1, false);
            } else if ("value".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "value"));
                }
                graphQLBusinessInfo.f = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLBusinessInfo, "value", graphQLBusinessInfo.a_, 2, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLBusinessInfo;
    }

    public static void m6706a(JsonGenerator jsonGenerator, GraphQLBusinessInfo graphQLBusinessInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLBusinessInfo.a() != null) {
            jsonGenerator.a("label", graphQLBusinessInfo.a());
        }
        if (graphQLBusinessInfo.j() != null) {
            jsonGenerator.a("type", graphQLBusinessInfo.j().toString());
        }
        if (graphQLBusinessInfo.k() != null) {
            jsonGenerator.a("value");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLBusinessInfo.k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
