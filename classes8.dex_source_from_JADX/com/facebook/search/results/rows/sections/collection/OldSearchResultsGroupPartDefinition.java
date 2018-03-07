package com.facebook.search.results.rows.sections.collection;

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
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RESIDENCE */
public class OldSearchResultsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit>, Void, SearchResultsFeedEnvironment> {
    private static OldSearchResultsGroupPartDefinition f23704d;
    private static final Object f23705e = new Object();
    private final SearchResultsItemsSelectorPartDefinition f23706a;
    private final SearchResultsFooterPartDefinition f23707b;
    private final SearchResultsCollectionHeaderPartDefinition f23708c;

    private static OldSearchResultsGroupPartDefinition m27361b(InjectorLike injectorLike) {
        return new OldSearchResultsGroupPartDefinition(SearchResultsCollectionHeaderPartDefinition.m27379a(injectorLike), SearchResultsItemsSelectorPartDefinition.m27411a(injectorLike), SearchResultsFooterPartDefinition.m27396a(injectorLike));
    }

    public final Object m27362a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f23708c, feedProps);
        baseMultiRowSubParts.a(this.f23706a, feedProps);
        baseMultiRowSubParts.a(this.f23707b, feedProps);
        return null;
    }

    public final boolean m27363a(Object obj) {
        return this.f23706a.m27414a((FeedProps) obj);
    }

    @Inject
    public OldSearchResultsGroupPartDefinition(SearchResultsCollectionHeaderPartDefinition searchResultsCollectionHeaderPartDefinition, SearchResultsItemsSelectorPartDefinition searchResultsItemsSelectorPartDefinition, SearchResultsFooterPartDefinition searchResultsFooterPartDefinition) {
        this.f23706a = searchResultsItemsSelectorPartDefinition;
        this.f23707b = searchResultsFooterPartDefinition;
        this.f23708c = searchResultsCollectionHeaderPartDefinition;
    }

    public static OldSearchResultsGroupPartDefinition m27360a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OldSearchResultsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23705e) {
                OldSearchResultsGroupPartDefinition oldSearchResultsGroupPartDefinition;
                if (a2 != null) {
                    oldSearchResultsGroupPartDefinition = (OldSearchResultsGroupPartDefinition) a2.a(f23705e);
                } else {
                    oldSearchResultsGroupPartDefinition = f23704d;
                }
                if (oldSearchResultsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27361b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23705e, b3);
                        } else {
                            f23704d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = oldSearchResultsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
