package com.facebook.components.reference;

import com.facebook.components.ComponentContext;
import com.facebook.components.ResourceResolver;

/* compiled from: getDayAlignedDiffMs result isn't aligned to day. It's off by  */
public abstract class Reference<L> {
    private final ReferenceLifecycle<L> f22610a;

    /* compiled from: getDayAlignedDiffMs result isn't aligned to day. It's off by  */
    public abstract class Builder<L> extends ResourceResolver {
        public abstract Reference<L> mo3297b();

        public final void m30721a(ComponentContext componentContext) {
            super.m30669a(componentContext, componentContext.f22550b);
        }
    }

    protected Reference(ReferenceLifecycle<L> referenceLifecycle) {
        this.f22610a = referenceLifecycle;
    }

    public static <T> T m30531a(ComponentContext componentContext, Reference<T> reference) {
        return reference.f22610a.mo3151a(componentContext, reference);
    }

    public static <T> void m30532a(ComponentContext componentContext, T t, Reference<T> reference) {
        reference.f22610a.mo3365a(componentContext, t, reference);
    }

    public static <T> boolean m30533a(Reference<T> reference, Reference<T> reference2) {
        if (reference == null) {
            return reference2 != null;
        } else {
            ReferenceLifecycle referenceLifecycle = reference.f22610a;
            boolean z = true;
            if (reference == null) {
                if (reference2 == null) {
                    z = false;
                }
            } else if (reference2 != null && reference.getClass() == reference2.getClass()) {
                z = !reference.equals(reference2);
            }
            return z;
        }
    }
}
