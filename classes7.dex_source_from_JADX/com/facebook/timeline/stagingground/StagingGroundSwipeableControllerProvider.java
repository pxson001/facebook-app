package com.facebook.timeline.stagingground;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesHScrollCirclePageIndicator;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import java.util.concurrent.Executor;

/* compiled from: facecast_show_pause_notif */
public class StagingGroundSwipeableControllerProvider extends AbstractAssistedProvider<StagingGroundSwipeableController> {
    public final StagingGroundSwipeableController m18766a(CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, SwipeableFramesHScrollCirclePageIndicator swipeableFramesHScrollCirclePageIndicator) {
        StagingGroundSwipeableController stagingGroundSwipeableController = new StagingGroundSwipeableController(creativeEditingSwipeableLayout, swipeableFramesHScrollCirclePageIndicator);
        stagingGroundSwipeableController.m18765a(IdBasedProvider.a(this, 2164), IdBasedSingletonScopeProvider.a(this, 7172), (CreativeEditingSwipeableControllerProvider) getOnDemandAssistedProviderForStaticDi(CreativeEditingSwipeableControllerProvider.class), IdBasedProvider.a(this, 9288), (SwipeableParamsListBuilderProvider) getOnDemandAssistedProviderForStaticDi(SwipeableParamsListBuilderProvider.class), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 494));
        return stagingGroundSwipeableController;
    }
}
