package com.facebook.reaction.placetips;

import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.event.PlaceTipsEventBus;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceStayedTheSameEvent;
import com.facebook.reaction.placetips.PlaceTipsReactionManager.5;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import javax.inject.Inject;

/* compiled from: too_many_events */
public class PlaceTipsPresenceStayedTheSameSubscriber extends INeedInitForEventBusSubscription<PlaceTipsPresenceStayedTheSameEvent, PlaceTipsReactionManager> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        PlaceTipsReactionManager placeTipsReactionManager = (PlaceTipsReactionManager) obj;
        ExecutorDetour.a(placeTipsReactionManager.f14898d, new 5(placeTipsReactionManager, ((PlaceTipsPresenceStayedTheSameEvent) fbEvent).mo658d()), 987858281);
    }

    @Inject
    public PlaceTipsPresenceStayedTheSameSubscriber(PlaceTipsEventBus placeTipsEventBus, Lazy<PlaceTipsReactionManager> lazy) {
        super(placeTipsEventBus, lazy);
    }

    public final Class<PlaceTipsPresenceStayedTheSameEvent> mo648a() {
        return PlaceTipsPresenceStayedTheSameEvent.class;
    }
}
