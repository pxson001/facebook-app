package com.facebook.video.player;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.View;
import android.view.animation.Interpolator;
import javax.inject.Singleton;

@Singleton
/* compiled from: oxygen_map_tile_download_size */
public class VideoAnimationHelper {
    private static volatile VideoAnimationHelper f14161b;
    public final Interpolator f14162a = PathInterpolatorCompat.m14975a(0.23f, 1.0f, 0.32f, 1.0f);

    public static com.facebook.video.player.VideoAnimationHelper m14973a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f14161b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.video.player.VideoAnimationHelper.class;
        monitor-enter(r1);
        r0 = f14161b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m14972a();	 Catch:{ all -> 0x0034 }
        f14161b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14161b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.player.VideoAnimationHelper.a(com.facebook.inject.InjectorLike):com.facebook.video.player.VideoAnimationHelper");
    }

    private static VideoAnimationHelper m14972a() {
        return new VideoAnimationHelper();
    }

    public final void m14974a(final View view, int i, final int i2) {
        view.animate().alpha(0.0f).setDuration((long) i).setInterpolator(this.f14162a).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ VideoAnimationHelper f5596c;

            public void onAnimationEnd(Animator animator) {
                view.setVisibility(i2);
            }
        }).start();
    }
}
