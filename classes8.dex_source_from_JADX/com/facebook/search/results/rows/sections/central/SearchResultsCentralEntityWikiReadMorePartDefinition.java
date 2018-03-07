package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RESULTS_FILTER */
public class SearchResultsCentralEntityWikiReadMorePartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCentralWikiUnit>, Void, E, BetterTextView> {
    private static SearchResultsCentralEntityWikiReadMorePartDefinition f23687c;
    private static final Object f23688d = new Object();
    private final BackgroundPartDefinition f23689a;
    private final SearchResultsCentralEntityWikiClickBinderPartDefinition f23690b;

    private static SearchResultsCentralEntityWikiReadMorePartDefinition m27338b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiReadMorePartDefinition(SearchResultsCentralEntityWikiClickBinderPartDefinition.m27318a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27340a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsCentralWikiUnit searchResultsCentralWikiUnit = (SearchResultsCentralWikiUnit) ((FeedProps) obj).a;
        subParts.a(this.f23689a, SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition.f23681b);
        subParts.a(this.f23690b, searchResultsCentralWikiUnit);
        return null;
    }

    public final boolean m27341a(Object obj) {
        return ((SearchResultsCentralWikiUnit) ((FeedProps) obj).a).m27145m() != null;
    }

    @Inject
    public SearchResultsCentralEntityWikiReadMorePartDefinition(SearchResultsCentralEntityWikiClickBinderPartDefinition searchResultsCentralEntityWikiClickBinderPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23690b = searchResultsCentralEntityWikiClickBinderPartDefinition;
        this.f23689a = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m27339a() {
        return SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition.f23680a;
    }

    public static SearchResultsCentralEntityWikiReadMorePartDefinition m27337a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiReadMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23688d) {
                SearchResultsCentralEntityWikiReadMorePartDefinition searchResultsCentralEntityWikiReadMorePartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiReadMorePartDefinition = (SearchResultsCentralEntityWikiReadMorePartDefinition) a2.a(f23688d);
                } else {
                    searchResultsCentralEntityWikiReadMorePartDefinition = f23687c;
                }
                if (searchResultsCentralEntityWikiReadMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27338b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23688d, b3);
                        } else {
                            f23687c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiReadMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
