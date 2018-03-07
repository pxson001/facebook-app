package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UI_THREAD */
public class GraphQLTopReactionsConnectionSerializer extends JsonSerializer<GraphQLTopReactionsConnection> {
    public final void m22251a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopReactionsConnection__JsonHelper.a(jsonGenerator, (GraphQLTopReactionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTopReactionsConnection.class, new GraphQLTopReactionsConnectionSerializer());
    }
}
