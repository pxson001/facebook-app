package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: refresh */
public final class BoostedComponentCreateInputData extends GraphQlMutationCallInput {

    /* compiled from: refresh */
    public final class Audience extends GraphQlCallInput {

        /* compiled from: refresh */
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

        /* compiled from: refresh */
        public final class TargetSpec extends GraphQlCallInput {

            /* compiled from: refresh */
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

            /* compiled from: refresh */
            public final class GeoLocations extends GraphQlCallInput {

                /* compiled from: refresh */
                public final class CustomLocations extends GraphQlCallInput {
                }

                /* compiled from: refresh */
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

        public final Audience m4318a(AudienceCode audienceCode) {
            a("audience_code", audienceCode);
            return this;
        }

        public final Audience m4319a(TargetSpec targetSpec) {
            a("target_spec", targetSpec);
            return this;
        }

        public final Audience m4320a(String str) {
            a("audience_id", str);
            return this;
        }
    }

    /* compiled from: refresh */
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

    /* compiled from: refresh */
    public final class Creative extends GraphQlCallInput {

        /* compiled from: refresh */
        public final class ObjectStorySpec extends GraphQlCallInput {

            /* compiled from: refresh */
            public final class LinkData extends GraphQlCallInput {

                /* compiled from: refresh */
                public final class CallToAction extends GraphQlCallInput {

                    /* compiled from: refresh */
                    public enum Type implements JsonSerializable {
                        OPEN_LINK("OPEN_LINK"),
                        LIKE_PAGE("LIKE_PAGE"),
                        SHOP_NOW("SHOP_NOW"),
                        PLAY_GAME("PLAY_GAME"),
                        INSTALL_APP("INSTALL_APP"),
                        USE_APP("USE_APP"),
                        CALL("CALL"),
                        CALL_ME("CALL_ME"),
                        INSTALL_MOBILE_APP("INSTALL_MOBILE_APP"),
                        INSTALL_FREE_MOBILE_APP("INSTALL_FREE_MOBILE_APP"),
                        USE_MOBILE_APP("USE_MOBILE_APP"),
                        MOBILE_DOWNLOAD("MOBILE_DOWNLOAD"),
                        BOOK_TRAVEL("BOOK_TRAVEL"),
                        LISTEN_MUSIC("LISTEN_MUSIC"),
                        WATCH_VIDEO("WATCH_VIDEO"),
                        LEARN_MORE("LEARN_MORE"),
                        SIGN_UP("SIGN_UP"),
                        DOWNLOAD("DOWNLOAD"),
                        WATCH_MORE("WATCH_MORE"),
                        NO_BUTTON("NO_BUTTON"),
                        VISIT_PAGES_FEED("VISIT_PAGES_FEED"),
                        MISSED_CALL("MISSED_CALL"),
                        CALL_NOW("CALL_NOW"),
                        APPLY_NOW("APPLY_NOW"),
                        BUY_NOW("BUY_NOW"),
                        GET_OFFER("GET_OFFER"),
                        GET_OFFER_VIEW("GET_OFFER_VIEW"),
                        BUY_TICKETS("BUY_TICKETS"),
                        UPDATE_APP("UPDATE_APP"),
                        GET_DIRECTIONS("GET_DIRECTIONS"),
                        BUY("BUY"),
                        SEE_DETAILS("SEE_DETAILS"),
                        MESSAGE_PAGE("MESSAGE_PAGE"),
                        DONATE("DONATE"),
                        SUBSCRIBE("SUBSCRIBE"),
                        SAY_THANKS("SAY_THANKS"),
                        SELL_NOW("SELL_NOW"),
                        SHARE("SHARE"),
                        DONATE_NOW("DONATE_NOW"),
                        GET_QUOTE("GET_QUOTE"),
                        CONTACT_US("CONTACT_US"),
                        ORDER_NOW("ORDER_NOW"),
                        ADD_TO_CART("ADD_TO_CART"),
                        VIDEO_ANNOTATION("VIDEO_ANNOTATION"),
                        MOMENTS("MOMENTS"),
                        RECORD_NOW("RECORD_NOW"),
                        VOTE_NOW("VOTE_NOW"),
                        GIVE_FREE_RIDES("GIVE_FREE_RIDES"),
                        REGISTER_NOW("REGISTER_NOW"),
                        OPEN_MESSENGER_EXT("OPEN_MESSENGER_EXT"),
                        UNLIKE_PAGE("UNLIKE_PAGE"),
                        BET_NOW("BET_NOW"),
                        OPEN_MOVIES("OPEN_MOVIES");
                        
                        protected final String serverValue;

                        private Type(String str) {
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

                    /* compiled from: refresh */
                    public final class Value extends GraphQlCallInput {
                    }
                }
            }
        }
    }

    /* compiled from: refresh */
    public final class EventSpec extends GraphQlCallInput {

        /* compiled from: refresh */
        public enum EventBoostType implements JsonSerializable {
            RSVP("RSVP"),
            TICKET("TICKET");
            
            protected final String serverValue;

            private EventBoostType(String str) {
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

    /* compiled from: refresh */
    public enum ValidateOnly implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private ValidateOnly(String str) {
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

    public final BoostedComponentCreateInputData m4325a(String str) {
        a("page_id", str);
        return this;
    }

    public final BoostedComponentCreateInputData m4327b(String str) {
        a("object_id", str);
        return this;
    }

    public final BoostedComponentCreateInputData m4328c(String str) {
        a("ad_account_id", str);
        return this;
    }

    public final BoostedComponentCreateInputData m4322a(BoostedComponentApp boostedComponentApp) {
        a("boosted_component_app", boostedComponentApp);
        return this;
    }

    public final BoostedComponentCreateInputData m4324a(Integer num) {
        a("stop_time", num);
        return this;
    }

    public final BoostedComponentCreateInputData m4323a(Creative creative) {
        a("creative", creative);
        return this;
    }

    public final BoostedComponentCreateInputData m4321a(Audience audience) {
        a("audience", audience);
        return this;
    }

    public final BoostedComponentCreateInputData m4326b(Integer num) {
        a("budget", num);
        return this;
    }
}
