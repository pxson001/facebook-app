package com.facebook.browser.prefetch;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import com.facebook.browser.liteclient.util.FbBrowserUtil;
import com.facebook.browser.prefetch.config.BrowserPrefetchConfig;
import com.facebook.browser.prefetch.qe.ExperimentsForBrowserPrefetchModule;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.C0407x2d3af7a5;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLBrowserPrefetchType;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.browser.prefs.BrowserPrefKey;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;

@Singleton
/* compiled from: pre_queue_time */
public class BrowserPrefetcher {
    private static final String f9314a = BrowserPrefetcher.class.getSimpleName();
    private static volatile BrowserPrefetcher f9315z;
    private final Context f9316b;
    private final XConfigReader f9317c;
    public final BrowserPrefetchCacheManager f9318d;
    public final BrowserPrefetchLogger f9319e;
    private final AbstractFbErrorReporter f9320f;
    private final ExecutorService f9321g;
    public final FbHttpRequestProcessor f9322h;
    public final FbSharedPreferences f9323i;
    public final Handler f9324j;
    private final QeAccessor f9325k;
    private final DeviceConditionHelper f9326l;
    private final FbNetworkManager f9327m;
    private final GatekeeperStoreImpl f9328n;
    private final Product f9329o;
    private final AppVersionInfo f9330p;
    public CookieManager f9331q;
    private boolean f9332r = true;
    private String f9333s;
    public String f9334t;
    public Map<String, String> f9335u;
    private HashMap<String, String> f9336v;
    private HashMap<String, String> f9337w;
    private StaticResourceUrlExtractor f9338x;
    private Boolean f9339y = null;

