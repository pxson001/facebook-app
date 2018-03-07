package com.facebook.gk.store;

/* compiled from: remoteBinder is the wrong class. */
public class GatekeeperRepository$1 implements Runnable {
    final /* synthetic */ GatekeeperCache f3174a;
    final /* synthetic */ GatekeeperRepository f3175b;

    public GatekeeperRepository$1(GatekeeperRepository gatekeeperRepository, GatekeeperCache gatekeeperCache) {
        this.f3175b = gatekeeperRepository;
        this.f3174a = gatekeeperCache;
    }

    public void run() {
        GatekeeperRepository.e(this.f3175b, this.f3174a);
    }
}
