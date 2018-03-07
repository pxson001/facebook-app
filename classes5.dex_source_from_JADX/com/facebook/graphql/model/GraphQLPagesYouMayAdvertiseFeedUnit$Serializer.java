package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPagesYouMayAdvertiseFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: emailSignInOptions */
public final class GraphQLPagesYouMayAdvertiseFeedUnit$Serializer extends JsonSerializer<GraphQLPagesYouMayAdvertiseFeedUnit> {
    public final void m9557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) obj;
        GraphQLPagesYouMayAdvertiseFeedUnitDeserializer.m5538a(graphQLPagesYouMayAdvertiseFeedUnit.w_(), graphQLPagesYouMayAdvertiseFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPagesYouMayAdvertiseFeedUnit.class, new GraphQLPagesYouMayAdvertiseFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPagesYouMayAdvertiseFeedUnit.class, new GraphQLPagesYouMayAdvertiseFeedUnit$Serializer());
    }
}
