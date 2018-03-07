package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: gametime_team_page_recent_matches */
public class GraphQLGraphSearchQueryFilterValueSerializer extends JsonSerializer<GraphQLGraphSearchQueryFilterValue> {
    public final void m8246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGraphSearchQueryFilterValue__JsonHelper.m8248a(jsonGenerator, (GraphQLGraphSearchQueryFilterValue) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGraphSearchQueryFilterValue.class, new GraphQLGraphSearchQueryFilterValueSerializer());
    }
}
