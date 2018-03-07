package com.facebook.controller.connectioncontroller.diskstore;

import android.os.Bundle;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.ConnectionState;

/* compiled from: options[] */
class DiskConnectionStore$2 implements Runnable {
    final /* synthetic */ int f8616a;
    final /* synthetic */ CursorConnectionState f8617b;
    final /* synthetic */ boolean f8618c;
    final /* synthetic */ int f8619d;
    final /* synthetic */ ConnectionPage f8620e;
    final /* synthetic */ boolean f8621f;
    final /* synthetic */ Bundle f8622g;
    final /* synthetic */ ConnectionLocation f8623h;
    final /* synthetic */ ConnectionOrder f8624i;
    final /* synthetic */ DiskConnectionStore f8625j;

    DiskConnectionStore$2(DiskConnectionStore diskConnectionStore, int i, CursorConnectionState cursorConnectionState, boolean z, int i2, ConnectionPage connectionPage, boolean z2, Bundle bundle, ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        this.f8625j = diskConnectionStore;
        this.f8616a = i;
        this.f8617b = cursorConnectionState;
        this.f8618c = z;
        this.f8619d = i2;
        this.f8620e = connectionPage;
        this.f8621f = z2;
        this.f8622g = bundle;
        this.f8623h = connectionLocation;
        this.f8624i = connectionOrder;
    }

    public void run() {
        this.f8625j.n.b(9568257, this.f8616a, (short) 2);
        ConnectionState a = DiskConnectionStore.a(this.f8625j, this.f8617b);
        if (this.f8618c && a.d() > 0) {
            this.f8625j.f.a();
        }
        this.f8625j.f.a(this.f8619d, this.f8620e.f8599b.size(), a, this.f8621f);
        DiskConnectionStore.a(this.f8625j, a, this.f8617b, this.f8622g);
        this.f8625j.f.a(this.f8623h, this.f8624i);
        DiskConnectionStore.b(this.f8625j, a);
    }
}
