package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: isVideoTranscodingError */
public final class GraphQLCommentsConnection__JsonHelper {
    public static GraphQLCommentsConnection m6819a(JsonParser jsonParser) {
        GraphQLCommentsConnection graphQLCommentsConnection = new GraphQLCommentsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            int i2;
            if ("count".equals(i)) {
                int i3;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i3 = 0;
                } else {
                    i3 = jsonParser.E();
                }
                graphQLCommentsConnection.d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLCommentsConnection, "count", graphQLCommentsConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLComment a = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLCommentsConnection.e = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLCommentsConnection, "nodes", graphQLCommentsConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLCommentsConnection.f = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLCommentsConnection, "page_info", graphQLCommentsConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLCommentsConnection;
    }

    public static void m6820a(JsonGenerator jsonGenerator, GraphQLCommentsConnection graphQLCommentsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLCommentsConnection.a());
        jsonGenerator.a("nodes");
        if (graphQLCommentsConnection.j() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment : graphQLCommentsConnection.j()) {
                if (graphQLComment != null) {
                    GraphQLComment__JsonHelper.a(jsonGenerator, graphQLComment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCommentsConnection.k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLCommentsConnection.k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
