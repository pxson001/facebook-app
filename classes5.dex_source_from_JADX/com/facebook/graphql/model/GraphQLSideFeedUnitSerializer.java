package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VARIANTS_PICKER */
public class GraphQLSideFeedUnitSerializer extends JsonSerializer<GraphQLSideFeedUnit> {
    public final void m21655a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSideFeedUnit__JsonHelper.m21657a(jsonGenerator, (GraphQLSideFeedUnit) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSideFeedUnit.class, new GraphQLSideFeedUnitSerializer());
    }
}
