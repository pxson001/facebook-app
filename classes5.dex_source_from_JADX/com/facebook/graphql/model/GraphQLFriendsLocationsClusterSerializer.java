package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: has_funding_source */
public class GraphQLFriendsLocationsClusterSerializer extends JsonSerializer<GraphQLFriendsLocationsCluster> {
    public final void m7629a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFriendsLocationsCluster__JsonHelper.m7631a(jsonGenerator, (GraphQLFriendsLocationsCluster) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFriendsLocationsCluster.class, new GraphQLFriendsLocationsClusterSerializer());
    }
}
