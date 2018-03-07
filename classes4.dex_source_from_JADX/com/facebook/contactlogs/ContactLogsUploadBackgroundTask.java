package com.facebook.contactlogs;

import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb4a_sponsored_feed_validation */
public class ContactLogsUploadBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12078a = ContactLogsUploadBackgroundTask.class;
    private static volatile ContactLogsUploadBackgroundTask f12079c;
    private final ContactLogsUploadRunner f12080b;

    public static com.facebook.contactlogs.ContactLogsUploadBackgroundTask m12759a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12079c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contactlogs.ContactLogsUploadBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12079c;	 Catch:{ all -> 0x003a }
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
        r0 = m12760b(r0);	 Catch:{ all -> 0x0035 }
        f12079c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12079c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contactlogs.ContactLogsUploadBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.contactlogs.ContactLogsUploadBackgroundTask");
    }

    private static ContactLogsUploadBackgroundTask m12760b(InjectorLike injectorLike) {
        return new ContactLogsUploadBackgroundTask(ContactLogsUploadRunner.m12764a(injectorLike));
    }

    @Inject
    public ContactLogsUploadBackgroundTask(ContactLogsUploadRunner contactLogsUploadRunner) {
        super("ContactLogsUploadBackgroundTask");
        this.f12080b = contactLogsUploadRunner;
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        return this.f12080b.m12771c();
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        OperationFuture a = this.f12080b.m12769a();
        if (a == null) {
            return null;
        }
        ListenableFuture<BackgroundResult> simpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(f12078a);
        Futures.a(a, simpleBackgroundResultFutureCallback);
        return simpleBackgroundResultFutureCallback;
    }
}
