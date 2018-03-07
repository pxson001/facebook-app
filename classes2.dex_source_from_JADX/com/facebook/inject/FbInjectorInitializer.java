package com.facebook.inject;

import android.content.Context;
import com.facebook.inject.testing.OverridesBindings;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.C00451;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: xx */
public class FbInjectorInitializer {
    private static final Class<?> f622a = FbInjectorInitializer.class;
    private final FbInjector f623b;
    private final Context f624c;
    private final List<? extends Module> f625d;
    private final ContextScope f626e;
    private final SingletonScope f627f;
    public final ModuleVerificationConfiguration f628g;
    private final boolean f629h;
    public final boolean f630i;
    private final boolean f631j;
    public final Map<Class<? extends Module>, Binder> f632k = Maps.m838c();
    private final Map<Key, Binding> f633l = Maps.m838c();
    private final Map<Key, ComponentBinding> f634m = Maps.m838c();
    private final Map<Class<? extends Module>, Boolean> f635n = Maps.m840d();
    private final List<Class<? extends LibraryModule>> f636o = Lists.m1296a();
    private final Set<Class<? extends Module>> f637p = Sets.m1313a();
    private final Map<Class<? extends Annotation>, Scope> f638q = Maps.m840d();
    private final Set<Key> f639r = Sets.m1313a();
    private final Map<Key, MultiBinder> f640s = Maps.m838c();
    private final Set<Key> f641t = Sets.m1313a();
    private final BundledAndroidModule f642u;

    /* compiled from: xx */
    class Result {
        final Map<Class<? extends Module>, Binder> f735a;
        final ContextScope f736b;
        final Map<Key, Binding> f737c;
        final Map<Key, ComponentBinding> f738d;
        final List<Class<? extends LibraryModule>> f739e;

        Result(Map<Class<? extends Module>, Binder> map, ContextScope contextScope, Map<Key, Binding> map2, Map<Key, ComponentBinding> map3, List<Class<? extends LibraryModule>> list) {
            this.f735a = map;
            this.f736b = contextScope;
            this.f737c = map2;
            this.f738d = map3;
            this.f739e = list;
        }
    }

    public FbInjectorInitializer(FbInjector fbInjector, Context context, List<? extends Module> list, boolean z, ModuleVerificationConfiguration moduleVerificationConfiguration) {
        this.f623b = fbInjector;
        this.f624c = context;
        this.f625d = list;
        this.f626e = new ContextScope(context);
        this.f627f = new SingletonScope(this.f626e);
        this.f628g = moduleVerificationConfiguration;
        this.f629h = z;
        this.f630i = this.f628g.f614a;
        this.f631j = this.f628g.f615b;
        this.f642u = new BundledAndroidModule(this.f627f, this.f626e, this.f624c);
    }

    public final Result m1294a() {
        TracerDetour.a("FbInjectorImpl.init#modules", -481541808);
        try {
            m1289a(this.f642u);
            for (Module a : this.f625d) {
                m1289a(a);
            }
            m1292c();
            m1293d();
            TracerDetour.a("FbInjectorImpl.init#assertBinding", -1476015234);
            try {
                for (Key key : this.f641t) {
                    if (!this.f633l.containsKey(key) && !this.f630i) {
                        throw new RuntimeException("No binding for required key " + key);
                    }
                }
                this.f641t.clear();
                return new Result(this.f632k, this.f626e, this.f633l, this.f634m, this.f636o);
            } finally {
                TracerDetour.a(-2098152429);
            }
        } finally {
            TracerDetour.a(-1577496951);
        }
    }

