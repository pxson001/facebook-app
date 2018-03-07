package com.facebook.common.dispose;

/* compiled from: stop MediaRecorder failed */
class DisposableContextHelper$1 implements Runnable {
    final /* synthetic */ AbstractListenableDisposable f2525a;
    final /* synthetic */ DisposableContextHelper f2526b;

    DisposableContextHelper$1(DisposableContextHelper disposableContextHelper, AbstractListenableDisposable abstractListenableDisposable) {
        this.f2526b = disposableContextHelper;
        this.f2525a = abstractListenableDisposable;
    }

    public void run() {
        this.f2525a.jc_();
    }
}
