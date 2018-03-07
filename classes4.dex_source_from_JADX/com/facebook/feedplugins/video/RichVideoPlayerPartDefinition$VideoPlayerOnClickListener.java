package com.facebook.feedplugins.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayer;

/* compiled from: pic */
public class RichVideoPlayerPartDefinition$VideoPlayerOnClickListener implements OnClickListener {
    final /* synthetic */ RichVideoPlayerPartDefinition f5051a;
    public final RichVideoPlayerPartDefinition$State f5052b;
    private final FrameRateBlameMarkers f5053c;
    private final E f5054d;

    public RichVideoPlayerPartDefinition$VideoPlayerOnClickListener(RichVideoPlayerPartDefinition richVideoPlayerPartDefinition, RichVideoPlayerPartDefinition$State richVideoPlayerPartDefinition$State, FrameRateBlameMarkers frameRateBlameMarkers, E e) {
        this.f5051a = richVideoPlayerPartDefinition;
        this.f5052b = richVideoPlayerPartDefinition$State;
        this.f5053c = frameRateBlameMarkers;
        this.f5054d = e;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 324820904);
        if (this.f5052b.f4986r) {
            Logger.a(2, EntryType.UI_INPUT_END, 711718068, a);
            return;
        }
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) view;
        RichVideoPlayer richVideoPlayer = richVideoAttachmentView.getRichVideoPlayer();
        this.f5052b.f4986r = true;
        int a2 = this.f5052b.f4978j.mo420a();
        if (richVideoPlayer.m14849o()) {
            a2 = richVideoPlayer.getCurrentPositionMs();
        }
        if (a2 == this.f5052b.f4973e.aD()) {
            a2 = 0;
        }
        int i = a2;
        boolean m = richVideoPlayer.m14847m();
        this.f5051a.n.a(this.f5052b.f4976h.f4962a.f4833b);
        this.f5051a.n.a(this.f5052b.f4976h.f4962a.f4833b, m);
        int lastStartPosition = m ? richVideoPlayer.getLastStartPosition() : i;
        RichVideoPlayerPartDefinition.b(richVideoPlayer, this.f5052b, this.f5053c, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
        this.f5052b.f4988t = ((FullScreenVideoPlayerHost) ContextUtils.a(view.getContext(), FullScreenVideoPlayerHost.class)).k();
        this.f5052b.f4988t.a(this.f5052b.f4989u);
        this.f5052b.f4988t.setAllowLooping(true);
        this.f5052b.f4988t.setLogEnteringStartEvent(!m);
        this.f5052b.f4988t.setLogExitingPauseEvent(false);
        this.f5052b.f4983o.f4950h = richVideoAttachmentView;
        this.f5052b.f4977i.m5311a();
        this.f5052b.f4983o.m5327a(i).m5330b(lastStartPosition).f4953k = richVideoAttachmentView.getAndClearShowLiveCommentDialogFragment();
        if (m) {
            this.f5052b.f4983o.f4952j = EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION;
        } else {
            this.f5052b.f4983o.f4952j = EventTriggerType.BY_USER;
        }
        this.f5052b.f4983o.f4949g = null;
        this.f5052b.f4988t.a(this.f5052b.f4983o);
        LogUtils.a(-2067284975, a);
    }
}
