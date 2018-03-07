package com.facebook.messaging.composer.triggers.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipeline.2;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: messenger_customthreads_picker_open */
public class ContentSearchLogger {
    private static volatile ContentSearchLogger f9930d;
    public final AnalyticsLogger f9931a;
    private final ImagePipeline f9932b;
    public final QuickPerformanceLogger f9933c;

    public static com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger m10478a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9930d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger.class;
        monitor-enter(r1);
        r0 = f9930d;	 Catch:{ all -> 0x003a }
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
        r0 = m10480b(r0);	 Catch:{ all -> 0x0035 }
        f9930d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9930d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger");
    }

    private static ContentSearchLogger m10480b(InjectorLike injectorLike) {
        return new ContentSearchLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContentSearchLogger(AnalyticsLogger analyticsLogger, ImagePipeline imagePipeline, QuickPerformanceLogger quickPerformanceLogger) {
        this.f9931a = analyticsLogger;
        this.f9932b = imagePipeline;
        this.f9933c = quickPerformanceLogger;
    }

    public final void m10481a() {
        this.f9933c.b(6815746);
    }

    public final void m10484c() {
        this.f9933c.b(6815746, (short) 3);
    }

    public final void m10485d() {
        this.f9933c.d(6815746);
    }

    public final void m10483a(ImageRequest[] imageRequestArr, CallerContext callerContext, String str, String str2) {
        Builder builder = ImmutableList.builder();
        for (ImageRequest 2 : imageRequestArr) {
            builder.c(new 2(this.f9932b, 2, callerContext));
        }
        FirstAvailableDataSourceSupplier.a(builder.b()).b().a(m10479b(str, str2), CallerThreadExecutor.a);
    }

    public final void m10482a(ImageRequest imageRequest, CallerContext callerContext, String str, String str2) {
        this.f9932b.d(imageRequest, callerContext).a(m10479b(str, str2), CallerThreadExecutor.a);
    }

    private BaseDataSubscriber<CloseableReference<PooledByteBuffer>> m10479b(final String str, final String str2) {
        return new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(this) {
            final /* synthetic */ ContentSearchLogger f9929c;

            protected final void m10476e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                if (dataSource.b() && dataSource.c()) {
                    int a = ((NativePooledByteBuffer) ((CloseableReference) dataSource.d()).a()).a();
                    ContentSearchLogger contentSearchLogger = this.f9929c;
                    String str = str;
                    String str2 = str2;
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("content_search_result_resource_size");
                    honeyClientEvent.c = "content_search_result";
                    honeyClientEvent.b("app_id", str).a("resource_size_in_bytes", a).b("result_id", str2);
                    contentSearchLogger.f9931a.a(honeyClientEvent);
                    ((CloseableReference) dataSource.d()).close();
                }
            }

            protected final void m10477f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            }
        };
    }
}
