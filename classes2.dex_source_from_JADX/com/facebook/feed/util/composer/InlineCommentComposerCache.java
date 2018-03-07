package com.facebook.feed.util.composer;

import android.util.LruCache;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.model.FeedUnit;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: position */
public class InlineCommentComposerCache {
    private static volatile InlineCommentComposerCache f9464b;
    public final LruCache<String, Boolean> f9465a = new LruCache(10);

    public static com.facebook.feed.util.composer.InlineCommentComposerCache m14459a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9464b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feed.util.composer.InlineCommentComposerCache.class;
        monitor-enter(r1);
        r0 = f9464b;	 Catch:{ all -> 0x0039 }
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
        r0 = m14458a();	 Catch:{ all -> 0x0034 }
        f9464b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f9464b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.util.composer.InlineCommentComposerCache.a(com.facebook.inject.InjectorLike):com.facebook.feed.util.composer.InlineCommentComposerCache");
    }

    private static InlineCommentComposerCache m14458a() {
        return new InlineCommentComposerCache();
    }

    public final <E extends HasInvalidate> void m14462a(FeedUnit feedUnit, @Nullable E e, Boolean bool) {
        if (!m14460b(feedUnit)) {
            this.f9465a.put(m14461c(feedUnit), bool);
            if (e != null) {
                e.mo2438a(feedUnit);
            }
        }
    }

    public static boolean m14460b(FeedUnit feedUnit) {
        return feedUnit.mo2507g() == null;
    }

    public static String m14461c(FeedUnit feedUnit) {
        return feedUnit.mo2507g();
    }
}
