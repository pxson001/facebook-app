package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: User is not in the gk */
public final class GraphQLSocialWifiFeedUnitItem__JsonHelper {
    public static GraphQLSocialWifiFeedUnitItem m21684a(JsonParser jsonParser) {
        GraphQLSocialWifiFeedUnitItem graphQLSocialWifiFeedUnitItem = new GraphQLSocialWifiFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21686a(graphQLSocialWifiFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSocialWifiFeedUnitItem;
    }

    private static boolean m21686a(GraphQLSocialWifiFeedUnitItem graphQLSocialWifiFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("profile".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLSocialWifiFeedUnitItem.f13024d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnitItem, "profile", graphQLSocialWifiFeedUnitItem.a_, 0, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSocialWifiFeedUnitItem.f13025e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSocialWifiFeedUnitItem, "tracking", graphQLSocialWifiFeedUnitItem.B_(), 1, false);
            return true;
        }
    }

    public static void m21685a(JsonGenerator jsonGenerator, GraphQLSocialWifiFeedUnitItem graphQLSocialWifiFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSocialWifiFeedUnitItem.m21679a() != null) {
            jsonGenerator.a("profile");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLSocialWifiFeedUnitItem.m21679a(), true);
        }
        if (graphQLSocialWifiFeedUnitItem.m21681k() != null) {
            jsonGenerator.a("tracking", graphQLSocialWifiFeedUnitItem.m21681k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
