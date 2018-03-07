package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.BaseJavaModule.ArgumentExtractor;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.lang.reflect.Method;

/* compiled from: growth_add_contactpoint_country_selected */
public class BaseJavaModule$JavaMethod implements NativeModule$NativeMethod {
    final /* synthetic */ BaseJavaModule f11456a;
    public Method f11457b;
    private final ArgumentExtractor[] f11458c;
    public final String f11459d;
    private final Object[] f11460e;
    private String f11461f = "remote";
    private final int f11462g;
    private final String f11463h;

    public BaseJavaModule$JavaMethod(BaseJavaModule baseJavaModule, Method method) {
        this.f11456a = baseJavaModule;
        this.f11457b = method;
        Class[] parameterTypes = method.getParameterTypes();
        this.f11458c = m13392b(parameterTypes);
        this.f11459d = m13391a(parameterTypes);
        this.f11460e = new Object[parameterTypes.length];
        this.f11462g = m13393d();
        this.f11463h = baseJavaModule.getName() + "." + this.f11457b.getName();
    }

    public final Method m13394a() {
        return this.f11457b;
    }

    public final String m13395b() {
        return this.f11459d;
    }

    private String m13391a(Class[] clsArr) {
        StringBuilder stringBuilder = new StringBuilder(clsArr.length);
        stringBuilder.append("v.");
        for (int i = 0; i < clsArr.length; i++) {
            Class cls = clsArr[i];
            if (cls == ExecutorToken.class) {
                if (!this.f11456a.f()) {
                    throw new RuntimeException("Module " + this.f11456a + " doesn't support web workers, but " + this.f11457b.getName() + " takes an ExecutorToken.");
                }
            } else if (cls == Promise.class) {
                boolean z;
                if (i == clsArr.length - 1) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.a(z, "Promise must be used as last parameter only");
                this.f11461f = "remoteAsync";
            }
            stringBuilder.append(BaseJavaModule.c(cls));
        }
        if (!this.f11456a.f() || stringBuilder.charAt(2) == 'T') {
            return stringBuilder.toString();
        }
        throw new RuntimeException("Module " + this.f11456a + " supports web workers, but " + this.f11457b.getName() + "does not take an ExecutorToken as its first parameter.");
    }

    private ArgumentExtractor[] m13392b(Class[] clsArr) {
        int i;
        if (!this.f11456a.f()) {
            i = 0;
        } else if (clsArr[0] != ExecutorToken.class) {
            throw new RuntimeException("Module " + this.f11456a + " supports web workers, but " + this.f11457b.getName() + "does not take an ExecutorToken as its first parameter.");
        } else {
            i = 1;
        }
        ArgumentExtractor[] argumentExtractorArr = new ArgumentExtractor[(clsArr.length - i)];
        for (int i2 = 0; i2 < clsArr.length - i; i2 += argumentExtractorArr[i2].a()) {
            int i3 = i2 + i;
            Class cls = clsArr[i3];
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                argumentExtractorArr[i2] = BaseJavaModule.a;
            } else if (cls == Integer.class || cls == Integer.TYPE) {
                argumentExtractorArr[i2] = BaseJavaModule.d;
            } else if (cls == Double.class || cls == Double.TYPE) {
                argumentExtractorArr[i2] = BaseJavaModule.b;
            } else if (cls == Float.class || cls == Float.TYPE) {
                argumentExtractorArr[i2] = BaseJavaModule.c;
            } else if (cls == String.class) {
                argumentExtractorArr[i2] = BaseJavaModule.e;
            } else if (cls == Callback.class) {
                argumentExtractorArr[i2] = BaseJavaModule.h;
            } else if (cls == Promise.class) {
                boolean z;
                argumentExtractorArr[i2] = BaseJavaModule.i;
                if (i3 == clsArr.length - 1) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.a(z, "Promise must be used as last parameter only");
                this.f11461f = "remoteAsync";
            } else if (cls == ReadableMap.class) {
                argumentExtractorArr[i2] = BaseJavaModule.g;
            } else if (cls == ReadableArray.class) {
                argumentExtractorArr[i2] = BaseJavaModule.f;
            } else {
                throw new RuntimeException("Got unknown argument class: " + cls.getSimpleName());
            }
        }
        return argumentExtractorArr;
    }

    private int m13393d() {
        int i = 0;
        ArgumentExtractor[] argumentExtractorArr = this.f11458c;
        int i2 = 0;
        while (i < argumentExtractorArr.length) {
            i2 += argumentExtractorArr[i].a();
            i++;
        }
        return i2;
    }

    private static String m13390a(int i, int i2) {
        return i2 > 1 ? i + "-" + ((i + i2) - 1) : i;
    }

    public void invoke(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray) {
        int i = 0;
        SystraceMessage.a(8192, "callJavaModuleMethod").a("method", this.f11463h).a();
        try {
            if (this.f11462g != readableNativeArray.size()) {
                throw new NativeArgumentsParseException(this.f11456a.getName() + "." + this.f11457b.getName() + " got " + readableNativeArray.size() + " arguments, expected " + this.f11462g);
            }
            int i2;
            int i3;
            if (this.f11456a.f()) {
                this.f11460e[0] = executorToken;
                i2 = 1;
                i3 = 0;
            } else {
                i2 = 0;
                i3 = 0;
            }
            while (i3 < this.f11458c.length) {
                try {
                    this.f11460e[i3 + i2] = this.f11458c[i3].a(catalystInstance, executorToken, readableNativeArray, i);
                    i += this.f11458c[i3].a();
                    i3++;
                } catch (Throwable e) {
                    throw new NativeArgumentsParseException(e.getMessage() + " (constructing arguments for " + this.f11456a.getName() + "." + this.f11457b.getName() + " at argument index " + m13390a(i, this.f11458c[i3].a()) + ")", e);
                }
            }
            try {
                this.f11457b.invoke(this.f11456a, this.f11460e);
            } catch (Throwable e2) {
                throw new RuntimeException("Could not invoke " + this.f11456a.getName() + "." + this.f11457b.getName(), e2);
            } catch (Throwable e22) {
                throw new RuntimeException("Could not invoke " + this.f11456a.getName() + "." + this.f11457b.getName(), e22);
            } catch (Throwable e222) {
                if (e222.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e222.getCause());
                }
                throw new RuntimeException("Could not invoke " + this.f11456a.getName() + "." + this.f11457b.getName(), e222);
            }
        } finally {
            Systrace.a(8192);
        }
    }

    public final String mo640c() {
        return this.f11461f;
    }
}
