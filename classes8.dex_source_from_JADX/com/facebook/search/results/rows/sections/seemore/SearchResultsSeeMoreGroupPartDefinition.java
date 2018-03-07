package com.facebook.search.results.rows.sections.seemore;

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
import com.facebook.search.results.model.unit.SearchResultsSeeMorePostsUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PREVIEW_DATA_AVAILABLE */
public class SearchResultsSeeMoreGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsSeeMorePostsUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsSeeMoreGroupPartDefinition f24973d;
    private static final Object f24974e = new Object();
    private final SearchResultsDividerPartDefinition f24975a;
    private final SearchResultsSeeMorePostsPartDefinition f24976b;
    private final SearchResultsSeeMoreTrendingPostsPartDefinition f24977c;

    private static SearchResultsSeeMoreGroupPartDefinition m28321b(InjectorLike injectorLike) {
        return new SearchResultsSeeMoreGroupPartDefinition(SearchResultsSeeMorePostsPartDefinition.m28325a(injectorLike), SearchResultsSeeMoreTrendingPostsPartDefinition.m28338a(injectorLike), SearchResultsDividerPartDefinition.m28314a(injectorLike));
    }

    public final Object m28322a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f24977c, feedProps.a).a(this.f24976b, feedProps.a);
        baseMultiRowSubParts.a(this.f24975a, feedProps.a);
        return null;
    }

    @Inject
    public SearchResultsSeeMoreGroupPartDefinition(SearchResultsSeeMorePostsPartDefinition searchResultsSeeMorePostsPartDefinition, SearchResultsSeeMoreTrendingPostsPartDefinition searchResultsSeeMoreTrendingPostsPartDefinition, SearchResultsDividerPartDefinition searchResultsDividerPartDefinition) {
        this.f24975a = searchResultsDividerPartDefinition;
        this.f24976b = searchResultsSeeMorePostsPartDefinition;
        this.f24977c = searchResultsSeeMoreTrendingPostsPartDefinition;
    }

    public final boolean m28323a(Object obj) {
        return true;
    }

    public static SearchResultsSeeMoreGroupPartDefinition m28320a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSeeMoreGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24974e) {
                SearchResultsSeeMoreGroupPartDefinition searchResultsSeeMoreGroupPartDefinition;
                if (a2 != null) {
                    searchResultsSeeMoreGroupPartDefinition = (SearchResultsSeeMoreGroupPartDefinition) a2.a(f24974e);
                } else {
                    searchResultsSeeMoreGroupPartDefinition = f24973d;
                }
                if (searchResultsSeeMoreGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28321b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24974e, b3);
                        } else {
                            f24973d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSeeMoreGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
