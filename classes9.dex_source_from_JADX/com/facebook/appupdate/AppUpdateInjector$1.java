package com.facebook.appupdate;

/* compiled from: UPDATE threads SET approx_total_message_count=1 */
final class AppUpdateInjector$1 implements Runnable {
    final /* synthetic */ InitWithInjector f23766a;
    final /* synthetic */ AppUpdateInjector f23767b;

    AppUpdateInjector$1(InitWithInjector initWithInjector, AppUpdateInjector appUpdateInjector) {
        this.f23766a = initWithInjector;
        this.f23767b = appUpdateInjector;
    }

    public final void run() {
        this.f23766a.mo1101a(this.f23767b);
    }
}
