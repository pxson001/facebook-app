package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to retrieve phone usage power stats */
public class GraphQLStoryAttachmentSerializer extends JsonSerializer<GraphQLStoryAttachment> {
    public final void m21854a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryAttachment__JsonHelper.m21863a(jsonGenerator, (GraphQLStoryAttachment) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryAttachment.class, new GraphQLStoryAttachmentSerializer());
    }
}
