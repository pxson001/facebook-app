package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_HOME_SECTION_HEADER */
public final class GraphQLRelevantReactorsEdge__JsonHelper {
    public static GraphQLRelevantReactorsEdge m21397a(JsonParser jsonParser) {
        GraphQLRelevantReactorsEdge graphQLRelevantReactorsEdge = new GraphQLRelevantReactorsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("feedback_reaction_info".equals(i)) {
                GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLFeedbackReactionInfo = null;
                } else {
                    graphQLFeedbackReactionInfo = GraphQLFeedbackReactionInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback_reaction_info"));
                }
                graphQLRelevantReactorsEdge.f12914d = graphQLFeedbackReactionInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLRelevantReactorsEdge, "feedback_reaction_info", graphQLRelevantReactorsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLRelevantReactorsEdge;
    }

    public static void m21398a(JsonGenerator jsonGenerator, GraphQLRelevantReactorsEdge graphQLRelevantReactorsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLRelevantReactorsEdge.m21393a() != null) {
            jsonGenerator.a("feedback_reaction_info");
            GraphQLFeedbackReactionInfo__JsonHelper.a(jsonGenerator, graphQLRelevantReactorsEdge.m21393a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
