package com.facebook.http.onion.impl;

import android.content.Context;
import android.webkit.WebView;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.HttpFutureWrapper;
import com.facebook.http.onion.OnionRewriter;
import com.facebook.http.onion.OnionRewriter.RuleChangeListener;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxy.ConnectionState;
import com.facebook.http.onion.TorProxy.State;
import com.facebook.http.onion.TorProxy.TorListener;
import com.facebook.http.onion.TorProxyListenersInitializer;
import com.facebook.http.onion.impl.OnionPreferenceListener.C33681;
import com.facebook.http.onion.impl.TorIntegrityChecker.TorIntegrityResult;
import com.facebook.http.onion.prefs.OnionPrefKeys;
import com.facebook.http.onion.ui.TorProxyListenersInitializerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;

@Singleton
/* compiled from: Synthetic Guest Profile Photo doesn't exist for this User Type */
public class FbTorProxy implements RuleChangeListener, TorProxy {
    public static final Class<FbTorProxy> f23335a = FbTorProxy.class;
    private static volatile FbTorProxy f23336r;
    private final Context f23337b;
    private final Lazy<TorIntegrityChecker> f23338c;
    private final Lazy<ExecutorService> f23339d;
    private final Lazy<OnionAnalyticsLogger> f23340e;
    private final Lazy<TorWebViewProxyManager> f23341f;
    private final Lazy<ProxyUpdater> f23342g;
    private final Lazy<TorProxyListenersInitializer> f23343h;
    private final Lazy<OnionPreferenceListener> f23344i;
    private final Lazy<OnionRewriter> f23345j;
    private final List<TorListener> f23346k = new ArrayList();
    private State f23347l = State.DISABLED;
    private ConnectionState f23348m = null;
    private HttpHost f23349n;
    private Proxy f23350o;
    private boolean f23351p = false;
    public boolean f23352q = false;

    /* compiled from: Synthetic Guest Profile Photo doesn't exist for this User Type */
    class C33662 implements FutureCallback<TorIntegrityResult> {
        final /* synthetic */ FbTorProxy f23332a;

        C33662(FbTorProxy fbTorProxy) {
            this.f23332a = fbTorProxy;
        }

        public void onSuccess(Object obj) {
            TorIntegrityResult torIntegrityResult = (TorIntegrityResult) obj;
            this.f23332a.f23352q = false;
            if (torIntegrityResult == null) {
                FbTorProxy.m24653a(this.f23332a, ConnectionState.CONNECTION_CHECK_ERROR);
                return;
            }
            switch (torIntegrityResult) {
                case PUBLIC:
                    FbTorProxy.m24653a(this.f23332a, ConnectionState.CONNECTION_CHECK_FAILED);
                    return;
                case TOR:
                    FbTorProxy.m24653a(this.f23332a, ConnectionState.CHECKED_CONNECTION_TOR);
                    return;
                case ONION:
                    FbTorProxy.m24653a(this.f23332a, ConnectionState.CHECKED_CONNECTION_ONION);
                    return;
                default:
                    return;
            }
        }

        public void onFailure(Throwable th) {
            this.f23332a.f23352q = false;
            FbTorProxy.m24653a(this.f23332a, ConnectionState.CONNECTION_CHECK_ERROR);
        }
    }

