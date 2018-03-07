package com.facebook.katana.activity;

import com.facebook.apptab.state.TabTag;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$27 implements FutureCallback<OperationResult> {
    final /* synthetic */ FbMainTabActivity f24215a;

    FbMainTabActivity$27(FbMainTabActivity fbMainTabActivity) {
        this.f24215a = fbMainTabActivity;
    }

    public void onSuccess(Object obj) {
        if (this.f24215a.j()) {
            this.f24215a.m().e();
        } else {
            this.f24215a.i();
            this.f24215a.bX = true;
        }
        this.f24215a.bE.a(TabTag.Feed.name());
    }

    public void onFailure(Throwable th) {
        ((AbstractFbErrorReporter) this.f24215a.L.get()).a(FbMainTabActivity.bk.getSimpleName(), th);
    }
}
