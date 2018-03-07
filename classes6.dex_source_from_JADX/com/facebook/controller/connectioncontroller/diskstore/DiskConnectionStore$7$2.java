package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.diskstore.DiskConnectionStore.7;

/* compiled from: options[] */
class DiskConnectionStore$7$2 implements Runnable {
    final /* synthetic */ ConnectionState f8638a;
    final /* synthetic */ 7 f8639b;

    DiskConnectionStore$7$2(7 7, ConnectionState connectionState) {
        this.f8639b = 7;
        this.f8638a = connectionState;
    }

    public void run() {
        this.f8639b.b.n.b(9568258, this.f8639b.a, (short) 2);
        ConnectionState a = DiskConnectionStore.a(this.f8639b.b, this.f8638a);
        if (this.f8638a.d() > 0) {
            this.f8639b.b.f.a(0, this.f8638a.d(), a, false);
        }
        this.f8639b.b.f.b();
        DiskConnectionStore.b(this.f8639b.b, a);
    }
}
