package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSUPPORTED_CARRIER */
public class GraphQLTagExpansionEducationInfoSerializer extends JsonSerializer<GraphQLTagExpansionEducationInfo> {
    public final void m22035a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTagExpansionEducationInfo__JsonHelper.m22037a(jsonGenerator, (GraphQLTagExpansionEducationInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTagExpansionEducationInfo.class, new GraphQLTagExpansionEducationInfoSerializer());
    }
}
