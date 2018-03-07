package com.facebook.photos.upload.service;

import android.util.Log;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler.Cancelable;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.uploaders.MediaUploader;
import com.facebook.photos.upload.uploaders.MultiPhotoUploader;
import com.facebook.photos.upload.uploaders.MultimediaUploader;
import com.facebook.photos.upload.uploaders.PartialUploadException;
import com.facebook.photos.upload.uploaders.VideoUploader;
import com.facebook.photos.upload.uploaders.WakeLockHandler;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fs_total_dir_size */
public class PhotosUploadServiceHandler implements BlueServiceHandler, Cancelable {
    private static final Class<?> f14256a = PhotosUploadServiceHandler.class;
    private static volatile PhotosUploadServiceHandler f14257o;
    private final boolean f14258b = Log.isLoggable("MediaUpload", 3);
    private final MultiPhotoUploader f14259c;
    private final VideoUploader f14260d;
    private final MultimediaUploader f14261e;
    private final ExecutorService f14262f;
    public final AbstractFbErrorReporter f14263g;
    private final UploadManager f14264h;
    private final WakeLockHandler f14265i;
    @GuardedBy("this")
    public MediaUploader f14266j = null;
    private volatile boolean f14267k;
    public CountDownLatch f14268l;
    @GuardedBy("this")
    private final HashSet<String> f14269m = Sets.a();
    private final HashSet<String> f14270n = Sets.a();

    /* compiled from: fs_total_dir_size */
    class C09231 implements Runnable {
        final /* synthetic */ PhotosUploadServiceHandler f14255a;

        C09231(PhotosUploadServiceHandler photosUploadServiceHandler) {
            this.f14255a = photosUploadServiceHandler;
        }

        public void run() {
            try {
                this.f14255a.f14267k = this.f14255a.f14266j.mo1159b();
            } catch (Throwable e) {
                this.f14255a.f14263g.a("MediaUploader.cancel", e);
            } finally {
                this.f14255a.f14268l.countDown();
            }
        }
    }

    public static com.facebook.photos.upload.service.PhotosUploadServiceHandler m21935a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14257o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.service.PhotosUploadServiceHandler.class;
        monitor-enter(r1);
        r0 = f14257o;	 Catch:{ all -> 0x003a }
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
        r0 = m21938b(r0);	 Catch:{ all -> 0x0035 }
        f14257o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14257o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.service.PhotosUploadServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.service.PhotosUploadServiceHandler");
    }

    private static PhotosUploadServiceHandler m21938b(InjectorLike injectorLike) {
        return new PhotosUploadServiceHandler(MultiPhotoUploader.m22023b(injectorLike), VideoUploader.m22129b(injectorLike), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), UploadManager.a(injectorLike), WakeLockHandler.m22168a(injectorLike), MultimediaUploader.m22030b(injectorLike));
    }

    @Inject
    public PhotosUploadServiceHandler(MultiPhotoUploader multiPhotoUploader, VideoUploader videoUploader, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, UploadManager uploadManager, WakeLockHandler wakeLockHandler, MultimediaUploader multimediaUploader) {
        this.f14259c = multiPhotoUploader;
        this.f14260d = videoUploader;
        this.f14262f = executorService;
        this.f14263g = abstractFbErrorReporter;
        this.f14264h = uploadManager;
        this.f14265i = wakeLockHandler;
        this.f14261e = multimediaUploader;
    }

    public final OperationResult m21939a(OperationParams operationParams) {
        this.f14265i.m22170a();
        try {
            OperationResult a;
            String a2 = operationParams.a();
            if ("photo_upload_op".equals(a2)) {
                a = m21934a(this.f14259c, operationParams);
            } else if ("video_upload_op".equals(a2)) {
                a = m21934a(this.f14260d, operationParams);
                this.f14265i.m22171b();
            } else if ("multimedia_upload_op".equals(a2)) {
                a = m21934a(this.f14261e, operationParams);
                this.f14265i.m22171b();
            } else {
                throw new UnsupportedOperationException("Cannot handle operation " + a2);
            }
            return a;
        } finally {
            this.f14265i.m22171b();
        }
    }

    private OperationResult m21934a(MediaUploader mediaUploader, OperationParams operationParams) {
        try {
            UploadOperation uploadOperation;
            synchronized (this) {
                uploadOperation = (UploadOperation) operationParams.b().getParcelable("uploadOp");
                if (this.f14266j != null) {
                    UploadRecords u = uploadOperation.m21546u();
                    Map a = u != null ? u.m21600a() : null;
                    if (a == null) {
                        a = Maps.c();
                    }
                    throw new PartialUploadException(new ExceptionInterpreter(new IllegalStateException("PhotosUploadServiceHandler re-entrance!")), a);
                }
                this.f14264h.f(uploadOperation.m21509N());
                if ("photo_upload_op".equals(operationParams.a()) && this.f14270n.contains(uploadOperation.m21509N())) {
                    this.f14263g.a(f14256a.getSimpleName(), "Repeating successful upload " + uploadOperation.m21509N());
                }
                this.f14266j = mediaUploader;
                if (this.f14258b) {
                    this.f14266j.getClass().getSimpleName();
                }
                this.f14266j.mo1158a();
                if (this.f14269m.remove(uploadOperation.m21509N())) {
                    throw new CancellationException("Cancelled prior to starting");
                }
            }
            OperationResult a2 = mediaUploader.mo1157a(uploadOperation);
            if (this.f14258b) {
                m21936a();
            }
            if ("photo_upload_op".equals(operationParams.a())) {
                this.f14270n.add(uploadOperation.m21509N());
            }
            synchronized (this) {
                this.f14266j = null;
            }
            return a2;
        } catch (Throwable e) {
            BLog.a(f14256a, e, "CancellationException in %s", new Object[]{m21936a()});
            throw e;
        } catch (Throwable e2) {
            BLog.a(f14256a, e2, "PartialUploadException in %s", new Object[]{m21936a()});
            throw e2;
        } catch (Throwable th) {
            synchronized (this) {
                this.f14266j = null;
            }
        }
    }

    private synchronized String m21936a() {
        return this.f14266j == null ? "<no media uploader>" : this.f14266j.getClass().getSimpleName();
    }

    public final synchronized boolean m21940a(String str) {
        boolean z = false;
        synchronized (this) {
            if (this.f14266j != null) {
                this.f14267k = false;
                if (this.f14258b) {
                    this.f14266j.getClass().getSimpleName();
                }
                this.f14268l = new CountDownLatch(1);
                try {
                    ExecutorDetour.a(this.f14262f, new C09231(this), -1567893357);
                    this.f14268l.await();
                    if (this.f14258b) {
                        new StringBuilder("Did we cancel ").append(this.f14266j.getClass().getSimpleName()).append("? ").append(this.f14267k ? "Yes!" : "No!");
                    }
                    z = this.f14267k;
                } catch (InterruptedException e) {
                }
            }
        }
        return z;
    }
}
