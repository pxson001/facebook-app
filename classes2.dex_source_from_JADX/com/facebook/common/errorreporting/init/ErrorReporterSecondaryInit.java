package com.facebook.common.errorreporting.init;

import android.text.TextUtils;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.FbPackageFetcher;
import com.facebook.common.init.INeedInit;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tuzi_marketplace_post_nearby */
public class ErrorReporterSecondaryInit implements INeedInit {
    public static final PrefKey f2191a = ((PrefKey) SharedPrefKeys.f989c.m2011a("app_version_name_current"));
    public static final PrefKey f2192b = ((PrefKey) SharedPrefKeys.f989c.m2011a("app_version_name_prev"));
    public final AbstractFbErrorReporter f2193c;
    private final Provider<String> f2194d;
    private final UniqueIdForDeviceHolderImpl f2195e;
    public final Lazy<AppVersionInfo> f2196f;
    public final FbSharedPreferences f2197g;
    private final FbPackageInfoReportSupplier f2198h;

    public static ErrorReporterSecondaryInit m4337b(InjectorLike injectorLike) {
        return new ErrorReporterSecondaryInit(FbErrorReporterImpl.m2317a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), UniqueIdForDeviceHolderMethodAutoProvider.m4339b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 879), FbSharedPreferencesImpl.m1826a(injectorLike), new FbPackageInfoReportSupplier(new FbPackageFetcher(PackageManagerMethodAutoProvider.m2633a(injectorLike), String_PackageNameMethodAutoProvider.m4353a(injectorLike))));
    }

    @Inject
    public ErrorReporterSecondaryInit(FbErrorReporter fbErrorReporter, Provider<String> provider, UniqueIdForDeviceHolder uniqueIdForDeviceHolder, Lazy<AppVersionInfo> lazy, FbSharedPreferences fbSharedPreferences, FbPackageInfoReportSupplier fbPackageInfoReportSupplier) {
        this.f2193c = fbErrorReporter;
        this.f2194d = provider;
        this.f2195e = uniqueIdForDeviceHolder;
        this.f2196f = lazy;
        this.f2197g = fbSharedPreferences;
        this.f2198h = fbPackageInfoReportSupplier;
    }

    public void init() {
        String str = (String) this.f2194d.get();
        if (!TextUtils.isEmpty(str)) {
            this.f2193c.mo344c(str);
        }
        str = this.f2195e.m4346a();
        if (str != null) {
            this.f2193c.mo345c("marauder_device_id", str);
            new StringBuilder("ErrorReporter DEVICE_ID_KEY set to: ").append(str);
        }
        this.f2193c.mo338a("installed_fb_apks", this.f2198h);
        String a = ((AppVersionInfo) this.f2196f.get()).mo367a();
        if (a == null) {
            a = "unknown";
        }
        if (this.f2197g.mo285a(f2191a)) {
            String a2 = this.f2197g.mo278a(f2191a, "DUMMY");
            if (a2.equals(a)) {
                this.f2193c.mo345c("app_version_name_prev", this.f2197g.mo278a(f2192b, "unknown"));
                return;
            }
            this.f2193c.mo345c("app_version_name_prev", a2);
            Editor edit = this.f2197g.edit();
            edit.mo1276a(f2192b, a2);
            edit.mo1276a(f2191a, a);
            edit.commit();
            return;
        }
        Editor edit2 = this.f2197g.edit();
        edit2.mo1276a(f2192b, "unknown");
        edit2.mo1276a(f2191a, a);
        edit2.commit();
        this.f2193c.mo345c("app_version_name_prev", "unknown");
    }
}
