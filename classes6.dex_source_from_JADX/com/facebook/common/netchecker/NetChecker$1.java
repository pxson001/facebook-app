package com.facebook.common.netchecker;

/* compiled from: place_picker_people_to_place_start */
class NetChecker$1 implements Runnable {
    final /* synthetic */ long f7749a;
    final /* synthetic */ NetChecker f7750b;

    NetChecker$1(NetChecker netChecker, long j) {
        this.f7750b = netChecker;
        this.f7749a = j;
    }

    public void run() {
        if (!m11063a()) {
            NetCheckState a = this.f7750b.d.a();
            synchronized (this.f7750b) {
                if (m11063a()) {
                    return;
                }
                NetChecker.a(this.f7750b, NetChecker.a);
                NetChecker.a(this.f7750b, this.f7750b.c.now());
                NetChecker.a(this.f7750b, a);
            }
        }
    }

    private boolean m11063a() {
        return Thread.interrupted() || this.f7750b.f.t() != this.f7749a;
    }
}
