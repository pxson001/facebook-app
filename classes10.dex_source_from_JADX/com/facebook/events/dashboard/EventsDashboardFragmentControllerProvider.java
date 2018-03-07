package com.facebook.events.dashboard;

import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.titlebar.FbTitleBarSupplier;

/* compiled from: commerce/admin/shop/{#%s}/edit */
public class EventsDashboardFragmentControllerProvider extends AbstractAssistedProvider<EventsDashboardFragmentController> {
    public final EventsDashboardFragmentController m17072a(EventsDashboardFragment eventsDashboardFragment, DashboardFilterType dashboardFilterType, Boolean bool) {
        return new EventsDashboardFragmentController(eventsDashboardFragment, dashboardFilterType, bool, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(this), EventPermalinkController.m18262b((InjectorLike) this), EventsDashboardPerformanceLogger.m17093a((InjectorLike) this), TipSeenTracker.b(this), EventsEventBus.a(this));
    }
}
