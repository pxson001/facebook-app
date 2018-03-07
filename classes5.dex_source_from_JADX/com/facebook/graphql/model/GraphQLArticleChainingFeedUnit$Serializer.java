package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLArticleChainingFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_spherical */
public final class GraphQLArticleChainingFeedUnit$Serializer extends JsonSerializer<GraphQLArticleChainingFeedUnit> {
    public final void m6601a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLArticleChainingFeedUnit graphQLArticleChainingFeedUnit = (GraphQLArticleChainingFeedUnit) obj;
        GraphQLArticleChainingFeedUnitDeserializer.m4587a(graphQLArticleChainingFeedUnit.w_(), graphQLArticleChainingFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLArticleChainingFeedUnit.class, new GraphQLArticleChainingFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLArticleChainingFeedUnit.class, new GraphQLArticleChainingFeedUnit$Serializer());
    }
}
