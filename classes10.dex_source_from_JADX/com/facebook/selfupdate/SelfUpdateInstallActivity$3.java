package com.facebook.selfupdate;

import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: has_pin */
class SelfUpdateInstallActivity$3 implements Runnable {
    final /* synthetic */ String f9993a;
    final /* synthetic */ ObjectNode f9994b;
    final /* synthetic */ SelfUpdateInstallActivity f9995c;

    SelfUpdateInstallActivity$3(SelfUpdateInstallActivity selfUpdateInstallActivity, String str, ObjectNode objectNode) {
        this.f9995c = selfUpdateInstallActivity;
        this.f9993a = str;
        this.f9994b = objectNode;
    }

    public void run() {
        this.f9995c.q.m10102a("cancelnag_" + this.f9993a, this.f9994b);
    }
}
