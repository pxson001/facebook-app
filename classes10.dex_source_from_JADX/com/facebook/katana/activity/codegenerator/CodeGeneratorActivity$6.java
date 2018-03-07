package com.facebook.katana.activity.codegenerator;

import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: user_for_settings */
class CodeGeneratorActivity$6 extends OperationResultFutureCallback {
    final /* synthetic */ CodeGeneratorActivity f707a;

    CodeGeneratorActivity$6(CodeGeneratorActivity codeGeneratorActivity) {
        this.f707a = codeGeneratorActivity;
    }

    public final void m722a(Object obj) {
        CheckCodeResult checkCodeResult = (CheckCodeResult) ((OperationResult) obj).h();
        long parseLong = Long.parseLong(checkCodeResult.f699b);
        String str = checkCodeResult.f698a;
        this.f707a.s.edit().a((PrefKey) FbandroidPrefKeys.e.a((String) this.f707a.p.get()), parseLong).commit();
        if (!"1".equals(str) && Math.abs(this.f707a.G.longValue() - parseLong) <= CodeGeneratorActivity.A) {
            CodeGeneratorActivity.c(this.f707a.s, this.f707a.q, this.f707a.r, (String) this.f707a.p.get());
        }
    }

    protected final void m721a(ServiceException serviceException) {
    }
}
