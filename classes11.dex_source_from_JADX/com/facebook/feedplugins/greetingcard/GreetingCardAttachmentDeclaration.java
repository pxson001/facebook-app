package com.facebook.feedplugins.greetingcard;

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
/* compiled from: deviceType */
public class GreetingCardAttachmentDeclaration implements FeedRowSupportDeclaration {
    private static GreetingCardAttachmentDeclaration f7656a;
    private static final Object f7657b = new Object();

    private static GreetingCardAttachmentDeclaration m8867a() {
        return new GreetingCardAttachmentDeclaration();
    }

    public final void m8869a(ListItemRowController listItemRowController) {
        listItemRowController.a(GreetingCardAttachmentPartDefinition.f7658a);
    }

    public static GreetingCardAttachmentDeclaration m8868a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardAttachmentDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7657b) {
                GreetingCardAttachmentDeclaration greetingCardAttachmentDeclaration;
                if (a3 != null) {
                    greetingCardAttachmentDeclaration = (GreetingCardAttachmentDeclaration) a3.a(f7657b);
                } else {
                    greetingCardAttachmentDeclaration = f7656a;
                }
                if (greetingCardAttachmentDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m8867a();
                        if (a3 != null) {
                            a3.a(f7657b, a2);
                        } else {
                            f7656a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = greetingCardAttachmentDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
