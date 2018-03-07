package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_tags_user_selected */
public class GraphQLApproximateCountSerializer extends JsonSerializer<GraphQLApproximateCount> {
    public final void m6598a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLApproximateCount graphQLApproximateCount = (GraphQLApproximateCount) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("count", graphQLApproximateCount.m6592a());
        jsonGenerator.a("may_exceed_count", graphQLApproximateCount.m6596j());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLApproximateCount.class, new GraphQLApproximateCountSerializer());
    }
}
