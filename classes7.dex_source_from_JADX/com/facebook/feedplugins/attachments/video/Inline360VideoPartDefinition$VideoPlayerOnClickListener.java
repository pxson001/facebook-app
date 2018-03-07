package com.facebook.feedplugins.attachments.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayer;

/* compiled from: TEXT_FIELD_ERROR */
public class Inline360VideoPartDefinition$VideoPlayerOnClickListener implements OnClickListener {
    final /* synthetic */ Inline360VideoPartDefinition f22751a;
    public final Inline360VideoPartDefinition$State f22752b;

    public Inline360VideoPartDefinition$VideoPlayerOnClickListener(Inline360VideoPartDefinition inline360VideoPartDefinition, Inline360VideoPartDefinition$State inline360VideoPartDefinition$State) {
        this.f22751a = inline360VideoPartDefinition;
        this.f22752b = inline360VideoPartDefinition$State;
    }

    public void onClick(View view) {
        int lastStartPosition;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1027109075);
        Inline360VideoAttachmentView inline360VideoAttachmentView = (Inline360VideoAttachmentView) view;
        RichVideoPlayer richVideoPlayer = inline360VideoAttachmentView.getRichVideoPlayer();
        boolean z = richVideoPlayer.m() || richVideoPlayer.n();
        int a2 = this.f22752b.f22745h.a();
        if (inline360VideoAttachmentView.getRichVideoPlayer().o()) {
            a2 = inline360VideoAttachmentView.getRichVideoPlayer().getCurrentPositionMs();
        }
        if (a2 == this.f22752b.f22740c.e.aD() || inline360VideoAttachmentView.getRichVideoPlayer().p()) {
            a2 = 0;
        }
        int i = a2;
        if (richVideoPlayer.m()) {
            lastStartPosition = richVideoPlayer.getLastStartPosition();
        } else {
            lastStartPosition = i;
        }
        Inline360VideoPartDefinition.b(inline360VideoAttachmentView, this.f22752b, this.f22751a.i, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
        this.f22752b.f22747j = true;
        this.f22752b.f22744g.a();
        this.f22752b.f22740c.b(view);
        this.f22752b.f22740c.a(inline360VideoAttachmentView, z);
        this.f22752b.f22740c.a(i, lastStartPosition, z);
        LogUtils.a(-489599813, a);
    }
}
