package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.GapTypeaheadUnit;
import com.facebook.search.model.GapTypeaheadUnit.BackgroundType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: verification_type */
public class SearchTypeaheadGapPartDefinition extends MultiRowSinglePartDefinition<GapTypeaheadUnit, Drawable, AnyEnvironment, View> {
    public static ViewType f527a = ViewType.a(2130907573);
    private static SearchTypeaheadGapPartDefinition f528c;
    private static final Object f529d = new Object();
    private final Context f530b;

    private static SearchTypeaheadGapPartDefinition m626b(InjectorLike injectorLike) {
        return new SearchTypeaheadGapPartDefinition((Context) injectorLike.getInstance(Context.class));
    }

    public final Object m628a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return ((GapTypeaheadUnit) obj).a == BackgroundType.GRAY ? new ColorDrawable(ContextCompat.b(this.f530b, 2131362148)) : new ColorDrawable(0);
    }

    public final /* bridge */ /* synthetic */ void m629a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 317001597);
        view.setBackgroundDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, 1550734651, a);
    }

    @Inject
    public SearchTypeaheadGapPartDefinition(Context context) {
        this.f530b = context;
    }

    public final ViewType<View> m627a() {
        return f527a;
    }

    public final boolean m630a(Object obj) {
        return true;
    }

    public static SearchTypeaheadGapPartDefinition m625a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadGapPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f529d) {
                SearchTypeaheadGapPartDefinition searchTypeaheadGapPartDefinition;
                if (a2 != null) {
                    searchTypeaheadGapPartDefinition = (SearchTypeaheadGapPartDefinition) a2.a(f529d);
                } else {
                    searchTypeaheadGapPartDefinition = f528c;
                }
                if (searchTypeaheadGapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m626b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f529d, b3);
                        } else {
                            f528c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadGapPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
