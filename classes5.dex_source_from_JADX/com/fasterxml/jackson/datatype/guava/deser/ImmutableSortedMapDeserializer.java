package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSortedMap;

/* compiled from: can_viewer_add_tags */
public class ImmutableSortedMapDeserializer extends GuavaImmutableMapDeserializer<ImmutableSortedMap<Object, Object>> {
    public ImmutableSortedMapDeserializer(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(mapType, keyDeserializer, typeDeserializer, jsonDeserializer);
    }

    protected final Builder<Object, Object> m12028e() {
        return ImmutableSortedMap.b();
    }

    public final GuavaMapDeserializer<ImmutableSortedMap<Object, Object>> m12027a(KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        return new ImmutableSortedMapDeserializer(this.a, keyDeserializer, typeDeserializer, jsonDeserializer);
    }
}
