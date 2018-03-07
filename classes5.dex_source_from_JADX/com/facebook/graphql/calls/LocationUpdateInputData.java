package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: profile_question */
public final class LocationUpdateInputData extends GraphQlMutationCallInput {

    /* compiled from: profile_question */
    public enum AppUseState implements JsonSerializable {
        FOREGROUND("FOREGROUND"),
        BACKGROUND("BACKGROUND");
        
        protected final String serverValue;

        private AppUseState(String str) {
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

    /* compiled from: profile_question */
    public final class CellInfo extends GraphQlCallInput {

        /* compiled from: profile_question */
        public final class Connected extends GraphQlCallInput {

            /* compiled from: profile_question */
            public final class CdmaInfo extends GraphQlCallInput {

                /* compiled from: profile_question */
                public final class BaseStationCoordinates extends GraphQlCallInput {
                }
            }

            /* compiled from: profile_question */
            public final class GsmInfo extends GraphQlCallInput {
            }

            /* compiled from: profile_question */
            public final class LteInfo extends GraphQlCallInput {
            }

            /* compiled from: profile_question */
            public final class WcdmaInfo extends GraphQlCallInput {
            }
        }

        /* compiled from: profile_question */
        public enum HasIccCard implements JsonSerializable {
            TRUE("true"),
            FALSE("false");
            
            protected final String serverValue;

            private HasIccCard(String str) {
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

        /* compiled from: profile_question */
        public final class ScanResults extends GraphQlCallInput {

            /* compiled from: profile_question */
            public final class CdmaInfo extends GraphQlCallInput {

                /* compiled from: profile_question */
                public final class BaseStationCoordinates extends GraphQlCallInput {
                }
            }

            /* compiled from: profile_question */
            public final class GsmInfo extends GraphQlCallInput {
            }

            /* compiled from: profile_question */
            public final class LteInfo extends GraphQlCallInput {
            }

            /* compiled from: profile_question */
            public final class WcdmaInfo extends GraphQlCallInput {
            }
        }
    }

    /* compiled from: profile_question */
    public final class LocationManagerInfo extends GraphQlCallInput {

        /* compiled from: profile_question */
        public final class Locations extends GraphQlCallInput {
        }
    }

    /* compiled from: profile_question */
    public final class WifiInfo extends GraphQlCallInput {

        /* compiled from: profile_question */
        public final class Connected extends GraphQlCallInput {
        }

        /* compiled from: profile_question */
        public final class ScanResults extends GraphQlCallInput {
        }
    }
}
