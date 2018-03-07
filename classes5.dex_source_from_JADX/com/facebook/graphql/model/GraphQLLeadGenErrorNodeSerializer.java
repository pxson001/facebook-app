package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_share_link */
public class GraphQLLeadGenErrorNodeSerializer extends JsonSerializer<GraphQLLeadGenErrorNode> {
    public final void m8832a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenErrorNode__JsonHelper.m8834a(jsonGenerator, (GraphQLLeadGenErrorNode) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenErrorNode.class, new GraphQLLeadGenErrorNodeSerializer());
    }
}
