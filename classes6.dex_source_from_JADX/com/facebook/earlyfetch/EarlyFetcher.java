package com.facebook.earlyfetch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: nux_flow_next */
public abstract class EarlyFetcher<T, F> {
    public long f8896a;
    public long f8897b;
    @Nullable
    public ViewerContextManager f8898c;
    @Nullable
    public ViewerContext f8899d;
    @Nullable
    public EarlyFetchResult<T, F> f8900e;

    public abstract EarlyFetchResult<T, F> m12688a(Context context, Intent intent);

    public abstract void m12691a(F f);

    public abstract boolean m12694b();

    public final void m12690a(ViewerContextManager viewerContextManager, Context context, int i, String str, Bundle bundle) {
        this.f8898c = viewerContextManager;
        this.f8899d = viewerContextManager.d();
        this.f8900e = m12689a(str, bundle);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f8897b = uptimeMillis;
        this.f8896a = uptimeMillis;
    }

    protected boolean m12692a(int i) {
        return false;
    }

    protected EarlyFetchResult<T, F> m12689a(String str, Bundle bundle) {
        return null;
    }

    public final F m12693b(T t) {
        EarlyFetchResult earlyFetchResult = this.f8900e;
        if (earlyFetchResult == null) {
            return null;
        }
        Object obj;
        F f;
        if (Objects.equal(t, earlyFetchResult.f8894a)) {
            if (this.f8898c == null) {
                obj = null;
            } else {
                obj = this.f8898c.d();
            }
            if (Objects.equal(obj, this.f8899d)) {
                obj = 1;
                if (obj == null) {
                    f = earlyFetchResult.f8895b;
                    this.f8897b = SystemClock.uptimeMillis();
                } else {
                    f = null;
                }
                this.f8900e = null;
                return f;
            }
        }
        obj = null;
        if (obj == null) {
            f = null;
        } else {
            f = earlyFetchResult.f8895b;
            this.f8897b = SystemClock.uptimeMillis();
        }
        this.f8900e = null;
        return f;
    }

    public final boolean m12695c() {
        return this.f8900e != null;
    }

    public final long m12696d() {
        return this.f8897b - this.f8896a;
    }
}
