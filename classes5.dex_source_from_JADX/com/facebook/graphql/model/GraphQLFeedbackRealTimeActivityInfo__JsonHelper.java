package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLFeedbackRealTimeActivityType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: hide */
public final class GraphQLFeedbackRealTimeActivityInfo__JsonHelper {
    public static GraphQLFeedbackRealTimeActivityInfo m7505a(JsonParser jsonParser) {
        GraphQLFeedbackRealTimeActivityInfo graphQLFeedbackRealTimeActivityInfo = new GraphQLFeedbackRealTimeActivityInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7507a(graphQLFeedbackRealTimeActivityInfo, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFeedbackRealTimeActivityInfo;
    }

    private static boolean m7507a(GraphQLFeedbackRealTimeActivityInfo graphQLFeedbackRealTimeActivityInfo, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("real_time_activity_actors".equals(str)) {
            GraphQLFeedbackRealTimeActivityActorsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFeedbackRealTimeActivityActorsConnection__JsonHelper.m7499a(FieldAccessQueryTracker.a(jsonParser, "real_time_activity_actors"));
            }
            graphQLFeedbackRealTimeActivityInfo.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackRealTimeActivityInfo, "real_time_activity_actors", graphQLFeedbackRealTimeActivityInfo.a_, 0, true);
            return true;
        } else if ("real_time_activity_sentence".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "real_time_activity_sentence"));
            }
            graphQLFeedbackRealTimeActivityInfo.e = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackRealTimeActivityInfo, "real_time_activity_sentence", graphQLFeedbackRealTimeActivityInfo.B_(), 1, true);
            return true;
        } else if (!"real_time_activity_type".equals(str)) {
            return false;
        } else {
            graphQLFeedbackRealTimeActivityInfo.f = GraphQLFeedbackRealTimeActivityType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLFeedbackRealTimeActivityInfo, "real_time_activity_type", graphQLFeedbackRealTimeActivityInfo.B_(), 2, false);
            return true;
        }
    }

    public static void m7506a(JsonGenerator jsonGenerator, GraphQLFeedbackRealTimeActivityInfo graphQLFeedbackRealTimeActivityInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFeedbackRealTimeActivityInfo.j() != null) {
            jsonGenerator.a("real_time_activity_actors");
            GraphQLFeedbackRealTimeActivityActorsConnection__JsonHelper.m7500a(jsonGenerator, graphQLFeedbackRealTimeActivityInfo.j(), true);
        }
        if (graphQLFeedbackRealTimeActivityInfo.k() != null) {
            jsonGenerator.a("real_time_activity_sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLFeedbackRealTimeActivityInfo.k(), true);
        }
        if (graphQLFeedbackRealTimeActivityInfo.l() != null) {
            jsonGenerator.a("real_time_activity_type", graphQLFeedbackRealTimeActivityInfo.l().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
