package com.facebook.inject;

import com.facebook.inject.binder.AnnotatedBindingBuilder;
import com.facebook.inject.binder.AnnotatedBindingBuilderImpl;
import com.facebook.inject.binder.LinkedBindingBuilder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: x-fb-request-flatbuffer-schema */
public class BinderImpl {
    public final Module f654a;
    private List<Binding> f655b;
    public List<ComponentBinding> f656c;
    private Map<Key, MultiBinding> f657d;
    public Set<Key> f658e;
    private Set<Key> f659f;
    private Set<Class<? extends LibraryModule>> f660g;
    public Set<Class<? extends Module>> f661h;
    public Map<Class<? extends Annotation>, Scope> f662i;

    public BinderImpl(Module module) {
        this.f654a = module;
    }

    public final <T> AnnotatedBindingBuilder<T> m1344a(Class<T> cls) {
        return new AnnotatedBindingBuilderImpl(m1342f(Key.m1365a((Class) cls)));
    }

    public final <T> LinkedBindingBuilder<T> m1345a(Key<T> key) {
        return new AnnotatedBindingBuilderImpl(m1342f((Key) key));
    }

    public final <T> AnnotatedBindingBuilder<T> m1348b(Class<T> cls) {
        Binding f = m1342f(Key.m1365a((Class) cls));
        f.m1386a(true);
        return new AnnotatedBindingBuilderImpl(f);
    }

    public final <T> LinkedBindingBuilder<T> m1349b(Key<T> key) {
        Binding f = m1342f((Key) key);
        f.m1386a(true);
        return new AnnotatedBindingBuilderImpl(f);
    }

    public final <T> void m1355d(Class<? extends AssistedProvider<T>> cls) {
        m1344a((Class) cls).mo198a(new AssistedProviderProvider(cls));
    }

    public final void m1352c(Key<?> key) {
        if (this.f659f == null) {
            this.f659f = Sets.m1313a();
        }
        this.f659f.add(key);
    }

    public final <T> MultiBinding<T> m1358f(Class<T> cls) {
        return m1343h(Key.m1365a((Class) cls));
    }

    public final <T> MultiBinding<T> m1347b(Class<T> cls, Class<? extends Annotation> cls2) {
        return m1343h(Key.m1366a((Class) cls, (Class) cls2));
    }

    public final <T> MultiBinding<T> m1353d(Key<T> key) {
        return m1343h((Key) key);
    }

    public final List<Binding> m1346a() {
        return this.f655b != null ? this.f655b : RegularImmutableList.f535a;
    }

    public final List<ComponentBinding> m1350b() {
        return this.f656c != null ? this.f656c : RegularImmutableList.f535a;
    }

    public final Set<Key> m1351c() {
        return this.f659f != null ? this.f659f : RegularImmutableSet.f688a;
    }

    public final Map<Key, MultiBinding> m1354d() {
        return this.f657d != null ? this.f657d : RegularImmutableBiMap.f695a;
    }

    private <T> Binding<T> m1342f(Key<T> key) {
        if (this.f655b == null) {
            this.f655b = Lists.m1296a();
        }
        Binding<T> binding = new Binding();
        binding.f670a = this.f654a.getClass().getName();
        binding.f671b = key;
        this.f655b.add(binding);
        return binding;
    }

    private <T> MultiBinding<T> m1343h(Key<T> key) {
        if (this.f657d == null) {
            this.f657d = Maps.m838c();
        }
        MultiBinding<T> multiBinding = (MultiBinding) this.f657d.get(key);
        if (multiBinding != null) {
            return multiBinding;
        }
        multiBinding = new MultiBinding(key);
        this.f657d.put(key, multiBinding);
        return multiBinding;
    }

    public final <T> void m1357e(Key<T> key) {
        if (this.f658e == null) {
            this.f658e = Sets.m1313a();
        }
        this.f658e.add(key);
    }

    public final Set<Key> m1356e() {
        return this.f658e != null ? this.f658e : RegularImmutableSet.f688a;
    }

    public final void m1361h(Class<? extends LibraryModule> cls) {
        if (this.f660g == null) {
            this.f660g = Sets.m1327c();
        }
        this.f660g.add(cls);
        if (this.f661h == null) {
            this.f661h = Sets.m1313a();
        }
        this.f661h.add(cls);
    }

    public final Set<Class<? extends LibraryModule>> m1359f() {
        return this.f660g != null ? this.f660g : RegularImmutableSet.f688a;
    }

    public final Map<Class<? extends Annotation>, Scope> m1360h() {
        return this.f662i == null ? RegularImmutableBiMap.f695a : this.f662i;
    }
}
