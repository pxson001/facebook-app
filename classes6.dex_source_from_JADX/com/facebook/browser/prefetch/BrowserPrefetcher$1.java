package com.facebook.browser.prefetch;

/* compiled from: privacy_scope_edit */
class BrowserPrefetcher$1 implements Runnable {
    final /* synthetic */ String f7419a;
    final /* synthetic */ String f7420b;
    final /* synthetic */ boolean f7421c;
    final /* synthetic */ BrowserPrefetcher f7422d;

    BrowserPrefetcher$1(BrowserPrefetcher browserPrefetcher, String str, String str2, boolean z) {
        this.f7422d = browserPrefetcher;
        this.f7419a = str;
        this.f7420b = str2;
        this.f7421c = z;
    }

    public void run() {
        BrowserPrefetcher.b(this.f7422d, this.f7419a, this.f7420b, this.f7421c);
    }
}
