package com.facebook.common.tempfile;

import android.content.Context;
import com.facebook.delayedworker.AbstractDelayedWorker;
import com.facebook.inject.FbInjector;

/* compiled from: should_use_default_image */
public class TempFileDelayedWorker extends AbstractDelayedWorker {
    public TempFileManager f2734a;

    public static void m3846a(Object obj, Context context) {
        ((TempFileDelayedWorker) obj).f2734a = TempFileManager.a(FbInjector.get(context));
    }

    public final void m3847a() {
        Class cls = TempFileDelayedWorker.class;
        m3846a(this, getContext());
    }

    public final void m3848b() {
        this.f2734a.a();
    }
}
