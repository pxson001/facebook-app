package com.facebook.reaction.placetips;

import com.facebook.common.init.INeedInitForEventBusSubscription;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.event.PlaceTipsEventBus;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceChangedEvent;
import com.facebook.reaction.placetips.PlaceTipsReactionManager.4;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import javax.inject.Inject;

/* compiled from: topic_feed_enabled */
public class PlaceTipsPresenceChangedSubscriber extends INeedInitForEventBusSubscription<PlaceTipsPresenceChangedEvent, PlaceTipsReactionManager> {
    protected final void mo649a(FbEvent fbEvent, Object obj) {
        PlaceTipsReactionManager placeTipsReactionManager = (PlaceTipsReactionManager) obj;
        ExecutorDetour.a(placeTipsReactionManager.f14898d, new 4(placeTipsReactionManager, ((PlaceTipsPresenceChangedEvent) fbEvent).mo658d()), -1770180641);
    }

    @Inject
    public PlaceTipsPresenceChangedSubscriber(PlaceTipsEventBus placeTipsEventBus, Lazy<PlaceTipsReactionManager> lazy) {
        super(placeTipsEventBus, lazy);
    }

    public final Class<PlaceTipsPresenceChangedEvent> mo648a() {
        return PlaceTipsPresenceChangedEvent.class;
    }
}
