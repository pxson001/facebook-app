package com.facebook.common.locale;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: signed_request */
public abstract class LocaleMemberFactory<T extends LocaleMember> {
    public final LoadingCache<String, Locale> f2688a = CacheBuilder.newBuilder().a(new C01881(this));
    private final LoadingCache<String, T> f2689b = CacheBuilder.newBuilder().a(new C01892(this));
    public final Supplier<ImmutableMap<String, T>> f2690c = Suppliers.memoize(new C01903(this));

    /* compiled from: signed_request */
    class C01881 extends CacheLoader<String, Locale> {
        final /* synthetic */ LocaleMemberFactory f2694a;

        C01881(LocaleMemberFactory localeMemberFactory) {
            this.f2694a = localeMemberFactory;
        }

        public final Object m3807a(Object obj) {
            return this.f2694a.mo573a((String) obj);
        }
    }

    /* compiled from: signed_request */
    class C01892 extends CacheLoader<String, T> {
        final /* synthetic */ LocaleMemberFactory f2695a;

        C01892(LocaleMemberFactory localeMemberFactory) {
            this.f2695a = localeMemberFactory;
        }

        public final Object m3808a(Object obj) {
            return this.f2695a.mo572a((Locale) this.f2695a.f2688a.c((String) obj));
        }
    }

    /* compiled from: signed_request */
    class C01903 implements Supplier<ImmutableMap<String, T>> {
        final /* synthetic */ LocaleMemberFactory f2696a;

        C01903(LocaleMemberFactory localeMemberFactory) {
            this.f2696a = localeMemberFactory;
        }

        public Object get() {
            return LocaleMemberFactory.m3794b(this.f2696a);
        }
    }

    /* compiled from: signed_request */
    class C01914 implements Function<T, String> {
        final /* synthetic */ LocaleMemberFactory f2697a;

        C01914(LocaleMemberFactory localeMemberFactory) {
            this.f2697a = localeMemberFactory;
        }

        public Object apply(Object obj) {
            return ((LocaleMember) obj).mo571c();
        }
    }

    /* compiled from: signed_request */
    class C01925 implements Function<String, T> {
        final /* synthetic */ LocaleMemberFactory f2698a;

        C01925(LocaleMemberFactory localeMemberFactory) {
            this.f2698a = localeMemberFactory;
        }

        public Object apply(Object obj) {
            return LocaleMemberFactory.m3795c(this.f2698a, (String) obj);
        }
    }

    protected abstract T mo572a(Locale locale);

    protected abstract Locale mo573a(String str);

    protected abstract String[] mo574a();

    LocaleMemberFactory() {
    }

    public static ImmutableMap m3794b(LocaleMemberFactory localeMemberFactory) {
        try {
            return Maps.a(localeMemberFactory.m3796c(), new C01914(localeMemberFactory));
        } catch (Throwable e) {
            throw new RuntimeException("Failed to construct a unique ISO3 index of items: " + localeMemberFactory.m3796c(), e);
        }
    }

    private List<T> m3796c() {
        return Lists.a(Arrays.asList(mo574a()), new C01925(this));
    }

    public static LocaleMember m3795c(LocaleMemberFactory localeMemberFactory, String str) {
        try {
            return (LocaleMember) localeMemberFactory.f2689b.c(str);
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    public final T m3800b(String str) {
        if (str.length() == 2) {
            return m3795c(this, str);
        }
        if (str.length() == 3) {
            return (LocaleMember) ((ImmutableMap) this.f2690c.get()).get(str);
        }
        throw new IllegalArgumentException("Not a legal code: " + str);
    }
}
