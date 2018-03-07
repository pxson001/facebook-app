package com.fasterxml.jackson.datatype.guava;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.guava.deser.GuavaOptionalDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.HashMultisetDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.ImmutableBiMapDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.ImmutableListDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.ImmutableMapDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.ImmutableMultisetDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.ImmutableSetDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.ImmutableSortedMapDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.ImmutableSortedSetDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.LinkedHashMultisetDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.MultimapDeserializer;
import com.fasterxml.jackson.datatype.guava.deser.TreeMultisetDeserializer;
import com.google.common.base.Optional;
import com.google.common.collect.BiMap;
import com.google.common.collect.EnumBiMap;
import com.google.common.collect.EnumHashBiMap;
import com.google.common.collect.EnumMultiset;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.common.collect.TreeMultiset;

/* compiled from: square_profile_pic_size_huge */
public class GuavaDeserializers extends Base {
    public final JsonDeserializer<?> mo1144a(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        if (Optional.class.isAssignableFrom(javaType._class)) {
            return new GuavaOptionalDeserializer(javaType);
        }
        return super.mo1144a(javaType, deserializationConfig, beanDescription);
    }

    public final JsonDeserializer<?> mo1145a(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Class cls = collectionType._class;
        if (ImmutableCollection.class.isAssignableFrom(cls)) {
            if (ImmutableList.class.isAssignableFrom(cls)) {
                return new ImmutableListDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            if (ImmutableMultiset.class.isAssignableFrom(cls)) {
                return new ImmutableMultisetDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            if (!ImmutableSet.class.isAssignableFrom(cls)) {
                return new ImmutableListDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            if (!ImmutableSortedSet.class.isAssignableFrom(cls)) {
                return new ImmutableSetDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            if (Comparable.class.isAssignableFrom(collectionType.m6728r()._class)) {
                return new ImmutableSortedSetDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            throw new IllegalArgumentException("Can not handle ImmutableSortedSet with elements that are not Comparable<?> (" + cls.getName() + ")");
        } else if (!Multiset.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (LinkedHashMultiset.class.isAssignableFrom(cls)) {
                return new LinkedHashMultisetDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            if (HashMultiset.class.isAssignableFrom(cls)) {
                return new HashMultisetDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            EnumMultiset.class.isAssignableFrom(cls);
            if (TreeMultiset.class.isAssignableFrom(cls)) {
                return new TreeMultisetDeserializer(collectionType, typeDeserializer, jsonDeserializer);
            }
            return new HashMultisetDeserializer(collectionType, typeDeserializer, jsonDeserializer);
        }
    }

    public final JsonDeserializer<?> mo1146a(MapLikeType mapLikeType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Class cls = mapLikeType._class;
        if (ImmutableMultimap.class.isAssignableFrom(cls)) {
            ImmutableListMultimap.class.isAssignableFrom(cls);
            ImmutableSetMultimap.class.isAssignableFrom(cls);
        }
        if (Multimap.class.isAssignableFrom(cls)) {
            return new MultimapDeserializer(mapLikeType, keyDeserializer, typeDeserializer, jsonDeserializer);
        }
        Table.class.isAssignableFrom(cls);
        return null;
    }

    public final JsonDeserializer<?> mo1147a(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        Class cls = mapType._class;
        if (!ImmutableMap.class.isAssignableFrom(cls)) {
            if (BiMap.class.isAssignableFrom(cls)) {
                EnumBiMap.class.isAssignableFrom(cls);
                EnumHashBiMap.class.isAssignableFrom(cls);
                HashBiMap.class.isAssignableFrom(cls);
            }
            return null;
        } else if (ImmutableSortedMap.class.isAssignableFrom(cls)) {
            return new ImmutableSortedMapDeserializer(mapType, keyDeserializer, typeDeserializer, jsonDeserializer);
        } else {
            if (ImmutableBiMap.class.isAssignableFrom(cls)) {
                return new ImmutableBiMapDeserializer(mapType, keyDeserializer, typeDeserializer, jsonDeserializer);
            }
            return new ImmutableMapDeserializer(mapType, keyDeserializer, typeDeserializer, jsonDeserializer);
        }
    }
}
