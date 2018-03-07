package com.facebook.feed.logging.viewport;

import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.TrackedLruCache;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@NotThreadSafe
/* compiled from: predicate */
public class GroupMallVpvs {
    private static volatile GroupMallVpvs f9309b;
    public final TrackedLruCache<String, String> f9310a;

    public static com.facebook.feed.logging.viewport.GroupMallVpvs m14274a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9309b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.viewport.GroupMallVpvs.class;
        monitor-enter(r1);
        r0 = f9309b;	 Catch:{ all -> 0x003a }
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
        r0 = m14275b(r0);	 Catch:{ all -> 0x0035 }
        f9309b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9309b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.viewport.GroupMallVpvs.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.viewport.GroupMallVpvs");
    }

    private static GroupMallVpvs m14275b(InjectorLike injectorLike) {
        return new GroupMallVpvs(FactoryMethodAutoProvider.m9805a(injectorLike));
    }

    @Inject
    public GroupMallVpvs(Factory factory) {
        this.f9310a = factory.m9821a(100, "group_mall_vpvs");
    }

    public final void m14277a(String str, String str2) {
        if (!StringUtil.m3589a((CharSequence) str2) && !StringUtil.m3589a((CharSequence) str)) {
            this.f9310a.m9842a((Object) str, (Object) str2);
        }
    }

    public final ImmutableList<String> m14276a() {
        List arrayList = new ArrayList();
        for (Entry key : this.f9310a.m9849c().entrySet()) {
            arrayList.add(key.getKey());
        }
        List<String> a = Lists.m1301a(arrayList);
        Builder builder = new Builder();
        for (String c : a) {
            builder.m1069c(c);
        }
        return builder.m1068b();
    }
}
