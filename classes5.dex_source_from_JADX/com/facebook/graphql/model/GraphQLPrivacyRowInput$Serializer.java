package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyRowInputDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VideoChannel */
public final class GraphQLPrivacyRowInput$Serializer extends JsonSerializer<GraphQLPrivacyRowInput> {
    public final void m21023a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyRowInput graphQLPrivacyRowInput = (GraphQLPrivacyRowInput) obj;
        GraphQLPrivacyRowInputDeserializer.a(graphQLPrivacyRowInput.w_(), graphQLPrivacyRowInput.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyRowInput.class, new GraphQLPrivacyRowInput$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyRowInput.class, new GraphQLPrivacyRowInput$Serializer());
    }
}
