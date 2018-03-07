package com.facebook.common.json;

import android.net.Uri;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

/* compiled from: pulsar_rssi */
public class UriDeserializer extends FromStringDeserializer<Uri> {
    public UriDeserializer() {
        super(Uri.class);
    }

    protected final Object mo1800a(String str, DeserializationContext deserializationContext) {
        return Uri.parse(str);
    }
}
