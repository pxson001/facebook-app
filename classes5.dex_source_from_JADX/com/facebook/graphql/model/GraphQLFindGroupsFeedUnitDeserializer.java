package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_suggestion_megaphone */
public class GraphQLFindGroupsFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m7515a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLFindGroupsFeedUnit graphQLFindGroupsFeedUnit = new GraphQLFindGroupsFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLFindGroupsFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                int i2;
                if ("__type__".equals(i)) {
                    graphQLFindGroupsFeedUnit.d = GraphQLObjectType.a(jsonParser);
                    i2 = 1;
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLFindGroupsFeedUnit.e = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFindGroupsFeedUnit, "fetchTimeMs", graphQLFindGroupsFeedUnit.a_, 0, false);
                    i2 = 1;
                }
                jsonParser.f();
            }
        }
        return graphQLFindGroupsFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFindGroupsFeedUnit.class, new GraphQLFindGroupsFeedUnitDeserializer());
    }

    public GraphQLFindGroupsFeedUnitDeserializer() {
        a(GraphQLFindGroupsFeedUnit.class);
    }
}
