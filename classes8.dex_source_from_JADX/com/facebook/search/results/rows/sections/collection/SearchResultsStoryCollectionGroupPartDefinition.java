package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.GraphQLStorySelectorPartDefinition;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.rows.sections.derp.DerpSuperDenseStoryPartDefinition;
import com.facebook.search.results.rows.sections.livefeed.LiveFeedCompactStoryPartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RENDER */
public class SearchResultsStoryCollectionGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<GraphQLStory>>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsStoryCollectionGroupPartDefinition f23850g;
    private static final Object f23851h = new Object();
    private final Lazy<LiveFeedCompactStoryPartDefinition> f23852a;
    private final Lazy<DerpSuperDenseStoryPartDefinition> f23853b;
    private final Lazy<GraphQLStorySelectorPartDefinition> f23854c;
    private final SearchResultsCollectionHeaderPartDefinition f23855d;
    private final SearchResultsFooterPartDefinition f23856e;
    private final QeAccessor f23857f;

    private static SearchResultsStoryCollectionGroupPartDefinition m27464b(InjectorLike injectorLike) {
        return new SearchResultsStoryCollectionGroupPartDefinition(IdBasedLazy.a(injectorLike, 10724), IdBasedLazy.a(injectorLike, 10677), IdBasedLazy.a(injectorLike, 1505), SearchResultsCollectionHeaderPartDefinition.m27379a(injectorLike), SearchResultsFooterPartDefinition.m27396a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m27465a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        boolean z2 = true;
        int i = 0;
        if (((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.LIVE_CONVERSATION_MODULE) {
            z = true;
        } else {
            z = false;
        }
        baseMultiRowSubParts.a(this.f23855d, feedProps);
        if (!(((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.POSTS && this.f23857f.a(ExperimentsForSearchAbTestModule.m, false))) {
            z2 = false;
        }
        ImmutableList immutableList = ((SearchResultsCollectionUnit) feedProps.a).f23463d;
        int size = immutableList.size();
        while (i < size) {
            FeedProps c = FeedProps.c((GraphQLStory) immutableList.get(i));
            SubPartsSelector.a(baseMultiRowSubParts, z, this.f23852a, c).a(z2, this.f23853b, c).a(this.f23854c, c);
            i++;
        }
        baseMultiRowSubParts.a(this.f23856e, feedProps);
        return null;
    }

    public final boolean m27466a(Object obj) {
        return !((SearchResultsCollectionUnit) ((FeedProps) obj).a).f23463d.isEmpty();
    }

    @Inject
    public SearchResultsStoryCollectionGroupPartDefinition(Lazy<LiveFeedCompactStoryPartDefinition> lazy, Lazy<DerpSuperDenseStoryPartDefinition> lazy2, Lazy<GraphQLStorySelectorPartDefinition> lazy3, SearchResultsCollectionHeaderPartDefinition searchResultsCollectionHeaderPartDefinition, SearchResultsFooterPartDefinition searchResultsFooterPartDefinition, QeAccessor qeAccessor) {
        this.f23852a = lazy;
        this.f23853b = lazy2;
        this.f23854c = lazy3;
        this.f23855d = searchResultsCollectionHeaderPartDefinition;
        this.f23856e = searchResultsFooterPartDefinition;
        this.f23857f = qeAccessor;
    }

    public static SearchResultsStoryCollectionGroupPartDefinition m27463a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsStoryCollectionGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23851h) {
                SearchResultsStoryCollectionGroupPartDefinition searchResultsStoryCollectionGroupPartDefinition;
                if (a2 != null) {
                    searchResultsStoryCollectionGroupPartDefinition = (SearchResultsStoryCollectionGroupPartDefinition) a2.a(f23851h);
                } else {
                    searchResultsStoryCollectionGroupPartDefinition = f23850g;
                }
                if (searchResultsStoryCollectionGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27464b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23851h, b3);
                        } else {
                            f23850g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsStoryCollectionGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
