package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.base.footer.EmptyFooterPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_OVERLAY_DISPLAY_ABORTED */
public class SearchResultsResultsEmptyFooterPartDefinition<T> extends MultiRowSinglePartDefinition<T, Void, HasPositionInformation, View> {
    public static final ViewType f24014a = EmptyFooterPartDefinition.b;
    private static final PaddingStyle f24015b;
    private static SearchResultsResultsEmptyFooterPartDefinition f24016d;
    private static final Object f24017e = new Object();
    private final BackgroundPartDefinition f24018c;

    private static SearchResultsResultsEmptyFooterPartDefinition m27593b(InjectorLike injectorLike) {
        return new SearchResultsResultsEmptyFooterPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27595a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24018c, new StylingData(null, f24015b, Position.BOTTOM));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.c = -4.0f;
        f24015b = a.i();
    }

    @Inject
    public SearchResultsResultsEmptyFooterPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f24018c = backgroundPartDefinition;
    }

    public final boolean m27596a(T t) {
        return true;
    }

    public final ViewType<View> m27594a() {
        return f24014a;
    }

    public static SearchResultsResultsEmptyFooterPartDefinition m27592a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsResultsEmptyFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24017e) {
                SearchResultsResultsEmptyFooterPartDefinition searchResultsResultsEmptyFooterPartDefinition;
                if (a2 != null) {
                    searchResultsResultsEmptyFooterPartDefinition = (SearchResultsResultsEmptyFooterPartDefinition) a2.a(f24017e);
                } else {
                    searchResultsResultsEmptyFooterPartDefinition = f24016d;
                }
                if (searchResultsResultsEmptyFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27593b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24017e, b3);
                        } else {
                            f24016d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsResultsEmptyFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
