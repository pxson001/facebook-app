package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESULTS_KEYWORD */
public class SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsWikiModulePage>, Void, E, BetterTextView> {
    public static final ViewType<BetterTextView> f23680a = ViewType.a(2130903533);
    static final StylingData f23681b = new StylingData(null, f23682c, Position.DIVIDER_BOTTOM_NON_TOP);
    private static final PaddingStyle f23682c;
    private static SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition f23683f;
    private static final Object f23684g = new Object();
    private final BackgroundPartDefinition f23685d;
    private final SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition f23686e;

    private static SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition m27333b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition(SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition.m27313a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27335a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        subParts.a(this.f23685d, f23681b);
        subParts.a(this.f23686e, searchResultsProps);
        return null;
    }

    public final boolean m27336a(Object obj) {
        return ((SearchResultsWikiModulePage) ((SearchResultsProps) obj).f23388a).jl_() != null;
    }

    static {
        Builder a = Builder.a();
        a.b = -12.0f;
        f23682c = a.i();
    }

    @Inject
    public SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition(SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition searchResultsCentralEntityWikiClickBinderConvertedPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23686e = searchResultsCentralEntityWikiClickBinderConvertedPartDefinition;
        this.f23685d = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m27334a() {
        return f23680a;
    }

    public static SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition m27332a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23684g) {
                SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition searchResultsCentralEntityWikiReadMoreConvertedPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiReadMoreConvertedPartDefinition = (SearchResultsCentralEntityWikiReadMoreConvertedPartDefinition) a2.a(f23684g);
                } else {
                    searchResultsCentralEntityWikiReadMoreConvertedPartDefinition = f23683f;
                }
                if (searchResultsCentralEntityWikiReadMoreConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27333b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23684g, b3);
                        } else {
                            f23683f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiReadMoreConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
