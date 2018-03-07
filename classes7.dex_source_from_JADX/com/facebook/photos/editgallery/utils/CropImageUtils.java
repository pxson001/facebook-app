package com.facebook.photos.editgallery.utils;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import com.facebook.bitmaps.Dimension;
import com.facebook.bitmaps.ImageResizer.ImageResizingInputFileException;
import com.facebook.bitmaps.NativeImageProcessor;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.utilities.CreativeEditingFileManager;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: last_song_played */
public class CropImageUtils {
    public final String f10505a;
    public final ListeningExecutorService f10506b;
    public final CreativeEditingFileManager f10507c;
    public final ImagePipeline f10508d;
    private final Lazy<TasksManager> f10509e;
    public final NativeImageProcessor f10510f;
    public final Toaster f10511g;
    public Uri f10512h;

    /* compiled from: last_song_played */
    public interface CropCallback {
        void mo595a(CreativeEditingData creativeEditingData);

        void mo596a(Throwable th, CreativeEditingData creativeEditingData);
    }

    @Inject
    public CropImageUtils(@Assisted String str, ListeningExecutorService listeningExecutorService, CreativeEditingFileManager creativeEditingFileManager, ImagePipeline imagePipeline, Lazy<TasksManager> lazy, NativeImageProcessor nativeImageProcessor, Toaster toaster) {
        this.f10505a = str;
        this.f10506b = listeningExecutorService;
        this.f10507c = creativeEditingFileManager;
        this.f10508d = imagePipeline;
        this.f10509e = lazy;
        this.f10510f = nativeImageProcessor;
        this.f10511g = toaster;
    }

    public final void m12372a(final CreativeEditingData creativeEditingData, Uri uri, Dimension dimension, final RectF rectF, final CropCallback cropCallback) {
        Preconditions.checkNotNull(rectF);
        final CreativeEditingData creativeEditingData2 = creativeEditingData;
        final Uri uri2 = uri;
        final RectF rectF2 = rectF;
        final Dimension dimension2 = dimension;
        ((TasksManager) this.f10509e.get()).a("crop_task", new Callable<ListenableFuture>(this) {
            final /* synthetic */ CropImageUtils f10504e;

            /* compiled from: last_song_played */
            class C08891 implements Runnable {
                final /* synthetic */ C08902 f10499a;

                C08891(C08902 c08902) {
                    this.f10499a = c08902;
                }

                public void run() {
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        File a;
                        String path = creativeEditingData2.o() == null ? null : creativeEditingData2.o().getPath();
                        if (path == null) {
                            try {
                                a = this.f10499a.f10504e.f10507c.a(this.f10499a.f10504e.f10505a, "jpg");
                            } catch (ImageResizingInputFileException e) {
                                e.printStackTrace();
                                if (this.f10499a.f10504e.f10512h != null) {
                                    CreativeEditingFileManager.a(this.f10499a.f10504e.f10512h);
                                    return;
                                }
                                return;
                            } catch (IOException e2) {
                                if (this.f10499a.f10504e.f10512h != null) {
                                    CreativeEditingFileManager.a(this.f10499a.f10504e.f10512h);
                                    return;
                                }
                                return;
                            }
                        }
                        a = new File(path);
                        if (NativeImageProcessor.a(uri2.getPath())) {
                            NativeImageProcessor.a(uri2.getPath(), 0, rectF2, a.getPath());
                        } else {
                            this.f10499a.f10504e.f10510f.a(uri2.getPath(), dimension2.b, dimension2.a, 0, rectF2, a.getPath());
                        }
                        this.f10499a.f10504e.f10512h = Uri.fromFile(a);
                        this.f10499a.f10504e.f10508d.a(this.f10499a.f10504e.f10512h);
                        return;
                    }
                    this.f10499a.f10504e.f10511g.b(new ToastBuilder(2131237820));
                }
            }

            public Object call() {
                return this.f10504e.f10506b.a(new C08891(this));
            }
        }, new AbstractDisposableFutureCallback(this) {
            final /* synthetic */ CropImageUtils f10498d;

            protected final void m12369a(Object obj) {
                Builder builder = new Builder(creativeEditingData);
                builder.c = this.f10498d.f10512h;
                builder = builder;
                builder.e = rectF;
                cropCallback.mo595a(builder.a());
            }

            protected final void m12370a(Throwable th) {
                cropCallback.mo596a(th, creativeEditingData);
            }
        });
    }
}
