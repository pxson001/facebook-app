package com.facebook.ui.toaster;

/* compiled from: comment_text */
class ClickableToastCoordinator$1 implements Runnable {
    final /* synthetic */ ClickableToast f5505a;
    final /* synthetic */ ClickableToastCoordinator f5506b;

    ClickableToastCoordinator$1(ClickableToastCoordinator clickableToastCoordinator, ClickableToast clickableToast) {
        this.f5506b = clickableToastCoordinator;
        this.f5505a = clickableToast;
    }

    public void run() {
        this.f5505a.m10354d();
    }
}
