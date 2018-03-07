package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLViewerVisitsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TaskStackBuilder */
public final class GraphQLViewerVisitsConnection$Serializer extends JsonSerializer<GraphQLViewerVisitsConnection> {
    public final void m22489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLViewerVisitsConnection graphQLViewerVisitsConnection = (GraphQLViewerVisitsConnection) obj;
        GraphQLViewerVisitsConnectionDeserializer.m6204a(graphQLViewerVisitsConnection.w_(), graphQLViewerVisitsConnection.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLViewerVisitsConnection.class, new GraphQLViewerVisitsConnection$Serializer());
        FbSerializerProvider.a(GraphQLViewerVisitsConnection.class, new GraphQLViewerVisitsConnection$Serializer());
    }
}
