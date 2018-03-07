package com.facebook.vault.service;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore.Images.Media;
import com.facebook.base.service.FbService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;

/* compiled from: third_party_registration */
public class VaultObserverService extends FbService {
    private static final Class<?> f1908a = VaultObserverService.class;
    private VaultNewImageContentObserver f1909b;
    private VaultHelpers f1910c;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final void m1975a() {
        AppInitLockHelper.a(this);
        this.f1909b = new VaultNewImageContentObserver(new Handler(), Media.EXTERNAL_CONTENT_URI, this);
        getContentResolver().registerContentObserver(this.f1909b.f1889b, true, this.f1909b);
        this.f1910c = VaultHelpers.b(FbInjector.get(this));
        this.f1910c.c(1);
    }

    public final int m1974a(@Nullable Intent intent, int i, int i2) {
        return 1;
    }

    public final void m1976k() {
        getContentResolver().unregisterContentObserver(this.f1909b);
    }
}
