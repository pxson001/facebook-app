package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: imageLowres */
public final class GraphQLEventWatchersEdge__JsonHelper {
    public static GraphQLEventWatchersEdge m7342a(JsonParser jsonParser) {
        GraphQLEventWatchersEdge graphQLEventWatchersEdge = new GraphQLEventWatchersEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLActor graphQLActor;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLActor = null;
                } else {
                    graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLEventWatchersEdge.f3684d = graphQLActor;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventWatchersEdge, "node", graphQLEventWatchersEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEventWatchersEdge;
    }

    public static void m7343a(JsonGenerator jsonGenerator, GraphQLEventWatchersEdge graphQLEventWatchersEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventWatchersEdge.m7338a() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLEventWatchersEdge.m7338a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
