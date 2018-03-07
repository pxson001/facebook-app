package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_suggestions_on_liking */
public class GraphQLFindFriendsFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m7511a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLFindFriendsFeedUnit graphQLFindFriendsFeedUnit = new GraphQLFindFriendsFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLFindFriendsFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                int i2;
                if ("__type__".equals(i)) {
                    graphQLFindFriendsFeedUnit.d = GraphQLObjectType.a(jsonParser);
                    i2 = 1;
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLFindFriendsFeedUnit.e = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLFindFriendsFeedUnit, "fetchTimeMs", graphQLFindFriendsFeedUnit.a_, 0, false);
                    i2 = 1;
                }
                jsonParser.f();
            }
        }
        return graphQLFindFriendsFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFindFriendsFeedUnit.class, new GraphQLFindFriendsFeedUnitDeserializer());
    }

    public GraphQLFindFriendsFeedUnitDeserializer() {
        a(GraphQLFindFriendsFeedUnit.class);
    }
}
