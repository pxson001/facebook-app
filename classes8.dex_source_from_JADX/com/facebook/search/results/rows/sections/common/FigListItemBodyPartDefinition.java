package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fig.listitem.FigListItem;
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

@ContextScoped
/* compiled from: REACTION_UNIT_IMPRESSION */
public class FigListItemBodyPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, FigListItem> {
    private static FigListItemBodyPartDefinition f23984a;
    private static final Object f23985b = new Object();

    private static FigListItemBodyPartDefinition m27559a() {
        return new FigListItemBodyPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m27561a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1228543391);
        ((FigListItem) view).setBodyText((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, -612078649, a);
    }

    public static FigListItemBodyPartDefinition m27560a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FigListItemBodyPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23985b) {
                FigListItemBodyPartDefinition figListItemBodyPartDefinition;
                if (a3 != null) {
                    figListItemBodyPartDefinition = (FigListItemBodyPartDefinition) a3.a(f23985b);
                } else {
                    figListItemBodyPartDefinition = f23984a;
                }
                if (figListItemBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m27559a();
                        if (a3 != null) {
                            a3.a(f23985b, a2);
                        } else {
                            f23984a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = figListItemBodyPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
