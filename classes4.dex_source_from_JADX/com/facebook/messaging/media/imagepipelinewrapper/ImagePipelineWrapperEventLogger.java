package com.facebook.messaging.media.imagepipelinewrapper;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.HttpResponseException;

@Singleton
/* compiled from: pymk_network */
public class ImagePipelineWrapperEventLogger {
    private static volatile ImagePipelineWrapperEventLogger f3994b;
    private final AnalyticsLogger f3995a;

    public static com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapperEventLogger m4485a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3994b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapperEventLogger.class;
        monitor-enter(r1);
        r0 = f3994b;	 Catch:{ all -> 0x003a }
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
        r0 = m4487b(r0);	 Catch:{ all -> 0x0035 }
        f3994b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3994b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapperEventLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.imagepipelinewrapper.ImagePipelineWrapperEventLogger");
    }

    private static ImagePipelineWrapperEventLogger m4487b(InjectorLike injectorLike) {
        return new ImagePipelineWrapperEventLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ImagePipelineWrapperEventLogger(AnalyticsLogger analyticsLogger) {
        this.f3995a = analyticsLogger;
    }

    public static Map<String, String> m4486a(CallerContext callerContext) {
        Map<String, String> hashMap = new HashMap();
        if (callerContext != null) {
            hashMap.put("calling_class", callerContext.b);
            hashMap.put("analytics_tag", callerContext.c());
            hashMap.put("module_tag", callerContext.d());
            hashMap.put("feature_tag", callerContext.b());
        }
        return hashMap;
    }

    public final void m4489a(@Nullable Map<String, String> map, Throwable th) {
        if (map != null && map.size() != 0) {
            if (th instanceof HttpResponseException) {
                map.put("http_failure_status_code", String.valueOf(((HttpResponseException) th).getStatusCode()));
            }
            map.put("failure_exception_message", th.toString());
            map.put("fetch_image_success_ratio", "0");
            this.f3995a.a("messenger_image_pipeline_wrapper", map);
        }
    }

    public final void m4488a(@Nullable Map<String, String> map) {
        if (map != null && map.size() != 0) {
            map.put("fetch_image_success_ratio", "1");
            this.f3995a.a("messenger_image_pipeline_wrapper", map);
        }
    }
}
