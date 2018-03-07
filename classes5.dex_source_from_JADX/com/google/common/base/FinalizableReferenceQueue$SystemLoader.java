package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;

/* compiled from: can_deeplink */
class FinalizableReferenceQueue$SystemLoader implements FinalizableReferenceQueue$FinalizerLoader {
    @VisibleForTesting
    static boolean disabled;

    FinalizableReferenceQueue$SystemLoader() {
    }

    public Class<?> loadFinalizer() {
        Class<?> cls = null;
        if (!disabled) {
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        cls = systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                    } catch (ClassNotFoundException e) {
                    }
                }
            } catch (SecurityException e2) {
                FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
            }
        }
        return cls;
    }
}
