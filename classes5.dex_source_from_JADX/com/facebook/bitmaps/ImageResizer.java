package com.facebook.bitmaps;

import android.graphics.Bitmap;
import com.facebook.proguard.annotations.DoNotStrip;

@Deprecated
/* compiled from: android.widget. */
public interface ImageResizer {

    /* compiled from: android.widget. */
    public enum DownscalePolicy {
        EXACT,
        BEST_EFFORT_BOUND_FROM_BELOW,
        BEST_EFFORT_BOUND_FROM_ABOVE,
        FOR_CENTER_CROP
    }

    @DoNotStrip
    /* compiled from: android.widget. */
    public class ImageResizingException extends Exception {
        private boolean mRetryMightWork;

        public ImageResizingException(String str, boolean z) {
            super(str);
            this.mRetryMightWork = z;
        }

        public ImageResizingException(Throwable th, boolean z) {
            super(th.getClass().getSimpleName() + ", " + th.getMessage(), th);
            this.mRetryMightWork = z;
        }

        public ImageResizingException(String str, Throwable th, boolean z) {
            super(th.getClass().getSimpleName() + ", " + th.getMessage() + ", " + str, th);
            this.mRetryMightWork = z;
        }

        public final boolean m18447a() {
            return this.mRetryMightWork;
        }
    }

    @DoNotStrip
    /* compiled from: android.widget. */
    public class ImageResizingBadParamException extends ImageResizingException {
        @DoNotStrip
        public ImageResizingBadParamException(String str) {
            super(str, false);
        }
    }

    /* compiled from: android.widget. */
    public class ImageResizingDecodeException extends ImageResizingException {
        public ImageResizingDecodeException(String str, Throwable th) {
            super(str, th, false);
        }
    }

    /* compiled from: android.widget. */
    public class ImageResizingIOException extends ImageResizingException {
        public ImageResizingIOException(String str, Throwable th) {
            super(str, th, true);
        }
    }

    /* compiled from: android.widget. */
    public class ImageResizingImageSourceException extends ImageResizingException {
        public ImageResizingImageSourceException(String str, Throwable th) {
            super(str, th, false);
        }
    }

    @DoNotStrip
    /* compiled from: android.widget. */
    public class ImageResizingInputFileException extends ImageResizingException {
        @DoNotStrip
        public ImageResizingInputFileException(String str) {
            super(str, false);
        }

        public ImageResizingInputFileException(String str, boolean z) {
            super(str, z);
        }
    }

    /* compiled from: android.widget. */
    public class ImageResizingOutOfMemoryException extends ImageResizingException {
        public ImageResizingOutOfMemoryException(String str, Throwable th) {
            super(str, th, true);
        }
    }

    @DoNotStrip
    /* compiled from: android.widget. */
    public class ImageResizingOutputFileException extends ImageResizingException {
        public ImageResizingOutputFileException(String str, Throwable th, boolean z) {
            super(str, th, z);
        }
    }

    Bitmap mo1115a(String str, int i, int i2, int i3, boolean z);

    Bitmap mo1116a(String str, BitmapResizingParam bitmapResizingParam);

    ImageScaleParam mo1117a(String str, String str2, int i, int i2, ImageScaleParam imageScaleParam);

    ImageScaleParam mo1118a(String str, String str2, ImageScaleParam imageScaleParam);

    void mo1119a(boolean z);
}
