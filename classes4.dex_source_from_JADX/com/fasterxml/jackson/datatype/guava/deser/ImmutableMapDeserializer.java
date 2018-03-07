package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: getPages */
public class ImmutableMapDeserializer extends GuavaImmutableMapDeserializer<ImmutableMap<Object, Object>> {
    public ImmutableMapDeserializer(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(mapType, keyDeserializer, typeDeserializer, jsonDeserializer);
    }

    public final GuavaMapDeserializer mo830a(KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer jsonDeserializer) {
        return new ImmutableMapDeserializer(this.f11105a, keyDeserializer, typeDeserializer, jsonDeserializer);
    }

    protected final Builder<Object, Object> mo831e() {
        return ImmutableMap.builder();
    }
}
