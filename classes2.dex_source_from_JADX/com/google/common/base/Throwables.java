package com.google.common.base;

import com.google.common.annotations.Beta;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: whistle_android */
public final class Throwables {
    @Nullable
    private static final Method getStackTraceDepthMethod;
    @Nullable
    private static final Method getStackTraceElementMethod;
    @Nullable
    private static final Object jla;

    private Throwables() {
    }

    public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable th, Class<X> cls) {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void propagateIfPossible(@Nullable Throwable th) {
        propagateIfInstanceOf(th, Error.class);
        propagateIfInstanceOf(th, RuntimeException.class);
    }

    public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable th, Class<X> cls) {
        propagateIfInstanceOf(th, cls);
        propagateIfPossible(th);
    }

    public static RuntimeException propagate(Throwable th) {
        propagateIfPossible((Throwable) Preconditions.checkNotNull(th));
        throw new RuntimeException(th);
    }

    @CheckReturnValue
    public static Throwable getRootCause(Throwable th) {
        while (true) {
            Throwable cause = th.getCause();
            if (cause == null) {
                return th;
            }
            th = cause;
        }
    }

    @CheckReturnValue
    @Beta
    public static List<Throwable> getCausalChain(Throwable th) {
        Preconditions.checkNotNull(th);
        List arrayList = new ArrayList(4);
        while (th != null) {
            arrayList.add(th);
            th = th.getCause();
        }
        return Collections.unmodifiableList(arrayList);
    }

    @CheckReturnValue
    public static String getStackTraceAsString(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    static {
        Method method;
        Method method2 = null;
        Object jla = getJLA();
        jla = jla;
        if (jla == null) {
            method = null;
        } else {
            method = getJlaMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        getStackTraceElementMethod = method;
        if (jla != null) {
            method2 = getJlaMethod("getStackTraceDepth", Throwable.class);
        }
        getStackTraceDepthMethod = method2;
    }

    @Nullable
    private static Object getJLA() {
        Object obj = null;
        try {
            obj = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
        }
        return obj;
    }

    @Nullable
    public static Method getJlaMethod(String str, Class<?>... clsArr) {
        Method method = null;
        try {
            method = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
        }
        return method;
    }
}
