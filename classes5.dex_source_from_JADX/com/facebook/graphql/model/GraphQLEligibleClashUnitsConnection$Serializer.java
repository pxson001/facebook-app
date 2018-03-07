package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLEligibleClashUnitsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_feather */
public final class GraphQLEligibleClashUnitsConnection$Serializer extends JsonSerializer<GraphQLEligibleClashUnitsConnection> {
    public final void m6987a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEligibleClashUnitsConnection graphQLEligibleClashUnitsConnection = (GraphQLEligibleClashUnitsConnection) obj;
        GraphQLEligibleClashUnitsConnectionDeserializer.m4730a(graphQLEligibleClashUnitsConnection.w_(), graphQLEligibleClashUnitsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLEligibleClashUnitsConnection.class, new GraphQLEligibleClashUnitsConnection$Serializer());
        FbSerializerProvider.a(GraphQLEligibleClashUnitsConnection.class, new GraphQLEligibleClashUnitsConnection$Serializer());
    }
}
