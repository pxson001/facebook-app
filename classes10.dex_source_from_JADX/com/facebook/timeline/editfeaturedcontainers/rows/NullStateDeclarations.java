package com.facebook.timeline.editfeaturedcontainers.rows;

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
/* compiled from: getSuggestedBots failed */
public class NullStateDeclarations implements FeedRowSupportDeclaration {
    private static NullStateDeclarations f10825a;
    private static final Object f10826b = new Object();

    private static NullStateDeclarations m10949a() {
        return new NullStateDeclarations();
    }

    public final void m10951a(ListItemRowController listItemRowController) {
        listItemRowController.a(NullStateSectionTitlePartDefinition.f10837a);
        listItemRowController.a(NullStateYourPhotosPartDefinition.f10890a);
        listItemRowController.a(NullStateClickablePhotoPartDefinition.f10820a);
        listItemRowController.a(NullStateSuggestedPagePartDefinition.f10846a);
        listItemRowController.a(NullStateSuggestedPagesSectionFooterPartDefinition.f10859a);
    }

    public static NullStateDeclarations m10950a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateDeclarations a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f10826b) {
                NullStateDeclarations nullStateDeclarations;
                if (a3 != null) {
                    nullStateDeclarations = (NullStateDeclarations) a3.a(f10826b);
                } else {
                    nullStateDeclarations = f10825a;
                }
                if (nullStateDeclarations == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m10949a();
                        if (a3 != null) {
                            a3.a(f10826b, a2);
                        } else {
                            f10825a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = nullStateDeclarations;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
