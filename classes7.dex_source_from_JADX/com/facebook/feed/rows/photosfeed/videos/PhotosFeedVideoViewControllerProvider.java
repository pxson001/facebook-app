package com.facebook.feed.rows.photosfeed.videos;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;

/* compiled from: __fbBatchedBridgeConfig */
public class PhotosFeedVideoViewControllerProvider extends AbstractAssistedProvider<PhotosFeedVideoViewController> {
    public final PhotosFeedVideoViewController m23474a(String str, PhotosFeedInlineVideoPersistentState photosFeedInlineVideoPersistentState) {
        return new PhotosFeedVideoViewController(str, photosFeedInlineVideoPersistentState, VideoAutoPlaySettingsChecker.a(this));
    }
}
