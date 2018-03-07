package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_reactions */
public class GraphQLEventCollectionFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m7144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLEventCollectionFeedUnit graphQLEventCollectionFeedUnit = new GraphQLEventCollectionFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLEventCollectionFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLEventCollectionFeedUnit.f3613d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLEventCollectionFeedUnit.f3614e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "cache_id", graphQLEventCollectionFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLEventCollectionFeedUnit.f3615f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "debug_info", graphQLEventCollectionFeedUnit.a_, 1, false);
                } else if ("eventChainingTitle".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "eventChainingTitle"));
                    }
                    graphQLEventCollectionFeedUnit.f3616g = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "eventChainingTitle", graphQLEventCollectionFeedUnit.a_, 2, true);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLEventCollectionFeedUnit.f3617h = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "fetchTimeMs", graphQLEventCollectionFeedUnit.a_, 3, false);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLEventCollectionFeedUnit.f3618i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "short_term_cache_key", graphQLEventCollectionFeedUnit.a_, 4, false);
                } else if ("suggestedEvents".equals(i)) {
                    GraphQLEventCollectionToItemConnection graphQLEventCollectionToItemConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLEventCollectionToItemConnection = null;
                    } else {
                        graphQLEventCollectionToItemConnection = GraphQLEventCollectionToItemConnection__JsonHelper.m7153a(FieldAccessQueryTracker.a(jsonParser, "suggestedEvents"));
                    }
                    graphQLEventCollectionFeedUnit.f3619j = graphQLEventCollectionToItemConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "suggestedEvents", graphQLEventCollectionFeedUnit.a_, 5, true);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLEventCollectionFeedUnit.f3620k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "title", graphQLEventCollectionFeedUnit.a_, 6, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLEventCollectionFeedUnit.f3621l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLEventCollectionFeedUnit, "tracking", graphQLEventCollectionFeedUnit.a_, 7, false);
                }
                jsonParser.f();
            }
        }
        return graphQLEventCollectionFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventCollectionFeedUnit.class, new GraphQLEventCollectionFeedUnitDeserializer());
    }

    public GraphQLEventCollectionFeedUnitDeserializer() {
        a(GraphQLEventCollectionFeedUnit.class);
    }
}
