package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: reg */
public final class BoostInfoEditTargetingInputData extends GraphQlMutationCallInput {

    /* compiled from: reg */
    public enum AudienceOption implements JsonSerializable {
        GROUPER("GROUPER"),
        NCPP("NCPP"),
        CUSTOM_AUDIENCE("CUSTOM_AUDIENCE"),
        LOOKALIKE("LOOKALIKE"),
        ENGAGED("ENGAGED"),
        FANS("FANS"),
        LOCAL("LOCAL"),
        IG_PROMOTED_POST_AUTO("IG_PROMOTED_POST_AUTO"),
        SAVED_AUDIENCE("SAVED_AUDIENCE");
        
        protected final String serverValue;

        private AudienceOption(String str) {
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

    /* compiled from: reg */
    public final class CustomTargeting extends GraphQlCallInput {

        /* compiled from: reg */
        public enum Genders implements JsonSerializable {
            MALE("MALE"),
            FEMALE("FEMALE");
            
            protected final String serverValue;

            private Genders(String str) {
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

        /* compiled from: reg */
        public final class GeoLocations extends GraphQlCallInput {
        }
    }
}
