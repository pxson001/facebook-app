package com.facebook.feedplugins.attachments.video;

import com.facebook.feed.ui.fullscreenvideoplayer.SubtitlesRequestCallback;
import com.facebook.feedplugins.attachments.video.VideoSubtitlesPartDefinition.State;
import com.facebook.video.subtitles.controller.Subtitles;

/* compiled from: TE;)V */
public class VideoSubtitlesPartDefinition$1 implements SubtitlesRequestCallback {
    final /* synthetic */ State f22854a;
    final /* synthetic */ VideoSubtitlesPartDefinition f22855b;

    public VideoSubtitlesPartDefinition$1(VideoSubtitlesPartDefinition videoSubtitlesPartDefinition, State state) {
        this.f22855b = videoSubtitlesPartDefinition;
        this.f22854a = state;
    }

    public final void mo1511a(Subtitles subtitles) {
        this.f22854a.b = subtitles;
        if (this.f22854a.c != null) {
            this.f22854a.c.a(subtitles);
        }
    }

    public final void mo1510a() {
        this.f22854a.b = null;
        if (this.f22854a.c != null) {
            this.f22854a.c.a(null);
        }
    }
}
