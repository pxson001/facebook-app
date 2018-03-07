package com.facebook.inject;

import android.app.Application;
import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.lang.annotation.Annotation;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: xbutton */
public class ContextScope implements Scope, ScopeWithInit {
    public final Context f643a;
    public FbInjector f644b;
    private final LoadingCache<Context, ContextScopeAwareInjector> f645c = new ContextKeyedLoadingCache(new ContextContextScopeAwareInjectorCacheLoader(this));

    /* compiled from: xbutton */
    class ContextContextScopeAwareInjectorCacheLoader extends CacheLoader<Context, ContextScopeAwareInjector> {
        final /* synthetic */ ContextScope f646a;

        public ContextContextScopeAwareInjectorCacheLoader(ContextScope contextScope) {
            this.f646a = contextScope;
        }

        public final Object mo118a(Object obj) {
            return new ContextScopeAwareInjector(this.f646a.f644b, (Context) obj);
        }
    }

    public ContextScope(Context context) {
        this.f643a = context;
    }

    public final void mo195a(FbInjector fbInjector) {
        this.f644b = fbInjector;
    }

    public InjectorThreadStack getInjectorThreadStack() {
        return this.f644b.getInjectorThreadStack();
    }

    public final <T> Provider<T> mo194a(Provider<T> provider) {
        return new ContextScopedProvider(this, provider);
    }

    public Class<? extends Annotation> annotationType() {
        return ContextScoped.class;
    }

    public final void m1333a(Context context, InjectorThreadStack injectorThreadStack) {
        injectorThreadStack.m1470a((ContextScopeAwareInjector) this.f645c.mo109d(context));
    }

    public static void m1331a(InjectorThreadStack injectorThreadStack) {
        injectorThreadStack.m1472c();
    }

    @Nullable
    public static PropertyBag m1330a(Context context) {
        PropertyBag propertyBag = (PropertyBag) ContextUtils.m2500a(context, PropertyBag.class);
        if (propertyBag != null) {
            return propertyBag;
        }
        if (((Application) ContextUtils.m2500a(context, Application.class)) != null) {
            return null;
        }
        throw new ProvisioningException("Context chain contains neither an Application nor a context which implements PropertyBag");
    }
}
