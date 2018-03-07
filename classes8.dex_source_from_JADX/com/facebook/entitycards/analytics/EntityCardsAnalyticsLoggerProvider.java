package com.facebook.entitycards.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.google.common.base.Optional;

/* compiled from: initialEntityId must be in initialEntityIds */
public class EntityCardsAnalyticsLoggerProvider extends AbstractAssistedProvider<EntityCardsAnalyticsLogger> {
    public final EntityCardsAnalyticsLogger m12800a(String str, String str2, Optional<String> optional, Optional<FriendingLocation> optional2) {
        return new EntityCardsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(this), (Clock) SystemClockMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 137), IdBasedLazy.a(this, 6689), IdBasedSingletonScopeProvider.b(this, 494), str, str2, optional, optional2);
    }
}
