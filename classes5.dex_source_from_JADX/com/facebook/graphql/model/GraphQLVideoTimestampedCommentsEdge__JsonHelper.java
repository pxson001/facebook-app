package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TermsNotAgreed */
public final class GraphQLVideoTimestampedCommentsEdge__JsonHelper {
    public static GraphQLVideoTimestampedCommentsEdge m22481a(JsonParser jsonParser) {
        GraphQLVideoTimestampedCommentsEdge graphQLVideoTimestampedCommentsEdge = new GraphQLVideoTimestampedCommentsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLComment graphQLComment;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLComment = null;
                } else {
                    graphQLComment = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLVideoTimestampedCommentsEdge.f13454d = graphQLComment;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoTimestampedCommentsEdge, "node", graphQLVideoTimestampedCommentsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLVideoTimestampedCommentsEdge;
    }

    public static void m22482a(JsonGenerator jsonGenerator, GraphQLVideoTimestampedCommentsEdge graphQLVideoTimestampedCommentsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLVideoTimestampedCommentsEdge.m22477a() != null) {
            jsonGenerator.a("node");
            GraphQLComment__JsonHelper.a(jsonGenerator, graphQLVideoTimestampedCommentsEdge.m22477a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
