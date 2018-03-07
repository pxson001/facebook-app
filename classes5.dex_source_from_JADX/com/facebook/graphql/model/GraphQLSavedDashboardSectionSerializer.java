package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTICAL_COMPONENTS */
public class GraphQLSavedDashboardSectionSerializer extends JsonSerializer<GraphQLSavedDashboardSection> {
    public final void m21556a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSavedDashboardSection__JsonHelper.m21558a(jsonGenerator, (GraphQLSavedDashboardSection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSavedDashboardSection.class, new GraphQLSavedDashboardSectionSerializer());
    }
}
