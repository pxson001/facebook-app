package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFindGroupsFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: headline_source */
public final class GraphQLFindGroupsFeedUnit$Serializer extends JsonSerializer<GraphQLFindGroupsFeedUnit> {
    public final void m7514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFindGroupsFeedUnit graphQLFindGroupsFeedUnit = (GraphQLFindGroupsFeedUnit) obj;
        GraphQLFindGroupsFeedUnitDeserializer.m4915a(graphQLFindGroupsFeedUnit.w_(), graphQLFindGroupsFeedUnit.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLFindGroupsFeedUnit.class, new GraphQLFindGroupsFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLFindGroupsFeedUnit.class, new GraphQLFindGroupsFeedUnit$Serializer());
    }
}
