package com.facebook.push.nna;

import android.content.Context;
import android.content.Intent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: has_user_submitted */
public class NNAServiceHelperClass {
    private static final Class<?> f11339a = NNAServiceHelperClass.class;
    private final NNAReceiverWakeLockHolder f11340b;
    private final Context f11341c;

    public static NNAServiceHelperClass m13217b(InjectorLike injectorLike) {
        return new NNAServiceHelperClass((Context) injectorLike.getInstance(Context.class), NNAReceiverWakeLockHolder.m13199a(injectorLike));
    }

    @Inject
    public NNAServiceHelperClass(Context context, NNAReceiverWakeLockHolder nNAReceiverWakeLockHolder) {
        this.f11341c = context;
        this.f11340b = nNAReceiverWakeLockHolder;
    }

    public final void m13218a(Intent intent) {
        this.f11340b.a.c();
        try {
            intent.setClass(this.f11341c, NNAService.class);
            if ((this.f11341c.startService(intent) != null ? 1 : null) != null) {
            }
        } finally {
            this.f11340b.a.d();
            BLog.a(f11339a, "Failed to start service");
        }
    }

    public static NNAServiceHelperClass m13216a(InjectorLike injectorLike) {
        return m13217b(injectorLike);
    }
}
