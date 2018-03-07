package com.facebook.controller.connectioncontroller;

import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;

/* compiled from: otherUserFbId */
public class ConnectionControllerImpl$3 implements Runnable {
    final /* synthetic */ ConnectionLocation f8546a;
    final /* synthetic */ ConnectionOrder f8547b;
    final /* synthetic */ ConnectionControllerImpl f8548c;

    public ConnectionControllerImpl$3(ConnectionControllerImpl connectionControllerImpl, ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        this.f8548c = connectionControllerImpl;
        this.f8546a = connectionLocation;
        this.f8547b = connectionOrder;
    }

    public void run() {
        this.f8548c.i.a(this.f8546a, this.f8547b);
    }
}
