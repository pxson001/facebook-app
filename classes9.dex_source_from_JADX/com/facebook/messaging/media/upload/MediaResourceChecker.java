package com.facebook.messaging.media.upload;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: local_filename */
public class MediaResourceChecker {
    private final ListeningExecutorService f11872a;
    private final MediaStorage f11873b;

    /* compiled from: local_filename */
    class CheckMediaResourceTask implements Callable<Result> {
        final /* synthetic */ MediaResourceChecker f11870a;
        private final MediaResource f11871b;

        public CheckMediaResourceTask(MediaResourceChecker mediaResourceChecker, MediaResource mediaResource) {
            this.f11870a = mediaResourceChecker;
            this.f11871b = mediaResource;
        }

        public Object call() {
            Result result;
            String path = this.f11871b.c.getPath();
            if (new File(path).exists()) {
                result = Result.VALID;
            } else {
                result = (!path.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath()) || MediaStorage.a()) ? Result.NONEXISTENT : Result.INACCESSIBLE;
            }
            Result result2 = result;
            if (result2 != Result.VALID) {
                return result2;
            }
            MediaResource mediaResource = this.f11871b;
            if (mediaResource.d != Type.PHOTO) {
                result = Result.VALID;
            } else {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(mediaResource.c.getPath(), options);
                result = (options.outWidth <= 0 || options.outHeight <= 0) ? Result.CORRUPTED : Result.VALID;
            }
            return result;
        }
    }

    /* compiled from: local_filename */
    public enum Result {
        VALID,
        NONEXISTENT,
        INACCESSIBLE,
        CORRUPTED
    }

    public static MediaResourceChecker m12467b(InjectorLike injectorLike) {
        return new MediaResourceChecker(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), MediaStorage.a(injectorLike));
    }

    @Inject
    public MediaResourceChecker(ListeningExecutorService listeningExecutorService, MediaStorage mediaStorage) {
        this.f11872a = listeningExecutorService;
        this.f11873b = mediaStorage;
    }

    public final ListenableFuture<Result> m12468a(MediaResource mediaResource) {
        return this.f11872a.a(new CheckMediaResourceTask(this, mediaResource));
    }
}
