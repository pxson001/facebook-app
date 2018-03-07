package com.facebook.pages.adminedpages;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel.AdminInfoModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel.Builder;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels$AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel.ProfilePictureModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.util.BasePagesTrackedLruCache;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: extra_user_key */
public class AdminedPagesRamCache extends BasePagesTrackedLruCache<String, AdminedPagesPrefetchNode> implements IHaveUserData {
    private static volatile AdminedPagesRamCache f12422e;
    @GuardedBy("this")
    private int f12423c;
    @GuardedBy("this")
    private long f12424d;

    public static com.facebook.pages.adminedpages.AdminedPagesRamCache m13121a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12422e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.adminedpages.AdminedPagesRamCache.class;
        monitor-enter(r1);
        r0 = f12422e;	 Catch:{ all -> 0x003a }
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
        r0 = m13122b(r0);	 Catch:{ all -> 0x0035 }
        f12422e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12422e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.adminedpages.AdminedPagesRamCache.a(com.facebook.inject.InjectorLike):com.facebook.pages.adminedpages.AdminedPagesRamCache");
    }

    private static AdminedPagesRamCache m13122b(InjectorLike injectorLike) {
        return new AdminedPagesRamCache(FactoryMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AdminedPagesRamCache(Factory factory, Clock clock) {
        super(factory, clock, 128);
    }

    public synchronized void clearUserData() {
        this.f12423c = 0;
        m13135a();
    }

    public final synchronized int m13129c() {
        return this.f12423c;
    }

    public final synchronized void m13123a(int i) {
        this.f12423c = i;
    }

    public final synchronized long m13130d() {
        return this.f12424d;
    }

    public final synchronized void m13124a(long j) {
        this.f12424d = j;
    }

    public final synchronized void m13127a(Iterator<? extends AdminedPagesPrefetchNode> it, long j) {
        while (it.hasNext()) {
            AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) it.next();
            if (!(adminedPagesPrefetchNode == null || StringUtil.a(adminedPagesPrefetchNode.a().m4524c()))) {
                m13134a(adminedPagesPrefetchNode.a().m4524c(), adminedPagesPrefetchNode, j);
            }
        }
    }

    public final synchronized void m13125a(String str) {
        m13139c(str);
    }

    public final synchronized void m13126a(String str, @Nullable String str2, @Nullable ImmutableList<? extends String> immutableList, @Nullable String str3, @Nullable Boolean bool, Optional<String> optional) {
        Builder a;
        Object adminedPagesPrefetchNode;
        AdminedPagesPrefetchNode adminedPagesPrefetchNode2 = (AdminedPagesPrefetchNode) m13137b(str);
        if (adminedPagesPrefetchNode2 != null) {
            a = Builder.a(adminedPagesPrefetchNode2.a());
        } else {
            a = new Builder();
        }
        a.a(str);
        if (!StringUtil.a(str2)) {
            a.b(str2);
        }
        if (immutableList != null) {
            a.a(ImmutableList.copyOf(immutableList));
        }
        if (bool != null) {
            a.a(new AdminInfoModel.Builder().a(bool.booleanValue()).a());
        }
        if (optional.isPresent()) {
            a.a(new ProfilePictureModel.Builder().a((String) optional.get()).a());
        }
        if (str3 == null) {
            if (adminedPagesPrefetchNode2 == null || !adminedPagesPrefetchNode2.b().isPresent()) {
                str3 = null;
            } else {
                str3 = (String) adminedPagesPrefetchNode2.b().get();
            }
        }
        if (StringUtil.a(str3)) {
            adminedPagesPrefetchNode = new AdminedPagesPrefetchNode(a.a());
        } else {
            adminedPagesPrefetchNode = new AdminedPagesPrefetchNode(a.a(), str3);
        }
        m13133a((Object) str, adminedPagesPrefetchNode);
    }

    public final synchronized AdminedPagesPrefetchNode m13128b(String str) {
        return (AdminedPagesPrefetchNode) m13138b(str, 86400000);
    }
}
