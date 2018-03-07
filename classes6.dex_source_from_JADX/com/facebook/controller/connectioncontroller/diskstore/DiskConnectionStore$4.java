package com.facebook.controller.connectioncontroller.diskstore;

import com.google.common.base.Predicate;

/* compiled from: options[] */
class DiskConnectionStore$4 implements Runnable {
    final /* synthetic */ String f8628a;
    final /* synthetic */ Predicate f8629b;
    final /* synthetic */ DiskConnectionStore f8630c;

    DiskConnectionStore$4(DiskConnectionStore diskConnectionStore, String str, Predicate predicate) {
        this.f8630c = diskConnectionStore;
        this.f8628a = str;
        this.f8629b = predicate;
    }

    public void run() {
        this.f8630c.k.a(this.f8630c.c, this.f8628a, this.f8629b);
    }
}
