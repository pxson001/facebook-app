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
/* compiled from: framesPrompt */
public class VisibilityPartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinition<Integer, Void, E, View> {
    private static VisibilityPartDefinition f23291a;
    private static final Object f23292b = new Object();

    private static VisibilityPartDefinition m31411a() {
        return new VisibilityPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1549741159);
        view.setVisibility(((Integer) obj).intValue());
        Logger.a(8, EntryType.MARK_POP, 1846895981, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setVisibility(0);
    }

    public static VisibilityPartDefinition m31412a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VisibilityPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f23292b) {
                VisibilityPartDefinition visibilityPartDefinition;
                if (a3 != null) {
                    visibilityPartDefinition = (VisibilityPartDefinition) a3.mo818a(f23292b);
                } else {
                    visibilityPartDefinition = f23291a;
                }
                if (visibilityPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m31411a();
                        if (a3 != null) {
                            a3.mo822a(f23292b, a2);
                        } else {
                            f23291a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = visibilityPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
