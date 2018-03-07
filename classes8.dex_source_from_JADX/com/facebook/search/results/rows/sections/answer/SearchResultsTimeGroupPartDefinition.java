package com.facebook.search.results.rows.sections.answer;

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
import com.facebook.search.results.model.unit.answer.SearchResultsTimeUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RFMCard */
public class SearchResultsTimeGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsTimeUnit>, Void, SearchResultsFeedEnvironment> {
    private static SearchResultsTimeGroupPartDefinition f23605c;
    private static final Object f23606d = new Object();
    private final SearchResultsTimeHeaderPartDefinition f23607a;
    private final SearchResultsTimeTextPartDefinition f23608b;

    private static SearchResultsTimeGroupPartDefinition m27269b(InjectorLike injectorLike) {
        return new SearchResultsTimeGroupPartDefinition(SearchResultsTimeHeaderPartDefinition.m27273a(injectorLike), SearchResultsTimeTextPartDefinition.m27280a(injectorLike));
    }

    public final Object m27270a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f23607a, feedProps);
        baseMultiRowSubParts.a(this.f23608b, feedProps);
        return null;
    }

    @Inject
    public SearchResultsTimeGroupPartDefinition(SearchResultsTimeHeaderPartDefinition searchResultsTimeHeaderPartDefinition, SearchResultsTimeTextPartDefinition searchResultsTimeTextPartDefinition) {
        this.f23607a = searchResultsTimeHeaderPartDefinition;
        this.f23608b = searchResultsTimeTextPartDefinition;
    }

    public final boolean m27271a(Object obj) {
        return true;
    }

    public static SearchResultsTimeGroupPartDefinition m27268a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTimeGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23606d) {
                SearchResultsTimeGroupPartDefinition searchResultsTimeGroupPartDefinition;
                if (a2 != null) {
                    searchResultsTimeGroupPartDefinition = (SearchResultsTimeGroupPartDefinition) a2.a(f23606d);
                } else {
                    searchResultsTimeGroupPartDefinition = f23605c;
                }
                if (searchResultsTimeGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27269b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23606d, b3);
                        } else {
                            f23605c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTimeGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
