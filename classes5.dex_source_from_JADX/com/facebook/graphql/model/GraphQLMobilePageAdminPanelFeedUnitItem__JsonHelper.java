package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: facepile_mentioned_ids */
public final class GraphQLMobilePageAdminPanelFeedUnitItem__JsonHelper {
    public static GraphQLMobilePageAdminPanelFeedUnitItem m9130a(JsonParser jsonParser) {
        GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem = new GraphQLMobilePageAdminPanelFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9132a(graphQLMobilePageAdminPanelFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLMobilePageAdminPanelFeedUnitItem;
    }

    private static boolean m9132a(GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("aymt_channel_image".equals(str)) {
            GraphQLImage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "aymt_channel_image"));
            }
            graphQLMobilePageAdminPanelFeedUnitItem.f4509d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnitItem, "aymt_channel_image", graphQLMobilePageAdminPanelFeedUnitItem.a_, 0, true);
            return true;
        } else if ("aymt_channel_url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMobilePageAdminPanelFeedUnitItem.f4510e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnitItem, "aymt_channel_url", graphQLMobilePageAdminPanelFeedUnitItem.B_(), 1, false);
            return true;
        } else if ("aymt_hpp_channel".equals(str)) {
            GraphQLAYMTChannel a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLAYMTChannel__JsonHelper.m6353a(FieldAccessQueryTracker.a(jsonParser, "aymt_hpp_channel"));
            }
            graphQLMobilePageAdminPanelFeedUnitItem.f4511f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnitItem, "aymt_hpp_channel", graphQLMobilePageAdminPanelFeedUnitItem.B_(), 2, true);
            return true;
        } else if ("context_rows".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLEntityCardContextItem a3 = GraphQLEntityCardContextItem__JsonHelper.m7083a(FieldAccessQueryTracker.a(jsonParser, "context_rows"));
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLMobilePageAdminPanelFeedUnitItem.f4512g = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnitItem, "context_rows", graphQLMobilePageAdminPanelFeedUnitItem.B_(), 3, true);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLPage a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLMobilePageAdminPanelFeedUnitItem.f4513h = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnitItem, "profile", graphQLMobilePageAdminPanelFeedUnitItem.B_(), 4, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMobilePageAdminPanelFeedUnitItem.f4514i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMobilePageAdminPanelFeedUnitItem, "tracking", graphQLMobilePageAdminPanelFeedUnitItem.B_(), 5, false);
            return true;
        }
    }

    public static void m9131a(JsonGenerator jsonGenerator, GraphQLMobilePageAdminPanelFeedUnitItem graphQLMobilePageAdminPanelFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMobilePageAdminPanelFeedUnitItem.m9122j() != null) {
            jsonGenerator.a("aymt_channel_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLMobilePageAdminPanelFeedUnitItem.m9122j(), true);
        }
        if (graphQLMobilePageAdminPanelFeedUnitItem.m9124l() != null) {
            jsonGenerator.a("aymt_channel_url", graphQLMobilePageAdminPanelFeedUnitItem.m9124l());
        }
        if (graphQLMobilePageAdminPanelFeedUnitItem.m9125m() != null) {
            jsonGenerator.a("aymt_hpp_channel");
            GraphQLAYMTChannel__JsonHelper.m6354a(jsonGenerator, graphQLMobilePageAdminPanelFeedUnitItem.m9125m(), true);
        }
        jsonGenerator.a("context_rows");
        if (graphQLMobilePageAdminPanelFeedUnitItem.m9126n() != null) {
            jsonGenerator.d();
            for (GraphQLEntityCardContextItem graphQLEntityCardContextItem : graphQLMobilePageAdminPanelFeedUnitItem.m9126n()) {
                if (graphQLEntityCardContextItem != null) {
                    GraphQLEntityCardContextItem__JsonHelper.m7084a(jsonGenerator, graphQLEntityCardContextItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLMobilePageAdminPanelFeedUnitItem.m9127o() != null) {
            jsonGenerator.a("profile");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLMobilePageAdminPanelFeedUnitItem.m9127o(), true);
        }
        if (graphQLMobilePageAdminPanelFeedUnitItem.m9123k() != null) {
            jsonGenerator.a("tracking", graphQLMobilePageAdminPanelFeedUnitItem.m9123k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
