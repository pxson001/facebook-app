package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsAnnotationUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_SURFACE_TAG must be a (non-null) Surface instance */
public class SearchResultsAnnotationPartDefinition extends MultiRowSinglePartDefinition<SearchResultsAnnotationUnit, Void, AnyEnvironment, BetterTextView> implements HasSpecialStyling {
    public static final ViewType f23986a = new C25531();
    private static final PaddingStyle f23987b;
    private static SearchResultsAnnotationPartDefinition f23988e;
    private static final Object f23989f = new Object();
    private final PaddingPartDefinition f23990c;
    private final TextPartDefinition f23991d;

    /* compiled from: REACTION_SURFACE_TAG must be a (non-null) Surface instance */
    final class C25531 extends ViewType {
        C25531() {
        }

        public final View m27562a(Context context) {
            return LayoutInflater.from(context).inflate(2130903254, null);
        }
    }

    private static SearchResultsAnnotationPartDefinition m27564b(InjectorLike injectorLike) {
        return new SearchResultsAnnotationPartDefinition(PaddingPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m27566a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsAnnotationUnit searchResultsAnnotationUnit = (SearchResultsAnnotationUnit) obj;
        subParts.a(this.f23991d, searchResultsAnnotationUnit.f23450a);
        subParts.a(this.f23990c, new PaddingData(searchResultsAnnotationUnit, f23987b, Position.TOP, 0));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = -4.0f;
        f23987b = a.i();
    }

    @Inject
    public SearchResultsAnnotationPartDefinition(PaddingPartDefinition paddingPartDefinition, TextPartDefinition textPartDefinition) {
        this.f23990c = paddingPartDefinition;
        this.f23991d = textPartDefinition;
    }

    public static SearchResultsAnnotationPartDefinition m27563a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsAnnotationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23989f) {
                SearchResultsAnnotationPartDefinition searchResultsAnnotationPartDefinition;
                if (a2 != null) {
                    searchResultsAnnotationPartDefinition = (SearchResultsAnnotationPartDefinition) a2.a(f23989f);
                } else {
                    searchResultsAnnotationPartDefinition = f23988e;
                }
                if (searchResultsAnnotationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27564b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23989f, b3);
                        } else {
                            f23988e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsAnnotationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m27565a() {
        return f23986a;
    }

    public final SpecialStylingType m27568b() {
        return SpecialStylingType.GAP_PART_DEFINITION;
    }

    public final boolean m27567a(Object obj) {
        return true;
    }
}
