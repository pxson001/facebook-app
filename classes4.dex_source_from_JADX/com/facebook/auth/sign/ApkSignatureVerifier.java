package com.facebook.auth.sign;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.content.PackageSignatureUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: message_type */
public class ApkSignatureVerifier implements INeedInit {
    public final AnalyticsLogger f8104a;
    private final PackageSignatureUtils f8105b;
    public final PackageManager f8106c;
    public final String f8107d;
    private final FbSharedPreferences f8108e;

    public static ApkSignatureVerifier m8388b(InjectorLike injectorLike) {
        return new ApkSignatureVerifier(PackageSignatureUtils.m8389a(injectorLike), (Context) injectorLike.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ApkSignatureVerifier(PackageSignatureUtils packageSignatureUtils, Context context, PackageManager packageManager, AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences) {
        this.f8105b = packageSignatureUtils;
        this.f8106c = packageManager;
        this.f8107d = context.getPackageName();
        this.f8104a = analyticsLogger;
        this.f8108e = fbSharedPreferences;
    }

    public void init() {
        if (!this.f8108e.a(AuthPrefKeys.t, false)) {
            Boolean valueOf;
            this.f8108e.edit().putBoolean(AuthPrefKeys.t, true);
            List<Signature> a = m8387a(this.f8107d);
            for (Signature toByteArray : a) {
                Object obj;
                String a2 = SecureHashUtil.a(toByteArray.toByteArray());
                if ("ijxLJi1yGs1JpL-X1SExmchvork".equals(a2) || "pLdFLi7Y9fGRBYynu_0msNMhS_w".equals(a2) || "Xo8WBi6jzSxKDVR4drqm84yr9iU".equals(a2)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    valueOf = Boolean.valueOf(true);
                    break;
                }
            }
            valueOf = Boolean.valueOf(false);
            if (!valueOf.booleanValue()) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_sign_verification");
                honeyClientEvent.b("package_name", this.f8107d);
                honeyClientEvent.b("installer", this.f8106c.getInstallerPackageName(this.f8107d));
                if (a.size() > 0) {
                    honeyClientEvent.a("signature", ((Signature) a.get(0)).toCharsString().hashCode());
                }
                honeyClientEvent.a("num_signatures", a.size());
                this.f8104a.b(honeyClientEvent, 1);
            }
        }
    }

    private List<Signature> m8387a(String str) {
        List<Signature> a = Lists.a();
        try {
            for (Object add : this.f8106c.getPackageInfo(str, 64).signatures) {
                a.add(add);
            }
        } catch (NameNotFoundException e) {
        }
        return a;
    }
}
