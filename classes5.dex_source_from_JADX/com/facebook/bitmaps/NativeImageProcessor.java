package com.facebook.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import com.facebook.bitmaps.ImageResizer.DownscalePolicy;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.ImageResizer.ImageResizingInputFileException;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.inject.Inject;

@DoNotStrip
@Deprecated
/* compiled from: android.support.v4.app.INotificationSideChannel */
public class NativeImageProcessor {
    public static final List<Integer> f10373a = ImmutableList.of(Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270));
    private final BitmapUtils f10374b;
    private final NativeImageLibraries f10375c;
    private final Lazy<FbErrorReporter> f10376d;

    /* compiled from: android.support.v4.app.INotificationSideChannel */
    /* synthetic */ class C09981 {
        static final /* synthetic */ int[] f10372a = new int[ImageFormat.values().length];

        static {
            try {
                f10372a[ImageFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @DoNotStrip
    /* compiled from: android.support.v4.app.INotificationSideChannel */
    public class NativeImageProcessorException extends ImageResizingException {
        @DoNotStrip
        public NativeImageProcessorException(String str) {
            super(str, false);
        }

        @DoNotStrip
        public NativeImageProcessorException(String str, boolean z) {
            super(str, z);
        }

        @DoNotStrip
        public NativeImageProcessorException(Throwable th, boolean z) {
            super(th, z);
        }

        @DoNotStrip
        public NativeImageProcessorException(String str, Throwable th, boolean z) {
            super(str, th, z);
        }
    }

    /* compiled from: android.support.v4.app.INotificationSideChannel */
    public enum RotationMode {
        ROTATE_TO_0,
        NO_ROTATION
    }

    @DoNotStrip
    private native void cropFaceIntoBitmap(String str, int i, RectF rectF, int i2, boolean z, boolean z2, Bitmap bitmap, float[] fArr, int[] iArr);

    @DoNotStrip
    private native void cropFaceIntoBitmapFromBitmap(Bitmap bitmap, int i, RectF rectF, int i2, boolean z, boolean z2, Bitmap bitmap2, float[] fArr, int[] iArr);

    @DoNotStrip
    private static native void cropJpeg(String str, int i, RectF rectF, OutputStream outputStream);

    @DoNotStrip
    private native void nativeRotateJpeg(InputStream inputStream, OutputStream outputStream, int i);

    @DoNotStrip
    private native byte[] transcodeJpeg(String str, int i, int i2, int i3, int i4, int i5, int i6);

    @DoNotStrip
    public native boolean areBitmapsSame(Bitmap bitmap, Bitmap bitmap2);

    @DoNotStrip
    public native void startProfiler();

    @DoNotStrip
    public native void stopProfiler();

    public static NativeImageProcessor m18472b(InjectorLike injectorLike) {
        return new NativeImageProcessor(IdBasedSingletonScopeProvider.b(injectorLike, 494), BitmapUtils.a(injectorLike), NativeImageLibraries.a(injectorLike));
    }

    public static NativeImageProcessor m18466a(InjectorLike injectorLike) {
        return m18472b(injectorLike);
    }

    public final boolean m18476a() {
        return this.f10375c.ah_();
    }

    @Inject
    public NativeImageProcessor(Lazy<FbErrorReporter> lazy, BitmapUtils bitmapUtils, NativeImageLibraries nativeImageLibraries) {
        this.f10374b = bitmapUtils;
        this.f10375c = nativeImageLibraries;
        this.f10375c.ah_();
        this.f10376d = lazy;
    }

    public final byte[] m18477a(String str, int i, int i2, int i3, DownscalePolicy downscalePolicy, RotationMode rotationMode, int i4) {
        if (new File(str).exists()) {
            m18467a(i2, i3, i4);
            return transcodeJpeg(str, i, i2, i3, downscalePolicy.ordinal(), rotationMode.ordinal(), i4);
        }
        throw new ImageResizingInputFileException("N/missing file: " + str, false);
    }

    private static void m18467a(int i, int i2, int i3) {
        boolean z;
        boolean z2 = true;
        if (i > 16) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (i2 > 16) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (i3 > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (i3 > 100) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
    }

    public final void m18474a(InputStream inputStream, OutputStream outputStream, int i) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        Preconditions.checkArgument(f10373a.contains(Integer.valueOf(i)));
        if (i == 0) {
            ByteStreams.a(inputStream, outputStream);
            return;
        }
        try {
            nativeRotateJpeg(inputStream, outputStream, i);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    public final Pair<Bitmap, PointF> m18473a(String str, int i, RectF rectF, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
        PointF pointF = new PointF(Float.MAX_VALUE, Float.MAX_VALUE);
        float[] fArr = new float[2];
        int[] iArr = new int[2];
        try {
            switch (C09981.f10372a[ImageFormatChecker.a(str).ordinal()]) {
                case 1:
                    cropFaceIntoBitmap(str, i, rectF, i2, true, false, createBitmap, fArr, iArr);
                    break;
                default:
                    cropFaceIntoBitmapFromBitmap(m18471b(str), i, rectF, i2, true, false, createBitmap, fArr, iArr);
                    break;
            }
            pointF.set(fArr[0], fArr[1]);
            if (iArr[0] == i2 && iArr[1] == i2) {
                return new Pair(createBitmap, pointF);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, iArr[0], iArr[1]);
            if (createBitmap != createBitmap2) {
                createBitmap.recycle();
            }
            pointF.set((fArr[0] / ((float) iArr[0])) * ((float) i2), (fArr[1] / ((float) iArr[1])) * ((float) i2));
            return new Pair(createBitmap2, pointF);
        } catch (ImageResizingException e) {
            return new Pair(createBitmap, pointF);
        }
    }

    private Bitmap m18471b(String str) {
        Options options = new Options();
        Dimension a = BitmapUtils.a(str);
        int i = a.f10362b;
        int i2 = a.f10361a;
        int i3 = 1;
        while (i > 720 && i2 > 720) {
            i3++;
            i /= i3;
            i2 /= i3;
        }
        options.inSampleSize = i3;
        return FbBitmapFactory.a(str, options);
    }

    public static boolean m18470a(String str) {
        Preconditions.checkNotNull(str);
        return ImageFormatChecker.a(str) == ImageFormat.JPEG;
    }

    public final void m18475a(String str, int i, int i2, int i3, RectF rectF, String str2) {
        Bitmap a;
        Bitmap bitmap;
        Throwable th;
        Throwable e;
        boolean z = true;
        boolean z2 = rectF.left >= 0.0f && rectF.top >= 0.0f && rectF.right >= 0.0f && rectF.bottom >= 0.0f;
        Preconditions.checkState(z2, "All rect bounds must be between 0 and 1.");
        if (rectF.left > 1.0f || rectF.top > 1.0f || rectF.right > 1.0f || rectF.bottom > 1.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkState(z2, "All rect bounds must be between 0 and 1.");
        if (rectF.left >= rectF.right || rectF.top >= rectF.bottom) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkState(z2, "All rect bounds must have left < right and top < bottom");
        if (ImageFormatChecker.a(str) == ImageFormat.JPEG) {
            z = false;
        }
        Preconditions.checkState(z);
        Dimension a2 = BitmapUtils.a(str);
        Rect rect = new Rect((int) (((float) a2.f10362b) * rectF.left), (int) (((float) a2.f10361a) * rectF.top), (int) (((float) a2.f10362b) * rectF.right), (int) (((float) a2.f10361a) * rectF.bottom));
        Bitmap bitmap2 = null;
        try {
            if (VERSION.SDK_INT <= 10 || 480 <= rect.width() || 480 <= rect.height()) {
                Bitmap a3;
                if (i2 == 0 && i == 0) {
                    a3 = this.f10374b.a(str, a2.f10362b, a2.f10361a);
                } else {
                    a3 = this.f10374b.a(str, i, i2);
                }
                a = BitmapUtils.a(a3, rect.left, rect.top, rect.width(), rect.height());
                if (a != null) {
                    BitmapUtils.a(a, CompressFormat.JPEG, 85, new File(str2));
                    if (a != null) {
                        a.recycle();
                        return;
                    }
                    return;
                }
            }
            a = this.f10374b.a(Uri.parse(str), rect, i3, a2.f10362b, a2.f10361a, true);
            if (a != null) {
                try {
                    BitmapUtils.a(a, CompressFormat.JPEG, 85, new File(str2));
                    if (a != null) {
                        a.recycle();
                        return;
                    }
                    return;
                } catch (Throwable e2) {
                    bitmap = a;
                    th = e2;
                    try {
                        ((AbstractFbErrorReporter) this.f10376d.get()).b(getClass().getSimpleName(), "failed to crop photo to file", th);
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                    } catch (Throwable th2) {
                        e2 = th2;
                        bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                        throw e2;
                    }
                } catch (Throwable th3) {
                    e2 = th3;
                    bitmap2 = a;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    throw e2;
                }
            }
            ((AbstractFbErrorReporter) this.f10376d.get()).b(getClass().getSimpleName(), "failed to crop photo to file");
            if (a != null) {
                a.recycle();
            }
        } catch (Throwable e22) {
            th = e22;
            bitmap = null;
            ((AbstractFbErrorReporter) this.f10376d.get()).b(getClass().getSimpleName(), "failed to crop photo to file", th);
            if (bitmap != null) {
                bitmap.recycle();
            }
        } catch (Throwable th4) {
            e22 = th4;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            throw e22;
        }
    }

    public static void m18469a(String str, int i, RectF rectF, String str2) {
        File file = new File(str2);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            m18468a(str, i, rectF, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    private static void m18468a(String str, int i, RectF rectF, OutputStream outputStream) {
        boolean z = true;
        boolean z2 = rectF.left >= 0.0f && rectF.top >= 0.0f && rectF.right >= 0.0f && rectF.bottom >= 0.0f;
        Preconditions.checkState(z2, "All rect bounds must be between 0 and 1.");
        if (rectF.left > 1.0f || rectF.top > 1.0f || rectF.right > 1.0f || rectF.bottom > 1.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkState(z2, "All rect bounds must be between 0 and 1.");
        if (rectF.left >= rectF.right || rectF.top >= rectF.bottom) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkState(z2, "All rect bounds must have left < right and top < bottom");
        if (ImageFormatChecker.a(str) != ImageFormat.JPEG) {
            z = false;
        }
        Preconditions.checkState(z);
        Preconditions.checkNotNull(outputStream);
        try {
            cropJpeg(str, i, rectF, outputStream);
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }
}
