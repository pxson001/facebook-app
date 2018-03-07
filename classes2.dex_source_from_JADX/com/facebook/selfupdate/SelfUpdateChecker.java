package com.facebook.selfupdate;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresence;
import com.facebook.oxygen.preloads.sdk.common.PreloadSdkPresenceMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: reaction_android_multirow_bg_styling */
public class SelfUpdateChecker {
    public static final String[] f8145a = new String[]{"com.android.vending", "com.google.android.gms", "com.google.market"};
    public final Context f8146b;
    private final DefaultProcessUtil f8147c;
    private final AppVersionInfo f8148d;
    private final Provider<Boolean> f8149e;
    public final Provider<Boolean> f8150f;
    private final Provider<Boolean> f8151g;
    public final FbSharedPreferences f8152h;
    public final PackageManager f8153i;
    public final PreloadSdkPresence f8154j;
    public final String f8155k;
    private final Clock f8156l;
    private final GatekeeperStoreImpl f8157m;

    public static SelfUpdateChecker m12685b(InjectorLike injectorLike) {
        return new SelfUpdateChecker((Context) injectorLike.getInstance(Context.class), DefaultProcessUtil.m2387a(injectorLike), AppVersionInfoMethodAutoProvider.m2629a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4327), IdBasedProvider.m1811a(injectorLike, 4328), IdBasedProvider.m1811a(injectorLike, 4326), FbSharedPreferencesImpl.m1826a(injectorLike), PackageManagerMethodAutoProvider.m2633a(injectorLike), PreloadSdkPresenceMethodAutoProvider.m12691b(injectorLike), String_PackageNameMethodAutoProvider.m4353a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public SelfUpdateChecker(Context context, ProcessUtil processUtil, AppVersionInfo appVersionInfo, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, FbSharedPreferences fbSharedPreferences, PackageManager packageManager, PreloadSdkPresence preloadSdkPresence, String str, Clock clock, GatekeeperStore gatekeeperStore) {
        this.f8146b = context;
        this.f8147c = processUtil;
        this.f8148d = appVersionInfo;
        this.f8149e = provider2;
        this.f8150f = provider;
        this.f8151g = provider3;
        this.f8152h = fbSharedPreferences;
        this.f8153i = packageManager;
        this.f8154j = preloadSdkPresence;
        this.f8155k = str;
        this.f8156l = clock;
        this.f8157m = gatekeeperStore;
    }

    public final boolean m12687a() {
        boolean z;
        boolean booleanValue = ((Boolean) this.f8149e.get()).booleanValue();
        boolean c = m12688c();
        boolean d = this.f8148d.m2713d();
        boolean a = this.f8152h.mo286a(SelfUpdateConstants.f8163D, false);
        DefaultProcessUtil defaultProcessUtil = this.f8147c;
        String packageName = this.f8146b.getPackageName();
        ProcessName a2 = defaultProcessUtil.m2389a();
        if (a2 == null) {
            BLog.a(DefaultProcessUtil.f1239a, "Couldn't find own process name");
            z = false;
        } else {
            z = Objects.equal(a2.b, packageName);
        }
        return (booleanValue || c) && ((!d || a) && z);
    }

    public final boolean m12688c() {
        Object obj;
        boolean booleanValue = ((Boolean) this.f8151g.get()).booleanValue();
        if (((Boolean) this.f8150f.get()).booleanValue()) {
            Object obj2;
            Object obj3;
            String installerPackageName;
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.f56b;
            if (GoogleApiAvailability.m148a(this.f8146b) == 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                if (AccountManager.get(this.f8146b).getAccountsByType("com.google").length > 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    obj3 = 1;
                    if (obj3 == null) {
                        obj2 = null;
                        installerPackageName = this.f8153i.getInstallerPackageName(this.f8155k);
                        for (String equals : f8145a) {
                            if (equals.equals(installerPackageName)) {
                                obj2 = 1;
                                break;
                            }
                        }
                        if (obj2 == null || this.f8154j.m12701b()) {
                            obj3 = null;
                        } else {
                            obj3 = 1;
                        }
                        if (obj3 != null) {
                            obj = 1;
                            return booleanValue || obj != null;
                        }
                    }
                }
            }
            obj3 = null;
            if (obj3 == null) {
                obj2 = null;
                installerPackageName = this.f8153i.getInstallerPackageName(this.f8155k);
                while (r5 < r8) {
                    if (equals.equals(installerPackageName)) {
                        obj2 = 1;
                        break;
                    }
                }
                if (obj2 == null) {
                }
                obj3 = null;
                if (obj3 != null) {
                    obj = 1;
                    if (!booleanValue) {
                    }
                }
            }
        }
        obj = null;
        if (booleanValue) {
        }
    }

    public final boolean m12689d() {
        try {
            if (Secure.getInt(this.f8146b.getContentResolver(), "install_non_market_apps") == 1) {
                return true;
            }
            return false;
        } catch (SettingNotFoundException e) {
            return false;
        }
    }

    public static boolean m12686b(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
