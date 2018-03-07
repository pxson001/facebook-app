package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unable to release  */
public final class GraphQLStoryGallerySurveyFeedUnit__JsonHelper {
    public static boolean m21870a(GraphQLStoryGallerySurveyFeedUnit graphQLStoryGallerySurveyFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLStoryGallerySurveyFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "cache_id", graphQLStoryGallerySurveyFeedUnit.a_, 0, false);
            return true;
        } else if ("cancellation".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "cancellation"));
            }
            graphQLStoryGallerySurveyFeedUnit.f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "cancellation", graphQLStoryGallerySurveyFeedUnit.B_(), 1, true);
            return true;
        } else if ("confirmation".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "confirmation"));
            }
            graphQLStoryGallerySurveyFeedUnit.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "confirmation", graphQLStoryGallerySurveyFeedUnit.B_(), 2, true);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "debug_info", graphQLStoryGallerySurveyFeedUnit.B_(), 3, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLStoryGallerySurveyFeedUnit.i = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "fetchTimeMs", graphQLStoryGallerySurveyFeedUnit.B_(), 4, false);
            return true;
        } else if ("footer".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "footer"));
            }
            graphQLStoryGallerySurveyFeedUnit.j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "footer", graphQLStoryGallerySurveyFeedUnit.B_(), 5, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "id", graphQLStoryGallerySurveyFeedUnit.B_(), 6, false);
            return true;
        } else if ("message_summary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message_summary"));
            }
            graphQLStoryGallerySurveyFeedUnit.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "message_summary", graphQLStoryGallerySurveyFeedUnit.B_(), 7, true);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "short_term_cache_key", graphQLStoryGallerySurveyFeedUnit.B_(), 9, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLStoryGallerySurveyFeedUnit.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "title", graphQLStoryGallerySurveyFeedUnit.B_(), 10, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLStoryGallerySurveyFeedUnit.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "titleForSummary", graphQLStoryGallerySurveyFeedUnit.B_(), 11, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.p = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "tracking", graphQLStoryGallerySurveyFeedUnit.B_(), 12, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.q = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "url", graphQLStoryGallerySurveyFeedUnit.B_(), 13, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.r = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "local_last_negative_feedback_action_type", graphQLStoryGallerySurveyFeedUnit.B_(), 14, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLStoryGallerySurveyFeedUnit.s = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "local_story_visibility", graphQLStoryGallerySurveyFeedUnit.B_(), 15, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLStoryGallerySurveyFeedUnit.t = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStoryGallerySurveyFeedUnit, "local_story_visible_height", graphQLStoryGallerySurveyFeedUnit.B_(), 16, false);
            return true;
        }
    }
}
