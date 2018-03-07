package com.facebook.feedplugins.games;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: device_auth */
public class QuicksilverDeclaration implements FeedRowSupportDeclaration {
    private static QuicksilverDeclaration f7654a;
    private static final Object f7655b = new Object();

    private static QuicksilverDeclaration m8864a() {
        return new QuicksilverDeclaration();
    }

    public final void m8866a(ListItemRowController listItemRowController) {
        listItemRowController.a(QuicksilverContentAttachmentGroupPartDefinition.f7647a);
    }

    public static QuicksilverDeclaration m8865a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuicksilverDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7655b) {
                QuicksilverDeclaration quicksilverDeclaration;
                if (a3 != null) {
                    quicksilverDeclaration = (QuicksilverDeclaration) a3.a(f7655b);
                } else {
                    quicksilverDeclaration = f7654a;
                }
                if (quicksilverDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m8864a();
                        if (a3 != null) {
                            a3.a(f7655b, a2);
                        } else {
                            f7654a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = quicksilverDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
