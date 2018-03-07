package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLAndroidAppConfigDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: japan_mobile_invite */
public final class GraphQLAndroidAppConfig$Serializer extends JsonSerializer<GraphQLAndroidAppConfig> {
    public final void m6537a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAndroidAppConfig graphQLAndroidAppConfig = (GraphQLAndroidAppConfig) obj;
        GraphQLAndroidAppConfigDeserializer.m4563a(graphQLAndroidAppConfig.w_(), graphQLAndroidAppConfig.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLAndroidAppConfig.class, new GraphQLAndroidAppConfig$Serializer());
        FbSerializerProvider.a(GraphQLAndroidAppConfig.class, new GraphQLAndroidAppConfig$Serializer());
    }
}
