package com.facebook.contactlogs;

import com.facebook.contactlogs.logging.ContactLogsLoggingConstants.EventType;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: profile_wizard_refresher_step_skip */
class ContactLogsUploadRunner$1 implements FutureCallback<OperationResult> {
    final /* synthetic */ ContactLogsUploadRunner f6132a;

    public void onSuccess(Object obj) {
        String str = ContactLogsUploadRunner.a;
        m6480b();
        this.f6132a.j.a(EventType.UPLOAD_SUCCEEDED);
    }

    ContactLogsUploadRunner$1(ContactLogsUploadRunner contactLogsUploadRunner) {
        this.f6132a = contactLogsUploadRunner;
    }

    public void onFailure(Throwable th) {
        m6480b();
        this.f6132a.j.a(EventType.UPLOAD_FAILED);
    }

    private void m6480b() {
        this.f6132a.m = null;
    }
}
