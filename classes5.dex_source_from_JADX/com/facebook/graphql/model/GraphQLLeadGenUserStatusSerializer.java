package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_awesomizer_pyml */
public class GraphQLLeadGenUserStatusSerializer extends JsonSerializer<GraphQLLeadGenUserStatus> {
    public final void m8907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenUserStatus__JsonHelper.m8909a(jsonGenerator, (GraphQLLeadGenUserStatus) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenUserStatus.class, new GraphQLLeadGenUserStatusSerializer());
    }
}
