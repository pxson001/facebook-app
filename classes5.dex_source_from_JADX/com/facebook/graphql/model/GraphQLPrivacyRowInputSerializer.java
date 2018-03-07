package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VideoAnnotation */
public class GraphQLPrivacyRowInputSerializer extends JsonSerializer<GraphQLPrivacyRowInput> {
    public final void m21025a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyRowInput__JsonHelper.a(jsonGenerator, (GraphQLPrivacyRowInput) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyRowInput.class, new GraphQLPrivacyRowInputSerializer());
    }
}
