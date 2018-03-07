package com.facebook.inject;

import com.google.inject.Key;
import java.util.ArrayList;
import java.util.List;

/* compiled from: deimpression */
public class ProvisioningDebugStack {
    public static ThreadLocal<List<Object>> f5154a = new C04891();

    /* compiled from: deimpression */
    final class C04891 extends ThreadLocal<List<Object>> {
        C04891() {
        }

        protected final Object initialValue() {
            return new ArrayList();
        }
    }

    /* compiled from: deimpression */
    public class StackEntry {
        final StackType f5152a;
        final Key<?> f5153b;

        public StackEntry(StackType stackType, Key<?> key) {
            this.f5152a = stackType;
            this.f5153b = key;
        }
    }

    /* compiled from: deimpression */
    public enum StackType {
        PROVIDER_GET,
        INSTANCE_GET,
        INJECT_COMPONENT
    }

    ProvisioningDebugStack() {
    }

    public static void m10030a(StackType stackType, Key<?> key) {
        List list = (List) f5154a.get();
        list.add(stackType);
        list.add(key);
    }

    public static void m10029a() {
        List list = (List) f5154a.get();
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
    }
}
