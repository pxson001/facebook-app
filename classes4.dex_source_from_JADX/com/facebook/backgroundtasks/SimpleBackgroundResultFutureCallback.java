package com.facebook.backgroundtasks;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: error_detail_type */
public class SimpleBackgroundResultFutureCallback extends AbstractFuture<BackgroundResult> implements FutureCallback<OperationResult> {
    private final Class<?> f12809a;

    public /* synthetic */ void onSuccess(Object obj) {
        mo305a((OperationResult) obj);
    }

    public SimpleBackgroundResultFutureCallback(Class<?> cls) {
        this.f12809a = cls;
    }

    public void mo305a(OperationResult operationResult) {
        a(new BackgroundResult(true));
    }

    public void onFailure(Throwable th) {
        a(new BackgroundResult(false));
    }
}
