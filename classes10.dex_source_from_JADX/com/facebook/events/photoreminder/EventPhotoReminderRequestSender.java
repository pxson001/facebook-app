package com.facebook.events.photoreminder;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.photoreminder.protocol.EventPhotoReminderMutationsModels.EventSendSharePhotosReminderCoreMutationModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: background_location_location_disabled_miniphone_displayed */
public class EventPhotoReminderRequestSender {
    public static final String f18958a = EventPhotoReminderRequestSender.class.getSimpleName();
    private static volatile EventPhotoReminderRequestSender f18959d;
    public final AbstractFbErrorReporter f18960b;
    public final GraphQLQueryExecutor f18961c;

    /* compiled from: background_location_location_disabled_miniphone_displayed */
    public class C26891 extends AbstractDisposableFutureCallback<GraphQLResult<EventSendSharePhotosReminderCoreMutationModel>> {
        final /* synthetic */ EventPhotoReminderRequestSender f18957a;

        public C26891(EventPhotoReminderRequestSender eventPhotoReminderRequestSender) {
            this.f18957a = eventPhotoReminderRequestSender;
        }

        protected final void m19196a(Throwable th) {
            this.f18957a.f18960b.a(EventPhotoReminderRequestSender.f18958a, "Failed to request for photo upload notification", th);
        }
    }

    public static com.facebook.events.photoreminder.EventPhotoReminderRequestSender m19197a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18959d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.photoreminder.EventPhotoReminderRequestSender.class;
        monitor-enter(r1);
        r0 = f18959d;	 Catch:{ all -> 0x003a }
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
        r0 = m19198b(r0);	 Catch:{ all -> 0x0035 }
        f18959d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18959d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.photoreminder.EventPhotoReminderRequestSender.a(com.facebook.inject.InjectorLike):com.facebook.events.photoreminder.EventPhotoReminderRequestSender");
    }

    private static EventPhotoReminderRequestSender m19198b(InjectorLike injectorLike) {
        return new EventPhotoReminderRequestSender((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public EventPhotoReminderRequestSender(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f18960b = abstractFbErrorReporter;
        this.f18961c = graphQLQueryExecutor;
    }
}
