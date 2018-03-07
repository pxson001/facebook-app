package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_PAUSE_RESUME_DOWNLOAD_BUTTON */
public class GraphQLRedSpaceStoryInfoSerializer extends JsonSerializer<GraphQLRedSpaceStoryInfo> {
    public final void m21374a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRedSpaceStoryInfo__JsonHelper.m21376a(jsonGenerator, (GraphQLRedSpaceStoryInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLRedSpaceStoryInfo.class, new GraphQLRedSpaceStoryInfoSerializer());
    }
}
