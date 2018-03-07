package com.facebook.fbservice.service;

import com.facebook.fbservice.service.BlueServiceQueue.OperationHolder;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: response_version */
class BlueServiceQueue$4 implements FutureCallback<OperationResult> {
    final /* synthetic */ OperationHolder f3051a;
    final /* synthetic */ BlueServiceQueue f3052b;

    BlueServiceQueue$4(BlueServiceQueue blueServiceQueue, OperationHolder operationHolder) {
        this.f3052b = blueServiceQueue;
        this.f3051a = operationHolder;
    }

    public void onSuccess(Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        Preconditions.checkState(this.f3052b.r.b());
        BlueServiceQueue.b(this.f3052b, this.f3051a, operationResult);
        this.f3052b.s = null;
        BlueServiceQueue.a(this.f3052b, 0);
    }

    public void onFailure(Throwable th) {
        Preconditions.checkState(this.f3052b.r.b());
        BlueServiceQueue.b(this.f3052b, this.f3051a, OperationResult.a(ErrorCodeUtil.a(th), ErrorCodeUtil.b(th), th));
        this.f3052b.s = null;
        BlueServiceQueue.a(this.f3052b, 0);
    }
}
