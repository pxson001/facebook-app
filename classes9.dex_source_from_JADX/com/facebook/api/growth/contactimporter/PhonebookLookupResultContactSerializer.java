package com.facebook.api.growth.contactimporter;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: send_confirmation_code */
public class PhonebookLookupResultContactSerializer extends JsonSerializer<PhonebookLookupResultContact> {
    public final void m3921a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PhonebookLookupResultContact phonebookLookupResultContact = (PhonebookLookupResultContact) obj;
        if (phonebookLookupResultContact == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3920b(phonebookLookupResultContact, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PhonebookLookupResultContact.class, new PhonebookLookupResultContactSerializer());
    }

    private static void m3920b(PhonebookLookupResultContact phonebookLookupResultContact, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "name", phonebookLookupResultContact.name);
        AutoGenJsonHelper.a(jsonGenerator, "record_id", Long.valueOf(phonebookLookupResultContact.recordId));
        AutoGenJsonHelper.a(jsonGenerator, "email", phonebookLookupResultContact.email);
        AutoGenJsonHelper.a(jsonGenerator, "cell", phonebookLookupResultContact.phone);
        AutoGenJsonHelper.a(jsonGenerator, "uid", Long.valueOf(phonebookLookupResultContact.userId));
        AutoGenJsonHelper.a(jsonGenerator, "is_friend", Boolean.valueOf(phonebookLookupResultContact.isFriend));
        AutoGenJsonHelper.a(jsonGenerator, "pic_square_with_logo", phonebookLookupResultContact.profilePic);
        AutoGenJsonHelper.a(jsonGenerator, "ordinal", Long.valueOf(phonebookLookupResultContact.ordinal));
        AutoGenJsonHelper.a(jsonGenerator, "native_name", phonebookLookupResultContact.nativeName);
        AutoGenJsonHelper.a(jsonGenerator, "mutual_friends", Integer.valueOf(phonebookLookupResultContact.mutualFriends));
    }
}