    public final void m1295b() {
        TracerDetour.a("FbInjectorInitializer.runPostInitLogic", 1834899794);
        try {
            Iterator it = this.f638q.values().iterator();
            while (it.hasNext()) {
                Scope scope = (Scope) it.next();
                if (scope instanceof ScopeWithInit) {
                    TracerDetour.a("Initializing scope: %s", scope.getClass(), -1470221144);
                    try {
                        ScopeWithInit scopeWithInit = (ScopeWithInit) scope;
                        scopeWithInit.mo195a(this.f623b);
                        TracerDetour.a(scopeWithInit);
                    } finally {
                        int i = 658003394;
                        TracerDetour.a(658003394);
                    }
                }
            }
            if (!this.f631j) {
                this.f642u.m1341a(this.f623b.getModuleInjector(this.f642u.getClass()));
            }
            StaticBindingVerifier.m1534a(this.f633l);
        } finally {
            TracerDetour.a(594430829);
        }
    }

    private void m1289a(Module module) {
        BinderImpl a;
        if (this.f630i) {
            ModuleVerificationConfiguration moduleVerificationConfiguration = this.f628g;
            Preconditions.checkState(moduleVerificationConfiguration.f614a, "Verification mode is disabled.");
            a = moduleVerificationConfiguration.f617d.a();
        } else {
            a = new BinderImpl(module);
        }
        module.configure(a);
        this.f632k.put(module.getClass(), a);
        if (this.f630i) {
            this.f628g.m1273d();
        }
        this.f637p.add(module.getClass());
        this.f638q.putAll(a.m1360h());
        for (Class cls : a.m1359f()) {
            if (!this.f635n.containsKey(cls)) {
                Module a2 = m1287a(cls);
                this.f635n.put(cls, Boolean.valueOf(true));
                m1289a(a2);
                this.f636o.add(cls);
            }
        }
        FbInjector moduleInjector = this.f623b.getModuleInjector(module.getClass());
        for (Binding a3 : a.m1346a()) {
            m1288a(moduleInjector, module, a3, a.m1359f());
        }
        for (ComponentBinding componentBinding : a.m1350b()) {
            this.f634m.put(componentBinding.b, componentBinding);
        }
        this.f639r.addAll(a.m1351c());
        Set c = a.m1351c();
        Set keySet = a.m1354d().keySet();
        Preconditions.checkNotNull(c, "set1");
        Preconditions.checkNotNull(keySet, "set2");
        for (Key key : new C00451(c, Sets.m1326c(keySet, c), keySet)) {
            if (((MultiBinder) this.f640s.get(key)) == null) {
                this.f640s.put(key, new MultiBinder(this.f623b, key));
            }
        }
        for (Entry entry : a.m1354d().entrySet()) {
            Key key2 = (Key) entry.getKey();
            MultiBinder multiBinder = (MultiBinder) this.f640s.get(key2);
            for (Key key3 : ((MultiBinding) entry.getValue()).b) {
                int size = multiBinder.d.size();
                for (int i = 0; i < size; i++) {
                    if (((Key) multiBinder.d.get(i)).equals(key3)) {
                        break;
                    }
                }
                multiBinder.d.add(key3);
            }
            Collections.sort(multiBinder.d, MultiBinder.a);
        }
        this.f641t.addAll(a.m1356e());
        if (module == this.f642u) {
            this.f635n.put(module.getClass(), Boolean.valueOf(true));
        }
    }

