package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPlaceSuggestionInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WATCHED_RECOMMENDATIONS */
public final class GraphQLPlaceSuggestionInfo$Serializer extends JsonSerializer<GraphQLPlaceSuggestionInfo> {
    public final void m20915a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceSuggestionInfo graphQLPlaceSuggestionInfo = (GraphQLPlaceSuggestionInfo) obj;
        GraphQLPlaceSuggestionInfoDeserializer.m5672a(graphQLPlaceSuggestionInfo.w_(), graphQLPlaceSuggestionInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceSuggestionInfo.class, new GraphQLPlaceSuggestionInfo$Serializer());
        FbSerializerProvider.a(GraphQLPlaceSuggestionInfo.class, new GraphQLPlaceSuggestionInfo$Serializer());
    }
}
