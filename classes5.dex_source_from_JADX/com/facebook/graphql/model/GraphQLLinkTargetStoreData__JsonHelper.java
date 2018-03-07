package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fc_pymk */
public final class GraphQLLinkTargetStoreData__JsonHelper {
    public static GraphQLLinkTargetStoreData m8947a(JsonParser jsonParser) {
        GraphQLLinkTargetStoreData graphQLLinkTargetStoreData = new GraphQLLinkTargetStoreData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8949a(graphQLLinkTargetStoreData, i, jsonParser);
            jsonParser.f();
        }
        return graphQLLinkTargetStoreData;
    }

    private static boolean m8949a(GraphQLLinkTargetStoreData graphQLLinkTargetStoreData, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("icon_url".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLLinkTargetStoreData.d = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLLinkTargetStoreData, "icon_url", graphQLLinkTargetStoreData.a_, 0, false);
            return true;
        } else if ("name".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "name"));
            }
            graphQLLinkTargetStoreData.e = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLLinkTargetStoreData, "name", graphQLLinkTargetStoreData.B_(), 1, true);
            return true;
        } else if ("show_beeper".equals(str)) {
            graphQLLinkTargetStoreData.f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLLinkTargetStoreData, "show_beeper", graphQLLinkTargetStoreData.B_(), 2, false);
            return true;
        } else if ("show_store_overlay".equals(str)) {
            graphQLLinkTargetStoreData.g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLLinkTargetStoreData, "show_store_overlay", graphQLLinkTargetStoreData.B_(), 3, false);
            return true;
        } else if (!"store_context".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "store_context"));
            }
            graphQLLinkTargetStoreData.h = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLLinkTargetStoreData, "store_context", graphQLLinkTargetStoreData.B_(), 4, true);
            return true;
        }
    }

    public static void m8948a(JsonGenerator jsonGenerator, GraphQLLinkTargetStoreData graphQLLinkTargetStoreData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLLinkTargetStoreData.a() != null) {
            jsonGenerator.a("icon_url", graphQLLinkTargetStoreData.a());
        }
        if (graphQLLinkTargetStoreData.j() != null) {
            jsonGenerator.a("name");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLLinkTargetStoreData.j(), true);
        }
        jsonGenerator.a("show_beeper", graphQLLinkTargetStoreData.k());
        jsonGenerator.a("show_store_overlay", graphQLLinkTargetStoreData.l());
        if (graphQLLinkTargetStoreData.m() != null) {
            jsonGenerator.a("store_context");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLLinkTargetStoreData.m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
