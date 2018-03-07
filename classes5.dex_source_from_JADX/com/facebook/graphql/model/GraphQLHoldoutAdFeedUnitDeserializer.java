package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: originalRun */
public class GraphQLHoldoutAdFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m8607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLHoldoutAdFeedUnit graphQLHoldoutAdFeedUnit = new GraphQLHoldoutAdFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLHoldoutAdFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLHoldoutAdFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLHoldoutAdFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "cache_id", graphQLHoldoutAdFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLHoldoutAdFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "debug_info", graphQLHoldoutAdFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLHoldoutAdFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "fetchTimeMs", graphQLHoldoutAdFeedUnit.a_, 2, false);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLHoldoutAdFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "short_term_cache_key", graphQLHoldoutAdFeedUnit.a_, 3, false);
                } else if ("sponsored_data".equals(i)) {
                    GraphQLSponsoredData graphQLSponsoredData;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLSponsoredData = null;
                    } else {
                        graphQLSponsoredData = GraphQLSponsoredData__JsonHelper.m21756a(FieldAccessQueryTracker.a(jsonParser, "sponsored_data"));
                    }
                    graphQLHoldoutAdFeedUnit.i = graphQLSponsoredData;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "sponsored_data", graphQLHoldoutAdFeedUnit.a_, 4, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLHoldoutAdFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "tracking", graphQLHoldoutAdFeedUnit.a_, 5, false);
                } else if ("local_last_negative_feedback_action_type".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLHoldoutAdFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "local_last_negative_feedback_action_type", graphQLHoldoutAdFeedUnit.a_, 6, false);
                } else if ("local_story_visibility".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLHoldoutAdFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "local_story_visibility", graphQLHoldoutAdFeedUnit.a_, 7, false);
                } else if ("local_story_visible_height".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLHoldoutAdFeedUnit.m = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLHoldoutAdFeedUnit, "local_story_visible_height", graphQLHoldoutAdFeedUnit.a_, 8, false);
                }
                jsonParser.f();
            }
        }
        return graphQLHoldoutAdFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLHoldoutAdFeedUnit.class, new GraphQLHoldoutAdFeedUnitDeserializer());
    }

    public GraphQLHoldoutAdFeedUnitDeserializer() {
        a(GraphQLHoldoutAdFeedUnit.class);
    }
}
