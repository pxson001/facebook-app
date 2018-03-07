package com.facebook.languages.switcher;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.facebook.common.util.LocaleUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switcher.logging.LanguageSwitcherLogger;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: timeline_fetch_context_items */
public class LanguageSwitchPromotionActivity extends Activity {
    @Inject
    FbSharedPreferences f1371a;
    @Inject
    LanguageSwitcherLogger f1372b;

    private static <T extends Context> void m1381a(Class<T> cls, T t) {
        m1382a((Object) t, (Context) t);
    }

    public static void m1382a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LanguageSwitchPromotionActivity) obj).m1380a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), LanguageSwitcherLogger.m1415b(injectorLike));
    }

    private void m1380a(FbSharedPreferences fbSharedPreferences, LanguageSwitcherLogger languageSwitcherLogger) {
        this.f1371a = fbSharedPreferences;
        this.f1372b = languageSwitcherLogger;
    }

    protected void onCreate(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -706290595);
        super.onCreate(bundle);
        Class cls = LanguageSwitchPromotionActivity.class;
        m1382a((Object) this, (Context) this);
        String locale = LocaleUtil.a(getIntent().getData().getQueryParameter("locale")).toString();
        String a2 = this.f1371a.a(LanguageSwitcherCommonExPrefKeys.b, "device");
        if (!a2.equals(locale)) {
            this.f1372b.m1418b(a2, locale);
            this.f1371a.edit().a(LanguageSwitcherCommonExPrefKeys.b, locale).commit();
        }
        finish();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -474795245, a);
    }
}
