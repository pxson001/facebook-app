package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLIconDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: followup_choices */
public final class GraphQLIcon$Serializer extends JsonSerializer<GraphQLIcon> {
    public final void m8610a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLIcon graphQLIcon = (GraphQLIcon) obj;
        GraphQLIconDeserializer.m5221a(graphQLIcon.w_(), graphQLIcon.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLIcon.class, new GraphQLIcon$Serializer());
        FbSerializerProvider.a(GraphQLIcon.class, new GraphQLIcon$Serializer());
    }
}
