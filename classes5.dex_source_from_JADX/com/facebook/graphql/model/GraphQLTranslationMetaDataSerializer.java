package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TrueTopicFeedOptionsConnection */
public class GraphQLTranslationMetaDataSerializer extends JsonSerializer<GraphQLTranslationMetaData> {
    public final void m22283a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTranslationMetaData__JsonHelper.m22285a(jsonGenerator, (GraphQLTranslationMetaData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTranslationMetaData.class, new GraphQLTranslationMetaDataSerializer());
    }
}
