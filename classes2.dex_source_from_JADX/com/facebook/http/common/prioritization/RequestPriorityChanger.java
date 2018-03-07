package com.facebook.http.common.prioritization;

import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpUtils;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: recv_window */
public class RequestPriorityChanger {
    private static final Class<?> f7858a = RequestPriorityChanger.class;
    private static volatile RequestPriorityChanger f7859d;
    private ArrayList<RequestPriorityFilter> f7860b;
    private final QeAccessor f7861c;

    public static com.facebook.http.common.prioritization.RequestPriorityChanger m12440a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7859d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.prioritization.RequestPriorityChanger.class;
        monitor-enter(r1);
        r0 = f7859d;	 Catch:{ all -> 0x003a }
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
        r0 = m12442b(r0);	 Catch:{ all -> 0x0035 }
        f7859d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7859d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.prioritization.RequestPriorityChanger.a(com.facebook.inject.InjectorLike):com.facebook.http.common.prioritization.RequestPriorityChanger");
    }

    private static RequestPriorityChanger m12442b(InjectorLike injectorLike) {
        return new RequestPriorityChanger(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public RequestPriorityChanger(QeAccessor qeAccessor) {
        this.f7861c = qeAccessor;
    }

    public final <T> FbHttpRequest<T> m12443a(FbHttpRequest<T> fbHttpRequest) {
        if (this.f7860b == null) {
            m12441a();
        }
        int size = this.f7860b.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            RequestPriorityFilter requestPriorityFilter = (RequestPriorityFilter) this.f7860b.get(i);
            Preconditions.checkNotNull(fbHttpRequest);
            if (requestPriorityFilter.a.equals(fbHttpRequest.f7686c) && requestPriorityFilter.b.equals(FbHttpUtils.b(fbHttpRequest)) && requestPriorityFilter.c == fbHttpRequest.m12235h()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                Builder a = FbHttpRequest.m12226a((FbHttpRequest) fbHttpRequest);
                a.f7712l = requestPriorityFilter.d;
                return a.m12256a();
            }
        }
        return fbHttpRequest;
    }

    private void m12441a() {
        String a = this.f7861c.mo581a(ExperimentsForHttpQeModule.aQ, "");
        Preconditions.checkNotNull(a);
        ArrayList arrayList = new ArrayList();
        for (String split : a.split(",")) {
            String[] split2 = split.split("::");
            if (split2.length >= 4) {
                try {
                    RequestPriority fromNumericValue = RequestPriority.fromNumericValue(Integer.parseInt(split2[2]), RequestPriority.UNUSED_REQUEST_PRIORITY);
                    if (fromNumericValue != RequestPriority.UNUSED_REQUEST_PRIORITY) {
                        RequestPriority fromNumericValue2 = RequestPriority.fromNumericValue(Integer.parseInt(split2[3]), RequestPriority.UNUSED_REQUEST_PRIORITY);
                        if (fromNumericValue2 != RequestPriority.UNUSED_REQUEST_PRIORITY) {
                            arrayList.add(new RequestPriorityFilter(split2[0], split2[1], fromNumericValue, fromNumericValue2));
                        }
                    }
                } catch (Throwable e) {
                    BLog.b(f7858a, "Ignore error parsing bad config", e);
                }
            }
        }
        this.f7860b = arrayList;
    }
}
