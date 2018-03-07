package com.facebook.search.results.rows.sections.fanfavorite;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.SportsTeam;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Prompts that are not shown */
public class GametimeFanFavoriteAfterVotingPartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<SportsTeam>>, Void, HasPositionInformation, CustomLinearLayout> {
    public static final ViewType f24298a = ViewType.a(2130904239);
    private static GametimeFanFavoriteAfterVotingPartDefinition f24299d;
    private static final Object f24300e = new Object();
    private final BackgroundPartDefinition f24301b;
    private final GametimeFanFavoriteTeamAfterVotingPartDefinition f24302c;

    private static GametimeFanFavoriteAfterVotingPartDefinition m27817b(InjectorLike injectorLike) {
        return new GametimeFanFavoriteAfterVotingPartDefinition(BackgroundPartDefinition.a(injectorLike), GametimeFanFavoriteTeamAfterVotingPartDefinition.m27832a(injectorLike));
    }

    public final Object m27819a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        subParts.a(this.f24301b, new StylingData(feedProps, PaddingStyle.a));
        subParts.a(2131561726, this.f24302c, searchResultsCollectionUnit.f23463d.get(0));
        subParts.a(2131561727, this.f24302c, searchResultsCollectionUnit.f23463d.get(1));
        return null;
    }

    public final boolean m27820a(Object obj) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) ((FeedProps) obj).a;
        return searchResultsCollectionUnit.f23463d.size() == 2 && searchResultsCollectionUnit.f23463d.get(0) != null && searchResultsCollectionUnit.f23463d.get(1) != null && (((SportsTeam) searchResultsCollectionUnit.f23463d.get(0)).f23401j || ((SportsTeam) searchResultsCollectionUnit.f23463d.get(1)).f23401j);
    }

    @Inject
    public GametimeFanFavoriteAfterVotingPartDefinition(BackgroundPartDefinition backgroundPartDefinition, GametimeFanFavoriteTeamAfterVotingPartDefinition gametimeFanFavoriteTeamAfterVotingPartDefinition) {
        this.f24301b = backgroundPartDefinition;
        this.f24302c = gametimeFanFavoriteTeamAfterVotingPartDefinition;
    }

    public final ViewType<CustomLinearLayout> m27818a() {
        return f24298a;
    }

    public static GametimeFanFavoriteAfterVotingPartDefinition m27816a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoriteAfterVotingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24300e) {
                GametimeFanFavoriteAfterVotingPartDefinition gametimeFanFavoriteAfterVotingPartDefinition;
                if (a2 != null) {
                    gametimeFanFavoriteAfterVotingPartDefinition = (GametimeFanFavoriteAfterVotingPartDefinition) a2.a(f24300e);
                } else {
                    gametimeFanFavoriteAfterVotingPartDefinition = f24299d;
                }
                if (gametimeFanFavoriteAfterVotingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27817b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24300e, b3);
                        } else {
                            f24299d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeFanFavoriteAfterVotingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
