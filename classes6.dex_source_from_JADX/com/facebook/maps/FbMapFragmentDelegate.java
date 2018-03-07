package com.facebook.maps;

import android.content.Context;
import android.os.Bundle;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.ReportButtonDrawable;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.delegate.MapFragmentDelegate;
import com.facebook.maps.report.FbMapReporterLauncher;
import javax.inject.Inject;

/* compiled from: zero_extra_charges_dialog_open */
public class FbMapFragmentDelegate extends MapFragmentDelegate implements InjectableComponentWithContext {
    @Inject
    FbMapInitializer f141d;
    @Inject
    FbMapReporterLauncher f142e;

    private static <T extends InjectableComponentWithContext> void m105a(Class<T> cls, T t) {
        m106a((Object) t, t.getContext());
    }

    private static void m106a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FbMapFragmentDelegate) obj).m104a(FbMapInitializer.m109b(fbInjector), FbMapReporterLauncher.a(fbInjector));
    }

    public static FbMapFragmentDelegate m102a(FacebookMapOptions facebookMapOptions) {
        return m103a(facebookMapOptions, null);
    }

    private static FbMapFragmentDelegate m103a(FacebookMapOptions facebookMapOptions, Integer num) {
        FbMapFragmentDelegate fbMapFragmentDelegate = new FbMapFragmentDelegate();
        if (num != null) {
            fbMapFragmentDelegate.c = num.intValue();
        }
        fbMapFragmentDelegate.a = facebookMapOptions;
        return fbMapFragmentDelegate;
    }

    public final void m108a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1023641191);
        super.a(bundle);
        m105a(FbMapFragmentDelegate.class, (InjectableComponentWithContext) this);
        this.b = Boolean.valueOf(true);
        this.f141d.m110a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2008398633, a);
    }

    protected final MapDrawable mo2a(FacebookMap facebookMap) {
        return new ReportButtonDrawable(facebookMap, this.f135c, this.f142e, facebookMap.z.getString(2131230962));
    }

    private void m104a(FbMapInitializer fbMapInitializer, FbMapReporterLauncher fbMapReporterLauncher) {
        this.f141d = fbMapInitializer;
        this.f142e = fbMapReporterLauncher;
    }
}
