package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.search.model.TypeaheadTitleModel;
import com.facebook.widget.text.BetterTextView;

@ContextScoped
/* compiled from: value cannot be null */
public class SearchTypeaheadTitlePartDefinition extends BaseSinglePartDefinition<TypeaheadTitleModel, Void, AnyEnvironment, BetterTextView> {
    private static SearchTypeaheadTitlePartDefinition f635a;
    private static final Object f636b = new Object();

    private static SearchTypeaheadTitlePartDefinition m730a() {
        return new SearchTypeaheadTitlePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m732a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 469264520);
        ((BetterTextView) view).setText(((TypeaheadTitleModel) obj).a);
        Logger.a(8, EntryType.MARK_POP, 18847584, a);
    }

    public static SearchTypeaheadTitlePartDefinition m731a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadTitlePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f636b) {
                SearchTypeaheadTitlePartDefinition searchTypeaheadTitlePartDefinition;
                if (a3 != null) {
                    searchTypeaheadTitlePartDefinition = (SearchTypeaheadTitlePartDefinition) a3.a(f636b);
                } else {
                    searchTypeaheadTitlePartDefinition = f635a;
                }
                if (searchTypeaheadTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m730a();
                        if (a3 != null) {
                            a3.a(f636b, a2);
                        } else {
                            f635a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = searchTypeaheadTitlePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
