package com.facebook.bitmaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.facebook.bitmaps.ImageResizer.DownscalePolicy;
import com.facebook.bitmaps.ImageResizer.ImageResizingBadParamException;
import com.facebook.bitmaps.ImageResizer.ImageResizingDecodeException;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.ImageResizer.ImageResizingIOException;
import com.facebook.bitmaps.ImageResizer.ImageResizingImageSourceException;
import com.facebook.bitmaps.ImageResizer.ImageResizingInputFileException;
import com.facebook.bitmaps.ImageResizer.ImageResizingOutOfMemoryException;
import com.facebook.bitmaps.ImageResizer.ImageResizingOutputFileException;
import com.facebook.bitmaps.NativeImageProcessor.RotationMode;
import com.facebook.bitmaps.logging.BitmapSequences;
import com.facebook.bitmaps.logging.BitmapSequences.GenerateThumbnailMethod;
import com.facebook.bitmaps.logging.BitmapSequences.ThumbnailMakerSequence;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.io.Files;
import java.io.File;
import javax.inject.Inject;

@Deprecated
/* compiled from: android.support.useSideChannel */
public class NativeImageResizer implements ImageResizer {
    private final Context f10377a;
    private final BitmapUtils f10378b;
    private final NativeImageProcessor f10379c;
    private final JavaImageResizer f10380d;
    private final SequenceLogger f10381e;
    private final ExifThumbnailUtil f10382f;
    private Optional<Sequence<ThumbnailMakerSequence>> f10383g = Absent.INSTANCE;

    public static NativeImageResizer m18479b(InjectorLike injectorLike) {
        return new NativeImageResizer((Context) injectorLike.getInstance(Context.class, ForAppContext.class), BitmapUtils.a(injectorLike), NativeImageProcessor.m18472b(injectorLike), JavaImageResizer.m18460b(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike), ExifThumbnailUtil.m18446a(injectorLike));
    }

    @Inject
    public NativeImageResizer(@ForAppContext Context context, BitmapUtils bitmapUtils, NativeImageProcessor nativeImageProcessor, JavaImageResizer javaImageResizer, SequenceLogger sequenceLogger, ExifThumbnailUtil exifThumbnailUtil) {
        this.f10377a = context;
        this.f10378b = bitmapUtils;
        this.f10379c = nativeImageProcessor;
        this.f10380d = javaImageResizer;
        this.f10381e = sequenceLogger;
        this.f10382f = exifThumbnailUtil;
    }

