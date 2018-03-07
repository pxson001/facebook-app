package com.facebook.ui.toaster;

/* compiled from: comment_text */
class ClickableToastCoordinator$2 implements Runnable {
    final /* synthetic */ ClickableToast f5507a;
    final /* synthetic */ ClickableToastCoordinator f5508b;

    ClickableToastCoordinator$2(ClickableToastCoordinator clickableToastCoordinator, ClickableToast clickableToast) {
        this.f5508b = clickableToastCoordinator;
        this.f5507a = clickableToast;
    }

    public void run() {
        this.f5507a.m10353c();
        this.f5508b.b = true;
    }
}
