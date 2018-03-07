package com.facebook.video.engine;

import android.graphics.Bitmap;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;

@VisibleForTesting
/* compiled from: percentile_99 */
public class VideoPlayerManager$VideoManagerPlayerListener implements VideoPlayerListener {
    private final WeakReference<VideoPlayerListener> f5148a;
    private final WeakReference<VideoPlayerManager> f5149b;
    public WeakReference<VideoPlayerManager$VideoManagerPlayer> f5150c = new WeakReference(this);

    protected VideoPlayerManager$VideoManagerPlayerListener(VideoPlayerManager videoPlayerManager, VideoPlayerListener videoPlayerListener) {
        this.f5149b = new WeakReference(videoPlayerManager);
        this.f5148a = new WeakReference(videoPlayerListener);
    }

    public final void mo444a() {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo444a();
        }
    }

    public final void mo445a(int i) {
        if (this.f5148a.get() != null) {
            VideoPlayerManager.j((VideoPlayerManager) this.f5149b.get(), (VideoPlayerManager$VideoManagerPlayer) this.f5150c.get());
            ((VideoPlayerListener) this.f5148a.get()).mo445a(i);
        }
    }

    public final void mo448a(EventTriggerType eventTriggerType) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo448a(eventTriggerType);
        }
    }

    public final void mo454b(EventTriggerType eventTriggerType) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo454b(eventTriggerType);
        }
    }

    public final void mo456c(EventTriggerType eventTriggerType) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo456c(eventTriggerType);
        }
    }

    public final void mo461b(int i) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo461b(i);
        }
    }

    public final void mo446a(int i, int i2) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo446a(i, i2);
        }
    }

    public final void mo460b() {
        ((VideoPlayerManager) this.f5149b.get()).b((VideoPlayerManager$VideoManagerPlayer) this.f5150c.get());
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo460b();
        }
    }

    public final void mo463c() {
        VideoPlayerManager videoPlayerManager = (VideoPlayerManager) this.f5149b.get();
        VideoPlayerManager$VideoManagerPlayer videoPlayerManager$VideoManagerPlayer = (VideoPlayerManager$VideoManagerPlayer) this.f5150c.get();
        Object obj = null;
        int i = videoPlayerManager$VideoManagerPlayer.f5295c;
        for (int i2 = 0; i2 < videoPlayerManager.c.size(); i2++) {
            VideoPlayerManager$VideoManagerPlayer videoPlayerManager$VideoManagerPlayer2 = (VideoPlayerManager$VideoManagerPlayer) ((WeakReference) videoPlayerManager.c.get(i2)).get();
            if (videoPlayerManager$VideoManagerPlayer2 != null && videoPlayerManager$VideoManagerPlayer2.f5295c == i) {
                obj = 1;
                break;
            }
        }
        if (obj == null) {
            VideoPlayerDefaultLimitsProvider videoPlayerDefaultLimitsProvider = videoPlayerManager.i;
            long j = 5;
            VideoEngineUtils.a(videoPlayerManager.c);
            if (((long) videoPlayerManager.c.size()) >= j) {
                VideoPlayerManager$VideoManagerPlayer videoPlayerManager$VideoManagerPlayer3 = (VideoPlayerManager$VideoManagerPlayer) ((WeakReference) videoPlayerManager.c.get(0)).get();
                videoPlayerManager.c.remove(0);
                if (videoPlayerManager$VideoManagerPlayer3 != null) {
                    videoPlayerManager$VideoManagerPlayer3.mo510n();
                    new Object[1][0] = Integer.valueOf(videoPlayerManager$VideoManagerPlayer3.f5295c);
                }
            }
            videoPlayerManager.c.add(new WeakReference(videoPlayerManager$VideoManagerPlayer));
            new Object[1][0] = Integer.valueOf(videoPlayerManager$VideoManagerPlayer.f5295c);
        }
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo463c();
        }
    }

    public final void mo447a(Bitmap bitmap) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo447a(bitmap);
        }
    }

    public final void mo465d() {
        VideoPlayerListener videoPlayerListener = (VideoPlayerListener) this.f5148a.get();
        if (videoPlayerListener != null) {
            videoPlayerListener.mo465d();
        }
    }

    public final void mo449a(EventTriggerType eventTriggerType, boolean z) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo449a(eventTriggerType, z);
        }
    }

    public final void mo462b(EventTriggerType eventTriggerType, boolean z) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo462b(eventTriggerType, z);
        }
    }

    public final void mo464c(EventTriggerType eventTriggerType, boolean z) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo464c(eventTriggerType, z);
        }
    }

    public final void mo450a(PlayerState playerState) {
        if (this.f5148a != null && this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo450a(playerState);
        }
    }

    public final void mo455b(PlayerState playerState) {
        if (this.f5148a != null && this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo455b(playerState);
        }
    }

    public final void mo453a(String str, VideoError videoError) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo453a(str, videoError);
        }
    }

    public final void mo452a(String str) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo452a(str);
        }
    }

    public final void mo457e() {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo457e();
        }
    }

    public final void mo458f() {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo458f();
        }
    }

    public final void mo451a(VideoResolution videoResolution) {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo451a(videoResolution);
        }
    }

    public final void mo459g() {
        if (this.f5148a.get() != null) {
            ((VideoPlayerListener) this.f5148a.get()).mo459g();
        }
    }
}
