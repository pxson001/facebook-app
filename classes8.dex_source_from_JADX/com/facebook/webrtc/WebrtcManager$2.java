package com.facebook.webrtc;

/* compiled from: location_opt_in_google_play_location_success */
class WebrtcManager$2 implements Runnable {
    final /* synthetic */ long f9833a;
    final /* synthetic */ String f9834b;
    final /* synthetic */ String f9835c;
    final /* synthetic */ boolean f9836d;
    final /* synthetic */ boolean f9837e;
    final /* synthetic */ boolean f9838f;
    final /* synthetic */ boolean f9839g;
    final /* synthetic */ String f9840h;
    final /* synthetic */ WebrtcManager f9841i;

    WebrtcManager$2(WebrtcManager webrtcManager, long j, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3) {
        this.f9841i = webrtcManager;
        this.f9833a = j;
        this.f9834b = str;
        this.f9835c = str2;
        this.f9836d = z;
        this.f9837e = z2;
        this.f9838f = z3;
        this.f9839g = z4;
        this.f9840h = str3;
    }

    public void run() {
        this.f9841i.w.startCall(this.f9833a, this.f9834b, this.f9835c, this.f9836d, this.f9837e, this.f9838f, this.f9839g, this.f9840h);
    }
}
