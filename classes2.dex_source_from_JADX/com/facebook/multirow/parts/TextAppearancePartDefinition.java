package com.facebook.multirow.parts;

import android.content.Context;
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
/* compiled from: in_channel_eligibility_experiment */
public class TextAppearancePartDefinition extends BaseSinglePartDefinition<Integer, Void, AnyEnvironment, TextView> {
    private static TextAppearancePartDefinition f20277a;
    private static final Object f20278b = new Object();

    private static TextAppearancePartDefinition m27948a() {
        return new TextAppearancePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 796185904);
        TextView textView = (TextView) view;
        textView.setTextAppearance(textView.getContext(), ((Integer) obj).intValue());
        Logger.a(8, EntryType.MARK_POP, 41545243, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TextView textView = (TextView) view;
        textView.setTextAppearance(textView.getContext(), 0);
    }

    public static TextAppearancePartDefinition m27949a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextAppearancePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f20278b) {
                TextAppearancePartDefinition textAppearancePartDefinition;
                if (a3 != null) {
                    textAppearancePartDefinition = (TextAppearancePartDefinition) a3.mo818a(f20278b);
                } else {
                    textAppearancePartDefinition = f20277a;
                }
                if (textAppearancePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m27948a();
                        if (a3 != null) {
                            a3.mo822a(f20278b, a2);
                        } else {
                            f20277a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = textAppearancePartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
