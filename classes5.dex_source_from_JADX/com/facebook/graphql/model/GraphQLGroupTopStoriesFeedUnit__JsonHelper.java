package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: free_form */
public final class GraphQLGroupTopStoriesFeedUnit__JsonHelper {
    public static boolean m8517a(GraphQLGroupTopStoriesFeedUnit graphQLGroupTopStoriesFeedUnit, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLGroupTopStoriesFeedUnit.d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("all_top_stories".equals(str)) {
            GraphQLGroupTopStoriesFeedUnitStoriesConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGroupTopStoriesFeedUnitStoriesConnection__JsonHelper.m8506a(FieldAccessQueryTracker.a(jsonParser, "all_top_stories"));
            }
            graphQLGroupTopStoriesFeedUnit.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "all_top_stories", graphQLGroupTopStoriesFeedUnit.a_, 0, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupTopStoriesFeedUnit.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "cache_id", graphQLGroupTopStoriesFeedUnit.B_(), 1, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupTopStoriesFeedUnit.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "debug_info", graphQLGroupTopStoriesFeedUnit.B_(), 2, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLGroupTopStoriesFeedUnit.h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "fetchTimeMs", graphQLGroupTopStoriesFeedUnit.B_(), 3, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupTopStoriesFeedUnit.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "short_term_cache_key", graphQLGroupTopStoriesFeedUnit.B_(), 4, false);
            return true;
        } else if ("title".equals(str)) {
            GraphQLTextWithEntities a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGroupTopStoriesFeedUnit.j = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "title", graphQLGroupTopStoriesFeedUnit.B_(), 5, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupTopStoriesFeedUnit.k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "tracking", graphQLGroupTopStoriesFeedUnit.B_(), 6, false);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupTopStoriesFeedUnit.l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "local_last_negative_feedback_action_type", graphQLGroupTopStoriesFeedUnit.B_(), 7, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupTopStoriesFeedUnit.m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "local_story_visibility", graphQLGroupTopStoriesFeedUnit.B_(), 8, false);
            return true;
        } else if (!"local_story_visible_height".equals(str)) {
            return false;
        } else {
            graphQLGroupTopStoriesFeedUnit.n = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupTopStoriesFeedUnit, "local_story_visible_height", graphQLGroupTopStoriesFeedUnit.B_(), 9, false);
            return true;
        }
    }
}
