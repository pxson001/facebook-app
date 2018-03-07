package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryAttachmentDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to retrieve radio power stats */
public final class GraphQLStoryAttachment$Serializer extends JsonSerializer<GraphQLStoryAttachment> {
    public final void m21852a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        GraphQLStoryAttachmentDeserializer.m5957b(graphQLStoryAttachment.w_(), graphQLStoryAttachment.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryAttachment.class, new GraphQLStoryAttachment$Serializer());
        FbSerializerProvider.a(GraphQLStoryAttachment.class, new GraphQLStoryAttachment$Serializer());
    }
}
