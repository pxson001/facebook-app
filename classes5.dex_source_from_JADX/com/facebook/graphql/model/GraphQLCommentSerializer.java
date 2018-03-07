package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_all_day */
public class GraphQLCommentSerializer extends JsonSerializer<GraphQLComment> {
    public final void m6812a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLComment__JsonHelper.a(jsonGenerator, (GraphQLComment) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLComment.class, new GraphQLCommentSerializer());
    }
}
