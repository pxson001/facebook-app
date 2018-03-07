package com.facebook.richdocument.fonts;

import android.content.Context;
import android.graphics.Typeface;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.HashMap;
import java.util.Map;

@ContextScoped
/* compiled from: preferred_quality */
public class RichDocumentFonts {
    private static RichDocumentFonts f5277c;
    private static final Object f5278d = new Object();
    public Map<String, Typeface> f5279a = new HashMap();
    public Map<String, Typeface> f5280b = new HashMap();

    private static RichDocumentFonts m5214c() {
        return new RichDocumentFonts();
    }

    public static RichDocumentFonts m5213a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentFonts c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5278d) {
                RichDocumentFonts richDocumentFonts;
                if (a2 != null) {
                    richDocumentFonts = (RichDocumentFonts) a2.a(f5278d);
                } else {
                    richDocumentFonts = f5277c;
                }
                if (richDocumentFonts == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m5214c();
                        if (a2 != null) {
                            a2.a(f5278d, c);
                        } else {
                            f5277c = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = richDocumentFonts;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
