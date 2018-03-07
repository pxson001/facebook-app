package com.facebook.megaphone.data;

import com.facebook.feed.megaphone.MegaphoneController;

/* compiled from: twitter */
class MegaphoneStore$3 implements Runnable {
    final /* synthetic */ MegaphoneController f1300a;
    final /* synthetic */ MegaphoneStore f1301b;

    MegaphoneStore$3(MegaphoneStore megaphoneStore, MegaphoneController megaphoneController) {
        this.f1301b = megaphoneStore;
        this.f1300a = megaphoneController;
    }

    public void run() {
        this.f1300a.d.hL_();
    }
}
