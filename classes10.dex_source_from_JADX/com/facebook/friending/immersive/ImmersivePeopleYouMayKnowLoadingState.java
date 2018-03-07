package com.facebook.friending.immersive;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: addContactParams */
public class ImmersivePeopleYouMayKnowLoadingState {
    private static ImmersivePeopleYouMayKnowLoadingState f20239b;
    private static final Object f20240c = new Object();
    public LoadingState f20241a = LoadingState.IDLE;

    /* compiled from: addContactParams */
    public enum LoadingState {
        LOADING,
        IDLE,
        FINISHED,
        REFRESHING,
        ERROR
    }

    private static ImmersivePeopleYouMayKnowLoadingState m20529b() {
        return new ImmersivePeopleYouMayKnowLoadingState();
    }

    public static ImmersivePeopleYouMayKnowLoadingState m20528a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImmersivePeopleYouMayKnowLoadingState b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20240c) {
                ImmersivePeopleYouMayKnowLoadingState immersivePeopleYouMayKnowLoadingState;
                if (a2 != null) {
                    immersivePeopleYouMayKnowLoadingState = (ImmersivePeopleYouMayKnowLoadingState) a2.a(f20240c);
                } else {
                    immersivePeopleYouMayKnowLoadingState = f20239b;
                }
                if (immersivePeopleYouMayKnowLoadingState == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m20529b();
                        if (a2 != null) {
                            a2.a(f20240c, b3);
                        } else {
                            f20239b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = immersivePeopleYouMayKnowLoadingState;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
