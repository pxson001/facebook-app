package com.facebook.video.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.util.LruCache;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.cache.PlayerReadableCache;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: pages_db2 */
public class MediaPlayerPool {
    public static final String f5369a = MediaPlayerPool.class.getSimpleName();
    private static volatile MediaPlayerPool f5370m;
    private final Provider<MediaPlayer> f5371b;
    public final MonotonicClock f5372c;
    public final Context f5373d;
    public final ExecutorService f5374e;
    public final MediaPlayerCache f5375f;
    private final Lazy<VideoServer> f5376g;
    private final QeAccessor f5377h;
    private final GatekeeperStoreImpl f5378i;
    private final Lazy<PlayerReadableCache> f5379j;
    private final ListeningExecutorService f5380k;
    public final VideoExoplayerConfig f5381l;

    /* compiled from: pages_db2 */
    class MediaPlayerCache extends LruCache<Uri, PreparingMediaPlayer> {
        final /* synthetic */ MediaPlayerPool f5382a;

        protected final void m5861a(boolean z, Object obj, Object obj2, Object obj3) {
            Uri uri = (Uri) obj;
            PreparingMediaPlayer preparingMediaPlayer = (PreparingMediaPlayer) obj2;
            PreparingMediaPlayer preparingMediaPlayer2 = (PreparingMediaPlayer) obj3;
            if (z) {
                String str = MediaPlayerPool.f5369a;
                MediaPlayer b = preparingMediaPlayer.mo522b();
                b.setOnPreparedListener(null);
                b.setOnErrorListener(null);
                if (this.f5382a.f5381l.A) {
                    ExecutorDetour.a(this.f5382a.f5374e, new 1(this, b), 1298562506);
                    return;
                } else {
                    b.release();
                    return;
                }
            }
            str = MediaPlayerPool.f5369a;
            preparingMediaPlayer.mo523c();
            Long.valueOf(this.f5382a.f5372c.now() - preparingMediaPlayer.mo524d());
            Preconditions.checkArgument(preparingMediaPlayer2 == null, "Entry shall not be removed by overwriting using put(), it should be remove()ed");
        }

        public MediaPlayerCache(MediaPlayerPool mediaPlayerPool, int i) {
            this.f5382a = mediaPlayerPool;
            super(i);
        }
    }

    public static com.facebook.video.engine.MediaPlayerPool m5857a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5370m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.MediaPlayerPool.class;
        monitor-enter(r1);
        r0 = f5370m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m5858b(r0);	 Catch:{ all -> 0x0035 }
        f5370m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5370m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.MediaPlayerPool.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.MediaPlayerPool");
    }

    private static MediaPlayerPool m5858b(InjectorLike injectorLike) {
        return new MediaPlayerPool(IdBasedProvider.a(injectorLike, 36), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3695), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 11641), ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider.a(injectorLike), VideoExoplayerConfig.b(injectorLike));
    }

    @Inject
    public MediaPlayerPool(Provider<MediaPlayer> provider, MonotonicClock monotonicClock, Context context, ExecutorService executorService, Lazy<VideoServer> lazy, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, Lazy<PlayerReadableCache> lazy2, ListeningExecutorService listeningExecutorService, VideoExoplayerConfig videoExoplayerConfig) {
        this.f5371b = provider;
        this.f5372c = monotonicClock;
        this.f5373d = context;
        this.f5376g = lazy;
        this.f5377h = qeAccessor;
        this.f5378i = gatekeeperStore;
        this.f5374e = executorService;
        this.f5381l = videoExoplayerConfig;
        this.f5375f = new MediaPlayerCache(this, videoExoplayerConfig.y);
        this.f5379j = lazy2;
        this.f5380k = listeningExecutorService;
    }

    public final DirectPlayMediaPlayer m5859a(Uri uri, VideoResourceMetadata videoResourceMetadata) {
        return new DirectPlayMediaPlayer(videoResourceMetadata, new MediaPlayer(), (VideoServer) this.f5376g.get(), this.f5373d, uri, this.f5372c, new DirectPlayConfig(this.f5377h, this.f5378i), (PlayerReadableCache) this.f5379j.get(), this.f5380k);
    }

    public final void m5860c(Uri uri) {
        if (this.f5375f.a(uri) == null) {
            try {
                this.f5375f.a(uri, new PreparingMediaPlayer((MediaPlayer) this.f5371b.get(), this.f5373d.getApplicationContext(), uri, this.f5372c));
            } catch (IOException e) {
                new Object[1][0] = uri;
            }
        }
    }
}
