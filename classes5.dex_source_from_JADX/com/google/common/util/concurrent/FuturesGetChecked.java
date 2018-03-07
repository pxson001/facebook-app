package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

/* compiled from: bug_description */
public final class FuturesGetChecked {
    public static final Ordering<Constructor<?>> f7662a = NaturalOrdering.a.a(new C08691()).a();

    /* compiled from: bug_description */
    final class C08691 implements Function<Constructor<?>, Boolean> {
        C08691() {
        }

        public final Object apply(Object obj) {
            return Boolean.valueOf(Arrays.asList(((Constructor) obj).getParameterTypes()).contains(String.class));
        }
    }

    @VisibleForTesting
    /* compiled from: bug_description */
    interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> cls);
    }

    @VisibleForTesting
    /* compiled from: bug_description */
    public class GetCheckedTypeValidatorHolder {
        static final String f7660a = (GetCheckedTypeValidatorHolder.class.getName() + "$ClassValueValidator");
        public static final GetCheckedTypeValidator f7661b = m13828a();

        /* compiled from: bug_description */
        enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;
            
            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = null;

            static {
                validClasses = new CopyOnWriteArraySet();
            }

            public final void validateClass(Class<? extends Exception> cls) {
                for (WeakReference weakReference : validClasses) {
                    if (cls.equals(weakReference.get())) {
                        return;
                    }
                }
                FuturesGetChecked.m13834a(cls);
                if (validClasses.size() > 1000) {
                    validClasses.clear();
                }
                validClasses.add(new WeakReference(cls));
            }
        }

        GetCheckedTypeValidatorHolder() {
        }

        private static GetCheckedTypeValidator m13828a() {
            try {
                return (GetCheckedTypeValidator) Class.forName(f7660a).getEnumConstants()[0];
            } catch (Throwable th) {
                return FuturesGetChecked.m13829a();
            }
        }
    }

    @VisibleForTesting
    private static <V, X extends Exception> V m13831a(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) {
        getCheckedTypeValidator.validateClass(cls);
        try {
            return FutureDetour.a(future, -319010803);
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            throw m13830a((Class) cls, e);
        } catch (ExecutionException e2) {
            m13835a(e2.getCause(), (Class) cls);
            throw new AssertionError();
        }
    }

    public static <V, X extends Exception> V m13833a(Future<V> future, Class<X> cls) {
        return m13831a(GetCheckedTypeValidatorHolder.f7661b, future, cls);
    }

    @VisibleForTesting
    static GetCheckedTypeValidator m13829a() {
        return WeakSetValidator.INSTANCE;
    }

    private static <X extends Exception> void m13835a(Throwable th, Class<X> cls) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw m13830a((Class) cls, th);
        }
    }

    private static boolean m13836b(Class<? extends Exception> cls) {
        try {
            m13830a((Class) cls, new Exception());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static <X extends Exception> X m13830a(Class<X> cls, Throwable th) {
        for (Constructor a : f7662a.c(Arrays.asList(cls.getConstructors()))) {
            Exception exception = (Exception) m13832a(a, th);
            if (exception != null) {
                if (exception.getCause() == null) {
                    exception.initCause(th);
                }
                return exception;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    @Nullable
    private static <X> X m13832a(Constructor<X> constructor, Throwable th) {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Object obj = parameterTypes[i];
            if (obj.equals(String.class)) {
                objArr[i] = th.toString();
            } else if (!obj.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (InstantiationException e2) {
            return null;
        } catch (IllegalAccessException e3) {
            return null;
        } catch (InvocationTargetException e4) {
            return null;
        }
    }

    @VisibleForTesting
    private static boolean m13837c(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    @VisibleForTesting
    static void m13834a(Class<? extends Exception> cls) {
        Preconditions.checkArgument(m13837c(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", new Object[]{cls});
        Preconditions.checkArgument(m13836b(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", new Object[]{cls});
    }

    private FuturesGetChecked() {
    }
}
