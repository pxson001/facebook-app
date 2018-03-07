package com.facebook.fbuploader;

import com.facebook.fbuploader.UploadJobImpl.OffsetResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.instagram.common.json.JsonFactoryHolder;

/* compiled from: network_image_uri */
public final class UploadJobImpl_OffsetResponse__JsonHelper {
    public static OffsetResponse m15779a(String str) {
        JsonParser a = JsonFactoryHolder.a.a(str);
        a.c();
        OffsetResponse offsetResponse = new OffsetResponse();
        if (a.g() != JsonToken.START_OBJECT) {
            a.f();
            offsetResponse = null;
        } else {
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                a.c();
                if ("offset".equals(i)) {
                    offsetResponse.f10069a = a.E();
                }
                a.f();
            }
        }
        return offsetResponse;
    }
}
