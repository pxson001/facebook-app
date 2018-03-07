package com.facebook.friendsharing.photoremix.utils;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager$Privacy;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.debug.log.BLog;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: WWW_NFX_DIALOG */
public class PhotoRemixSavePhotoUtils {
    public static final String f12313a = PhotoRemixSavePhotoUtils.class.getName();
    public static final CallerContext f12314b = CallerContext.a(PhotoRemixSavePhotoUtils.class);
    public final ImagePipeline f12315c;
    public TempFileManager f12316d;
    public final Executor f12317e;

    /* compiled from: WWW_NFX_DIALOG */
    public class C11301 extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
        final /* synthetic */ DisposableFutureCallback f12311a;
        final /* synthetic */ PhotoRemixSavePhotoUtils f12312b;

        public C11301(PhotoRemixSavePhotoUtils photoRemixSavePhotoUtils, DisposableFutureCallback disposableFutureCallback) {
            this.f12312b = photoRemixSavePhotoUtils;
            this.f12311a = disposableFutureCallback;
        }

        protected final void m20399e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            if (dataSource.b()) {
                CloseableReference closeableReference = (CloseableReference) dataSource.d();
                if (closeableReference != null) {
                    PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
                    try {
                        String fileExtension = ImageFormat.getFileExtension(ImageFormatChecker.b(pooledByteBufferInputStream));
                        if (fileExtension == null) {
                            BLog.a(PhotoRemixSavePhotoUtils.f12313a, "Unknown image format");
                            this.f12311a.onFailure(new UnsupportedOperationException("Unknown image format"));
                            return;
                        }
                        File a = this.f12312b.f12316d.a("remix_tmp", "." + fileExtension, TempFileManager$Privacy.REQUIRE_PRIVATE);
                        PhotoRemixSavePhotoUtils.m20402b(pooledByteBufferInputStream, a);
                        this.f12311a.onSuccess(Uri.fromFile(a));
                        Closeables.a(pooledByteBufferInputStream);
                        CloseableReference.c(closeableReference);
                    } catch (IOException e) {
                        this.f12311a.onFailure(new Throwable(e.getMessage()));
                    } catch (UnsupportedOperationException e2) {
                        this.f12311a.onFailure(new Throwable(e2.getMessage()));
                    } finally {
                        Closeables.a(pooledByteBufferInputStream);
                        CloseableReference.c(closeableReference);
                    }
                }
            }
        }

        protected final void m20400f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            this.f12311a.onFailure(new Throwable("Failed saving photo"));
        }
    }

    public static PhotoRemixSavePhotoUtils m20401b(InjectorLike injectorLike) {
        return new PhotoRemixSavePhotoUtils(ImagePipelineMethodAutoProvider.a(injectorLike), TempFileManager.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoRemixSavePhotoUtils(ImagePipeline imagePipeline, TempFileManager tempFileManager, Executor executor) {
        this.f12315c = imagePipeline;
        this.f12316d = tempFileManager;
        this.f12317e = executor;
    }

    public static void m20402b(InputStream inputStream, File file) {
        Throwable th;
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreams.a(inputStream, fileOutputStream);
                fileOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
