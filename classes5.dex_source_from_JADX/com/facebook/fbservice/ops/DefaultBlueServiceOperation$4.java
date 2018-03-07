package com.facebook.fbservice.ops;

import com.facebook.fbservice.service.OperationResult;

/* compiled from: retrigger */
class DefaultBlueServiceOperation$4 implements Runnable {
    final /* synthetic */ OperationResult f3017a;
    final /* synthetic */ DefaultBlueServiceOperation f3018b;

    DefaultBlueServiceOperation$4(DefaultBlueServiceOperation defaultBlueServiceOperation, OperationResult operationResult) {
        this.f3018b = defaultBlueServiceOperation;
        this.f3017a = operationResult;
    }

    public void run() {
        if (!this.f3018b.g()) {
            DefaultBlueServiceOperation defaultBlueServiceOperation = this.f3018b;
            OperationResult operationResult = this.f3017a;
            if (!defaultBlueServiceOperation.n.isDone() && defaultBlueServiceOperation.w != null) {
                defaultBlueServiceOperation.w.m4188a(operationResult);
            }
        }
    }
}
