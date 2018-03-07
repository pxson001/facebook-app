package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: fragment_pause */
class ViewManagersPropertyCache {
    private static final Map<Class, Map<String, PropSetter>> f11879a = new HashMap();
    private static final Map<String, PropSetter> f11880b = new HashMap();

    /* compiled from: fragment_pause */
    public abstract class PropSetter {
        private static final Object[] f11867e = new Object[2];
        private static final Object[] f11868f = new Object[3];
        private static final Object[] f11869g = new Object[1];
        private static final Object[] f11870h = new Object[2];
        public final String f11871a;
        public final String f11872b;
        protected final Method f11873c;
        @Nullable
        protected final Integer f11874d;

        @Nullable
        protected abstract Object mo751a(ReactStylesDiffMap reactStylesDiffMap);

        public PropSetter(ReactProp reactProp, String str, Method method) {
            this.f11871a = reactProp.name();
            if (!"__default_type__".equals(reactProp.customType())) {
                str = reactProp.customType();
            }
            this.f11872b = str;
            this.f11873c = method;
            this.f11874d = null;
        }

        public PropSetter(ReactPropGroup reactPropGroup, String str, Method method, int i) {
            this.f11871a = reactPropGroup.m14127a()[i];
            if (!"__default_type__".equals(reactPropGroup.customType())) {
                str = reactPropGroup.customType();
            }
            this.f11872b = str;
            this.f11873c = method;
            this.f11874d = Integer.valueOf(i);
        }

        public final String m14103a() {
            return this.f11871a;
        }

        public final String m14106b() {
            return this.f11872b;
        }

        public final void m14105a(ViewManager viewManager, View view, ReactStylesDiffMap reactStylesDiffMap) {
            try {
                if (this.f11874d == null) {
                    f11867e[0] = view;
                    f11867e[1] = mo751a(reactStylesDiffMap);
                    this.f11873c.invoke(viewManager, f11867e);
                    Arrays.fill(f11867e, null);
                    return;
                }
                f11868f[0] = view;
                f11868f[1] = this.f11874d;
                f11868f[2] = mo751a(reactStylesDiffMap);
                this.f11873c.invoke(viewManager, f11868f);
                Arrays.fill(f11868f, null);
            } catch (Throwable th) {
                FLog.a(ViewManager.class, "Error while updating prop " + this.f11871a, th);
                JSApplicationIllegalArgumentException jSApplicationIllegalArgumentException = new JSApplicationIllegalArgumentException("Error while updating property '" + this.f11871a + "' of a view managed by: " + viewManager.mo744a(), th);
            }
        }

        public final void m14104a(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
            try {
                if (this.f11874d == null) {
                    f11869g[0] = mo751a(reactStylesDiffMap);
                    this.f11873c.invoke(reactShadowNode, f11869g);
                    Arrays.fill(f11869g, null);
                    return;
                }
                f11870h[0] = this.f11874d;
                f11870h[1] = mo751a(reactStylesDiffMap);
                this.f11873c.invoke(reactShadowNode, f11870h);
                Arrays.fill(f11870h, null);
            } catch (Throwable th) {
                FLog.a(ViewManager.class, "Error while updating prop " + this.f11871a, th);
                JSApplicationIllegalArgumentException jSApplicationIllegalArgumentException = new JSApplicationIllegalArgumentException("Error while updating property '" + this.f11871a + "' in shadow node of type: " + reactShadowNode.m13853u(), th);
            }
        }
    }

