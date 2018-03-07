package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UNIVERSAL_FEEDBACK_TEXT */
public final class GraphQLTimelineAppCollectionsConnection__JsonHelper {
    public static GraphQLTimelineAppCollectionsConnection m22173a(JsonParser jsonParser) {
        GraphQLTimelineAppCollectionsConnection graphQLTimelineAppCollectionsConnection = new GraphQLTimelineAppCollectionsConnection();
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
                graphQLTimelineAppCollectionsConnection.f13327d = i3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionsConnection, "count", graphQLTimelineAppCollectionsConnection.a_, 0, false);
                i2 = 1;
            } else if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLTimelineAppCollection a = GraphQLTimelineAppCollection__JsonHelper.m22160a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLTimelineAppCollectionsConnection.f13328e = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionsConnection, "nodes", graphQLTimelineAppCollectionsConnection.a_, 1, true);
                i2 = 1;
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLTimelineAppCollectionsConnection.f13329f = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineAppCollectionsConnection, "page_info", graphQLTimelineAppCollectionsConnection.a_, 2, true);
                i2 = 1;
            }
            jsonParser.f();
        }
        return graphQLTimelineAppCollectionsConnection;
    }

    public static void m22174a(JsonGenerator jsonGenerator, GraphQLTimelineAppCollectionsConnection graphQLTimelineAppCollectionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLTimelineAppCollectionsConnection.m22165a());
        jsonGenerator.a("nodes");
        if (graphQLTimelineAppCollectionsConnection.m22169j() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineAppCollection graphQLTimelineAppCollection : graphQLTimelineAppCollectionsConnection.m22169j()) {
                if (graphQLTimelineAppCollection != null) {
                    GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLTimelineAppCollection, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTimelineAppCollectionsConnection.m22170k() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionsConnection.m22170k(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
