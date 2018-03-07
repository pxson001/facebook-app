package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStorySetCollectionType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: USER_PUBLIC */
public final class GraphQLStorySet__JsonHelper {
    public static boolean m21915a(GraphQLStorySet graphQLStorySet, String str, JsonParser jsonParser) {
        GraphQLImage graphQLImage = null;
        if ("__type__".equals(str)) {
            graphQLStorySet.d = GraphQLObjectType.a(jsonParser);
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
            graphQLStorySet.e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "action_links", graphQLStorySet.a_, 0, true);
            return true;
        } else if ("all_stories".equals(str)) {
            GraphQLStorySetStoriesConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLStorySetStoriesConnection__JsonHelper.m21913a(FieldAccessQueryTracker.a(jsonParser, "all_stories"));
            }
            graphQLStorySet.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "all_stories", graphQLStorySet.B_(), 1, true);
            return true;
        } else if ("cache_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "cache_id", graphQLStorySet.B_(), 2, false);
            return true;
        } else if ("debug_info".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "debug_info", graphQLStorySet.B_(), 3, false);
            return true;
        } else if ("feed_unit_pagination_identifier".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "feed_unit_pagination_identifier", graphQLStorySet.B_(), 4, false);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            graphQLStorySet.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "fetchTimeMs", graphQLStorySet.B_(), 5, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "id", graphQLStorySet.B_(), 6, false);
            return true;
        } else if ("short_term_cache_key".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "short_term_cache_key", graphQLStorySet.B_(), 8, false);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLStorySet.m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "title", graphQLStorySet.B_(), 9, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLStorySet.n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "titleForSummary", graphQLStorySet.B_(), 10, true);
            return true;
        } else if ("tracking".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "tracking", graphQLStorySet.B_(), 11, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "url", graphQLStorySet.B_(), 12, false);
            return true;
        } else if ("collection_type_list".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStorySetCollectionType fromString = GraphQLStorySetCollectionType.fromString(jsonParser.o());
                    if (fromString != null) {
                        r1.add(fromString);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLStorySet.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "collection_type_list", graphQLStorySet.B_(), 13, false);
            return true;
        } else if ("hideable_token".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "hideable_token", graphQLStorySet.B_(), 14, false);
            return true;
        } else if ("negative_feedback_actions".equals(str)) {
            GraphQLNegativeFeedbackActionsConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9243a(FieldAccessQueryTracker.a(jsonParser, "negative_feedback_actions"));
            }
            graphQLStorySet.s = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "negative_feedback_actions", graphQLStorySet.B_(), 15, true);
            return true;
        } else if ("local_last_negative_feedback_action_type".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.t = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "local_last_negative_feedback_action_type", graphQLStorySet.B_(), 16, false);
            return true;
        } else if ("local_story_visibility".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLStorySet.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "local_story_visibility", graphQLStorySet.B_(), 17, false);
            return true;
        } else if ("local_story_visible_height".equals(str)) {
            graphQLStorySet.v = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "local_story_visible_height", graphQLStorySet.B_(), 18, false);
            return true;
        } else if (!"set_icon".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "set_icon"));
            }
            graphQLStorySet.w = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLStorySet, "set_icon", graphQLStorySet.B_(), 19, true);
            return true;
        }
    }
}
