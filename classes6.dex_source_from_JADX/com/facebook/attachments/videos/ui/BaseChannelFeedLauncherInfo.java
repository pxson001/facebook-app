package com.facebook.attachments.videos.ui;

import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.video.player.VideoTransitionNode;

/* compiled from: profile_photo_method */
public class BaseChannelFeedLauncherInfo implements HasChannelFeedLauncherInfo {
    private final VideoStoryPersistentState f7348a;

    public BaseChannelFeedLauncherInfo(VideoStoryPersistentState videoStoryPersistentState) {
        this.f7348a = videoStoryPersistentState;
    }

    public int getSeekPosition() {
        if (this.f7348a == null) {
            return 0;
        }
        return this.f7348a.a();
    }

    public int getLastStartPosition() {
        return 0;
    }

    public VideoTransitionNode getTransitionNode() {
        return null;
    }

    public VideoStoryPersistentState getVideoStoryPersistentState() {
        return this.f7348a;
    }
}
