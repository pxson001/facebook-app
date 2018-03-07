package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unable to retrieve thumbnail rotation for %s */
public class GraphQLStoryActionLinkSerializer extends JsonSerializer<GraphQLStoryActionLink> {
    public final void m21846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, (GraphQLStoryActionLink) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLStoryActionLink.class, new GraphQLStoryActionLinkSerializer());
    }
}
