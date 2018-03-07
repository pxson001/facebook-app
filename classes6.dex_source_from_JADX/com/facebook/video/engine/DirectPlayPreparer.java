package com.facebook.video.engine;

import android.net.Uri;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.cache.PlayerReadableCache;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* compiled from: conAckCode= */
public class DirectPlayPreparer {
    public static final String f18769a = DirectPlayPreparer.class.getSimpleName();
    private final VideoResourceMetadata f18770b;
    private final DefaultAndroidThreadUtil f18771c;
    private final VideoServer f18772d;
    public final Uri f18773e;
    private final MonotonicClock f18774f;
    private final DirectPlayConfig f18775g;
    private final PlayerReadableCache f18776h;
    public final ListeningExecutorService f18777i;
    public AtomicBoolean f18778j = new AtomicBoolean(false);
    public boolean f18779k = false;
    private int f18780l;
    public Callback f18781m;

    /* compiled from: conAckCode= */
    public class C13991 implements Runnable {
        final /* synthetic */ DirectPlayPreparer f18765a;

        public void run() {
            String str = DirectPlayPreparer.f18769a;
            Long.valueOf(Thread.currentThread().getId());
            DirectPlayPreparer.m27504a(this.f18765a, this.f18765a.f18773e);
            str = DirectPlayPreparer.f18769a;
            Long.valueOf(Thread.currentThread().getId());
        }

        public C13991(DirectPlayPreparer directPlayPreparer) {
            this.f18765a = directPlayPreparer;
        }
    }

    /* compiled from: conAckCode= */
    public interface Callback {
        void setDataSource(Uri uri);
    }

    @Inject
    public DirectPlayPreparer(@Assisted VideoResourceMetadata videoResourceMetadata, @Assisted Uri uri, DefaultAndroidThreadUtil defaultAndroidThreadUtil, VideoServer videoServer, MonotonicClock monotonicClock, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, PlayerReadableCache playerReadableCache, ListeningExecutorService listeningExecutorService) {
        this.f18770b = videoResourceMetadata;
        this.f18773e = uri;
        this.f18771c = defaultAndroidThreadUtil;
        this.f18772d = videoServer;
        this.f18774f = monotonicClock;
        this.f18775g = new DirectPlayConfig(qeAccessor, gatekeeperStoreImpl);
        this.f18776h = playerReadableCache;
        this.f18777i = listeningExecutorService;
        this.f18780l = 0;
    }

    public static void m27504a(DirectPlayPreparer directPlayPreparer, Uri uri) {
        Uri d = VideoServer.f(uri) ? VideoServer.d(uri) : uri;
        directPlayPreparer.f18772d.a(d, 0, -1, VideoServer.g(uri), VideoServer.a(uri), new DirectPlayAsyncWriterHandler(directPlayPreparer, directPlayPreparer.f18776h, directPlayPreparer.f18775g, directPlayPreparer.f18774f.now() + "_" + Math.abs(d.hashCode()) + ".mp4", directPlayPreparer.f18770b) {
            final /* synthetic */ DirectPlayPreparer f18766a;

            protected final void mo1421a(String str) {
                String str2 = DirectPlayPreparer.f18769a;
                DirectPlayPreparer.m27505b(this.f18766a, Uri.parse(str));
            }

            protected final boolean mo1422a() {
                return this.f18766a.f18779k;
            }

            protected final void mo1423b() {
                DirectPlayPreparer.m27505b(this.f18766a, this.f18766a.f18773e);
            }
        });
        directPlayPreparer.f18776h.ai_();
        directPlayPreparer.f18778j.set(false);
    }

    public static void m27505b(DirectPlayPreparer directPlayPreparer, final Uri uri) {
        directPlayPreparer.f18771c.a(new Runnable(directPlayPreparer) {
            final /* synthetic */ DirectPlayPreparer f18768b;

            public void run() {
                this.f18768b.f18781m.setDataSource(uri);
            }
        });
    }

    public final void m27506b() {
        this.f18779k = true;
    }
}
