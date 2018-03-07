package com.facebook.zero.notification;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Provider;

/* compiled from: {SouvenirBurstItem size=%d selected=%s} */
public abstract class ZeroFreeDataNotificationBase {
    protected final Context f115a;
    protected final FbSharedPreferences f116b;
    protected final BaseFbBroadcastManager f117c;
    protected final Lazy<ZeroFeatureVisibilityHelper> f118d;
    protected final Provider<Boolean> f119e;
    protected final SecureContextHelper f120f;

    public ZeroFreeDataNotificationBase(Context context, FbSharedPreferences fbSharedPreferences, FbBroadcastManager fbBroadcastManager, Lazy<ZeroFeatureVisibilityHelper> lazy, Provider<Boolean> provider, SecureContextHelper secureContextHelper) {
        this.f115a = context;
        this.f116b = fbSharedPreferences;
        this.f117c = fbBroadcastManager;
        this.f118d = lazy;
        this.f119e = provider;
        this.f120f = secureContextHelper;
    }
}
