package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: events_carousel */
public final class GraphQLNegativeFeedbackActionsEdge__JsonHelper {
    public static GraphQLNegativeFeedbackActionsEdge m9249a(JsonParser jsonParser) {
        GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = new GraphQLNegativeFeedbackActionsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLNegativeFeedbackAction = null;
                } else {
                    graphQLNegativeFeedbackAction = GraphQLNegativeFeedbackAction__JsonHelper.m9236a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLNegativeFeedbackActionsEdge.d = graphQLNegativeFeedbackAction;
                FieldAccessQueryTracker.a(jsonParser, graphQLNegativeFeedbackActionsEdge, "node", graphQLNegativeFeedbackActionsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLNegativeFeedbackActionsEdge;
    }

    public static void m9250a(JsonGenerator jsonGenerator, GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLNegativeFeedbackActionsEdge.a() != null) {
            jsonGenerator.a("node");
            GraphQLNegativeFeedbackAction__JsonHelper.m9237a(jsonGenerator, graphQLNegativeFeedbackActionsEdge.a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
