package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNAVAILABLE */
public class GraphQLTopLevelCommentsConnectionSerializer extends JsonSerializer<GraphQLTopLevelCommentsConnection> {
    public final void m22247a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopLevelCommentsConnection__JsonHelper.a(jsonGenerator, (GraphQLTopLevelCommentsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTopLevelCommentsConnection.class, new GraphQLTopLevelCommentsConnectionSerializer());
    }
}
