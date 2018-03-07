package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: WORK_POSITION_TYPE */
public final class GraphQLPaginatedPeopleYouMayKnowFeedUnit__JsonHelper {
    public static boolean m20632a(GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLPaginatedPeopleYouMayKnowFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("all_users".equals(str)) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = C1160xc690a2f6.m20623a(FieldAccessQueryTracker.a(jsonParser, "all_users"));
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "all_users", graphQLPaginatedPeopleYouMayKnowFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "cache_id", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 1, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "debug_info", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLPaginatedPeopleYouMayKnowFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "fetchTimeMs", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 3, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "id", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 4, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "short_term_cache_key", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 6, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "title", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 7, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "titleForSummary", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 8, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "tracking", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 9, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPaginatedPeopleYouMayKnowFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPaginatedPeopleYouMayKnowFeedUnit, "url", graphQLPaginatedPeopleYouMayKnowFeedUnit.B_(), 10, false);
            return true;
        }
    }
}
