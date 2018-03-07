package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: featured_video */
public class GraphQLLikersOfContentConnectionSerializer extends JsonSerializer<GraphQLLikersOfContentConnection> {
    public final void m8919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLikersOfContentConnection__JsonHelper.a(jsonGenerator, (GraphQLLikersOfContentConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLikersOfContentConnection.class, new GraphQLLikersOfContentConnectionSerializer());
    }
}
