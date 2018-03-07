package com.facebook.contacts.omnistore;

import com.facebook.omnistore.Collection;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Singleton;

@Singleton
/* compiled from: parseSmsAddress */
public class ContactsCollectionHolder {
    private static volatile ContactsCollectionHolder f8352b;
    @GuardedBy("this")
    private SettableFuture<Collection> f8353a = SettableFuture.f();

    public static com.facebook.contacts.omnistore.ContactsCollectionHolder m12147a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8352b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.contacts.omnistore.ContactsCollectionHolder.class;
        monitor-enter(r1);
        r0 = f8352b;	 Catch:{ all -> 0x0039 }
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
        r0 = m12148b();	 Catch:{ all -> 0x0034 }
        f8352b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f8352b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.omnistore.ContactsCollectionHolder.a(com.facebook.inject.InjectorLike):com.facebook.contacts.omnistore.ContactsCollectionHolder");
    }

    private static ContactsCollectionHolder m12148b() {
        return new ContactsCollectionHolder();
    }

    public final Collection m12149a() {
        Throwable e;
        synchronized (this) {
            SettableFuture settableFuture = this.f8353a;
        }
        try {
            return (Collection) FutureDetour.a(settableFuture, 1340481418);
        } catch (InterruptedException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (ExecutionException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }
}
