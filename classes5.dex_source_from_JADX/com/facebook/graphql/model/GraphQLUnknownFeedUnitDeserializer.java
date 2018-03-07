package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mfl */
public class GraphQLUnknownFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m22350a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLUnknownFeedUnit graphQLUnknownFeedUnit = new GraphQLUnknownFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLUnknownFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("__type__".equals(i)) {
                    graphQLUnknownFeedUnit.f13374d = GraphQLObjectType.a(jsonParser);
                } else if ("cache_id".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnknownFeedUnit.f13375e = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnknownFeedUnit, "cache_id", graphQLUnknownFeedUnit.a_, 0, false);
                } else if ("debug_info".equals(i)) {
                    r4 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLUnknownFeedUnit.f13376f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnknownFeedUnit, "debug_info", graphQLUnknownFeedUnit.a_, 1, false);
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLUnknownFeedUnit.f13377g = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLUnknownFeedUnit, "fetchTimeMs", graphQLUnknownFeedUnit.a_, 2, false);
                }
                jsonParser.f();
            }
        }
        return graphQLUnknownFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUnknownFeedUnit.class, new GraphQLUnknownFeedUnitDeserializer());
    }

    public GraphQLUnknownFeedUnitDeserializer() {
        a(GraphQLUnknownFeedUnit.class);
    }
}
