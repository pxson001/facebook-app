package com.facebook.entitycards.analytics;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.entitycards.model.EntityCardsDataSource;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: init_cards */
public class EntityCardsImpressionLoggerProvider extends AbstractAssistedProvider<EntityCardsImpressionLogger> {
    public final EntityCardsImpressionLogger m12806a(EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, EntityCardsDataSource entityCardsDataSource) {
        return new EntityCardsImpressionLogger(entityCardsAnalyticsLogger, entityCardsDataSource, (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this));
    }
}
