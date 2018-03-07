package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSavedCollectionFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VETERINARIAN */
public final class GraphQLSavedCollectionFeedUnit$Serializer extends JsonSerializer<GraphQLSavedCollectionFeedUnit> {
    public final void m21533a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) obj;
        GraphQLSavedCollectionFeedUnitDeserializer.m5853a(graphQLSavedCollectionFeedUnit.w_(), graphQLSavedCollectionFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSavedCollectionFeedUnit.class, new GraphQLSavedCollectionFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLSavedCollectionFeedUnit.class, new GraphQLSavedCollectionFeedUnit$Serializer());
    }
}
