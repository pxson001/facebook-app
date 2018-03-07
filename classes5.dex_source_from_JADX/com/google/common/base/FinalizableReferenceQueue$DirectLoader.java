package com.google.common.base;

/* compiled from: can_deeplink */
class FinalizableReferenceQueue$DirectLoader implements FinalizableReferenceQueue$FinalizerLoader {
    FinalizableReferenceQueue$DirectLoader() {
    }

    public Class<?> loadFinalizer() {
        try {
            return Class.forName("com.google.common.base.internal.Finalizer");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
}
