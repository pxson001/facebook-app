package com.facebook.graphql.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fbLogoBadgeCount */
public class GraphQLMapTileSerializer extends JsonSerializer<GraphQLMapTile> {
    public final void m9001a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMapTile graphQLMapTile = (GraphQLMapTile) obj;
        if (graphQLMapTile == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m9000b(graphQLMapTile, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GraphQLMapTile.class, new GraphQLMapTileSerializer());
    }

    private static void m9000b(GraphQLMapTile graphQLMapTile, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "tile_key", graphQLMapTile.id);
        AutoGenJsonHelper.a(jsonGenerator, "creation_time", Long.valueOf(graphQLMapTile.creationTime));
        AutoGenJsonHelper.a(jsonGenerator, "ttl", Long.valueOf(graphQLMapTile.timeToLiveInSeconds));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "bounds", graphQLMapTile.bounds);
        AutoGenJsonHelper.a(jsonGenerator, "min_zoom", Float.valueOf(graphQLMapTile.minZoom));
        AutoGenJsonHelper.a(jsonGenerator, "max_zoom", Float.valueOf(graphQLMapTile.maxZoom));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "placesRenderPriority1", graphQLMapTile.places);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "placesRenderPriority2", graphQLMapTile.backgroundPlaces);
    }
}
