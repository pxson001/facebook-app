package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: guided_tour */
public class GraphQLFullIndexEducationInfoSerializer extends JsonSerializer<GraphQLFullIndexEducationInfo> {
    public final void m7661a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFullIndexEducationInfo__JsonHelper.m7663a(jsonGenerator, (GraphQLFullIndexEducationInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFullIndexEducationInfo.class, new GraphQLFullIndexEducationInfoSerializer());
    }
}
