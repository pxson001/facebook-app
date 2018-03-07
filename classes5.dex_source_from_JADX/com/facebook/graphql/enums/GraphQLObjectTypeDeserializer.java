package com.facebook.graphql.enums;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mLastName */
public class GraphQLObjectTypeDeserializer extends FbJsonDeserializer {
    public Object m6223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLObjectType graphQLObjectType = new GraphQLObjectType();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLObjectType = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String str = null;
                if ("name".equals(i)) {
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                        str = jsonParser.o();
                    }
                    graphQLObjectType.name = ObjectType.a(ObjectType.a(str));
                }
                jsonParser.f();
            }
            graphQLObjectType = graphQLObjectType.f();
        }
        return graphQLObjectType;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLObjectType.class, new GraphQLObjectTypeDeserializer());
    }

    public GraphQLObjectTypeDeserializer() {
        a(GraphQLObjectType.class);
    }
}
