package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;

/* compiled from: state_lock */
public interface Deserializers {

    /* compiled from: state_lock */
    public class Base implements Deserializers {
        public final JsonDeserializer<?> mo1148a() {
            return null;
        }

        public JsonDeserializer<?> mo1145a(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
            return null;
        }

        public final JsonDeserializer<?> mo1149b() {
            return null;
        }

        public JsonDeserializer<?> mo1147a(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
            return null;
        }

        public JsonDeserializer<?> mo1146a(MapLikeType mapLikeType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
            return null;
        }

        public final JsonDeserializer<?> mo1150c() {
            return null;
        }

        public final JsonDeserializer<?> mo1151d() {
            return null;
        }

        public JsonDeserializer<?> mo1144a(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
            return null;
        }
    }

    JsonDeserializer<?> mo1148a();

    JsonDeserializer<?> mo1144a(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription);

    JsonDeserializer<?> mo1145a(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer);

    JsonDeserializer<?> mo1146a(MapLikeType mapLikeType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer);

    JsonDeserializer<?> mo1147a(MapType mapType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer);

    JsonDeserializer<?> mo1149b();

    JsonDeserializer<?> mo1150c();

    JsonDeserializer<?> mo1151d();
}
