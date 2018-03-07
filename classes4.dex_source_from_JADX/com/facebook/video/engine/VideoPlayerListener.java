package com.facebook.video.engine;

import android.graphics.Bitmap;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.VideoPlayer.PlayerState;

/* compiled from: perf_log_threshold_ms */
public interface VideoPlayerListener {
    void mo444a();

    void mo445a(int i);

    void mo446a(int i, int i2);

    void mo447a(Bitmap bitmap);

    void mo448a(EventTriggerType eventTriggerType);

    void mo449a(EventTriggerType eventTriggerType, boolean z);

    void mo450a(PlayerState playerState);

    void mo451a(VideoResolution videoResolution);

    void mo452a(String str);

    void mo453a(String str, VideoError videoError);

    void mo460b();

    void mo461b(int i);

    void mo454b(EventTriggerType eventTriggerType);

    void mo462b(EventTriggerType eventTriggerType, boolean z);

    void mo455b(PlayerState playerState);

    void mo463c();

    void mo456c(EventTriggerType eventTriggerType);

    void mo464c(EventTriggerType eventTriggerType, boolean z);

    void mo465d();

    void mo457e();

    void mo458f();

    void mo459g();
}
