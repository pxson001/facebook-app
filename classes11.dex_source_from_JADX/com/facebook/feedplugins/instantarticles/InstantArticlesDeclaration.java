package com.facebook.feedplugins.instantarticles;

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
/* compiled from: context_items_card_limit */
public class InstantArticlesDeclaration implements FeedRowSupportDeclaration {
    private static InstantArticlesDeclaration f7982a;
    private static final Object f7983b = new Object();

    private static InstantArticlesDeclaration m9057a() {
        return new InstantArticlesDeclaration();
    }

    public final void m9059a(ListItemRowController listItemRowController) {
        listItemRowController.a(AngoraInstantArticleAttachmentLabelView.f7967a);
        listItemRowController.a(InstantArticlePhotoAttachmentContainerView.f7975b);
        listItemRowController.a(InstantArticlesRichVideoAttachmentView.f7984c);
    }

    public static InstantArticlesDeclaration m9058a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticlesDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7983b) {
                InstantArticlesDeclaration instantArticlesDeclaration;
                if (a3 != null) {
                    instantArticlesDeclaration = (InstantArticlesDeclaration) a3.a(f7983b);
                } else {
                    instantArticlesDeclaration = f7982a;
                }
                if (instantArticlesDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9057a();
                        if (a3 != null) {
                            a3.a(f7983b, a2);
                        } else {
                            f7982a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = instantArticlesDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
