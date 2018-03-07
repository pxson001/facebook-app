package com.facebook.http.config;

import com.facebook.common.init.INeedInit;
import com.facebook.http.common.executorimpl.apache.FbHttpClient;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SocketFactory;

@Singleton
/* compiled from: is_sender_missing */
public class NetworkConfigUpdater implements INeedInit {
    private static volatile NetworkConfigUpdater f9829d;
    public final Lazy<FbHttpClient> f9830a;
    public final Provider<SocketFactory> f9831b;
    public final DefaultNetworkConfig f9832c;

    /* compiled from: is_sender_missing */
    public class C04441 {
        final /* synthetic */ NetworkConfigUpdater f9833a;

        C04441(NetworkConfigUpdater networkConfigUpdater) {
            this.f9833a = networkConfigUpdater;
        }

        public final void m10241a() {
            NetworkConfigUpdater networkConfigUpdater = this.f9833a;
            ((FbHttpClient) networkConfigUpdater.f9830a.get()).getConnectionManager().getSchemeRegistry().register(new Scheme("https", (SocketFactory) networkConfigUpdater.f9831b.get(), 443));
            ((FbHttpClient) networkConfigUpdater.f9830a.get()).getParams().setParameter("http.route.default-proxy", networkConfigUpdater.f9832c.j);
        }
    }

    public static com.facebook.http.config.NetworkConfigUpdater m10239a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9829d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.config.NetworkConfigUpdater.class;
        monitor-enter(r1);
        r0 = f9829d;	 Catch:{ all -> 0x003a }
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
        r0 = m10240b(r0);	 Catch:{ all -> 0x0035 }
        f9829d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9829d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.config.NetworkConfigUpdater.a(com.facebook.inject.InjectorLike):com.facebook.http.config.NetworkConfigUpdater");
    }

    private static NetworkConfigUpdater m10240b(InjectorLike injectorLike) {
        return new NetworkConfigUpdater(IdBasedSingletonScopeProvider.b(injectorLike, 7182), IdBasedProvider.a(injectorLike, 4549), DefaultNetworkConfig.a(injectorLike));
    }

    @Inject
    public NetworkConfigUpdater(Lazy<FbHttpClient> lazy, Provider<SocketFactory> provider, NetworkConfig networkConfig) {
        this.f9830a = lazy;
        this.f9831b = provider;
        this.f9832c = networkConfig;
    }

    public void init() {
        DefaultNetworkConfig defaultNetworkConfig = this.f9832c;
        C04441 c04441 = new C04441(this);
        defaultNetworkConfig.b.add(c04441);
        if (!defaultNetworkConfig.g || defaultNetworkConfig.h || defaultNetworkConfig.i || !Objects.equal(defaultNetworkConfig.j, DefaultNetworkConfig.e)) {
            c04441.m10241a();
        }
    }
}
