package com.facebook.friending.profileshare;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.provider.Telephony.Sms;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.MathUtil;
import com.facebook.friending.profileshare.xconfig.ProfileShareXConfig;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: add-members */
public class ProfileShareController {
    private final Context f20251a;
    private final ProfileShareXConfig f20252b;
    private final Provider<String> f20253c;

    public static ProfileShareController m20540b(InjectorLike injectorLike) {
        return new ProfileShareController((Context) injectorLike.getInstance(Context.class), ProfileShareXConfig.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public ProfileShareController(Context context, ProfileShareXConfig profileShareXConfig, Provider<String> provider) {
        this.f20251a = context;
        this.f20252b = profileShareXConfig;
        this.f20253c = provider;
    }

    public final List<ProfileShareItem> m20543a() {
        List<ProfileShareItem> arrayList = new ArrayList();
        Set hashSet = new HashSet();
        PackageManager packageManager = this.f20251a.getPackageManager();
        Set hashSet2 = new HashSet(this.f20252b.b());
        Set hashSet3 = new HashSet(this.f20252b.a());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(m20539b(), 0);
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            arrayList.add(new ProfileShareItem((String) resolveInfo.loadLabel(packageManager), resolveInfo.loadIcon(packageManager), m20541c().setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name)).putExtra("IS_SMS_INTENT_TAG", true)));
            hashSet.add(resolveInfo.activityInfo.name);
        }
        queryIntentActivities.addAll(packageManager.queryIntentActivities(m20541c(), 0));
        for (ResolveInfo resolveInfo2 : queryIntentActivities) {
            String str = resolveInfo2.activityInfo.packageName;
            String str2 = resolveInfo2.activityInfo.name;
            if (!(hashSet.contains(str2) || ((!hashSet2.contains(str) && !hashSet2.contains(str2)) || hashSet3.contains(str) || hashSet3.contains(str2)))) {
                Intent c = m20541c();
                c.setComponent(new ComponentName(str, str2));
                arrayList.add(new ProfileShareItem((String) resolveInfo2.loadLabel(packageManager), resolveInfo2.loadIcon(packageManager), c));
                hashSet.add(resolveInfo2.activityInfo.name);
            }
        }
        return arrayList;
    }

    public final String m20542a(long j) {
        String a = MathUtil.a(Long.parseLong((String) this.f20253c.get()));
        String a2 = MathUtil.a(j);
        a = StringFormatUtil.a("https://m.facebook.com/c/%s/%s", new Object[]{a, a2});
        return this.f20251a.getResources().getString(2131241363, new Object[]{a});
    }

    private Intent m20539b() {
        Intent intent = null;
        if (VERSION.SDK_INT >= 19) {
            String defaultSmsPackage = Sms.getDefaultSmsPackage(this.f20251a);
            if (defaultSmsPackage != null) {
                intent = new Intent("android.intent.action.SEND").setType("text/plain").setPackage(defaultSmsPackage);
            }
        }
        if (intent == null) {
            return new Intent("android.intent.action.VIEW").setType("vnd.android-dir/mms-sms");
        }
        return intent;
    }

    private static Intent m20541c() {
        return new Intent("android.intent.action.SEND").setType("text/plain");
    }
}
