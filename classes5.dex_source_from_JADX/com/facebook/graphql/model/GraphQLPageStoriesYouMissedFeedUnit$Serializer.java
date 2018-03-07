package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageStoriesYouMissedFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enable_ad_network_bridging */
public final class GraphQLPageStoriesYouMissedFeedUnit$Serializer extends JsonSerializer<GraphQLPageStoriesYouMissedFeedUnit> {
    public final void m9524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageStoriesYouMissedFeedUnit graphQLPageStoriesYouMissedFeedUnit = (GraphQLPageStoriesYouMissedFeedUnit) obj;
        GraphQLPageStoriesYouMissedFeedUnitDeserializer.m5526a(graphQLPageStoriesYouMissedFeedUnit.w_(), graphQLPageStoriesYouMissedFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnit.class, new GraphQLPageStoriesYouMissedFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLPageStoriesYouMissedFeedUnit.class, new GraphQLPageStoriesYouMissedFeedUnit$Serializer());
    }
}
