package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEW_PDF_MENU */
public final class GraphQLQuickPromotionAction__JsonHelper {
    public static GraphQLQuickPromotionAction m21210a(JsonParser jsonParser) {
        GraphQLQuickPromotionAction graphQLQuickPromotionAction = new GraphQLQuickPromotionAction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21212a(graphQLQuickPromotionAction, i, jsonParser);
            jsonParser.f();
        }
        return graphQLQuickPromotionAction;
    }

    private static boolean m21212a(GraphQLQuickPromotionAction graphQLQuickPromotionAction, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("title".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLQuickPromotionAction.f12847d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionAction, "title", graphQLQuickPromotionAction.a_, 0, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLQuickPromotionAction.f12848e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuickPromotionAction, "url", graphQLQuickPromotionAction.B_(), 1, false);
            return true;
        }
    }

    public static void m21211a(JsonGenerator jsonGenerator, GraphQLQuickPromotionAction graphQLQuickPromotionAction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQuickPromotionAction.m21205a() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuickPromotionAction.m21205a(), true);
        }
        if (graphQLQuickPromotionAction.m21207j() != null) {
            jsonGenerator.a("url", graphQLQuickPromotionAction.m21207j());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
