package com.facebook.search.results.rows.sections.central;

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
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RESULTS_KEYWORD_TABS */
public class SearchResultsCentralEntityWikiGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCentralWikiUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsCentralEntityWikiGroupPartDefinition f23675d;
    private static final Object f23676e = new Object();
    private final SearchResultsCentralEntityWikiTitlePartDefinition f23677a;
    private final SearchResultsCentralEntityWikiAboutTextPartDefinition f23678b;
    private final SearchResultsCentralEntityWikiReadMorePartDefinition f23679c;

    private static SearchResultsCentralEntityWikiGroupPartDefinition m27329b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiGroupPartDefinition(SearchResultsCentralEntityWikiTitlePartDefinition.m27355a(injectorLike), SearchResultsCentralEntityWikiAboutTextPartDefinition.m27306a(injectorLike), SearchResultsCentralEntityWikiReadMorePartDefinition.m27337a(injectorLike));
    }

    public final Object m27330a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsCentralWikiUnit searchResultsCentralWikiUnit = (SearchResultsCentralWikiUnit) feedProps.a;
        SearchResultsCentralEntityWikiState searchResultsCentralEntityWikiState = (SearchResultsCentralEntityWikiState) ((SearchResultsFeedEnvironmentGenerated) anyEnvironment).a(SearchResultsCentralEntityWikiState.m27346a(searchResultsCentralWikiUnit), searchResultsCentralWikiUnit);
        if (searchResultsCentralWikiUnit.m27145m() == null || searchResultsCentralWikiUnit.m27145m().length() <= 150) {
            searchResultsCentralEntityWikiState.f23694b = false;
            searchResultsCentralEntityWikiState.f23693a = false;
        }
        baseMultiRowSubParts.a(this.f23677a, feedProps);
        baseMultiRowSubParts.a(this.f23678b, feedProps);
        if (searchResultsCentralEntityWikiState.m27348a()) {
            baseMultiRowSubParts.a(this.f23679c, feedProps);
        }
        return null;
    }

    @Inject
    public SearchResultsCentralEntityWikiGroupPartDefinition(SearchResultsCentralEntityWikiTitlePartDefinition searchResultsCentralEntityWikiTitlePartDefinition, SearchResultsCentralEntityWikiAboutTextPartDefinition searchResultsCentralEntityWikiAboutTextPartDefinition, SearchResultsCentralEntityWikiReadMorePartDefinition searchResultsCentralEntityWikiReadMorePartDefinition) {
        this.f23677a = searchResultsCentralEntityWikiTitlePartDefinition;
        this.f23678b = searchResultsCentralEntityWikiAboutTextPartDefinition;
        this.f23679c = searchResultsCentralEntityWikiReadMorePartDefinition;
    }

    public static SearchResultsCentralEntityWikiGroupPartDefinition m27328a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23676e) {
                SearchResultsCentralEntityWikiGroupPartDefinition searchResultsCentralEntityWikiGroupPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiGroupPartDefinition = (SearchResultsCentralEntityWikiGroupPartDefinition) a2.a(f23676e);
                } else {
                    searchResultsCentralEntityWikiGroupPartDefinition = f23675d;
                }
                if (searchResultsCentralEntityWikiGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27329b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23676e, b3);
                        } else {
                            f23675d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27331a(Object obj) {
        return true;
    }
}