    public final ImageScaleParam mo1118a(String str, String str2, ImageScaleParam imageScaleParam) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        FbBitmapFactory.a(str, options);
        return mo1117a(str, str2, options.outWidth, options.outHeight, imageScaleParam);
    }

    public final void mo1119a(boolean z) {
        this.f10378b.a = z;
        this.f10380d.mo1119a(z);
    }

    public final ImageScaleParam mo1117a(String str, String str2, int i, int i2, ImageScaleParam imageScaleParam) {
        Throwable e;
        if (!new File(str).exists()) {
            throw new ImageResizingInputFileException("N/missing file: " + str, false);
        } else if (i <= 0 || i2 <= 0 || imageScaleParam.m18456a() <= 0 || imageScaleParam.m18457b() <= 0 || imageScaleParam.m18458c() <= 0 || imageScaleParam.m18458c() > 100) {
            throw new ImageResizingBadParamException("N/input dims: [" + i + "x" + i2 + "], target dims: [" + imageScaleParam.m18456a() + "x" + imageScaleParam.m18457b() + "], q: " + imageScaleParam.m18458c() + ", path: " + str);
        } else {
            String str3 = "N/scaleImageAndWriteToFile";
            File file = new File(str2);
            try {
                ImageFormat a = ImageFormatChecker.a(str);
                if (a != ImageFormat.JPEG) {
                    String str4 = "J/scaleJpegFile";
                    try {
                        this.f10378b.a(this.f10377a, new File(str), file, imageScaleParam.f10365a, imageScaleParam.f10366b, imageScaleParam.f10367c);
                        str3 = str4;
                    } catch (BitmapIOException e2) {
                        e = e2;
                        str3 = str4;
                        try {
                            throw new ImageResizingIOException(str3, e);
                        } catch (Throwable th) {
                            if (file != null && file.exists()) {
                                file.delete();
                            }
                        }
                    } catch (BitmapException e3) {
                        e = e3;
                        str3 = str4;
                        throw new ImageResizingException(str3 + " " + str, e, false);
                    }
                }
                str3 = "N/transcodeJpeg";
                try {
                    Files.a(this.f10379c.m18477a(str, 0, imageScaleParam.f10365a, imageScaleParam.f10366b, imageScaleParam.f10368d ? DownscalePolicy.EXACT : DownscalePolicy.BEST_EFFORT_BOUND_FROM_BELOW, RotationMode.NO_ROTATION, imageScaleParam.f10367c), file);
                } catch (Throwable e4) {
                    throw new ImageResizingOutputFileException("N/writing " + str2, e4, false);
                } catch (Throwable e42) {
                    throw new ImageResizingOutputFileException("N/writing " + str2, e42, true);
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                FbBitmapFactory.a(str2, options);
                if (a == ImageFormat.JPEG) {
                    this.f10378b.a(str, str2);
                }
                return new ImageScaleParam(options.outWidth, options.outHeight, imageScaleParam.f10367c);
            } catch (BitmapIOException e5) {
                e42 = e5;
                throw new ImageResizingIOException(str3, e42);
            } catch (BitmapException e6) {
                e42 = e6;
                throw new ImageResizingException(str3 + " " + str, e42, false);
            }
        }
    }

    public final Bitmap mo1115a(String str, int i, int i2, int i3, boolean z) {
        if (ImageFormatChecker.a(str) != ImageFormat.JPEG) {
            try {
                return this.f10378b.a(this.f10377a, Uri.fromFile(new File(str)), i2, i3, z);
            } catch (Throwable e) {
                throw new ImageResizingIOException("N/scaleImage", e);
            } catch (Throwable e2) {
                throw new ImageResizingOutOfMemoryException("N/scaleImage " + str, e2);
            } catch (Throwable e22) {
                throw new ImageResizingDecodeException("N/scaleImage " + str, e22);
            } catch (Throwable e222) {
                throw new ImageResizingImageSourceException("N/scaleImage " + str, e222);
            }
        }
        byte[] a = this.f10379c.m18477a(str, i, i2, i3, DownscalePolicy.BEST_EFFORT_BOUND_FROM_BELOW, z ? RotationMode.ROTATE_TO_0 : RotationMode.NO_ROTATION, 85);
        return FbBitmapFactory.a(a, 0, a.length);
    }

    public final Bitmap mo1116a(String str, BitmapResizingParam bitmapResizingParam) {
        this.f10383g = Optional.fromNullable(this.f10381e.b(BitmapSequences.f10403a, str));
        if (this.f10383g.isPresent()) {
            SequenceLoggerDetour.a((Sequence) this.f10383g.get(), "GetThumbnail", -249437053);
        }
        Bitmap a;
        if (ImageFormatChecker.a(str) == ImageFormat.JPEG) {
            if (bitmapResizingParam.f10358d) {
                a = ExifThumbnailUtil.m18444a(str, bitmapResizingParam, this.f10379c);
                if (a != null) {
                    m18478a(GenerateThumbnailMethod.EXIF);
                    return a;
                }
            }
            byte[] a2 = this.f10379c.m18477a(str, bitmapResizingParam.f10355a, bitmapResizingParam.f10356b, bitmapResizingParam.f10357c, DownscalePolicy.FOR_CENTER_CROP, RotationMode.ROTATE_TO_0, 85);
            a = FbBitmapFactory.a(a2, 0, a2.length);
            m18478a(GenerateThumbnailMethod.NATIVE_RESIZER);
            return a;
        }
        a = this.f10380d.mo1116a(str, bitmapResizingParam);
        m18478a(GenerateThumbnailMethod.JAVA_RESIZER);
        return a;
    }

    private void m18478a(GenerateThumbnailMethod generateThumbnailMethod) {
        if (this.f10383g.isPresent()) {
            SequenceLoggerDetour.b((Sequence) this.f10383g.get(), "GetThumbnail", null, ImmutableBiMap.b("GenerateThumbnailMethod", generateThumbnailMethod.toString()), -1149964410);
        }
    }
}
