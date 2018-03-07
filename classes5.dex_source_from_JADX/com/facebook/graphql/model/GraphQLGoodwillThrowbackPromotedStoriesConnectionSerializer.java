package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: getService */
public class GraphQLGoodwillThrowbackPromotedStoriesConnectionSerializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotedStoriesConnection> {
    public final void m8085a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackPromotedStoriesConnection__JsonHelper.m8087a(jsonGenerator, (GraphQLGoodwillThrowbackPromotedStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotedStoriesConnection.class, new GraphQLGoodwillThrowbackPromotedStoriesConnectionSerializer());
    }
}
