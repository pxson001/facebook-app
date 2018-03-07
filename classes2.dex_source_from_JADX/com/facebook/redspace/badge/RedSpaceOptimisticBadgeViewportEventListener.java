package com.facebook.redspace.badge;

import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.ultralight.Inject;

/* compiled from: photo/%s/?set=%s */
public class RedSpaceOptimisticBadgeViewportEventListener extends BaseViewportEventListener implements ViewportEventListener {
    @Inject
    public RedSpaceOptimisticBadgeStore f10089a;
    @Inject
    public QeAccessor f10090b;

    public static RedSpaceOptimisticBadgeViewportEventListener m15187b(InjectorLike injectorLike) {
        RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener = new RedSpaceOptimisticBadgeViewportEventListener();
        QeAccessor a = QeInternalImplMethodAutoProvider.m3744a(injectorLike);
        redSpaceOptimisticBadgeViewportEventListener.f10089a = RedSpaceOptimisticBadgeStore.m15190a(injectorLike);
        redSpaceOptimisticBadgeViewportEventListener.f10090b = a;
        return redSpaceOptimisticBadgeViewportEventListener;
    }

    public final void mo1970a(Object obj) {
        FeedUnit a = FeedUnitHelper.m21141a(obj);
        if (a != null && (a instanceof GraphQLStory)) {
            this.f10089a.m15197a((GraphQLStory) a);
        }
    }

    public final boolean m15189a() {
        return this.f10090b.mo596a(ExperimentsForRedSpaceExperimentsModule.f7063h, false) && this.f10090b.mo596a(ExperimentsForRedSpaceExperimentsModule.f7058c, true);
    }

    public static RedSpaceOptimisticBadgeViewportEventListener m15186a(InjectorLike injectorLike) {
        return m15187b(injectorLike);
    }
}
