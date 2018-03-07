package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: preview_payload */
public final class ProductionPromptDismissInputData extends GraphQlMutationCallInput {

    /* compiled from: preview_payload */
    public enum UserAction implements JsonSerializable {
        POSTSUGG("post-sugg"),
        POSTNOSUGG("post-no-sugg"),
        IMPRESSION("impression"),
        DEIMPRESSION("deimpression"),
        ADD("add"),
        XOUT("x-out"),
        OGTAGGERCLICK("og-tagger-click"),
        HIDE("hide"),
        EXPIRED("expired"),
        UNDO_DISMISS("undo_dismiss");
        
        protected final String serverValue;

        private UserAction(String str) {
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
