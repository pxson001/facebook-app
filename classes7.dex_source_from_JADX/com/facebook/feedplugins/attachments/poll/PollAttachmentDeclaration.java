package com.facebook.feedplugins.attachments.poll;

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
/* compiled from: THREE_SQUARE_ITEMS */
public class PollAttachmentDeclaration implements FeedRowSupportDeclaration {
    private static PollAttachmentDeclaration f22654a;
    private static final Object f22655b = new Object();

    private static PollAttachmentDeclaration m25307a() {
        return new PollAttachmentDeclaration();
    }

    public final void m25309a(ListItemRowController listItemRowController) {
        listItemRowController.a(PollOptionTextWithProgressBarPartDefinition.f22705a);
    }

    public static PollAttachmentDeclaration m25308a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollAttachmentDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f22655b) {
                PollAttachmentDeclaration pollAttachmentDeclaration;
                if (a3 != null) {
                    pollAttachmentDeclaration = (PollAttachmentDeclaration) a3.a(f22655b);
                } else {
                    pollAttachmentDeclaration = f22654a;
                }
                if (pollAttachmentDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m25307a();
                        if (a3 != null) {
                            a3.a(f22655b, a2);
                        } else {
                            f22654a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = pollAttachmentDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
