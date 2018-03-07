package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGeoRectangleDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: group_leaderboard */
public final class GraphQLGeoRectangle$Serializer extends JsonSerializer<GraphQLGeoRectangle> {
    public final void m7763a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGeoRectangle graphQLGeoRectangle = (GraphQLGeoRectangle) obj;
        GraphQLGeoRectangleDeserializer.m4995a(graphQLGeoRectangle.w_(), graphQLGeoRectangle.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLGeoRectangle.class, new GraphQLGeoRectangle$Serializer());
        FbSerializerProvider.a(GraphQLGeoRectangle.class, new GraphQLGeoRectangle$Serializer());
    }
}
