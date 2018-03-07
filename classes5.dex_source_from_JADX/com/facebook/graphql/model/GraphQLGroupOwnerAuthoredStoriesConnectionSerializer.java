package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendEventWatchersFirst5 */
public class GraphQLGroupOwnerAuthoredStoriesConnectionSerializer extends JsonSerializer<GraphQLGroupOwnerAuthoredStoriesConnection> {
    public final void m8489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupOwnerAuthoredStoriesConnection__JsonHelper.m8491a(jsonGenerator, (GraphQLGroupOwnerAuthoredStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupOwnerAuthoredStoriesConnection.class, new GraphQLGroupOwnerAuthoredStoriesConnectionSerializer());
    }
}
