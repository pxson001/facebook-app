package com.facebook.orca.notify;

import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;

/* compiled from: non_critical/ */
class MessagingNotificationUtil$4 extends OperationResultFutureCallback {
    final /* synthetic */ int f6258a;
    final /* synthetic */ MessagingNotificationUtil f6259b;

    MessagingNotificationUtil$4(MessagingNotificationUtil messagingNotificationUtil, int i) {
        this.f6259b = messagingNotificationUtil;
        this.f6258a = i;
    }

    protected final void m5958a(ServiceException serviceException) {
        this.f6259b.m.n(this.f6258a);
    }

    protected final void m5959a(Object obj) {
        this.f6259b.m.o(this.f6258a);
    }
}
