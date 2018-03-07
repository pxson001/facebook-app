package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: num_visible_top_answers */
public class GraphQLPageStoriesYouMissedFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m9525a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPageStoriesYouMissedFeedUnit graphQLPageStoriesYouMissedFeedUnit = new GraphQLPageStoriesYouMissedFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPageStoriesYouMissedFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLPageStoriesYouMissedFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPageStoriesYouMissedFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "cache_id", graphQLPageStoriesYouMissedFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPageStoriesYouMissedFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "debug_info", graphQLPageStoriesYouMissedFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLPageStoriesYouMissedFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "fetchTimeMs", graphQLPageStoriesYouMissedFeedUnit.a_, 2, false);
                } else if ("page_stories".equals(i)) {
                    GraphQLPageStoriesYouMissedFeedUnitStoriesConnection graphQLPageStoriesYouMissedFeedUnitStoriesConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPageStoriesYouMissedFeedUnitStoriesConnection = null;
                    } else {
                        graphQLPageStoriesYouMissedFeedUnitStoriesConnection = GraphQLPageStoriesYouMissedFeedUnitStoriesConnection__JsonHelper.m9535a(FieldAccessQueryTracker.a(jsonParser, "page_stories"));
                    }
                    graphQLPageStoriesYouMissedFeedUnit.h = graphQLPageStoriesYouMissedFeedUnitStoriesConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "page_stories", graphQLPageStoriesYouMissedFeedUnit.a_, 3, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPageStoriesYouMissedFeedUnit.i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "short_term_cache_key", graphQLPageStoriesYouMissedFeedUnit.a_, 4, false);
                } else if ("title".equals(i)) {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLTextWithEntities = null;
                    } else {
                        graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLPageStoriesYouMissedFeedUnit.j = graphQLTextWithEntities;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "title", graphQLPageStoriesYouMissedFeedUnit.a_, 5, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPageStoriesYouMissedFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "tracking", graphQLPageStoriesYouMissedFeedUnit.a_, 6, false);
                } else if ("local_last_negative_feedback_action_type".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPageStoriesYouMissedFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "local_last_negative_feedback_action_type", graphQLPageStoriesYouMissedFeedUnit.a_, 7, false);
                } else if ("local_story_visibility".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPageStoriesYouMissedFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "local_story_visibility", graphQLPageStoriesYouMissedFeedUnit.a_, 8, false);
                } else if ("local_story_visible_height".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLPageStoriesYouMissedFeedUnit.n = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPageStoriesYouMissedFeedUnit, "local_story_visible_height", graphQLPageStoriesYouMissedFeedUnit.a_, 9, false);
                }
                jsonParser.f();
            }
        }
        return graphQLPageStoriesYouMissedFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageStoriesYouMissedFeedUnit.class, new GraphQLPageStoriesYouMissedFeedUnitDeserializer());
    }

    public GraphQLPageStoriesYouMissedFeedUnitDeserializer() {
        a(GraphQLPageStoriesYouMissedFeedUnit.class);
    }
}
