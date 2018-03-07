package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCreativePagesYouMayLikeFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is-forced-subtitle */
public final class GraphQLCreativePagesYouMayLikeFeedUnit$Serializer extends JsonSerializer<GraphQLCreativePagesYouMayLikeFeedUnit> {
    public final void m6894a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) obj;
        GraphQLCreativePagesYouMayLikeFeedUnitDeserializer.m4691a(graphQLCreativePagesYouMayLikeFeedUnit.w_(), graphQLCreativePagesYouMayLikeFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLCreativePagesYouMayLikeFeedUnit.class, new GraphQLCreativePagesYouMayLikeFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLCreativePagesYouMayLikeFeedUnit.class, new GraphQLCreativePagesYouMayLikeFeedUnit$Serializer());
    }
}
