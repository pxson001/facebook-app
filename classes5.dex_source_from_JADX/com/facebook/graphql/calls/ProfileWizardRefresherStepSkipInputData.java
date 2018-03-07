package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: prepay_account_balance */
public final class ProfileWizardRefresherStepSkipInputData extends GraphQlMutationCallInput {

    /* compiled from: prepay_account_balance */
    public enum StepType implements JsonSerializable {
        COMPOSER("COMPOSER"),
        CORE_PROFILE_FIELD("CORE_PROFILE_FIELD"),
        COVER_PHOTO("COVER_PHOTO"),
        PROFILE_PICTURE("PROFILE_PICTURE"),
        INTRO_CARD_BIO("INTRO_CARD_BIO"),
        INTRO_CARD_FEATURED_PHOTOS("INTRO_CARD_FEATURED_PHOTOS");
        
        protected final String serverValue;

        private StepType(String str) {
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
