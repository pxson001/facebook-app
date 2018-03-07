package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: places_editor_review_suggestions_module */
public final class UserUpdateGenderInputData extends GraphQlMutationCallInput {

    /* compiled from: places_editor_review_suggestions_module */
    public enum NewGender implements JsonSerializable {
        UNKNOWN("UNKNOWN"),
        FEMALE("FEMALE"),
        MALE("MALE");
        
        protected final String serverValue;

        private NewGender(String str) {
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

    public final UserUpdateGenderInputData m4502a(NewGender newGender) {
        a("new_gender", newGender);
        return this;
    }
}
