package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: heartbleed */
public class GraphQLFindFriendsFeedUnitSerializer extends JsonSerializer<GraphQLFindFriendsFeedUnit> {
    public final void m7512a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFindFriendsFeedUnit graphQLFindFriendsFeedUnit = (GraphQLFindFriendsFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLFindFriendsFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLFindFriendsFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("fetchTimeMs", graphQLFindFriendsFeedUnit.T_());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLFindFriendsFeedUnit.class, new GraphQLFindFriendsFeedUnitSerializer());
    }
}
