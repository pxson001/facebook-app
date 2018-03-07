package com.facebook.messaging.quickcam;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.quickcam.QuickCamBitmapUtil;
import com.facebook.common.quickcam.QuickCamPreviewHolder;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.inject.InjectorLike;
import com.facebook.libyuv.YUVColorConverter;
import com.facebook.messaging.quickcam.PhotoParams.CaptureType;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: delta_t */
public class MediaOperations {
    public final DefaultAndroidThreadUtil f16421a;
    public final AbstractFbErrorReporter f16422b;
    public final MediaResourceHelper f16423c;
    public final QuickCamBitmapUtil f16424d;
    public final TempFileManager f16425e;

    /* compiled from: delta_t */
    class CameraPreviewCapture implements Function<Bitmap, Bitmap> {
        final /* synthetic */ MediaOperations f16410a;
        private final byte[] f16411b;

        @Nullable
        public Object apply(@Nullable Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            Preconditions.checkNotNull(bitmap);
            this.f16410a.f16421a.a();
            QuickCamBitmapUtil quickCamBitmapUtil = this.f16410a.f16424d;
            byte[] bArr = this.f16411b;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ByteBuffer put = ByteBuffer.allocateDirect(bArr.length).put(bArr);
            put.rewind();
            ByteBuffer slice = put.slice();
            ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.allocateDirect((width * height) * 4).order(ByteOrder.nativeOrder()).rewind();
            put.position(0);
            slice.position(width * height);
            YUVColorConverter.b(put, width, slice, width, byteBuffer, width * 4, width, height);
            byteBuffer.rewind();
            bitmap.copyPixelsFromBuffer(byteBuffer);
            return bitmap;
        }

        public CameraPreviewCapture(MediaOperations mediaOperations, byte[] bArr) {
            this.f16410a = mediaOperations;
            this.f16411b = bArr;
        }
    }

    /* compiled from: delta_t */
    public class CropPhoto implements Function<List<Bitmap>, Bitmap> {
        final /* synthetic */ MediaOperations f16412a;
        private final PhotoParams f16413b;

        @Nullable
        public Object apply(@Nullable Object obj) {
            Matrix a;
            List list = (List) obj;
            boolean z = true;
            Preconditions.checkNotNull(list);
            Preconditions.checkArgument(list.size() == 2);
            this.f16412a.f16421a.b();
            Bitmap bitmap = (Bitmap) list.get(0);
            Bitmap bitmap2 = (Bitmap) list.get(1);
            Canvas canvas = new Canvas(bitmap2);
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            if (this.f16413b.f16440g == CaptureType.TEXTURE) {
                a = this.f16412a.f16424d.m6394a(bitmap, bitmap2, this.f16413b.f16438e);
            } else {
                QuickCamBitmapUtil quickCamBitmapUtil = this.f16412a.f16424d;
                int i = this.f16413b.f16438e;
                if (this.f16413b.f16439f != Source.QUICKCAM_FRONT) {
                    z = false;
                }
                a = quickCamBitmapUtil.m6395a(bitmap, bitmap2, i, z);
            }
            canvas.drawBitmap(bitmap, a, paint);
            return bitmap2;
        }

        public CropPhoto(MediaOperations mediaOperations, PhotoParams photoParams) {
            this.f16412a = mediaOperations;
            this.f16413b = photoParams;
        }
    }

    /* compiled from: delta_t */
    class SavePhoto implements Function<Bitmap, MediaResource> {
        final /* synthetic */ MediaOperations f16414a;
        private final PhotoParams f16415b;

