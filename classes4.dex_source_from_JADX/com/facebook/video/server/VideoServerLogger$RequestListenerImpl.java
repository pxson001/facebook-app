package com.facebook.video.server;

import android.net.NetworkInfo;
import android.net.Uri;
import com.facebook.common.iolite.ProgressOutputStream.Listener;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.analytics.VideoPerformanceTracking;

/* compiled from: page_query */
public class VideoServerLogger$RequestListenerImpl {
    final /* synthetic */ VideoServerLogger f5455a;
    private String f5456b;
    private Uri f5457c;
    private int f5458d;
    public long f5459e = 0;
    public long f5460f = 0;
    private long f5461g;
    public long f5462h;
    private long f5463i;
    private boolean f5464j;
    private Range f5465k;
    private boolean f5466l;
    private String f5467m;
    private boolean f5468n;
    private Listener f5469o;
    public Listener f5470p;

    public VideoServerLogger$RequestListenerImpl(final VideoServerLogger videoServerLogger, String str, Uri uri, int i, boolean z) {
        this.f5455a = videoServerLogger;
        this.f5456b = str;
        this.f5457c = uri;
        this.f5458d = i;
        this.f5461g = videoServerLogger.a.now();
        this.f5462h = -1;
        this.f5466l = z;
        this.f5469o = new Listener(this) {
            final /* synthetic */ VideoServerLogger$RequestListenerImpl f5472b;

            public final void m5928a(long j, long j2) {
                VideoServerLogger$RequestListenerImpl videoServerLogger$RequestListenerImpl = this.f5472b;
                videoServerLogger$RequestListenerImpl.f5459e += j;
            }
        };
        this.f5470p = new Listener(this) {
            final /* synthetic */ VideoServerLogger$RequestListenerImpl f5474b;

            public final void m5929a(long j, long j2) {
                if (this.f5474b.f5462h < 0) {
                    this.f5474b.f5462h = this.f5474b.f5455a.a.now();
                }
                VideoServerLogger$RequestListenerImpl videoServerLogger$RequestListenerImpl = this.f5474b;
                videoServerLogger$RequestListenerImpl.f5460f += j;
            }
        };
    }

    public final void m5925a(boolean z, Range range) {
        this.f5464j = z;
        this.f5465k = range;
    }

    public final Listener m5923a() {
        return this.f5469o;
    }

    public final void m5927c() {
        m5922d();
        ((VideoPerformanceTracking) this.f5455a.c.get()).a(this.f5456b, this.f5457c, this.f5458d, this.f5460f, this.f5459e, this.f5464j, this.f5465k, this.f5467m, this.f5468n, this.f5463i - this.f5461g, this.f5462h - this.f5461g);
    }

    public final void m5924a(Throwable th) {
        m5922d();
        ((VideoPerformanceTracking) this.f5455a.c.get()).a(this.f5456b, this.f5457c, this.f5458d, th, this.f5460f, this.f5459e, this.f5464j, this.f5465k, this.f5467m, this.f5468n, this.f5463i - this.f5461g, this.f5462h - this.f5461g);
    }

    public final void m5926b(Throwable th) {
        ((VideoPerformanceTracking) this.f5455a.c.get()).a(this.f5456b, this.f5457c, this.f5458d, th, this.f5464j, this.f5465k, this.f5467m, this.f5463i - this.f5461g);
    }

    private void m5922d() {
        this.f5463i = this.f5455a.a.now();
        NetworkInfo i = this.f5455a.b.i();
        this.f5467m = i == null ? "not_available" : i.getTypeName();
        boolean z = i != null && i.getType() == 1;
        this.f5468n = z;
        if (this.f5466l) {
            this.f5455a.d.a("video_download" + (this.f5468n ? "_wifi" : "_mobile") + "_received", this.f5459e);
        }
    }
}
