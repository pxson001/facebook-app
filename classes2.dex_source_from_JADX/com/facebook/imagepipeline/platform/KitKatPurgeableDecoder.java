package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(19)
@ThreadSafe
/* compiled from: page/videolist?page_id={%s}&source={%s} */
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    private final FlexByteArrayPool f10547b;

    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.f10547b = flexByteArrayPool;
    }

    protected final Bitmap m15667a(CloseableReference<PooledByteBuffer> closeableReference, Options options) {
        NativePooledByteBuffer nativePooledByteBuffer = (NativePooledByteBuffer) closeableReference.m15682a();
        int a = nativePooledByteBuffer.m15689a();
        CloseableReference a2 = this.f10547b.m15720a(a);
        try {
            byte[] bArr = (byte[]) a2.m15682a();
            nativePooledByteBuffer.m15690a(0, bArr, 0, a);
            Bitmap bitmap = (Bitmap) Preconditions.a(BitmapFactory.decodeByteArray(bArr, 0, a, options), "BitmapFactory returned null");
            return bitmap;
        } finally {
            CloseableReference.m15681c(a2);
        }
    }

    protected final Bitmap m15666a(CloseableReference<PooledByteBuffer> closeableReference, int i, Options options) {
        boolean z = false;
        byte[] bArr = DalvikPurgeableDecoder.a(closeableReference, i) ? null : DalvikPurgeableDecoder.a;
        NativePooledByteBuffer nativePooledByteBuffer = (NativePooledByteBuffer) closeableReference.m15682a();
        if (i <= nativePooledByteBuffer.m15689a()) {
            z = true;
        }
        Preconditions.a(z);
        CloseableReference a = this.f10547b.m15720a(i + 2);
        try {
            byte[] bArr2 = (byte[]) a.m15682a();
            nativePooledByteBuffer.m15690a(0, bArr2, 0, i);
            if (bArr != null) {
                m15665a(bArr2, i);
                i += 2;
            }
            Bitmap bitmap = (Bitmap) Preconditions.a(BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
            return bitmap;
        } finally {
            CloseableReference.m15681c(a);
        }
    }

    private static void m15665a(byte[] bArr, int i) {
        bArr[i] = (byte) -1;
        bArr[i + 1] = (byte) -39;
    }
}
