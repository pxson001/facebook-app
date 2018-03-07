package com.facebook.videocodec.render;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.facebook.gl.GLHelpers;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.facebook.videocodec.effects.GLRenderer;
import com.google.common.base.Preconditions;

@TargetApi(16)
/* compiled from: results_from_cache */
public class TranscodeOutputSurfaceFrameHandler implements OnFrameAvailableListener {
    private static final Class<TranscodeOutputSurfaceFrameHandler> f5616a = TranscodeOutputSurfaceFrameHandler.class;
    private final SurfaceTexture f5617b;
    private final TranscodeTextureRenderer f5618c;
    private final int f5619d;
    private final Object f5620e = new Object();
    private boolean f5621f;

    public TranscodeOutputSurfaceFrameHandler(SurfaceTexture surfaceTexture, TranscodeTextureRenderer transcodeTextureRenderer, int i) {
        this.f5617b = surfaceTexture;
        this.f5618c = transcodeTextureRenderer;
        this.f5619d = i;
    }

    public final void m8259a() {
        long nanoTime = System.nanoTime();
        long j = (((long) this.f5619d) * 1000000) + nanoTime;
        synchronized (this.f5620e) {
            while (!this.f5621f && r0 < j) {
                try {
                    ObjectDetour.a(this.f5620e, (long) this.f5619d, -943809864);
                    nanoTime = System.nanoTime();
                } catch (Throwable e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            if (this.f5621f) {
                this.f5621f = false;
            } else {
                throw new RuntimeException("Surface frame wait timed out");
            }
        }
        GLHelpers.a("before updateTexImage");
        this.f5617b.updateTexImage();
    }

    public final void m8260b() {
        TranscodeTextureRenderer transcodeTextureRenderer = this.f5618c;
        SurfaceTexture surfaceTexture = this.f5617b;
        if (transcodeTextureRenderer.f5630i != null) {
            Preconditions.checkNotNull(transcodeTextureRenderer.f5631j);
            for (GLRenderer a : transcodeTextureRenderer.f5630i) {
                a.mo367a(surfaceTexture, transcodeTextureRenderer.f5631j, transcodeTextureRenderer.f5627f, transcodeTextureRenderer.f5628g);
            }
            return;
        }
        GLHelpers.a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(transcodeTextureRenderer.f5626e);
        GLES20.glClear(16640);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, transcodeTextureRenderer.f5629h);
        transcodeTextureRenderer.f5624c.a().a("uSTMatrix", transcodeTextureRenderer.f5626e).a("uConstMatrix", transcodeTextureRenderer.f5627f).a(transcodeTextureRenderer.f5623b);
        GLES20.glFinish();
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f5620e) {
            if (this.f5621f) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.f5621f = true;
            ObjectDetour.c(this.f5620e, 1842193434);
        }
    }
}
