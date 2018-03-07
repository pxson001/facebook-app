package com.facebook.zero.service;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;

/* compiled from: width_of_notification */
class ZeroHeaderRequestManager$1 implements FutureCallback<OperationResult> {
    final /* synthetic */ ZeroHeaderRequestManager f226a;

    ZeroHeaderRequestManager$1(ZeroHeaderRequestManager zeroHeaderRequestManager) {
        this.f226a = zeroHeaderRequestManager;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
    }

    public void onFailure(Throwable th) {
        if (th instanceof CancellationException) {
            Class cls = ZeroHeaderRequestManager.a;
            return;
        }
        ZeroHeaderRequestManager zeroHeaderRequestManager = this.f226a;
        th.getMessage();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("zero_header_request_params_fetch_failed");
        honeyClientEvent.c = "zero_module";
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.a("exception_message", th);
        ((AnalyticsLogger) zeroHeaderRequestManager.d.get()).a(honeyClientEvent2);
    }
}
