package com.facebook.languages.switcher;

import android.app.Activity;
import android.os.Build.VERSION;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.google.common.annotations.VisibleForTesting;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: stylingData */
public class LanguageSwitcherListener {
    @VisibleForTesting
    public Locale f3945a;
    private final LanguageSwitcher f3946b;
    private final Locales f3947c;

    @Inject
    public LanguageSwitcherListener(LanguageSwitcher languageSwitcher, Locales locales) {
        this.f3946b = languageSwitcher;
        this.f3947c = locales;
    }

    public final void m6544a() {
        if (LanguageSwitcher.m4743a()) {
            this.f3945a = m6543c();
        }
    }

    public final void m6546b() {
        if (LanguageSwitcher.m4743a()) {
            this.f3945a = m6543c();
        }
    }

    public final void m6545a(Activity activity) {
        if (LanguageSwitcher.m4743a() && this.f3945a != null) {
            Locale locale = activity.getResources().getConfiguration().locale;
            if (!StringUtil.m3590a(locale.toString(), this.f3945a.toString())) {
                this.f3945a = locale;
                if (VERSION.SDK_INT >= 11) {
                    activity.recreate();
                } else {
                    BLog.a(LanguageSwitcherListener.class, StringFormatUtil.a("Finishing activity %s due to locale mismatch: old locale %s new locale %s. This is expected iff language was just switched.", new Object[]{activity.getComponentName().getClassName(), this.f3945a.toString(), locale.toString()}));
                    activity.finish();
                }
            }
        }
    }

    private Locale m6543c() {
        this.f3946b.m4752f();
        return this.f3947c.m2609a();
    }
}
