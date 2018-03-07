package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: referral */
public final class BoostedComponentEditInputData extends GraphQlMutationCallInput {

    /* compiled from: referral */
    public final class Audience extends GraphQlCallInput {

        /* compiled from: referral */
        public enum AudienceCode implements JsonSerializable {
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

            private AudienceCode(String str) {
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

        /* compiled from: referral */
        public final class TargetSpec extends GraphQlCallInput {

            /* compiled from: referral */
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

            /* compiled from: referral */
            public final class GeoLocations extends GraphQlCallInput {

                /* compiled from: referral */
                public final class CustomLocations extends GraphQlCallInput {
                }

                /* compiled from: referral */
                public enum LocationTypes implements JsonSerializable {
                    HOME("HOME"),
                    RECENT("RECENT"),
                    TRAVEL_IN("TRAVEL_IN");
                    
                    protected final String serverValue;

                    private LocationTypes(String str) {
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

        public final Audience m4329a(AudienceCode audienceCode) {
            a("audience_code", audienceCode);
            return this;
        }

        public final Audience m4330a(String str) {
            a("audience_id", str);
            return this;
        }
    }

    /* compiled from: referral */
    public enum BoostedComponentApp implements JsonSerializable {
        BOOSTED_INSTAGRAM_MEDIA_MOBILE("BOOSTED_INSTAGRAM_MEDIA_MOBILE"),
        BOOSTED_LOCAL_AWARENESS_MOBILE("BOOSTED_LOCAL_AWARENESS_MOBILE"),
        BOOSTED_PAGELIKE_MOBILE("BOOSTED_PAGELIKE_MOBILE"),
        BOOSTED_POST_MOBILE("BOOSTED_POST_MOBILE"),
        BOOSTED_WEBSITE_MOBILE("BOOSTED_WEBSITE_MOBILE"),
        BOOSTED_CCTA_MOBILE("BOOSTED_CCTA_MOBILE"),
        BOOSTED_EVENT_MOBILE("BOOSTED_EVENT_MOBILE"),
        BOOSTED_PRODUCT_MOBILE("BOOSTED_PRODUCT_MOBILE"),
        BOOSTED_DYNAMIC_PRODUCTS_MOBILE("BOOSTED_DYNAMIC_PRODUCTS_MOBILE");
        
        protected final String serverValue;

        private BoostedComponentApp(String str) {
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

    /* compiled from: referral */
    public final class Creative extends GraphQlCallInput {
    }

    /* compiled from: referral */
    public enum Status implements JsonSerializable {
        PAUSED("paused"),
        ACTIVE("active");
        
        protected final String serverValue;

        private Status(String str) {
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
