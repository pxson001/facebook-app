package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VOIDED */
public class GraphQLProfileBadgeSerializer extends JsonSerializer<GraphQLProfileBadge> {
    public final void m21101a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLProfileBadge__JsonHelper.m21103a(jsonGenerator, (GraphQLProfileBadge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLProfileBadge.class, new GraphQLProfileBadgeSerializer());
    }
}
