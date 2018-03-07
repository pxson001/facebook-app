package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: flight_status_label */
public final class GraphQLImageOverlay__JsonHelper {
    public static GraphQLImageOverlay m8630a(JsonParser jsonParser) {
        GraphQLImageOverlay graphQLImageOverlay = new GraphQLImageOverlay();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8632a(graphQLImageOverlay, i, jsonParser);
            jsonParser.f();
        }
        return graphQLImageOverlay;
    }

    private static boolean m8632a(GraphQLImageOverlay graphQLImageOverlay, String str, JsonParser jsonParser) {
        GraphQLImage graphQLImage = null;
        if ("__type__".equals(str)) {
            GraphQLObjectType a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLObjectType.a(jsonParser);
            }
            graphQLImageOverlay.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLImageOverlay, "__type__", graphQLImageOverlay.a_, 0, false);
            return true;
        } else if ("associated_pages".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLProfile a2 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "associated_pages"));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLImageOverlay.e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLImageOverlay, "associated_pages", graphQLImageOverlay.B_(), 1, true);
            return true;
        } else if ("id".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLImageOverlay.f = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLImageOverlay, "id", graphQLImageOverlay.B_(), 2, false);
            return true;
        } else if (!"image".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
            }
            graphQLImageOverlay.g = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLImageOverlay, "image", graphQLImageOverlay.B_(), 3, true);
            return true;
        }
    }

    public static void m8631a(JsonGenerator jsonGenerator, GraphQLImageOverlay graphQLImageOverlay, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLImageOverlay.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLImageOverlay.j().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("associated_pages");
        if (graphQLImageOverlay.k() != null) {
            jsonGenerator.d();
            for (GraphQLProfile graphQLProfile : graphQLImageOverlay.k()) {
                if (graphQLProfile != null) {
                    GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLProfile, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLImageOverlay.l() != null) {
            jsonGenerator.a("id", graphQLImageOverlay.l());
        }
        if (graphQLImageOverlay.m() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLImageOverlay.m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
