package com.facebook.ui.animations.persistent.parts;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: multiple_thread_keys */
public class DefaultAnimationPartFactory {
    private static volatile DefaultAnimationPartFactory f13192a;

    public static com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory m19389a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13192a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory.class;
        monitor-enter(r1);
        r0 = f13192a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m19388a();	 Catch:{ all -> 0x0034 }
        f13192a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13192a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory.a(com.facebook.inject.InjectorLike):com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory");
    }

    private static DefaultAnimationPartFactory m19388a() {
        return new DefaultAnimationPartFactory();
    }

    public final PersistentAnimation m19393a(Object obj, long j, float f, float f2, AnimatorListener animatorListener) {
        if (obj instanceof View) {
            return new ViewScaleAnimation((View) obj, j, f, f2, animatorListener);
        }
        if (obj instanceof AnimatorUpdateListener) {
            return new UpdateListenerAnimation((AnimatorUpdateListener) obj, j, f, f2, animatorListener);
        }
        throw new IllegalArgumentException("Target object not of suitable type");
    }

    public final PersistentAnimation m19390a(long j, AnimatorListener animatorListener) {
        return new DelayAnimation(j, animatorListener);
    }

    public final PersistentAnimation m19391a(View view, long j, int i, int i2, AnimatorListener animatorListener) {
        return new ExpandAnimation(view, j, i, i2, animatorListener);
    }

    public final PersistentAnimation m19392a(ImmutableList<PersistentAnimation> immutableList, long j, AnimatorListener animatorListener) {
        return new PersistentSetAnimation(immutableList, j, animatorListener);
    }
}
