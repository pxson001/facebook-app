package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_OVERLAY_DISPLAYED */
public class SearchResultsResultsEmptyHeaderPartDefinition<T> extends SearchResultsEmptyPartDefinition<T> {
    private static final PaddingStyle f24019b;
    private static SearchResultsResultsEmptyHeaderPartDefinition f24020d;
    private static final Object f24021e = new Object();
    private final BackgroundPartDefinition f24022c;

    private static SearchResultsResultsEmptyHeaderPartDefinition m27598b(InjectorLike injectorLike) {
        return new SearchResultsResultsEmptyHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27599a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24022c, new StylingData(null, f24019b, Position.TOP));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.c = 6.0f;
        f24019b = a.i();
    }

    @Inject
    public SearchResultsResultsEmptyHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f24022c = backgroundPartDefinition;
    }

    public static SearchResultsResultsEmptyHeaderPartDefinition m27597a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsResultsEmptyHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24021e) {
                SearchResultsResultsEmptyHeaderPartDefinition searchResultsResultsEmptyHeaderPartDefinition;
                if (a2 != null) {
                    searchResultsResultsEmptyHeaderPartDefinition = (SearchResultsResultsEmptyHeaderPartDefinition) a2.a(f24021e);
                } else {
                    searchResultsResultsEmptyHeaderPartDefinition = f24020d;
                }
                if (searchResultsResultsEmptyHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27598b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24021e, b3);
                        } else {
                            f24020d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsResultsEmptyHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
