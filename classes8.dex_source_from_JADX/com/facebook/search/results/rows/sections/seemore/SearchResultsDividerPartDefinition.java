package com.facebook.search.results.rows.sections.seemore;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.rows.styling.PaddingPartDefinition;
import com.facebook.feed.rows.styling.PaddingPartDefinition.PaddingData;
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
import com.facebook.search.results.rows.sections.common.SearchResultsDividerView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PREVIEW_OPENED */
public class SearchResultsDividerPartDefinition<T> extends MultiRowSinglePartDefinition<T, Void, AnyEnvironment, SearchResultsDividerView> implements HasSpecialStyling {
    public static final ViewType f24968a = ViewType.a(2130907003);
    private static final PaddingStyle f24969b;
    private static SearchResultsDividerPartDefinition f24970d;
    private static final Object f24971e = new Object();
    private final PaddingPartDefinition f24972c;

    private static SearchResultsDividerPartDefinition m28315b(InjectorLike injectorLike) {
        return new SearchResultsDividerPartDefinition(PaddingPartDefinition.a(injectorLike));
    }

    public final Object m28317a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24972c, new PaddingData(null, f24969b, Position.MIDDLE, 0));
        return null;
    }

    static {
        Builder c = Builder.c();
        c.d = 12.0f;
        f24969b = c.i();
    }

    @Inject
    public SearchResultsDividerPartDefinition(PaddingPartDefinition paddingPartDefinition) {
        this.f24972c = paddingPartDefinition;
    }

    public final ViewType m28316a() {
        return f24968a;
    }

    public final SpecialStylingType m28319b() {
        return SpecialStylingType.GAP_PART_DEFINITION;
    }

    public final boolean m28318a(T t) {
        return true;
    }

    public static SearchResultsDividerPartDefinition m28314a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsDividerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24971e) {
                SearchResultsDividerPartDefinition searchResultsDividerPartDefinition;
                if (a2 != null) {
                    searchResultsDividerPartDefinition = (SearchResultsDividerPartDefinition) a2.a(f24971e);
                } else {
                    searchResultsDividerPartDefinition = f24970d;
                }
                if (searchResultsDividerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28315b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24971e, b3);
                        } else {
                            f24970d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsDividerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
