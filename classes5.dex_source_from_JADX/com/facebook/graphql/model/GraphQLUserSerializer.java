package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TokenData */
public class GraphQLUserSerializer extends JsonSerializer<GraphQLUser> {
    public final void m22400a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUser__JsonHelper.a(jsonGenerator, (GraphQLUser) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLUser.class, new GraphQLUserSerializer());
    }
}
