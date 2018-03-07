package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isFeedOnlyPost */
public class GraphQLContactPointSerializer extends JsonSerializer<GraphQLContactPoint> {
    public final void m6873a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLContactPoint__JsonHelper.m6875a(jsonGenerator, (GraphQLContactPoint) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLContactPoint.class, new GraphQLContactPointSerializer());
    }
}
