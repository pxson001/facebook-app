package com.facebook.orca.background;

import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: page_icon_size */
class FetchThreadListBackgroundTask$1 extends SimpleBackgroundResultFutureCallback {
    final /* synthetic */ int f5247a;
    final /* synthetic */ FetchThreadListBackgroundTask f5248b;

    FetchThreadListBackgroundTask$1(FetchThreadListBackgroundTask fetchThreadListBackgroundTask, Class cls, int i) {
        this.f5248b = fetchThreadListBackgroundTask;
        this.f5247a = i;
        super(cls);
    }

    public /* synthetic */ void onSuccess(Object obj) {
        m4686a((OperationResult) obj);
    }

    public final void m4686a(OperationResult operationResult) {
        super.a(operationResult);
        this.f5248b.i.f(this.f5247a);
    }

    public void onFailure(Throwable th) {
        super.onFailure(th);
        this.f5248b.i.g(this.f5247a);
    }
}
