package com.facebook.feed.autoplay;

import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.facebook.video.videohome.abtest.VideoHomeConfig;

/* compiled from: is_prefetch */
public class AutoplayStateManagerProvider extends AbstractAssistedProvider<AutoplayStateManager> {
    public final AutoplayStateManager m26594a(FeedProps<GraphQLStory> feedProps, GraphQLVideo graphQLVideo, Integer num) {
        return new AutoplayStateManager(QeInternalImplMethodAutoProvider.m3744a(this), feedProps, graphQLVideo, num, FbErrorReporterImpl.m2317a((InjectorLike) this), VideoAutoPlaySettingsChecker.m26868a((InjectorLike) this), VideoServerMethodAutoProvider.m26993a(this), DeviceConditionHelper.m5526a((InjectorLike) this), QuickExperimentControllerImpl.m10166a((InjectorLike) this), IdBasedProvider.m1811a(this, 806), FbDataConnectionManager.m3787a((InjectorLike) this), VideoLivePlaybackConfig.m14002a(this), VideoHomeConfig.m14005a(this));
    }
}
