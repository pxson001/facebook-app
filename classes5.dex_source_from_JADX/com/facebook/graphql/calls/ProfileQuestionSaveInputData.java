package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: previewTemplateWithPeople */
public final class ProfileQuestionSaveInputData extends GraphQlMutationCallInput {

    /* compiled from: previewTemplateWithPeople */
    public final class Privacy extends GraphQlCallInput {

        /* compiled from: previewTemplateWithPeople */
        public enum BaseState implements JsonSerializable {
            EVERYONE("EVERYONE"),
            FRIENDS("FRIENDS"),
            FRIENDS_OF_FRIENDS("FRIENDS_OF_FRIENDS"),
            SELF("SELF");
            
            protected final String serverValue;

            private BaseState(String str) {
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
}
