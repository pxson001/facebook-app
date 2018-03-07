package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.controller.AbstractDraweeController;

/* compiled from: graphNotifUpdateSeenStateOnlyOnServer */
public class GestureDetector {
    @VisibleForTesting
    public AbstractDraweeController f22013a;
    @VisibleForTesting
    public final float f22014b;
    @VisibleForTesting
    public boolean f22015c;
    @VisibleForTesting
    public boolean f22016d;
    @VisibleForTesting
    public long f22017e;
    @VisibleForTesting
    public float f22018f;
    @VisibleForTesting
    public float f22019g;

    public GestureDetector(Context context) {
        this.f22014b = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        m29795a();
    }

    public final void m29795a() {
        this.f22013a = null;
        m29796b();
    }

    public final void m29796b() {
        this.f22015c = false;
        this.f22016d = false;
    }
}
