package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFindPagesFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: header_image */
public final class GraphQLFindPagesFeedUnit$Serializer extends JsonSerializer<GraphQLFindPagesFeedUnit> {
    public final void m7518a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFindPagesFeedUnit graphQLFindPagesFeedUnit = (GraphQLFindPagesFeedUnit) obj;
        GraphQLFindPagesFeedUnitDeserializer.m4918a(graphQLFindPagesFeedUnit.w_(), graphQLFindPagesFeedUnit.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLFindPagesFeedUnit.class, new GraphQLFindPagesFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLFindPagesFeedUnit.class, new GraphQLFindPagesFeedUnit$Serializer());
    }
}
