package com.facebook.zero.iptest;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.content.FacebookOnlySecureBroadcastReceiver;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.zero.iptest.ZeroIPTestInvoker.C18221;
import com.google.common.util.concurrent.ListenableFutureTask;
import javax.inject.Inject;

/* compiled from: events_suggestions_cut_diplay_name */
public class ZeroIPTestBroadcastReceiver extends FacebookOnlySecureBroadcastReceiver implements InjectableComponentWithoutContext {
    @Inject
    public ZeroIPTestInvoker f13061a;

    private static <T extends InjectableComponentWithoutContext> void m13134a(Class<T> cls, T t, Context context) {
        m13135a(t, context);
    }

    public static void m13135a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ZeroIPTestBroadcastReceiver) obj).f13061a = new ZeroIPTestInvoker(DefaultAppChoreographer.a(fbInjector), ZeroIPTestManager.m13137a(fbInjector), ZeroIPTestScheduler.a(fbInjector), IdBasedProvider.a(fbInjector, 4393));
    }

    private void m13133a(ZeroIPTestInvoker zeroIPTestInvoker) {
        this.f13061a = zeroIPTestInvoker;
    }

    public ZeroIPTestBroadcastReceiver() {
        super("ZERO_IP_TEST_ACTION");
    }

    protected final void m13136a(Context context, Intent intent, String str) {
        Class cls = ZeroIPTestBroadcastReceiver.class;
        m13135a(this, context);
        AppInitLockHelper.a(context);
        ZeroIPTestInvoker zeroIPTestInvoker = this.f13061a;
        ListenableFutureTask a = zeroIPTestInvoker.f13064b.a("ZeroIPTestInvoker-invoke", new C18221(zeroIPTestInvoker), Priority.APPLICATION_LOADED_LOW_PRIORITY, ThreadType.BACKGROUND);
    }
}
