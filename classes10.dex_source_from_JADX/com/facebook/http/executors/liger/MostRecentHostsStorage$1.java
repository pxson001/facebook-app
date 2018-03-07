package com.facebook.http.executors.liger;

/* compiled from: TAIL_LOAD */
class MostRecentHostsStorage$1 implements Runnable {
    final /* synthetic */ String f23327a;
    final /* synthetic */ MostRecentHostsStorage f23328b;

    MostRecentHostsStorage$1(MostRecentHostsStorage mostRecentHostsStorage, String str) {
        this.f23328b = mostRecentHostsStorage;
        this.f23327a = str;
    }

    public void run() {
        MostRecentHostsStorage.b(this.f23328b, this.f23327a);
        this.f23328b.g.set(false);
    }
}
