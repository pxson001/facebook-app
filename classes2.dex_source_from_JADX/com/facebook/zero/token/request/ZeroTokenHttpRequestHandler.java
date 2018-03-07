package com.facebook.zero.token.request;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpRequest;

@Singleton
/* compiled from: tincan_out */
public class ZeroTokenHttpRequestHandler {
    private static volatile ZeroTokenHttpRequestHandler f4339c;
    private final GatekeeperStoreImpl f4340a;
    private boolean f4341b = true;

    /* compiled from: tincan_out */
    public class ZeroTokenHttpRequestHandlerSharedPrefsListenerRegistration extends INeedInitForSharedPrefsListenerRegistration<ZeroTokenHttpRequestHandler> {
        protected final void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, Object obj) {
            ((ZeroTokenHttpRequestHandler) obj).m8013a(Boolean.valueOf(fbSharedPreferences.mo286a(prefKey, true)));
        }

        @Inject
        public ZeroTokenHttpRequestHandlerSharedPrefsListenerRegistration(Lazy<ZeroTokenHttpRequestHandler> lazy) {
            super((Lazy) lazy, (PrefKey) SharedPrefKeys.f987a.m2011a("zero_rating2/clearable/zero_unknown_state"));
        }
    }

    public static com.facebook.zero.token.request.ZeroTokenHttpRequestHandler m8011a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4339c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.token.request.ZeroTokenHttpRequestHandler.class;
        monitor-enter(r1);
        r0 = f4339c;	 Catch:{ all -> 0x003a }
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
        r0 = m8012b(r0);	 Catch:{ all -> 0x0035 }
        f4339c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4339c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.token.request.ZeroTokenHttpRequestHandler.a(com.facebook.inject.InjectorLike):com.facebook.zero.token.request.ZeroTokenHttpRequestHandler");
    }

    private static ZeroTokenHttpRequestHandler m8012b(InjectorLike injectorLike) {
        return new ZeroTokenHttpRequestHandler(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public ZeroTokenHttpRequestHandler(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f4340a = gatekeeperStoreImpl;
    }

    public final synchronized void m8014a(HttpRequest httpRequest) {
        if (this.f4340a.m2189a(1189, false)) {
            String uri = httpRequest.getRequestLine().getUri();
            if (this.f4341b && uri.matches("^https?://(b-)?((api|api2|z-m-api|b-api|api-read)|(graph|graph2|z-m-graph|b-graph))\\.([0-9a-zA-Z\\.-]*)?facebook\\.com.*$") && !uri.contains("method/mobile.zeroCampaign")) {
                httpRequest.addHeader("X-ZERO-STATE", "unknown");
            }
        }
    }

    public final void m8013a(Boolean bool) {
        this.f4341b = bool.booleanValue();
    }
}