    private <T> void m1288a(FbInjector fbInjector, Module module, Binding<T> binding, Set<Class<? extends LibraryModule>> set) {
        Key b = binding.m1387b();
        Provider c = binding.m1389c();
        binding.f674e = c;
        Binding binding2 = (Binding) this.f633l.get(b);
        if (binding2 == null || ((binding2.m1391e() && !binding.m1391e()) || MalformedModuleBindingOverrideWhitelist.a.mo410b(binding2.m1383a(), binding2.m1387b().toString()) || m1291b(module))) {
            Set hashSet = new HashSet();
            for (Class name : set) {
                hashSet.add(name.getName());
            }
            if (binding2 == null || hashSet.contains(binding2.m1383a()) || m1291b(module) || binding2.m1383a() == binding.m1383a() || MalformedModuleBindingOverrideWhitelist.a.mo410b(binding2.m1383a(), binding2.m1387b().toString())) {
                Provider provider;
                if (c instanceof AbstractProvider) {
                    ((AbstractProvider) c).mInjector = fbInjector;
                }
                if (binding.m1390d() == null || this.f630i) {
                    provider = c;
                } else {
                    provider = m1290b(binding.m1390d()).mo194a(c);
                    if (provider instanceof AbstractProvider) {
                        ((AbstractProvider) provider).mInjector = fbInjector;
                    }
                }
                if (this.f629h || this.f630i) {
                    provider = new ProvisioningDebugStackProvider(b, provider);
                }
                binding.f672c = provider;
                this.f633l.put(b, binding);
                return;
            }
            throw new IllegalArgumentException(String.format("Module %s is overriding binding for %s from module %s, but does not require that module. Add %s(base module) in the dependency list of %s.", new Object[]{binding.m1383a().toString(), binding2.m1387b().toString(), binding2.m1383a().toString(), binding2.m1383a().toString(), binding.m1383a().toString()}));
        }
        throw new IllegalArgumentException(String.format("Module %s illegally overriding binding for %s from module %s. Either require module %s(base module) from %s or provide %s as a default binding so it can be overridden in module %s(top module) .", new Object[]{binding.m1383a().toString(), binding2.m1387b().toString(), binding2.m1383a().toString(), binding2.m1383a().toString(), binding.m1383a().toString(), binding2.m1387b().toString(), binding.m1383a().toString()}));
    }

    private static LibraryModule m1287a(Class<? extends LibraryModule> cls) {
        try {
            Constructor constructor = cls.getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return (AbstractLibraryModule) constructor.newInstance(new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to find public default constructor for " + cls, e);
        } catch (Throwable e2) {
            throw new RuntimeException("Failed to invoke constructor for " + cls, e2);
        } catch (Throwable e22) {
            throw new RuntimeException("Failed to instantiate " + cls, e22);
        } catch (Throwable e222) {
            throw new RuntimeException("Failed to access constructor for " + cls, e222);
        }
    }

    private void m1292c() {
        TracerDetour.a("FbInjectorImpl.init#multiBinding", -1993118471);
        try {
            for (MultiBinder multiBinder : this.f640s.values()) {
                Binding binding = new Binding();
                binding.m1384a(multiBinder.c());
                binding.m1385a(multiBinder.b());
                binding.m1388b(multiBinder.b());
                this.f633l.put(multiBinder.c(), binding);
            }
        } finally {
            TracerDetour.a(49504048);
        }
    }

    private void m1293d() {
        int i = 1;
        StringBuilder stringBuilder = null;
        for (MultiBinder multiBinder : this.f640s.values()) {
            int i2;
            Key key = multiBinder.c;
            Binding binding = (Binding) this.f633l.get(key);
            if (binding != null) {
                Object obj;
                StringBuilder stringBuilder2;
                for (Entry entry : this.f632k.entrySet()) {
                    if (((BinderImpl) entry.getValue()).m1346a().contains(binding)) {
                        obj = (Class) entry.getKey();
                        break;
                    }
                }
                obj = null;
                if (stringBuilder == null) {
                    stringBuilder2 = new StringBuilder();
                } else {
                    stringBuilder2 = stringBuilder;
                }
                int i3 = i + 1;
                stringBuilder2.append(i);
                stringBuilder2.append(": ");
                stringBuilder2.append(key).append(" by ").append(obj).append("\n");
                stringBuilder = stringBuilder2;
                i2 = i3;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (stringBuilder != null) {
            throw new IllegalArgumentException("One or more multibind keys were illegally bound:\n" + stringBuilder.toString());
        }
    }

    private Scope m1290b(Class<? extends Annotation> cls) {
        Scope scope = (Scope) this.f638q.get(cls);
        if (scope != null) {
            return scope;
        }
        throw new ProvisioningException("No scope registered for " + cls);
    }

    private static boolean m1291b(Module module) {
        return module instanceof OverridesBindings;
    }
}
