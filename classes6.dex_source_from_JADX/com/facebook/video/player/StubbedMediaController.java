package com.facebook.video.player;

import android.content.Context;
import android.view.View;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.facebook.video.player.FullScreenVideoPlayer.VideoViewControlHandler;
import java.lang.ref.WeakReference;

/* compiled from: composer_implicit_location_click */
public class StubbedMediaController extends MediaController {
    public WeakReference<VideoViewIntegrationInterface> f19210a;

    public StubbedMediaController(Context context) {
        super(context);
    }

    public boolean isShowing() {
        if (this.f19210a == null || this.f19210a.get() == null) {
            return false;
        }
        return ((VideoViewControlHandler) this.f19210a.get()).m27745a();
    }

    public void show(int i) {
        if (this.f19210a != null && this.f19210a.get() != null) {
            this.f19210a.get();
        }
    }

    public void hide() {
        if (this.f19210a != null && this.f19210a.get() != null) {
            this.f19210a.get();
        }
    }

    public void setAnchorView(View view) {
        if (this.f19210a != null && this.f19210a.get() != null) {
            this.f19210a.get();
        }
    }

    public void setEnabled(boolean z) {
        if (this.f19210a != null && this.f19210a.get() != null) {
            this.f19210a.get();
        }
    }

    public void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        if (this.f19210a != null && this.f19210a.get() != null) {
            this.f19210a.get();
        }
    }
}
