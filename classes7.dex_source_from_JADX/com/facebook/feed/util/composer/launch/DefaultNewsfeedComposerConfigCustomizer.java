package com.facebook.feed.util.composer.launch;

import com.facebook.feed.util.composer.launch.FeedComposerLauncher.ComposerConfigCustomizer;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;

/* compiled from: Tab layout should be a subclass of ImageView */
public class DefaultNewsfeedComposerConfigCustomizer implements ComposerConfigCustomizer {
    public final void m24942a(Builder builder) {
        builder.setAllowFeedOnlyPost(true);
        builder.setAllowDynamicTextStyle(true);
    }
}
