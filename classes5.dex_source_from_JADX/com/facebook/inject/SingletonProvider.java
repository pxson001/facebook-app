package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: default_quality */
public class SingletonProvider<T> extends AbstractProvider<T> implements Lazy<T> {
    private final SingletonScope f5160a;
    private final Provider<T> f5161b;
    private T f5162c;
    private boolean f5163d;

    public synchronized T get() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:20:0x002f in {15, 17, 19, 22, 24} preds:[]
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
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f5163d;
        if (r0 != 0) goto L_0x0025;
    L_0x0005:
        r1 = com.facebook.inject.ScopeSet.a();
        r0 = 1;
        r2 = r1.b(r0);
        r0 = r4.f5160a;	 Catch:{ all -> 0x002e }
        r3 = r0.enterScope();	 Catch:{ all -> 0x002e }
        r0 = r4.f5161b;	 Catch:{ all -> 0x0029 }
        r0 = r0.get();	 Catch:{ all -> 0x0029 }
        r4.f5162c = r0;	 Catch:{ all -> 0x0029 }
        r0 = 1;	 Catch:{ all -> 0x0029 }
        r4.f5163d = r0;	 Catch:{ all -> 0x0029 }
        com.facebook.inject.SingletonScope.a(r3);
        r1.c(r2);
    L_0x0025:
        r0 = r4.f5162c;	 Catch:{  }
        monitor-exit(r4);
        return r0;
    L_0x0029:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r3);	 Catch:{ all -> 0x0029 }
        throw r0;	 Catch:{ all -> 0x0029 }
    L_0x002e:
        r0 = move-exception;
        r1.c(r2);	 Catch:{ all -> 0x002e }
        throw r0;	 Catch:{ all -> 0x002e }
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.inject.SingletonProvider.get():T");
    }

    public SingletonProvider(SingletonScope singletonScope, Provider<T> provider) {
        this.f5160a = singletonScope;
        this.f5161b = provider;
    }
}
