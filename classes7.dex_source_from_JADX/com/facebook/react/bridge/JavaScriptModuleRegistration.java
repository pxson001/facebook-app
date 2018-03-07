package com.facebook.react.bridge;

import com.facebook.react.common.build.ReactBuildConfig;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: group_not_forsale_stories */
public class JavaScriptModuleRegistration {
    public final Class<? extends JavaScriptModule> f11509a;
    private final Map<Method, String> f11510b = new HashMap();

    public JavaScriptModuleRegistration(Class<? extends JavaScriptModule> cls) {
        this.f11509a = cls;
        if (ReactBuildConfig.a) {
            Set linkedHashSet = new LinkedHashSet();
            Method[] declaredMethods = this.f11509a.getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (i < length) {
                Method method = declaredMethods[i];
                if (linkedHashSet.add(method.getName())) {
                    i++;
                } else {
                    throw new AssertionError("Method overloading is unsupported: " + this.f11509a.getName() + "#" + method.getName());
                }
            }
        }
    }

    public final String m13464a(Method method) {
        String str = (String) this.f11510b.get(method);
        if (str != null) {
            return str;
        }
        str = "JSCall__" + m13465b() + "_" + method.getName();
        this.f11510b.put(method, str);
        return str;
    }

    public final Class<? extends JavaScriptModule> m13463a() {
        return this.f11509a;
    }

    public final String m13465b() {
        String simpleName = this.f11509a.getSimpleName();
        int lastIndexOf = simpleName.lastIndexOf(36);
        if (lastIndexOf != -1) {
            return simpleName.substring(lastIndexOf + 1);
        }
        return simpleName;
    }
}
