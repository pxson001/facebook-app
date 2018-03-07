package com.facebook.composer.minutiae.widget;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DataSourceToFutureAdapter;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: task_key_update_poll_vote */
public class RidgeWidgetProfilePictureFetcher {
    private static final CallerContext f1933a = CallerContext.a(RidgeWidgetService.class, "composer");
    private static volatile RidgeWidgetProfilePictureFetcher f1934d;
    private final ImagePipeline f1935b;
    private final TasksManager<Integer> f1936c;

    public static com.facebook.composer.minutiae.widget.RidgeWidgetProfilePictureFetcher m1877a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1934d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.widget.RidgeWidgetProfilePictureFetcher.class;
        monitor-enter(r1);
        r0 = f1934d;	 Catch:{ all -> 0x003a }
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
        r0 = m1878b(r0);	 Catch:{ all -> 0x0035 }
        f1934d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1934d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.widget.RidgeWidgetProfilePictureFetcher.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.widget.RidgeWidgetProfilePictureFetcher");
    }

    private static RidgeWidgetProfilePictureFetcher m1878b(InjectorLike injectorLike) {
        return new RidgeWidgetProfilePictureFetcher(ImagePipelineMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public RidgeWidgetProfilePictureFetcher(ImagePipeline imagePipeline, TasksManager tasksManager) {
        this.f1935b = imagePipeline;
        this.f1936c = tasksManager;
    }

    public final void m1879a(Uri uri, AbstractDisposableFutureCallback<CloseableReference<CloseableImage>> abstractDisposableFutureCallback) {
        DataSourceToFutureAdapter a = DataSourceToFutureAdapter.a(this.f1935b.c(ImageRequest.a(uri), f1933a));
        if (this.f1936c.a(Integer.valueOf(1))) {
            this.f1936c.c(Integer.valueOf(1));
        }
        this.f1936c.a(Integer.valueOf(1), a, abstractDisposableFutureCallback);
    }
}
