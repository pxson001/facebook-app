package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_CHANNEL_FEED_UNIT */
public class GraphQLReshareEducationInfoSerializer extends JsonSerializer<GraphQLReshareEducationInfo> {
    public final void m21495a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReshareEducationInfo__JsonHelper.m21497a(jsonGenerator, (GraphQLReshareEducationInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLReshareEducationInfo.class, new GraphQLReshareEducationInfoSerializer());
    }
}
