package com.facebook.appupdate;

/* compiled from: UPDATE threads SET approx_total_message_count=1 */
final class AppUpdateInjector$2 implements Runnable {
    final /* synthetic */ InitWithInjector f23768a;
    final /* synthetic */ AppUpdateInjector f23769b;

    AppUpdateInjector$2(InitWithInjector initWithInjector, AppUpdateInjector appUpdateInjector) {
        this.f23768a = initWithInjector;
        this.f23769b = appUpdateInjector;
    }

    public final void run() {
        this.f23768a.mo1101a(this.f23769b);
    }
}
