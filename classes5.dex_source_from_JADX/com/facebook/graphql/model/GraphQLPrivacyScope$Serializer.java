package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivacyScopeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Video Call */
public final class GraphQLPrivacyScope$Serializer extends JsonSerializer<GraphQLPrivacyScope> {
    public final void m21030a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivacyScope graphQLPrivacyScope = (GraphQLPrivacyScope) obj;
        GraphQLPrivacyScopeDeserializer.m5707a(graphQLPrivacyScope.w_(), graphQLPrivacyScope.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivacyScope.class, new GraphQLPrivacyScope$Serializer());
        FbSerializerProvider.a(GraphQLPrivacyScope.class, new GraphQLPrivacyScope$Serializer());
    }
}
