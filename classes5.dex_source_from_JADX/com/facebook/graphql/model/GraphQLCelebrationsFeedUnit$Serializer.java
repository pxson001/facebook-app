package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCelebrationsFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_editable */
public final class GraphQLCelebrationsFeedUnit$Serializer extends JsonSerializer<GraphQLCelebrationsFeedUnit> {
    public final void m6744a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCelebrationsFeedUnit graphQLCelebrationsFeedUnit = (GraphQLCelebrationsFeedUnit) obj;
        GraphQLCelebrationsFeedUnitDeserializer.m4642a(graphQLCelebrationsFeedUnit.w_(), graphQLCelebrationsFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLCelebrationsFeedUnit.class, new GraphQLCelebrationsFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLCelebrationsFeedUnit.class, new GraphQLCelebrationsFeedUnit$Serializer());
    }
}
