package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.ImmutableCollection.Builder;
import com.google.common.collect.ImmutableSet;

/* compiled from: can_viewer_append_photos */
public class ImmutableSetDeserializer extends GuavaImmutableCollectionDeserializer<ImmutableSet<Object>> {
    public ImmutableSetDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    public final GuavaCollectionDeserializer mo731a(TypeDeserializer typeDeserializer, JsonDeserializer jsonDeserializer) {
        return new ImmutableSetDeserializer(this._containerType, typeDeserializer, jsonDeserializer);
    }

    protected final Builder<Object> mo733e() {
        return ImmutableSet.builder();
    }
}
