package com.facebook.video.player.events;

import com.facebook.video.subtitles.controller.Subtitles;

/* compiled from: permission */
public class RVPRequestSubtitlesLanguageChangeEvent extends RichVideoPlayerEvent {
    public final Subtitles f5097a;

    public RVPRequestSubtitlesLanguageChangeEvent(Subtitles subtitles) {
        this.f5097a = subtitles;
    }
}
