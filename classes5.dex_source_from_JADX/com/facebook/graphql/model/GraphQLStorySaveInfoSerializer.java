package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to allocate row to hold data. */
public class GraphQLStorySaveInfoSerializer extends JsonSerializer<GraphQLStorySaveInfo> {
    public final void m21884a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStorySaveInfo__JsonHelper.m21886a(jsonGenerator, (GraphQLStorySaveInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStorySaveInfo.class, new GraphQLStorySaveInfoSerializer());
    }
}
