package com.facebook.search.results.rows.sections.newscontext;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.search.results.model.SearchResultsNewsTitle;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageCallToActionAutoFillQuery */
public class SearchResultsNewsContextTitlePartDefinition extends MultiRowSinglePartDefinition<SearchResultsNewsTitle, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType<BetterTextView> f24668a = ViewType.a(2130905449);
    private static final PaddingStyle f24669b;
    private static SearchResultsNewsContextTitlePartDefinition f24670e;
    private static final Object f24671f = new Object();
    private final SearchResultsNewsTitlePartDefinition f24672c;
    private final BackgroundPartDefinition f24673d;

    private static SearchResultsNewsContextTitlePartDefinition m28085b(InjectorLike injectorLike) {
        return new SearchResultsNewsContextTitlePartDefinition(SearchResultsNewsTitlePartDefinition.m28090a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28087a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsNewsTitle searchResultsNewsTitle = (SearchResultsNewsTitle) obj;
        Position position = Position.MIDDLE;
        subParts.a(this.f24672c, searchResultsNewsTitle);
        subParts.a(this.f24673d, new StylingData(null, f24669b, position));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = 2.0f;
        a = a;
        a.c = -3.0f;
        f24669b = a.i();
    }

    @Inject
    public SearchResultsNewsContextTitlePartDefinition(SearchResultsNewsTitlePartDefinition searchResultsNewsTitlePartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24672c = searchResultsNewsTitlePartDefinition;
        this.f24673d = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m28086a() {
        return f24668a;
    }

    public final boolean m28088a(Object obj) {
        return true;
    }

    public static SearchResultsNewsContextTitlePartDefinition m28084a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNewsContextTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24671f) {
                SearchResultsNewsContextTitlePartDefinition searchResultsNewsContextTitlePartDefinition;
                if (a2 != null) {
                    searchResultsNewsContextTitlePartDefinition = (SearchResultsNewsContextTitlePartDefinition) a2.a(f24671f);
                } else {
                    searchResultsNewsContextTitlePartDefinition = f24670e;
                }
                if (searchResultsNewsContextTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28085b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24671f, b3);
                        } else {
                            f24670e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNewsContextTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
