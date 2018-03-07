package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: friendEventWatchers */
public final class GraphQLGroupOwnerAuthoredStoriesConnection__JsonHelper {
    public static GraphQLGroupOwnerAuthoredStoriesConnection m8490a(JsonParser jsonParser) {
        GraphQLGroupOwnerAuthoredStoriesConnection graphQLGroupOwnerAuthoredStoriesConnection = new GraphQLGroupOwnerAuthoredStoriesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8492a(graphQLGroupOwnerAuthoredStoriesConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGroupOwnerAuthoredStoriesConnection;
    }

    private static boolean m8492a(GraphQLGroupOwnerAuthoredStoriesConnection graphQLGroupOwnerAuthoredStoriesConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("available_for_sale_count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLGroupOwnerAuthoredStoriesConnection.d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupOwnerAuthoredStoriesConnection, "available_for_sale_count", graphQLGroupOwnerAuthoredStoriesConnection.a_, 0, false);
            return true;
        } else if ("nodes".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStory a = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGroupOwnerAuthoredStoriesConnection.e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupOwnerAuthoredStoriesConnection, "nodes", graphQLGroupOwnerAuthoredStoriesConnection.B_(), 1, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLGroupOwnerAuthoredStoriesConnection.f = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupOwnerAuthoredStoriesConnection, "page_info", graphQLGroupOwnerAuthoredStoriesConnection.B_(), 2, true);
            return true;
        } else if (!"total_for_sale_count".equals(str)) {
            return false;
        } else {
            graphQLGroupOwnerAuthoredStoriesConnection.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupOwnerAuthoredStoriesConnection, "total_for_sale_count", graphQLGroupOwnerAuthoredStoriesConnection.B_(), 3, false);
            return true;
        }
    }

    public static void m8491a(JsonGenerator jsonGenerator, GraphQLGroupOwnerAuthoredStoriesConnection graphQLGroupOwnerAuthoredStoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("available_for_sale_count", graphQLGroupOwnerAuthoredStoriesConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLGroupOwnerAuthoredStoriesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLStory graphQLStory : graphQLGroupOwnerAuthoredStoriesConnection.j()) {
                if (graphQLStory != null) {
                    GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStory, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupOwnerAuthoredStoriesConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLGroupOwnerAuthoredStoriesConnection.k(), true);
        }
        jsonGenerator.a("total_for_sale_count", graphQLGroupOwnerAuthoredStoriesConnection.l());
        if (z) {
            jsonGenerator.g();
        }
    }
}
