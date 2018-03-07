package com.facebook.zero.rewrite;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.HttpRequestFilter;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.impl.client.RequestWrapper;

@Singleton
/* compiled from: regionPreference */
public class ZeroDebugHttpFilter implements HttpRequestFilter {
    private static volatile ZeroDebugHttpFilter f7792c;
    public final GatekeeperStoreImpl f7793a;
    public final List<String> f7794b = new ArrayList();

    public static com.facebook.zero.rewrite.ZeroDebugHttpFilter m12330a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7792c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.rewrite.ZeroDebugHttpFilter.class;
        monitor-enter(r1);
        r0 = f7792c;	 Catch:{ all -> 0x003a }
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
        r0 = m12331b(r0);	 Catch:{ all -> 0x0035 }
        f7792c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7792c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.rewrite.ZeroDebugHttpFilter.a(com.facebook.inject.InjectorLike):com.facebook.zero.rewrite.ZeroDebugHttpFilter");
    }

    private static ZeroDebugHttpFilter m12331b(InjectorLike injectorLike) {
        return new ZeroDebugHttpFilter(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public ZeroDebugHttpFilter(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f7793a = gatekeeperStoreImpl;
    }

    public final int mo1679a() {
        return Integer.MAX_VALUE;
    }

    public final void mo1680a(RequestWrapper requestWrapper, FbHttpRequest fbHttpRequest) {
        if (this.f7793a.m2189a(1188, false)) {
            this.f7794b.add(0, requestWrapper.getURI().toString());
        }
    }
}
