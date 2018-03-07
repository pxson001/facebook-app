package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESPOND_TO_FRIEND_REQUEST_TASK */
public class SearchResultsCentralEntityWikiTitleConvertedPartDefinition extends MultiRowSinglePartDefinition<SearchResultsWikiModulePage, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType<BetterTextView> f23695a = SearchResultsCommonViewTypes.f24004b;
    private static SearchResultsCentralEntityWikiTitleConvertedPartDefinition f23696d;
    private static final Object f23697e = new Object();
    private final BackgroundPartDefinition f23698b;
    private final TextPartDefinition f23699c;

    private static SearchResultsCentralEntityWikiTitleConvertedPartDefinition m27351b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiTitleConvertedPartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m27353a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsWikiModulePage searchResultsWikiModulePage = (SearchResultsWikiModulePage) obj;
        subParts.a(this.f23698b, m27350b(searchResultsWikiModulePage.jl_()));
        subParts.a(this.f23699c, searchResultsWikiModulePage.mo573D());
        return null;
    }

    @Inject
    public SearchResultsCentralEntityWikiTitleConvertedPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition) {
        this.f23698b = backgroundPartDefinition;
        this.f23699c = textPartDefinition;
    }

    public final ViewType<BetterTextView> m27352a() {
        return f23695a;
    }

    public static SearchResultsCentralEntityWikiTitleConvertedPartDefinition m27349a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiTitleConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23697e) {
                SearchResultsCentralEntityWikiTitleConvertedPartDefinition searchResultsCentralEntityWikiTitleConvertedPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiTitleConvertedPartDefinition = (SearchResultsCentralEntityWikiTitleConvertedPartDefinition) a2.a(f23697e);
                } else {
                    searchResultsCentralEntityWikiTitleConvertedPartDefinition = f23696d;
                }
                if (searchResultsCentralEntityWikiTitleConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27351b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23697e, b3);
                        } else {
                            f23696d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiTitleConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27354a(Object obj) {
        return true;
    }

    static <T> StylingData m27350b(T t) {
        return new StylingData(null, PaddingStyle.a, t == null ? Position.DIVIDER_BOTTOM_NON_TOP : Position.MIDDLE);
    }
}
