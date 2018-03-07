package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: safe_browsers */
public final class GraphQLTopReactionsEdge__JsonHelper {
    public static GraphQLTopReactionsEdge m3258a(JsonParser jsonParser) {
        GraphQLTopReactionsEdge graphQLTopReactionsEdge = new GraphQLTopReactionsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3260a(graphQLTopReactionsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTopReactionsEdge;
    }

    private static boolean m3260a(GraphQLTopReactionsEdge graphQLTopReactionsEdge, String str, JsonParser jsonParser) {
        if ("node".equals(str)) {
            GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                graphQLFeedbackReactionInfo = null;
            } else {
                graphQLFeedbackReactionInfo = GraphQLFeedbackReactionInfo__JsonHelper.m3261a(FieldAccessQueryTracker.m2235a(jsonParser, "node"));
            }
            graphQLTopReactionsEdge.d = graphQLFeedbackReactionInfo;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTopReactionsEdge, "node", graphQLTopReactionsEdge.a_, 0, true);
            return true;
        } else if (!"reaction_count".equals(str)) {
            return false;
        } else {
            graphQLTopReactionsEdge.e = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTopReactionsEdge, "reaction_count", graphQLTopReactionsEdge.B_(), 1, false);
            return true;
        }
    }

    public static void m3259a(JsonGenerator jsonGenerator, GraphQLTopReactionsEdge graphQLTopReactionsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTopReactionsEdge.a() != null) {
            jsonGenerator.a("node");
            GraphQLFeedbackReactionInfo__JsonHelper.m3262a(jsonGenerator, graphQLTopReactionsEdge.a(), true);
        }
        jsonGenerator.a("reaction_count", graphQLTopReactionsEdge.j());
        if (z) {
            jsonGenerator.g();
        }
    }
}
