package com.facebook.feedback.ui;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.inject.InjectorLike;
import com.facebook.offlinemode.comments.CanHandleSuccessfulOfflineComment;
import com.facebook.offlinemode.comments.OfflineCommentsExecutorHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: route descriptor already added */
public class OfflineCommentCache implements IHaveUserData, CanHandleSuccessfulOfflineComment {
    private static volatile OfflineCommentCache f4638c;
    private OfflineCommentsExecutorHelper f4639a;
    private LinkedList<GraphQLComment> f4640b = new LinkedList();

    public static com.facebook.feedback.ui.OfflineCommentCache m5175a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4638c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.ui.OfflineCommentCache.class;
        monitor-enter(r1);
        r0 = f4638c;	 Catch:{ all -> 0x003a }
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
        r0 = m5177b(r0);	 Catch:{ all -> 0x0035 }
        f4638c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4638c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.OfflineCommentCache.a(com.facebook.inject.InjectorLike):com.facebook.feedback.ui.OfflineCommentCache");
    }

    private static OfflineCommentCache m5177b(InjectorLike injectorLike) {
        return new OfflineCommentCache(OfflineCommentsExecutorHelper.a(injectorLike));
    }

    @Inject
    public OfflineCommentCache(OfflineCommentsExecutorHelper offlineCommentsExecutorHelper) {
        this.f4639a = offlineCommentsExecutorHelper;
        this.f4639a.a(this);
    }

    public final synchronized void m5180b(GraphQLComment graphQLComment) {
        if (this.f4640b.size() >= 10) {
            this.f4640b.removeFirst();
        }
        this.f4640b.add(graphQLComment);
    }

    public final synchronized void m5181c(GraphQLComment graphQLComment) {
        Iterator it = this.f4640b.iterator();
        while (it.hasNext()) {
            if (((GraphQLComment) it.next()).equals(graphQLComment)) {
                it.remove();
                break;
            }
        }
    }

    public final synchronized ImmutableList<GraphQLComment> m5178a(String str) {
        Builder builder;
        builder = new Builder();
        Iterator it = this.f4640b.iterator();
        while (it.hasNext()) {
            GraphQLComment graphQLComment = (GraphQLComment) it.next();
            if (!(graphQLComment.l() == null || graphQLComment.l().z_() == null || !graphQLComment.l().z_().equals(str))) {
                builder.c(graphQLComment);
            }
        }
        return builder.b();
    }

    private synchronized void m5176a() {
        this.f4640b.clear();
    }

    public final void m5179a(GraphQLComment graphQLComment) {
        m5181c(graphQLComment);
    }

    public void clearUserData() {
        m5176a();
    }
}