        @Nullable
        public Object apply(@Nullable Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            Preconditions.checkNotNull(bitmap);
            this.f16414a.f16421a.b();
            File a = this.f16414a.f16425e.a("orca-image-", ".jpg", Privacy.REQUIRE_PRIVATE);
            Throwable th;
            try {
                OutputStream fileOutputStream = new FileOutputStream(a);
                Throwable th2 = null;
                try {
                    bitmap.compress(CompressFormat.JPEG, 85, fileOutputStream);
                    fileOutputStream.close();
                    MediaResourceBuilder b = MediaResource.a().a(Uri.fromFile(a)).a(Type.PHOTO).a(this.f16415b.f16439f).a("is_full_screen", String.valueOf(this.f16415b.f16441h)).a("device_orientation", this.f16415b.f16442i).b("image/jpg");
                    this.f16414a.f16423c.a(b);
                    return b.C();
                } catch (Throwable th22) {
                    Throwable th3 = th22;
                    th22 = th;
                    th = th3;
                }
                if (th22 != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    fileOutputStream.close();
                }
                throw th;
                throw th;
            } catch (Throwable th5) {
                this.f16414a.f16422b.a("QuickCamPopup", "Probably not enough space to make a temp file");
                throw Throwables.propagate(th5);
            }
        }

        public SavePhoto(MediaOperations mediaOperations, PhotoParams photoParams) {
            this.f16414a = mediaOperations;
            this.f16415b = photoParams;
        }
    }

    /* compiled from: delta_t */
    public class SaveVideo implements Function<Uri, MediaResource> {
        final /* synthetic */ MediaOperations f16416a;
        private final VideoParams f16417b;
        @Nullable
        private final Source f16418c;

        @Nullable
        public Object apply(@Nullable Object obj) {
            Uri uri = (Uri) obj;
            MediaResourceBuilder a = MediaResource.a();
            a.a = uri;
            a = a;
            a.b = Type.VIDEO;
            a = a;
            a.c = this.f16418c;
            a = a;
            a.p = true;
            a = a;
            if (this.f16417b != null) {
                a.o = this.f16417b.f16602f;
                a = a.a("is_full_screen", String.valueOf(this.f16417b.f16601e)).a("device_orientation", this.f16417b.f16603g);
            }
            this.f16416a.f16423c.a(a);
            return a.C();
        }

        public SaveVideo(MediaOperations mediaOperations, VideoParams videoParams) {
            this.f16416a = mediaOperations;
            this.f16417b = videoParams;
            this.f16418c = this.f16417b.f16600d;
        }

        public SaveVideo(MediaOperations mediaOperations, Source source) {
            this.f16416a = mediaOperations;
            this.f16418c = source;
            this.f16417b = null;
        }
    }

    /* compiled from: delta_t */
    class TexturePhotoCapture implements Function<Bitmap, Bitmap> {
        final /* synthetic */ MediaOperations f16419a;
        private final QuickCamPreviewHolder f16420b;

        @Nullable
        public Object apply(@Nullable Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            Preconditions.checkNotNull(bitmap);
            this.f16419a.f16421a.a();
            this.f16420b.mo233a(bitmap);
            bitmap.setPixel(0, 0, bitmap.getPixel(0, 0));
            return bitmap;
        }

        public TexturePhotoCapture(MediaOperations mediaOperations, QuickCamPreviewHolder quickCamPreviewHolder) {
            this.f16419a = mediaOperations;
            this.f16420b = quickCamPreviewHolder;
        }
    }

    public static MediaOperations m16472b(InjectorLike injectorLike) {
        return new MediaOperations(DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), MediaResourceHelper.a(injectorLike), QuickCamBitmapUtil.m6393b(injectorLike), TempFileManager.a(injectorLike));
    }

    public static MediaOperations m16471a(InjectorLike injectorLike) {
        return m16472b(injectorLike);
    }

    @Inject
    public MediaOperations(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, MediaResourceHelper mediaResourceHelper, QuickCamBitmapUtil quickCamBitmapUtil, TempFileManager tempFileManager) {
        this.f16421a = defaultAndroidThreadUtil;
        this.f16422b = abstractFbErrorReporter;
        this.f16423c = mediaResourceHelper;
        this.f16424d = quickCamBitmapUtil;
        this.f16425e = tempFileManager;
    }

    public final Function<Bitmap, Bitmap> m16473a(QuickCamPreviewHolder quickCamPreviewHolder) {
        return new TexturePhotoCapture(this, quickCamPreviewHolder);
    }

    public final Function<Bitmap, Bitmap> m16474a(byte[] bArr) {
        return new CameraPreviewCapture(this, bArr);
    }

    public final Function<Bitmap, MediaResource> m16475b(PhotoParams photoParams) {
        return new SavePhoto(this, photoParams);
    }
}
