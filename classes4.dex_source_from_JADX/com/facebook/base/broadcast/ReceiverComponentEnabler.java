package com.facebook.base.broadcast;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.inject.ForAppContext;
import javax.inject.Inject;

/* compiled from: mSettingName */
public class ReceiverComponentEnabler {
    public final Context f8556a;
    public final PackageManager f8557b;

    @Inject
    public ReceiverComponentEnabler(@ForAppContext Context context, PackageManager packageManager) {
        this.f8556a = context;
        this.f8557b = packageManager;
    }
}
