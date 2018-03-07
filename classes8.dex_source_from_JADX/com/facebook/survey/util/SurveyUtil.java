package com.facebook.survey.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;

/* compiled from: me.msqrd.android */
public class SurveyUtil {
    public static final PrefKey f9043c = ((PrefKey) SharedPrefKeys.a.a("survey/"));
    private final SecureContextHelper f9044a;
    public final FbSharedPreferences f9045b;

    public static SurveyUtil m10800b(InjectorLike injectorLike) {
        return new SurveyUtil((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public SurveyUtil(SecureContextHelper secureContextHelper, FbSharedPreferences fbSharedPreferences) {
        this.f9044a = secureContextHelper;
        this.f9045b = fbSharedPreferences;
    }

    public final void m10801a(long j, Context context) {
        this.f9044a.a(new Intent("android.intent.action.VIEW").setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("survey/%s"), Long.valueOf(j)))), context);
    }
}
