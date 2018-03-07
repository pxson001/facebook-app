package com.facebook.entitycards.model.event;

import com.facebook.entitycards.model.EntityCardsDataKey;
import com.facebook.entitycards.model.EntityCardsDataSource.State;
import com.facebook.entitycards.model.OrderedImmutableMap;

/* compiled from: home_id */
public class EntityModelCollectionChangedEvent extends EntityCardsModelEvent {
    public final OrderedImmutableMap<EntityCardsDataKey, Object> f11083a;
    public final State f11084b;
    public final State f11085c;

    public EntityModelCollectionChangedEvent(OrderedImmutableMap<EntityCardsDataKey, Object> orderedImmutableMap, State state, State state2) {
        this.f11083a = orderedImmutableMap;
        this.f11084b = state;
        this.f11085c = state2;
    }
}
