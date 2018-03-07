package com.facebook.photos.editgallery.utils;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.util.UriUtil;
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
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: last_finish_element */
public class FetchImageUtils {
    public static final String f10515a = FetchImageUtils.class.getName();
    public static final CallerContext f10516b = CallerContext.a(FetchImageUtils.class);
    public final ImagePipeline f10517c;
    public final TempFileManager f10518d;
    public final Executor f10519e;

    public static FetchImageUtils m12376b(InjectorLike injectorLike) {
        return new FetchImageUtils(ImagePipelineMethodAutoProvider.a(injectorLike), TempFileManager.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchImageUtils(ImagePipeline imagePipeline, TempFileManager tempFileManager, Executor executor) {
        this.f10517c = imagePipeline;
        this.f10518d = tempFileManager;
        this.f10519e = executor;
    }

    public final void m12378a(Context context, Uri uri, final AbstractDisposableFutureCallback<Uri> abstractDisposableFutureCallback) {
        if (UriUtil.a(uri)) {
            Preconditions.checkNotNull(abstractDisposableFutureCallback);
            this.f10517c.d(ImageRequest.a(uri), f10516b).a(new BaseDataSubscriber<CloseableReference<PooledByteBuffer>>(this) {
                final /* synthetic */ FetchImageUtils f10514b;

                protected final void m12374e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    if (dataSource.b()) {
                        CloseableReference closeableReference = (CloseableReference) dataSource.d();
                        if (closeableReference != null) {
                            PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((NativePooledByteBuffer) closeableReference.a());
                            try {
                                String fileExtension = ImageFormat.getFileExtension(ImageFormatChecker.b(pooledByteBufferInputStream));
                                if (fileExtension == null) {
                                    BLog.a(FetchImageUtils.f10515a, "Unknown image format");
                                    abstractDisposableFutureCallback.onFailure(new UnsupportedOperationException("Unknown image format"));
                                    return;
                                }
                                File a = this.f10514b.f10518d.a("edit_gallery_fetch_image_temp", "." + fileExtension, Privacy.REQUIRE_PRIVATE);
                                FetchImageUtils.m12377b(pooledByteBufferInputStream, a);
                                abstractDisposableFutureCallback.onSuccess(Uri.fromFile(a));
                                Closeables.a(pooledByteBufferInputStream);
                                CloseableReference.c(closeableReference);
                            } catch (IOException e) {
                                abstractDisposableFutureCallback.onFailure(new Throwable(e.getMessage()));
                            } catch (UnsupportedOperationException e2) {
                                abstractDisposableFutureCallback.onFailure(new Throwable(e2.getMessage()));
                            } finally {
                                Closeables.a(pooledByteBufferInputStream);
                                CloseableReference.c(closeableReference);
                            }
                        }
                    }
                }

                protected final void m12375f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
                    abstractDisposableFutureCallback.onFailure(new Throwable("Failed saving photo"));
                }
            }, this.f10519e);
        } else if (UriUtil.c(uri)) {
            m12379b(context, uri, abstractDisposableFutureCallback);
        } else {
            abstractDisposableFutureCallback.onSuccess(uri);
        }
    }

    public final void m12379b(Context context, Uri uri, AbstractDisposableFutureCallback<Uri> abstractDisposableFutureCallback) {
        try {
            Throwable th;
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            Throwable th2 = null;
            try {
                File a = this.f10518d.a("edit_gallery_fetch_image_temp", "." + MimeTypeMap.getFileExtensionFromUrl(context.getContentResolver().getType(uri)), Privacy.REQUIRE_PRIVATE);
                m12377b(openInputStream, a);
                abstractDisposableFutureCallback.onSuccess(Uri.fromFile(a));
                if (openInputStream != null) {
                    openInputStream.close();
                    return;
                }
                return;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (openInputStream != null) {
                if (th22 != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    openInputStream.close();
                }
            }
            throw th;
            throw th;
        } catch (IOException e) {
            abstractDisposableFutureCallback.onFailure(new Throwable(e.getMessage()));
        }
    }

    public static void m12377b(InputStream inputStream, File file) {
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
