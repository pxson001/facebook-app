package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: primary_button_step */
public final class PageServicesSectionInputData extends GraphQlMutationCallInput {

    /* compiled from: primary_button_step */
    public enum Visibility implements JsonSerializable {
        STAGING("STAGING"),
        PUBLISHED("PUBLISHED");
        
        protected final String serverValue;

        private Visibility(String str) {
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

    public final PageServicesSectionInputData m4471a(String str) {
        a("page_id", str);
        return this;
    }

    public final PageServicesSectionInputData m4470a(Visibility visibility) {
        a("visibility", visibility);
        return this;
    }
}
