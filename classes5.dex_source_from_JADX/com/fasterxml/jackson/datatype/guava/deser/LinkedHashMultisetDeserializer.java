package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

/* compiled from: can_viewer_act_as_memorial_contact */
public class LinkedHashMultisetDeserializer extends GuavaMultisetDeserializer<LinkedHashMultiset<Object>> {
    public LinkedHashMultisetDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType, typeDeserializer, jsonDeserializer);
    }

    protected final Multiset mo732e() {
        return LinkedHashMultiset.m13472g();
    }

    public final GuavaCollectionDeserializer<LinkedHashMultiset<Object>> mo731a(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        return new LinkedHashMultisetDeserializer(this._containerType, typeDeserializer, jsonDeserializer);
    }
}
