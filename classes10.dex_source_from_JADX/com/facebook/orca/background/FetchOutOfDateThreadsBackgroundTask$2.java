package com.facebook.orca.background;

import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: page_section_types */
class FetchOutOfDateThreadsBackgroundTask$2 extends SimpleBackgroundResultFutureCallback {
    final /* synthetic */ ThreadKey f5233a;
    final /* synthetic */ FetchOutOfDateThreadsBackgroundTask f5234b;

    FetchOutOfDateThreadsBackgroundTask$2(FetchOutOfDateThreadsBackgroundTask fetchOutOfDateThreadsBackgroundTask, Class cls, ThreadKey threadKey) {
        this.f5234b = fetchOutOfDateThreadsBackgroundTask;
        this.f5233a = threadKey;
        super(cls);
    }

    public /* synthetic */ void onSuccess(Object obj) {
        m4680a((OperationResult) obj);
    }

    public final void m4680a(OperationResult operationResult) {
        super.a(operationResult);
        this.f5234b.c.put(this.f5233a, Long.valueOf(this.f5234b.h.a()));
    }
}
