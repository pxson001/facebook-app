package com.facebook.multirow.parts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
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
/* compiled from: notifications_inline_expansion_message */
public class ViewHeightAspectRatioPartDefinition extends BaseSinglePartDefinition<Float, Void, AnyEnvironment, View> {
    private static ViewHeightAspectRatioPartDefinition f7969a;
    private static final Object f7970b = new Object();

    private static ViewHeightAspectRatioPartDefinition m9590a() {
        return new ViewHeightAspectRatioPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9592a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 960537250);
        Float f = (Float) obj;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.height = (int) (((float) marginLayoutParams.width) / f.floatValue());
            view.setLayoutParams(marginLayoutParams);
        }
        Logger.a(8, EntryType.MARK_POP, 850578052, a);
    }

    public static ViewHeightAspectRatioPartDefinition m9591a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewHeightAspectRatioPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7970b) {
                ViewHeightAspectRatioPartDefinition viewHeightAspectRatioPartDefinition;
                if (a3 != null) {
                    viewHeightAspectRatioPartDefinition = (ViewHeightAspectRatioPartDefinition) a3.a(f7970b);
                } else {
                    viewHeightAspectRatioPartDefinition = f7969a;
                }
                if (viewHeightAspectRatioPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9590a();
                        if (a3 != null) {
                            a3.a(f7970b, a2);
                        } else {
                            f7969a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = viewHeightAspectRatioPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
