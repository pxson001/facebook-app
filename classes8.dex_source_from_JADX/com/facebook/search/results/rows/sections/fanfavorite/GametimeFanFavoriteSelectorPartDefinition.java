package com.facebook.search.results.rows.sections.fanfavorite;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.SportsTeam;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Promotions - Internal */
public class GametimeFanFavoriteSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<SportsTeam>>, Void, SearchResultsFeedEnvironment> {
    private static GametimeFanFavoriteSelectorPartDefinition f24318c;
    private static final Object f24319d = new Object();
    private final GametimeFanFavoriteAfterVotingPartDefinition f24320a;
    private final GametimeFanFavoriteBeforeVotingPartDefinition<SearchResultsFeedEnvironment> f24321b;

    private static GametimeFanFavoriteSelectorPartDefinition m27828b(InjectorLike injectorLike) {
        return new GametimeFanFavoriteSelectorPartDefinition(GametimeFanFavoriteBeforeVotingPartDefinition.m27821a(injectorLike), GametimeFanFavoriteAfterVotingPartDefinition.m27816a(injectorLike));
    }

    public final Object m27829a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f24321b, feedProps).a(this.f24320a, feedProps);
        return null;
    }

    @Inject
    public GametimeFanFavoriteSelectorPartDefinition(GametimeFanFavoriteBeforeVotingPartDefinition gametimeFanFavoriteBeforeVotingPartDefinition, GametimeFanFavoriteAfterVotingPartDefinition gametimeFanFavoriteAfterVotingPartDefinition) {
        this.f24320a = gametimeFanFavoriteAfterVotingPartDefinition;
        this.f24321b = gametimeFanFavoriteBeforeVotingPartDefinition;
    }

    public final boolean m27830a(Object obj) {
        return true;
    }

    public static GametimeFanFavoriteSelectorPartDefinition m27827a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoriteSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24319d) {
                GametimeFanFavoriteSelectorPartDefinition gametimeFanFavoriteSelectorPartDefinition;
                if (a2 != null) {
                    gametimeFanFavoriteSelectorPartDefinition = (GametimeFanFavoriteSelectorPartDefinition) a2.a(f24319d);
                } else {
                    gametimeFanFavoriteSelectorPartDefinition = f24318c;
                }
                if (gametimeFanFavoriteSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27828b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24319d, b3);
                        } else {
                            f24318c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeFanFavoriteSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
