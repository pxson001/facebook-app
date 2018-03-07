package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_hide */
public class GraphQLLeadGenPageSerializer extends JsonSerializer<GraphQLLeadGenPage> {
    public final void m8891a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenPage__JsonHelper.m8893a(jsonGenerator, (GraphQLLeadGenPage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenPage.class, new GraphQLLeadGenPageSerializer());
    }
}
