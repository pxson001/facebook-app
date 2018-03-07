package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCustomizedStoryDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_post_checkin_upload_photo */
public final class GraphQLCustomizedStory$Serializer extends JsonSerializer<GraphQLCustomizedStory> {
    public final void m6927a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) obj;
        GraphQLCustomizedStoryDeserializer.m4705a(graphQLCustomizedStory.w_(), graphQLCustomizedStory.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLCustomizedStory.class, new GraphQLCustomizedStory$Serializer());
        FbSerializerProvider.a(GraphQLCustomizedStory.class, new GraphQLCustomizedStory$Serializer());
    }
}
