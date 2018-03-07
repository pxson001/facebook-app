package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offset_amount */
public class GraphQLNoContentGoodFriendsFeedUnitDeserializer extends FbJsonDeserializer {
    public Object m9280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLNoContentGoodFriendsFeedUnit graphQLNoContentGoodFriendsFeedUnit = new GraphQLNoContentGoodFriendsFeedUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLNoContentGoodFriendsFeedUnit = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                int i2;
                if ("__type__".equals(i)) {
                    graphQLNoContentGoodFriendsFeedUnit.d = GraphQLObjectType.a(jsonParser);
                    i2 = 1;
                } else if ("fetchTimeMs".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLNoContentGoodFriendsFeedUnit.e = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLNoContentGoodFriendsFeedUnit, "fetchTimeMs", graphQLNoContentGoodFriendsFeedUnit.a_, 0, false);
                    i2 = 1;
                }
                jsonParser.f();
            }
        }
        return graphQLNoContentGoodFriendsFeedUnit;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNoContentGoodFriendsFeedUnit.class, new GraphQLNoContentGoodFriendsFeedUnitDeserializer());
    }

    public GraphQLNoContentGoodFriendsFeedUnitDeserializer() {
        a(GraphQLNoContentGoodFriendsFeedUnit.class);
    }
}
