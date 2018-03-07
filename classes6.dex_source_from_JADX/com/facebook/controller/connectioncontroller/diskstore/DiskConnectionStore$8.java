package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.google.common.base.Function;

/* compiled from: options[] */
class DiskConnectionStore$8 implements Function<Integer, Void> {
    final /* synthetic */ ConnectionState f8640a;
    final /* synthetic */ DiskConnectionStore f8641b;

    DiskConnectionStore$8(DiskConnectionStore diskConnectionStore, ConnectionState connectionState) {
        this.f8641b = diskConnectionStore;
        this.f8640a = connectionState;
    }

    public Object apply(Object obj) {
        this.f8641b.f.a(((Integer) obj).intValue(), 1, this.f8640a);
        return null;
    }
}
