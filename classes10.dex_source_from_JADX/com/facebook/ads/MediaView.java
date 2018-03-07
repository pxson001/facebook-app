package com.facebook.ads;

import android.widget.RelativeLayout;
import com.facebook.ads.internal.util.C1986k;
import com.facebook.ads.internal.util.C1994r;
import com.facebook.ads.internal.view.C2000e;
import com.facebook.ads.internal.view.video.C2002a;

public class MediaView extends RelativeLayout {
    private final C2000e f13900a;
    private final C2002a f13901b;
    private boolean f13902c;
    private boolean f13903d;

    private static boolean m14172a(NativeAd nativeAd) {
        return !C1994r.m14486a(nativeAd.m14195i());
    }

    public void setAutoplay(boolean z) {
        this.f13903d = z;
        this.f13901b.f14390f = z;
    }

    public void setNativeAd(NativeAd nativeAd) {
        nativeAd.m14186a(true);
        nativeAd.m14188b(this.f13903d);
        if (this.f13902c) {
            this.f13900a.m14491a(null, null);
            this.f13901b.m14494b();
            this.f13902c = false;
        }
        if (m14172a(nativeAd)) {
            this.f13900a.setVisibility(4);
            this.f13901b.setVisibility(0);
            bringChildToFront(this.f13901b);
            this.f13902c = true;
            try {
                this.f13901b.setVideoPlayReportURI(nativeAd.m14196j());
                this.f13901b.setVideoTimeReportURI(nativeAd.m14197k());
                this.f13901b.setVideoURI(nativeAd.m14195i());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (nativeAd.m14187b() != null) {
            this.f13901b.m14493a();
            this.f13901b.setVisibility(4);
            this.f13900a.setVisibility(0);
            bringChildToFront(this.f13900a);
            this.f13902c = true;
            new C1986k(this.f13900a).execute(new String[]{nativeAd.m14187b().m14176a()});
        }
    }
}
