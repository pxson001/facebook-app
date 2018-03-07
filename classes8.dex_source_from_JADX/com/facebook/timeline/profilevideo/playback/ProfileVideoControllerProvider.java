package com.facebook.timeline.profilevideo.playback;

import android.content.Context;
import com.facebook.caspian.ui.standardheader.ProfileVideoIconBinder;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.timeline.profilevideo.playback.protocol.ProfileVideoHeaderData;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.util.concurrent.ListeningExecutorService;

/* compiled from: mMinor */
public class ProfileVideoControllerProvider extends AbstractAssistedProvider<ProfileVideoController> {
    public final ProfileVideoController m11150a(Context context, StandardCoverHeaderView standardCoverHeaderView, boolean z, ProfileVideoHeaderData profileVideoHeaderData, ProfileVideoPlaybackExperimentAccessor profileVideoPlaybackExperimentAccessor) {
        return new ProfileVideoController(context, standardCoverHeaderView, z, profileVideoHeaderData, profileVideoPlaybackExperimentAccessor, VideoAutoPlaySettingsChecker.a(this), GraphQLQueryExecutor.a(this), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), FullscreenVideoPlayerLauncher.m11255b(this), (ZeroDialogController) FbZeroDialogController.b(this), OptimisticProfileVideoStore.m11170a((InjectorLike) this), ProfileVideoIconBinder.a(this));
    }
}
