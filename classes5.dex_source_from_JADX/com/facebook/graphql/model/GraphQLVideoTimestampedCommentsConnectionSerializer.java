package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TextWithEntities */
public class GraphQLVideoTimestampedCommentsConnectionSerializer extends JsonSerializer<GraphQLVideoTimestampedCommentsConnection> {
    public final void m22471a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoTimestampedCommentsConnection__JsonHelper.m22473a(jsonGenerator, (GraphQLVideoTimestampedCommentsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoTimestampedCommentsConnection.class, new GraphQLVideoTimestampedCommentsConnectionSerializer());
    }
}
