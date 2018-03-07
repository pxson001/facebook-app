package com.facebook.feed.rows.photosfeed.videos;

import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.inject.Assisted;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.player.BaseInlineVideoPlayer;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Inject;

/* compiled from: __{TOKEN}__ */
public class PhotosFeedVideoViewController extends VideoViewController<InlineVideoAttachmentView> {
    private boolean f20347a = false;
    public PhotosFeedInlineVideoPersistentState f20348b;
    public VideoAutoPlaySettingsChecker f20349c;

    public final void m23472a(Object obj) {
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) obj;
        if (this.f20347a) {
            this.f20347a = false;
            this.f20348b.m23469a(inlineVideoAttachmentView.getSeekPosition());
            BaseInlineVideoPlayer baseInlineVideoPlayer = inlineVideoAttachmentView.a;
            if (baseInlineVideoPlayer.b()) {
                this.f20348b.m23469a(baseInlineVideoPlayer.getCurrentPosition());
                baseInlineVideoPlayer.a(EventTriggerType.BY_AUTOPLAY, VideoMediaState.PAUSED);
            }
        }
    }

    public final void m23473b(Object obj) {
        InlineVideoAttachmentView inlineVideoAttachmentView = (InlineVideoAttachmentView) obj;
        if (!this.f20347a) {
            Object obj2;
            this.f20347a = true;
            if (this.f20348b.f20346b || !this.f20349c.a()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                int a = this.f20348b.m23468a();
                inlineVideoAttachmentView.a.a(EventTriggerType.BY_AUTOPLAY, new PlayPosition(a, a));
            }
        }
    }

    @Inject
    public PhotosFeedVideoViewController(@Assisted String str, @Assisted PhotosFeedInlineVideoPersistentState photosFeedInlineVideoPersistentState, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker) {
        super(str);
        this.f20348b = photosFeedInlineVideoPersistentState;
        this.f20349c = videoAutoPlaySettingsChecker;
    }
}
