package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_age_restricted */
public class GraphQLCommentsConnectionSerializer extends JsonSerializer<GraphQLCommentsConnection> {
    public final void m6818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCommentsConnection__JsonHelper.m6820a(jsonGenerator, (GraphQLCommentsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLCommentsConnection.class, new GraphQLCommentsConnectionSerializer());
    }
}
