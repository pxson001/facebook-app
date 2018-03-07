package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.Multiset;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.TreeMultiset;

/* compiled from: can_user_edit_rsvp_status_of_guest */
public class TreeMultisetDeserializer extends GuavaMultisetDeserializer<TreeMultiset<Object>> {
    public TreeMultisetDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    public final GuavaCollectionDeserializer<TreeMultiset<Object>> mo731a(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        return new TreeMultisetDeserializer(this._containerType, typeDeserializer, jsonDeserializer);
    }

    protected final Multiset mo732e() {
        return new TreeMultiset(NaturalOrdering.a);
    }
}
