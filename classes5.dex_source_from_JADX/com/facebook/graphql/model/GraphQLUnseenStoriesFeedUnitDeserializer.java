package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: method/bug.create */
public class GraphQLUnseenStoriesFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m22379a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLUnseenStoriesFeedUnit graphQLUnseenStoriesFeedUnit = new GraphQLUnseenStoriesFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLUnseenStoriesFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLUnseenStoriesFeedUnit.f13380d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnseenStoriesFeedUnit.f13381e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "cache_id", graphQLUnseenStoriesFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnseenStoriesFeedUnit.f13382f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "debug_info", graphQLUnseenStoriesFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLUnseenStoriesFeedUnit.f13383g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "fetchTimeMs", graphQLUnseenStoriesFeedUnit.a_, 2, false);
                } else if ("id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnseenStoriesFeedUnit.f13384h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "id", graphQLUnseenStoriesFeedUnit.a_, 3, false);
                } else if ("owner".equals(i)) {
                    GraphQLActor graphQLActor;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLActor = null;
                    } else {
                        graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "owner"));
                    }
                    graphQLUnseenStoriesFeedUnit.f13385i = graphQLActor;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "owner", graphQLUnseenStoriesFeedUnit.a_, 4, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnseenStoriesFeedUnit.f13386j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "short_term_cache_key", graphQLUnseenStoriesFeedUnit.a_, 6, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLUnseenStoriesFeedUnit.f13387k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "title", graphQLUnseenStoriesFeedUnit.a_, 7, true);
                } else if ("titleForSummary".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
                    }
                    graphQLUnseenStoriesFeedUnit.f13388l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "titleForSummary", graphQLUnseenStoriesFeedUnit.a_, 8, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnseenStoriesFeedUnit.f13389m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "tracking", graphQLUnseenStoriesFeedUnit.a_, 9, false);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnseenStoriesFeedUnit.f13390n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnseenStoriesFeedUnit, "url", graphQLUnseenStoriesFeedUnit.a_, 10, false);
                }
                jsonParser.f();
            }
        }
        return graphQLUnseenStoriesFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUnseenStoriesFeedUnit.class, new GraphQLUnseenStoriesFeedUnitDeserializer());
    }

    public GraphQLUnseenStoriesFeedUnitDeserializer() {
        a(GraphQLUnseenStoriesFeedUnit.class);
    }
}
