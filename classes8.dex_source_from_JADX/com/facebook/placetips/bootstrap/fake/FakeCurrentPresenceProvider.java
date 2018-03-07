package com.facebook.placetips.bootstrap.fake;

import com.facebook.placetips.bootstrap.PagePresenceProvider;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLInterfaces.LocationTriggerWithReactionUnits;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: search_awareness_learning_nux */
public class FakeCurrentPresenceProvider implements PagePresenceProvider {
    public final Optional<PresenceDescription> m3733a() {
        return Absent.INSTANCE;
    }

    public final Optional<LocationTriggerWithReactionUnits> m3734b() {
        return Absent.INSTANCE;
    }
}
