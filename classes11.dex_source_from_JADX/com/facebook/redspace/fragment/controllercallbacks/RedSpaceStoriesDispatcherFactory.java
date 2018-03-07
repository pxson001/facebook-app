package com.facebook.redspace.fragment.controllercallbacks;

import com.facebook.base.fragment.FbFragmentController;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.feed.fragment.controllercallbacks.FeedLoggingViewportController;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeViewportEventListener;
import com.facebook.redspace.data.RedSpaceHeaderCollection;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceComposerActivityController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFriendViewMutationController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpacePresenceActivityController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceSelfViewMutationController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceViewportMonitorFragmentControllerProvider;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceWallLoadEventController;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.ultralight.Inject;

/* compiled from: PagesServicesFragment */
public class RedSpaceStoriesDispatcherFactory {
    @Inject
    private RedSpaceViewportMonitorFragmentControllerProvider f12023a;
    @Inject
    private RedSpaceFriendViewMutationController f12024b;
    @Inject
    private RedSpacePresenceActivityController f12025c;
    @Inject
    private RedSpaceWallLoadEventController f12026d;
    @Inject
    private RedSpaceComposerActivityController f12027e;
    @Inject
    private RedSpaceSelfViewMutationController f12028f;
    @Inject
    private RedSpaceOptimisticBadgeViewportEventListener f12029g;
    @Inject
    private FeedLoggingViewportController f12030h;

    private static RedSpaceStoriesDispatcherFactory m12498b(InjectorLike injectorLike) {
        RedSpaceStoriesDispatcherFactory redSpaceStoriesDispatcherFactory = new RedSpaceStoriesDispatcherFactory();
        RedSpaceViewportMonitorFragmentControllerProvider redSpaceViewportMonitorFragmentControllerProvider = (RedSpaceViewportMonitorFragmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceViewportMonitorFragmentControllerProvider.class);
        RedSpaceFriendViewMutationController redSpaceFriendViewMutationController = new RedSpaceFriendViewMutationController();
        Clock clock = (Clock) SystemClockMethodAutoProvider.a(injectorLike);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 10172);
        redSpaceFriendViewMutationController.f12066b = clock;
        redSpaceFriendViewMutationController.f12067c = qeAccessor;
        redSpaceFriendViewMutationController.f12068d = b;
        RedSpaceFriendViewMutationController redSpaceFriendViewMutationController2 = redSpaceFriendViewMutationController;
        RedSpacePresenceActivityController redSpacePresenceActivityController = new RedSpacePresenceActivityController();
        redSpacePresenceActivityController.f12081a = IdBasedSingletonScopeProvider.b(injectorLike, 3088);
        RedSpacePresenceActivityController redSpacePresenceActivityController2 = redSpacePresenceActivityController;
        RedSpaceWallLoadEventController b2 = RedSpaceWallLoadEventController.m12560b(injectorLike);
        RedSpaceComposerActivityController b3 = RedSpaceComposerActivityController.m12509b(injectorLike);
        RedSpaceSelfViewMutationController redSpaceSelfViewMutationController = new RedSpaceSelfViewMutationController();
        redSpaceSelfViewMutationController.f12103a = IdBasedLazy.a(injectorLike, 10175);
        redSpaceStoriesDispatcherFactory.m12497a(redSpaceViewportMonitorFragmentControllerProvider, redSpaceFriendViewMutationController2, redSpacePresenceActivityController2, b2, b3, redSpaceSelfViewMutationController, RedSpaceOptimisticBadgeViewportEventListener.b(injectorLike), FeedLoggingViewportController.b(injectorLike));
        return redSpaceStoriesDispatcherFactory;
    }

    private void m12497a(RedSpaceViewportMonitorFragmentControllerProvider redSpaceViewportMonitorFragmentControllerProvider, RedSpaceFriendViewMutationController redSpaceFriendViewMutationController, RedSpacePresenceActivityController redSpacePresenceActivityController, RedSpaceWallLoadEventController redSpaceWallLoadEventController, RedSpaceComposerActivityController redSpaceComposerActivityController, RedSpaceSelfViewMutationController redSpaceSelfViewMutationController, RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener, FeedLoggingViewportController feedLoggingViewportController) {
        this.f12023a = redSpaceViewportMonitorFragmentControllerProvider;
        this.f12024b = redSpaceFriendViewMutationController;
        this.f12025c = redSpacePresenceActivityController;
        this.f12026d = redSpaceWallLoadEventController;
        this.f12027e = redSpaceComposerActivityController;
        this.f12028f = redSpaceSelfViewMutationController;
        this.f12029g = redSpaceOptimisticBadgeViewportEventListener;
        this.f12030h = feedLoggingViewportController;
    }

    public static RedSpaceStoriesDispatcherFactory m12496a(InjectorLike injectorLike) {
        return m12498b(injectorLike);
    }

    public final RedSpaceStoriesControllerCallbacksDispatcher m12499a(ViewportMonitor viewportMonitor, RedSpaceFeedEventController redSpaceFeedEventController, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceWallCollection redSpaceWallCollection, RedSpaceHeaderCollection redSpaceHeaderCollection, TimelineContext timelineContext) {
        RedSpaceStoriesControllerCallbacksDispatcher redSpaceStoriesControllerCallbacksDispatcher = new RedSpaceStoriesControllerCallbacksDispatcher(new FbFragmentController(), RedSpaceViewportMonitorFragmentControllerProvider.m12559a(viewportMonitor), redSpaceFeedEventController, this.f12024b, this.f12025c, this.f12026d, this.f12027e, this.f12028f, this.f12029g, this.f12030h);
        redSpaceStoriesControllerCallbacksDispatcher.m12479a(redSpaceStoriesControllerCallbacksDispatcher);
        redSpaceStoriesControllerCallbacksDispatcher.m12474a(new Holder());
        redSpaceStoriesControllerCallbacksDispatcher.m12480a(redSpaceFeedProfileFragmentModel);
        redSpaceStoriesControllerCallbacksDispatcher.m12485a("redspace");
        redSpaceStoriesControllerCallbacksDispatcher.m12478a(redSpaceWallCollection);
        redSpaceStoriesControllerCallbacksDispatcher.m12477a(redSpaceHeaderCollection);
        redSpaceStoriesControllerCallbacksDispatcher.m12476a(timelineContext);
        redSpaceStoriesControllerCallbacksDispatcher.m12495g();
        return redSpaceStoriesControllerCallbacksDispatcher;
    }
}
