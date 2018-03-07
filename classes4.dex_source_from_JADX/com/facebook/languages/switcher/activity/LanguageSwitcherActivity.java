package com.facebook.languages.switcher.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.inject.FbInjector;
import com.facebook.languages.switcher.fragment.LanguageSwitcherFragment;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.IFbResourcesNotRequired;
import javax.inject.Inject;

/* compiled from: traceInfo */
public class LanguageSwitcherActivity extends FbFragmentActivity implements IAuthNotRequired, IFbResourcesNotRequired {
    @Inject
    public FbSharedPreferences f844p;
    private String f845q;

    private static <T extends Context> void m1193a(Class<T> cls, T t) {
        m1194a((Object) t, (Context) t);
    }

    public static void m1194a(Object obj, Context context) {
        ((LanguageSwitcherActivity) obj).f844p = (FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context));
    }

    protected final void m1195a(Bundle bundle) {
        super.a(bundle);
        overridePendingTransition(2130968591, 2130968592);
    }

    public final void m1196b(Bundle bundle) {
        super.b(bundle);
        Class cls = LanguageSwitcherActivity.class;
        m1194a((Object) this, (Context) this);
        setContentView(2130904999);
        FragmentManager kO_ = kO_();
        if (kO_.a(2131558429) == null) {
            kO_.a().a(2131558429, new LanguageSwitcherFragment()).b();
        }
        if (bundle != null) {
            this.f845q = bundle.getString("original_locale");
        } else {
            this.f845q = this.f844p.a(LanguageSwitcherCommonExPrefKeys.b, "device");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("original_locale", this.f845q);
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f844p.edit().a(LanguageSwitcherCommonExPrefKeys.b, this.f845q).commit();
    }

    private void m1192a(FbSharedPreferences fbSharedPreferences) {
        this.f844p = fbSharedPreferences;
    }
}
