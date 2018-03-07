package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
/* compiled from: TOUR_GUIDE */
public class BitmapPool extends BasePool<Bitmap> {
    protected final void m23056b(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Preconditions.a(bitmap);
        bitmap.recycle();
    }

    protected final int m23058c(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Preconditions.a(bitmap);
        return bitmap.getAllocationByteCount();
    }

    protected final boolean m23060d(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Preconditions.a(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }

    public BitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        a();
    }

    protected final Object m23055b(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Config.RGB_565);
    }

    protected final int m23057c(int i) {
        return i;
    }

    protected final int m23059d(int i) {
        return i;
    }
}
