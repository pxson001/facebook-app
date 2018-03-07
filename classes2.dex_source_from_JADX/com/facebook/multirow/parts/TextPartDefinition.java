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
/* compiled from: music_preview_nux_history */
public class TextPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, TextView> {
    private static TextPartDefinition f13181a;
    private static final Object f13182b = new Object();

    private static TextPartDefinition m19378a() {
        return new TextPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1094290188);
        ((TextView) view).setText((CharSequence) obj);
        Logger.a(8, EntryType.MARK_POP, -1871152304, a);
    }

    public static TextPartDefinition m19379a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13182b) {
                TextPartDefinition textPartDefinition;
                if (a3 != null) {
                    textPartDefinition = (TextPartDefinition) a3.mo818a(f13182b);
                } else {
                    textPartDefinition = f13181a;
                }
                if (textPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19378a();
                        if (a3 != null) {
                            a3.mo822a(f13182b, a2);
                        } else {
                            f13181a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = textPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
