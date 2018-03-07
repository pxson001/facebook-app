package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Method;

/* compiled from: growth_add_contactpoint_country_selected */
public class BaseJavaModule$SyncJavaHook {
    final /* synthetic */ BaseJavaModule f11464a;
    public Method f11465b;
    public final String f11466c;

    public BaseJavaModule$SyncJavaHook(BaseJavaModule baseJavaModule, Method method) {
        this.f11464a = baseJavaModule;
        this.f11465b = method;
        this.f11466c = m13397a(method);
    }

    public final Method m13398a() {
        return this.f11465b;
    }

    public final String m13399b() {
        return this.f11466c;
    }

    private String m13397a(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder stringBuilder = new StringBuilder(parameterTypes.length + 2);
        stringBuilder.append(BaseJavaModule.d(method.getReturnType()));
        stringBuilder.append('.');
        for (int i = 0; i < parameterTypes.length; i++) {
            Class cls = parameterTypes[i];
            if (cls == ExecutorToken.class) {
                if (!this.f11464a.f()) {
                    throw new RuntimeException("Module " + this.f11464a + " doesn't support web workers, but " + this.f11465b.getName() + " takes an ExecutorToken.");
                }
            } else if (cls == Promise.class) {
                boolean z;
                if (i == parameterTypes.length - 1) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.a(z, "Promise must be used as last parameter only");
            }
            stringBuilder.append(BaseJavaModule.c(cls));
        }
        return stringBuilder.toString();
    }
}