    /* compiled from: fragment_pause */
    class ArrayPropSetter extends PropSetter {
        public ArrayPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "Array", method);
        }

        @Nullable
        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.m13946d(this.f11871a);
        }
    }

    /* compiled from: fragment_pause */
    class BooleanPropSetter extends PropSetter {
        private final boolean f11875e;

        public BooleanPropSetter(ReactProp reactProp, Method method, boolean z) {
            super(reactProp, "boolean", method);
            this.f11875e = z;
        }

        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.m13943a(this.f11871a, this.f11875e) ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    /* compiled from: fragment_pause */
    class BoxedBooleanPropSetter extends PropSetter {
        public BoxedBooleanPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "boolean", method);
        }

        @Nullable
        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            if (reactStylesDiffMap.m13944b(this.f11871a)) {
                return null;
            }
            return reactStylesDiffMap.m13943a(this.f11871a, false) ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    /* compiled from: fragment_pause */
    class BoxedIntPropSetter extends PropSetter {
        public BoxedIntPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "number", method);
        }

        public BoxedIntPropSetter(ReactPropGroup reactPropGroup, Method method, int i) {
            super(reactPropGroup, "number", method, i);
        }

        @Nullable
        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            if (reactStylesDiffMap.m13944b(this.f11871a)) {
                return null;
            }
            return Integer.valueOf(reactStylesDiffMap.m13941a(this.f11871a, 0));
        }
    }

    /* compiled from: fragment_pause */
    class DoublePropSetter extends PropSetter {
        private final double f11876e;

        public DoublePropSetter(ReactProp reactProp, Method method, double d) {
            super(reactProp, "number", method);
            this.f11876e = d;
        }

        public DoublePropSetter(ReactPropGroup reactPropGroup, Method method, int i, double d) {
            super(reactPropGroup, "number", method, i);
            this.f11876e = d;
        }

        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            return Double.valueOf(reactStylesDiffMap.m13939a(this.f11871a, this.f11876e));
        }
    }

    /* compiled from: fragment_pause */
    class FloatPropSetter extends PropSetter {
        private final float f11877e;

        public FloatPropSetter(ReactProp reactProp, Method method, float f) {
            super(reactProp, "number", method);
            this.f11877e = f;
        }

        public FloatPropSetter(ReactPropGroup reactPropGroup, Method method, int i, float f) {
            super(reactPropGroup, "number", method, i);
            this.f11877e = f;
        }

        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            return Float.valueOf(reactStylesDiffMap.m13940a(this.f11871a, this.f11877e));
        }
    }

    /* compiled from: fragment_pause */
    class IntPropSetter extends PropSetter {
        private final int f11878e;

        public IntPropSetter(ReactProp reactProp, Method method, int i) {
            super(reactProp, "number", method);
            this.f11878e = i;
        }

        public IntPropSetter(ReactPropGroup reactPropGroup, Method method, int i, int i2) {
            super(reactPropGroup, "number", method, i);
            this.f11878e = i2;
        }

        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            return Integer.valueOf(reactStylesDiffMap.m13941a(this.f11871a, this.f11878e));
        }
    }

    /* compiled from: fragment_pause */
    class MapPropSetter extends PropSetter {
        public MapPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "Map", method);
        }

        @Nullable
        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.m13947e(this.f11871a);
        }
    }

    /* compiled from: fragment_pause */
    class StringPropSetter extends PropSetter {
        public StringPropSetter(ReactProp reactProp, Method method) {
            super(reactProp, "String", method);
        }

        @Nullable
        protected final Object mo751a(ReactStylesDiffMap reactStylesDiffMap) {
            return reactStylesDiffMap.m13945c(this.f11871a);
        }
    }

    ViewManagersPropertyCache() {
    }

    static Map<String, PropSetter> m14117a(Class<? extends ViewManager> cls) {
        if (cls == ViewManager.class) {
            return f11880b;
        }
        Map<String, PropSetter> map = (Map) f11879a.get(cls);
        if (map != null) {
            return map;
        }
        map = new HashMap(m14117a(cls.getSuperclass()));
        m14119a(cls, map);
        f11879a.put(cls, map);
        return map;
    }

    static Map<String, PropSetter> m14120b(Class<? extends ReactShadowNode> cls) {
        if (cls == ReactShadowNode.class) {
            return f11880b;
        }
        Map<String, PropSetter> map = (Map) f11879a.get(cls);
        if (map != null) {
            return map;
        }
        map = new HashMap(m14120b(cls.getSuperclass()));
        m14121b(cls, map);
        f11879a.put(cls, map);
        return map;
    }

    private static PropSetter m14116a(ReactProp reactProp, Method method, Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return new BooleanPropSetter(reactProp, method, reactProp.m14126d());
        }
        if (cls == Integer.TYPE) {
            return new IntPropSetter(reactProp, method, reactProp.m14125c());
        }
        if (cls == Float.TYPE) {
            return new FloatPropSetter(reactProp, method, reactProp.m14124b());
        }
        if (cls == Double.TYPE) {
            return new DoublePropSetter(reactProp, method, reactProp.m14123a());
        }
        if (cls == String.class) {
            return new StringPropSetter(reactProp, method);
        }
        if (cls == Boolean.class) {
            return new BoxedBooleanPropSetter(reactProp, method);
        }
        if (cls == Integer.class) {
            return new BoxedIntPropSetter(reactProp, method);
        }
        if (cls == ReadableArray.class) {
            return new ArrayPropSetter(reactProp, method);
        }
        if (cls == ReadableMap.class) {
            return new MapPropSetter(reactProp, method);
        }
        throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
    }

    private static void m14118a(ReactPropGroup reactPropGroup, Method method, Class<?> cls, Map<String, PropSetter> map) {
        int i = 0;
        String[] a = reactPropGroup.m14127a();
        if (cls == Integer.TYPE) {
            while (i < a.length) {
                map.put(a[i], new IntPropSetter(reactPropGroup, method, i, reactPropGroup.m14130d()));
                i++;
            }
        } else if (cls == Float.TYPE) {
            while (i < a.length) {
                map.put(a[i], new FloatPropSetter(reactPropGroup, method, i, reactPropGroup.m14128b()));
                i++;
            }
        } else if (cls == Double.TYPE) {
            for (int i2 = 0; i2 < a.length; i2++) {
                map.put(a[i2], new DoublePropSetter(reactPropGroup, method, i2, reactPropGroup.m14129c()));
            }
        } else if (cls == Integer.class) {
            while (i < a.length) {
                map.put(a[i], new BoxedIntPropSetter(reactPropGroup, method, i));
                i++;
            }
        } else {
            throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
        }
    }

    private static void m14119a(Class<? extends ViewManager> cls, Map<String, PropSetter> map) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class[] parameterTypes;
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                } else if (View.class.isAssignableFrom(parameterTypes[0])) {
                    map.put(reactProp.name(), m14116a(reactProp, method, parameterTypes[1]));
                } else {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                }
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 3) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                } else if (!View.class.isAssignableFrom(parameterTypes[0])) {
                    throw new RuntimeException("First param should be a view subclass to be updated: " + cls.getName() + "#" + method.getName());
                } else if (parameterTypes[1] != Integer.TYPE) {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                } else {
                    m14118a(reactPropGroup, method, parameterTypes[2], map);
                }
            }
        }
    }

    private static void m14121b(Class<? extends ReactShadowNode> cls, Map<String, PropSetter> map) {
        for (Method method : cls.getDeclaredMethods()) {
            Class[] parameterTypes;
            ReactProp reactProp = (ReactProp) method.getAnnotation(ReactProp.class);
            if (reactProp != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
                map.put(reactProp.name(), m14116a(reactProp, method, parameterTypes[0]));
            }
            ReactPropGroup reactPropGroup = (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
            if (reactPropGroup != null) {
                parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 2) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                } else if (parameterTypes[0] != Integer.TYPE) {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                } else {
                    m14118a(reactPropGroup, method, parameterTypes[1], map);
                }
            }
        }
    }
}
