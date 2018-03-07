package com.facebook.orca.background;

import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: pageProps */
class FetchThreadsIntoMemoryCacheBackgroundTask$3 implements Runnable {
    final /* synthetic */ ThreadKey f5253a;
    final /* synthetic */ FetchThreadsIntoMemoryCacheBackgroundTask f5254b;

    FetchThreadsIntoMemoryCacheBackgroundTask$3(FetchThreadsIntoMemoryCacheBackgroundTask fetchThreadsIntoMemoryCacheBackgroundTask, ThreadKey threadKey) {
        this.f5254b = fetchThreadsIntoMemoryCacheBackgroundTask;
        this.f5253a = threadKey;
    }

    public void run() {
        synchronized (this.f5254b.g) {
            this.f5254b.g.remove(this.f5253a);
        }
    }
}
