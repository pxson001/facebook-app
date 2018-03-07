package com.facebook.ui.images.fetch;

import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.collect.LruMap;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: recipient_ids */
public class FetchImagePerfLogger {
    private static volatile FetchImagePerfLogger f12923h;
    public final double f12924a;
    public final PerformanceLogger f12925b;
    private final AnalyticsLogger f12926c;
    private final VMMemoryInfo f12927d;
    public final Map<Uri, AllUrlsForImage> f12928e = Collections.synchronizedMap(new LruMap(500));
    public final LinkedList<ImageDimensions> f12929f = Lists.b();
    public boolean f12930g = false;

    /* compiled from: recipient_ids */
    public enum OperationResult {
        SUCCESS,
        FAILURE,
        CANCELLED
    }

    public static com.facebook.ui.images.fetch.FetchImagePerfLogger m13805a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12923h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.fetch.FetchImagePerfLogger.class;
        monitor-enter(r1);
        r0 = f12923h;	 Catch:{ all -> 0x003a }
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
        r0 = m13811b(r0);	 Catch:{ all -> 0x0035 }
        f12923h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12923h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.fetch.FetchImagePerfLogger.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.fetch.FetchImagePerfLogger");
    }

    private static FetchImagePerfLogger m13811b(InjectorLike injectorLike) {
        return new FetchImagePerfLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), VMMemoryInfoMethodAutoProvider.a(injectorLike), PerfTestConfig.a(injectorLike));
    }

    @Inject
    public FetchImagePerfLogger(PerformanceLogger performanceLogger, AnalyticsLogger analyticsLogger, VMMemoryInfo vMMemoryInfo, PerfTestConfig perfTestConfig) {
        this.f12925b = performanceLogger;
        this.f12926c = analyticsLogger;
        this.f12927d = vMMemoryInfo;
        this.f12924a = PerfTestConfigBase.b() ? 1.0d : 0.1d;
    }

    public final MarkerConfig m13816a(Uri uri, int i, String str) {
        if (!m13814d() || !this.f12928e.containsKey(uri)) {
            return null;
        }
        AllUrlsForImage allUrlsForImage = (AllUrlsForImage) this.f12928e.get(uri);
        Uri uri2 = allUrlsForImage.b;
        if (!m13813c(uri2, i, str)) {
            return null;
        }
        MarkerConfig a = allUrlsForImage.a(i, str, uri2.toString());
        Map map = a.l;
        map.put("UrlImageUrlBeingFetched", uri.toString());
        a.a(map);
        this.f12925b.c(new MarkerConfig(a));
        if (this.f12925b.e(a)) {
            if (str.equalsIgnoreCase("UrlImagePrefetch") && this.f12928e.get(uri2) != null) {
                ((AllUrlsForImage) this.f12928e.get(uri2)).d = a;
            } else if (str.equalsIgnoreCase("UrlImageBindModelToRender") && this.f12928e.get(uri2) != null) {
                ((AllUrlsForImage) this.f12928e.get(uri2)).e = a;
            }
        }
        return a;
    }

    private boolean m13813c(Uri uri, int i, String str) {
        if (str.equalsIgnoreCase("UrlImagePipelineExperiment")) {
            return true;
        }
        if (!str.equalsIgnoreCase("UrlImageBindModelToRender") && !str.equalsIgnoreCase("UrlImagePrefetch")) {
            return m13810a(uri);
        }
        if (m13815d(uri, i, str)) {
            return false;
        }
        return true;
    }

    public final void m13819a(@Nullable MarkerConfig markerConfig, String str) {
        if (str != null) {
            m13808a(markerConfig, "operationResult", str);
        }
    }

    public final void m13822a(MarkerConfig markerConfig, boolean z) {
        m13819a(markerConfig, z ? OperationResult.SUCCESS.toString() : OperationResult.FAILURE.toString());
    }

    public final void m13823a(MarkerConfig markerConfig, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str) {
        Map map = markerConfig.l;
        map.put("UrlImageDoesBackgroundResourceIdExist", String.valueOf(z));
        map.put("UrlImageIsDarwableFromFetchImageParams", String.valueOf(z2));
        map.put("UrlImageDoesImageSpecDrawableExist", String.valueOf(z3));
        map.put("UrlImageDoesImageSpecResourceIdExist", String.valueOf(z4));
        map.put("UrlImageCurrentMode", str);
        map.put("operationResult", z5 ? OperationResult.SUCCESS.toString() : OperationResult.FAILURE.toString());
        m13821a(markerConfig, map);
    }

    private void m13808a(@Nullable MarkerConfig markerConfig, String str, String str2) {
        if (m13814d() && markerConfig != null) {
            Map map = markerConfig.l;
            map.put(str, str2);
            markerConfig.a(map);
            this.f12925b.b(markerConfig);
        }
    }

    public final void m13821a(MarkerConfig markerConfig, Map<String, String> map) {
        if (m13814d() && markerConfig != null) {
            Map map2 = markerConfig.l;
            map2.putAll(map);
            markerConfig.a(map2);
            this.f12925b.b(markerConfig);
        }
    }

    public final void m13820a(MarkerConfig markerConfig, String str, String str2, boolean z, int i) {
        if (m13814d()) {
            Map map = markerConfig.l;
            map.put("UrlImageNewMode", str);
            map.put("UrlImageCurrentMode", str2);
            map.put("UrlImageIsShownInGallery", String.valueOf(z));
            map.put("UrlImageIsImageViewVisible", String.valueOf(i));
            m13821a(markerConfig, map);
        }
    }

    public final void m13818a(Uri uri, String str, @Nullable String str2, @Nullable Throwable th) {
        if (m13814d()) {
            AllUrlsForImage allUrlsForImage = (AllUrlsForImage) this.f12928e.get(uri);
            if (allUrlsForImage != null) {
                Uri uri2 = allUrlsForImage.b;
                if (m13815d(uri2, 5439489, "UrlImageBindModelToRender")) {
                    MarkerConfig markerConfig = ((AllUrlsForImage) this.f12928e.get(uri2)).e;
                    if (markerConfig != null) {
                        Map map = markerConfig.l;
                        if (str2 != null) {
                            map.put("UrlImageFetchedImageSource", str2);
                        }
                        if (th != null) {
                            if (th instanceof CancellationException) {
                                map.put("operationResult", OperationResult.CANCELLED.toString());
                            } else {
                                map.put("operationResult", OperationResult.FAILURE.toString());
                                map.put("UrlImageException", Throwables.getStackTraceAsString(th));
                            }
                        } else if (str != null) {
                            map.put("operationResult", str);
                        }
                        map.put("UrlImageUrlBeingFetched", uri.toString());
                        markerConfig.a(map);
                        this.f12925b.b(markerConfig);
                    }
                }
                AllUrlsForImage allUrlsForImage2 = (AllUrlsForImage) this.f12928e.get(uri2);
                if (allUrlsForImage2 != null) {
                    this.f12928e.remove(allUrlsForImage2.b);
                    for (Uri remove : allUrlsForImage2.c) {
                        this.f12928e.remove(remove);
                    }
                }
            }
        }
    }

    public final MarkerConfig m13817a(Uri uri, long j, int i) {
        if (!m13814d()) {
            return null;
        }
        AllUrlsForImage allUrlsForImage = (AllUrlsForImage) this.f12928e.get(uri);
        if (allUrlsForImage == null) {
            return null;
        }
        Uri uri2 = allUrlsForImage.b;
        if (!m13815d(uri2, 5439489, "UrlImageBindModelToRender")) {
            return null;
        }
        MarkerConfig a = allUrlsForImage.a(5439492, "UrlImageNetworkFetch", uri2.toString());
        Map map = a.l;
        map.put("UrlImageUrlBeingFetched", uri.toString());
        map.put("UrlImageNetworkFetchRequestStartDelay", String.valueOf(j));
        map.put("UrlImageNetworkFetchRetryNumber", String.valueOf(i));
        a.a(map);
        this.f12925b.c(a);
        return a;
    }

    public final boolean m13825a(MarkerConfig markerConfig) {
        if (!m13814d() || markerConfig == null) {
            return false;
        }
        this.f12925b.b(markerConfig);
        return true;
    }

    public final void m13824a(boolean z) {
        if (z) {
            m13806a();
        } else {
            this.f12930g = false;
        }
    }

    private void m13806a() {
        this.f12930g = true;
        m13812c();
    }

    private synchronized void m13812c() {
        while (this.f12930g && !this.f12929f.isEmpty()) {
            m13809a((ImageDimensions) this.f12929f.removeFirst());
        }
    }

    private void m13809a(ImageDimensions imageDimensions) {
        HoneyClientEventFast a = this.f12926c.a("wasteful_image_load", false);
        if (a.a()) {
            a.a("render_width", imageDimensions.a);
            a.a("render_height", imageDimensions.b);
            a.a("img_width", imageDimensions.c);
            a.a("img_height", imageDimensions.d);
            a.b();
        }
    }

    private boolean m13810a(Uri uri) {
        if (m13815d(uri, 5439489, "UrlImageBindModelToRender") || m13815d(uri, 5439491, "UrlImagePrefetch")) {
            return true;
        }
        return false;
    }

    private boolean m13815d(Uri uri, int i, String str) {
        AllUrlsForImage allUrlsForImage = (AllUrlsForImage) this.f12928e.get(uri);
        if (allUrlsForImage == null) {
            return false;
        }
        return this.f12925b.d(i, str, allUrlsForImage.f.b);
    }

    private void m13807a(Uri uri, List<Uri> list) {
        if (m13814d()) {
            AllUrlsForImage allUrlsForImage = new AllUrlsForImage(this, uri, list);
            if (!this.f12928e.containsKey(uri)) {
                this.f12928e.put(uri, allUrlsForImage);
            }
            for (Uri uri2 : list) {
                if (!this.f12928e.containsKey(uri2)) {
                    this.f12928e.put(uri2, allUrlsForImage);
                }
            }
        }
    }

    private boolean m13814d() {
        return !this.f12927d.a();
    }

    public final MarkerConfig m13826b(Uri uri, int i, String str) {
        if (uri == null) {
            return null;
        }
        m13807a(uri, (List) RegularImmutableList.a);
        if (m13815d(uri, i, str)) {
            return null;
        }
        return m13816a(uri, i, str);
    }
}
