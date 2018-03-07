package com.facebook.contacts.properties;

import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: page_saved_reply */
class CollationChangedTracker$1 extends OperationResultFutureCallback2 {
    final /* synthetic */ CollationChangedTracker f8377a;

    CollationChangedTracker$1(CollationChangedTracker collationChangedTracker) {
        this.f8377a = collationChangedTracker;
    }

    protected final void m12226a(OperationResult operationResult) {
    }

    protected final void m12228a(Throwable th) {
        BLog.b(CollationChangedTracker.a, th, "failed to redindex contacts db", new Object[0]);
    }
}
