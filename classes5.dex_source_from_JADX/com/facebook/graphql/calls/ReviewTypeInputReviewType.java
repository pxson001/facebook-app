package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: postResponse */
public enum ReviewTypeInputReviewType implements JsonSerializable {
    NONE("NONE"),
    DAILY_DIALOGUE_CONTACT_INFO("DAILY_DIALOGUE_CONTACT_INFO"),
    ID_BACKED_PRIVACY_CHECKUP("ID_BACKED_PRIVACY_CHECKUP"),
    FB4A_PROFILE_PHOTO_CHECKUP("FB4A_PROFILE_PHOTO_CHECKUP"),
    PROFILE_PHOTO_CHECKUP("PROFILE_PHOTO_CHECKUP"),
    UNIT_TEST("UNIT_TEST");
    
    protected final String serverValue;

    private ReviewTypeInputReviewType(String str) {
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
