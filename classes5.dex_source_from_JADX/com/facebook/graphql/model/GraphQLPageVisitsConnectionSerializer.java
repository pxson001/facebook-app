package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: email_invite_join_bar */
public class GraphQLPageVisitsConnectionSerializer extends JsonSerializer<GraphQLPageVisitsConnection> {
    public final void m9550a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageVisitsConnection__JsonHelper.m9552a(jsonGenerator, (GraphQLPageVisitsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageVisitsConnection.class, new GraphQLPageVisitsConnectionSerializer());
    }
}
