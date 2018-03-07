package com.facebook.feed.fragment;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.common.time.Clock;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.core.persistence.ContextStateMap;
import com.facebook.feed.rows.sections.hidden.FeedUnitVisibilityKey;
import com.facebook.feed.rows.sections.hidden.FeedUnitVisibilityState;
import com.facebook.feed.util.event.HideEvents$StoryVisibilityEvent;
import com.facebook.feed.util.event.HideEvents$StoryVisibilityEventSubscriber;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: off_screen_ads_pyml_using_graphql_batch */
public final class StoryVisibilitySubscriber extends HideEvents$StoryVisibilityEventSubscriber {
    private final LegacyFeedUnitUpdater f11618a;
    private final Clock f11619b;
    public final ContextStateMap f11620c;

    public final void mo650b(FbEvent fbEvent) {
        HideEvents$StoryVisibilityEvent hideEvents$StoryVisibilityEvent = (HideEvents$StoryVisibilityEvent) fbEvent;
        if (hideEvents$StoryVisibilityEvent.f11646a == null) {
            HideableUnit b;
            if (hideEvents$StoryVisibilityEvent.f11647b != null) {
                b = this.f11618a.mo1382b(hideEvents$StoryVisibilityEvent.f11647b);
            } else {
                b = this.f11618a.mo1383c(hideEvents$StoryVisibilityEvent.f11648c);
            }
            if (b != null) {
                m16927a(b, hideEvents$StoryVisibilityEvent);
                return;
            }
            return;
        }
        for (GraphQLFeedUnitEdge c : this.f11618a.mo1384d(hideEvents$StoryVisibilityEvent.f11646a)) {
            FeedUnit c2 = c.mo2540c();
            if (c2 instanceof HideableUnit) {
                m16927a((HideableUnit) c2, hideEvents$StoryVisibilityEvent);
            }
        }
    }

    @Inject
    public StoryVisibilitySubscriber(Clock clock, ContextStateMap contextStateMap, @Assisted LegacyFeedUnitUpdater legacyFeedUnitUpdater) {
        this.f11619b = clock;
        this.f11620c = contextStateMap;
        this.f11618a = legacyFeedUnitUpdater;
    }

    private void m16927a(HideableUnit hideableUnit, HideEvents$StoryVisibilityEvent hideEvents$StoryVisibilityEvent) {
        int i;
        if (hideEvents$StoryVisibilityEvent.f11649d == StoryVisibility.CONTRACTING) {
            i = ((FeedUnitVisibilityState) this.f11620c.m14940a(new FeedUnitVisibilityKey(hideableUnit), (CacheableEntity) hideableUnit)).f18983a;
        } else {
            i = hideEvents$StoryVisibilityEvent.f11650e;
        }
        this.f11618a.mo1379a((HideableUnit) FeedUnitMutator.a(hideableUnit).a(this.f11619b.mo211a(), hideEvents$StoryVisibilityEvent.f11649d, i).a());
    }
}
