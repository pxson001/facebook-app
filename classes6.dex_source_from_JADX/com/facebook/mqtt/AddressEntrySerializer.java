package com.facebook.mqtt;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: topicsVersion */
public class AddressEntrySerializer extends JsonSerializer<AddressEntry> {
    public final void m3954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AddressEntry addressEntry = (AddressEntry) obj;
        if (addressEntry == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3953b(addressEntry, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(AddressEntry.class, new AddressEntrySerializer());
    }

    private static void m3953b(AddressEntry addressEntry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "host_name", addressEntry.mHostName);
        AutoGenJsonHelper.a(jsonGenerator, "priority", Integer.valueOf(addressEntry.mPriority));
        AutoGenJsonHelper.a(jsonGenerator, "fail_count", Integer.valueOf(addressEntry.mFailCount));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "address_list_data", addressEntry.mAddressListData);
    }
}
