package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hc_unknown */
public class GraphQLFollowUpFeedUnitsConnectionSerializer extends JsonSerializer<GraphQLFollowUpFeedUnitsConnection> {
    public final void m7531a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFollowUpFeedUnitsConnection__JsonHelper.m7533a(jsonGenerator, (GraphQLFollowUpFeedUnitsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFollowUpFeedUnitsConnection.class, new GraphQLFollowUpFeedUnitsConnectionSerializer());
    }
}
