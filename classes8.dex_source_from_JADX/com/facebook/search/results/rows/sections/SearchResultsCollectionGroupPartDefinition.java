package com.facebook.search.results.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.SportsTeam;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityPivotUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.search.results.rows.sections.collection.OldSearchResultsGroupPartDefinition;
import com.facebook.search.results.rows.sections.collection.SearchResultsStoryCollectionGroupPartDefinition;
import com.facebook.search.results.rows.sections.commerce.SearchResultsCommerceGroupPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityPivotsGroupPartDefinition;
import com.facebook.search.results.rows.sections.eyewitness.SearchResultsEyewitnessGroupPartDefinition;
import com.facebook.search.results.rows.sections.fanfavorite.SearchResultsGametimeFanFavoriteGroupPartDefinition;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ROUNDED_CORNERS */
public class SearchResultsCollectionGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsCollectionGroupPartDefinition f23596c;
    private static final Object f23597d = new Object();
    private final Map<Class<?>, Lazy<? extends MultiRowGroupPartDefinition<?, ?, ?>>> f23598a = new HashMap();
    private final Lazy<OldSearchResultsGroupPartDefinition> f23599b;

    private static SearchResultsCollectionGroupPartDefinition m27261b(InjectorLike injectorLike) {
        return new SearchResultsCollectionGroupPartDefinition(IdBasedLazy.a(injectorLike, 10704), IdBasedLazy.a(injectorLike, 10710), IdBasedLazy.a(injectorLike, 10663), IdBasedLazy.a(injectorLike, 10649), IdBasedLazy.a(injectorLike, 10632), IdBasedLazy.a(injectorLike, 10693));
    }

    public final Object m27262a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        if (searchResultsCollectionUnit.m27154o().isPresent() && this.f23598a.containsKey(searchResultsCollectionUnit.m27154o().get())) {
            baseMultiRowSubParts.a((MultiRowGroupPartDefinition) ((Lazy) this.f23598a.get(searchResultsCollectionUnit.m27154o().get())).get(), feedProps);
        } else {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f23599b.get(), FeedProps.c(searchResultsCollectionUnit));
        }
        return null;
    }

    @Inject
    public SearchResultsCollectionGroupPartDefinition(Lazy<SearchResultsEyewitnessGroupPartDefinition> lazy, Lazy<SearchResultsGametimeFanFavoriteGroupPartDefinition> lazy2, Lazy<SearchResultsCommerceGroupPartDefinition> lazy3, Lazy<SearchResultsStoryCollectionGroupPartDefinition> lazy4, Lazy<OldSearchResultsGroupPartDefinition> lazy5, Lazy<SearchResultsEntityPivotsGroupPartDefinition> lazy6) {
        m27260a(GraphQLStoryAttachment.class, lazy);
        m27260a(SportsTeam.class, lazy2);
        m27260a(SearchResultsProductItemUnit.class, lazy3);
        m27260a(GraphQLStory.class, lazy4);
        m27260a(SearchResultsEntityPivotUnit.class, lazy6);
        this.f23599b = lazy5;
    }

    public static SearchResultsCollectionGroupPartDefinition m27259a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCollectionGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23597d) {
                SearchResultsCollectionGroupPartDefinition searchResultsCollectionGroupPartDefinition;
                if (a2 != null) {
                    searchResultsCollectionGroupPartDefinition = (SearchResultsCollectionGroupPartDefinition) a2.a(f23597d);
                } else {
                    searchResultsCollectionGroupPartDefinition = f23596c;
                }
                if (searchResultsCollectionGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27261b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23597d, b3);
                        } else {
                            f23596c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCollectionGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27263a(Object obj) {
        return true;
    }

    private <T> void m27260a(Class<T> cls, Lazy<? extends MultiRowGroupPartDefinition<?, ?, ?>> lazy) {
        this.f23598a.put(cls, lazy);
    }
}
