package com.facebook.search.typeahead.rows.nullstate;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;

@ContextScoped
/* compiled from: validateOnly */
public class NullStateModuleItemClickPartDefinition extends BaseSinglePartDefinition<NullStateModuleSuggestionUnit, OnClickListener, SearchSuggestionsEnvironment, View> {
    private static NullStateModuleItemClickPartDefinition f652a;
    private static final Object f653b = new Object();

    private static NullStateModuleItemClickPartDefinition m748a() {
        return new NullStateModuleItemClickPartDefinition();
    }

    public final Object m750a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit = (NullStateModuleSuggestionUnit) obj;
        final SearchSuggestionsEnvironment searchSuggestionsEnvironment = (SearchSuggestionsEnvironment) anyEnvironment;
        return new OnClickListener(this) {
            final /* synthetic */ NullStateModuleItemClickPartDefinition f651c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1456395874);
                searchSuggestionsEnvironment.m206a(nullStateModuleSuggestionUnit);
                nullStateModuleSuggestionUnit.n = true;
                Logger.a(2, EntryType.UI_INPUT_END, 1877542035, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m751a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1894523078);
        view.setOnClickListener((OnClickListener) obj2);
        Logger.a(8, EntryType.MARK_POP, 519018792, a);
    }

    public final void m752b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }

    public static NullStateModuleItemClickPartDefinition m749a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateModuleItemClickPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f653b) {
                NullStateModuleItemClickPartDefinition nullStateModuleItemClickPartDefinition;
                if (a3 != null) {
                    nullStateModuleItemClickPartDefinition = (NullStateModuleItemClickPartDefinition) a3.a(f653b);
                } else {
                    nullStateModuleItemClickPartDefinition = f652a;
                }
                if (nullStateModuleItemClickPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m748a();
                        if (a3 != null) {
                            a3.a(f653b, a2);
                        } else {
                            f652a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = nullStateModuleItemClickPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
