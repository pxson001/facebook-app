package com.facebook.messaging.analytics.threads;

import com.facebook.messaging.service.model.FetchThreadHandlerChange;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: p2p_edit_card_fail */
public class FetchThreadTracer {
    private static final Class<?> f7674a = FetchThreadTracer.class;
    private static volatile FetchThreadTracer f7675d;
    private volatile ArrayList<FetchThreadHandlerChange> f7676b = Lists.a();
    private volatile boolean f7677c;

    public static com.facebook.messaging.analytics.threads.FetchThreadTracer m7979a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7675d;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.analytics.threads.FetchThreadTracer.class;
        monitor-enter(r1);
        r0 = f7675d;	 Catch:{ all -> 0x0039 }
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
        r0 = m7980c();	 Catch:{ all -> 0x0034 }
        f7675d = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7675d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.analytics.threads.FetchThreadTracer.a(com.facebook.inject.InjectorLike):com.facebook.messaging.analytics.threads.FetchThreadTracer");
    }

    private static FetchThreadTracer m7980c() {
        return new FetchThreadTracer();
    }

    public final void m7981a() {
        this.f7676b.clear();
        this.f7677c = true;
    }

    public final void m7982a(FetchThreadHandlerChange fetchThreadHandlerChange) {
        if (this.f7677c) {
            this.f7676b.add(fetchThreadHandlerChange);
        }
    }

    public final ArrayList<FetchThreadHandlerChange> m7983b() {
        Preconditions.checkState(this.f7677c);
        ArrayList<FetchThreadHandlerChange> a = Lists.a(this.f7676b);
        this.f7677c = false;
        return a;
    }
}
