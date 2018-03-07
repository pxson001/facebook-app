package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: recommending_comments */
public final class ContactBatchUploadInputData extends GraphQlMutationCallInput {

    /* compiled from: recommending_comments */
    public final class Contacts extends GraphQlCallInput {

        /* compiled from: recommending_comments */
        public final class Emails extends GraphQlCallInput {
        }

        /* compiled from: recommending_comments */
        public enum Modifier implements JsonSerializable {
            ADD("ADD"),
            REMOVE("REMOVE"),
            UPDATE("UPDATE");
            
            protected final String serverValue;

            private Modifier(String str) {
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

        /* compiled from: recommending_comments */
        public final class Phones extends GraphQlCallInput {
        }
    }
}
