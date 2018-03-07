package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimelineAppCollectionsConnection */
public class GraphQLVect2Serializer extends JsonSerializer<GraphQLVect2> {
    public final void m22420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVect2__JsonHelper.m22422a(jsonGenerator, (GraphQLVect2) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVect2.class, new GraphQLVect2Serializer());
    }
}
