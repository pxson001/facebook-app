package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: previewTemplateWithPeopleAtPlace */
public final class ProfileIntroCardSetInputData extends GraphQlMutationCallInput {

    /* compiled from: previewTemplateWithPeopleAtPlace */
    public enum PublishBioFeedStory implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private PublishBioFeedStory(String str) {
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
