package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_unit_pagination_identifier */
public class GraphQLLeadGenContextPageSerializer extends JsonSerializer<GraphQLLeadGenContextPage> {
    public final void m8813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenContextPage__JsonHelper.m8815a(jsonGenerator, (GraphQLLeadGenContextPage) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenContextPage.class, new GraphQLLeadGenContextPageSerializer());
    }
}
