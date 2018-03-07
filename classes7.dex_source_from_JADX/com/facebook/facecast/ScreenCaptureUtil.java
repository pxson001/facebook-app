package com.facebook.facecast;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: broadcast_transition_to */
public class ScreenCaptureUtil {
    public static final String f18136a = ScreenCaptureUtil.class.getSimpleName();
    public static final CompressFormat f18137b = CompressFormat.JPEG;
    private final ExecutorService f18138c;

    static /* synthetic */ Bitmap m21942a(Bitmap bitmap, float[] fArr, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.setRotate(180.0f, (float) (i / 2), (float) (i2 / 2));
        return Bitmap.createBitmap(bitmap, 0, 0, i, i2, matrix, false);
    }

    @Inject
    public ScreenCaptureUtil(ExecutorService executorService) {
        this.f18138c = executorService;
    }

    public final synchronized void m21944a(String str, ByteBuffer byteBuffer, float[] fArr, int i, int i2) {
        byteBuffer.rewind();
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, byteBuffer);
        final Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        byteBuffer.rewind();
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        final String str2 = str;
        final float[] fArr2 = fArr;
        final int i3 = i;
        final int i4 = i2;
        ExecutorDetour.a(this.f18138c, new Runnable(this) {
            final /* synthetic */ ScreenCaptureUtil f18135f;

            public void run() {
                BufferedOutputStream bufferedOutputStream;
                Throwable e;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2)));
                    try {
                        Bitmap a = ScreenCaptureUtil.m21942a(createBitmap, fArr2, i3, i4);
                        a.compress(ScreenCaptureUtil.f18137b, 90, bufferedOutputStream);
                        createBitmap.recycle();
                        a.recycle();
                        ScreenCaptureUtil.m21943b(bufferedOutputStream);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            BLog.b(ScreenCaptureUtil.f18136a, "error while saving to bitmap", e);
                            ScreenCaptureUtil.m21943b(bufferedOutputStream);
                        } catch (Throwable th) {
                            e = th;
                            ScreenCaptureUtil.m21943b(bufferedOutputStream);
                            throw e;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream = null;
                    BLog.b(ScreenCaptureUtil.f18136a, "error while saving to bitmap", e);
                    ScreenCaptureUtil.m21943b(bufferedOutputStream);
                } catch (Throwable th2) {
                    e = th2;
                    bufferedOutputStream = null;
                    ScreenCaptureUtil.m21943b(bufferedOutputStream);
                    throw e;
                }
            }
        }, -788102131);
    }

    public static void m21943b(BufferedOutputStream bufferedOutputStream) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (Throwable e) {
                BLog.b(f18136a, "error while closing BufferedOutputStream.", e);
            }
        }
    }
}
