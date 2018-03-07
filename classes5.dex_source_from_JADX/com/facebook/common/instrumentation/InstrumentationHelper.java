package com.facebook.common.instrumentation;

import java.lang.reflect.Method;

/* compiled from: source_surface */
public final class InstrumentationHelper {
    private static final InstrumentationLogger f2632a = new C01821();

    /* compiled from: source_surface */
    public interface InstrumentationLogger {
        void mo565a(String str);

        void mo566a(String str, Throwable th);
    }

    /* compiled from: source_surface */
    final class C01821 implements InstrumentationLogger {
        C01821() {
        }

        public final void mo565a(String str) {
            System.out.println(str);
        }

        public final void mo566a(String str, Throwable th) {
            System.out.println(str);
            th.printStackTrace();
        }
    }

    private InstrumentationHelper() {
    }

    public static InstrumentationInformationCollector m3742a(Object obj, InstrumentationInfo instrumentationInfo, InstrumentationLogger instrumentationLogger) {
        if (obj == null) {
            return null;
        }
        if (instrumentationLogger == null) {
            instrumentationLogger = f2632a;
        }
        Class cls = obj.getClass();
        if (m3745b(cls.getName())) {
            Method a = m3744a(cls, instrumentationLogger);
            if (a == null) {
                return null;
            }
            try {
                InstrumentationInformationCollector instrumentationInformationCollector = (InstrumentationInformationCollector) a.invoke(obj, new Object[]{instrumentationInfo});
                instrumentationLogger.mo565a(String.format("Added AddInstrumentationListener method for class %s", new Object[]{cls.getName()}));
                if (instrumentationInformationCollector != null) {
                    return instrumentationInformationCollector;
                }
                throw new IllegalStateException("We currently do not support multiple collectors inflight");
            } catch (Throwable e) {
                if (e.getCause() != null) {
                    instrumentationLogger.mo566a(String.format("Cannot call AddInstrumentationListener method for class %s. Cause:", new Object[]{cls.getName()}), e.getCause());
                }
                instrumentationLogger.mo566a(String.format("Cannot call AddInstrumentationListener method for class %s. Top Level:", new Object[]{cls.getName()}), e);
                return null;
            }
        }
        instrumentationLogger.mo565a(String.format("Class %s is not eligible for instrumentation", new Object[]{cls.getName()}));
        return null;
    }

    private static Method m3744a(Class<?> cls, InstrumentationLogger instrumentationLogger) {
        try {
            return cls.getMethod(m3743a(cls.getName()), new Class[]{InstrumentationInfo.class});
        } catch (Throwable e) {
            instrumentationLogger.mo566a(String.format("Cannot get method %s for class %s", new Object[]{r1, cls.getName()}), e);
            return null;
        }
    }

    private static String m3743a(String str) {
        return "addInstrumentationListener" + "_UNIQUE_NAME_" + str.replace('.', '_').replace('/', '_').replace('$', '_');
    }

    private static boolean m3745b(String str) {
        return str.contains("facebook");
    }
}
