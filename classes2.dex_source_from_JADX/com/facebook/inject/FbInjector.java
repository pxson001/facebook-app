package com.facebook.inject;

import android.content.Context;
import android.view.View;
import com.facebook.base.app.AbstractApplicationLike;
import com.facebook.common.process.PrivateProcessName;
import com.facebook.common.process.ProcessName;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.MoreTypes.ParameterizedTypeImpl;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/* compiled from: zero_indicator */
public abstract class FbInjector implements InjectorLike {
    private static final LoadingCache<Context, ContextScopeAwareInjector> f539a = new ContextKeyedLoadingCache(new ContextContextScopeAwareInjectorCacheLoader());
    private static AbstractApplicationLike f540b;

    /* compiled from: zero_indicator */
    class ContextContextScopeAwareInjectorCacheLoader extends CacheLoader<Context, ContextScopeAwareInjector> {
        public final Object mo118a(Object obj) {
            Context context = (Context) obj;
            FbInjector a = FbInjector.m1083b(context).m26a();
            if (a != null) {
                return new ContextScopeAwareInjector(a, context);
            }
            throw new IllegalStateException("Can NOT get FbInjector instance! Possible reasons: (1) This method was called in ContentProvider's onCreate. (2) This is a test, and you forgot to initialize the MockInjector. For example, using RobolectricTestUtil.initializeMockInjector().");
        }
    }

    protected abstract <T> void mo160a(Class<T> cls, T t);

    protected abstract boolean mo161a(Key<?> key);

    @DoNotStrip
    public static FbInjector get(Context context) {
        return (FbInjector) f539a.mo109d(context);
    }

    public static FbInjector m1077a(Context context, List<? extends Module> list, PrivateProcessName privateProcessName, boolean z) {
        return new FbInjectorImpl(context, list, new ModuleVerificationConfiguration(false, false, null, null), privateProcessName, z);
    }

    public static <T> Key<Set<T>> m1078a(Class<T> cls, Class<? extends Annotation> cls2) {
        TypeLiteral a = TypeLiteral.m1372a(new ParameterizedTypeImpl(null, Set.class, new Type[]{cls}));
        if (cls2 != null) {
            return Key.m1364a(a, (Class) cls2);
        }
        return Key.m1363a(a);
    }

    public static <T> Key<Set<T>> m1084b(Key<T> key) {
        TypeLiteral a = TypeLiteral.m1372a(new ParameterizedTypeImpl(null, Set.class, new Type[]{key.f664b.f667b}));
        Annotation c = key.m1371c();
        Class b = key.m1370b();
        if (c != null) {
            return new Key(a, Key.m1362a(c));
        }
        if (b != null) {
            return Key.m1364a(a, b);
        }
        return Key.m1363a(a);
    }

    public static void m1082a(String str) {
        throw new ProvisioningException("Invalid annotation: " + str);
    }

    public static <T> void m1081a(Class<T> cls, T t, Context context) {
        TracerDetour.a("FbInjector.injectMe()", 1655510417);
        try {
            get(context).mo160a((Class) cls, (Object) t);
        } finally {
            TracerDetour.a(-2094569713);
        }
    }

    public static <T extends InjectableComponentWithContext> void m1080a(Class<T> cls, T t) {
        m1081a(cls, t, t.getContext());
    }

    public static <T extends View> void m1079a(Class<T> cls, T t) {
        m1081a(cls, t, t.getContext());
    }

    public static AbstractApplicationLike m1083b(Context context) {
        if (f540b != null) {
            return f540b;
        }
        Context applicationContext = context.getApplicationContext();
        while (applicationContext instanceof FbInjectorProviderProvider) {
            applicationContext = ((FbInjectorProviderProvider) applicationContext).P_();
        }
        if (applicationContext instanceof AbstractApplicationLike) {
            return (AbstractApplicationLike) applicationContext;
        }
        throw new UnsupportedOperationException("Injector is not supported in process " + ProcessName.g().b);
    }
}
