package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
/* compiled from: TRACKER */
public class ArtDecoder implements PlatformDecoder {
    private static final byte[] f13710c = new byte[]{(byte) -1, (byte) -39};
    @VisibleForTesting
    final SynchronizedPool<ByteBuffer> f13711a;
    private final BitmapPool f13712b;

    public ArtDecoder(BitmapPool bitmapPool, int i, SynchronizedPool synchronizedPool) {
        this.f13712b = bitmapPool;
        this.f13711a = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.f13711a.a(ByteBuffer.allocate(16384));
        }
    }

    public final CloseableReference<Bitmap> m23048a(EncodedImage encodedImage, Config config) {
        Options b = m23047b(encodedImage, config);
        Object obj = b.inPreferredConfig != Config.ARGB_8888 ? 1 : null;
        try {
            return mo1274a(encodedImage.b(), b);
        } catch (RuntimeException e) {
            if (obj != null) {
                return m23048a(encodedImage, Config.ARGB_8888);
            }
            throw e;
        }
    }

    public final CloseableReference<Bitmap> m23049a(EncodedImage encodedImage, Config config, int i) {
        InputStream limitedInputStream;
        boolean e = encodedImage.e(i);
        Options b = m23047b(encodedImage, config);
        InputStream b2 = encodedImage.b();
        Preconditions.a(b2);
        if (encodedImage.h() > i) {
            limitedInputStream = new LimitedInputStream(b2, i);
        } else {
            limitedInputStream = b2;
        }
        if (e) {
            b2 = limitedInputStream;
        } else {
            b2 = new TailAppendingInputStream(limitedInputStream, f13710c);
        }
        Object obj = b.inPreferredConfig != Config.ARGB_8888 ? 1 : null;
        try {
            return mo1274a(b2, b);
        } catch (RuntimeException e2) {
            if (obj != null) {
                return m23048a(encodedImage, Config.ARGB_8888);
            }
            throw e2;
        }
    }

    protected CloseableReference<Bitmap> mo1274a(InputStream inputStream, Options options) {
        ByteBuffer allocate;
        Preconditions.a(inputStream);
        Bitmap bitmap = (Bitmap) this.f13712b.a(BitmapUtil.a(options.outWidth, options.outHeight, options.inPreferredConfig));
        if (bitmap == null) {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmap;
        ByteBuffer byteBuffer = (ByteBuffer) this.f13711a.a();
        if (byteBuffer == null) {
            allocate = ByteBuffer.allocate(16384);
        } else {
            allocate = byteBuffer;
        }
        try {
            options.inTempStorage = allocate.array();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            this.f13711a.a(allocate);
            if (bitmap == decodeStream) {
                return CloseableReference.a(decodeStream, this.f13712b);
            }
            this.f13712b.a(bitmap);
            decodeStream.recycle();
            throw new IllegalStateException();
        } catch (RuntimeException e) {
            this.f13712b.a(bitmap);
            throw e;
        } catch (Throwable th) {
            this.f13711a.a(allocate);
        }
    }

    private static Options m23047b(EncodedImage encodedImage, Config config) {
        Options options = new Options();
        options.inSampleSize = encodedImage.g;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.b(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
