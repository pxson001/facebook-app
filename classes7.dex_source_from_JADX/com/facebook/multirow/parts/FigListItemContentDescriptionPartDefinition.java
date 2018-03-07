package com.facebook.multirow.parts;

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
/* compiled from: num_questions */
public class FigListItemContentDescriptionPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, FigListItem> {
    private static FigListItemContentDescriptionPartDefinition f7908a;
    private static final Object f7909b = new Object();

    private static FigListItemContentDescriptionPartDefinition m9539a() {
        return new FigListItemContentDescriptionPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9541a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1045093624);
        ((FigListItem) view).setContentDescription((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, 755750476, a);
    }

    public static FigListItemContentDescriptionPartDefinition m9540a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FigListItemContentDescriptionPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7909b) {
                FigListItemContentDescriptionPartDefinition figListItemContentDescriptionPartDefinition;
                if (a3 != null) {
                    figListItemContentDescriptionPartDefinition = (FigListItemContentDescriptionPartDefinition) a3.a(f7909b);
                } else {
                    figListItemContentDescriptionPartDefinition = f7908a;
                }
                if (figListItemContentDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9539a();
                        if (a3 != null) {
                            a3.a(f7909b, a2);
                        } else {
                            f7908a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = figListItemContentDescriptionPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
