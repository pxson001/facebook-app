package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.google.common.base.Function;

/* compiled from: options[] */
class DiskConnectionStore$9 implements Function<Integer, Void> {
    final /* synthetic */ ConnectionState f8642a;
    final /* synthetic */ DiskConnectionStore f8643b;

    DiskConnectionStore$9(DiskConnectionStore diskConnectionStore, ConnectionState connectionState) {
        this.f8643b = diskConnectionStore;
        this.f8642a = connectionState;
    }

    public Object apply(Object obj) {
        this.f8643b.f.b(((Integer) obj).intValue(), 1, this.f8642a);
        return null;
    }
}
