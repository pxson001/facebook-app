package com.facebook.search.results.rows.sections.stories;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.GraphQLStorySelectorPartDefinition;
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
import com.facebook.search.api.SearchQueryFunctions;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.unit.SearchResultsStoryUnit;
import com.facebook.search.results.rows.sections.derp.DerpSuperDenseHeaderNoAttachmentPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POSTS */
public class SearchResultsStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsStoryUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsStoryGroupPartDefinition f25081d;
    private static final Object f25082e = new Object();
    private final SearchResultsStorySnippetPartDefinition f25083a;
    private final GraphQLStorySelectorPartDefinition f25084b;
    private final Lazy<DerpSuperDenseHeaderNoAttachmentPartDefinition<SearchResultsFeedEnvironment>> f25085c;

    private static SearchResultsStoryGroupPartDefinition m28386b(InjectorLike injectorLike) {
        return new SearchResultsStoryGroupPartDefinition(SearchResultsStorySnippetPartDefinition.m28390a(injectorLike), GraphQLStorySelectorPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 10675));
    }

    public final Object m28387a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsFeedEnvironmentGenerated searchResultsFeedEnvironmentGenerated = (SearchResultsFeedEnvironmentGenerated) anyEnvironment;
        baseMultiRowSubParts.a(this.f25083a, feedProps);
        SearchResultsMutableContext s = searchResultsFeedEnvironmentGenerated.mo1248s();
        if (SearchQueryFunctions.a(s.mo1212b()) || (s.m27102v() != null && "news_v2".equals(s.m27102v().mo596l()))) {
            z = true;
        } else {
            z = false;
        }
        SubPartsSelector.a(baseMultiRowSubParts, z, this.f25085c, feedProps).a(this.f25084b, FeedProps.c(((SearchResultsStoryUnit) feedProps.a).mo1333f()));
        return null;
    }

    @Inject
    public SearchResultsStoryGroupPartDefinition(SearchResultsStorySnippetPartDefinition searchResultsStorySnippetPartDefinition, GraphQLStorySelectorPartDefinition graphQLStorySelectorPartDefinition, Lazy<DerpSuperDenseHeaderNoAttachmentPartDefinition> lazy) {
        this.f25083a = searchResultsStorySnippetPartDefinition;
        this.f25084b = graphQLStorySelectorPartDefinition;
        this.f25085c = lazy;
    }

    public final boolean m28388a(Object obj) {
        return true;
    }

    public static SearchResultsStoryGroupPartDefinition m28385a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25082e) {
                SearchResultsStoryGroupPartDefinition searchResultsStoryGroupPartDefinition;
                if (a2 != null) {
                    searchResultsStoryGroupPartDefinition = (SearchResultsStoryGroupPartDefinition) a2.a(f25082e);
                } else {
                    searchResultsStoryGroupPartDefinition = f25081d;
                }
                if (searchResultsStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28386b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25082e, b3);
                        } else {
                            f25081d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
