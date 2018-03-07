package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLPhrasesAnalysisItem;
import com.facebook.graphql.model.GraphQLQuotesAnalysisItem;
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
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.pulse.PulseCommonPhrasesGroupPartDefinition;
import com.facebook.search.results.rows.sections.pulse.PulseCommonQuotesGroupPartDefinition;
import com.google.common.base.Optional;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REPORT_DUPLICATES */
public class SearchResultsItemsSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsItemsSelectorPartDefinition f23767e;
    private static final Object f23768f = new Object();
    private final SearchResultsItemsGroupPartDefinition f23769a;
    private final SearchResultsMediaGridPartDefinition f23770b;
    private final PulseCommonPhrasesGroupPartDefinition f23771c;
    private final PulseCommonQuotesGroupPartDefinition f23772d;

    private static SearchResultsItemsSelectorPartDefinition m27412b(InjectorLike injectorLike) {
        return new SearchResultsItemsSelectorPartDefinition(SearchResultsItemsGroupPartDefinition.m27400a(injectorLike), SearchResultsMediaGridPartDefinition.m27419a(injectorLike), PulseCommonPhrasesGroupPartDefinition.m28137a(injectorLike), PulseCommonQuotesGroupPartDefinition.m28153a(injectorLike));
    }

    public final Object m27413a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        SubPartsSelector.a(baseMultiRowSubParts, this.f23770b, feedProps).a(this.f23771c, searchResultsCollectionUnit).a(this.f23772d, searchResultsCollectionUnit).a(this.f23769a, searchResultsCollectionUnit);
        return null;
    }

    @Inject
    public SearchResultsItemsSelectorPartDefinition(SearchResultsItemsGroupPartDefinition searchResultsItemsGroupPartDefinition, SearchResultsMediaGridPartDefinition searchResultsMediaGridPartDefinition, PulseCommonPhrasesGroupPartDefinition pulseCommonPhrasesGroupPartDefinition, PulseCommonQuotesGroupPartDefinition pulseCommonQuotesGroupPartDefinition) {
        this.f23772d = pulseCommonQuotesGroupPartDefinition;
        this.f23771c = pulseCommonPhrasesGroupPartDefinition;
        this.f23770b = searchResultsMediaGridPartDefinition;
        this.f23769a = searchResultsItemsGroupPartDefinition;
    }

    public static SearchResultsItemsSelectorPartDefinition m27411a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsItemsSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23768f) {
                SearchResultsItemsSelectorPartDefinition searchResultsItemsSelectorPartDefinition;
                if (a2 != null) {
                    searchResultsItemsSelectorPartDefinition = (SearchResultsItemsSelectorPartDefinition) a2.a(f23768f);
                } else {
                    searchResultsItemsSelectorPartDefinition = f23767e;
                }
                if (searchResultsItemsSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27412b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23768f, b3);
                        } else {
                            f23767e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsItemsSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27414a(FeedProps<SearchResultsCollectionUnit> feedProps) {
        SearchResultsCollectionUnit searchResultsCollectionUnit = (SearchResultsCollectionUnit) feedProps.a;
        if (searchResultsCollectionUnit.m27154o().equals(Optional.of(GraphQLPhrasesAnalysisItem.class))) {
            return PulseCommonPhrasesGroupPartDefinition.m28138a(searchResultsCollectionUnit);
        }
        if (searchResultsCollectionUnit.m27154o().equals(Optional.of(GraphQLQuotesAnalysisItem.class))) {
            return PulseCommonQuotesGroupPartDefinition.m28154a(searchResultsCollectionUnit);
        }
        return SearchResultsMediaGridPartDefinition.m27420a((FeedProps) feedProps) || this.f23769a.m27409a(searchResultsCollectionUnit);
    }
}
