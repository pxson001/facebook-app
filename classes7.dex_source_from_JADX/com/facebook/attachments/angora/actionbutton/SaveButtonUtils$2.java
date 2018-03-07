package com.facebook.attachments.angora.actionbutton;

import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;

/* compiled from: user_ids */
class SaveButtonUtils$2 extends ResultFutureCallback<OperationResult> {
    final /* synthetic */ SaveButtonUtils f877a;

    SaveButtonUtils$2(SaveButtonUtils saveButtonUtils) {
        this.f877a = saveButtonUtils;
    }

    protected final void m866a(ServiceException serviceException) {
        this.f877a.i.a(this.f877a.getClass().getSimpleName(), serviceException);
    }

    protected final void m867a(Object obj) {
        this.f877a.p.c();
    }
}
