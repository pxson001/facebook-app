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
import com.facebook.widget.ExpandingFixedAspectRatioFrameLayout;

@ContextScoped
/* compiled from: number_of_breaks */
public class ExpandingFixedAspectRatioFrameLayoutPartDefinition extends BaseSinglePartDefinition<Double, Void, AnyEnvironment, ExpandingFixedAspectRatioFrameLayout> {
    private static ExpandingFixedAspectRatioFrameLayoutPartDefinition f7882a;
    private static final Object f7883b = new Object();

    private static ExpandingFixedAspectRatioFrameLayoutPartDefinition m9523a() {
        return new ExpandingFixedAspectRatioFrameLayoutPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9525a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 898216886);
        Double d = (Double) obj;
        ExpandingFixedAspectRatioFrameLayout expandingFixedAspectRatioFrameLayout = (ExpandingFixedAspectRatioFrameLayout) view;
        if (d != null && d.doubleValue() > 0.0d) {
            expandingFixedAspectRatioFrameLayout.a = d.doubleValue();
        }
        Logger.a(8, EntryType.MARK_POP, 1610747999, a);
    }

    public static ExpandingFixedAspectRatioFrameLayoutPartDefinition m9524a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExpandingFixedAspectRatioFrameLayoutPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7883b) {
                ExpandingFixedAspectRatioFrameLayoutPartDefinition expandingFixedAspectRatioFrameLayoutPartDefinition;
                if (a3 != null) {
                    expandingFixedAspectRatioFrameLayoutPartDefinition = (ExpandingFixedAspectRatioFrameLayoutPartDefinition) a3.a(f7883b);
                } else {
                    expandingFixedAspectRatioFrameLayoutPartDefinition = f7882a;
                }
                if (expandingFixedAspectRatioFrameLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9523a();
                        if (a3 != null) {
                            a3.a(f7883b, a2);
                        } else {
                            f7882a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = expandingFixedAspectRatioFrameLayoutPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
