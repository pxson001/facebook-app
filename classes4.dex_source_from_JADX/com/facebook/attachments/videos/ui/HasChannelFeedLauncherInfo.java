package com.facebook.attachments.videos.ui;

import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.video.player.VideoTransitionNode;
import javax.annotation.Nullable;

/* compiled from: deleted_messages */
public interface HasChannelFeedLauncherInfo {
    int getLastStartPosition();

    int getSeekPosition();

    VideoTransitionNode getTransitionNode();

    @Nullable
    VideoStoryPersistentState getVideoStoryPersistentState();
}
