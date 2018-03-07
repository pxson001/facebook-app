package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: sa_text */
public final class GraphQLFeedbackReaction__JsonHelper {
    public static GraphQLFeedbackReaction m3263a(JsonParser jsonParser) {
        GraphQLFeedbackReaction graphQLFeedbackReaction = new GraphQLFeedbackReaction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("key".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLFeedbackReaction.d = i2;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReaction, "key", graphQLFeedbackReaction.a_, 0, false);
            }
            jsonParser.f();
        }
        return graphQLFeedbackReaction;
    }

    public static void m3264a(JsonGenerator jsonGenerator, GraphQLFeedbackReaction graphQLFeedbackReaction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("key", graphQLFeedbackReaction.a());
        if (z) {
            jsonGenerator.g();
        }
    }
}
