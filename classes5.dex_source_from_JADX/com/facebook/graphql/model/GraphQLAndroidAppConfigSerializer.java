package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: japan_ci_friends_suggestion */
public class GraphQLAndroidAppConfigSerializer extends JsonSerializer<GraphQLAndroidAppConfig> {
    public final void m6539a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAndroidAppConfig__JsonHelper.m6541a(jsonGenerator, (GraphQLAndroidAppConfig) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAndroidAppConfig.class, new GraphQLAndroidAppConfigSerializer());
    }
}
