package com.facebook.stickers.data;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.LruCacheListener;
import com.facebook.cache.TrackedLruCache;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.common.cache.CacheSizeHelper;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.model.StickerTag;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: failed_stage */
public class StickerCache implements IHaveUserData {
    private static final Class<?> f12290a = StickerCache.class;
    private static final Object f12291h = new Object();
    private TrackedLruCache<String, Sticker> f12292b;
    private Map<String, StickerPack> f12293c = Maps.c();
    private Map<StickerPackType, LinkedHashSet<String>> f12294d = Maps.c();
    private ImmutableList<Sticker> f12295e = null;
    private ImmutableList<StickerPack> f12296f = null;
    private ImmutableList<StickerTag> f12297g = null;

    /* compiled from: failed_stage */
    class C05861 implements LruCacheListener<String, Sticker> {
        final /* synthetic */ StickerCache f12300a;

        C05861(StickerCache stickerCache) {
            this.f12300a = stickerCache;
        }

        public final int m12988a(Object obj, Object obj2) {
            int i;
            Sticker sticker = (Sticker) obj2;
            int length = ((String) obj).length();
            if (sticker == null) {
                i = 0;
            } else {
                int i2 = 0;
                int length2 = (sticker.g == null ? 0 : sticker.g.getPath().length()) + ((((sticker.c.getPath().length() + (sticker.a.length() + sticker.b.length())) + (sticker.d == null ? 0 : sticker.d.getPath().length())) + (sticker.e == null ? 0 : sticker.e.getPath().length())) + (sticker.f == null ? 0 : sticker.f.getPath().length()));
                if (sticker.h != null) {
                    i2 = sticker.h.getPath().length();
                }
                i = length2 + i2;
            }
            return i + length;
        }

        public final /* bridge */ /* synthetic */ void m12989a(boolean z, Object obj, Object obj2, Object obj3) {
        }
    }

    private static StickerCache m12961b(InjectorLike injectorLike) {
        return new StickerCache(FactoryMethodAutoProvider.a(injectorLike), CacheSizeHelper.m12985a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.stickers.data.StickerCache m12960a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f12291h;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m12961b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12291h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.stickers.data.StickerCache) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.stickers.data.StickerCache) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f12291h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.stickers.data.StickerCache) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickerCache.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickerCache");
    }

    @Inject
    StickerCache(Factory factory, CacheSizeHelper cacheSizeHelper) {
        this.f12292b = factory.c(cacheSizeHelper.m12987a(30720, 102400), "stickers", new C05861(this));
    }

    public final synchronized boolean m12971a(String str) {
        return this.f12293c.containsKey(str);
    }

    public final synchronized void m12965a(StickerPack stickerPack) {
        if (m12971a(stickerPack.a())) {
            this.f12293c.put(stickerPack.a(), stickerPack);
        }
    }

    @Nullable
    public final synchronized StickerPack m12972b(String str) {
        StickerPack stickerPack;
        if (this.f12293c.containsKey(str)) {
            stickerPack = (StickerPack) this.f12293c.get(str);
        } else {
            stickerPack = null;
        }
        return stickerPack;
    }

    public final synchronized TriState m12977c(String str) {
        TriState triState;
        triState = m12970a(StickerPackType.DOWNLOADED_PACKS) ? ((LinkedHashSet) this.f12294d.get(StickerPackType.DOWNLOADED_PACKS)).contains(str) ? TriState.YES : TriState.NO : TriState.UNSET;
        return triState;
    }

    public final synchronized boolean m12970a(StickerPackType stickerPackType) {
        return this.f12294d.get(stickerPackType) != null;
    }

    public final synchronized ImmutableList<StickerPack> m12973b(StickerPackType stickerPackType) {
        return m12962c((LinkedHashSet) this.f12294d.get(stickerPackType));
    }

    private ImmutableList<StickerPack> m12962c(@Nullable Collection<String> collection) {
        if (collection == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        for (String str : collection) {
            builder.c(this.f12293c.get(str));
        }
        return builder.b();
    }

    public final void m12966a(StickerPackType stickerPackType, StickerPack stickerPack) {
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.f12294d.get(stickerPackType);
        if (linkedHashSet == null) {
            throw new IllegalStateException("Tried to add a StickerPack before it was set");
        }
        this.f12293c.put(stickerPack.a, stickerPack);
        Collection a = Lists.a();
        a.add(stickerPack.a);
        a.addAll(linkedHashSet);
        linkedHashSet = Sets.c();
        linkedHashSet.addAll(a);
        this.f12294d.put(stickerPackType, linkedHashSet);
    }

    public final synchronized void m12967a(StickerPackType stickerPackType, List<StickerPack> list) {
        LinkedHashSet c = Sets.c();
        for (StickerPack stickerPack : list) {
            this.f12293c.put(stickerPack.a(), stickerPack);
            c.add(stickerPack.a());
        }
        this.f12294d.put(stickerPackType, c);
    }

    public final synchronized ImmutableList<Sticker> m12963a() {
        return this.f12295e;
    }

    public final synchronized void m12969a(List<Sticker> list) {
        this.f12295e = ImmutableList.copyOf(list);
    }

    public final synchronized boolean m12976b() {
        return this.f12295e != null;
    }

    public final synchronized ImmutableList<StickerPack> m12978c() {
        return this.f12296f;
    }

    public final synchronized void m12975b(List<StickerPack> list) {
        this.f12296f = ImmutableList.copyOf(list);
    }

    public final synchronized boolean m12980d() {
        return this.f12296f != null;
    }

    public final synchronized void m12981e() {
        this.f12296f = null;
    }

    public final synchronized Sticker m12979d(String str) {
        return (Sticker) this.f12292b.a(str);
    }

    public final synchronized ImmutableList<Sticker> m12964a(Collection<String> collection) {
        Builder builder;
        builder = ImmutableList.builder();
        for (String str : collection) {
            if (this.f12292b.a(str) != null) {
                builder.c(this.f12292b.a(str));
            }
        }
        return builder.b();
    }

    public final synchronized void m12974b(Collection<Sticker> collection) {
        for (Sticker sticker : collection) {
            this.f12292b.a(sticker.a, sticker);
        }
    }

    public final synchronized boolean m12982f() {
        return this.f12297g != null;
    }

    public final synchronized ImmutableList<StickerTag> m12983g() {
        return this.f12297g;
    }

    public final synchronized void m12968a(ImmutableList<StickerTag> immutableList) {
        this.f12297g = immutableList;
    }

    public final synchronized void m12984h() {
        this.f12292b.a();
        this.f12293c.clear();
        this.f12294d.clear();
        this.f12297g = null;
        this.f12296f = null;
        this.f12295e = null;
    }

    public void clearUserData() {
        m12984h();
    }
}
