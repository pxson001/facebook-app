package com.facebook.feedplugins.richmedia;

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
/* compiled from: buying_unread */
public class RichMediaDeclaration implements FeedRowSupportDeclaration {
    private static RichMediaDeclaration f9162a;
    private static final Object f9163b = new Object();

    private static RichMediaDeclaration m9842a() {
        return new RichMediaDeclaration();
    }

    public final void m9844a(ListItemRowController listItemRowController) {
        listItemRowController.a(RichMediaVideoAttachmentPartDefinition.f9216a);
        listItemRowController.a(RichMediaImageAttachmentPartDefinition.f9164a);
    }

    public static RichMediaDeclaration m9843a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f9163b) {
                RichMediaDeclaration richMediaDeclaration;
                if (a3 != null) {
                    richMediaDeclaration = (RichMediaDeclaration) a3.a(f9163b);
                } else {
                    richMediaDeclaration = f9162a;
                }
                if (richMediaDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9842a();
                        if (a3 != null) {
                            a3.a(f9163b, a2);
                        } else {
                            f9162a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = richMediaDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
