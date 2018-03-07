package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLContactDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isIncompleteData */
public final class GraphQLContact$Serializer extends JsonSerializer<GraphQLContact> {
    public final void m6862a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLContact graphQLContact = (GraphQLContact) obj;
        GraphQLContactDeserializer.m4679a(graphQLContact.w_(), graphQLContact.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLContact.class, new GraphQLContact$Serializer());
        FbSerializerProvider.a(GraphQLContact.class, new GraphQLContact$Serializer());
    }
}
