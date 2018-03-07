package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: View Hierarchy Too Deep */
public class GraphQLPrivacyOptionsComposerConnectionSerializer extends JsonSerializer<GraphQLPrivacyOptionsComposerConnection> {
    public final void m20998a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyOptionsComposerConnection__JsonHelper.a(jsonGenerator, (GraphQLPrivacyOptionsComposerConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyOptionsComposerConnection.class, new GraphQLPrivacyOptionsComposerConnectionSerializer());
    }
}
