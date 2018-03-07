package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
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
import com.facebook.widget.CustomLinearLayout;
import java.text.NumberFormat;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_SCROLLED_TO_BOTTOM */
public class SearchResultsAnnotationWithPostCountPartDefinition extends MultiRowSinglePartDefinition<SearchResultsAnnotationUnit, Void, AnyEnvironment, CustomLinearLayout> implements HasSpecialStyling {
    public static final ViewType f23996a = new C25541();
    private static final PaddingStyle f23997b;
    private static SearchResultsAnnotationWithPostCountPartDefinition f23998f;
    private static final Object f23999g = new Object();
    private final Resources f24000c;
    private final PaddingPartDefinition f24001d;
    private final TextPartDefinition f24002e;

    /* compiled from: REACTION_SCROLLED_TO_BOTTOM */
    final class C25541 extends ViewType {
        C25541() {
        }

        public final View m27573a(Context context) {
            return LayoutInflater.from(context).inflate(2130903255, null);
        }
    }

    private static SearchResultsAnnotationWithPostCountPartDefinition m27576b(InjectorLike injectorLike) {
        return new SearchResultsAnnotationWithPostCountPartDefinition(PaddingPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m27578a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsAnnotationUnit searchResultsAnnotationUnit = (SearchResultsAnnotationUnit) obj;
        subParts.a(2131559597, this.f24002e, searchResultsAnnotationUnit.f23450a);
        subParts.a(2131559598, this.f24002e, m27575a(searchResultsAnnotationUnit.f23451b));
        subParts.a(this.f24001d, new PaddingData(searchResultsAnnotationUnit, f23997b, Position.TOP, 0));
        return null;
    }

    public final boolean m27579a(Object obj) {
        return ((SearchResultsAnnotationUnit) obj).f23451b > 0;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = -4.0f;
        f23997b = a.i();
    }

    @Inject
    public SearchResultsAnnotationWithPostCountPartDefinition(PaddingPartDefinition paddingPartDefinition, TextPartDefinition textPartDefinition, Resources resources) {
        this.f24001d = paddingPartDefinition;
        this.f24002e = textPartDefinition;
        this.f24000c = resources;
    }

    public static SearchResultsAnnotationWithPostCountPartDefinition m27574a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsAnnotationWithPostCountPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23999g) {
                SearchResultsAnnotationWithPostCountPartDefinition searchResultsAnnotationWithPostCountPartDefinition;
                if (a2 != null) {
                    searchResultsAnnotationWithPostCountPartDefinition = (SearchResultsAnnotationWithPostCountPartDefinition) a2.a(f23999g);
                } else {
                    searchResultsAnnotationWithPostCountPartDefinition = f23998f;
                }
                if (searchResultsAnnotationWithPostCountPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27576b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23999g, b3);
                        } else {
                            f23998f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsAnnotationWithPostCountPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m27577a() {
        return f23996a;
    }

    public final SpecialStylingType m27580b() {
        return SpecialStylingType.GAP_PART_DEFINITION;
    }

    private String m27575a(int i) {
        return StringFormatUtil.formatStrLocaleSafe(this.f24000c.getString(2131239061, new Object[]{NumberFormat.getNumberInstance().format((long) i)}));
    }
}
