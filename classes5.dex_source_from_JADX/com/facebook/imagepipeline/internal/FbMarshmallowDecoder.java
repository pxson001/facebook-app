package com.facebook.imagepipeline.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imageutils.BitmapUtil;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(23)
@ThreadSafe
/* compiled from: TR; */
public class FbMarshmallowDecoder extends ArtDecoder {
    private static Method f13713d;
    private final BitmapPool f13714b;
    private final SynchronizedPool<ByteBuffer> f13715c;

    public FbMarshmallowDecoder(BitmapPool bitmapPool, int i, SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
        this.f13714b = bitmapPool;
        this.f13715c = synchronizedPool;
    }

    public final CloseableReference<Bitmap> mo1274a(InputStream inputStream, Options options) {
        ByteBuffer allocate;
        Preconditions.a(inputStream);
        Bitmap bitmap = (Bitmap) this.f13714b.a(BitmapUtil.a(options.outWidth, options.outHeight, options.inPreferredConfig));
        if (bitmap == null) {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmap;
        ByteBuffer byteBuffer = (ByteBuffer) this.f13715c.a();
        if (byteBuffer == null) {
            allocate = ByteBuffer.allocate(16384);
        } else {
            allocate = byteBuffer;
        }
        try {
            options.inTempStorage = allocate.array();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            this.f13715c.a(allocate);
            if (bitmap != decodeStream) {
                this.f13714b.a(bitmap);
                decodeStream.recycle();
                throw new IllegalStateException();
            }
            bitmap = m23051a(decodeStream);
            this.f13714b.a(decodeStream);
            return CloseableReference.a(bitmap, this.f13714b);
        } catch (RuntimeException e) {
            this.f13714b.a(bitmap);
            throw e;
        } catch (Throwable th) {
            this.f13715c.a(allocate);
        }
    }

    private static synchronized Method m23052a() {
        Method declaredMethod;
        synchronized (FbMarshmallowDecoder.class) {
            if (f13713d == null) {
                try {
                    declaredMethod = Bitmap.class.getDeclaredMethod("createAshmemBitmap", new Class[0]);
                    f13713d = declaredMethod;
                } catch (Throwable e) {
                    throw Throwables.b(e);
                }
            }
            declaredMethod = f13713d;
        }
        return declaredMethod;
    }

    private static Bitmap m23051a(Bitmap bitmap) {
        try {
            return (Bitmap) m23052a().invoke(bitmap, new Object[0]);
        } catch (Throwable e) {
            throw Throwables.b(e);
        }
    }
}
