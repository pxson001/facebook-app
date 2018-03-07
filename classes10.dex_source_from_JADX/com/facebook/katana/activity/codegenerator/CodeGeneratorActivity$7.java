package com.facebook.katana.activity.codegenerator;

import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Strings;

/* compiled from: user_for_settings */
public final class CodeGeneratorActivity$7 extends OperationResultFutureCallback {
    final /* synthetic */ String f708a;
    final /* synthetic */ FbSharedPreferences f709b;

    public CodeGeneratorActivity$7(String str, FbSharedPreferences fbSharedPreferences) {
        this.f708a = str;
        this.f709b = fbSharedPreferences;
    }

    public final void m724a(Object obj) {
        FetchCodeResult fetchCodeResult = (FetchCodeResult) ((OperationResult) obj).h();
        String str = fetchCodeResult.a;
        long parseLong = Long.parseLong(fetchCodeResult.b);
        this.f709b.edit().a((PrefKey) FbandroidPrefKeys.e.a(this.f708a), parseLong).commit();
        if (!Strings.isNullOrEmpty(str)) {
            this.f709b.edit().a((PrefKey) FbandroidPrefKeys.f.a(this.f708a), str).commit();
        }
    }

    protected final void m723a(ServiceException serviceException) {
    }
}
