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
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: fetchZeroToken */
public class TextOrHiddenPartDefinition extends BaseSinglePartDefinition<CharSequence, Void, AnyEnvironment, TextView> {
    private static TextOrHiddenPartDefinition f24213a;
    private static final Object f24214b = new Object();

    private static TextOrHiddenPartDefinition m32560a() {
        return new TextOrHiddenPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(@Nullable Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1288130005);
        CharSequence charSequence = (CharSequence) obj;
        TextView textView = (TextView) view;
        if (charSequence == null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence);
        }
        Logger.a(8, EntryType.MARK_POP, -917419753, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TextView textView = (TextView) view;
        textView.setVisibility(8);
        textView.setText(null);
    }

    public static TextOrHiddenPartDefinition m32561a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextOrHiddenPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f24214b) {
                TextOrHiddenPartDefinition textOrHiddenPartDefinition;
                if (a3 != null) {
                    textOrHiddenPartDefinition = (TextOrHiddenPartDefinition) a3.mo818a(f24214b);
                } else {
                    textOrHiddenPartDefinition = f24213a;
                }
                if (textOrHiddenPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m32560a();
                        if (a3 != null) {
                            a3.mo822a(f24214b, a2);
                        } else {
                            f24213a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = textOrHiddenPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
