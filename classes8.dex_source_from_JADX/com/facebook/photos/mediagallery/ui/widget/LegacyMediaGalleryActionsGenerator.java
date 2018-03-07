package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.file.FileUtils;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.datasource.DataSubscriber;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.sharing.TempBinaryFileManager;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: single_tap_on_video */
public class LegacyMediaGalleryActionsGenerator extends MediaGalleryActionsGenerator {
    private static volatile LegacyMediaGalleryActionsGenerator f2609g;
    public final Context f2610a;
    private final ImageCache f2611b;
    @DefaultExecutorService
    private final ListeningExecutorService f2612c;
    public final TempBinaryFileManager f2613d;
    private final TasksManager f2614e;
    public final FrescoMediaGalleryActionsGenerator f2615f;

    public static com.facebook.photos.mediagallery.ui.widget.LegacyMediaGalleryActionsGenerator m2710a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2609g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.mediagallery.ui.widget.LegacyMediaGalleryActionsGenerator.class;
        monitor-enter(r1);
        r0 = f2609g;	 Catch:{ all -> 0x003a }
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
        r0 = m2711b(r0);	 Catch:{ all -> 0x0035 }
        f2609g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2609g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.ui.widget.LegacyMediaGalleryActionsGenerator.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediagallery.ui.widget.LegacyMediaGalleryActionsGenerator");
    }

    private static LegacyMediaGalleryActionsGenerator m2711b(InjectorLike injectorLike) {
        return new LegacyMediaGalleryActionsGenerator((Context) injectorLike.getInstance(Context.class), ImageCache.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TempBinaryFileManager.a(injectorLike), TasksManager.b(injectorLike), FrescoMediaGalleryActionsGenerator.m2684a(injectorLike));
    }

    @Inject
    public LegacyMediaGalleryActionsGenerator(Context context, ImageCache imageCache, ListeningExecutorService listeningExecutorService, TempBinaryFileManager tempBinaryFileManager, TasksManager tasksManager, FrescoMediaGalleryActionsGenerator frescoMediaGalleryActionsGenerator) {
        this.f2610a = context;
        this.f2611b = imageCache;
        this.f2612c = listeningExecutorService;
        this.f2613d = tempBinaryFileManager;
        this.f2614e = tasksManager;
        this.f2615f = frescoMediaGalleryActionsGenerator;
    }

    protected final FrescoMediaGalleryActionsGenerator mo130a() {
        return this.f2615f;
    }

    @VisibleForTesting
    protected final void mo131a(final MediaMetadata mediaMetadata, final AbstractDisposableFutureCallback abstractDisposableFutureCallback, final DataSubscriber dataSubscriber) {
        this.f2614e.a(Integer.valueOf(2006), m2713c(mediaMetadata), new AbstractDisposableFutureCallback<File>(this) {
            final /* synthetic */ LegacyMediaGalleryActionsGenerator f2600d;

            protected final void m2706a(Object obj) {
                abstractDisposableFutureCallback.onSuccess((File) obj);
            }

            protected final void m2707a(Throwable th) {
                this.f2600d.f2615f.mo131a(mediaMetadata, abstractDisposableFutureCallback, dataSubscriber);
            }
        });
    }

    @VisibleForTesting
    protected final void mo132b(final MediaMetadata mediaMetadata, final AbstractDisposableFutureCallback abstractDisposableFutureCallback, final DataSubscriber dataSubscriber) {
        this.f2614e.a(Integer.valueOf(2004), m2712b(mediaMetadata), new AbstractDisposableFutureCallback<Uri>(this) {
            final /* synthetic */ LegacyMediaGalleryActionsGenerator f2604d;

            protected final void m2708a(Object obj) {
                abstractDisposableFutureCallback.onSuccess((Uri) obj);
            }

            protected final void m2709a(Throwable th) {
                this.f2604d.f2615f.mo132b(mediaMetadata, abstractDisposableFutureCallback, dataSubscriber);
            }
        });
    }

    @VisibleForTesting
    private ListenableFuture<Uri> m2712b(final MediaMetadata mediaMetadata) {
        return this.f2612c.a(new Callable<Uri>(this) {
            final /* synthetic */ LegacyMediaGalleryActionsGenerator f2606b;

            public Object call() {
                BinaryResource a = this.f2606b.m2714a(mediaMetadata);
                if (a != null) {
                    return this.f2606b.f2613d.a(a);
                }
                throw new IOException(StringFormatUtil.formatStrLocaleSafe("Could not save file %s", mediaMetadata.g().b()));
            }
        });
    }

    @VisibleForTesting
    private ListenableFuture<File> m2713c(final MediaMetadata mediaMetadata) {
        return this.f2612c.a(new Callable<File>(this) {
            final /* synthetic */ LegacyMediaGalleryActionsGenerator f2608b;

            public Object call() {
                BinaryResource a = this.f2608b.m2714a(mediaMetadata);
                if (a == null) {
                    throw new IOException("failed to obtain source image");
                }
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Facebook");
                FileUtils.a(file);
                File a2 = this.f2608b.f2613d.a(a, new File(file, StringFormatUtil.formatStrLocaleSafe("%s_%d.jpg", "FB_IMG", Long.valueOf(new Date().getTime()))));
                MediaScannerConnection.scanFile(this.f2608b.f2610a, new String[]{a2.getAbsolutePath()}, new String[]{"image/jpeg"}, null);
                return a2;
            }
        });
    }

    @Nullable
    @VisibleForTesting
    final BinaryResource m2714a(MediaMetadata mediaMetadata) {
        return this.f2611b.d(FetchImageParams.a(Uri.parse(mediaMetadata.g().b())).a().k());
    }
}
