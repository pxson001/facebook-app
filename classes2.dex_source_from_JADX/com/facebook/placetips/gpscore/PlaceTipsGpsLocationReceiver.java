package com.facebook.placetips.gpscore;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.FacebookOnlySecureBroadcastReceiver;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.gpscore.abtest.ExperimentsForPlaceTipsGpsAbTestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: feedback/reactions/small_images/ */
public class PlaceTipsGpsLocationReceiver extends FacebookOnlySecureBroadcastReceiver {
    @Inject
    Lazy<PlaceTipsGpsReceiverLogic> f24450a;
    @Inject
    QeAccessor f24451b;

    private static <T extends InjectableComponentWithoutContext> void m32758a(Class<T> cls, T t, Context context) {
        m32759a((Object) t, context);
    }

    public static void m32759a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlaceTipsGpsLocationReceiver) obj).m32757a(IdBasedSingletonScopeProvider.m1810b(injectorLike, 9590), (QeAccessor) QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    private void m32757a(Lazy<PlaceTipsGpsReceiverLogic> lazy, QeAccessor qeAccessor) {
        this.f24450a = lazy;
        this.f24451b = qeAccessor;
    }

    public PlaceTipsGpsLocationReceiver() {
        super(ImmutableList.of("FOREGROUND_LOCATION_AVAILABLE", "FOREGROUND_LOCATION_CHECK_SKIPPED", "FOREGROUND_LOCATION_CHECK_FAILED"));
    }

    protected final void mo3518a(Context context, Intent intent, String str) {
        Class cls = PlaceTipsGpsLocationReceiver.class;
        m32759a((Object) this, context);
        if (this.f24451b.mo596a(ExperimentsForPlaceTipsGpsAbTestModule.f13562a, false)) {
            m32760a(str);
        }
    }

    private void m32760a(String str) {
        if (str.equals("FOREGROUND_LOCATION_AVAILABLE")) {
            ((PlaceTipsGpsReceiverLogic) this.f24450a.get()).d();
        } else if (str.equals("FOREGROUND_LOCATION_CHECK_SKIPPED")) {
            ((PlaceTipsGpsReceiverLogic) this.f24450a.get()).b();
        } else if (str.equals("FOREGROUND_LOCATION_CHECK_FAILED")) {
            ((PlaceTipsGpsReceiverLogic) this.f24450a.get()).c();
        }
    }
}
