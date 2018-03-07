package com.facebook.feed.util.composer.launch;

import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.simplepicker.SimplePickerSource;

/* compiled from: neko_app_uninstall_tracking */
public class NewsfeedLauncherContext implements FeedComposerLauncher$LauncherContext {
    private final String f12845a;

    public NewsfeedLauncherContext(String str) {
        this.f12845a = str;
    }

    public final ComposerTargetData mo2500a() {
        return ComposerTargetData.a;
    }

    public final String mo2501b() {
        return "newsfeed_composer";
    }

    public final ComposerSourceSurface mo2502c() {
        return ComposerSourceSurface.NEWSFEED;
    }

    public final String mo2503d() {
        return this.f12845a;
    }

    public final Surface mo2504e() {
        return Surface.ANDROID_FEED_COMPOSER;
    }

    public final SimplePickerSource mo2505f() {
        return SimplePickerSource.FEED;
    }

    public final ComposerType mo2506g() {
        return ComposerType.STATUS;
    }
}
