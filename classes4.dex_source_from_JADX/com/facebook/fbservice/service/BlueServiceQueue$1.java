package com.facebook.fbservice.service;

import com.facebook.fbservice.service.BlueServiceQueue.OperationHolder;

/* compiled from: gms_enabled */
class BlueServiceQueue$1 implements Runnable {
    final /* synthetic */ BlueServiceQueue f11029a;

    BlueServiceQueue$1(BlueServiceQueue blueServiceQueue) {
        this.f11029a = blueServiceQueue;
    }

    public void run() {
        if (this.f11029a.r != null) {
            this.f11029a.r.a();
        }
        OperationHolder operationHolder = this.f11029a.s;
        if (operationHolder != null) {
            operationHolder.h.cancel(false);
        }
        this.f11029a.e.b(this.f11029a);
    }
}
