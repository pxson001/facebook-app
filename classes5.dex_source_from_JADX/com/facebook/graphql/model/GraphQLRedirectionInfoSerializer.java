package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_MUTED */
public class GraphQLRedirectionInfoSerializer extends JsonSerializer<GraphQLRedirectionInfo> {
    public final void m21380a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRedirectionInfo__JsonHelper.m21382a(jsonGenerator, (GraphQLRedirectionInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLRedirectionInfo.class, new GraphQLRedirectionInfoSerializer());
    }
}
