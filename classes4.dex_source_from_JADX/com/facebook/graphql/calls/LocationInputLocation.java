package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: friend_requests_counts */
public final class LocationInputLocation extends GraphQlCallInput {

    /* compiled from: friend_requests_counts */
    public enum LocationServiceEnabled implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private LocationServiceEnabled(String str) {
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

    public final LocationInputLocation m11812a(Double d) {
        a("latitude", d);
        return this;
    }

    public final LocationInputLocation m11813b(Double d) {
        a("longitude", d);
        return this;
    }

    public final LocationInputLocation m11814c(Double d) {
        a("accuracy", d);
        return this;
    }

    public final LocationInputLocation m11811a(LocationServiceEnabled locationServiceEnabled) {
        a("location_service_enabled", locationServiceEnabled);
        return this;
    }
}
