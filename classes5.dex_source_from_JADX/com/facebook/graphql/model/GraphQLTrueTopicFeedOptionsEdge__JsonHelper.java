package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Total sensor power */
public final class GraphQLTrueTopicFeedOptionsEdge__JsonHelper {
    public static GraphQLTrueTopicFeedOptionsEdge m22337a(JsonParser jsonParser) {
        GraphQLTrueTopicFeedOptionsEdge graphQLTrueTopicFeedOptionsEdge = new GraphQLTrueTopicFeedOptionsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLTrueTopicFeedOption = null;
                } else {
                    graphQLTrueTopicFeedOption = GraphQLTrueTopicFeedOption__JsonHelper.m22319a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLTrueTopicFeedOptionsEdge.f13373d = graphQLTrueTopicFeedOption;
                FieldAccessQueryTracker.a(jsonParser, graphQLTrueTopicFeedOptionsEdge, "node", graphQLTrueTopicFeedOptionsEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLTrueTopicFeedOptionsEdge;
    }

    public static void m22338a(JsonGenerator jsonGenerator, GraphQLTrueTopicFeedOptionsEdge graphQLTrueTopicFeedOptionsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTrueTopicFeedOptionsEdge.m22333a() != null) {
            jsonGenerator.a("node");
            GraphQLTrueTopicFeedOption__JsonHelper.m22320a(jsonGenerator, graphQLTrueTopicFeedOptionsEdge.m22333a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
