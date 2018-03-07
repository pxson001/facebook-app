package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFollowUpFeedUnitsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hdAtomSize */
public final class GraphQLFollowUpFeedUnitsConnection$Serializer extends JsonSerializer<GraphQLFollowUpFeedUnitsConnection> {
    public final void m7529a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFollowUpFeedUnitsConnection graphQLFollowUpFeedUnitsConnection = (GraphQLFollowUpFeedUnitsConnection) obj;
        GraphQLFollowUpFeedUnitsConnectionDeserializer.m4924a(graphQLFollowUpFeedUnitsConnection.w_(), graphQLFollowUpFeedUnitsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFollowUpFeedUnitsConnection.class, new GraphQLFollowUpFeedUnitsConnection$Serializer());
        FbSerializerProvider.a(GraphQLFollowUpFeedUnitsConnection.class, new GraphQLFollowUpFeedUnitsConnection$Serializer());
    }
}
