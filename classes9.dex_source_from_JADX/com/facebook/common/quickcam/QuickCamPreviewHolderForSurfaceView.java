package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewStub;
import com.facebook.common.quickcam.QuickCamViewportController.C06371;

@TargetApi(10)
/* compiled from: promotion_message_block_on */
public class QuickCamPreviewHolderForSurfaceView implements QuickCamPreviewHolder {
    private final Resources f6074a;
    private int f6075b = -1;
    private int f6076c = -1;
    private SurfaceView f6077d;
    public SurfaceHolder f6078e;
    public C06371 f6079f;
    private final CameraSurfaceViewListener f6080g = new CameraSurfaceViewListener(this);

    /* compiled from: promotion_message_block_on */
    class CameraSurfaceViewListener implements Callback {
        final /* synthetic */ QuickCamPreviewHolderForSurfaceView f6073a;

        public CameraSurfaceViewListener(QuickCamPreviewHolderForSurfaceView quickCamPreviewHolderForSurfaceView) {
            this.f6073a = quickCamPreviewHolderForSurfaceView;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f6073a.f6078e = surfaceHolder;
            if (this.f6073a.f6079f != null) {
                this.f6073a.f6079f.m6459a();
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f6073a.f6078e = null;
            if (this.f6073a.f6079f != null) {
                this.f6073a.f6079f.m6460b();
            }
        }
    }

    public QuickCamPreviewHolderForSurfaceView(Resources resources) {
        this.f6074a = resources;
    }

    public final void mo236a(ViewStub viewStub) {
        viewStub.setLayoutResource(2130906559);
        this.f6077d = (SurfaceView) viewStub.inflate();
        this.f6077d.getHolder().addCallback(this.f6080g);
        this.f6077d.getHolder().setType(3);
    }

    public final void mo234a(Camera camera) {
        Size previewSize = camera.getParameters().getPreviewSize();
        int i = this.f6074a.getConfiguration().orientation;
        this.f6075b = previewSize.width;
        this.f6076c = previewSize.height;
        camera.setPreviewDisplay(this.f6078e);
    }

    public final void mo235a(MediaRecorder mediaRecorder) {
        mediaRecorder.setPreviewDisplay(this.f6078e.getSurface());
    }

    public final void mo237a(C06371 c06371) {
        this.f6079f = c06371;
    }

    public final View mo239b() {
        return this.f6077d;
    }

    public final boolean mo240c() {
        return this.f6078e != null;
    }

    public final void mo241d() {
        this.f6077d.getHolder().removeCallback(this.f6080g);
    }

    public final boolean mo238a() {
        return false;
    }

    public final void mo233a(Bitmap bitmap) {
        throw new UnsupportedOperationException("QuickCamPreviewHolderForSurfaceView does not support direct bitmap capture");
    }
}
