package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: launch_point_liked_pages */
public class GraphQLAYMTTipSerializer extends JsonSerializer<GraphQLAYMTTip> {
    public final void m6386a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAYMTTip__JsonHelper.m6388a(jsonGenerator, (GraphQLAYMTTip) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAYMTTip.class, new GraphQLAYMTTipSerializer());
    }
}
