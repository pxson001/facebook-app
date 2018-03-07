package com.facebook.graphql.executor;

import com.facebook.graphql.executor.iface.SubscriptionPusher;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import javax.inject.Singleton;

@Singleton
/* compiled from: saved_collection_story_caret_imp */
public class GraphQLQuerySubscriber {
    private static volatile GraphQLQuerySubscriber f6172b;
    @VisibleForTesting
    final WeakHashMap<SubscriptionPusher, Boolean> f6173a = new WeakHashMap();

    public static com.facebook.graphql.executor.GraphQLQuerySubscriber m10365a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f6172b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.graphql.executor.GraphQLQuerySubscriber.class;
        monitor-enter(r1);
        r0 = f6172b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m10366b();	 Catch:{ all -> 0x0034 }
        f6172b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6172b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.GraphQLQuerySubscriber.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.GraphQLQuerySubscriber");
    }

    private static GraphQLQuerySubscriber m10366b() {
        return new GraphQLQuerySubscriber();
    }

    public final synchronized void m10369a(GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        this.f6173a.put(graphQLSubscriptionHolder, Boolean.TRUE);
    }

    public final synchronized void m10370b(GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        this.f6173a.remove(graphQLSubscriptionHolder);
    }

    public final void m10368a(int i, Set<String> set) {
        if (!set.isEmpty()) {
            ImmutableSet copyOf;
            synchronized (this) {
                copyOf = ImmutableSet.copyOf(this.f6173a.keySet());
            }
            Iterator it = copyOf.iterator();
            while (it.hasNext()) {
                ((GraphQLSubscriptionHolder) it.next()).m14630a(i, set);
            }
        }
    }

    public final Collection<String> m10367a() {
        ImmutableSet copyOf;
        synchronized (this) {
            copyOf = ImmutableSet.copyOf(this.f6173a.keySet());
        }
        Builder builder = new Builder();
        Iterator it = copyOf.iterator();
        while (it.hasNext()) {
            GraphQLSubscriptionHolder graphQLSubscriptionHolder = (GraphQLSubscriptionHolder) it.next();
            if (graphQLSubscriptionHolder instanceof GraphQLSubscriptionHolder) {
                graphQLSubscriptionHolder.m14631a(builder);
            }
        }
        return builder.m1068b();
    }
}
