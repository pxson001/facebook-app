package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendEventInviteesFirst5 */
public class GraphQLGroupTopStoriesFeedUnitStoriesConnectionSerializer extends JsonSerializer<GraphQLGroupTopStoriesFeedUnitStoriesConnection> {
    public final void m8505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupTopStoriesFeedUnitStoriesConnection__JsonHelper.m8507a(jsonGenerator, (GraphQLGroupTopStoriesFeedUnitStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupTopStoriesFeedUnitStoriesConnection.class, new GraphQLGroupTopStoriesFeedUnitStoriesConnectionSerializer());
    }
}
