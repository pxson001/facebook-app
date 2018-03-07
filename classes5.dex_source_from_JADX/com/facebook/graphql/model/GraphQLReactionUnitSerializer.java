package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIETNAMESE_RESTAURANT */
public class GraphQLReactionUnitSerializer extends JsonSerializer<GraphQLReactionUnit> {
    public final void m21340a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReactionUnit__JsonHelper.m21342a(jsonGenerator, (GraphQLReactionUnit) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLReactionUnit.class, new GraphQLReactionUnitSerializer());
    }
}
