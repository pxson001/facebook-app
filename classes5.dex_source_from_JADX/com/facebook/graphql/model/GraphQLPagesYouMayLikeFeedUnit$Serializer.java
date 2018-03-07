package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPagesYouMayLikeFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: eglInitialize */
public final class GraphQLPagesYouMayLikeFeedUnit$Serializer extends JsonSerializer<GraphQLPagesYouMayLikeFeedUnit> {
    public final void m9576a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) obj;
        GraphQLPagesYouMayLikeFeedUnitDeserializer.m5545a(graphQLPagesYouMayLikeFeedUnit.w_(), graphQLPagesYouMayLikeFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnit.class, new GraphQLPagesYouMayLikeFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnit.class, new GraphQLPagesYouMayLikeFeedUnit$Serializer());
    }
}