    public static com.facebook.browser.prefetch.BrowserPrefetcher m14282a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9315z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.browser.prefetch.BrowserPrefetcher.class;
        monitor-enter(r1);
        r0 = f9315z;	 Catch:{ all -> 0x003a }
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
        r0 = m14284b(r0);	 Catch:{ all -> 0x0035 }
        f9315z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9315z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.browser.prefetch.BrowserPrefetcher.a(com.facebook.inject.InjectorLike):com.facebook.browser.prefetch.BrowserPrefetcher");
    }

    private static BrowserPrefetcher m14284b(InjectorLike injectorLike) {
        return new BrowserPrefetcher(BrowserPrefetchCacheManager.m14306a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), XConfigReader.m2681a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbHttpRequestProcessor.m12260a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), DeviceConditionHelper.m5526a(injectorLike), FbNetworkManager.m3811a(injectorLike), BrowserPrefetchLogger.m14326a(injectorLike), (Context) injectorLike.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), C0407x2d3af7a5.m14328a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.m5522a(injectorLike), StaticResourceUrlExtractor.m14330a(injectorLike), ProductMethodAutoProvider.m4523a(injectorLike), AppVersionInfoMethodAutoProvider.m2629a(injectorLike));
    }

    @Inject
    public BrowserPrefetcher(BrowserPrefetchCacheManager browserPrefetchCacheManager, AbstractFbErrorReporter abstractFbErrorReporter, XConfigReader xConfigReader, QeAccessor qeAccessor, FbHttpRequestProcessor fbHttpRequestProcessor, FbSharedPreferences fbSharedPreferences, DeviceConditionHelper deviceConditionHelper, FbNetworkManager fbNetworkManager, BrowserPrefetchLogger browserPrefetchLogger, Context context, GatekeeperStoreImpl gatekeeperStoreImpl, ExecutorService executorService, Handler handler, StaticResourceUrlExtractor staticResourceUrlExtractor, Product product, AppVersionInfo appVersionInfo) {
        this.f9318d = browserPrefetchCacheManager;
        this.f9320f = abstractFbErrorReporter;
        this.f9317c = xConfigReader;
        this.f9325k = qeAccessor;
        this.f9326l = deviceConditionHelper;
        this.f9327m = fbNetworkManager;
        this.f9322h = fbHttpRequestProcessor;
        this.f9323i = fbSharedPreferences;
        this.f9319e = browserPrefetchLogger;
        this.f9316b = context;
        this.f9328n = gatekeeperStoreImpl;
        this.f9321g = executorService;
        this.f9324j = handler;
        this.f9338x = staticResourceUrlExtractor;
        this.f9329o = product;
        this.f9330p = appVersionInfo;
        this.f9335u = new FifoMap(10);
    }

    public final boolean m14299a(Uri uri) {
        return m14298a() && m14301b(uri);
    }

    public final boolean m14298a() {
        return VERSION.SDK_INT >= 12 && !this.f9323i.mo286a(BrowserPrefKey.f9364a, false) && this.f9325k.mo596a(ExperimentsForBrowserPrefetchModule.f9380i, false);
    }

    private boolean m14292l() {
        boolean z = this.f9325k.mo596a(ExperimentsForBrowserPrefetchModule.f9381j, true) && this.f9328n.m2189a(22, true);
        if ((!z || this.f9326l.m5534b()) && this.f9325k.mo572a(ExperimentsForBrowserPrefetchModule.f9379h, 0) > 0) {
            return true;
        }
        return false;
    }

    public final int m14302c() {
        return this.f9325k.mo572a(ExperimentsForBrowserPrefetchModule.f9382k, 0);
    }

    public final boolean m14303d() {
        return this.f9326l.m5534b();
    }

    public final boolean m14304g() {
        return this.f9325k.mo596a(ExperimentsForBrowserPrefetchModule.f9373b, false);
    }

    public final void m14305i() {
        try {
            this.f9324j.removeCallbacksAndMessages(null);
            this.f9324j.getLooper().getThread().interrupt();
        } catch (Exception e) {
        }
    }

    public final void m14300b(String str) {
        this.f9335u.put(str, "");
    }

    final boolean m14301b(@Nullable Uri uri) {
        if (uri == null || !URLUtil.isNetworkUrl(uri.toString())) {
            return false;
        }
        if (this.f9325k.mo596a(ExperimentsForBrowserPrefetchModule.f9374c, false)) {
            return true;
        }
        return URLUtil.isHttpUrl(uri.toString());
    }

    public final void m14296a(String str, GraphQLBrowserPrefetchType graphQLBrowserPrefetchType) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        m14295a(new BrowserPrefetchRequest(arrayList), true, graphQLBrowserPrefetchType);
    }

    @TargetApi(12)
    public final void m14295a(BrowserPrefetchRequest browserPrefetchRequest, boolean z, GraphQLBrowserPrefetchType graphQLBrowserPrefetchType) {
        Thread.interrupted();
        if (this.f9327m.m3828d()) {
            List<String> a = browserPrefetchRequest.a();
            List<String> arrayList = new ArrayList();
            try {
                if (m14293m()) {
                    for (String str : a) {
                        this.f9334t = str;
                        if (!(Strings.isNullOrEmpty(str) || this.f9318d.m14319b(str))) {
                            arrayList.add(str);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        Map hashMap = new HashMap();
                        for (String str2 : arrayList) {
                            hashMap.put(ExecutorDetour.a(this.f9321g, m14288c(str2), 1426910086), str2);
                        }
                        try {
                            for (Future future : hashMap.keySet()) {
                                try {
                                    FutureDetour.a(future, 20000, TimeUnit.MILLISECONDS, 920460878);
                                    if (z && m14292l() && graphQLBrowserPrefetchType != GraphQLBrowserPrefetchType.HTML_ONLY) {
                                        m14287b(this.f9334t, graphQLBrowserPrefetchType);
                                    }
                                } catch (TimeoutException e) {
                                    future.cancel(true);
                                    new Object[1][0] = hashMap.get(future);
                                } catch (InterruptedException e2) {
                                    throw e2;
                                } catch (Throwable e3) {
                                    hashMap.get(future);
                                    this.f9320f.mo336a(SoftError.a(f9314a + ".prefetch", "Prefetch failed" + browserPrefetchRequest.a()).a(e3).g());
                                }
                            }
                        } catch (InterruptedException e4) {
                            for (Future future2 : hashMap.keySet()) {
                                future2.cancel(true);
                            }
                        }
                    }
                }
            } catch (Throwable e5) {
                new Object[1][0] = browserPrefetchRequest.a();
                this.f9320f.mo336a(SoftError.a(f9314a + ".prefetch", "Prefetch failed" + browserPrefetchRequest.a()).a(e5).g());
            }
        }
    }

    public final void m14297a(String str, String str2, boolean z) {
        boolean z2 = false;
        if (this.f9325k.mo596a(ExperimentsForBrowserPrefetchModule.f9375d, false)) {
            if (z && this.f9325k.mo596a(ExperimentsForBrowserPrefetchModule.f9377f, false)) {
                z2 = true;
            }
            if (z2 || !str.equalsIgnoreCase(str2)) {
                long a = this.f9325k.mo575a(ExperimentsForBrowserPrefetchModule.f9376e, 0);
                HandlerDetour.b(this.f9324j, new 1(this, str, str2, z2), a, 1854778345);
            }
        }
    }

    public static void m14286b(BrowserPrefetcher browserPrefetcher, String str, String str2, boolean z) {
        Thread.interrupted();
        if (browserPrefetcher.f9327m.m3828d() && browserPrefetcher.m14293m()) {
            Future a = ExecutorDetour.a(browserPrefetcher.f9321g, browserPrefetcher.m14289c(str, str2, z), 280713639);
            try {
                FutureDetour.a(a, 20000, TimeUnit.MILLISECONDS, -612555560);
            } catch (TimeoutException e) {
                a.cancel(true);
            } catch (InterruptedException e2) {
                a.cancel(true);
            } catch (Exception e3) {
                Object[] objArr = new Object[]{str, str2};
            }
        }
    }

    private boolean m14293m() {
        if (!this.f9318d.m14318b() || !m14283a(this.f9332r)) {
            return false;
        }
        if (this.f9336v == null) {
            try {
                this.f9336v = BrowserPrefetchConfig.a(this.f9317c, BrowserPrefetchConfig.c);
                this.f9337w = BrowserPrefetchConfig.a(this.f9317c, BrowserPrefetchConfig.d);
            } catch (Throwable e) {
                this.f9320f.m2343a(f9314a + ".initializeResources.getRequestHeader", "Failed get request header", e);
            }
        }
        if (this.f9332r) {
            this.f9333s = m14294n();
        }
        this.f9332r = false;
        return true;
    }

    @TargetApi(17)
    @Nullable
    private String m14294n() {
        if (VERSION.SDK_INT >= 17) {
            return WebSettings.getDefaultUserAgent(this.f9316b) + FbBrowserUtil.a(this.f9329o, this.f9330p);
        }
        if (this.f9336v == null || !this.f9336v.containsKey("User-Agent")) {
            return System.getProperty("http.agent");
        }
        return (String) this.f9336v.get("User-Agent");
    }

    private Callable<Boolean> m14288c(String str) {
        return new 2(this, str);
    }

    private Callable<Boolean> m14289c(String str, String str2, boolean z) {
        return new 3(this, str, z, str2);
    }

    @Nullable
    public static String m14285b(String str, String str2) {
        try {
            if (Uri.parse(str2).isAbsolute()) {
                return str2;
            }
            return URI.create(str).resolve(str2).toString();
        } catch (Exception e) {
            Object[] objArr = new Object[]{str, str2};
            return null;
        }
    }

    public static FbHttpRequest m14290d(BrowserPrefetcher browserPrefetcher, String str, String str2, boolean z) {
        HttpUriRequest httpGet = new HttpGet(str2);
        if (!Strings.isNullOrEmpty(browserPrefetcher.f9333s)) {
            httpGet.setHeader("User-Agent", browserPrefetcher.f9333s);
        }
        HashMap hashMap = z ? browserPrefetcher.f9337w : browserPrefetcher.f9336v;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                if (!"User-Agent".equals(str3)) {
                    httpGet.setHeader(str3, (String) hashMap.get(str3));
                }
            }
        }
        String str32 = browserPrefetcher.f9331q.getCookie(str2);
        if (!Strings.isNullOrEmpty(str32)) {
            httpGet.setHeader("Cookie", str32);
        }
        HttpClientParams.setRedirecting(httpGet.getParams(), false);
        Builder newBuilder = FbHttpRequest.newBuilder();
        newBuilder.f7702b = httpGet;
        newBuilder = newBuilder;
        newBuilder.f7704d = CallerContext.m9060a(BrowserPrefetcher.class);
        newBuilder = newBuilder;
        newBuilder.f7703c = f9314a;
        newBuilder = newBuilder;
        newBuilder.f7712l = RequestPriority.NON_INTERACTIVE;
        Builder builder = newBuilder;
        builder.f7707g = new PrefetchHttpResponseHandler(browserPrefetcher, str, str2, z);
        return builder.m12256a();
    }

    private boolean m14283a(boolean z) {
        if (z && this.f9331q == null) {
            CookieSyncManager.createInstance(this.f9316b);
            this.f9331q = CookieManager.getInstance();
            if (this.f9331q == null) {
                return false;
            }
            return true;
        } else if (this.f9331q != null) {
            return true;
        } else {
            return false;
        }
    }

    private void m14287b(String str, GraphQLBrowserPrefetchType graphQLBrowserPrefetchType) {
        String c = this.f9318d.m14320c(str);
        List<String> a = this.f9338x.m14335a(c, graphQLBrowserPrefetchType);
        if (!a.isEmpty()) {
            List arrayList = new ArrayList();
            for (String replace : a) {
                String replace2 = m14285b(c, replace2.replace("&amp;", "&").replace("\\/", "/"));
                if (replace2 != null) {
                    arrayList.add(replace2);
                }
            }
            HandlerDetour.a(this.f9324j, new 4(this, arrayList), 1209132710);
        }
    }
}
