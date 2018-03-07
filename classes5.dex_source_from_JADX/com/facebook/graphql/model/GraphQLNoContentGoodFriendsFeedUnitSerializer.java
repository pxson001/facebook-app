package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_prompt_action_button */
public class GraphQLNoContentGoodFriendsFeedUnitSerializer extends JsonSerializer<GraphQLNoContentGoodFriendsFeedUnit> {
    public final void m9281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNoContentGoodFriendsFeedUnit graphQLNoContentGoodFriendsFeedUnit = (GraphQLNoContentGoodFriendsFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNoContentGoodFriendsFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLNoContentGoodFriendsFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("fetchTimeMs", graphQLNoContentGoodFriendsFeedUnit.T_());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNoContentGoodFriendsFeedUnit.class, new GraphQLNoContentGoodFriendsFeedUnitSerializer());
    }
}
