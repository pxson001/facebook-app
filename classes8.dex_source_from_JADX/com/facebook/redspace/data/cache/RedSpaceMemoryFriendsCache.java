package com.facebook.redspace.data.cache;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel.ActorModel.RedspaceModel.RecentStoryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpacePageInfoModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: USE_SELECTED_ITEMS */
public class RedSpaceMemoryFriendsCache implements IHaveUserData, MemoryTrimmable {
    private static volatile RedSpaceMemoryFriendsCache f21297e;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> f21298a = UltralightRuntime.b;
    private final Map<String, CacheSection> f21299b = new ArrayMap();
    public final Map<String, Long> f21300c = new ArrayMap();
    public RecentStoryModel f21301d;

    /* compiled from: USE_SELECTED_ITEMS */
    public class CacheSection {
        public List<RedSpaceFeedProfileFragmentModel> f21294a = new ArrayList();
        public RedSpacePageInfoModel f21295b;
        public OverflowFriendsModel f21296c;
    }

    public static com.facebook.redspace.data.cache.RedSpaceMemoryFriendsCache m24905a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f21297e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.redspace.data.cache.RedSpaceMemoryFriendsCache.class;
        monitor-enter(r1);
        r0 = f21297e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m24906b(r0);	 Catch:{ all -> 0x0035 }
        f21297e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21297e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.data.cache.RedSpaceMemoryFriendsCache.a(com.facebook.inject.InjectorLike):com.facebook.redspace.data.cache.RedSpaceMemoryFriendsCache");
    }

    private static RedSpaceMemoryFriendsCache m24906b(InjectorLike injectorLike) {
        RedSpaceMemoryFriendsCache redSpaceMemoryFriendsCache = new RedSpaceMemoryFriendsCache((MemoryTrimmableRegistry) MemoryManager.a(injectorLike));
        redSpaceMemoryFriendsCache.f21298a = IdBasedSingletonScopeProvider.b(injectorLike, 609);
        return redSpaceMemoryFriendsCache;
    }

    @Inject
    private RedSpaceMemoryFriendsCache(MemoryTrimmableRegistry memoryTrimmableRegistry) {
        memoryTrimmableRegistry.a(this);
    }

    public final void m24914a(String str) {
        this.f21299b.remove(str);
        this.f21300c.remove(str);
    }

    public final void m24913a(@Nullable ImmutableList<RedSpaceFeedProfileFragmentModel> immutableList, String str, boolean z) {
        CacheSection f = m24907f(str);
        if (z) {
            f.f21294a.clear();
        }
        if (immutableList != null) {
            f.f21294a.addAll(immutableList);
        }
    }

    public final void m24912a(@Nullable RedSpacePageInfoModel redSpacePageInfoModel, String str) {
        m24907f(str).f21295b = redSpacePageInfoModel;
        this.f21300c.put(str, Long.valueOf(((Clock) this.f21298a.get()).a()));
    }

    public final void m24911a(@Nullable OverflowFriendsModel overflowFriendsModel, String str) {
        m24907f(str).f21296c = overflowFriendsModel;
    }

    public final void m24910a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, String str, String str2, boolean z) {
        List list = m24907f(str).f21294a;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (StringUtil.a(((RedSpaceFeedProfileFragmentModel) list.get(size)).k(), redSpaceFeedProfileFragmentModel.k())) {
                list.remove(size);
            }
        }
        if (z) {
            m24907f(str2).f21294a.add(0, redSpaceFeedProfileFragmentModel);
        } else {
            m24907f(str2).f21294a.add(redSpaceFeedProfileFragmentModel);
        }
    }

    public final void m24909a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, String str) {
        List list = m24907f(str).f21294a;
        for (int i = 0; i < list.size(); i++) {
            if (StringUtil.a(((RedSpaceFeedProfileFragmentModel) list.get(i)).k(), redSpaceFeedProfileFragmentModel.k())) {
                list.set(i, redSpaceFeedProfileFragmentModel);
            }
        }
    }

    public final ImmutableList<RedSpaceFeedProfileFragmentModel> m24915b(String str) {
        return ImmutableList.copyOf(m24907f(str).f21294a);
    }

    public final RedSpacePageInfoModel m24916c(String str) {
        return m24907f(str).f21295b;
    }

    public final OverflowFriendsModel m24917d(String str) {
        return m24907f(str).f21296c;
    }

    public void clearUserData() {
        this.f21299b.clear();
        this.f21300c.clear();
        this.f21301d = null;
    }

    private CacheSection m24907f(String str) {
        CacheSection cacheSection = (CacheSection) this.f21299b.get(str);
        if (cacheSection != null) {
            return cacheSection;
        }
        cacheSection = new CacheSection();
        this.f21299b.put(str, cacheSection);
        return cacheSection;
    }

    public final void m24908a(MemoryTrimType memoryTrimType) {
        if (memoryTrimType != MemoryTrimType.OnAppBackgrounded) {
            clearUserData();
        }
    }

    public final long m24918e(String str) {
        Long l = (Long) this.f21300c.get(str);
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }
}
