package com.facebook.placetips.presence;

import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceEvent;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipWelcomeHeaderFragmentModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: scaleType */
public class PagePresenceManager$PresenceUpdateBuilder {
    final /* synthetic */ PagePresenceManager f3881a;
    public final PresenceSource f3882b;
    public String f3883c;
    public String f3884d;
    public ImmutableList<String> f3885e;
    public PlaceTipWelcomeHeaderFragmentModel f3886f;
    public DefaultTextWithEntitiesLongFields f3887g;
    public DefaultTextWithEntitiesLongFields f3888h;
    public boolean f3889i;
    public DefaultTextWithEntitiesLongFields f3890j;
    public DefaultTextWithEntitiesLongFields f3891k;
    public DefaultTextWithEntitiesLongFields f3892l;
    public ReactionStories f3893m;
    public String f3894n;
    public String f3895o;
    public ConfidenceLevel f3896p = null;
    public LocationTriggerWithReactionUnitsModel f3897q = null;

    public PagePresenceManager$PresenceUpdateBuilder(PagePresenceManager pagePresenceManager, PresenceSource presenceSource) {
        this.f3881a = pagePresenceManager;
        this.f3882b = presenceSource;
    }

    public final PlaceTipsPresenceEvent m3872a() {
        Preconditions.checkNotNull(this.f3883c);
        Preconditions.checkNotNull(this.f3884d);
        Preconditions.checkNotNull(this.f3887g);
        return PagePresenceManager.a(this.f3881a, this);
    }

    final PresenceDescription m3873b() {
        long a = this.f3881a.b.a();
        return new PresenceDescription(this.f3883c, this.f3884d, this.f3885e, a, a, this.f3887g, this.f3888h, this.f3889i, this.f3890j, this.f3891k, this.f3892l, this.f3882b, this.f3886f, this.f3893m, this.f3894n, this.f3895o, this.f3896p);
    }
}
