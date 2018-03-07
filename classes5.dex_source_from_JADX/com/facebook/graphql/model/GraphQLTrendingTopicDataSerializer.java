package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TranslationMetaData */
public class GraphQLTrendingTopicDataSerializer extends JsonSerializer<GraphQLTrendingTopicData> {
    public final void m22300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTrendingTopicData__JsonHelper.m22302a(jsonGenerator, (GraphQLTrendingTopicData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTrendingTopicData.class, new GraphQLTrendingTopicDataSerializer());
    }
}
