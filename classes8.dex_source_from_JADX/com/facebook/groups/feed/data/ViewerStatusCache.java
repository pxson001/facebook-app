package com.facebook.groups.feed.data;

import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerStatus;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: faceweb/f?href=/ads/manage */
public class ViewerStatusCache {
    private static volatile ViewerStatusCache f14041c;
    private final Set<String> f14042a = Sets.a();
    private final Set<String> f14043b = Sets.a();

    public static com.facebook.groups.feed.data.ViewerStatusCache m15635a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14041c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.groups.feed.data.ViewerStatusCache.class;
        monitor-enter(r1);
        r0 = f14041c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m15634a();	 Catch:{ all -> 0x0034 }
        f14041c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f14041c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.feed.data.ViewerStatusCache.a(com.facebook.inject.InjectorLike):com.facebook.groups.feed.data.ViewerStatusCache");
    }

    private static ViewerStatusCache m15634a() {
        return new ViewerStatusCache();
    }

    public final synchronized void m15637a(String str, GroupViewerStatus groupViewerStatus) {
        if (str != null) {
            if (groupViewerStatus != null) {
                if (groupViewerStatus.p() == GraphQLGroupJoinState.MEMBER) {
                    this.f14043b.add(str);
                    if (groupViewerStatus == null && (GraphQLGroupAdminType.ADMIN == groupViewerStatus.n() || GraphQLGroupAdminType.MODERATOR == groupViewerStatus.n())) {
                        this.f14042a.add(str);
                    } else {
                        this.f14042a.remove(str);
                    }
                }
            }
            this.f14043b.remove(str);
            if (groupViewerStatus == null) {
            }
            this.f14042a.remove(str);
        }
    }

    public final synchronized void m15636a(String str, GraphQLGroupAdminType graphQLGroupAdminType) {
        if (str != null) {
            if (GraphQLGroupAdminType.ADMIN == graphQLGroupAdminType || GraphQLGroupAdminType.MODERATOR == graphQLGroupAdminType) {
                this.f14042a.add(str);
            } else {
                this.f14042a.remove(str);
            }
        }
    }

    public final synchronized boolean m15638a(String str) {
        boolean z;
        if (str != null) {
            if (this.f14042a.contains(str)) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public final synchronized boolean m15639b(String str) {
        boolean z;
        if (str != null) {
            if (this.f14043b.contains(str)) {
                z = true;
            }
        }
        z = false;
        return z;
    }
}
