package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: greeting_card_template */
public final class GraphQLGoodwillBirthdayCampaign__JsonHelper {
    public static boolean m7819a(GraphQLGoodwillBirthdayCampaign graphQLGoodwillBirthdayCampaign, String str, JsonParser jsonParser) {
        List list = null;
        if ("campaign_owner".equals(str)) {
            GraphQLProfile a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "campaign_owner"));
            }
            graphQLGoodwillBirthdayCampaign.f3872d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillBirthdayCampaign, "campaign_owner", graphQLGoodwillBirthdayCampaign.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillBirthdayCampaign.f3873e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillBirthdayCampaign, "id", graphQLGoodwillBirthdayCampaign.B_(), 1, false);
            return true;
        } else if ("posting_actors".equals(str)) {
            GraphQLGoodwillBirthdayCampaignPostingActorsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = C0344xcce9d9af.m7816a(FieldAccessQueryTracker.a(jsonParser, "posting_actors"));
            }
            graphQLGoodwillBirthdayCampaign.f3874f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillBirthdayCampaign, "posting_actors", graphQLGoodwillBirthdayCampaign.B_(), 2, true);
            return true;
        } else if ("social_context".equals(str)) {
            GraphQLTextWithEntities a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "social_context"));
            }
            graphQLGoodwillBirthdayCampaign.f3875g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillBirthdayCampaign, "social_context", graphQLGoodwillBirthdayCampaign.B_(), 3, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLGoodwillBirthdayCampaign.f3876h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillBirthdayCampaign, "url", graphQLGoodwillBirthdayCampaign.B_(), 4, false);
            return true;
        } else if (!"image_overlays".equals(str)) {
            return false;
        } else {
            Collection arrayList;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLImageOverlay a4 = GraphQLImageOverlay__JsonHelper.m8630a(FieldAccessQueryTracker.a(jsonParser, "image_overlays"));
                    if (a4 != null) {
                        arrayList.add(a4);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                list = ImmutableList.copyOf(arrayList);
            }
            graphQLGoodwillBirthdayCampaign.f3877i = list;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillBirthdayCampaign, "image_overlays", graphQLGoodwillBirthdayCampaign.B_(), 5, true);
            return true;
        }
    }
}
