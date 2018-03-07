package com.facebook.feedplugins.voiceswitcher;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

@ContextScoped
/* compiled from: SHARE_EXTERNAL */
public class VoiceSwitcherDeclaration implements FeedRowSupportDeclaration, RootPartsDeclaration, RecyclableViewsDeclaration {
    private static VoiceSwitcherDeclaration f23838a;
    private static final Object f23839b = new Object();

    private static VoiceSwitcherDeclaration m25986a() {
        return new VoiceSwitcherDeclaration();
    }

    public final void m25988a(ListItemRowController listItemRowController) {
        listItemRowController.a(VoiceSwitcherPartDefinition.f23841a);
    }

    public final void m25989a(RootPartRegistrationController rootPartRegistrationController) {
    }

    public final void m25990a(RecyclableViewPoolManager recyclableViewPoolManager) {
    }

    public static VoiceSwitcherDeclaration m25987a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VoiceSwitcherDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f23839b) {
                VoiceSwitcherDeclaration voiceSwitcherDeclaration;
                if (a3 != null) {
                    voiceSwitcherDeclaration = (VoiceSwitcherDeclaration) a3.a(f23839b);
                } else {
                    voiceSwitcherDeclaration = f23838a;
                }
                if (voiceSwitcherDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m25986a();
                        if (a3 != null) {
                            a3.a(f23839b, a2);
                        } else {
                            f23838a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = voiceSwitcherDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
