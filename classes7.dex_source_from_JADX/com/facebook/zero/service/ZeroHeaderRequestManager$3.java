package com.facebook.zero.service;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: width_of_notification */
class ZeroHeaderRequestManager$3 implements FutureCallback<OperationResult> {
    final /* synthetic */ ZeroHeaderRequestManager f228a;

    public void onFailure(Throwable th) {
        Class cls = ZeroHeaderRequestManager.a;
        th.getMessage();
    }

    public void onSuccess(Object obj) {
        Class cls = ZeroHeaderRequestManager.a;
        ((BaseFbBroadcastManager) this.f228a.g.get()).a("com.facebook.zero.ZERO_HEADER_REFRESH_COMPLETED");
    }

    ZeroHeaderRequestManager$3(ZeroHeaderRequestManager zeroHeaderRequestManager) {
        this.f228a = zeroHeaderRequestManager;
    }
}
