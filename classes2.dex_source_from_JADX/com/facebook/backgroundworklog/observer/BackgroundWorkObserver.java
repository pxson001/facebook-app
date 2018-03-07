package com.facebook.backgroundworklog.observer;

import android.app.Service;
import android.content.Intent;
import javax.annotation.Nullable;

/* compiled from: webrtc_response */
public interface BackgroundWorkObserver {
    void mo232a(int i, String str, Object obj);

    void mo233a(long j, @Nullable Intent intent, @Nullable Class<?> cls);

    void mo234a(long j, @Nullable Class<? extends Service> cls);

    void mo235a(long j, @Nullable Class<? extends Service> cls, @Nullable Intent intent);

    void mo236a(long j, @Nullable String str, @Nullable Object obj);

    void mo237a(OnBackgroundWorkObservedChanged onBackgroundWorkObservedChanged);

    boolean mo238a();

    void mo239b(long j, @Nullable Class<? extends Service> cls);
}
