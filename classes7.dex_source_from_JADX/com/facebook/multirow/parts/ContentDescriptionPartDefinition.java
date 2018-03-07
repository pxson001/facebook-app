package com.facebook.multirow.parts;

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

@ContextScoped
/* compiled from: nux_submessage */
public class ContentDescriptionPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, View> {
    private static ContentDescriptionPartDefinition f7868a;
    private static final Object f7869b = new Object();

    private static ContentDescriptionPartDefinition m9501a() {
        return new ContentDescriptionPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9503a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 556093309);
        view.setContentDescription((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, 670350272, a);
    }

    public final void m9504b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setContentDescription(null);
    }

    public static ContentDescriptionPartDefinition m9502a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContentDescriptionPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7869b) {
                ContentDescriptionPartDefinition contentDescriptionPartDefinition;
                if (a3 != null) {
                    contentDescriptionPartDefinition = (ContentDescriptionPartDefinition) a3.a(f7869b);
                } else {
                    contentDescriptionPartDefinition = f7868a;
                }
                if (contentDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9501a();
                        if (a3 != null) {
                            a3.a(f7869b, a2);
                        } else {
                            f7868a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = contentDescriptionPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
