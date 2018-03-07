package com.google.common.base.internal;

import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: campaigns */
public class Finalizer implements Runnable {
    private static final Field inheritableThreadLocals = getInheritableThreadLocalsField();
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    public static void startFinalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        if (cls.getName().equals("com.google.common.base.FinalizableReference")) {
            Thread a = ThreadInitDetour.a(new Finalizer(cls, referenceQueue, phantomReference), -302008174);
            a.setName(Finalizer.class.getName());
            a.setDaemon(true);
            try {
                if (inheritableThreadLocals != null) {
                    inheritableThreadLocals.set(a, null);
                }
            } catch (Throwable th) {
                logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th);
            }
            a.start();
            return;
        }
        throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }

    private Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.queue = referenceQueue;
        this.finalizableReferenceClassReference = new WeakReference(cls);
        this.frqReference = phantomReference;
    }

    public void run() {
        while (cleanUp(this.queue.remove())) {
            try {
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean cleanUp(Reference<?> reference) {
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        if (finalizeReferentMethod == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.frqReference) {
                return false;
            }
            try {
                finalizeReferentMethod.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.queue.poll();
        } while (reference != null);
        return true;
    }

    private Method getFinalizeReferentMethod() {
        Class cls = (Class) this.finalizableReferenceClassReference.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public static Field getInheritableThreadLocalsField() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }
}
