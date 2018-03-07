package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.ImmutableCollection.Builder;
import com.google.common.collect.ImmutableList;

/* compiled from: can_viewer_change_availability */
public class ImmutableListDeserializer extends GuavaImmutableCollectionDeserializer<ImmutableList<Object>> {
    public ImmutableListDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    public final GuavaCollectionDeserializer mo731a(TypeDeserializer typeDeserializer, JsonDeserializer jsonDeserializer) {
        return new ImmutableListDeserializer(this._containerType, typeDeserializer, jsonDeserializer);
    }

    protected final Builder mo733e() {
        return ImmutableList.builder();
    }
}