    /* compiled from: Synthetic Guest Profile Photo doesn't exist for this User Type */
    /* synthetic */ class C33673 {
        static final /* synthetic */ int[] f23333a = new int[TriState.values().length];

        static {
            f23334b = new int[TorIntegrityResult.values().length];
            try {
                f23334b[TorIntegrityResult.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23334b[TorIntegrityResult.TOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23334b[TorIntegrityResult.ONION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23333a[TriState.YES.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23333a[TriState.NO.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23333a[TriState.UNSET.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static com.facebook.http.onion.impl.FbTorProxy m24650a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23336r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.impl.FbTorProxy.class;
        monitor-enter(r1);
        r0 = f23336r;	 Catch:{ all -> 0x003a }
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
        r0 = m24654b(r0);	 Catch:{ all -> 0x0035 }
        f23336r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23336r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.FbTorProxy.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.impl.FbTorProxy");
    }

    private static FbTorProxy m24654b(InjectorLike injectorLike) {
        return new FbTorProxy((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 7196), IdBasedSingletonScopeProvider.b(injectorLike, 3863), IdBasedLazy.a(injectorLike, 7191), IdBasedSingletonScopeProvider.b(injectorLike, 7197), IdBasedLazy.a(injectorLike, 7195), IdBasedSingletonScopeProvider.b(injectorLike, 7200), IdBasedSingletonScopeProvider.b(injectorLike, 7192), IdBasedSingletonScopeProvider.b(injectorLike, 2271));
    }

    @Inject
    public FbTorProxy(Context context, Lazy<TorIntegrityChecker> lazy, Lazy<ExecutorService> lazy2, Lazy<OnionAnalyticsLogger> lazy3, Lazy<TorWebViewProxyManager> lazy4, Lazy<ProxyUpdater> lazy5, Lazy<TorProxyListenersInitializer> lazy6, Lazy<OnionPreferenceListener> lazy7, Lazy<OnionRewriter> lazy8) {
        this.f23337b = context;
        this.f23338c = lazy;
        this.f23339d = lazy2;
        this.f23340e = lazy3;
        this.f23341f = lazy4;
        this.f23342g = lazy5;
        this.f23343h = lazy6;
        this.f23344i = lazy7;
        this.f23345j = lazy8;
    }

    public final void m24668f() {
        m24651a(State.REQUESTED);
    }

    public final synchronized void m24669g() {
        m24651a(State.STARTING);
    }

    public final synchronized void m24661a(String str, int i, String str2, int i2) {
        if (m24655n().isStarting()) {
            this.f23349n = new HttpHost(str, i, "http");
            this.f23350o = new Proxy(Type.SOCKS, new InetSocketAddress(str2, i2));
            ((OnionAnalyticsLogger) this.f23340e.get()).m24679a(str, i, str2, i2);
            m24651a(State.ENABLED);
            m24653a(this, ConnectionState.CHECKING_CONNECTION);
            m24658q(this);
            m24674l();
            Integer.valueOf(i);
            Integer.valueOf(i2);
        }
    }

    public final synchronized void m24670h() {
        m24651a(State.DISABLED);
        m24658q(this);
    }

    public final synchronized void m24671i() {
        m24666d();
    }

    public final void m24672j() {
        m24653a(this, ConnectionState.PROXY_ERROR);
    }

    public final void m24673k() {
        m24651a(State.REQUESTED);
    }

    public final void m24667e() {
        m24674l();
    }

    public void init() {
        if (!this.f23351p) {
            this.f23351p = true;
            OnionPreferenceListener onionPreferenceListener = (OnionPreferenceListener) this.f23344i.get();
            ((FbSharedPreferences) onionPreferenceListener.f23361c.get()).a(ImmutableSet.of(OnionPrefKeys.b, OnionPrefKeys.c), onionPreferenceListener);
            ((FbSharedPreferences) onionPreferenceListener.f23361c.get()).a(new C33681(onionPreferenceListener));
            ((OnionAnalyticsLogger) onionPreferenceListener.f23362d.get()).m24678a();
            a(((TorProxyListenersInitializerImpl) this.f23343h.get()).f365a);
            ((FbOnionRewriter) this.f23345j.get()).a(this);
        }
    }

    private synchronized State m24655n() {
        return this.f23347l;
    }

    private synchronized ConnectionState m24656o() {
        return m24655n().isEnabled() ? this.f23348m : null;
    }

    private synchronized void m24651a(State state) {
        if (state != this.f23347l) {
            this.f23347l = state;
            m24652a(state, m24656o());
            ((OnionAnalyticsLogger) this.f23340e.get()).m24681b();
        }
    }

    public static synchronized void m24653a(FbTorProxy fbTorProxy, ConnectionState connectionState) {
        synchronized (fbTorProxy) {
            if (connectionState != fbTorProxy.f23348m) {
                fbTorProxy.f23348m = connectionState;
                fbTorProxy.m24652a(fbTorProxy.m24655n(), connectionState);
            }
        }
    }

    private void m24652a(State state, ConnectionState connectionState) {
        for (TorListener a : this.f23346k) {
            a.a(state, connectionState);
        }
        OnionAnalyticsLogger onionAnalyticsLogger = (OnionAnalyticsLogger) this.f23340e.get();
        onionAnalyticsLogger.f23356b.put("state", state.name());
        if (connectionState != null) {
            onionAnalyticsLogger.f23356b.put("connState", connectionState.name());
        }
    }

    public final boolean m24662a() {
        return m24655n().isEnabled();
    }

    public final boolean m24664b() {
        ConnectionState o = m24656o();
        return o != null && o.hasEncounteredError();
    }

    public final synchronized HttpHost m24665c() {
        HttpHost httpHost;
        if (m24662a()) {
            httpHost = this.f23349n;
        } else {
            httpHost = null;
        }
        return httpHost;
    }

    private synchronized Proxy m24657p() {
        Proxy proxy;
        if (m24662a()) {
            proxy = this.f23350o;
        } else {
            proxy = null;
        }
        return proxy;
    }

    public final void m24666d() {
        if (m24662a()) {
            new TorRunningChecker(this, m24665c()) {
                final /* synthetic */ FbTorProxy f23331a;

                protected void onPostExecute(Object obj) {
                    switch (C33673.f23333a[((TriState) obj).ordinal()]) {
                        case 1:
                            this.f23331a.m24674l();
                            return;
                        case 2:
                            FbTorProxy.m24653a(this.f23331a, ConnectionState.PROXY_ERROR);
                            FbTorProxy.m24658q(this.f23331a);
                            return;
                        case 3:
                            BLog.a(FbTorProxy.f23335a, "Failed to check connection");
                            return;
                        default:
                            return;
                    }
                }
            }.a(this.f23337b, new Void[0]);
        } else {
            BLog.a(f23335a, "Connection check requested when disabled");
        }
    }

    @VisibleForTesting
    public final void m24674l() {
        if (!this.f23352q) {
            if (m24662a()) {
                TorIntegrityChecker torIntegrityChecker = (TorIntegrityChecker) this.f23338c.get();
                HttpUriRequest httpGet = new HttpGet("https://www.facebook.com/si/proxy/");
                HttpClientParams.setRedirecting(httpGet.getParams(), true);
                Builder newBuilder = FbHttpRequest.newBuilder();
                newBuilder.b = httpGet;
                Builder builder = newBuilder;
                builder.c = "Tor integrity checker";
                builder = builder;
                builder.g = TorIntegrityChecker.f23375b;
                HttpFutureWrapper b = torIntegrityChecker.f23377a.b(builder.a());
                if (b == null) {
                    BLog.a(f23335a, "Null future returned from integrity checker");
                    return;
                }
                FutureUtils.a(b.b, new C33662(this), (Executor) this.f23339d.get());
                this.f23352q = true;
                return;
            }
            BLog.a(f23335a, "Integrity check requested when disabled");
        }
    }

    public final synchronized void m24660a(TorListener torListener) {
        if (torListener != null) {
            this.f23346k.add(torListener);
        }
    }

    public final synchronized void m24663b(TorListener torListener) {
        this.f23346k.remove(torListener);
    }

    public final void m24659a(WebView webView) {
        ((TorWebViewProxyManager) this.f23341f.get()).m24699a(webView);
    }

    public static synchronized void m24658q(FbTorProxy fbTorProxy) {
        synchronized (fbTorProxy) {
            ProxyUpdater proxyUpdater = (ProxyUpdater) fbTorProxy.f23342g.get();
            fbTorProxy.m24665c();
            proxyUpdater.m24691a(fbTorProxy.m24657p());
            for (TorListener a : fbTorProxy.f23346k) {
                a.a();
            }
            ((TorWebViewProxyManager) fbTorProxy.f23341f.get()).m24698a();
        }
    }
}
