package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.ViewManagersPropertyCache.PropSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: friend_finder_legal_manage */
public class ViewManagerPropertyUpdater {
    private static final Map<Class<?>, ViewManagerSetter<?, ?>> f11864a = new HashMap();
    private static final Map<Class<?>, ShadowNodeSetter<?>> f11865b = new HashMap();

    /* compiled from: friend_finder_legal_manage */
    public interface Settable {
        Map<String, String> mo733a();
    }

    /* compiled from: friend_finder_legal_manage */
    public interface ShadowNodeSetter<T extends ReactShadowNode> extends Settable {
        void mo734a(T t, String str, ReactStylesDiffMap reactStylesDiffMap);
    }

    /* compiled from: friend_finder_legal_manage */
    public interface ViewManagerSetter<T extends ViewManager, V extends View> extends Settable {
        void mo739a(T t, V v, String str, ReactStylesDiffMap reactStylesDiffMap);
    }

    /* compiled from: friend_finder_legal_manage */
    class FallbackShadowNodeSetter<T extends ReactShadowNode> implements ShadowNodeSetter<T> {
        private final Map<String, PropSetter> f11862a;

        public FallbackShadowNodeSetter(Class<? extends ReactShadowNode> cls) {
            this.f11862a = ViewManagersPropertyCache.m14120b(cls);
        }

        public final void mo734a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
            PropSetter propSetter = (PropSetter) this.f11862a.get(str);
            if (propSetter != null) {
                propSetter.m14104a(reactShadowNode, reactStylesDiffMap);
            }
        }

        public final Map<String, String> mo733a() {
            Map<String, String> hashMap = new HashMap();
            for (PropSetter propSetter : this.f11862a.values()) {
                hashMap.put(propSetter.f11871a, propSetter.f11872b);
            }
            return hashMap;
        }
    }

    /* compiled from: friend_finder_legal_manage */
    class FallbackViewManagerSetter<T extends ViewManager, V extends View> implements ViewManagerSetter<T, V> {
        private final Map<String, PropSetter> f11863a;

        public FallbackViewManagerSetter(Class<? extends ViewManager> cls) {
            this.f11863a = ViewManagersPropertyCache.m14117a(cls);
        }

        public final void mo739a(T t, V v, String str, ReactStylesDiffMap reactStylesDiffMap) {
            PropSetter propSetter = (PropSetter) this.f11863a.get(str);
            if (propSetter != null) {
                propSetter.m14105a(t, v, reactStylesDiffMap);
            }
        }

        public final Map<String, String> mo733a() {
            Map<String, String> hashMap = new HashMap();
            for (PropSetter propSetter : this.f11863a.values()) {
                hashMap.put(propSetter.f11871a, propSetter.f11872b);
            }
            return hashMap;
        }
    }

    public static <T extends ViewManager, V extends View> void m14098a(T t, V v, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerSetter a = m14095a(t.getClass());
        ReadableMapKeySetIterator a2 = reactStylesDiffMap.f11766a.mo679a();
        while (a2.hasNextKey()) {
            a.mo739a(t, v, a2.nextKey(), reactStylesDiffMap);
        }
    }

    public static <T extends ReactShadowNode> void m14097a(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ShadowNodeSetter b = m14099b(t.getClass());
        ReadableMapKeySetIterator a = reactStylesDiffMap.f11766a.mo679a();
        while (a.hasNextKey()) {
            b.mo734a(t, a.nextKey(), reactStylesDiffMap);
        }
    }

    public static Map<String, String> m14096a(Class<? extends ViewManager> cls, Class<? extends ReactShadowNode> cls2) {
        Map<String, String> hashMap = new HashMap();
        hashMap.putAll(m14095a(cls).mo733a());
        hashMap.putAll(m14099b(cls2).mo733a());
        return hashMap;
    }

    private static <T extends ViewManager, V extends View> ViewManagerSetter<T, V> m14095a(Class<? extends ViewManager> cls) {
        ViewManagerSetter<T, V> viewManagerSetter = (ViewManagerSetter) f11864a.get(cls);
        if (viewManagerSetter == null) {
            viewManagerSetter = (ViewManagerSetter) m14100c(cls);
            if (viewManagerSetter == null) {
                viewManagerSetter = new FallbackViewManagerSetter(cls);
            }
            f11864a.put(cls, viewManagerSetter);
        }
        return viewManagerSetter;
    }

    private static <T extends ReactShadowNode> ShadowNodeSetter<T> m14099b(Class<? extends ReactShadowNode> cls) {
        ShadowNodeSetter<T> shadowNodeSetter = (ShadowNodeSetter) f11865b.get(cls);
        if (shadowNodeSetter == null) {
            shadowNodeSetter = (ShadowNodeSetter) m14100c(cls);
            if (shadowNodeSetter == null) {
                shadowNodeSetter = new FallbackShadowNodeSetter(cls);
            }
            f11865b.put(cls, shadowNodeSetter);
        }
        return shadowNodeSetter;
    }

    private static <T> T m14100c(Class<?> cls) {
        Throwable e;
        String name = cls.getName();
        try {
            return Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException e2) {
            FLog.a("ViewManagerPropertyUpdater", "Could not find generated setter for " + cls);
            return null;
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e);
        }
    }
}
