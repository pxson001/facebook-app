package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: end_of_feed */
public class GraphQLPageLikersConnectionSerializer extends JsonSerializer<GraphQLPageLikersConnection> {
    public final void m9493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageLikersConnection__JsonHelper.m9495a(jsonGenerator, (GraphQLPageLikersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageLikersConnection.class, new GraphQLPageLikersConnectionSerializer());
    }
}
