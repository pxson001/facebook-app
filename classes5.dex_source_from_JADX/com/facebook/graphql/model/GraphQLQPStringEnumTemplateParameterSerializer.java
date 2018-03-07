package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VISITS */
public class GraphQLQPStringEnumTemplateParameterSerializer extends JsonSerializer<GraphQLQPStringEnumTemplateParameter> {
    public final void m21126a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQPStringEnumTemplateParameter graphQLQPStringEnumTemplateParameter = (GraphQLQPStringEnumTemplateParameter) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLQPStringEnumTemplateParameter.m21121a() != null) {
            jsonGenerator.a("name", graphQLQPStringEnumTemplateParameter.m21121a());
        }
        jsonGenerator.a("required", graphQLQPStringEnumTemplateParameter.m21123j());
        if (graphQLQPStringEnumTemplateParameter.m21124k() != null) {
            jsonGenerator.a("string_value", graphQLQPStringEnumTemplateParameter.m21124k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLQPStringEnumTemplateParameter.class, new GraphQLQPStringEnumTemplateParameterSerializer());
    }
}
