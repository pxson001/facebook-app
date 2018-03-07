package com.facebook.platform.common.activity;

import android.os.Bundle;

/* compiled from: stream_network_use_ssl_factory */
public class PlatformActivityActionNotSupportedException extends Exception {
    private static final long serialVersionUID = 3434740933015239969L;
    private Bundle mErrorBundle;

    public PlatformActivityActionNotSupportedException(Bundle bundle) {
        this.mErrorBundle = bundle;
    }

    public final Bundle m5922a() {
        return this.mErrorBundle;
    }
}
