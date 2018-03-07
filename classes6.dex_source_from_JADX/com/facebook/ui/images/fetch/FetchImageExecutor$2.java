package com.facebook.ui.images.fetch;

import com.facebook.widget.images.UrlImage.UrlImageProgressListener;

/* compiled from: secondary_option */
class FetchImageExecutor$2 implements Runnable {
    final /* synthetic */ UrlImageProgressListener f5109a;
    final /* synthetic */ FetchImageExecutor f5110b;

    FetchImageExecutor$2(FetchImageExecutor fetchImageExecutor, UrlImageProgressListener urlImageProgressListener) {
        this.f5110b = fetchImageExecutor;
        this.f5109a = urlImageProgressListener;
    }

    public void run() {
        this.f5109a.m8404a(0);
    }
}
