package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

public class zzms<R extends Result> extends zze<R> implements ResultCallback<R> {
    private zzb<? super R, ? extends Result> f6905a;
    private zzms<? extends Result> f6906b;
    private ResultCallbacks<? super R> f6907c;
    private PendingResult<R> f6908d;
    private final Object f6909e;

    private void m12872a() {
        if (this.f6908d == null) {
            return;
        }
        if (this.f6905a != null || this.f6907c != null) {
            this.f6908d.mo826a(this);
        }
    }

    private void m12873a(PendingResult<?> pendingResult) {
        synchronized (this.f6909e) {
            this.f6908d = pendingResult;
            m12872a();
        }
    }

    private void m12874a(Status status) {
        synchronized (this.f6909e) {
            if (this.f6905a != null) {
                Status a = zzb.m12145a(status);
                zzx.a(a, "onFailure must not return null");
                this.f6906b.m12874a(a);
            }
        }
    }

    private static void m12875b(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).mo737c();
            } catch (Throwable e) {
                Log.w("TransformedResultImpl", "Unable to release " + result, e);
            }
        }
    }

    public final void m12876a(R r) {
        synchronized (this.f6909e) {
            if (!r.cp_().e()) {
                m12874a(r.cp_());
                m12875b(r);
            } else if (this.f6905a != null) {
                PendingResult a = this.f6905a.m12146a();
                if (a == null) {
                    m12874a(new Status(13, "Transform returned null"));
                } else {
                    this.f6906b.m12873a(a);
                }
                m12875b(r);
            } else if (this.f6907c != null) {
            }
        }
    }
}
