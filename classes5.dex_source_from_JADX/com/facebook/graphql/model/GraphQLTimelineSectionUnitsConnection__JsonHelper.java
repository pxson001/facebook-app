package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UNIFIED_MEDIA_GALLERY */
public final class GraphQLTimelineSectionUnitsConnection__JsonHelper {
    public static GraphQLTimelineSectionUnitsConnection m22203a(JsonParser jsonParser) {
        GraphQLTimelineSectionUnitsConnection graphQLTimelineSectionUnitsConnection = new GraphQLTimelineSectionUnitsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLPageInfo graphQLPageInfo = null;
            if ("edges".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLTimelineSectionUnitsEdge a = GraphQLTimelineSectionUnitsEdge__JsonHelper.m22214a(FieldAccessQueryTracker.a(jsonParser, "edges"));
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
                graphQLTimelineSectionUnitsConnection.f13342d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSectionUnitsConnection, "edges", graphQLTimelineSectionUnitsConnection.a_, 0, true);
            } else if ("page_info".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLPageInfo = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
                }
                graphQLTimelineSectionUnitsConnection.f13343e = graphQLPageInfo;
                FieldAccessQueryTracker.a(jsonParser, graphQLTimelineSectionUnitsConnection, "page_info", graphQLTimelineSectionUnitsConnection.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLTimelineSectionUnitsConnection;
    }

    public static void m22204a(JsonGenerator jsonGenerator, GraphQLTimelineSectionUnitsConnection graphQLTimelineSectionUnitsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("edges");
        if (graphQLTimelineSectionUnitsConnection.m22199a() != null) {
            jsonGenerator.d();
            for (GraphQLTimelineSectionUnitsEdge graphQLTimelineSectionUnitsEdge : graphQLTimelineSectionUnitsConnection.m22199a()) {
                if (graphQLTimelineSectionUnitsEdge != null) {
                    GraphQLTimelineSectionUnitsEdge__JsonHelper.m22215a(jsonGenerator, graphQLTimelineSectionUnitsEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTimelineSectionUnitsConnection.m22200j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLTimelineSectionUnitsConnection.m22200j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
