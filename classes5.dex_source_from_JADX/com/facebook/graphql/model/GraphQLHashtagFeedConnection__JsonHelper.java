package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: form-data */
public final class GraphQLHashtagFeedConnection__JsonHelper {
    public static GraphQLHashtagFeedConnection m8601a(JsonParser jsonParser) {
        GraphQLHashtagFeedConnection graphQLHashtagFeedConnection = new GraphQLHashtagFeedConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("page_info".equals(i)) {
                GraphQLPageInfo graphQLPageInfo;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLPageInfo = null;
                } else {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLHashtagFeedConnection.f4272d = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLHashtagFeedConnection, "page_info", graphQLHashtagFeedConnection.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLHashtagFeedConnection;
    }

    public static void m8602a(JsonGenerator jsonGenerator, GraphQLHashtagFeedConnection graphQLHashtagFeedConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLHashtagFeedConnection.m8597a() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLHashtagFeedConnection.m8597a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
