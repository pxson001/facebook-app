package com.facebook.video.watchandbrowse;

import android.view.View;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.video.player.PlayerActivityManager;

/* compiled from: length */
public class VideoWatchAndBrowseLauncherPartDefinitionProvider extends AbstractAssistedProvider<VideoWatchAndBrowseLauncherPartDefinition> {
    public final <E extends HasFeedListType & HasPersistentState, V extends View & CanLaunchWatchAndBrowse> VideoWatchAndBrowseLauncherPartDefinition<E, V> m225a(WatchAndMoreType watchAndMoreType) {
        return new VideoWatchAndBrowseLauncherPartDefinition(PlayerActivityManager.a(this), (AutoplayStateManagerProvider) getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), IdBasedLazy.a(this, 1817), watchAndMoreType);
    }
}
