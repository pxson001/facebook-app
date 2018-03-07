package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UNDERLINE */
public final class GraphQLTimelineSectionsConnection__JsonHelper {
    public static GraphQLTimelineSectionsConnection m22223a(JsonParser jsonParser) {
        GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection = new GraphQLTimelineSectionsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("nodes".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLTimelineSection a = GraphQLTimelineSection__JsonHelper.m22217a(FieldAccessQueryTracker.a(jsonParser, "nodes"));
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
                graphQLTimelineSectionsConnection.d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSectionsConnection, "nodes", graphQLTimelineSectionsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLTimelineSectionsConnection.e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSectionsConnection, "page_info", graphQLTimelineSectionsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLTimelineSectionsConnection;
    }

    public static void m22224a(JsonGenerator jsonGenerator, GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("nodes");
        if (graphQLTimelineSectionsConnection.a() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineSection graphQLTimelineSection : graphQLTimelineSectionsConnection.a()) {
                if (graphQLTimelineSection != null) {
                    GraphQLTimelineSection__JsonHelper.m22218a(jsonGenerator, graphQLTimelineSection, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTimelineSectionsConnection.j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLTimelineSectionsConnection.j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
