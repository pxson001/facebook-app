package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: five_good */
public class GraphQLInfoRequestFieldSerializer extends JsonSerializer<GraphQLInfoRequestField> {
    public final void m8683a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInfoRequestField graphQLInfoRequestField = (GraphQLInfoRequestField) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLInfoRequestField.m8677a() != null) {
            jsonGenerator.a("field_type", graphQLInfoRequestField.m8677a().toString());
        }
        if (graphQLInfoRequestField.m8679j() != null) {
            jsonGenerator.a("name", graphQLInfoRequestField.m8679j());
        }
        if (graphQLInfoRequestField.m8680k() != null) {
            jsonGenerator.a("status", graphQLInfoRequestField.m8680k().toString());
        }
        if (graphQLInfoRequestField.m8681l() != null) {
            jsonGenerator.a("url", graphQLInfoRequestField.m8681l());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLInfoRequestField.class, new GraphQLInfoRequestFieldSerializer());
    }
}
