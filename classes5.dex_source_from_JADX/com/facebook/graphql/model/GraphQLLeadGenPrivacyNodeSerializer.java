package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_cover_config */
public class GraphQLLeadGenPrivacyNodeSerializer extends JsonSerializer<GraphQLLeadGenPrivacyNode> {
    public final void m8901a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenPrivacyNode__JsonHelper.m8903a(jsonGenerator, (GraphQLLeadGenPrivacyNode) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenPrivacyNode.class, new GraphQLLeadGenPrivacyNodeSerializer());
    }
}
