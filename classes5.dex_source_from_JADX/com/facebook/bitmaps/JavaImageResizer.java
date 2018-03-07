package com.facebook.bitmaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import com.facebook.bitmaps.ImageResizer.ImageResizingDecodeException;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.ImageResizer.ImageResizingIOException;
import com.facebook.bitmaps.ImageResizer.ImageResizingImageSourceException;
import com.facebook.bitmaps.ImageResizer.ImageResizingOutOfMemoryException;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import java.io.File;
import javax.inject.Inject;

@Deprecated
/* compiled from: android.view.HardwareCanvas */
public class JavaImageResizer implements ImageResizer {
    private static final Class<?> f10369a = JavaImageResizer.class;
    private final Context f10370b;
    private final BitmapUtils f10371c;

    public static JavaImageResizer m18460b(InjectorLike injectorLike) {
        return new JavaImageResizer((Context) injectorLike.getInstance(Context.class, ForAppContext.class), BitmapUtils.a(injectorLike));
    }

    @Inject
    public JavaImageResizer(@ForAppContext Context context, BitmapUtils bitmapUtils) {
        this.f10370b = context;
        this.f10371c = bitmapUtils;
    }

    public final void mo1119a(boolean z) {
        this.f10371c.a = z;
    }

    public final ImageScaleParam mo1117a(String str, String str2, int i, int i2, ImageScaleParam imageScaleParam) {
        return mo1118a(str, str2, imageScaleParam);
    }

    public final ImageScaleParam mo1118a(String str, String str2, ImageScaleParam imageScaleParam) {
        try {
            this.f10371c.a(this.f10370b, new File(str), new File(str2), imageScaleParam.f10365a, imageScaleParam.f10366b, imageScaleParam.f10367c);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            FbBitmapFactory.a(str2, options);
            return new ImageScaleParam(options.outWidth, options.outHeight, imageScaleParam.f10367c);
        } catch (Throwable e) {
            throw new ImageResizingException("J/scaleJpegFile " + str, e, false);
        }
    }

    public final Bitmap mo1115a(String str, int i, int i2, int i3, boolean z) {
        try {
            return this.f10371c.a(this.f10370b, Uri.fromFile(new File(str)), i2, i3, z);
        } catch (Throwable e) {
            throw new ImageResizingIOException("J/scaleImage", e);
        } catch (Throwable e2) {
            throw new ImageResizingOutOfMemoryException("J/scaleImage " + str, e2);
        } catch (Throwable e22) {
            throw new ImageResizingDecodeException("J/scaleImage " + str, e22);
        } catch (Throwable e222) {
            throw new ImageResizingImageSourceException("J/scaleImage " + str, e222);
        }
    }

    public final Bitmap mo1116a(String str, BitmapResizingParam bitmapResizingParam) {
        Dimension a = BitmapUtils.a(str);
        float f = ((float) a.f10362b) / ((float) a.f10361a);
        if (bitmapResizingParam.f10355a == 90 || bitmapResizingParam.f10355a == 270) {
            f = ((float) a.f10361a) / ((float) a.f10362b);
        }
        try {
            Bitmap bitmap;
            Object obj = Math.abs(f - (((float) bitmapResizingParam.f10356b) / ((float) bitmapResizingParam.f10357c))) < 0.05f ? 1 : null;
            int max = Math.max(bitmapResizingParam.f10356b, bitmapResizingParam.f10357c);
            Bitmap a2 = obj != null ? this.f10371c.a(this.f10370b, new File(str), max) : m18459a(str, a, max);
            if (a2 == null || bitmapResizingParam.f10355a == 0) {
                bitmap = a2;
            } else {
                bitmap = BitmapUtils.a(a2, bitmapResizingParam.f10355a, true);
                if (bitmap != a2) {
                    a2.recycle();
                }
            }
            if (obj == null) {
                bitmap = ThumbnailUtils.extractThumbnail(bitmap, bitmapResizingParam.f10356b, bitmapResizingParam.f10357c);
            }
            return bitmap;
        } catch (Throwable e) {
            throw new ImageResizingIOException("J/getThumbnail", e);
        } catch (Throwable e2) {
            throw new ImageResizingOutOfMemoryException("J/getThumbnail " + str, e2);
        } catch (Throwable e22) {
            throw new ImageResizingDecodeException("J/getThumbnail " + str, e22);
        } catch (Throwable e222) {
            throw new ImageResizingImageSourceException("J/getThumbnail " + str, e222);
        }
    }

    private static Bitmap m18459a(String str, Dimension dimension, int i) {
        int max = Math.max(dimension.f10362b, dimension.f10361a);
        int i2 = 1;
        while (max > i) {
            i2++;
            max /= i2;
        }
        Options options = new Options();
        options.inSampleSize = i2 + 1;
        return FbBitmapFactory.a(str, options);
    }
}
