package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.common.executors.IncrementalRunnable;
import java.util.concurrent.ExecutorService;

/* compiled from: order_friends_by */
class CursorConnectionState$LookAheadReader extends IncrementalRunnable {
    final /* synthetic */ CursorConnectionState f8613a;

    public CursorConnectionState$LookAheadReader(CursorConnectionState cursorConnectionState, ExecutorService executorService) {
        this.f8613a = cursorConnectionState;
        super(executorService);
    }

    public final void m12430b() {
        if (this.f8613a.f + 10 > this.f8613a.g) {
            CursorConnectionState.a(this.f8613a, this.f8613a.g + 1, true);
        }
    }

    public final boolean m12431c() {
        return this.f8613a.g < this.f8613a.d() + -1;
    }
}
