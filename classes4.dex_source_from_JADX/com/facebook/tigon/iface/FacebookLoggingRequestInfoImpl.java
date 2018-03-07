package com.facebook.tigon.iface;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: last_upload_client_root_hash */
public final class FacebookLoggingRequestInfoImpl implements FacebookLoggingRequestInfo {
    private String f9524a;
    private String f9525b;

    @DoNotStrip
    public FacebookLoggingRequestInfoImpl(String str, String str2) {
        this.f9524a = str;
        this.f9525b = str2;
    }

    public final String logName() {
        return this.f9524a;
    }

    public final String logNamespace() {
        return this.f9525b;
    }
}
