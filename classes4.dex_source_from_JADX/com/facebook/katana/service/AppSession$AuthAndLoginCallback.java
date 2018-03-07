package com.facebook.katana.service;

import android.content.Intent;
import com.facebook.auth.login.AuthStateMachineMonitor;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.katana.service.AppSession.LoginStatus;

/* compiled from: unexpected exception */
public class AppSession$AuthAndLoginCallback extends AbstractDisposableFutureCallback<OperationResult> {
    final /* synthetic */ AppSession f1274a;

    public AppSession$AuthAndLoginCallback(AppSession appSession) {
        this.f1274a = appSession;
    }

    protected final void m1512a(Object obj) {
        this.f1274a.e();
    }

    protected final void m1513a(Throwable th) {
        AuthStateMachineMonitor authStateMachineMonitor = this.f1274a.s;
        Intent intent = new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_FAILED");
        if (th != null) {
            intent.putExtra("AUTH_FAILED_THROWABLE", th);
        }
        authStateMachineMonitor.a.a(intent);
        AppSession.a(this.f1274a, LoginStatus.STATUS_LOGGED_OUT);
        for (AppSessionListener a : this.f1274a.a.a()) {
            a.mo65a(th);
        }
    }
}
