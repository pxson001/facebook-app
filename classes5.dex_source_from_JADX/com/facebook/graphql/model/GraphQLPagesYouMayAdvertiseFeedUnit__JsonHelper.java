package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPYMACategory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: eglMakeCurrent */
public final class GraphQLPagesYouMayAdvertiseFeedUnit__JsonHelper {
    public static boolean m9574a(GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLPagesYouMayAdvertiseFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("action_links".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryActionLink a = GraphQLStoryActionLink__JsonHelper.m21847a(FieldAccessQueryTracker.a(jsonParser, "action_links"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPagesYouMayAdvertiseFeedUnit.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "action_links", graphQLPagesYouMayAdvertiseFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "cache_id", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 1, false);
            return true;
        } else if ("category".equals(str)) {
            graphQLPagesYouMayAdvertiseFeedUnit.g = GraphQLPYMACategory.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "category", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 2, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnit.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "debug_info", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 3, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLPagesYouMayAdvertiseFeedUnit.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "fetchTimeMs", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 4, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnit.j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "hideable_token", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 5, false);
            return true;
        } else if ("items".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPagesYouMayAdvertiseFeedUnitItem a2 = GraphQLPagesYouMayAdvertiseFeedUnitItem__JsonHelper.m9570a(FieldAccessQueryTracker.a(jsonParser, "items"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLPagesYouMayAdvertiseFeedUnit.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "items", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 6, true);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLPagesYouMayAdvertiseFeedUnit.l = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "negative_feedback_actions", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 7, true);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLPagesYouMayAdvertiseFeedUnit.m = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "privacy_scope", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 8, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnit.n = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "short_term_cache_key", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 9, false);
            return true;
        } else if ("title".equals(str)) {
            GraphQLTextWithEntities a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLPagesYouMayAdvertiseFeedUnit.o = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "title", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 10, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnit.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "tracking", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 11, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnit.q = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "local_last_negative_feedback_action_type", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 12, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPagesYouMayAdvertiseFeedUnit.r = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "local_story_visibility", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 13, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLPagesYouMayAdvertiseFeedUnit.s = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLPagesYouMayAdvertiseFeedUnit, "local_story_visible_height", graphQLPagesYouMayAdvertiseFeedUnit.B_(), 14, false);
            return true;
        }
    }
}
