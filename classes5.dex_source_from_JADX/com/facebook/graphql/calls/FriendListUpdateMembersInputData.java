package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymlTitle */
public final class FriendListUpdateMembersInputData extends GraphQlMutationCallInput {

    /* compiled from: pymlTitle */
    public enum ListType implements JsonSerializable {
        GOOD_FRIENDS("GOOD_FRIENDS"),
        CLOSE_FRIENDS("CLOSE_FRIENDS"),
        ACQUAINTANCES("ACQUAINTANCES"),
        RESTRICTED("RESTRICTED"),
        USER_CREATED("USER_CREATED"),
        EDUCATION("EDUCATION"),
        WORK("WORK"),
        CURRENT_CITY("CURRENT_CITY"),
        FAMILY("FAMILY"),
        SUBSCRIBEES("SUBSCRIBEES"),
        GAMER_FRIENDS("GAMER_FRIENDS"),
        APP_CREATED("APP_CREATED"),
        QUERY_SNAPSHOT("QUERY_SNAPSHOT");
        
        protected final String serverValue;

        private ListType(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }
}
