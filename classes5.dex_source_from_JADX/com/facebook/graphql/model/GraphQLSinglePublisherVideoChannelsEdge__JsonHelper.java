package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: UserWorkExperiencesConnection */
public final class GraphQLSinglePublisherVideoChannelsEdge__JsonHelper {
    public static GraphQLSinglePublisherVideoChannelsEdge m21671a(JsonParser jsonParser) {
        GraphQLSinglePublisherVideoChannelsEdge graphQLSinglePublisherVideoChannelsEdge = new GraphQLSinglePublisherVideoChannelsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLVideoChannel graphQLVideoChannel;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLVideoChannel = null;
                } else {
                    graphQLVideoChannel = GraphQLVideoChannel__JsonHelper.m22446a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLSinglePublisherVideoChannelsEdge.f13023d = graphQLVideoChannel;
                FieldAccessQueryTracker.a(jsonParser, graphQLSinglePublisherVideoChannelsEdge, "node", graphQLSinglePublisherVideoChannelsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLSinglePublisherVideoChannelsEdge;
    }

    public static void m21672a(JsonGenerator jsonGenerator, GraphQLSinglePublisherVideoChannelsEdge graphQLSinglePublisherVideoChannelsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSinglePublisherVideoChannelsEdge.m21667a() != null) {
            jsonGenerator.a("node");
            GraphQLVideoChannel__JsonHelper.m22447a(jsonGenerator, graphQLSinglePublisherVideoChannelsEdge.m21667a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
