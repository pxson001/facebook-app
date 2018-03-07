package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.ImmutableCollection.Builder;
import com.google.common.collect.ImmutableMultiset;

/* compiled from: can_viewer_block */
public class ImmutableMultisetDeserializer extends GuavaImmutableCollectionDeserializer<ImmutableMultiset<Object>> {
    public ImmutableMultisetDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    public final GuavaCollectionDeserializer<ImmutableMultiset<Object>> mo731a(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        return new ImmutableMultisetDeserializer(this._containerType, typeDeserializer, jsonDeserializer);
    }

    protected final Builder<Object> mo733e() {
        return new ImmutableMultiset.Builder();
    }
}
