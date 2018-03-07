package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_entry_divebar */
public class GraphQLVideoChainingFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m22433a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLVideoChainingFeedUnit graphQLVideoChainingFeedUnit = new GraphQLVideoChainingFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLVideoChainingFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLVideoChainingFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLVideoChainingFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "cache_id", graphQLVideoChainingFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLVideoChainingFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "debug_info", graphQLVideoChainingFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLVideoChainingFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "fetchTimeMs", graphQLVideoChainingFeedUnit.a_, 2, false);
                } else if ("id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLVideoChainingFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "id", graphQLVideoChainingFeedUnit.a_, 3, false);
                } else if ("original_video".equals(i)) {
                    GraphQLVideo graphQLVideo;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLVideo = null;
                    } else {
                        graphQLVideo = GraphQLVideo__JsonHelper.m22483a(FieldAccessQueryTracker.a(jsonParser, "original_video"));
                    }
                    graphQLVideoChainingFeedUnit.i = graphQLVideo;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "original_video", graphQLVideoChainingFeedUnit.a_, 4, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLVideoChainingFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "short_term_cache_key", graphQLVideoChainingFeedUnit.a_, 6, false);
                } else if ("suggested_videos".equals(i)) {
                    GraphQLSuggestedVideoConnection graphQLSuggestedVideoConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLSuggestedVideoConnection = null;
                    } else {
                        graphQLSuggestedVideoConnection = GraphQLSuggestedVideoConnection__JsonHelper.m22026a(FieldAccessQueryTracker.a(jsonParser, "suggested_videos"));
                    }
                    graphQLVideoChainingFeedUnit.k = graphQLSuggestedVideoConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "suggested_videos", graphQLVideoChainingFeedUnit.a_, 7, true);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLVideoChainingFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "title", graphQLVideoChainingFeedUnit.a_, 8, true);
                } else if ("titleForSummary".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
                    }
                    graphQLVideoChainingFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "titleForSummary", graphQLVideoChainingFeedUnit.a_, 9, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLVideoChainingFeedUnit.n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "tracking", graphQLVideoChainingFeedUnit.a_, 10, false);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLVideoChainingFeedUnit.o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "url", graphQLVideoChainingFeedUnit.a_, 11, false);
                } else if ("videoChainingTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "videoChainingTitle"));
                    }
                    graphQLVideoChainingFeedUnit.p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLVideoChainingFeedUnit, "videoChainingTitle", graphQLVideoChainingFeedUnit.a_, 12, true);
                }
                jsonParser.f();
            }
        }
        return graphQLVideoChainingFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoChainingFeedUnit.class, new GraphQLVideoChainingFeedUnitDeserializer());
    }

    public GraphQLVideoChainingFeedUnitDeserializer() {
        a(GraphQLVideoChainingFeedUnit.class);
    }
}
