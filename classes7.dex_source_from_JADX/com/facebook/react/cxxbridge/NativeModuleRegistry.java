package com.facebook.react.cxxbridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.common.MapBuilder;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: group_address */
public class NativeModuleRegistry {
    private final Map<Class<NativeModule>, NativeModule> f11622a;
    private final ArrayList<OnBatchCompleteListener> f11623b;

    /* compiled from: group_address */
    public class Builder {
        private final HashMap<String, NativeModule> f11621a = MapBuilder.m13603a();

        public final Builder m13669a(NativeModule nativeModule) {
            NativeModule nativeModule2 = (NativeModule) this.f11621a.get(nativeModule.getName());
            if (nativeModule2 == null || nativeModule.d()) {
                this.f11621a.put(nativeModule.getName(), nativeModule);
                return this;
            }
            throw new IllegalStateException("Native module " + nativeModule.getClass().getSimpleName() + " tried to override " + nativeModule2.getClass().getSimpleName() + " for module name " + nativeModule.getName() + ". If this was your intention, return true from " + nativeModule.getClass().getSimpleName() + "#canOverrideExistingModule()");
        }

        public final NativeModuleRegistry m13670a() {
            Map hashMap = new HashMap();
            for (NativeModule nativeModule : this.f11621a.values()) {
                hashMap.put(nativeModule.getClass(), nativeModule);
            }
            return new NativeModuleRegistry(hashMap);
        }
    }

    public NativeModuleRegistry(Map<Class<NativeModule>, NativeModule> map) {
        this.f11622a = map;
        this.f11623b = new ArrayList(this.f11622a.size());
        for (NativeModule nativeModule : this.f11622a.values()) {
            if (nativeModule instanceof OnBatchCompleteListener) {
                this.f11623b.add((OnBatchCompleteListener) nativeModule);
            }
        }
    }

    final ModuleRegistryHolder m13672a(CatalystInstanceImpl catalystInstanceImpl) {
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        for (NativeModule nativeModule : this.f11622a.values()) {
            if (nativeModule instanceof BaseJavaModule) {
                arrayList.add(new JavaModuleWrapper(catalystInstanceImpl, (BaseJavaModule) nativeModule));
            } else if (nativeModule instanceof CxxModuleWrapper) {
                arrayList2.add((CxxModuleWrapper) nativeModule);
            } else {
                throw new IllegalArgumentException("Unknown module type " + nativeModule.getClass());
            }
        }
        return new ModuleRegistryHolder(catalystInstanceImpl, arrayList, arrayList2);
    }

    final void m13673a() {
        UiThreadUtil.m13677a();
        Systrace.a(8192, "NativeModuleRegistry_notifyCatalystInstanceDestroy");
        try {
            for (NativeModule e : this.f11622a.values()) {
                e.e();
            }
        } finally {
            Systrace.a(8192);
        }
    }

    final void m13674b() {
        UiThreadUtil.m13677a();
        ReactMarker.logMarker("NativeModule_start");
        Systrace.a(8192, "NativeModuleRegistry_notifyCatalystInstanceInitialized");
        try {
            for (NativeModule c : this.f11622a.values()) {
                c.c();
            }
        } finally {
            Systrace.a(8192);
            ReactMarker.logMarker("NativeModule_end");
        }
    }

    public final void m13675c() {
        for (int i = 0; i < this.f11623b.size(); i++) {
            ((OnBatchCompleteListener) this.f11623b.get(i)).hi_();
        }
    }

    public final <T extends NativeModule> T m13671a(Class<T> cls) {
        return (NativeModule) Assertions.b(this.f11622a.get(cls));
    }
}
