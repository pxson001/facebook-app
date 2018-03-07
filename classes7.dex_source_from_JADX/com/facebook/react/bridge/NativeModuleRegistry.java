package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.MapBuilder;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: group_address */
public class NativeModuleRegistry {
    private final List<ModuleDefinition> f11528a;
    private final Map<Class<? extends NativeModule>, NativeModule> f11529b;
    private final ArrayList<OnBatchCompleteListener> f11530c;
    private final ArrayList<OnExecutorUnregisteredListener> f11531d;

    /* compiled from: group_address */
    public class Builder {
        private final HashMap<String, NativeModule> f11520a = MapBuilder.m13603a();

        public final Builder m13490a(NativeModule nativeModule) {
            NativeModule nativeModule2 = (NativeModule) this.f11520a.get(nativeModule.getName());
            if (nativeModule2 == null || nativeModule.d()) {
                this.f11520a.put(nativeModule.getName(), nativeModule);
                return this;
            }
            throw new IllegalStateException("Native module " + nativeModule.getClass().getSimpleName() + " tried to override " + nativeModule2.getClass().getSimpleName() + " for module name " + nativeModule.getName() + ". If this was your intention, return true from " + nativeModule.getClass().getSimpleName() + "#canOverrideExistingModule()");
        }

        public final NativeModuleRegistry m13491a() {
            List arrayList = new ArrayList();
            Map hashMap = new HashMap();
            int i = 0;
            for (NativeModule nativeModule : this.f11520a.values()) {
                int i2 = i + 1;
                arrayList.add(new ModuleDefinition(i, nativeModule.getName(), nativeModule));
                hashMap.put(nativeModule.getClass(), nativeModule);
                i = i2;
            }
            return new NativeModuleRegistry(arrayList, hashMap);
        }
    }

    /* compiled from: group_address */
    class MethodRegistration {
        public String f11521a;
        public String f11522b;
        public NativeModule$NativeMethod f11523c;

        public MethodRegistration(String str, String str2, NativeModule$NativeMethod nativeModule$NativeMethod) {
            this.f11521a = str;
            this.f11522b = str2;
            this.f11523c = nativeModule$NativeMethod;
        }
    }

    /* compiled from: group_address */
    class ModuleDefinition {
        public final int f11524a;
        public final String f11525b;
        public final NativeModule f11526c;
        public final ArrayList<MethodRegistration> f11527d = new ArrayList();

        public ModuleDefinition(int i, String str, NativeModule nativeModule) {
            this.f11524a = i;
            this.f11525b = str;
            this.f11526c = nativeModule;
            for (Entry entry : nativeModule.getMethods().entrySet()) {
                this.f11527d.add(new MethodRegistration((String) entry.getKey(), "NativeCall__" + nativeModule.getName() + "_" + ((String) entry.getKey()), (NativeModule$NativeMethod) entry.getValue()));
            }
        }

        public final void m13492a(CatalystInstance catalystInstance, ExecutorToken executorToken, int i, ReadableNativeArray readableNativeArray) {
            Systrace.a(8192, ((MethodRegistration) this.f11527d.get(i)).f11522b);
            try {
                ((MethodRegistration) this.f11527d.get(i)).f11523c.invoke(catalystInstance, executorToken, readableNativeArray);
            } finally {
                Systrace.a(8192);
            }
        }
    }

    public NativeModuleRegistry(List<ModuleDefinition> list, Map<Class<? extends NativeModule>, NativeModule> map) {
        this.f11528a = list;
        this.f11529b = map;
        this.f11530c = new ArrayList(this.f11528a.size());
        this.f11531d = new ArrayList(this.f11528a.size());
        for (int i = 0; i < this.f11528a.size(); i++) {
            ModuleDefinition moduleDefinition = (ModuleDefinition) this.f11528a.get(i);
            if (moduleDefinition.f11526c instanceof OnBatchCompleteListener) {
                this.f11530c.add((OnBatchCompleteListener) moduleDefinition.f11526c);
            }
            if (moduleDefinition.f11526c instanceof OnExecutorUnregisteredListener) {
                this.f11531d.add((OnExecutorUnregisteredListener) moduleDefinition.f11526c);
            }
        }
    }

    final void m13495a(CatalystInstance catalystInstance, ExecutorToken executorToken, int i, int i2, ReadableNativeArray readableNativeArray) {
        ModuleDefinition moduleDefinition = (ModuleDefinition) this.f11528a.get(i);
        if (moduleDefinition == null) {
            throw new RuntimeException("Call to unknown module: " + i);
        }
        moduleDefinition.m13492a(catalystInstance, executorToken, i2, readableNativeArray);
    }

    final void m13497a(JsonWriter jsonWriter) {
        Systrace.a(8192, "CreateJSON");
        try {
            jsonWriter.m13482c();
            for (ModuleDefinition moduleDefinition : this.f11528a) {
                jsonWriter.m13478a(moduleDefinition.f11525b).m13482c();
                jsonWriter.m13478a("moduleID").m13476a((long) moduleDefinition.f11524a);
                jsonWriter.m13478a("supportsWebWorkers").m13479a(moduleDefinition.f11526c.f());
                jsonWriter.m13478a("methods").m13482c();
                for (int i = 0; i < moduleDefinition.f11527d.size(); i++) {
                    MethodRegistration methodRegistration = (MethodRegistration) moduleDefinition.f11527d.get(i);
                    jsonWriter.m13478a(methodRegistration.f11521a).m13482c();
                    jsonWriter.m13478a("methodID").m13476a((long) i);
                    jsonWriter.m13478a("type").m13481b(methodRegistration.f11523c.mo640c());
                    jsonWriter.m13484d();
                }
                jsonWriter.m13484d();
                moduleDefinition.f11526c.a(jsonWriter, "constants");
                jsonWriter.m13484d();
            }
            jsonWriter.m13484d();
        } finally {
            Systrace.a(8192);
        }
    }

    final void m13494a() {
        UiThreadUtil.m13554b();
        Systrace.a(8192, "NativeModuleRegistry_notifyCatalystInstanceDestroy");
        try {
            for (NativeModule e : this.f11529b.values()) {
                e.e();
            }
        } finally {
            Systrace.a(8192);
        }
    }

    final void m13499b() {
        UiThreadUtil.m13554b();
        ReactMarker.logMarker("NativeModule_start");
        Systrace.a(8192, "NativeModuleRegistry_notifyCatalystInstanceInitialized");
        try {
            for (NativeModule c : this.f11529b.values()) {
                c.c();
            }
        } finally {
            Systrace.a(8192);
            ReactMarker.logMarker("NativeModule_end");
        }
    }

    final void m13498a(ReactBridge reactBridge) {
        Systrace.a(8192, "NativeModuleRegistry_notifyReactBridgeInitialized");
        try {
            Iterator it = this.f11529b.values().iterator();
            while (it.hasNext()) {
                it.next();
            }
        } finally {
            Systrace.a(8192);
        }
    }

    public final void m13500c() {
        for (int i = 0; i < this.f11530c.size(); i++) {
            ((OnBatchCompleteListener) this.f11530c.get(i)).hi_();
        }
    }

    public final void m13496a(ExecutorToken executorToken) {
        for (int i = 0; i < this.f11531d.size(); i++) {
            ((OnExecutorUnregisteredListener) this.f11531d.get(i)).mo723a(executorToken);
        }
    }

    public final <T extends NativeModule> T m13493a(Class<T> cls) {
        return (NativeModule) Assertions.b(this.f11529b.get(cls));
    }
}
