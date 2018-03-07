package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.controller.connectioncontroller.diskstore.DiskConnectionStore.7;

/* compiled from: options[] */
class DiskConnectionStore$7$1 implements Runnable {
    final /* synthetic */ CursorConnectionState f8636a;
    final /* synthetic */ 7 f8637b;

    DiskConnectionStore$7$1(7 7, CursorConnectionState cursorConnectionState) {
        this.f8637b = 7;
        this.f8636a = cursorConnectionState;
    }

    public void run() {
        DiskConnectionStore.b(this.f8637b.b, this.f8636a);
    }
}
