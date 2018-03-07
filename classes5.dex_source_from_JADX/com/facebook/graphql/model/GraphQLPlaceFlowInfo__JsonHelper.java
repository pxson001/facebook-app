package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCheckinPlaceResultsContext;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: WEBVIEW */
public final class GraphQLPlaceFlowInfo__JsonHelper {
    public static GraphQLPlaceFlowInfo m20847a(JsonParser jsonParser) {
        GraphQLPlaceFlowInfo graphQLPlaceFlowInfo = new GraphQLPlaceFlowInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            Collection collection;
            Object o;
            List list;
            if ("place_ids".equals(i)) {
                collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            collection.add(o);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLPlaceFlowInfo.f12638d = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceFlowInfo, "place_ids", graphQLPlaceFlowInfo.a_, 0, false);
            } else if ("place_topic_ids".equals(i)) {
                collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                        if (o != null) {
                            collection.add(o);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLPlaceFlowInfo.f12639e = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceFlowInfo, "place_topic_ids", graphQLPlaceFlowInfo.a_, 1, false);
            } else if ("show_all_contextual_places".equals(i)) {
                graphQLPlaceFlowInfo.f12640f = GraphQLCheckinPlaceResultsContext.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceFlowInfo, "show_all_contextual_places", graphQLPlaceFlowInfo.a_, 2, false);
            } else if ("suggestion_mechanism".equals(i)) {
                String o2 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLPlaceFlowInfo.f12641g = o2;
                FieldAccessQueryTracker.a(jsonParser, graphQLPlaceFlowInfo, "suggestion_mechanism", graphQLPlaceFlowInfo.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLPlaceFlowInfo;
    }

    public static void m20848a(JsonGenerator jsonGenerator, GraphQLPlaceFlowInfo graphQLPlaceFlowInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("place_ids");
        if (graphQLPlaceFlowInfo.m20841a() != null) {
            jsonGenerator.d();
            for (String str : graphQLPlaceFlowInfo.m20841a()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("place_topic_ids");
        if (graphQLPlaceFlowInfo.m20842j() != null) {
            jsonGenerator.d();
            for (String str2 : graphQLPlaceFlowInfo.m20842j()) {
                if (str2 != null) {
                    jsonGenerator.b(str2);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPlaceFlowInfo.m20843k() != null) {
            jsonGenerator.a("show_all_contextual_places", graphQLPlaceFlowInfo.m20843k().toString());
        }
        if (graphQLPlaceFlowInfo.m20844l() != null) {
            jsonGenerator.a("suggestion_mechanism", graphQLPlaceFlowInfo.m20844l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
