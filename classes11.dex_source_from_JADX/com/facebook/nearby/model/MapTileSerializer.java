package com.facebook.nearby.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: updateProxy */
public class MapTileSerializer extends JsonSerializer<MapTile> {
    public final void m488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MapTile mapTile = (MapTile) obj;
        if (mapTile == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m487b(mapTile, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(MapTile.class, new MapTileSerializer());
    }

    private static void m487b(MapTile mapTile, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", mapTile.id);
        AutoGenJsonHelper.a(jsonGenerator, "creationTime", Long.valueOf(mapTile.creationTime));
        AutoGenJsonHelper.a(jsonGenerator, "timeToLiveInSeconds", Long.valueOf(mapTile.timeToLiveInSeconds));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "bounds", mapTile.bounds);
        AutoGenJsonHelper.a(jsonGenerator, "minZoom", Float.valueOf(mapTile.minZoom));
        AutoGenJsonHelper.a(jsonGenerator, "maxZoom", Float.valueOf(mapTile.maxZoom));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "places", mapTile.places);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "backgroundPlaces", mapTile.backgroundPlaces);
    }
}
