package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VOICEMAIL */
public class GraphQLProfileSerializer extends JsonSerializer<GraphQLProfile> {
    public final void m21106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLProfile__JsonHelper.m21115a(jsonGenerator, (GraphQLProfile) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLProfile.class, new GraphQLProfileSerializer());
    }
}
