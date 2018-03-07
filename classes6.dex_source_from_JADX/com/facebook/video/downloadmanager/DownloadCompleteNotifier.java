package com.facebook.video.downloadmanager;

import android.annotation.SuppressLint;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.video.downloadmanager.graphql.SavedVideoMutationModels.SavedVideoDownloadStateMutationModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"BadMethodUse-com.google.common.util.concurrent.Futures.addCallback"})
/* compiled from: contact_changes */
public class DownloadCompleteNotifier {
    public static final String f18634a = DownloadCompleteNotifier.class.getName();
    private static volatile DownloadCompleteNotifier f18635c;
    public final GraphQLQueryExecutor f18636b;

    /* compiled from: contact_changes */
    public class C13831 implements FutureCallback<GraphQLResult<SavedVideoDownloadStateMutationModel>> {
        final /* synthetic */ String f18632a;
        final /* synthetic */ DownloadCompleteNotifier f18633b;

        public void onSuccess(@Nullable Object obj) {
            String str = DownloadCompleteNotifier.f18634a;
        }

        public C13831(DownloadCompleteNotifier downloadCompleteNotifier, String str) {
            this.f18633b = downloadCompleteNotifier;
            this.f18632a = str;
        }

        public void onFailure(Throwable th) {
            BLog.b(DownloadCompleteNotifier.f18634a, th, "Download complete notification failed %s", new Object[]{this.f18632a});
        }
    }

    public static com.facebook.video.downloadmanager.DownloadCompleteNotifier m27399a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18635c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.downloadmanager.DownloadCompleteNotifier.class;
        monitor-enter(r1);
        r0 = f18635c;	 Catch:{ all -> 0x003a }
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
        r0 = m27400b(r0);	 Catch:{ all -> 0x0035 }
        f18635c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18635c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.downloadmanager.DownloadCompleteNotifier.a(com.facebook.inject.InjectorLike):com.facebook.video.downloadmanager.DownloadCompleteNotifier");
    }

    private static DownloadCompleteNotifier m27400b(InjectorLike injectorLike) {
        return new DownloadCompleteNotifier(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public DownloadCompleteNotifier(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f18636b = graphQLQueryExecutor;
    }
}
