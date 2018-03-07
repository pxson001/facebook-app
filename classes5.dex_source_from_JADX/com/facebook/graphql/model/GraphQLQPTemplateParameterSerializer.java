package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VISA */
public class GraphQLQPTemplateParameterSerializer extends JsonSerializer<GraphQLQPTemplateParameter> {
    public final void m21137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQPTemplateParameter__JsonHelper.m21139a(jsonGenerator, (GraphQLQPTemplateParameter) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLQPTemplateParameter.class, new GraphQLQPTemplateParameterSerializer());
    }
}
