package com.facebook.multirow.parts;

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

@ContextScoped
/* compiled from: mutate_payment_platform_context */
public class ClickListenerPartDefinition extends BaseSinglePartDefinition<OnClickListener, Void, AnyEnvironment, View> {
    private static ClickListenerPartDefinition f13141a;
    private static final Object f13142b = new Object();

    private static ClickListenerPartDefinition m19352a() {
        return new ClickListenerPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1595614245);
        view.setOnClickListener((OnClickListener) obj);
        Logger.a(8, EntryType.MARK_POP, -2082882934, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }

    public static ClickListenerPartDefinition m19353a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ClickListenerPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13142b) {
                ClickListenerPartDefinition clickListenerPartDefinition;
                if (a3 != null) {
                    clickListenerPartDefinition = (ClickListenerPartDefinition) a3.mo818a(f13142b);
                } else {
                    clickListenerPartDefinition = f13141a;
                }
                if (clickListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19352a();
                        if (a3 != null) {
                            a3.mo822a(f13142b, a2);
                        } else {
                            f13141a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = clickListenerPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
