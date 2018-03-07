package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: errno */
public class GraphQLPYMLWithLargeImageFeedUnitsConnectionSerializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnitsConnection> {
    public final void m9451a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnitsConnection__JsonHelper.m9453a(jsonGenerator, (GraphQLPYMLWithLargeImageFeedUnitsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnitsConnection.class, new GraphQLPYMLWithLargeImageFeedUnitsConnectionSerializer());
    }
}
