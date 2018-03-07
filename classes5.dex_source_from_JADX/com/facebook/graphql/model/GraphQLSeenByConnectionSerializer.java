package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX_CITY_SUGGEST_EDITS_BUTTON */
public class GraphQLSeenByConnectionSerializer extends JsonSerializer<GraphQLSeenByConnection> {
    public final void m21632a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSeenByConnection__JsonHelper.a(jsonGenerator, (GraphQLSeenByConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSeenByConnection.class, new GraphQLSeenByConnectionSerializer());
    }
}
