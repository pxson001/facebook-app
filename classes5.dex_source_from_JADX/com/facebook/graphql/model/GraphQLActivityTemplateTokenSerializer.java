package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: launch_point_discover_pyml */
public class GraphQLActivityTemplateTokenSerializer extends JsonSerializer<GraphQLActivityTemplateToken> {
    public final void m6393a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLActivityTemplateToken__JsonHelper.m6395a(jsonGenerator, (GraphQLActivityTemplateToken) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLActivityTemplateToken.class, new GraphQLActivityTemplateTokenSerializer());
    }
}
