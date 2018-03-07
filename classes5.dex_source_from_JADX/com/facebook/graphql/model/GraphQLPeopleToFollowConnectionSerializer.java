package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WORK_NEWSFEED_NUX */
public class GraphQLPeopleToFollowConnectionSerializer extends JsonSerializer<GraphQLPeopleToFollowConnection> {
    public final void m20639a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPeopleToFollowConnection__JsonHelper.m20641a(jsonGenerator, (GraphQLPeopleToFollowConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPeopleToFollowConnection.class, new GraphQLPeopleToFollowConnectionSerializer());
    }
}
