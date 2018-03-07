package com.facebook.feed.rows.styling.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.concurrent.Immutable;
import javax.inject.Singleton;

@Singleton
@Immutable
@Deprecated
/* compiled from: inapp_browser_prefetch_timing */
public class FeedAnimators {
    private static volatile FeedAnimators f20252a;

    public static com.facebook.feed.rows.styling.animators.FeedAnimators m27920a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20252a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.rows.styling.animators.FeedAnimators.class;
        monitor-enter(r1);
        r0 = f20252a;	 Catch:{ all -> 0x0039 }
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
        r0 = m27919a();	 Catch:{ all -> 0x0034 }
        f20252a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f20252a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.styling.animators.FeedAnimators.a(com.facebook.inject.InjectorLike):com.facebook.feed.rows.styling.animators.FeedAnimators");
    }

    private static FeedAnimators m27919a() {
        return new FeedAnimators();
    }

    public final Animator m27922a(View view, int i, int i2) {
        Animator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new 1(this, view));
        ofInt.addListener(new 2(this, view, i2, i));
        return ofInt;
    }

    public static Set<Animator> m27921a(Set<View> set, float f, float f2, long j) {
        boolean z = ((double) f) >= 0.0d && f <= 1.0f;
        Preconditions.checkArgument(z);
        if (((double) f2) < 0.0d || f2 > 1.0f) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (((double) j) >= 0.0d) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Set<Animator> a = Sets.m1313a();
        for (View ofFloat : set) {
            Animator ofFloat2 = ObjectAnimator.ofFloat(ofFloat, "alpha", new float[]{f, f2});
            ofFloat2.setDuration(j);
            a.add(ofFloat2);
        }
        return a;
    }
}
