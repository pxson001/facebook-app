package com.facebook.search.results.rows.sections.fanfavorite;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.search.results.rows.sections.collection.SearchResultsCollectionHeaderPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsFooterPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ProfilePictureOverlayCategoryBrowser */
public class SearchResultsGametimeFanFavoriteGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<SportsTeam>>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsGametimeFanFavoriteGroupPartDefinition f24337d;
    private static final Object f24338e = new Object();
    private final SearchResultsCollectionHeaderPartDefinition<SportsTeam> f24339a;
    private final GametimeFanFavoriteSelectorPartDefinition f24340b;
    private final SearchResultsFooterPartDefinition<SportsTeam> f24341c;

    private static SearchResultsGametimeFanFavoriteGroupPartDefinition m27840b(InjectorLike injectorLike) {
        return new SearchResultsGametimeFanFavoriteGroupPartDefinition(SearchResultsCollectionHeaderPartDefinition.m27379a(injectorLike), GametimeFanFavoriteSelectorPartDefinition.m27827a(injectorLike), SearchResultsFooterPartDefinition.m27396a(injectorLike));
    }

    public final Object m27841a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f24339a, feedProps);
        baseMultiRowSubParts.a(this.f24340b, feedProps);
        baseMultiRowSubParts.a(this.f24341c, feedProps);
        return null;
    }

    @Inject
    public SearchResultsGametimeFanFavoriteGroupPartDefinition(SearchResultsCollectionHeaderPartDefinition searchResultsCollectionHeaderPartDefinition, GametimeFanFavoriteSelectorPartDefinition gametimeFanFavoriteSelectorPartDefinition, SearchResultsFooterPartDefinition searchResultsFooterPartDefinition) {
        this.f24341c = searchResultsFooterPartDefinition;
        this.f24339a = searchResultsCollectionHeaderPartDefinition;
        this.f24340b = gametimeFanFavoriteSelectorPartDefinition;
    }

    public final boolean m27842a(Object obj) {
        return true;
    }

    public static SearchResultsGametimeFanFavoriteGroupPartDefinition m27839a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsGametimeFanFavoriteGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24338e) {
                SearchResultsGametimeFanFavoriteGroupPartDefinition searchResultsGametimeFanFavoriteGroupPartDefinition;
                if (a2 != null) {
                    searchResultsGametimeFanFavoriteGroupPartDefinition = (SearchResultsGametimeFanFavoriteGroupPartDefinition) a2.a(f24338e);
                } else {
                    searchResultsGametimeFanFavoriteGroupPartDefinition = f24337d;
                }
                if (searchResultsGametimeFanFavoriteGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27840b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24338e, b3);
                        } else {
                            f24337d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsGametimeFanFavoriteGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
