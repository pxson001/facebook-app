package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStoryAttachmentStyleInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to retrieve idle power stats */
public final class GraphQLStoryAttachmentStyleInfo$Serializer extends JsonSerializer<GraphQLStoryAttachmentStyleInfo> {
    public final void m21856a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryAttachmentStyleInfo graphQLStoryAttachmentStyleInfo = (GraphQLStoryAttachmentStyleInfo) obj;
        GraphQLStoryAttachmentStyleInfoDeserializer.m5961b(graphQLStoryAttachmentStyleInfo.w_(), graphQLStoryAttachmentStyleInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryAttachmentStyleInfo.class, new GraphQLStoryAttachmentStyleInfo$Serializer());
        FbSerializerProvider.a(GraphQLStoryAttachmentStyleInfo.class, new GraphQLStoryAttachmentStyleInfo$Serializer());
    }
}
