package com.facebook.photos.mediagallery.ui.widget;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.sharing.TempBinaryFileManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: skip_activity_log */
public class FrescoMediaGalleryActionsGenerator extends MediaGalleryActionsGenerator {
    private static final CallerContext f2588b = CallerContext.a(FrescoMediaGalleryActionsGenerator.class, "set_cover_photo");
    private static volatile FrescoMediaGalleryActionsGenerator f2589e;
    private final ImagePipeline f2590a;
    private final TempBinaryFileManager f2591c;
    private final ExecutorService f2592d;

    public static com.facebook.photos.mediagallery.ui.widget.FrescoMediaGalleryActionsGenerator m2684a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2589e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.mediagallery.ui.widget.FrescoMediaGalleryActionsGenerator.class;
        monitor-enter(r1);
        r0 = f2589e;	 Catch:{ all -> 0x003a }
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
        r0 = m2686b(r0);	 Catch:{ all -> 0x0035 }
        f2589e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2589e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.ui.widget.FrescoMediaGalleryActionsGenerator.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediagallery.ui.widget.FrescoMediaGalleryActionsGenerator");
    }

    private static FrescoMediaGalleryActionsGenerator m2686b(InjectorLike injectorLike) {
        return new FrescoMediaGalleryActionsGenerator(ImagePipelineMethodAutoProvider.a(injectorLike), TempBinaryFileManager.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FrescoMediaGalleryActionsGenerator(ImagePipeline imagePipeline, TempBinaryFileManager tempBinaryFileManager, ExecutorService executorService) {
        this.f2590a = imagePipeline;
        this.f2591c = tempBinaryFileManager;
        this.f2592d = executorService;
    }

    protected final FrescoMediaGalleryActionsGenerator mo130a() {
        return this;
    }

    protected final void mo131a(MediaMetadata mediaMetadata, AbstractDisposableFutureCallback abstractDisposableFutureCallback, DataSubscriber dataSubscriber) {
        m2683a(mediaMetadata).a(dataSubscriber, this.f2592d);
    }

    protected final void mo132b(MediaMetadata mediaMetadata, AbstractDisposableFutureCallback abstractDisposableFutureCallback, DataSubscriber dataSubscriber) {
        m2683a(mediaMetadata).a(dataSubscriber, this.f2592d);
    }

    protected final void m2691a(MediaMetadata mediaMetadata, DataSubscriber dataSubscriber) {
        m2685b(mediaMetadata).a(dataSubscriber, this.f2592d);
    }

    protected final void m2693b(MediaMetadata mediaMetadata, DataSubscriber dataSubscriber) {
        m2685b(mediaMetadata).a(dataSubscriber, this.f2592d);
    }

    @VisibleForTesting
    private DataSource<CloseableReference<PooledByteBuffer>> m2683a(MediaMetadata mediaMetadata) {
        return this.f2590a.d(ImageRequest.a(Uri.parse(mediaMetadata.g().b())), f2588b);
    }

    @VisibleForTesting
    private DataSource<CloseableReference<CloseableImage>> m2685b(MediaMetadata mediaMetadata) {
        return this.f2590a.c(ImageRequest.a(Uri.parse(mediaMetadata.g().b())), f2588b);
    }

    protected final Uri m2688a(InputStream inputStream, File file) {
        Preconditions.checkNotNull(inputStream);
        return this.f2591c.a(inputStream, file);
    }

    protected final Uri m2687a(Bitmap bitmap, File file) {
        Preconditions.checkNotNull(bitmap);
        return this.f2591c.a(bitmap, file);
    }
}
