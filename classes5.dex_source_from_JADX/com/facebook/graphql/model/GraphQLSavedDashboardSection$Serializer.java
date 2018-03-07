package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSavedDashboardSectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTICAL_COMPONENTS_LIST */
public final class GraphQLSavedDashboardSection$Serializer extends JsonSerializer<GraphQLSavedDashboardSection> {
    public final void m21554a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSavedDashboardSection graphQLSavedDashboardSection = (GraphQLSavedDashboardSection) obj;
        GraphQLSavedDashboardSectionDeserializer.m5861a(graphQLSavedDashboardSection.w_(), graphQLSavedDashboardSection.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLSavedDashboardSection.class, new GraphQLSavedDashboardSection$Serializer());
        FbSerializerProvider.a(GraphQLSavedDashboardSection.class, new GraphQLSavedDashboardSection$Serializer());
    }
}
