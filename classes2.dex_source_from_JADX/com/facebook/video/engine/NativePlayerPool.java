package com.facebook.video.engine;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.util.LruCache;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.view.exo.PlaybackPreferences;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_send_on_enter_android */
public class NativePlayerPool {
    static final String f13774a = NativePlayerPool.class.getSimpleName();
    private static volatile NativePlayerPool f13775j;
    public final Lazy<MediaPlayerPool> f13776b;
    public final LruCache<String, VideoPlayerParams> f13777c = new LruCache(50);
    private final ExoPlayerPool f13778d;
    public final LruCache<Uri, Boolean> f13779e;
    public final QeAccessor f13780f;
    public final GatekeeperStoreImpl f13781g;
    public final VideoExoplayerConfig f13782h;
    @Nullable
    public DirectPlayConfig f13783i;

    public static com.facebook.video.engine.NativePlayerPool m20190a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13775j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.NativePlayerPool.class;
        monitor-enter(r1);
        r0 = f13775j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m20192b(r0);	 Catch:{ all -> 0x0035 }
        f13775j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13775j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.NativePlayerPool.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.NativePlayerPool");
    }

    private static NativePlayerPool m20192b(InjectorLike injectorLike) {
        return new NativePlayerPool(VideoExoplayerConfig.m11519b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3660), ExoPlayerPool.m20198a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public NativePlayerPool(VideoExoplayerConfig videoExoplayerConfig, Lazy<MediaPlayerPool> lazy, ExoPlayerPool exoPlayerPool, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore) {
        this.f13776b = lazy;
        this.f13778d = exoPlayerPool;
        this.f13780f = qeAccessor;
        this.f13781g = gatekeeperStore;
        this.f13782h = videoExoplayerConfig;
        this.f13779e = new LruCache(videoExoplayerConfig.f6903C);
    }

    public final boolean m20197a() {
        return this.f13782h.m11520a();
    }

    public final ExoPlayerPreparerBase m20194a(Uri uri, Uri uri2, String str, Uri uri3, PlaybackPreferences playbackPreferences, boolean z) {
        this.f13779e.m4433a((Object) uri, Boolean.valueOf(true));
        return this.f13778d.m20201a(uri, uri2, str, uri3, playbackPreferences, z);
    }

    private PreparingMediaPlayer m20191a(Uri uri) {
        this.f13779e.m4433a((Object) uri, Boolean.valueOf(true));
        MediaPlayerPool mediaPlayerPool = (MediaPlayerPool) this.f13776b.get();
        PreparingMediaPlayer preparingMediaPlayer = (PreparingMediaPlayer) mediaPlayerPool.f.m4432a((Object) uri);
        mediaPlayerPool.f.m4438b((Object) uri);
        if (preparingMediaPlayer == null || preparingMediaPlayer.c() == PlayerState.STATE_ERROR) {
            preparingMediaPlayer = new PreparingMediaPlayer(new MediaPlayer(), mediaPlayerPool.d.getApplicationContext(), uri, mediaPlayerPool.c);
        }
        return preparingMediaPlayer;
    }

    public final MediaPlayerWrapper m20195a(Uri uri, VideoResourceMetadata videoResourceMetadata, boolean z) {
        if (this.f13783i == null) {
            this.f13783i = new DirectPlayConfig(this.f13780f, this.f13781g);
        }
        DirectPlayConfig directPlayConfig = this.f13783i;
        if (directPlayConfig.a && z && ((directPlayConfig.k || videoResourceMetadata.h()) && videoResourceMetadata.f <= directPlayConfig.d)) {
            Object obj;
            PreparingMediaPlayer preparingMediaPlayer = (PreparingMediaPlayer) ((MediaPlayerPool) this.f13776b.get()).f.m4432a((Object) uri);
            if (preparingMediaPlayer == null || preparingMediaPlayer.c() != PlayerState.STATE_PREPARED) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                return ((MediaPlayerPool) this.f13776b.get()).a(uri, videoResourceMetadata);
            }
        }
        return m20191a(uri);
    }

    public final void m20196a(String str, VideoPlayerParams videoPlayerParams) {
        this.f13777c.m4433a((Object) str, (Object) videoPlayerParams);
    }

    @Nullable
    public static VideoDataSource m20193b(@Nullable VideoPlayerParams videoPlayerParams) {
        if (videoPlayerParams == null || videoPlayerParams.a == null || videoPlayerParams.a.isEmpty()) {
            return null;
        }
        return (VideoDataSource) videoPlayerParams.a.get(0);
    }
}
