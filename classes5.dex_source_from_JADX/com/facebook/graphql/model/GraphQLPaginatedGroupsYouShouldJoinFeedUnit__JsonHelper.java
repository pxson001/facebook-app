package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WRAP_CONTENT */
public final class GraphQLPaginatedGroupsYouShouldJoinFeedUnit__JsonHelper {
    public static boolean m20610a(GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("all_groups".equals(str)) {
            GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = C1150x757fdcee.m20594a(FieldAccessQueryTracker.a(jsonParser, "all_groups"));
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "all_groups", graphQLPaginatedGroupsYouShouldJoinFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "cache_id", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 1, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "debug_info", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "fetchTimeMs", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 3, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "id", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 4, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "short_term_cache_key", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 6, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "title", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 7, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "titleForSummary", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 8, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "tracking", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 9, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedGroupsYouShouldJoinFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedGroupsYouShouldJoinFeedUnit, "url", graphQLPaginatedGroupsYouShouldJoinFeedUnit.B_(), 10, false);
            return true;
        }
    }
}
