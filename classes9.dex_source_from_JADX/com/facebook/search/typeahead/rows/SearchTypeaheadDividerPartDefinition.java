package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.suggestions.model.DividerTypeaheadUnit;

@ContextScoped
/* compiled from: videoChannelId cannot be null */
public class SearchTypeaheadDividerPartDefinition extends MultiRowSinglePartDefinition<DividerTypeaheadUnit, Void, AnyEnvironment, View> {
    public static final ViewType f468a = new C00451();
    private static SearchTypeaheadDividerPartDefinition f469b;
    private static final Object f470c = new Object();

    /* compiled from: videoChannelId cannot be null */
    final class C00451 extends ViewType {
        C00451() {
        }

        public final View m572a(Context context) {
            return LayoutInflater.from(context).inflate(2130907571, null);
        }
    }

    private static SearchTypeaheadDividerPartDefinition m574c() {
        return new SearchTypeaheadDividerPartDefinition();
    }

    public final ViewType m575a() {
        return f468a;
    }

    public final boolean m576a(Object obj) {
        return true;
    }

    public static SearchTypeaheadDividerPartDefinition m573a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadDividerPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f470c) {
                SearchTypeaheadDividerPartDefinition searchTypeaheadDividerPartDefinition;
                if (a2 != null) {
                    searchTypeaheadDividerPartDefinition = (SearchTypeaheadDividerPartDefinition) a2.a(f470c);
                } else {
                    searchTypeaheadDividerPartDefinition = f469b;
                }
                if (searchTypeaheadDividerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m574c();
                        if (a2 != null) {
                            a2.a(f470c, c);
                        } else {
                            f469b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = searchTypeaheadDividerPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
