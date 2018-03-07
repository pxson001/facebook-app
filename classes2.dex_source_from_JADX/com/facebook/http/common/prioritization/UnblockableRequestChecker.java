package com.facebook.http.common.prioritization;

import com.facebook.http.common.PriorityRequestHolder;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: read_receipt */
public class UnblockableRequestChecker {
    private static volatile UnblockableRequestChecker f7954c;
    public ArrayList<RequestFilter> f7955a;
    public final QeAccessor f7956b;

    public static com.facebook.http.common.prioritization.UnblockableRequestChecker m12530a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7954c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.prioritization.UnblockableRequestChecker.class;
        monitor-enter(r1);
        r0 = f7954c;	 Catch:{ all -> 0x003a }
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
        r0 = m12531b(r0);	 Catch:{ all -> 0x0035 }
        f7954c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7954c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.prioritization.UnblockableRequestChecker.a(com.facebook.inject.InjectorLike):com.facebook.http.common.prioritization.UnblockableRequestChecker");
    }

    private static UnblockableRequestChecker m12531b(InjectorLike injectorLike) {
        return new UnblockableRequestChecker(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public UnblockableRequestChecker(QeAccessor qeAccessor) {
        this.f7956b = qeAccessor;
    }

    public final boolean m12532a(PriorityRequestHolder priorityRequestHolder) {
        if (this.f7955a == null) {
            String a = this.f7956b.mo581a(ExperimentsForHttpQeModule.aT, "");
            Preconditions.checkNotNull(a);
            ArrayList arrayList = new ArrayList();
            for (String split : a.split(",")) {
                String[] split2 = split.split("::");
                if (split2.length >= 2) {
                    arrayList.add(new RequestFilter(split2[0], split2[1]));
                }
            }
            this.f7955a = arrayList;
        }
        int size = this.f7955a.size();
        for (int i = 0; i < size; i++) {
            if (((RequestFilter) this.f7955a.get(i)).a(priorityRequestHolder.f11888c)) {
                return true;
            }
        }
        return false;
    }
}
