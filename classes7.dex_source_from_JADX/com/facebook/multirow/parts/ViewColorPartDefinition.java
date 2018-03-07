package com.facebook.multirow.parts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: notifications_megaphone_dismissed */
public class ViewColorPartDefinition extends BaseSinglePartDefinition<Integer, Integer, AnyEnvironment, View> {
    private static ViewColorPartDefinition f7966b;
    private static final Object f7967c = new Object();
    private final Resources f7968a;

    private static ViewColorPartDefinition m9587b(InjectorLike injectorLike) {
        return new ViewColorPartDefinition(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m9588a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Integer num = (Integer) obj;
        if (num != null) {
            return Integer.valueOf(this.f7968a.getColor(num.intValue()));
        }
        return Integer.valueOf(-16777216);
    }

    public final /* bridge */ /* synthetic */ void m9589a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -588192294);
        Integer num = (Integer) obj2;
        if (num != null) {
            int intValue = num.intValue();
            Drawable background = view.getBackground();
            if (background == null) {
                view.setBackgroundDrawable(new ColorDrawable(intValue));
            } else if (background instanceof ColorDrawable) {
                ((ColorDrawable) background.mutate()).setColor(intValue);
            }
        }
        Logger.a(8, EntryType.MARK_POP, 2122818171, a);
    }

    @Inject
    public ViewColorPartDefinition(Resources resources) {
        this.f7968a = resources;
    }

    public static ViewColorPartDefinition m9586a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ViewColorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7967c) {
                ViewColorPartDefinition viewColorPartDefinition;
                if (a2 != null) {
                    viewColorPartDefinition = (ViewColorPartDefinition) a2.a(f7967c);
                } else {
                    viewColorPartDefinition = f7966b;
                }
                if (viewColorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9587b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7967c, b3);
                        } else {
                            f7966b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = viewColorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
