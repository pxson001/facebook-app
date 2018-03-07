package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
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
import com.facebook.search.results.rows.sections.common.SearchResultsResultsEmptyHeaderPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESEND_CODE_ATTEMPT */
public class SearchResultsCollectionHeaderPartDefinition<T> extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<T>>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsCollectionHeaderPartDefinition f23736c;
    private static final Object f23737d = new Object();
    private final SearchResultsResultsEmptyHeaderPartDefinition f23738a;
    private final SearchResultsCollectionTitlePartDefinition<T> f23739b;

    private static SearchResultsCollectionHeaderPartDefinition m27380b(InjectorLike injectorLike) {
        return new SearchResultsCollectionHeaderPartDefinition(SearchResultsCollectionTitlePartDefinition.m27383a(injectorLike), SearchResultsResultsEmptyHeaderPartDefinition.m27597a(injectorLike));
    }

    public final Object m27381a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f23739b, feedProps).a(this.f23738a, feedProps.a);
        return null;
    }

    public final boolean m27382a(Object obj) {
        return ((SearchResultsCollectionUnit) ((FeedProps) obj).a).mo1321k() != GraphQLGraphSearchResultRole.PROMOTED_ENTITY_MEDIA;
    }

    @Inject
    public SearchResultsCollectionHeaderPartDefinition(SearchResultsCollectionTitlePartDefinition searchResultsCollectionTitlePartDefinition, SearchResultsResultsEmptyHeaderPartDefinition searchResultsResultsEmptyHeaderPartDefinition) {
        this.f23738a = searchResultsResultsEmptyHeaderPartDefinition;
        this.f23739b = searchResultsCollectionTitlePartDefinition;
    }

    public static SearchResultsCollectionHeaderPartDefinition m27379a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCollectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23737d) {
                SearchResultsCollectionHeaderPartDefinition searchResultsCollectionHeaderPartDefinition;
                if (a2 != null) {
                    searchResultsCollectionHeaderPartDefinition = (SearchResultsCollectionHeaderPartDefinition) a2.a(f23737d);
                } else {
                    searchResultsCollectionHeaderPartDefinition = f23736c;
                }
                if (searchResultsCollectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27380b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23737d, b3);
                        } else {
                            f23736c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCollectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
