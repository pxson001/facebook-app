package com.facebook.fbuploader;

import com.facebook.fbuploader.UploadJobImpl.UploadResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.instagram.common.json.JsonFactoryHolder;

/* compiled from: network_image */
public final class UploadJobImpl_UploadResponse__JsonHelper {
    public static UploadResponse m15780a(String str) {
        JsonParser a = JsonFactoryHolder.a.a(str);
        a.c();
        UploadResponse uploadResponse = new UploadResponse();
        if (a.g() != JsonToken.START_OBJECT) {
            a.f();
            uploadResponse = null;
        } else {
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                a.c();
                String str2 = null;
                int i2;
                if ("h".equals(i)) {
                    if (a.g() != JsonToken.VALUE_NULL) {
                        str2 = a.o();
                    }
                    uploadResponse.f10070a = str2;
                    i2 = 1;
                } else if ("media_id".equals(i)) {
                    if (a.g() != JsonToken.VALUE_NULL) {
                        str2 = a.o();
                    }
                    uploadResponse.f10071b = str2;
                    i2 = 1;
                }
                a.f();
            }
        }
        return uploadResponse;
    }
}
