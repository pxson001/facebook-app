package com.facebook.react.cxxbridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.BaseJavaModule$JavaMethod;
import com.facebook.react.bridge.BaseJavaModule$SyncJavaHook;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ExecutorToken;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeModule$NativeMethod;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.WritableNativeArray;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

@DoNotStrip
/* compiled from: getAdminAwareGroup */
class JavaModuleWrapper {
    private final CatalystInstance f11618a;
    private final BaseJavaModule f11619b;
    private final ArrayList<BaseJavaModule$JavaMethod> f11620c = new ArrayList();

    @DoNotStrip
    /* compiled from: getAdminAwareGroup */
    public class MethodDescriptor {
        final /* synthetic */ JavaModuleWrapper f11617a;
        @DoNotStrip
        Method method;
        @DoNotStrip
        String name;
        @DoNotStrip
        String signature;
        @DoNotStrip
        String type;

        public MethodDescriptor(JavaModuleWrapper javaModuleWrapper) {
            this.f11617a = javaModuleWrapper;
        }
    }

    public JavaModuleWrapper(CatalystInstance catalystInstance, BaseJavaModule baseJavaModule) {
        this.f11618a = catalystInstance;
        this.f11619b = baseJavaModule;
    }

    @DoNotStrip
    public BaseJavaModule getModule() {
        return this.f11619b;
    }

    @DoNotStrip
    public String getName() {
        return this.f11619b.getName();
    }

    @DoNotStrip
    public List<MethodDescriptor> getMethodDescriptors() {
        List arrayList = new ArrayList();
        for (Entry entry : this.f11619b.getMethods().entrySet()) {
            MethodDescriptor methodDescriptor = new MethodDescriptor(this);
            methodDescriptor.name = (String) entry.getKey();
            methodDescriptor.type = ((NativeModule$NativeMethod) entry.getValue()).mo640c();
            this.f11620c.add((BaseJavaModule$JavaMethod) entry.getValue());
            arrayList.add(methodDescriptor);
        }
        return arrayList;
    }

    @DoNotStrip
    public List<MethodDescriptor> newGetMethodDescriptors() {
        List arrayList = new ArrayList();
        for (Entry entry : this.f11619b.getMethods().entrySet()) {
            MethodDescriptor methodDescriptor = new MethodDescriptor(this);
            methodDescriptor.name = (String) entry.getKey();
            methodDescriptor.type = ((NativeModule$NativeMethod) entry.getValue()).mo640c();
            BaseJavaModule$JavaMethod baseJavaModule$JavaMethod = (BaseJavaModule$JavaMethod) entry.getValue();
            methodDescriptor.method = baseJavaModule$JavaMethod.f11457b;
            methodDescriptor.signature = baseJavaModule$JavaMethod.f11459d;
            arrayList.add(methodDescriptor);
        }
        for (Entry entry2 : this.f11619b.b().entrySet()) {
            methodDescriptor = new MethodDescriptor(this);
            methodDescriptor.name = (String) entry2.getKey();
            methodDescriptor.type = "syncHook";
            BaseJavaModule$SyncJavaHook baseJavaModule$SyncJavaHook = (BaseJavaModule$SyncJavaHook) entry2.getValue();
            methodDescriptor.method = baseJavaModule$SyncJavaHook.f11465b;
            methodDescriptor.signature = baseJavaModule$SyncJavaHook.f11466c;
            arrayList.add(methodDescriptor);
        }
        return arrayList;
    }

    @DoNotStrip
    public NativeArray getConstants() {
        NativeArray writableNativeArray = new WritableNativeArray();
        writableNativeArray.mo689a(Arguments.m13620a(this.f11619b.a()));
        return writableNativeArray;
    }

    @DoNotStrip
    public boolean supportsWebWorkers() {
        return this.f11619b.f();
    }

    @DoNotStrip
    public void invoke(ExecutorToken executorToken, int i, ReadableNativeArray readableNativeArray) {
        if (this.f11620c != null && i < this.f11620c.size()) {
            ((BaseJavaModule$JavaMethod) this.f11620c.get(i)).invoke(this.f11618a, executorToken, readableNativeArray);
        }
    }
}
