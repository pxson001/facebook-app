package com.facebook.common.market;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: longitude */
public class GooglePlayIntentHelper {
    private static final Uri f15953a = new Builder().scheme("market").authority("details").build();
    private static final Uri f15954b = new Builder().scheme("https").authority("play.google.com").path("store/apps/details").build();
    private static final String[] f15955c = new String[]{"com.android.vending", "com.google.android.gms", "com.google.market"};
    private final PackageManager f15956d;

    public static GooglePlayIntentHelper m22732b(InjectorLike injectorLike) {
        return new GooglePlayIntentHelper(PackageManagerMethodAutoProvider.m2633a(injectorLike));
    }

    public static GooglePlayIntentHelper m22730a(InjectorLike injectorLike) {
        return m22732b(injectorLike);
    }

    @Inject
    public GooglePlayIntentHelper(PackageManager packageManager) {
        this.f15956d = packageManager;
    }

    public final Intent m22735a(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null || !f15953a.getScheme().equals(parse.getScheme())) {
            return null;
        }
        String queryParameter = parse.getQueryParameter("id");
        if (queryParameter == null || queryParameter.isEmpty()) {
            return null;
        }
        return m22738b(queryParameter);
    }

    public final Intent m22738b(String str) {
        Intent a = m22728a(f15953a, str);
        a.addFlags(268435456);
        PackageItemInfo a2 = m22729a(a);
        if (a2 == null || a2.packageName == null || a2.name == null) {
            return !m22733b(a) ? m22728a(f15954b, str) : a;
        } else {
            return a.setComponent(new ComponentName(a2.packageName, a2.name));
        }
    }

    public final void m22736a(Context context, String str) {
        DefaultSecureContextHelper.m4636a(FbInjector.get(context)).mo665b(m22738b(str), context);
    }

    public final boolean m22737a() {
        return m22729a(m22728a(f15953a, "foo")) != null;
    }

    public final boolean m22739b() {
        for (String a : f15955c) {
            if (m22731a(this.f15956d, a)) {
                return true;
            }
        }
        return false;
    }

    private static boolean m22731a(PackageManager packageManager, String str) {
        boolean z = false;
        if (packageManager == null) {
            return z;
        }
        try {
            return packageManager.getApplicationInfo(str, 0).enabled;
        } catch (NameNotFoundException e) {
            return z;
        }
    }

    private static Intent m22728a(Uri uri, String str) {
        return new Intent("android.intent.action.VIEW", uri.buildUpon().appendQueryParameter("id", str).build());
    }

    @Nullable
    private ActivityInfo m22729a(Intent intent) {
        for (ResolveInfo resolveInfo : m22734c(intent)) {
            if (resolveInfo.activityInfo != null && "com.android.vending".equals(resolveInfo.activityInfo.packageName)) {
                return resolveInfo.activityInfo;
            }
        }
        return null;
    }

    private boolean m22733b(Intent intent) {
        return !m22734c(intent).isEmpty();
    }

    private List<ResolveInfo> m22734c(Intent intent) {
        return this.f15956d.queryIntentActivities(intent, 65536);
    }
}
