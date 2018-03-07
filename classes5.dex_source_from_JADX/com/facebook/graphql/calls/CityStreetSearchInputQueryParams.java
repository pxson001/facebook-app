package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: redspace_self_inline */
public final class CityStreetSearchInputQueryParams extends GraphQlCallInput {

    /* compiled from: redspace_self_inline */
    public enum Caller implements JsonSerializable {
        MOBILE_ADS_MANAGER("MOBILE_ADS_MANAGER"),
        MESSENGER_TRANSPORTATION_ANDROID("MESSENGER_TRANSPORTATION_ANDROID"),
        MESSENGER_TRANSPORTATION_IOS("MESSENGER_TRANSPORTATION_IOS"),
        ADS_TARGETTING("ADS_TARGETTING"),
        EVENTS_CREATION("EVENTS_CREATION"),
        GRAPHQL("GRAPHQL"),
        WWW_GUI("WWW_GUI"),
        ADS_GEO_LOCATION_SEARCH("ADS_GEO_LOCATION_SEARCH"),
        EVALUATION("EVALUATION"),
        CONSTITUENT_TITLE_UPSELL("CONSTITUENT_TITLE_UPSELL"),
        UNKNOWN("UNKNOWN");
        
        protected final String serverValue;

        private Caller(String str) {
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

    /* compiled from: redspace_self_inline */
    public enum IntegrationStrategy implements JsonSerializable {
        SIMPLE("SIMPLE"),
        DISTANCE_ONLY("DISTANCE_ONLY"),
        STRING_MATCH("STRING_MATCH"),
        TYPE_MATCH_CHECK("TYPE_MATCH_CHECK");
        
        protected final String serverValue;

        private IntegrationStrategy(String str) {
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

    /* compiled from: redspace_self_inline */
    public enum Provider implements JsonSerializable {
        FACEBOOK("FACEBOOK"),
        GOOGLE("GOOGLE"),
        HERE_WEB("HERE_WEB"),
        HERE_THRIFT("HERE_THRIFT"),
        DEFAULT_PROVIDER("DEFAULT_PROVIDER");
        
        protected final String serverValue;

        private Provider(String str) {
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

    /* compiled from: redspace_self_inline */
    public enum ResultOrdering implements JsonSerializable {
        PLACE_FIRST("PLACE_FIRST"),
        ADDRESS_FIRST("ADDRESS_FIRST"),
        INTERLEAVE("INTERLEAVE");
        
        protected final String serverValue;

        private ResultOrdering(String str) {
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

    /* compiled from: redspace_self_inline */
    public enum SearchType implements JsonSerializable {
        STREET_TYPEAHEAD("STREET_TYPEAHEAD"),
        PLACE_TYPEAHEAD("PLACE_TYPEAHEAD"),
        CITY_TYPEAHEAD("CITY_TYPEAHEAD"),
        STREET_PLACE_TYPEAHEAD("STREET_PLACE_TYPEAHEAD");
        
        protected final String serverValue;

        private SearchType(String str) {
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

    /* compiled from: redspace_self_inline */
    public final class ViewerCoordinates extends GraphQlCallInput {
    }
}
