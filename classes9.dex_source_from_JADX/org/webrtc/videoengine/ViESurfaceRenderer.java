package org.webrtc.videoengine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Process;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.facebook.proguard.annotations.DoNotStrip;
import java.nio.ByteBuffer;

@DoNotStrip
/* compiled from: age_max */
public class ViESurfaceRenderer implements Callback {
    public Bitmap f21117a = null;
    private ByteBuffer f21118b = null;
    public SurfaceHolder f21119c;
    public Rect f21120d = new Rect();
    public Rect f21121e = new Rect();
    private Rect f21122f = new Rect();
    private float f21123g = 0.0f;
    private float f21124h = 1.0f;
    private float f21125i = 0.0f;
    private float f21126j = 1.0f;
    public boolean f21127k;

    @DoNotStrip
    public ViESurfaceRenderer(SurfaceView surfaceView) {
        this.f21119c = surfaceView.getHolder();
        if (this.f21119c != null) {
            this.f21119c.addCallback(this);
            this.f21122f = this.f21119c.getSurfaceFrame();
        }
    }

    private void m21567a(int i, int i2) {
        this.f21122f.right = this.f21122f.left + i;
        this.f21122f.bottom = this.f21122f.top + i2;
        this.f21121e.right = (int) (((float) this.f21121e.left) + (this.f21126j * ((float) i)));
        this.f21121e.bottom = (int) (((float) this.f21121e.top) + (this.f21124h * ((float) i2)));
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.d("WEBRTC", "ViESurfaceRender::surfaceChanged");
        m21567a(i2, i3);
        Log.d("WEBRTC", "ViESurfaceRender::surfaceChanged in_width:" + i2 + " in_height:" + i3 + " srcRect.left:" + this.f21120d.left + " srcRect.top:" + this.f21120d.top + " srcRect.right:" + this.f21120d.right + " srcRect.bottom:" + this.f21120d.bottom + " dstRect.left:" + this.f21121e.left + " dstRect.top:" + this.f21121e.top + " dstRect.right:" + this.f21121e.right + " dstRect.bottom:" + this.f21121e.bottom);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas lockCanvas = this.f21119c.lockCanvas();
        if (lockCanvas != null) {
            Rect surfaceFrame = this.f21119c.getSurfaceFrame();
            if (surfaceFrame != null) {
                m21567a(surfaceFrame.right - surfaceFrame.left, surfaceFrame.bottom - surfaceFrame.top);
                Log.d("WEBRTC", "ViESurfaceRender::surfaceCreated dst.left:" + surfaceFrame.left + " dst.top:" + surfaceFrame.top + " dst.right:" + surfaceFrame.right + " dst.bottom:" + surfaceFrame.bottom + " srcRect.left:" + this.f21120d.left + " srcRect.top:" + this.f21120d.top + " srcRect.right:" + this.f21120d.right + " srcRect.bottom:" + this.f21120d.bottom + " dstRect.left:" + this.f21121e.left + " dstRect.top:" + this.f21121e.top + " dstRect.right:" + this.f21121e.right + " dstRect.bottom:" + this.f21121e.bottom);
            }
            this.f21127k = true;
            this.f21119c.unlockCanvasAndPost(lockCanvas);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.d("WEBRTC", "ViESurfaceRenderer::surfaceDestroyed");
        this.f21117a = null;
        this.f21118b = null;
        this.f21127k = false;
    }

    private Bitmap m21568b(int i, int i2) {
        Log.d("WEBRTC", "CreateByteBitmap " + i + ":" + i2);
        if (this.f21117a == null) {
            try {
                Process.setThreadPriority(-4);
            } catch (Exception e) {
            }
        }
        this.f21117a = Bitmap.createBitmap(i, i2, Config.RGB_565);
        this.f21120d.left = 0;
        this.f21120d.top = 0;
        this.f21120d.bottom = i2;
        this.f21120d.right = i;
        return this.f21117a;
    }

    @DoNotStrip
    public ByteBuffer CreateByteBuffer(int i, int i2) {
        Log.d("WEBRTC", "CreateByteBuffer " + i + ":" + i2);
        this.f21117a = m21568b(i, i2);
        this.f21118b = ByteBuffer.allocateDirect((i * i2) * 2);
        return this.f21118b;
    }

    @DoNotStrip
    public void SetCoordinates(float f, float f2, float f3, float f4) {
        Log.d("WEBRTC", "SetCoordinates " + f + "," + f2 + ":" + f3 + "," + f4);
        this.f21125i = f;
        this.f21123g = f2;
        this.f21126j = f3;
        this.f21124h = f4;
        this.f21121e.right = (int) (((float) this.f21121e.left) + (this.f21126j * ((float) this.f21122f.height())));
        this.f21121e.bottom = (int) (((float) this.f21121e.top) + (this.f21124h * ((float) this.f21122f.width())));
    }

    @DoNotStrip
    public void DrawByteBuffer() {
        if (this.f21118b != null) {
            this.f21118b.rewind();
            this.f21117a.copyPixelsFromBuffer(this.f21118b);
            if (this.f21117a != null && this.f21127k) {
                Canvas lockCanvas = this.f21119c.lockCanvas();
                if (lockCanvas != null && this.f21127k) {
                    lockCanvas.drawBitmap(this.f21117a, this.f21120d, this.f21121e, null);
                    this.f21119c.unlockCanvasAndPost(lockCanvas);
                }
            }
        }
    }
}
