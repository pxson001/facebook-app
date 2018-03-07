package com.facebook.ui.images.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.images.base.BitmapReader;
import com.facebook.ui.images.base.ByteArrayBitmapReader;
import com.facebook.ui.images.base.FileBitmapReader;
import com.facebook.ui.images.cache.ImageCacheKey.Options.DownscalingMethod;
import com.facebook.ui.media.attachments.MediaResourceScheme;
import com.facebook.ui.media.attachments.MediaResourceUtil;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
/* compiled from: entity_cards */
public class ImageDecoder {
    private static volatile ImageDecoder f12899c;
    private final Context f12900a;
    private final MediaResourceUtil f12901b;

    /* compiled from: entity_cards */
    public enum ImageOrientationProcessing {
        NO_ORIENTATION,
        APPLY_ORIENTATION
    }

    public static com.facebook.ui.images.decoder.ImageDecoder m13772a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12899c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.decoder.ImageDecoder.class;
        monitor-enter(r1);
        r0 = f12899c;	 Catch:{ all -> 0x003a }
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
        r0 = m13773b(r0);	 Catch:{ all -> 0x0035 }
        f12899c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12899c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.decoder.ImageDecoder.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.decoder.ImageDecoder");
    }

    private static ImageDecoder m13773b(InjectorLike injectorLike) {
        return new ImageDecoder((Context) injectorLike.getInstance(Context.class), MediaResourceUtil.m13776a(injectorLike));
    }

    @Inject
    public ImageDecoder(Context context, MediaResourceUtil mediaResourceUtil) {
        this.f12900a = context;
        this.f12901b = mediaResourceUtil;
    }

    @Nullable
    public final Bitmap m13774a(Uri uri, int i, int i2, DownscalingMethod downscalingMethod, ImageOrientationProcessing imageOrientationProcessing) {
        return m13775a(m13771a(uri), i, i2, downscalingMethod, imageOrientationProcessing);
    }

    public final Bitmap m13775a(BitmapReader bitmapReader, int i, int i2, DownscalingMethod downscalingMethod, ImageOrientationProcessing imageOrientationProcessing) {
        int i3;
        if (i == -1 && i2 == -1) {
            i3 = 1;
        } else {
            Options a = bitmapReader.mo939a();
            i3 = m13769a(i, i2, a.outWidth, a.outHeight, downscalingMethod);
        }
        Options options = new Options();
        options.inSampleSize = i3;
        options.inInputShareable = true;
        Bitmap a2 = bitmapReader.mo938a(options);
        if (a2 == null) {
            return null;
        }
        if (imageOrientationProcessing == ImageOrientationProcessing.APPLY_ORIENTATION) {
            return m13770a(a2, bitmapReader.mo940b());
        }
        return a2;
    }

    private static Bitmap m13770a(Bitmap bitmap, int i) {
        if (i == 0 || i == 1) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        if (i == 2) {
            matrix.postScale(1.0f, -1.0f);
            i = 1;
        } else if (i == 4) {
            matrix.postScale(1.0f, -1.0f);
            i = 3;
        } else if (i == 7) {
            matrix.postScale(1.0f, -1.0f);
            i = 6;
        } else if (i == 5) {
            matrix.postScale(1.0f, -1.0f);
            i = 8;
        }
        if (i == 3) {
            matrix.postRotate(180.0f);
        } else if (i == 6) {
            matrix.postRotate(90.0f);
        } else if (i == 8) {
            matrix.postRotate(270.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private int m13769a(int i, int i2, int i3, int i4, DownscalingMethod downscalingMethod) {
        int i5;
        if (i2 == -2) {
            i2 = this.f12900a.getResources().getDisplayMetrics().heightPixels;
        } else if (i2 == -1) {
            i2 = i4;
        }
        if (i == -2) {
            i = this.f12900a.getResources().getDisplayMetrics().widthPixels;
        } else if (i == -1) {
            i = i3;
        }
        switch (downscalingMethod) {
            case MemoryUsagePowerOfTwo:
                int i6 = (i4 * i3) * 4;
                i5 = 1;
                while (i6 > (((i2 * 17) * i) * 4) / 10) {
                    i6 /= 4;
                    i5 *= 2;
                }
                break;
            case MaxScaleNonPowerOfTwo:
                i5 = (int) Math.max(Math.floor(((double) i3) / ((double) i)), Math.floor(((double) i4) / ((double) i2)));
                break;
            case MinScaleNonPowerOfTwo:
                i5 = (int) Math.min(Math.floor(((double) i3) / ((double) i)), Math.floor(((double) i4) / ((double) i2)));
                break;
            default:
                i5 = 1;
                break;
        }
        i5 = Math.max(i5, 1);
        while (Math.max(i3, i4) / i5 > 4096) {
            i5 *= 2;
        }
        return i5;
    }

    private BitmapReader m13771a(Uri uri) {
        switch (MediaResourceScheme.from(uri)) {
            case FILE:
                return new FileBitmapReader(new File(uri.getPath()));
            case CONTENT:
                return new ByteArrayBitmapReader(this.f12901b.m13781a(uri));
            default:
                throw new IllegalArgumentException("Unsupported scheme");
        }
    }
}
