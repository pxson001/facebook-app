package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.ImmutableCollection.Builder;
import com.google.common.collect.ImmutableSortedSet;

/* compiled from: can_viewer_add_contributors */
public class ImmutableSortedSetDeserializer extends GuavaImmutableCollectionDeserializer<ImmutableSortedSet<Object>> {
    public ImmutableSortedSetDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    public final GuavaCollectionDeserializer mo731a(TypeDeserializer typeDeserializer, JsonDeserializer jsonDeserializer) {
        return new ImmutableSortedSetDeserializer(this._containerType, typeDeserializer, jsonDeserializer);
    }

    protected final Builder<Object> mo733e() {
        return ImmutableSortedSet.d();
    }
}
