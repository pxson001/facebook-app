package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ViewerVisitsConnection */
public class GraphQLPostTranslatabilitySerializer extends JsonSerializer<GraphQLPostTranslatability> {
    public final void m20969a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPostTranslatability__JsonHelper.a(jsonGenerator, (GraphQLPostTranslatability) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPostTranslatability.class, new GraphQLPostTranslatabilitySerializer());
    }
}
