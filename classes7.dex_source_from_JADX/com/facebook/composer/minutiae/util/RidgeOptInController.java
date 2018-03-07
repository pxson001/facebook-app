package com.facebook.composer.minutiae.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.composer.minutiae.music.MusicBroadcastReceiver;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.composer.minutiae.widget.RidgeWidgetProvider;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: text_count */
public class RidgeOptInController {
    public final FbSharedPreferences f1852a;
    private final PackageManager f1853b;
    private final Context f1854c;
    private final Provider<TriState> f1855d;
    private final Provider<TriState> f1856e;
    private final QeAccessor f1857f;

    public static RidgeOptInController m1822b(InjectorLike injectorLike) {
        return new RidgeOptInController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class, ForAppContext.class), IdBasedProvider.a(injectorLike, 652), IdBasedProvider.a(injectorLike, 653), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RidgeOptInController(FbSharedPreferences fbSharedPreferences, PackageManager packageManager, @ForAppContext Context context, Provider<TriState> provider, Provider<TriState> provider2, QeAccessor qeAccessor) {
        this.f1852a = fbSharedPreferences;
        this.f1853b = packageManager;
        this.f1854c = context;
        this.f1855d = provider;
        this.f1856e = provider2;
        this.f1857f = qeAccessor;
    }

    public final int m1825a() {
        return this.f1852a.a(MinutiaePrefKeys.f1622j, 0);
    }

    public final boolean m1827c() {
        return this.f1852a.a(MinutiaePrefKeys.f1616d, false);
    }

    public final boolean m1828e() {
        return this.f1852a.a(MinutiaePrefKeys.f1617e, false);
    }

    public final void m1829f() {
        this.f1852a.edit().putBoolean(MinutiaePrefKeys.f1616d, true).commit();
        m1824l();
    }

    public final void m1830h() {
        this.f1852a.edit().putBoolean(MinutiaePrefKeys.f1617e, true).commit();
        m1826a(true);
    }

    public final void m1831i() {
        this.f1852a.edit().putBoolean(MinutiaePrefKeys.f1617e, false).commit();
        m1826a(false);
    }

    public final boolean m1832j() {
        return this.f1852a.a(MinutiaePrefKeys.f1618f, false);
    }

    public final void m1826a(boolean z) {
        if (this.f1857f.a(ExperimentsForFeedUtilComposerAbtestModule.G, false) || (z && ((TriState) this.f1855d.get()).asBoolean(false))) {
            m1820a(MusicBroadcastReceiver.class);
        } else {
            m1823b(MusicBroadcastReceiver.class);
        }
    }

    private void m1824l() {
        if (((TriState) this.f1856e.get()).asBoolean(false)) {
            m1820a(RidgeWidgetProvider.class);
        } else {
            m1823b(RidgeWidgetProvider.class);
        }
    }

    private void m1820a(Class<?> cls) {
        m1821a(cls, 1);
    }

    private void m1823b(Class<?> cls) {
        m1821a(cls, 2);
    }

    private void m1821a(Class<?> cls, int i) {
        ComponentName componentName = new ComponentName(this.f1854c, cls);
        if (this.f1853b.getComponentEnabledSetting(componentName) != i) {
            this.f1853b.setComponentEnabledSetting(componentName, i, 1);
        }
    }
}
