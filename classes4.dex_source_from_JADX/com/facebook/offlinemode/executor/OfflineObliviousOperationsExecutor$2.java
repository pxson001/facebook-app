package com.facebook.offlinemode.executor;

import com.facebook.offlinemode.common.OfflineModeHelper$ProcessQueueTrigger;

/* compiled from: getHeadersForVideo-PARTIAL */
class OfflineObliviousOperationsExecutor$2 implements Runnable {
    final /* synthetic */ OfflineModeHelper$ProcessQueueTrigger f11154a;
    final /* synthetic */ OfflineObliviousOperationsExecutor f11155b;

    OfflineObliviousOperationsExecutor$2(OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor, OfflineModeHelper$ProcessQueueTrigger offlineModeHelper$ProcessQueueTrigger) {
        this.f11155b = offlineObliviousOperationsExecutor;
        this.f11154a = offlineModeHelper$ProcessQueueTrigger;
    }

    public void run() {
        try {
            OfflineObliviousOperationsExecutor.b(this.f11155b, this.f11154a);
        } finally {
            this.f11155b.j.set(false);
        }
    }
}
