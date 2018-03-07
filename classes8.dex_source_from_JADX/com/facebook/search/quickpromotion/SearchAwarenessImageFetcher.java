package com.facebook.search.quickpromotion;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: TEXT_CAPTION_LARGE */
public class SearchAwarenessImageFetcher {
    private static final CallerContext f22378a = CallerContext.a(SearchAwarenessImageFetcher.class, "search_awareness");
    private static volatile SearchAwarenessImageFetcher f22379e;
    public final ImagePipeline f22380b;
    public final AbstractFbErrorReporter f22381c;
    public final Map<ImageRequest, Boolean> f22382d = Collections.synchronizedMap(new HashMap());

    public static com.facebook.search.quickpromotion.SearchAwarenessImageFetcher m25873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22379e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.quickpromotion.SearchAwarenessImageFetcher.class;
        monitor-enter(r1);
        r0 = f22379e;	 Catch:{ all -> 0x003a }
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
        r0 = m25874b(r0);	 Catch:{ all -> 0x0035 }
        f22379e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22379e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.quickpromotion.SearchAwarenessImageFetcher.a(com.facebook.inject.InjectorLike):com.facebook.search.quickpromotion.SearchAwarenessImageFetcher");
    }

    private static SearchAwarenessImageFetcher m25874b(InjectorLike injectorLike) {
        return new SearchAwarenessImageFetcher(ImagePipelineMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    private SearchAwarenessImageFetcher(ImagePipeline imagePipeline, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f22380b = imagePipeline;
        this.f22381c = abstractFbErrorReporter;
    }

    public final void m25875a(Collection<ImageRequest> collection) {
        for (final ImageRequest imageRequest : collection) {
            this.f22382d.put(imageRequest, Boolean.valueOf(false));
            this.f22380b.e(imageRequest, f22378a).a(new BaseDataSubscriber<Void>(this) {
                final /* synthetic */ SearchAwarenessImageFetcher f22377b;

                protected final void m25871e(DataSource<Void> dataSource) {
                    if (dataSource.b()) {
                        SearchAwarenessImageFetcher searchAwarenessImageFetcher = this.f22377b;
                        ImageRequest imageRequest = imageRequest;
                        if (searchAwarenessImageFetcher.f22382d.containsKey(imageRequest)) {
                            searchAwarenessImageFetcher.f22382d.put(imageRequest, Boolean.valueOf(true));
                        } else {
                            searchAwarenessImageFetcher.f22381c.a("SearchAwareness", "Tried to mark fetch complete for imageRequest that wasn't started: " + imageRequest);
                        }
                    }
                }

                protected final void m25872f(DataSource<Void> dataSource) {
                    this.f22377b.f22381c.a("SearchAwareness", "Image prefetch failure: " + dataSource.e());
                }
            }, CallerThreadExecutor.a);
        }
    }
}
