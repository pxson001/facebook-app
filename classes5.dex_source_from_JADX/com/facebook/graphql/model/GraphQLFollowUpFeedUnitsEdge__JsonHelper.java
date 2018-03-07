package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: hc_reminder_poke */
public final class GraphQLFollowUpFeedUnitsEdge__JsonHelper {
    public static GraphQLFollowUpFeedUnitsEdge m7542a(JsonParser jsonParser) {
        GraphQLFollowUpFeedUnitsEdge graphQLFollowUpFeedUnitsEdge = new GraphQLFollowUpFeedUnitsEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7544a(graphQLFollowUpFeedUnitsEdge, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFollowUpFeedUnitsEdge;
    }

    private static boolean m7544a(GraphQLFollowUpFeedUnitsEdge graphQLFollowUpFeedUnitsEdge, String str, JsonParser jsonParser) {
        List list = null;
        if ("node".equals(str)) {
            FeedUnit a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = FeedUnitDeserializer.m6329a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLFollowUpFeedUnitsEdge.f3774d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFollowUpFeedUnitsEdge, "node", graphQLFollowUpFeedUnitsEdge.a_, 0, true);
            return true;
        } else if (!"supported_action_types".equals(str)) {
            return false;
        } else {
            Collection arrayList;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLFollowUpFeedUnitActionType fromString = GraphQLFollowUpFeedUnitActionType.fromString(jsonParser.o());
                    if (fromString != null) {
                        arrayList.add(fromString);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLFollowUpFeedUnitsEdge.f3775e = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLFollowUpFeedUnitsEdge, "supported_action_types", graphQLFollowUpFeedUnitsEdge.B_(), 1, false);
            return true;
        }
    }

    public static void m7543a(JsonGenerator jsonGenerator, GraphQLFollowUpFeedUnitsEdge graphQLFollowUpFeedUnitsEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFollowUpFeedUnitsEdge.m7537a() != null) {
            jsonGenerator.a("node");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLFollowUpFeedUnitsEdge.m7537a());
        }
        jsonGenerator.a("supported_action_types");
        if (graphQLFollowUpFeedUnitsEdge.m7539j() != null) {
            jsonGenerator.d();
            for (GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType : graphQLFollowUpFeedUnitsEdge.m7539j()) {
                if (graphQLFollowUpFeedUnitActionType != null) {
                    jsonGenerator.b(graphQLFollowUpFeedUnitActionType.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
