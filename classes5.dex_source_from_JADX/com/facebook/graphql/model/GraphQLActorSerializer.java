package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: lat_long_list */
public class GraphQLActorSerializer extends JsonSerializer<GraphQLActor> {
    public final void m6399a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLActor__JsonHelper.a(jsonGenerator, (GraphQLActor) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLActor.class, new GraphQLActorSerializer());
    }
}
