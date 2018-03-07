package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_nearby_friends_self_view_context_menu */
public class GraphQLEditHistoryConnectionSerializer extends JsonSerializer<GraphQLEditHistoryConnection> {
    public final void m6967a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEditHistoryConnection__JsonHelper.a(jsonGenerator, (GraphQLEditHistoryConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEditHistoryConnection.class, new GraphQLEditHistoryConnectionSerializer());
    }
}
