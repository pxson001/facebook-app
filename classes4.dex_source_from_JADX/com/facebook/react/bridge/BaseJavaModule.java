package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeModule.NativeMethod;
import com.facebook.systrace.Systrace;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: marauder_beacon */
public abstract class BaseJavaModule implements NativeModule {
    public static final ArgumentExtractor<Boolean> f8347a = new C04001();
    public static final ArgumentExtractor<Double> f8348b = new C04012();
    public static final ArgumentExtractor<Float> f8349c = new C04023();
    public static final ArgumentExtractor<Integer> f8350d = new C04034();
    public static final ArgumentExtractor<String> f8351e = new C04045();
    public static final ArgumentExtractor<ReadableNativeArray> f8352f = new C04056();
    public static final ArgumentExtractor<ReadableMap> f8353g = new C04067();
    public static final ArgumentExtractor<Callback> f8354h = new C04078();
    public static final ArgumentExtractor<Promise> f8355i = new C04089();
    @Nullable
    private Map<String, NativeMethod> f8356j;
    @Nullable
    private Map<String, Object> f8357k;

    /* compiled from: marauder_beacon */
    final class C04001 extends ArgumentExtractor<Boolean> {
        C04001() {
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return Boolean.valueOf(readableNativeArray.getBoolean(i));
        }
    }

    /* compiled from: marauder_beacon */
    abstract class ArgumentExtractor<T> {
        @Nullable
        public abstract T mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i);

        public int mo681a() {
            return 1;
        }
    }

    /* compiled from: marauder_beacon */
    final class C04012 extends ArgumentExtractor<Double> {
        C04012() {
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return Double.valueOf(readableNativeArray.getDouble(i));
        }
    }

    /* compiled from: marauder_beacon */
    final class C04023 extends ArgumentExtractor<Float> {
        C04023() {
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return Float.valueOf((float) readableNativeArray.getDouble(i));
        }
    }

    /* compiled from: marauder_beacon */
    final class C04034 extends ArgumentExtractor<Integer> {
        C04034() {
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return Integer.valueOf((int) readableNativeArray.getDouble(i));
        }
    }

    /* compiled from: marauder_beacon */
    final class C04045 extends ArgumentExtractor<String> {
        C04045() {
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return readableNativeArray.getString(i);
        }
    }

    /* compiled from: marauder_beacon */
    final class C04056 extends ArgumentExtractor<ReadableNativeArray> {
        C04056() {
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return readableNativeArray.getArray(i);
        }
    }

    /* compiled from: marauder_beacon */
    final class C04067 extends ArgumentExtractor<ReadableMap> {
        C04067() {
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return readableNativeArray.getMap(i);
        }
    }

    /* compiled from: marauder_beacon */
    final class C04078 extends ArgumentExtractor<Callback> {
        C04078() {
        }

        @Nullable
        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            if (readableNativeArray.isNull(i)) {
                return null;
            }
            return new CallbackImpl(catalystInstance, executorToken, (int) readableNativeArray.getDouble(i));
        }
    }

    /* compiled from: marauder_beacon */
    final class C04089 extends ArgumentExtractor<Promise> {
        C04089() {
        }

        public final int mo681a() {
            return 2;
        }

        public final Object mo680a(CatalystInstance catalystInstance, ExecutorToken executorToken, ReadableNativeArray readableNativeArray, int i) {
            return new PromiseImpl((Callback) BaseJavaModule.f8354h.mo680a(catalystInstance, executorToken, readableNativeArray, i), (Callback) BaseJavaModule.f8354h.mo680a(catalystInstance, executorToken, readableNativeArray, i + 1));
        }
    }

    private void m8621p() {
        if (this.f8356j == null) {
            Systrace.a(8192, "findMethods");
            this.f8356j = new HashMap();
            this.f8357k = new HashMap();
            for (Method method : getClass().getDeclaredMethods()) {
                String name;
                if (method.getAnnotation(ReactMethod.class) != null) {
                    name = method.getName();
                    if (this.f8357k.containsKey(name) || this.f8356j.containsKey(name)) {
                        throw new IllegalArgumentException("Java Module " + getName() + " sync method name already registered: " + name);
                    }
                    this.f8356j.put(name, new JavaMethod(this, method));
                }
                if (method.getAnnotation(ReactSyncHook.class) != null) {
                    name = method.getName();
                    if (this.f8357k.containsKey(name) || this.f8356j.containsKey(name)) {
                        throw new IllegalArgumentException("Java Module " + getName() + " sync method name already registered: " + name);
                    }
                    this.f8357k.put(name, new SyncJavaHook(this, method));
                }
            }
            Systrace.a(8192);
        }
    }

    public final Map<String, NativeMethod> getMethods() {
        m8621p();
        return (Map) Assertions.b(this.f8356j);
    }

    @Nullable
    public Map<String, Object> m8622a() {
        return null;
    }

    public final Map<String, Object> m8624b() {
        m8621p();
        return (Map) Assertions.b(this.f8357k);
    }

    public final void mo675a(JsonWriter jsonWriter, String str) {
        Map a = m8622a();
        if (a != null && !a.isEmpty()) {
            jsonWriter.a(str).c();
            for (Entry entry : a.entrySet()) {
                jsonWriter.a((String) entry.getKey());
                JsonWriterHelper.a(jsonWriter, entry.getValue());
            }
            jsonWriter.d();
        }
    }

    public void mo676c() {
    }

    public boolean mo673d() {
        return false;
    }

    public void mo677e() {
    }

    public boolean mo678f() {
        return false;
    }

    public static char m8609c(Class cls) {
        char e = m8611e(cls);
        if (e != '\u0000') {
            return e;
        }
        if (cls == ExecutorToken.class) {
            return 'T';
        }
        if (cls == Callback.class) {
            return 'X';
        }
        if (cls == Promise.class) {
            return 'P';
        }
        if (cls == ReadableMap.class) {
            return 'M';
        }
        if (cls == ReadableArray.class) {
            return 'A';
        }
        throw new RuntimeException("Got unknown param class: " + cls.getSimpleName());
    }

    public static char m8610d(Class cls) {
        char e = m8611e(cls);
        if (e != '\u0000') {
            return e;
        }
        if (cls == Void.TYPE) {
            return 'v';
        }
        if (cls == WritableMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class) {
            return 'A';
        }
        throw new RuntimeException("Got unknown return class: " + cls.getSimpleName());
    }

    private static char m8611e(Class cls) {
        if (cls == Boolean.TYPE) {
            return 'z';
        }
        if (cls == Boolean.class) {
            return 'Z';
        }
        if (cls == Integer.TYPE) {
            return 'i';
        }
        if (cls == Integer.class) {
            return 'I';
        }
        if (cls == Double.TYPE) {
            return 'd';
        }
        if (cls == Double.class) {
            return 'D';
        }
        if (cls == Float.TYPE) {
            return 'f';
        }
        if (cls == Float.class) {
            return 'F';
        }
        if (cls == String.class) {
            return 'S';
        }
        return '\u0000';
    }
}
