package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLOverlayCallToActionInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: estimated_reach */
public final class GraphQLOverlayCallToActionInfo$Serializer extends JsonSerializer<GraphQLOverlayCallToActionInfo> {
    public final void m9424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOverlayCallToActionInfo graphQLOverlayCallToActionInfo = (GraphQLOverlayCallToActionInfo) obj;
        GraphQLOverlayCallToActionInfoDeserializer.m5475a(graphQLOverlayCallToActionInfo.w_(), graphQLOverlayCallToActionInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLOverlayCallToActionInfo.class, new GraphQLOverlayCallToActionInfo$Serializer());
        FbSerializerProvider.a(GraphQLOverlayCallToActionInfo.class, new GraphQLOverlayCallToActionInfo$Serializer());
    }
}
