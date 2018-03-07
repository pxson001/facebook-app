package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to retrieve bluetooth power stats */
public class GraphQLStoryAttachmentStyleInfoSerializer extends JsonSerializer<GraphQLStoryAttachmentStyleInfo> {
    public final void m21858a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryAttachmentStyleInfo__JsonHelper.m21860a(jsonGenerator, (GraphQLStoryAttachmentStyleInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryAttachmentStyleInfo.class, new GraphQLStoryAttachmentStyleInfoSerializer());
    }
}
