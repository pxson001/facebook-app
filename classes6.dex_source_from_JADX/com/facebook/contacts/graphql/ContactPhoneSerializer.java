package com.facebook.contacts.graphql;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: phonetic_middle_name */
public class ContactPhoneSerializer extends JsonSerializer<ContactPhone> {
    public final void m12036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ContactPhone contactPhone = (ContactPhone) obj;
        if (contactPhone == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m12035b(contactPhone, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ContactPhone.class, new ContactPhoneSerializer());
    }

    private static void m12035b(ContactPhone contactPhone, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", contactPhone.mId);
        AutoGenJsonHelper.a(jsonGenerator, "label", contactPhone.mLabel);
        AutoGenJsonHelper.a(jsonGenerator, "displayNumber", contactPhone.mDisplayNumber);
        AutoGenJsonHelper.a(jsonGenerator, "universalNumber", contactPhone.mUniversalNumber);
        AutoGenJsonHelper.a(jsonGenerator, "isVerified", Boolean.valueOf(contactPhone.mIsVerified));
    }
}
