package com.facebook.video.api.playersession;

import android.support.v4.util.LruCache;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.video.api.playersession.VideoPlayerSessionBase.SessionState;

/* compiled from: previous_cache_size */
public class VideoPlayerSessionManager {
    private static final Class<?> f9076a = VideoPlayerSessionManager.class;
    private final boolean f9077b;
    private final LruCache<Integer, VideoPlayerSessionBase> f9078c = new LruCache(HTTPTransportCallback.BODY_BYTES_RECEIVED);
    private volatile boolean f9079d = false;

    public VideoPlayerSessionManager(boolean z) {
        this.f9077b = z;
    }

    public final void m13970a(int i, VideoPlayerSessionBase videoPlayerSessionBase) {
        if (i >= 0 && this.f9077b) {
            synchronized (this.f9078c) {
                this.f9078c.m4433a(Integer.valueOf(i), (Object) videoPlayerSessionBase);
            }
            Integer.valueOf(i);
            Boolean.valueOf(videoPlayerSessionBase.c());
        }
    }

    public final void m13967a(int i) {
        if (i >= 0 && this.f9077b) {
            synchronized (this.f9078c) {
                VideoPlayerSessionBase videoPlayerSessionBase = (VideoPlayerSessionBase) this.f9078c.m4432a(Integer.valueOf(i));
                if (videoPlayerSessionBase != null) {
                    videoPlayerSessionBase.a = SessionState.STOP;
                    videoPlayerSessionBase.b = -1;
                }
            }
            Integer.valueOf(i);
        }
    }

    public final VideoPlayerSessionBase m13972b(int i) {
        if (!this.f9077b || i < 0) {
            return null;
        }
        VideoPlayerSessionBase videoPlayerSessionBase;
        synchronized (this.f9078c) {
            videoPlayerSessionBase = (VideoPlayerSessionBase) this.f9078c.m4432a(Integer.valueOf(i));
        }
        return videoPlayerSessionBase;
    }

    public final void m13968a(int i, int i2) {
        if (this.f9077b && i >= 0) {
            synchronized (this.f9078c) {
                VideoPlayerSessionBase videoPlayerSessionBase = (VideoPlayerSessionBase) this.f9078c.m4432a(Integer.valueOf(i));
                if (!(videoPlayerSessionBase == null || videoPlayerSessionBase.b == i2)) {
                    videoPlayerSessionBase.b = i2;
                }
            }
            Integer.valueOf(i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m13969a(int r5, com.facebook.video.api.playersession.VideoPlayerSessionBase.SessionState r6) {
        /*
        r4 = this;
        r0 = r4.f9077b;
        if (r0 == 0) goto L_0x0006;
    L_0x0004:
        if (r5 >= 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = r4.f9078c;
        monitor-enter(r1);
        r0 = r4.f9078c;	 Catch:{ all -> 0x0020 }
        r2 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0020 }
        r0 = r0.m4432a(r2);	 Catch:{ all -> 0x0020 }
        r0 = (com.facebook.video.api.playersession.VideoPlayerSessionBase) r0;	 Catch:{ all -> 0x0020 }
        if (r0 == 0) goto L_0x001e;
    L_0x0018:
        r2 = r0.a;	 Catch:{ all -> 0x0020 }
        r3 = com.facebook.video.api.playersession.VideoPlayerSessionBase.SessionState.STOP;	 Catch:{ all -> 0x0020 }
        if (r2 != r3) goto L_0x0023;
    L_0x001e:
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0006;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0020 }
        throw r0;
    L_0x0023:
        java.lang.Integer.valueOf(r5);	 Catch:{  }
        r0.a = r6;	 Catch:{  }
        monitor-exit(r1);	 Catch:{  }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.api.playersession.VideoPlayerSessionManager.a(int, com.facebook.video.api.playersession.VideoPlayerSessionBase$SessionState):void");
    }

    public final boolean m13971a() {
        return this.f9079d;
    }
}
