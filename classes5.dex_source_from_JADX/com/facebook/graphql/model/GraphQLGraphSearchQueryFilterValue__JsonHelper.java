package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: gametime */
public final class GraphQLGraphSearchQueryFilterValue__JsonHelper {
    public static GraphQLGraphSearchQueryFilterValue m8247a(JsonParser jsonParser) {
        GraphQLGraphSearchQueryFilterValue graphQLGraphSearchQueryFilterValue = new GraphQLGraphSearchQueryFilterValue();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("is_selected".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLGraphSearchQueryFilterValue.f4088d = z;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterValue, "is_selected", graphQLGraphSearchQueryFilterValue.a_, 0, false);
            } else if ("text".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGraphSearchQueryFilterValue.f4089e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterValue, "text", graphQLGraphSearchQueryFilterValue.a_, 1, false);
            } else if ("value".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLGraphSearchQueryFilterValue.f4090f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterValue, "value", graphQLGraphSearchQueryFilterValue.a_, 2, false);
            } else if ("value_object".equals(i)) {
                GraphQLNode graphQLNode;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLNode = null;
                } else {
                    graphQLNode = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "value_object"));
                }
                graphQLGraphSearchQueryFilterValue.f4091g = graphQLNode;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilterValue, "value_object", graphQLGraphSearchQueryFilterValue.a_, 3, true);
            }
            jsonParser.f();
        }
        return graphQLGraphSearchQueryFilterValue;
    }

    public static void m8248a(JsonGenerator jsonGenerator, GraphQLGraphSearchQueryFilterValue graphQLGraphSearchQueryFilterValue, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("is_selected", graphQLGraphSearchQueryFilterValue.m8241a());
        if (graphQLGraphSearchQueryFilterValue.m8242j() != null) {
            jsonGenerator.a("text", graphQLGraphSearchQueryFilterValue.m8242j());
        }
        if (graphQLGraphSearchQueryFilterValue.m8243k() != null) {
            jsonGenerator.a("value", graphQLGraphSearchQueryFilterValue.m8243k());
        }
        if (graphQLGraphSearchQueryFilterValue.m8244l() != null) {
            jsonGenerator.a("value_object");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLGraphSearchQueryFilterValue.m8244l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
