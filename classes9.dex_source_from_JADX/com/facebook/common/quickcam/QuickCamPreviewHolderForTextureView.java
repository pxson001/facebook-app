package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewStub;
import com.facebook.common.quickcam.QuickCamViewportController.C06371;

@TargetApi(14)
/* compiled from: promotion_message_block_off */
public class QuickCamPreviewHolderForTextureView implements QuickCamPreviewHolder {
    private TextureView f6082a;
    public SurfaceTexture f6083b;
    public C06371 f6084c;

    /* compiled from: promotion_message_block_off */
    class CameraTextureViewListener implements SurfaceTextureListener {
        final /* synthetic */ QuickCamPreviewHolderForTextureView f6081a;

        public CameraTextureViewListener(QuickCamPreviewHolderForTextureView quickCamPreviewHolderForTextureView) {
            this.f6081a = quickCamPreviewHolderForTextureView;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f6081a.f6083b = surfaceTexture;
            if (this.f6081a.f6084c != null) {
                this.f6081a.f6084c.m6459a();
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f6081a.f6083b = null;
            if (this.f6081a.f6084c != null) {
                this.f6081a.f6084c.m6460b();
            }
            return true;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public final void mo236a(ViewStub viewStub) {
        viewStub.setLayoutResource(2130906560);
        this.f6082a = (TextureView) viewStub.inflate();
        this.f6082a.setSurfaceTextureListener(new CameraTextureViewListener(this));
    }

    public final void mo234a(Camera camera) {
        camera.setPreviewTexture(this.f6083b);
    }

    public final void mo235a(MediaRecorder mediaRecorder) {
    }

    public final void mo237a(C06371 c06371) {
        this.f6084c = c06371;
    }

    public final View mo239b() {
        return this.f6082a;
    }

    public final boolean mo240c() {
        return this.f6083b != null;
    }

    public final void mo241d() {
    }

    public final boolean mo238a() {
        return true;
    }

    public final void mo233a(Bitmap bitmap) {
        this.f6082a.getBitmap(bitmap);
    }
}
