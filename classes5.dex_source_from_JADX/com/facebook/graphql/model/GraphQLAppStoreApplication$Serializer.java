package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAppStoreApplicationDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: item_availability */
public final class GraphQLAppStoreApplication$Serializer extends JsonSerializer<GraphQLAppStoreApplication> {
    public final void m6571a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAppStoreApplication graphQLAppStoreApplication = (GraphQLAppStoreApplication) obj;
        GraphQLAppStoreApplicationDeserializer.m4575a(graphQLAppStoreApplication.w_(), graphQLAppStoreApplication.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAppStoreApplication.class, new GraphQLAppStoreApplication$Serializer());
        FbSerializerProvider.a(GraphQLAppStoreApplication.class, new GraphQLAppStoreApplication$Serializer());
    }
}
