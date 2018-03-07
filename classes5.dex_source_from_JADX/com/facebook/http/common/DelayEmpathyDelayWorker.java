package com.facebook.http.common;

import android.content.Context;
import com.facebook.delayedworker.AbstractDelayedWorker;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.FbInjector;
import com.google.common.collect.ImmutableSet;

/* compiled from: duplicate */
public class DelayEmpathyDelayWorker extends AbstractDelayedWorker {
    public DelayEmpathyManager f4918a;

    public static void m9856a(Object obj, Context context) {
        ((DelayEmpathyDelayWorker) obj).f4918a = DelayEmpathyManager.m9859a(FbInjector.get(context));
    }

    public final void m9857a() {
        Class cls = DelayEmpathyDelayWorker.class;
        m9856a(this, getContext());
    }

    public final void m9858b() {
        DelayEmpathyManager delayEmpathyManager = this.f4918a;
        Integer.valueOf(delayEmpathyManager.f4922c.a(ExperimentsForHttpQeModule.an, 3600000));
        delayEmpathyManager.f4921b.a(ImmutableSet.of(InternalHttpPrefKeys.m));
    }
}
