package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: failed to delete  */
public final class GraphQLMegaphoneAction__JsonHelper {
    public static GraphQLMegaphoneAction m9101a(JsonParser jsonParser) {
        GraphQLMegaphoneAction graphQLMegaphoneAction = new GraphQLMegaphoneAction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("style".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMegaphoneAction.f4506d = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMegaphoneAction, "style", graphQLMegaphoneAction.a_, 0, false);
            } else if ("title".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMegaphoneAction.f4507e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMegaphoneAction, "title", graphQLMegaphoneAction.a_, 1, false);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLMegaphoneAction.f4508f = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMegaphoneAction, "url", graphQLMegaphoneAction.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLMegaphoneAction;
    }

    public static void m9102a(JsonGenerator jsonGenerator, GraphQLMegaphoneAction graphQLMegaphoneAction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMegaphoneAction.m9096a() != null) {
            jsonGenerator.a("style", graphQLMegaphoneAction.m9096a());
        }
        if (graphQLMegaphoneAction.m9097j() != null) {
            jsonGenerator.a("title", graphQLMegaphoneAction.m9097j());
        }
        if (graphQLMegaphoneAction.m9098k() != null) {
            jsonGenerator.a("url", graphQLMegaphoneAction.m9098k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
