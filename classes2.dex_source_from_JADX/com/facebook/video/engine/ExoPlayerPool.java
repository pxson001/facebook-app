package com.facebook.video.engine;

import android.net.Uri;
import android.support.v4.util.LruCache;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.view.exo.PlaybackPreferences;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_save_quickcam_gallery_android */
public class ExoPlayerPool {
    public static final String f13784a = ExoPlayerPool.class.getSimpleName();
    private static volatile ExoPlayerPool f13785i;
    private final ExoPlayerPreparerProvider f13786b;
    private final LruCache<Uri, ExoPlayerPreparerBase> f13787c;
    public final MonotonicClock f13788d;
    private PlaybackPreferences f13789e;
    private Uri f13790f;
    private String f13791g;
    private Uri f13792h;

    /* compiled from: messenger_save_quickcam_gallery_android */
    class ExoPlayerCache extends LruCache<Uri, ExoPlayerPreparerBase> {
        final /* synthetic */ ExoPlayerPool f13793a;

        protected final void mo2670a(boolean z, Object obj, Object obj2, Object obj3) {
            Uri uri = (Uri) obj;
            ExoPlayerPreparerBase exoPlayerPreparerBase = (ExoPlayerPreparerBase) obj2;
            ExoPlayerPreparerBase exoPlayerPreparerBase2 = (ExoPlayerPreparerBase) obj3;
            if (z) {
                String str = ExoPlayerPool.f13784a;
                exoPlayerPreparerBase.e();
                return;
            }
            str = ExoPlayerPool.f13784a;
            ExoPlayerPreparerBase.a(exoPlayerPreparerBase.d);
            Long.valueOf(this.f13793a.f13788d.now() - exoPlayerPreparerBase.i);
            Preconditions.checkArgument(exoPlayerPreparerBase2 == null, "Entry shall not be removed by overwriting using put(), it should be remove()ed");
        }

        public ExoPlayerCache(ExoPlayerPool exoPlayerPool, int i) {
            this.f13793a = exoPlayerPool;
            super(i);
        }
    }

    public static com.facebook.video.engine.ExoPlayerPool m20198a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13785i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.ExoPlayerPool.class;
        monitor-enter(r1);
        r0 = f13785i;	 Catch:{ all -> 0x003a }
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
        r0 = m20200b(r0);	 Catch:{ all -> 0x0035 }
        f13785i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13785i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.ExoPlayerPool.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.ExoPlayerPool");
    }

    private static ExoPlayerPool m20200b(InjectorLike injectorLike) {
        return new ExoPlayerPool((ExoPlayerPreparerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ExoPlayerPreparerProvider.class), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), VideoExoplayerConfig.m11519b(injectorLike));
    }

    @Inject
    public ExoPlayerPool(ExoPlayerPreparerProvider exoPlayerPreparerProvider, MonotonicClock monotonicClock, VideoExoplayerConfig videoExoplayerConfig) {
        this.f13786b = exoPlayerPreparerProvider;
        this.f13788d = monotonicClock;
        this.f13787c = new ExoPlayerCache(this, videoExoplayerConfig.f6938y);
    }

    public final ExoPlayerPreparerBase m20201a(Uri uri, Uri uri2, String str, Uri uri3, PlaybackPreferences playbackPreferences, boolean z) {
        this.f13790f = uri2;
        this.f13791g = str;
        this.f13792h = uri3;
        this.f13789e = playbackPreferences;
        ExoPlayerPreparerBase exoPlayerPreparerBase = (ExoPlayerPreparerBase) this.f13787c.m4438b((Object) uri);
        if (exoPlayerPreparerBase != null) {
            if (!exoPlayerPreparerBase.l) {
                return exoPlayerPreparerBase;
            }
            exoPlayerPreparerBase.e();
        }
        return m20199a(uri, z);
    }

    private ExoPlayerPreparerBase m20199a(Uri uri, boolean z) {
        return this.f13786b.m20202a(uri, this.f13790f, this.f13791g, this.f13792h, this.f13789e, z);
    }
}
