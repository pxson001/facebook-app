package com.facebook.graphql.error;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: limit must be non-negative */
public class GraphQLErrorSerializer extends JsonSerializer<GraphQLError> {
    public final void m6244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLError graphQLError = (GraphQLError) obj;
        if (graphQLError == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m6243b(graphQLError, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GraphQLError.class, new GraphQLErrorSerializer());
    }

    private static void m6243b(GraphQLError graphQLError, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "code", Integer.valueOf(graphQLError.code));
        AutoGenJsonHelper.a(jsonGenerator, "summary", graphQLError.summary);
        AutoGenJsonHelper.a(jsonGenerator, "description", graphQLError.description);
        AutoGenJsonHelper.a(jsonGenerator, "is_silent", Boolean.valueOf(graphQLError.isSilent));
        AutoGenJsonHelper.a(jsonGenerator, "is_transient", Boolean.valueOf(graphQLError.isTransient));
        AutoGenJsonHelper.a(jsonGenerator, "requires_reauth", Boolean.valueOf(graphQLError.requiresReauth));
        AutoGenJsonHelper.a(jsonGenerator, "debug_info", graphQLError.debugInfo);
        AutoGenJsonHelper.a(jsonGenerator, "query_path", graphQLError.queryPath);
    }
}
