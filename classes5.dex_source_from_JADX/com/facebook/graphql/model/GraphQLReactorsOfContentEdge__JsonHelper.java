package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIDEO_SETS_CACHE_REFRESH */
public final class GraphQLReactorsOfContentEdge__JsonHelper {
    public static GraphQLReactorsOfContentEdge m21352a(JsonParser jsonParser) {
        GraphQLReactorsOfContentEdge graphQLReactorsOfContentEdge = new GraphQLReactorsOfContentEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLActor graphQLActor = null;
            if ("feedback_reaction_info".equals(i)) {
                GraphQLFeedbackReactionInfo a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLFeedbackReactionInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback_reaction_info"));
                }
                graphQLReactorsOfContentEdge.d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactorsOfContentEdge, "feedback_reaction_info", graphQLReactorsOfContentEdge.a_, 0, true);
            } else if ("node".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLReactorsOfContentEdge.e = graphQLActor;
                FieldAccessQueryTracker.a(jsonParser, graphQLReactorsOfContentEdge, "node", graphQLReactorsOfContentEdge.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLReactorsOfContentEdge;
    }

    public static void m21353a(JsonGenerator jsonGenerator, GraphQLReactorsOfContentEdge graphQLReactorsOfContentEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLReactorsOfContentEdge.a() != null) {
            jsonGenerator.a("feedback_reaction_info");
            GraphQLFeedbackReactionInfo__JsonHelper.a(jsonGenerator, graphQLReactorsOfContentEdge.a(), true);
        }
        if (graphQLReactorsOfContentEdge.j() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLReactorsOfContentEdge.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
