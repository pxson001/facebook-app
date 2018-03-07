package com.facebook.friendsharing.souvenirs.ui;

import android.graphics.Rect;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import java.util.ArrayDeque;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: RED */
public class SouvenirVideoAutoplayController {
    public static final String f24187a = SouvenirVideoAutoplayController.class.getSimpleName().substring(0, 22);
    public static final Rect f24188b = new Rect();
    public final ArrayDeque<VideoAutoPlayView> f24189c = new ArrayDeque();
    private final boolean f24190d;
    @Nullable
    public VideoAutoPlayView f24191e;

    /* compiled from: RED */
    class C21041 implements RichVideoPlayerCallbackListener {
        final /* synthetic */ SouvenirVideoAutoplayController f24186a;

        C21041(SouvenirVideoAutoplayController souvenirVideoAutoplayController) {
            this.f24186a = souvenirVideoAutoplayController;
        }

        public final void m26436a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
            if (this.f24186a.f24191e != null) {
                this.f24186a.f24191e.setVideoListener(null);
            }
            SouvenirVideoAutoplayController.m26443c(this.f24186a);
        }

        public final void m26434a() {
        }

        public final void m26435a(RVPErrorEvent rVPErrorEvent) {
        }
    }

    /* compiled from: RED */
    public interface VideoAutoPlayView {
        void mo1602a();

        void m26438a(EventTriggerType eventTriggerType);

        void m26439b(EventTriggerType eventTriggerType);

        boolean getGlobalVisibleRect(Rect rect);

        boolean m26440o();

        void setVideoListener(RichVideoPlayerCallbackListener richVideoPlayerCallbackListener);
    }

    public static SouvenirVideoAutoplayController m26441b(InjectorLike injectorLike) {
        return new SouvenirVideoAutoplayController(VideoAutoPlaySettingsChecker.a(injectorLike));
    }

    @Inject
    public SouvenirVideoAutoplayController(VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker) {
        this.f24190d = videoAutoPlaySettingsChecker.a();
    }

    public static void m26442c(VideoAutoPlayView videoAutoPlayView) {
        videoAutoPlayView.setVideoListener(null);
        videoAutoPlayView.m26439b(EventTriggerType.BY_AUTOPLAY);
    }

    public static void m26443c(SouvenirVideoAutoplayController souvenirVideoAutoplayController) {
        if (!souvenirVideoAutoplayController.f24189c.isEmpty() && souvenirVideoAutoplayController.f24190d) {
            Object obj = (souvenirVideoAutoplayController.f24191e == null || !souvenirVideoAutoplayController.f24191e.getGlobalVisibleRect(f24188b)) ? null : 1;
            if (souvenirVideoAutoplayController.f24191e == null || obj == null || !souvenirVideoAutoplayController.f24191e.m26440o()) {
                VideoAutoPlayView videoAutoPlayView;
                if (souvenirVideoAutoplayController.f24191e != null && obj == null) {
                    m26442c(souvenirVideoAutoplayController.f24191e);
                }
                while (!souvenirVideoAutoplayController.f24189c.isEmpty()) {
                    videoAutoPlayView = (VideoAutoPlayView) souvenirVideoAutoplayController.f24189c.pop();
                    if (!videoAutoPlayView.m26440o() && videoAutoPlayView.getGlobalVisibleRect(f24188b)) {
                        souvenirVideoAutoplayController.f24189c.addLast(videoAutoPlayView);
                        if (videoAutoPlayView != souvenirVideoAutoplayController.f24191e || souvenirVideoAutoplayController.f24189c.size() <= 1) {
                            break;
                        }
                    } else {
                        BLog.b(f24187a, "getNextVideoToPlay: unexpected video view in queue");
                    }
                }
                videoAutoPlayView = null;
                souvenirVideoAutoplayController.f24191e = videoAutoPlayView;
                if (souvenirVideoAutoplayController.f24191e != null) {
                    souvenirVideoAutoplayController.f24191e.setVideoListener(new C21041(souvenirVideoAutoplayController));
                    souvenirVideoAutoplayController.f24191e.mo1602a();
                    souvenirVideoAutoplayController.f24191e.m26438a(EventTriggerType.BY_AUTOPLAY);
                }
            }
        }
    }
}
