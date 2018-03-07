package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is-default */
public final class GraphQLCreativePagesYouMayLikeFeedUnitItem$Serializer extends JsonSerializer<GraphQLCreativePagesYouMayLikeFeedUnitItem> {
    public final void m6897a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem = (GraphQLCreativePagesYouMayLikeFeedUnitItem) obj;
        GraphQLCreativePagesYouMayLikeFeedUnitItemDeserializer.m4696b(graphQLCreativePagesYouMayLikeFeedUnitItem.w_(), graphQLCreativePagesYouMayLikeFeedUnitItem.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLCreativePagesYouMayLikeFeedUnitItem.class, new GraphQLCreativePagesYouMayLikeFeedUnitItem$Serializer());
        FbSerializerProvider.a(GraphQLCreativePagesYouMayLikeFeedUnitItem.class, new GraphQLCreativePagesYouMayLikeFeedUnitItem$Serializer());
    }
}
