package com.facebook.search.typeahead.rows;

import android.content.Context;
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
import com.facebook.multirow.api.ViewType;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.widget.text.BetterTextView;

@ContextScoped
/* compiled from: validation_messages */
public class UnsupportedSearchTypeaheadPartDefinition extends MultiRowSinglePartDefinition<TypeaheadUnit, Void, AnyEnvironment, BetterTextView> {
    public static final ViewType f637a = new C00571();
    private static UnsupportedSearchTypeaheadPartDefinition f638b;
    private static final Object f639c = new Object();

    /* compiled from: validation_messages */
    final class C00571 extends ViewType {
        C00571() {
        }

        public final View m733a(Context context) {
            return new BetterTextView(context);
        }
    }

    private static UnsupportedSearchTypeaheadPartDefinition m735c() {
        return new UnsupportedSearchTypeaheadPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m737a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -763721193);
        TypeaheadUnit typeaheadUnit = (TypeaheadUnit) obj;
        BetterTextView betterTextView = (BetterTextView) view;
        betterTextView.setGravity(17);
        betterTextView.setText(typeaheadUnit.getClass().getSimpleName());
        Logger.a(8, EntryType.MARK_POP, -778215246, a);
    }

    public final ViewType m736a() {
        return f637a;
    }

    public final boolean m738a(Object obj) {
        return true;
    }

    public static UnsupportedSearchTypeaheadPartDefinition m734a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnsupportedSearchTypeaheadPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f639c) {
                UnsupportedSearchTypeaheadPartDefinition unsupportedSearchTypeaheadPartDefinition;
                if (a2 != null) {
                    unsupportedSearchTypeaheadPartDefinition = (UnsupportedSearchTypeaheadPartDefinition) a2.a(f639c);
                } else {
                    unsupportedSearchTypeaheadPartDefinition = f638b;
                }
                if (unsupportedSearchTypeaheadPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m735c();
                        if (a2 != null) {
                            a2.a(f639c, c);
                        } else {
                            f638b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = unsupportedSearchTypeaheadPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
