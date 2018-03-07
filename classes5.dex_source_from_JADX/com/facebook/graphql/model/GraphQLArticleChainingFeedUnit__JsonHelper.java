package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: is_service_page */
public final class GraphQLArticleChainingFeedUnit__JsonHelper {
    public static boolean m6604a(GraphQLArticleChainingFeedUnit graphQLArticleChainingFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLArticleChainingFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("articleChainingTitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "articleChainingTitle"));
            }
            graphQLArticleChainingFeedUnit.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "articleChainingTitle", graphQLArticleChainingFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLArticleChainingFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "cache_id", graphQLArticleChainingFeedUnit.B_(), 1, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLArticleChainingFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "debug_info", graphQLArticleChainingFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLArticleChainingFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "fetchTimeMs", graphQLArticleChainingFeedUnit.B_(), 3, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLArticleChainingFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "id", graphQLArticleChainingFeedUnit.B_(), 4, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLArticleChainingFeedUnit.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "short_term_cache_key", graphQLArticleChainingFeedUnit.B_(), 6, false);
            return true;
        } else if ("suggested_content".equals(str)) {
            GraphQLSuggestedContentConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLSuggestedContentConnection__JsonHelper.m22017a(FieldAccessQueryTracker.a(jsonParser, "suggested_content"));
            }
            graphQLArticleChainingFeedUnit.k = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "suggested_content", graphQLArticleChainingFeedUnit.B_(), 7, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLArticleChainingFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "title", graphQLArticleChainingFeedUnit.B_(), 8, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLArticleChainingFeedUnit.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "titleForSummary", graphQLArticleChainingFeedUnit.B_(), 9, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLArticleChainingFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "tracking", graphQLArticleChainingFeedUnit.B_(), 10, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLArticleChainingFeedUnit.o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLArticleChainingFeedUnit, "url", graphQLArticleChainingFeedUnit.B_(), 11, false);
            return true;
        }
    }
}
