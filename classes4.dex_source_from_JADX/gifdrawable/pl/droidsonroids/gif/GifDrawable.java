package gifdrawable.pl.droidsonroids.gif;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.MediaController.MediaPlayerControl;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;

/* compiled from: on_by_default */
public class GifDrawable extends Drawable implements Animatable, MediaPlayerControl {
    private static final Handler f6077b = new Handler(Looper.getMainLooper());
    protected final Paint f6078a = new Paint(6);
    public volatile int f6079c;
    private volatile boolean f6080d = false;
    private final int[] f6081e;
    private float f6082f = 1.0f;
    private float f6083g = 1.0f;
    private boolean f6084h;
    private final Rect f6085i = new Rect();
    public int[] f6086j;
    private final Runnable f6087k = new C02631(this);
    private final Runnable f6088l = new C02642(this);
    private final Runnable f6089m = new C02653(this);
    private final Runnable f6090n = new C02664(this);

    /* compiled from: on_by_default */
    class C02631 implements Runnable {
        final /* synthetic */ GifDrawable f6093a;

        C02631(GifDrawable gifDrawable) {
            this.f6093a = gifDrawable;
        }

        public void run() {
            GifDrawable.reset(this.f6093a.f6079c);
        }
    }

    /* compiled from: on_by_default */
    class C02642 implements Runnable {
        final /* synthetic */ GifDrawable f6094a;

        C02642(GifDrawable gifDrawable) {
            this.f6094a = gifDrawable;
        }

        public void run() {
            GifDrawable.restoreRemainder(this.f6094a.f6079c);
            this.f6094a.invalidateSelf();
        }
    }

    /* compiled from: on_by_default */
    class C02653 implements Runnable {
        final /* synthetic */ GifDrawable f6095a;

        C02653(GifDrawable gifDrawable) {
            this.f6095a = gifDrawable;
        }

        public void run() {
            GifDrawable.saveRemainder(this.f6095a.f6079c);
        }
    }

    /* compiled from: on_by_default */
    class C02664 implements Runnable {
        final /* synthetic */ GifDrawable f6096a;

        C02664(GifDrawable gifDrawable) {
            this.f6096a = gifDrawable;
        }

        public void run() {
            this.f6096a.invalidateSelf();
        }
    }

    private static native void free(int i);

    private static native long getAllocationByteCount(int i);

    private static native String getComment(int i);

    private static native int getCurrentPosition(int i);

    private static native int getDuration(int i);

    private static native int getLoopCount(int i);

    private static native int openByteArray(int[] iArr, byte[] bArr);

    private static native int openDirectByteBuffer(int[] iArr, ByteBuffer byteBuffer);

    private static native int openFd(int[] iArr, FileDescriptor fileDescriptor, long j);

    private static native int openFile(int[] iArr, String str);

    private static native int openStream(int[] iArr, InputStream inputStream);

    private static native void renderFrame(int[] iArr, int i, int[] iArr2);

    private static native boolean reset(int i);

    public static native void restoreRemainder(int i);

    public static native void saveRemainder(int i);

    public static native void seekToFrame(int i, int i2, int[] iArr);

    public static native void seekToTime(int i, int i2, int[] iArr);

    private static native void setSpeedFactor(int i, float f);

    public static void m6536a(DecodedGifData decodedGifData) {
        free(decodedGifData.f6091a);
    }

    private static void m6537a(Runnable runnable) {
        if (Looper.myLooper() == f6077b.getLooper()) {
            runnable.run();
        } else {
            HandlerDetour.a(f6077b, runnable, -1926161357);
        }
    }

    public GifDrawable(DecodedGifData decodedGifData) {
        this.f6081e = decodedGifData.f6092b;
        this.f6079c = decodedGifData.f6091a;
        this.f6086j = new int[(this.f6081e[0] * this.f6081e[1])];
        m6544d(0);
    }

    public static DecodedGifData m6533a(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("Source is null");
        } else if (inputStream.markSupported()) {
            int[] iArr = new int[5];
            return new DecodedGifData(openStream(iArr, inputStream), iArr);
        } else {
            throw new IllegalArgumentException("InputStream does not support marking");
        }
    }

    private void m6534a() {
        this.f6080d = false;
        this.f6079c = 0;
        this.f6086j = null;
    }

    protected void finalize() {
        try {
            m6534a();
        } finally {
            super.finalize();
        }
    }

    public int getIntrinsicHeight() {
        return this.f6081e[1];
    }

    public int getIntrinsicWidth() {
        return this.f6081e[0];
    }

    public void setAlpha(int i) {
        this.f6078a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6078a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    public void start() {
        this.f6080d = true;
        m6537a(this.f6088l);
    }

    public void stop() {
        this.f6080d = false;
        m6537a(this.f6089m);
    }

    public boolean isRunning() {
        return this.f6080d;
    }

    public String toString() {
        return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", new Object[]{Integer.valueOf(this.f6081e[0]), Integer.valueOf(this.f6081e[1]), Integer.valueOf(this.f6081e[2]), Integer.valueOf(this.f6081e[3])});
    }

    private int m6539b() {
        return this.f6081e[2];
    }

    public void pause() {
        stop();
    }

    public int getDuration() {
        return getDuration(this.f6079c);
    }

    public int getCurrentPosition() {
        return getCurrentPosition(this.f6079c);
    }

    public void seekTo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        m6537a(new 5(this, i));
    }

    private void m6544d(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("frameIndex is not positive");
        }
        m6537a(new Runnable(this) {
            final /* synthetic */ GifDrawable f6098b;

            public void run() {
                GifDrawable.seekToFrame(this.f6098b.f6079c, i, this.f6098b.f6086j);
                this.f6098b.invalidateSelf();
            }
        });
    }

    public boolean isPlaying() {
        return this.f6080d;
    }

    public int getBufferPercentage() {
        return 100;
    }

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return false;
    }

    public boolean canSeekForward() {
        return m6539b() > 1;
    }

    public int getAudioSessionId() {
        return 0;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f6084h = true;
    }

    public void draw(Canvas canvas) {
        if (this.f6084h) {
            this.f6085i.set(getBounds());
            this.f6082f = ((float) this.f6085i.width()) / ((float) this.f6081e[0]);
            this.f6083g = ((float) this.f6085i.height()) / ((float) this.f6081e[1]);
            this.f6084h = false;
        }
        if (this.f6078a.getShader() == null) {
            if (this.f6080d) {
                renderFrame(this.f6086j, this.f6079c, this.f6081e);
            } else {
                this.f6081e[4] = -1;
            }
            canvas.scale(this.f6082f, this.f6083g);
            int[] iArr = this.f6086j;
            if (iArr != null) {
                canvas.drawBitmap(iArr, 0, this.f6081e[0], 0.0f, 0.0f, this.f6081e[0], this.f6081e[1], true, this.f6078a);
            }
            if (this.f6081e[4] >= 0 && this.f6081e[2] > 1) {
                HandlerDetour.b(f6077b, this.f6090n, (long) this.f6081e[4], 1400855423);
                return;
            }
            return;
        }
        canvas.drawRect(this.f6085i, this.f6078a);
    }

    public int getAlpha() {
        return this.f6078a.getAlpha();
    }

    public void setFilterBitmap(boolean z) {
        this.f6078a.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f6078a.setDither(z);
        invalidateSelf();
    }

    public int getMinimumHeight() {
        return this.f6081e[1];
    }

    public int getMinimumWidth() {
        return this.f6081e[0];
    }
}
