package com.facebook.timeline.publisher.rows;

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
import javax.inject.Inject;

@ContextScoped
/* compiled from: failed to get more section data */
public class PublisherDeclarations implements FeedRowSupportDeclaration {
    private static PublisherDeclarations f12444a;
    private static final Object f12445b = new Object();

    private static PublisherDeclarations m12479a() {
        return new PublisherDeclarations();
    }

    @Inject
    PublisherDeclarations() {
    }

    public final void m12481a(ListItemRowController listItemRowController) {
        listItemRowController.a(OpenPublisherBarWithStatusButtonsPartDefinition.f12436a);
    }

    public static PublisherDeclarations m12480a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PublisherDeclarations a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f12445b) {
                PublisherDeclarations publisherDeclarations;
                if (a3 != null) {
                    publisherDeclarations = (PublisherDeclarations) a3.a(f12445b);
                } else {
                    publisherDeclarations = f12444a;
                }
                if (publisherDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m12479a();
                        if (a3 != null) {
                            a3.a(f12445b, a2);
                        } else {
                            f12444a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = publisherDeclarations;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
