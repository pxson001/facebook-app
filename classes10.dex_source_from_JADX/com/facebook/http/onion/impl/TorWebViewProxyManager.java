package com.facebook.http.onion.impl;

import android.content.Context;
import android.webkit.WebView;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.webview.proxy.WebViewProxyUtil;
import com.facebook.webview.proxy.WebViewProxyUtil.UnableToSetProxyException;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpHost;

@Singleton
/* compiled from: Successful */
public class TorWebViewProxyManager {
    public static final Class<TorWebViewProxyManager> f23381a = TorWebViewProxyManager.class;
    private static volatile TorWebViewProxyManager f23382f;
    private final ExecutorService f23383b;
    private final FbTorProxy f23384c;
    public final WebViewProxyUtil f23385d;
    public final List<WeakReference<WebView>> f23386e = Collections.synchronizedList(new ArrayList());

    public static com.facebook.http.onion.impl.TorWebViewProxyManager m24694a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23382f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.impl.TorWebViewProxyManager.class;
        monitor-enter(r1);
        r0 = f23382f;	 Catch:{ all -> 0x003a }
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
        r0 = m24697b(r0);	 Catch:{ all -> 0x0035 }
        f23382f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23382f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.TorWebViewProxyManager.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.impl.TorWebViewProxyManager");
    }

    private static TorWebViewProxyManager m24697b(InjectorLike injectorLike) {
        return new TorWebViewProxyManager(OnionImplModule.m24683a((Context) injectorLike.getInstance(Context.class)), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FbTorProxy.m24650a(injectorLike));
    }

    @Inject
    public TorWebViewProxyManager(WebViewProxyUtil webViewProxyUtil, ExecutorService executorService, FbTorProxy fbTorProxy) {
        this.f23385d = webViewProxyUtil;
        this.f23383b = executorService;
        this.f23384c = fbTorProxy;
    }

    private Future<Boolean> m24696a(final HttpHost httpHost, final List<WebView> list) {
        return ExecutorDetour.a(this.f23383b, new Callable<Boolean>(this) {
            final /* synthetic */ TorWebViewProxyManager f23380c;

            public Object call() {
                boolean z = true;
                for (WebView webView : list) {
                    boolean z2;
                    try {
                        if (httpHost != null) {
                            this.f23380c.f23385d.a(httpHost.getHostName(), httpHost.getPort(), webView);
                            z2 = z;
                            z = z2;
                        } else {
                            this.f23380c.f23385d.a(webView);
                        }
                    } catch (UnableToSetProxyException e) {
                        BLog.b(TorWebViewProxyManager.f23381a, "Failed to set proxy for WebView", e);
                        z2 = false;
                    }
                }
                return Boolean.valueOf(z);
            }
        }, 1677939637);
    }

    private Future<Boolean> m24695a(HttpHost httpHost, WebView webView) {
        return m24696a(httpHost, ImmutableList.of(webView));
    }

    public final Future<Boolean> m24698a() {
        HttpHost c = this.f23384c.m24665c();
        List arrayList = new ArrayList();
        for (WeakReference weakReference : this.f23386e) {
            WebView webView = (WebView) weakReference.get();
            if (webView != null) {
                arrayList.add(webView);
            }
        }
        return m24696a(c, arrayList);
    }

    public final void m24699a(WebView webView) {
        if (webView != null) {
            this.f23386e.add(new WeakReference(webView));
            if (this.f23384c.m24662a()) {
                m24695a(this.f23384c.m24665c(), webView);
            }
        }
    }
}
