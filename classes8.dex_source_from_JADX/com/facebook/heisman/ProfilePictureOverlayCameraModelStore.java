package com.facebook.heisman;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Preconditions;

@ContextScoped
/* compiled from: value-name */
public class ProfilePictureOverlayCameraModelStore {
    private static ProfilePictureOverlayCameraModelStore f695b;
    private static final Object f696c = new Object();
    private ProfilePictureOverlayCameraModel f697a;

    private static ProfilePictureOverlayCameraModelStore m762b() {
        return new ProfilePictureOverlayCameraModelStore();
    }

    public final void m764a(ProfilePictureOverlayCameraModel profilePictureOverlayCameraModel) {
        this.f697a = (ProfilePictureOverlayCameraModel) Preconditions.checkNotNull(profilePictureOverlayCameraModel);
    }

    public final ProfilePictureOverlayCameraModel m763a() {
        Preconditions.checkNotNull(this.f697a, "Called getCameraModel() before initializing");
        return this.f697a;
    }

    public static ProfilePictureOverlayCameraModelStore m761a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfilePictureOverlayCameraModelStore b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f696c) {
                ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore;
                if (a2 != null) {
                    profilePictureOverlayCameraModelStore = (ProfilePictureOverlayCameraModelStore) a2.a(f696c);
                } else {
                    profilePictureOverlayCameraModelStore = f695b;
                }
                if (profilePictureOverlayCameraModelStore == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m762b();
                        if (a2 != null) {
                            a2.a(f696c, b3);
                        } else {
                            f695b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profilePictureOverlayCameraModelStore;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
