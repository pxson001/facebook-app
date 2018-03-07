package com.facebook.http.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: taggable_id */
public class BatchComponentRunner {
    private static volatile BatchComponentRunner f1333b;
    private final MethodBatcherImpl f1334a;

    public static com.facebook.http.protocol.BatchComponentRunner m1565a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1333b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.protocol.BatchComponentRunner.class;
        monitor-enter(r1);
        r0 = f1333b;	 Catch:{ all -> 0x003a }
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
        r0 = m1566b(r0);	 Catch:{ all -> 0x0035 }
        f1333b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1333b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.BatchComponentRunner.a(com.facebook.inject.InjectorLike):com.facebook.http.protocol.BatchComponentRunner");
    }

    private static BatchComponentRunner m1566b(InjectorLike injectorLike) {
        return new BatchComponentRunner(MethodBatcherImpl.a(injectorLike));
    }

    @Inject
    public BatchComponentRunner(MethodBatcherImpl methodBatcherImpl) {
        this.f1334a = methodBatcherImpl;
    }

    public final void m1567a(String str, CallerContext callerContext, List<BatchComponent> list, @Nullable ApiMethodRunnerParams apiMethodRunnerParams) {
        Preconditions.checkNotNull(callerContext);
        ApiMethodRunner$Batch a = this.f1334a.a();
        Map c = Maps.c();
        int i = 0;
        for (BatchComponent batchComponent : list) {
            Iterable<BatchOperation> a2 = batchComponent.mo99a();
            c.put(batchComponent, a2);
            for (BatchOperation a3 : a2) {
                a.mo888a(a3);
                i++;
            }
        }
        if (i > 0) {
            a.mo884a(str, callerContext, apiMethodRunnerParams);
        }
        for (Entry entry : c.entrySet()) {
            BatchComponent batchComponent2 = (BatchComponent) entry.getKey();
            Map c2 = Maps.c();
            for (BatchOperation a32 : (Iterable) entry.getValue()) {
                String str2 = a32.f11919c;
                c2.put(str2, a.mo887a(str2));
            }
            batchComponent2.mo100a(c2);
        }
    }
}
