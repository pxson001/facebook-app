package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UPLOADED_BY_YOUR_FRIENDS */
public final class GraphQLSubstoriesConnection__JsonHelper {
    public static GraphQLSubstoriesConnection m22007a(JsonParser jsonParser) {
        GraphQLSubstoriesConnection graphQLSubstoriesConnection = new GraphQLSubstoriesConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m22009a(graphQLSubstoriesConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSubstoriesConnection;
    }

    private static boolean m22009a(GraphQLSubstoriesConnection graphQLSubstoriesConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLSubstoriesConnection.d = i;
            FieldAccessQueryTracker.a(jsonParser, graphQLSubstoriesConnection, "count", graphQLSubstoriesConnection.a_, 0, false);
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
            graphQLSubstoriesConnection.e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLSubstoriesConnection, "nodes", graphQLSubstoriesConnection.B_(), 2, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLSubstoriesConnection.f = graphQLPageInfo;
            FieldAccessQueryTracker.a(jsonParser, graphQLSubstoriesConnection, "page_info", graphQLSubstoriesConnection.B_(), 3, true);
            return true;
        } else if (!"remaining_count".equals(str)) {
            return false;
        } else {
            graphQLSubstoriesConnection.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSubstoriesConnection, "remaining_count", graphQLSubstoriesConnection.B_(), 4, false);
            return true;
        }
    }

    public static void m22008a(JsonGenerator jsonGenerator, GraphQLSubstoriesConnection graphQLSubstoriesConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLSubstoriesConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLSubstoriesConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLStory graphQLStory : graphQLSubstoriesConnection.j()) {
                if (graphQLStory != null) {
                    GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLStory, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSubstoriesConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLSubstoriesConnection.k(), true);
        }
        jsonGenerator.a("remaining_count", graphQLSubstoriesConnection.l());
        if (z) {
            jsonGenerator.g();
        }
    }
}
