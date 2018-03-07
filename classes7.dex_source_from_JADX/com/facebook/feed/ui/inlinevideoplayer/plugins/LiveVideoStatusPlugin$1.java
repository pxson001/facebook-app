package com.facebook.feed.ui.inlinevideoplayer.plugins;

import com.facebook.facecastdisplay.LiveVideoStatusMessage.VideoState;
import com.facebook.facecastdisplay.LiveVideoStatusView;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;

/* compiled from: The ViewPager center page can't be < 0 */
class LiveVideoStatusPlugin$1 implements Runnable {
    final /* synthetic */ LiveVideoStatusPlugin f22266a;

    LiveVideoStatusPlugin$1(LiveVideoStatusPlugin liveVideoStatusPlugin) {
        this.f22266a = liveVideoStatusPlugin;
    }

    public void run() {
        int i;
        if (this.f22266a.h == null || this.f22266a.h.q != PlayerType.FULL_SCREEN_PLAYER) {
            i = 0;
        } else {
            i = 1;
        }
        this.f22266a.s.setIsSmall(this.f22266a.w);
        this.f22266a.b.setVisibility(0);
        LiveVideoStatusView liveVideoStatusView = this.f22266a.s;
        if (i != 0) {
            i = 8;
        } else {
            i = 0;
        }
        liveVideoStatusView.setVisibility(i);
        if (this.f22266a.p.s) {
            this.f22266a.d.setLiveText(VideoState.BROADCAST_INTERRUPTED);
        } else {
            this.f22266a.d.setLiveText(VideoState.PAUSED);
        }
        this.f22266a.d.setIsSmall(this.f22266a.w);
        this.f22266a.d.setVisibility(0);
    }
}
