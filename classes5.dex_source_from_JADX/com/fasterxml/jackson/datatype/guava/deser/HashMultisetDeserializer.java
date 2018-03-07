package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/* compiled from: can_viewer_change_guest_status */
public class HashMultisetDeserializer extends GuavaMultisetDeserializer<HashMultiset<Object>> {
    public HashMultisetDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    public final GuavaCollectionDeserializer mo731a(TypeDeserializer typeDeserializer, JsonDeserializer jsonDeserializer) {
        return new HashMultisetDeserializer(this._containerType, typeDeserializer, jsonDeserializer);
    }

    protected final Multiset mo732e() {
        return HashMultiset.g();
    }
}
