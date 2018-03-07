package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: extra_disable_video */
public class GraphQLNameSerializer extends JsonSerializer<GraphQLName> {
    public final void m9155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLName__JsonHelper.a(jsonGenerator, (GraphQLName) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLName.class, new GraphQLNameSerializer());
    }
}
