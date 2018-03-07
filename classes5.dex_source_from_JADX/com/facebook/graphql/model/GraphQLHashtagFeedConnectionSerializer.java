package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: form-data; name=" */
public class GraphQLHashtagFeedConnectionSerializer extends JsonSerializer<GraphQLHashtagFeedConnection> {
    public final void m8600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLHashtagFeedConnection__JsonHelper.m8602a(jsonGenerator, (GraphQLHashtagFeedConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLHashtagFeedConnection.class, new GraphQLHashtagFeedConnectionSerializer());
    }
}
