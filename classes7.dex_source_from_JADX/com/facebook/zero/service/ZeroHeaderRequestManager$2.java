package com.facebook.zero.service;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.server.FetchZeroHeaderRequestResult;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: width_of_notification */
class ZeroHeaderRequestManager$2 implements AsyncFunction<OperationResult, OperationResult> {
    final /* synthetic */ ZeroHeaderRequestManager f227a;

    ZeroHeaderRequestManager$2(ZeroHeaderRequestManager zeroHeaderRequestManager) {
        this.f227a = zeroHeaderRequestManager;
    }

    public final ListenableFuture m231a(Object obj) {
        FetchZeroHeaderRequestResult fetchZeroHeaderRequestResult = (FetchZeroHeaderRequestResult) ((OperationResult) obj).g().getParcelable("result");
        Class cls = ZeroHeaderRequestManager.a;
        this.f227a.i.edit().a(ZeroPrefKeys.t, fetchZeroHeaderRequestResult.f()).commit();
        if ("enabled".equals(fetchZeroHeaderRequestResult.a())) {
            return ZeroHeaderRequestManager.b(this.f227a, fetchZeroHeaderRequestResult);
        }
        return Futures.a(OperationResult.a(ErrorCode.OTHER, "Zero header request not sent because status is " + fetchZeroHeaderRequestResult.a()));
    }
}
