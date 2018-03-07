package com.facebook.ui.browser.logging;

import android.webkit.WebView;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureWebViewHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.browser.event.BrowserEventBus;
import com.facebook.ui.browser.event.BrowserEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnPageFinishedEvent;
import com.facebook.ui.browser.event.BrowserEvents.OnPageFinishedEventSubscriber;
import com.facebook.ui.browser.event.BrowserEvents.OnPageStartedEvent;
import com.facebook.ui.browser.event.BrowserEvents.onPageStartedEventSubscriber;
import com.facebook.ui.browser.gating.IsNavigationTimingLogEnabled;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: tincan */
public class WebviewTimingLog {
    private static final long f1608d = Long.valueOf(-1).longValue();
    private static volatile WebviewTimingLog f1609m;
    public final SecureWebViewHelper f1610a;
    private final Clock f1611b;
    @IsNavigationTimingLogEnabled
    public Provider<TriState> f1612c;
    private long f1613e = f1608d;
    private long f1614f = f1608d;
    private long f1615g = f1608d;
    private long f1616h = f1608d;
    private long f1617i = f1608d;
    public BrowserEventSubscriber<OnPageFinishedEvent> f1618j;
    public BrowserEventSubscriber<OnPageStartedEvent> f1619k;
    public final BrowserEventBus f1620l;

    /* compiled from: tincan */
    public class C01631 extends onPageStartedEventSubscriber {
        final /* synthetic */ WebviewTimingLog f1606a;

        public C01631(WebviewTimingLog webviewTimingLog) {
            this.f1606a = webviewTimingLog;
        }

        public final void m1656b(FbEvent fbEvent) {
            this.f1606a.m1660a(false);
        }
    }

    /* compiled from: tincan */
    public class C01642 extends OnPageFinishedEventSubscriber {
        final /* synthetic */ WebviewTimingLog f1607a;

        public C01642(WebviewTimingLog webviewTimingLog) {
            this.f1607a = webviewTimingLog;
        }

        public final void m1657b(FbEvent fbEvent) {
            OnPageFinishedEvent onPageFinishedEvent = (OnPageFinishedEvent) fbEvent;
            WebviewTimingLog webviewTimingLog = this.f1607a;
            WebView webView = onPageFinishedEvent.f1526a;
            if (((TriState) webviewTimingLog.f1612c.get()).asBoolean(false) && webView != null) {
                webviewTimingLog.f1610a.b(webView, "javascript:void((function(){try {  if (!window.performance || !window.performance.timing) {    return;  }  var nvtiming__fb_t = window.performance.timing;  if (nvtiming__fb_t.navigationStart > 0) {    console.log('FBNavNavigationStart:'+nvtiming__fb_t.navigationStart);  }  if (nvtiming__fb_t.domLoading > 0) {    console.log('FBNavDomLoading:'+nvtiming__fb_t.domLoading);  }  if (nvtiming__fb_t.domInteractive > 0) {    console.log('FBNavDomInteractive:'+nvtiming__fb_t.domInteractive);  }  if (nvtiming__fb_t.domContentLoadedEventStart > 0) {    console.log('FBNavDomContentLoaded:'+nvtiming__fb_t.domContentLoadedEventStart);  }  if (nvtiming__fb_t.domComplete > 0) {    console.log('FBNavDomComplete:'+nvtiming__fb_t.domComplete);  }}catch(err){  console.log('fb_navigation_timing_error:'+err.message);}})());");
            }
        }
    }

    public static com.facebook.ui.browser.logging.WebviewTimingLog m1658a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1609m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.browser.logging.WebviewTimingLog.class;
        monitor-enter(r1);
        r0 = f1609m;	 Catch:{ all -> 0x003a }
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
        r0 = m1659b(r0);	 Catch:{ all -> 0x0035 }
        f1609m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1609m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.browser.logging.WebviewTimingLog.a(com.facebook.inject.InjectorLike):com.facebook.ui.browser.logging.WebviewTimingLog");
    }

    private static WebviewTimingLog m1659b(InjectorLike injectorLike) {
        return new WebviewTimingLog(SecureWebViewHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 790), BrowserEventBus.m1600a(injectorLike));
    }

    @Inject
    public WebviewTimingLog(SecureWebViewHelper secureWebViewHelper, Clock clock, Provider<TriState> provider, BrowserEventBus browserEventBus) {
        this.f1610a = secureWebViewHelper;
        this.f1611b = clock;
        this.f1612c = provider;
        this.f1620l = browserEventBus;
        m1660a(true);
        this.f1619k = new C01631(this);
        this.f1618j = new C01642(this);
        this.f1620l.a(this.f1619k);
        this.f1620l.a(this.f1618j);
    }

    public final void m1660a(boolean z) {
        if (z) {
            this.f1613e = f1608d;
        }
        this.f1614f = f1608d;
        this.f1615g = f1608d;
        this.f1616h = f1608d;
        this.f1617i = f1608d;
    }
}
