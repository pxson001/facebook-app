package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

@ContextScoped
/* compiled from: num_cam */
public class GroupCommerceStorySetDeclaration implements RecyclableViewsDeclaration {
    private static GroupCommerceStorySetDeclaration f6595a;
    private static final Object f6596b = new Object();

    private static GroupCommerceStorySetDeclaration m7010a() {
        return new GroupCommerceStorySetDeclaration();
    }

    public final void m7012a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.m6901a(GroupCommerceHScrollItemView.class, RecyclableViewPoolManager.f6446a, RecyclableViewPoolManager.f6450e);
    }

    public static GroupCommerceStorySetDeclaration m7011a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceStorySetDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f6596b) {
                GroupCommerceStorySetDeclaration groupCommerceStorySetDeclaration;
                if (a3 != null) {
                    groupCommerceStorySetDeclaration = (GroupCommerceStorySetDeclaration) a3.a(f6596b);
                } else {
                    groupCommerceStorySetDeclaration = f6595a;
                }
                if (groupCommerceStorySetDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m7010a();
                        if (a3 != null) {
                            a3.a(f6596b, a2);
                        } else {
                            f6595a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = groupCommerceStorySetDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
