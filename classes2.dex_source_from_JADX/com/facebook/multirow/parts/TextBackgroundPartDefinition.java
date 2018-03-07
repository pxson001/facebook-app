package com.facebook.multirow.parts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
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
import com.facebook.resources.ui.FbTextView;

@ContextScoped
/* compiled from: in_flight_conns */
public class TextBackgroundPartDefinition extends BaseSinglePartDefinition<Drawable, Void, AnyEnvironment, FbTextView> {
    private static TextBackgroundPartDefinition f20275a;
    private static final Object f20276b = new Object();

    private static TextBackgroundPartDefinition m27945a() {
        return new TextBackgroundPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1142998817);
        Drawable drawable = (Drawable) obj;
        FbTextView fbTextView = (FbTextView) view;
        if (VERSION.SDK_INT < 16) {
            fbTextView.setBackgroundDrawable(drawable);
        } else {
            fbTextView.setBackground(drawable);
        }
        Logger.a(8, EntryType.MARK_POP, -113407276, a);
    }

    public static TextBackgroundPartDefinition m27946a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextBackgroundPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f20276b) {
                TextBackgroundPartDefinition textBackgroundPartDefinition;
                if (a3 != null) {
                    textBackgroundPartDefinition = (TextBackgroundPartDefinition) a3.mo818a(f20276b);
                } else {
                    textBackgroundPartDefinition = f20275a;
                }
                if (textBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m27945a();
                        if (a3 != null) {
                            a3.mo822a(f20276b, a2);
                        } else {
                            f20275a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = textBackgroundPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}
