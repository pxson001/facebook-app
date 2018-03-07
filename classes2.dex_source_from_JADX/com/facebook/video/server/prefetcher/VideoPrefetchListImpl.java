package com.facebook.video.server.prefetcher;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.prefetcher.VideoPrefetchModel.ListCallback;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: offersite/detail/?offer_id=%s&share_id=%s&site_uri=%s&title=%s&offer_code=%s&notif_trigger=%s&notif_medium=%s&rule=%s */
public class VideoPrefetchListImpl implements VideoPrefetchList {
    private static final String f11467a = VideoPrefetchListImpl.class.getSimpleName();
    private final ListCallback f11468b;
    private final AbstractFbErrorReporter f11469c;
    @GuardedBy("this")
    private final Deque<VideoResourceMetadata> f11470d = new ArrayDeque();
    public final VideoPrefetchLocation f11471e;
    @GuardedBy("this")
    private boolean f11472f = true;
    @GuardedBy("this")
    private boolean f11473g = false;

    public VideoPrefetchListImpl(ListCallback listCallback, AbstractFbErrorReporter abstractFbErrorReporter, VideoPrefetchLocation videoPrefetchLocation) {
        this.f11468b = listCallback;
        this.f11469c = abstractFbErrorReporter;
        this.f11471e = videoPrefetchLocation;
    }

    public final synchronized void mo2175a(VideoResourceMetadata... videoResourceMetadataArr) {
        if (!m16770f()) {
            for (VideoResourceMetadata videoResourceMetadata : videoResourceMetadataArr) {
                videoResourceMetadata.a();
                this.f11470d.addFirst(videoResourceMetadata);
            }
            this.f11468b.m16786a();
        }
    }

    public final synchronized void mo2178b(VideoResourceMetadata... videoResourceMetadataArr) {
        if (!m16770f()) {
            for (VideoResourceMetadata videoResourceMetadata : videoResourceMetadataArr) {
                if (!this.f11470d.contains(videoResourceMetadata)) {
                    videoResourceMetadata.a();
                    this.f11470d.addLast(videoResourceMetadata);
                }
            }
            this.f11468b.m16786a();
        }
    }

    public final synchronized void mo2179c(VideoResourceMetadata... videoResourceMetadataArr) {
        Object obj = null;
        synchronized (this) {
            if (!m16770f()) {
                for (Object remove : videoResourceMetadataArr) {
                    if (this.f11470d.remove(remove)) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    this.f11468b.m16787b();
                }
            }
        }
    }

    public final synchronized void m16771a(Uri uri) {
        if (!m16770f()) {
            Iterator it = this.f11470d.iterator();
            while (it.hasNext()) {
                if (uri.equals(((VideoResourceMetadata) it.next()).a())) {
                    it.remove();
                }
            }
        }
    }

    public final synchronized boolean m16778c() {
        boolean z;
        z = this.f11472f && !this.f11470d.isEmpty();
        return z;
    }

    @Nullable
    public final synchronized VideoResourceMetadata m16779d() {
        return (VideoResourceMetadata) this.f11470d.pollFirst();
    }

    public final synchronized boolean mo2176a() {
        boolean z;
        z = !this.f11473g && this.f11472f;
        return z;
    }

    public final synchronized void mo2174a(boolean z) {
        this.f11472f = z;
        this.f11468b.m16788c();
    }

    public final synchronized void mo2177b() {
        if (!m16770f()) {
            this.f11470d.clear();
        }
    }

    @GuardedBy("this")
    private boolean m16770f() {
        if (!this.f11473g) {
            return false;
        }
        this.f11469c.m2340a(f11467a, "Tried to access methods on a released list: " + this.f11471e);
        return true;
    }
}
