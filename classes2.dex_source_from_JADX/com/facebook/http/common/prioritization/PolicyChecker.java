package com.facebook.http.common.prioritization;

import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.PriorityInflightRequests;
import com.facebook.http.common.PriorityRequestHolder;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: read_response_body */
public class PolicyChecker {
    private static volatile PolicyChecker f7952b;
    private final UnblockableRequestChecker f7953a;

    public static com.facebook.http.common.prioritization.PolicyChecker m12527a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7952b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.prioritization.PolicyChecker.class;
        monitor-enter(r1);
        r0 = f7952b;	 Catch:{ all -> 0x003a }
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
        r0 = m12528b(r0);	 Catch:{ all -> 0x0035 }
        f7952b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7952b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.prioritization.PolicyChecker.a(com.facebook.inject.InjectorLike):com.facebook.http.common.prioritization.PolicyChecker");
    }

    private static PolicyChecker m12528b(InjectorLike injectorLike) {
        return new PolicyChecker(UnblockableRequestChecker.m12530a(injectorLike));
    }

    @Inject
    public PolicyChecker(UnblockableRequestChecker unblockableRequestChecker) {
        this.f7953a = unblockableRequestChecker;
    }

    public final boolean m12529a(PriorityRequestHolder priorityRequestHolder, PriorityInflightRequests priorityInflightRequests, PrioritizationPolicy prioritizationPolicy) {
        if (this.f7953a.m12532a(priorityRequestHolder)) {
            return true;
        }
        if (priorityRequestHolder.f11888c.m12244r()) {
            int size = priorityInflightRequests.f7926a.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                if (((FbHttpRequest) priorityInflightRequests.f7926a.get(i)).m12244r()) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i++;
                i2 = i3;
            }
            if (i2 >= prioritizationPolicy.f7917a) {
                return false;
            }
        }
        if (priorityRequestHolder.m17395a() == RequestPriority.INTERACTIVE) {
            if (priorityInflightRequests.m12514b() >= prioritizationPolicy.f7918b) {
                return false;
            }
            return true;
        } else if (priorityInflightRequests.m12514b() >= prioritizationPolicy.f7919c) {
            return false;
        } else {
            return true;
        }
    }
}
