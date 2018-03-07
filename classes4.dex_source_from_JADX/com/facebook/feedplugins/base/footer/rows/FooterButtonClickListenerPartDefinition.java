package com.facebook.feedplugins.base.footer.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
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
/* compiled from: presence_mqtt_receive */
public class FooterButtonClickListenerPartDefinition<V extends View & Footer> extends BaseSinglePartDefinition<ButtonClickedListener, Void, AnyEnvironment, V> {
    private static FooterButtonClickListenerPartDefinition f4289a;
    private static final Object f4290b = new Object();

    private static FooterButtonClickListenerPartDefinition m4820a() {
        return new FooterButtonClickListenerPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m4823a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 556861828);
        m4822a((ButtonClickedListener) obj, view);
        Logger.a(8, EntryType.MARK_POP, 1303126764, a);
    }

    private static void m4822a(ButtonClickedListener buttonClickedListener, V v) {
        ((Footer) v).setOnButtonClickedListener(buttonClickedListener);
    }

    public final void m4824b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((Footer) view).setOnButtonClickedListener(null);
    }

    public static FooterButtonClickListenerPartDefinition m4821a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FooterButtonClickListenerPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f4290b) {
                FooterButtonClickListenerPartDefinition footerButtonClickListenerPartDefinition;
                if (a3 != null) {
                    footerButtonClickListenerPartDefinition = (FooterButtonClickListenerPartDefinition) a3.a(f4290b);
                } else {
                    footerButtonClickListenerPartDefinition = f4289a;
                }
                if (footerButtonClickListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m4820a();
                        if (a3 != null) {
                            a3.a(f4290b, a2);
                        } else {
                            f4289a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = footerButtonClickListenerPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
