package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: can_viewer_change_cover_photo */
public class ImmutableBiMapDeserializer extends GuavaImmutableMapDeserializer<ImmutableBiMap<Object, Object>> {
    public ImmutableBiMapDeserializer(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(mapType, keyDeserializer, typeDeserializer, jsonDeserializer);
    }

    protected final Builder<Object, Object> m12020e() {
        return ImmutableBiMap.d();
    }

    public final GuavaMapDeserializer<ImmutableBiMap<Object, Object>> m12019a(KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        return new ImmutableBiMapDeserializer(this.a, keyDeserializer, typeDeserializer, jsonDeserializer);
    }
}
