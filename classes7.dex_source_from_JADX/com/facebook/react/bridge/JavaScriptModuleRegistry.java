package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

/* compiled from: group_name */
public class JavaScriptModuleRegistry {
    private final WeakHashMap<ExecutorToken, HashMap<Class<? extends JavaScriptModule>, JavaScriptModule>> f11515a = new WeakHashMap();
    private final HashMap<Class<? extends JavaScriptModule>, JavaScriptModuleRegistration> f11516b = new HashMap();

    /* compiled from: group_name */
    public class Builder {
        private List<JavaScriptModuleRegistration> f11511a = new ArrayList();

        public final Builder m13466a(Class<? extends JavaScriptModule> cls) {
            this.f11511a.add(new JavaScriptModuleRegistration(cls));
            return this;
        }

        public final JavaScriptModuleRegistry m13467a() {
            return new JavaScriptModuleRegistry(this.f11511a);
        }
    }

    /* compiled from: group_name */
    class JavaScriptModuleInvocationHandler implements InvocationHandler {
        private final WeakReference<ExecutorToken> f11512a;
        private final CatalystInstance f11513b;
        private final JavaScriptModuleRegistration f11514c;

        public JavaScriptModuleInvocationHandler(ExecutorToken executorToken, CatalystInstance catalystInstance, JavaScriptModuleRegistration javaScriptModuleRegistration) {
            this.f11512a = new WeakReference(executorToken);
            this.f11513b = catalystInstance;
            this.f11514c = javaScriptModuleRegistration;
        }

        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
            ExecutorToken executorToken = (ExecutorToken) this.f11512a.get();
            if (executorToken == null) {
                FLog.a("React", "Dropping JS call, ExecutorToken went away...");
            } else {
                this.f11513b.callFunction(executorToken, this.f11514c.m13465b(), method.getName(), objArr != null ? Arguments.m13387a(objArr) : new WritableNativeArray(), this.f11514c.m13464a(method));
            }
            return null;
        }
    }

    public JavaScriptModuleRegistry(List<JavaScriptModuleRegistration> list) {
        for (JavaScriptModuleRegistration javaScriptModuleRegistration : list) {
            this.f11516b.put(javaScriptModuleRegistration.f11509a, javaScriptModuleRegistration);
        }
    }

    public final synchronized <T extends JavaScriptModule> T m13468a(CatalystInstance catalystInstance, ExecutorToken executorToken, Class<T> cls) {
        T t;
        HashMap hashMap;
        HashMap hashMap2 = (HashMap) this.f11515a.get(executorToken);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            this.f11515a.put(executorToken, hashMap2);
            hashMap = hashMap2;
        } else {
            hashMap = hashMap2;
        }
        t = (JavaScriptModule) hashMap.get(cls);
        if (t == null) {
            JavaScriptModuleRegistration javaScriptModuleRegistration = (JavaScriptModuleRegistration) Assertions.a(this.f11516b.get(cls), "JS module " + cls.getSimpleName() + " hasn't been registered!");
            JavaScriptModule javaScriptModule = (JavaScriptModule) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new JavaScriptModuleInvocationHandler(executorToken, catalystInstance, javaScriptModuleRegistration));
            hashMap.put(cls, javaScriptModule);
        }
        return t;
    }
}
