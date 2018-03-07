package com.facebook.livephotos.egl;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.view.Surface;

@TargetApi(19)
/* compiled from: partDefinitionProps */
public class GLOffScreenSurface extends GLSurfaceBase implements OnFrameAvailableListener {
    public final SurfaceTexture f6683c;
    public final int f6684d;
    public boolean f6685e;
    public final float[] f6686f = new float[16];

    public GLOffScreenSurface(GLContext gLContext, int i, int i2) {
        super(gLContext);
        int[] iArr = new int[]{-1};
        GLES20.glGenTextures(1, iArr, 0);
        GLContext.m8561a("glGenTextures");
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        this.f6684d = iArr[0];
        this.f6683c = new SurfaceTexture(this.f6684d);
        this.f6683c.setDefaultBufferSize(i, i2);
        this.f6683c.setOnFrameAvailableListener(this);
        this.b = new Surface(this.f6683c);
    }

    public final void mo363b() {
        this.f6682b.release();
        this.f6683c.release();
        this.f6682b.release();
        GLES20.glDeleteTextures(1, new int[]{this.f6684d}, 0);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f6685e = true;
    }
}
