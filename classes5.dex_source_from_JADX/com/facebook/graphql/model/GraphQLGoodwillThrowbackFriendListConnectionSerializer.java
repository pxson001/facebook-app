package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: global_usage_summary_sentence */
public class GraphQLGoodwillThrowbackFriendListConnectionSerializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendListConnection> {
    public final void m8000a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillThrowbackFriendListConnection__JsonHelper.m8002a(jsonGenerator, (GraphQLGoodwillThrowbackFriendListConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendListConnection.class, new GraphQLGoodwillThrowbackFriendListConnectionSerializer());
    }
}
