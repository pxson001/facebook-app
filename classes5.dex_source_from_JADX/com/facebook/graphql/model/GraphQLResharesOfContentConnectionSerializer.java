package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_CHAINING */
public class GraphQLResharesOfContentConnectionSerializer extends JsonSerializer<GraphQLResharesOfContentConnection> {
    public final void m21503a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLResharesOfContentConnection__JsonHelper.m21505a(jsonGenerator, (GraphQLResharesOfContentConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLResharesOfContentConnection.class, new GraphQLResharesOfContentConnectionSerializer());
    }
}
