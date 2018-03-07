package com.facebook.contacts.upload;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.contacts.upload.logging.ContactsUploadLoggingConstants.Events;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: tapped_create_shortcut */
class ContinuousContactUploadClient$1 implements FutureCallback<OperationResult> {
    final /* synthetic */ ContinuousContactUploadClient f2191a;

    ContinuousContactUploadClient$1(ContinuousContactUploadClient continuousContactUploadClient) {
        this.f2191a = continuousContactUploadClient;
    }

    public void onSuccess(Object obj) {
        ContinuousContactUploadClient.a(this.f2191a);
        AnalyticsLogger analyticsLogger = this.f2191a.e.a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("contacts_upload_succeeded");
        honeyClientEvent.c = "contacts_upload";
        analyticsLogger.a(honeyClientEvent);
        this.f2191a.e.a(Events.CCU_UPLOAD_SUCCESSS);
        this.f2191a.e.b();
    }

    public void onFailure(Throwable th) {
        AnalyticsLogger analyticsLogger = this.f2191a.e.a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("contacts_upload_failed");
        honeyClientEvent.c = "contacts_upload";
        analyticsLogger.a(honeyClientEvent);
        this.f2191a.e.a(Events.CCU_UPLOAD_FAIL);
        if (th instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) th;
            if (serviceException.result.e == ErrorCode.API_ERROR) {
                boolean z;
                this.f2191a.f.a();
                this.f2191a.e.a(Events.SNAPSHOT_AND_IMPORT_ID_DELETED);
                ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.k();
                if (apiErrorResult == null || apiErrorResult.a() != 5910) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.f2191a.g.a(false);
                    this.f2191a.e.a(Events.TURN_OFF_CCU_AFTER_EXCEPTION);
                }
            }
        }
        this.f2191a.e.b();
    }
}
