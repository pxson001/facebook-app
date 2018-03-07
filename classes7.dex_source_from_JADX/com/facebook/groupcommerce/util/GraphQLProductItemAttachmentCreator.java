package com.facebook.groupcommerce.util;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: reaction_unit_header */
public class GraphQLProductItemAttachmentCreator {
    private static GraphQLProductItemAttachmentCreator f5494a;
    private static final Object f5495b = new Object();

    private static GraphQLProductItemAttachmentCreator m6179a() {
        return new GraphQLProductItemAttachmentCreator();
    }

    public static GraphQLProductItemAttachmentCreator m6180a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphQLProductItemAttachmentCreator a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f5495b) {
                GraphQLProductItemAttachmentCreator graphQLProductItemAttachmentCreator;
                if (a3 != null) {
                    graphQLProductItemAttachmentCreator = (GraphQLProductItemAttachmentCreator) a3.a(f5495b);
                } else {
                    graphQLProductItemAttachmentCreator = f5494a;
                }
                if (graphQLProductItemAttachmentCreator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m6179a();
                        if (a3 != null) {
                            a3.a(f5495b, a2);
                        } else {
                            f5494a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = graphQLProductItemAttachmentCreator;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
