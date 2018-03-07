package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photo_stories */
public class GraphQLClientBumpingPlaceHolderFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m6788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLClientBumpingPlaceHolderFeedUnit graphQLClientBumpingPlaceHolderFeedUnit = new GraphQLClientBumpingPlaceHolderFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLClientBumpingPlaceHolderFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLClientBumpingPlaceHolderFeedUnit.f3438d = GraphQLObjectType.a(jsonParser);
                } else if ("bump_story_deduplication_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLClientBumpingPlaceHolderFeedUnit.f3439e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLClientBumpingPlaceHolderFeedUnit, "bump_story_deduplication_key", graphQLClientBumpingPlaceHolderFeedUnit.a_, 0, false);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLClientBumpingPlaceHolderFeedUnit.f3440f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLClientBumpingPlaceHolderFeedUnit, "cache_id", graphQLClientBumpingPlaceHolderFeedUnit.a_, 1, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLClientBumpingPlaceHolderFeedUnit.f3441g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLClientBumpingPlaceHolderFeedUnit, "debug_info", graphQLClientBumpingPlaceHolderFeedUnit.a_, 2, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLClientBumpingPlaceHolderFeedUnit.f3442h = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLClientBumpingPlaceHolderFeedUnit, "fetchTimeMs", graphQLClientBumpingPlaceHolderFeedUnit.a_, 3, false);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLClientBumpingPlaceHolderFeedUnit.f3443i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLClientBumpingPlaceHolderFeedUnit, "short_term_cache_key", graphQLClientBumpingPlaceHolderFeedUnit.a_, 4, false);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLClientBumpingPlaceHolderFeedUnit.f3444j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLClientBumpingPlaceHolderFeedUnit, "tracking", graphQLClientBumpingPlaceHolderFeedUnit.a_, 5, false);
                }
                jsonParser.f();
            }
        }
        return graphQLClientBumpingPlaceHolderFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLClientBumpingPlaceHolderFeedUnit.class, new GraphQLClientBumpingPlaceHolderFeedUnitDeserializer());
    }

    public GraphQLClientBumpingPlaceHolderFeedUnitDeserializer() {
        a(GraphQLClientBumpingPlaceHolderFeedUnit.class);
    }
}
