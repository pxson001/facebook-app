package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.support.v4.util.Pools$SynchronizedPool;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: last_update_time */
public final class BitmapUtil {
    private static final Pools$SynchronizedPool<ByteBuffer> f17836a = new Pools$SynchronizedPool(12);

    /* compiled from: last_update_time */
    /* synthetic */ class C07181 {
        static final /* synthetic */ int[] f17837a = new int[Config.values().length];

        static {
            try {
                f17837a[Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17837a[Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17837a[Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17837a[Config.RGB_565.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static int m25068a(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (VERSION.SDK_INT > 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        if (VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getWidth() * bitmap.getRowBytes();
    }

    @Nullable
    public static Pair<Integer, Integer> m25069a(InputStream inputStream) {
        Pair<Integer, Integer> pair = null;
        Preconditions.a(inputStream);
        ByteBuffer byteBuffer = (ByteBuffer) f17836a.mo740a();
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(16384);
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBuffer.array();
            BitmapFactory.decodeStream(inputStream, null, options);
            if (!(options.outWidth == -1 || options.outHeight == -1)) {
                pair = new Pair(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
            }
            f17836a.mo741a(byteBuffer);
            return pair;
        } catch (Throwable th) {
            f17836a.mo741a(byteBuffer);
        }
    }

    public static int m25067a(Config config) {
        switch (C07181.f17837a[config.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 4;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return 1;
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return 2;
            default:
                throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
    }

    public static int m25066a(int i, int i2, Config config) {
        return (i * i2) * m25067a(config);
    }
}
