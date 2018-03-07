package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VH_COMBINED_SINGLE_LIVE_FEED */
public final class GraphQLSaleGroupsNearYouFeedUnit__JsonHelper {
    public static boolean m21531a(GraphQLSaleGroupsNearYouFeedUnit graphQLSaleGroupsNearYouFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLSaleGroupsNearYouFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("all_sale_groups".equals(str)) {
            GraphQLSaleGroupsNearYouFeedUnitGroupsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLSaleGroupsNearYouFeedUnitGroupsConnection__JsonHelper.m21517a(FieldAccessQueryTracker.a(jsonParser, "all_sale_groups"));
            }
            graphQLSaleGroupsNearYouFeedUnit.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "all_sale_groups", graphQLSaleGroupsNearYouFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSaleGroupsNearYouFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "cache_id", graphQLSaleGroupsNearYouFeedUnit.B_(), 1, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSaleGroupsNearYouFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "debug_info", graphQLSaleGroupsNearYouFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLSaleGroupsNearYouFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "fetchTimeMs", graphQLSaleGroupsNearYouFeedUnit.B_(), 3, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSaleGroupsNearYouFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "id", graphQLSaleGroupsNearYouFeedUnit.B_(), 4, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSaleGroupsNearYouFeedUnit.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "short_term_cache_key", graphQLSaleGroupsNearYouFeedUnit.B_(), 6, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLSaleGroupsNearYouFeedUnit.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "title", graphQLSaleGroupsNearYouFeedUnit.B_(), 7, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLSaleGroupsNearYouFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "titleForSummary", graphQLSaleGroupsNearYouFeedUnit.B_(), 8, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSaleGroupsNearYouFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "tracking", graphQLSaleGroupsNearYouFeedUnit.B_(), 9, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSaleGroupsNearYouFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSaleGroupsNearYouFeedUnit, "url", graphQLSaleGroupsNearYouFeedUnit.B_(), 10, false);
            return true;
        }
    }
}
