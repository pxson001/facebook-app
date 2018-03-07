package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: initCameraSettings/setDisplayOrientation failed */
public final class GraphQLEventHostsEdge__JsonHelper {
    public static GraphQLEventHostsEdge m7200a(JsonParser jsonParser) {
        GraphQLEventHostsEdge graphQLEventHostsEdge = new GraphQLEventHostsEdge();
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
                graphQLEventHostsEdge.f3633d = graphQLActor;
                FieldAccessQueryTracker.a(jsonParser, graphQLEventHostsEdge, "node", graphQLEventHostsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLEventHostsEdge;
    }

    public static void m7201a(JsonGenerator jsonGenerator, GraphQLEventHostsEdge graphQLEventHostsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLEventHostsEdge.m7196a() != null) {
            jsonGenerator.a("node");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLEventHostsEdge.m7196a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
