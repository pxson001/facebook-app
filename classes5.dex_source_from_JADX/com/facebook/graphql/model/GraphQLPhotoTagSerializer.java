package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WILDE_GROUP_PROFILE_UPSELL */
public class GraphQLPhotoTagSerializer extends JsonSerializer<GraphQLPhotoTag> {
    public final void m20743a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPhotoTag__JsonHelper.m20745a(jsonGenerator, (GraphQLPhotoTag) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPhotoTag.class, new GraphQLPhotoTagSerializer());
    }
}
