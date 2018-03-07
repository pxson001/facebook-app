package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VideoTimestampedCommentsConnection */
public class GraphQLPrivacyOptionsContentConnectionSerializer extends JsonSerializer<GraphQLPrivacyOptionsContentConnection> {
    public final void m21008a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsContentConnection__JsonHelper.m21010a(jsonGenerator, (GraphQLPrivacyOptionsContentConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsContentConnection.class, new GraphQLPrivacyOptionsContentConnectionSerializer());
    }
}
