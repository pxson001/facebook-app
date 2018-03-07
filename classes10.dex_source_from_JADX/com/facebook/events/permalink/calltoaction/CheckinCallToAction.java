package com.facebook.events.permalink.calltoaction;

import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.permalink.EventPhaseSelector;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: button2 */
public class CheckinCallToAction {
    public final EventPhaseSelector f18274a;
    public final QeAccessor f18275b;

    @Inject
    public CheckinCallToAction(EventPhaseSelector eventPhaseSelector, QeAccessor qeAccessor) {
        this.f18274a = eventPhaseSelector;
        this.f18275b = qeAccessor;
        long a = ((long) this.f18275b.a(ExperimentsForEventsGatingModule.n, 0)) * 60000;
        this.f18274a.m18302a(a, a, 60000 * ((long) this.f18275b.a(ExperimentsForEventsGatingModule.m, 0)));
    }
}
