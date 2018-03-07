package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: estimated_delivery_time_for_display */
public class GraphQLOverlayCallToActionInfoSerializer extends JsonSerializer<GraphQLOverlayCallToActionInfo> {
    public final void m9426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOverlayCallToActionInfo__JsonHelper.m9428a(jsonGenerator, (GraphQLOverlayCallToActionInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLOverlayCallToActionInfo.class, new GraphQLOverlayCallToActionInfoSerializer());
    }
}
