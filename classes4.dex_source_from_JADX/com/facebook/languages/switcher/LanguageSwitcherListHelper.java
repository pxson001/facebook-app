package com.facebook.languages.switcher;

import android.content.Context;
import com.facebook.common.util.LocaleUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: transcode */
public class LanguageSwitcherListHelper {
    private final Context f755a;
    private final SuggestedLanguagesListHelper f756b;
    public final FbSharedPreferences f757c;
    private final LanguageSwitcher f758d;

    public static LanguageSwitcherListHelper m1108b(InjectorLike injectorLike) {
        return new LanguageSwitcherListHelper((Context) injectorLike.getInstance(Context.class), SuggestedLanguagesListHelper.m1017b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), LanguageSwitcher.a(injectorLike));
    }

    @Inject
    public LanguageSwitcherListHelper(Context context, SuggestedLanguagesListHelper suggestedLanguagesListHelper, FbSharedPreferences fbSharedPreferences, LanguageSwitcher languageSwitcher) {
        this.f755a = context;
        this.f756b = suggestedLanguagesListHelper;
        this.f757c = fbSharedPreferences;
        this.f758d = languageSwitcher;
        this.f756b.m1019a();
    }

    public final LanguageSwitcherList m1109a() {
        return m1107a(true);
    }

    public final LanguageSwitcherList m1110b() {
        return m1107a(false);
    }

    private LanguageSwitcherList m1107a(boolean z) {
        int i;
        int i2 = -1;
        Builder builder = ImmutableMap.builder();
        String a = this.f757c.a(LanguageSwitcherCommonExPrefKeys.b, "device");
        if (z) {
            builder.b("device", this.f755a.getString(2131240203));
            if ("device".equals(a)) {
                i2 = 0;
            }
            i = i2;
            i2 = 1;
        } else {
            i = -1;
            i2 = 0;
        }
        ImmutableList c = this.f756b.m1020c();
        int size = c.size();
        int i3 = 0;
        int i4 = i2;
        while (i3 < size) {
            String str = (String) c.get(i3);
            builder.b(str, LocaleUtil.a(LocaleUtil.a(str)));
            if (str.equals(a)) {
                i2 = i4;
            } else {
                i2 = i;
            }
            i3++;
            i4++;
            i = i2;
        }
        ImmutableSet keySet = builder.b().keySet();
        Iterator it = this.f758d.d().iterator();
        while (it.hasNext()) {
            Locale locale = (Locale) it.next();
            String locale2 = locale.toString();
            if (keySet.contains(locale2)) {
                i2 = i;
            } else {
                builder.b(locale2, LocaleUtil.a(locale));
                if (locale2.equals(a)) {
                    i2 = i4;
                } else {
                    i2 = i;
                }
                i4++;
            }
            i = i2;
        }
        return new LanguageSwitcherList(builder.b(), i);
    }
}
