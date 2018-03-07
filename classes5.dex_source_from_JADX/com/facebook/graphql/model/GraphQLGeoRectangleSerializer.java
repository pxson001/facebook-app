package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_jump_header */
public class GraphQLGeoRectangleSerializer extends JsonSerializer<GraphQLGeoRectangle> {
    public final void m7765a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, (GraphQLGeoRectangle) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGeoRectangle.class, new GraphQLGeoRectangleSerializer());
    }
}
