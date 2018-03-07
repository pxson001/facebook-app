package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: screen_brightness_mode */
public final class GraphQLTopLevelCommentsConnection__JsonHelper {
    public static GraphQLTopLevelCommentsConnection m3225a(JsonParser jsonParser) {
        GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection = new GraphQLTopLevelCommentsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3227a(graphQLTopLevelCommentsConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLTopLevelCommentsConnection;
    }

    private static boolean m3227a(GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection, String str, JsonParser jsonParser) {
        GraphQLPageInfo graphQLPageInfo = null;
        if ("count".equals(str)) {
            int i;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                i = 0;
            } else {
                i = jsonParser.E();
            }
            graphQLTopLevelCommentsConnection.d = i;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTopLevelCommentsConnection, "count", graphQLTopLevelCommentsConnection.a_, 0, false);
            return true;
        } else if ("nodes".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLComment a = GraphQLComment__JsonHelper.m3228a(FieldAccessQueryTracker.m2235a(jsonParser, "nodes"));
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
            graphQLTopLevelCommentsConnection.e = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTopLevelCommentsConnection, "nodes", graphQLTopLevelCommentsConnection.B_(), 1, true);
            return true;
        } else if ("page_info".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPageInfo = GraphQLPageInfo__JsonHelper.m11279a(FieldAccessQueryTracker.m2235a(jsonParser, "page_info"));
            }
            graphQLTopLevelCommentsConnection.f = graphQLPageInfo;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTopLevelCommentsConnection, "page_info", graphQLTopLevelCommentsConnection.B_(), 2, true);
            return true;
        } else if (!"total_count".equals(str)) {
            return false;
        } else {
            graphQLTopLevelCommentsConnection.g = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLTopLevelCommentsConnection, "total_count", graphQLTopLevelCommentsConnection.B_(), 3, false);
            return true;
        }
    }

    public static void m3226a(JsonGenerator jsonGenerator, GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLTopLevelCommentsConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLTopLevelCommentsConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment : graphQLTopLevelCommentsConnection.j()) {
                if (graphQLComment != null) {
                    GraphQLComment__JsonHelper.m3229a(jsonGenerator, graphQLComment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTopLevelCommentsConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.m11280a(jsonGenerator, graphQLTopLevelCommentsConnection.k(), true);
        }
        jsonGenerator.a("total_count", graphQLTopLevelCommentsConnection.b());
        if (z) {
            jsonGenerator.g();
        }
    }
}
