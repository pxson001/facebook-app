package com.facebook.vault.service;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.facebook.inject.FbInjector;

/* compiled from: third_party_registration_relative_path */
public class VaultNewImageContentObserver extends ContentObserver {
    private static final Class<?> f1888a = VaultNewImageContentObserver.class;
    public Uri f1889b;
    private VaultHelpers f1890c;

    public VaultNewImageContentObserver(Handler handler, Uri uri, Context context) {
        super(handler);
        this.f1889b = uri;
        this.f1890c = VaultHelpers.b(FbInjector.get(context));
    }

    public void onChange(boolean z) {
        new StringBuilder("Detected change from ").append(this.f1889b.toString());
        this.f1890c.c(0);
    }

    public boolean deliverSelfNotifications() {
        return false;
    }
}
