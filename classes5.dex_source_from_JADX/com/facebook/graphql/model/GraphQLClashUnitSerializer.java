package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_current_location */
public class GraphQLClashUnitSerializer extends JsonSerializer<GraphQLClashUnit> {
    public final void m6771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLClashUnit__JsonHelper.m6773a(jsonGenerator, (GraphQLClashUnit) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLClashUnit.class, new GraphQLClashUnitSerializer());
    }
}
