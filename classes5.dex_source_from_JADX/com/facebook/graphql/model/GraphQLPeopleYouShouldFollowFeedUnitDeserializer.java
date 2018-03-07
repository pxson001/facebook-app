package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: noLogoForNow */
public class GraphQLPeopleYouShouldFollowFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m20694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLPeopleYouShouldFollowFeedUnit graphQLPeopleYouShouldFollowFeedUnit = new GraphQLPeopleYouShouldFollowFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLPeopleYouShouldFollowFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLPeopleYouShouldFollowFeedUnit.d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPeopleYouShouldFollowFeedUnit.e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "cache_id", graphQLPeopleYouShouldFollowFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPeopleYouShouldFollowFeedUnit.f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "debug_info", graphQLPeopleYouShouldFollowFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLPeopleYouShouldFollowFeedUnit.g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "fetchTimeMs", graphQLPeopleYouShouldFollowFeedUnit.a_, 2, false);
                } else if ("id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPeopleYouShouldFollowFeedUnit.h = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "id", graphQLPeopleYouShouldFollowFeedUnit.a_, 3, false);
                } else if ("pysfItems".equals(i)) {
                    GraphQLPeopleToFollowConnection graphQLPeopleToFollowConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPeopleToFollowConnection = null;
                    } else {
                        graphQLPeopleToFollowConnection = GraphQLPeopleToFollowConnection__JsonHelper.m20640a(FieldAccessQueryTracker.a(jsonParser, "pysfItems"));
                    }
                    graphQLPeopleYouShouldFollowFeedUnit.i = graphQLPeopleToFollowConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "pysfItems", graphQLPeopleYouShouldFollowFeedUnit.a_, 4, true);
                } else if ("short_term_cache_key".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPeopleYouShouldFollowFeedUnit.j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "short_term_cache_key", graphQLPeopleYouShouldFollowFeedUnit.a_, 6, false);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLPeopleYouShouldFollowFeedUnit.k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "title", graphQLPeopleYouShouldFollowFeedUnit.a_, 7, true);
                } else if ("titleForSummary".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
                    }
                    graphQLPeopleYouShouldFollowFeedUnit.l = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "titleForSummary", graphQLPeopleYouShouldFollowFeedUnit.a_, 8, true);
                } else if ("tracking".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPeopleYouShouldFollowFeedUnit.m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "tracking", graphQLPeopleYouShouldFollowFeedUnit.a_, 9, false);
                } else if ("url".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLPeopleYouShouldFollowFeedUnit.n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLPeopleYouShouldFollowFeedUnit, "url", graphQLPeopleYouShouldFollowFeedUnit.a_, 10, false);
                }
                jsonParser.f();
            }
        }
        return graphQLPeopleYouShouldFollowFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouShouldFollowFeedUnit.class, new GraphQLPeopleYouShouldFollowFeedUnitDeserializer());
    }

    public GraphQLPeopleYouShouldFollowFeedUnitDeserializer() {
        a(GraphQLPeopleYouShouldFollowFeedUnit.class);
    }
}
