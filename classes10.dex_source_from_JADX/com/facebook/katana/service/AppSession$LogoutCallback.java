package com.facebook.katana.service;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.katana.service.AppSession.LoginStatus;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: tor */
class AppSession$LogoutCallback extends AbstractDisposableFutureCallback<OperationResult> {
    final /* synthetic */ AppSession f1174a;
    private final Set<AppSessionListener> f1175b;

    public AppSession$LogoutCallback(AppSession appSession, Set<AppSessionListener> set) {
        this.f1174a = appSession;
        this.f1175b = Sets.b(set);
    }

    protected final void m1199a(Object obj) {
        this.f1174a.s.c();
        for (AppSessionListener b : this.f1175b) {
            b.b(null);
        }
    }

    protected final void m1200a(Throwable th) {
        AppSession.a(this.f1174a, LoginStatus.STATUS_LOGGED_IN);
        for (AppSessionListener b : this.f1175b) {
            b.b(th);
        }
    }
}
