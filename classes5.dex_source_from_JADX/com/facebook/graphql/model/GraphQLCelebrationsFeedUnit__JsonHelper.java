package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: is_default */
public final class GraphQLCelebrationsFeedUnit__JsonHelper {
    public static boolean m6759a(GraphQLCelebrationsFeedUnit graphQLCelebrationsFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLCelebrationsFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCelebrationsFeedUnit.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "cache_id", graphQLCelebrationsFeedUnit.a_, 0, false);
            return true;
        } else if ("celebsItems".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLCelebrationsFeedUnitItem__JsonHelper.m6755a(FieldAccessQueryTracker.a(jsonParser, "celebsItems"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLCelebrationsFeedUnit.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "celebsItems", graphQLCelebrationsFeedUnit.B_(), 1, true);
            return true;
        } else if ("celebsTitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "celebsTitle"));
            }
            graphQLCelebrationsFeedUnit.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "celebsTitle", graphQLCelebrationsFeedUnit.B_(), 2, true);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCelebrationsFeedUnit.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "debug_info", graphQLCelebrationsFeedUnit.B_(), 3, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLCelebrationsFeedUnit.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "fetchTimeMs", graphQLCelebrationsFeedUnit.B_(), 4, false);
            return true;
        } else if ("items".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLCelebrationsFeedUnitItem__JsonHelper.m6755a(FieldAccessQueryTracker.a(jsonParser, "items"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLCelebrationsFeedUnit.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "items", graphQLCelebrationsFeedUnit.B_(), 5, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCelebrationsFeedUnit.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "short_term_cache_key", graphQLCelebrationsFeedUnit.B_(), 6, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLCelebrationsFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "title", graphQLCelebrationsFeedUnit.B_(), 7, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLCelebrationsFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLCelebrationsFeedUnit, "tracking", graphQLCelebrationsFeedUnit.B_(), 8, false);
            return true;
        }
    }
}
