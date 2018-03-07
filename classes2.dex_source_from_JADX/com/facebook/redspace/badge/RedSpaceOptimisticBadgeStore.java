package com.facebook.redspace.badge;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.badge.event.RedSpaceBadgingEventBus;
import com.facebook.redspace.badge.event.SeenStoryStoreUpdatedEvent;
import com.facebook.ultralight.Inject;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo/%s */
public class RedSpaceOptimisticBadgeStore implements IHaveUserData, MemoryTrimmable {
    private static volatile RedSpaceOptimisticBadgeStore f10091j;
    @Inject
    public RedSpaceBadgingEventBus f10092a;
    public final Set<String> f10093b;
    private final Map<String, Set<String>> f10094c;
    private final Map<String, String> f10095d;
    public final Set<String> f10096e;
    public final Map<String, Set<String>> f10097f;
    public final Map<String, Set<String>> f10098g;
    public final SeenStoryStoreUpdatedEvent f10099h = new SeenStoryStoreUpdatedEvent();
    public int f10100i;

    public static com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore m15190a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10091j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore.class;
        monitor-enter(r1);
        r0 = f10091j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m15192b(r0);	 Catch:{ all -> 0x0035 }
        f10091j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10091j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore.a(com.facebook.inject.InjectorLike):com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore");
    }

    private static RedSpaceOptimisticBadgeStore m15192b(InjectorLike injectorLike) {
        RedSpaceOptimisticBadgeStore redSpaceOptimisticBadgeStore = new RedSpaceOptimisticBadgeStore(MemoryManager.m9807a(injectorLike));
        redSpaceOptimisticBadgeStore.f10092a = RedSpaceBadgingEventBus.m15202a(injectorLike);
        return redSpaceOptimisticBadgeStore;
    }

    @Inject
    private RedSpaceOptimisticBadgeStore(MemoryTrimmableRegistry memoryTrimmableRegistry) {
        memoryTrimmableRegistry.mo1390a(this);
        this.f10093b = new HashSet();
        this.f10094c = new ArrayMap();
        this.f10095d = new ArrayMap();
        this.f10096e = new HashSet();
        this.f10097f = new ArrayMap();
        this.f10098g = new ArrayMap();
    }

    public final void m15197a(GraphQLStory graphQLStory) {
        if (graphQLStory != null && graphQLStory.m22350c() != null && !this.f10093b.contains(graphQLStory.m22350c())) {
            this.f10093b.add(graphQLStory.m22350c());
            m15193b(graphQLStory.m22350c());
            GraphQLStory L = graphQLStory.m22326L();
            if (!(L == null || L.m22350c() == null)) {
                m15191a(graphQLStory.m22350c(), L.m22350c());
            }
            if (this.f10092a != null) {
                this.f10092a.mo651a(this.f10099h);
            }
        }
    }

    private void m15193b(String str) {
        if (m15195h()) {
            m15200c();
        }
        Set<String> set = (Set) this.f10098g.get(str);
        if (set != null) {
            List<String> arrayList = new ArrayList();
            for (String str2 : set) {
                Set set2 = (Set) this.f10097f.get(str2);
                set2.remove(str);
                if (set2.isEmpty()) {
                    arrayList.add(str2);
                    if (this.f10096e.remove(str2)) {
                        this.f10100i--;
                    }
                }
            }
            for (String str22 : arrayList) {
                this.f10097f.remove(str22);
            }
            this.f10098g.remove(str);
        }
        if (this.f10094c.containsKey(str)) {
            for (String str222 : (Set) this.f10094c.get(str)) {
                m15193b(str222);
            }
        }
    }

    private void m15191a(String str, String str2) {
        m15194b(str, str2);
        this.f10093b.add(str2);
        m15193b(str2);
    }

    private void m15194b(String str, String str2) {
        if (this.f10094c.containsKey(str2)) {
            ((Set) this.f10094c.get(str2)).add(str);
        } else {
            this.f10094c.put(str2, Sets.m1315a(str));
        }
        this.f10095d.put(str, str2);
    }

    public final void m15198a(String str, String str2, @Nullable String str3) {
        if (!this.f10093b.contains(str2)) {
            if (str3 != null) {
                m15194b(str2, str3);
                m15198a(str, str3, null);
                return;
            }
            Set hashSet;
            if (m15195h()) {
                m15200c();
            }
            if (this.f10096e.add(str)) {
                this.f10100i++;
            }
            if (this.f10097f.containsKey(str)) {
                ((Set) this.f10097f.get(str)).add(str2);
            } else {
                hashSet = new HashSet();
                hashSet.add(str2);
                this.f10097f.put(str, hashSet);
            }
            if (this.f10098g.containsKey(str2)) {
                ((Set) this.f10098g.get(str2)).add(str);
                return;
            }
            hashSet = new HashSet();
            hashSet.add(str);
            this.f10098g.put(str2, hashSet);
        }
    }

    public final void m15199b() {
        this.f10100i = 0;
    }

    private boolean m15195h() {
        return this.f10100i == 0 && !(this.f10096e.isEmpty() && this.f10098g.isEmpty() && this.f10097f.isEmpty());
    }

    public final void m15200c() {
        m15199b();
        this.f10096e.clear();
        this.f10098g.clear();
        this.f10097f.clear();
    }

    public void clearUserData() {
        this.f10093b.clear();
        this.f10094c.clear();
        this.f10095d.clear();
        this.f10096e.clear();
        this.f10097f.clear();
        this.f10098g.clear();
    }

    public final void mo1395a(MemoryTrimType memoryTrimType) {
        if (memoryTrimType != MemoryTrimType.OnAppBackgrounded) {
            clearUserData();
        }
    }
}
