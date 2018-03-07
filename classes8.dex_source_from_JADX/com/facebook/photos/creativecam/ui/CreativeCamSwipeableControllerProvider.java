package com.facebook.photos.creativecam.ui;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.ipc.creativecam.controller.CreativeCamSwipeableFramesLogController;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableFramesHScrollCirclePageIndicator;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.google.common.collect.ImmutableList;

/* compiled from: start_ms */
public class CreativeCamSwipeableControllerProvider extends AbstractAssistedProvider<CreativeCamSwipeableController> {
    public final CreativeCamSwipeableController m2393a(CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, SwipeableFramesHScrollCirclePageIndicator swipeableFramesHScrollCirclePageIndicator, CreativeEditingLogger creativeEditingLogger, ImmutableList<Frame> immutableList, String str, CreativeCamSource creativeCamSource, CreativeCamSwipeableFramesLogController creativeCamSwipeableFramesLogController) {
        return new CreativeCamSwipeableController(creativeEditingSwipeableLayout, swipeableFramesHScrollCirclePageIndicator, creativeEditingLogger, immutableList, str, creativeCamSource, creativeCamSwipeableFramesLogController, (CreativeEditingSwipeableControllerProvider) getOnDemandAssistedProviderForStaticDi(CreativeEditingSwipeableControllerProvider.class), IdBasedProvider.a(this, 9288), (SwipeableParamsListBuilderProvider) getOnDemandAssistedProviderForStaticDi(SwipeableParamsListBuilderProvider.class));
    }
}
