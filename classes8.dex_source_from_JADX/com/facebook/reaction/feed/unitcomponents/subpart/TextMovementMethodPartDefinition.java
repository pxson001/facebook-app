package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.TextView;
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
/* compiled from: ZJ[J */
public class TextMovementMethodPartDefinition extends BaseSinglePartDefinition<MovementMethod, Void, AnyEnvironment, TextView> {
    private static TextMovementMethodPartDefinition f20695a;
    private static final Object f20696b = new Object();

    private static TextMovementMethodPartDefinition m24362a() {
        return new TextMovementMethodPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m24364a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 488718197);
        ((TextView) view).setMovementMethod((MovementMethod) obj);
        Logger.a(8, EntryType.MARK_POP, -1125464344, a);
    }

    public static TextMovementMethodPartDefinition m24363a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextMovementMethodPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f20696b) {
                TextMovementMethodPartDefinition textMovementMethodPartDefinition;
                if (a3 != null) {
                    textMovementMethodPartDefinition = (TextMovementMethodPartDefinition) a3.a(f20696b);
                } else {
                    textMovementMethodPartDefinition = f20695a;
                }
                if (textMovementMethodPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m24362a();
                        if (a3 != null) {
                            a3.a(f20696b, a2);
                        } else {
                            f20695a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = textMovementMethodPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
