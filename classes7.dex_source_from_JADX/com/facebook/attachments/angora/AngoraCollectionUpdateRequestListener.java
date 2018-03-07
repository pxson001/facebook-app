package com.facebook.attachments.angora;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.server.timeline.TimelineGraphPostService;
import com.facebook.inject.InjectorLike;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.story.UpdateTimelineAppCollectionParams.Builder;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: videoParams */
public class AngoraCollectionUpdateRequestListener implements CollectionUpdateRequestListener {
    private static volatile AngoraCollectionUpdateRequestListener f628d;
    private final TasksManager<String> f629a;
    public final AbstractFbErrorReporter f630b;
    private final TimelineGraphPostService f631c;

    public static com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener m717a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f628d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener.class;
        monitor-enter(r1);
        r0 = f628d;	 Catch:{ all -> 0x003a }
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
        r0 = m718b(r0);	 Catch:{ all -> 0x0035 }
        f628d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f628d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener.a(com.facebook.inject.InjectorLike):com.facebook.attachments.angora.AngoraCollectionUpdateRequestListener");
    }

    private static AngoraCollectionUpdateRequestListener m718b(InjectorLike injectorLike) {
        return new AngoraCollectionUpdateRequestListener(TasksManager.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TimelineGraphPostService.m4428b(injectorLike));
    }

    @Inject
    public AngoraCollectionUpdateRequestListener(TasksManager tasksManager, AbstractFbErrorReporter abstractFbErrorReporter, TimelineGraphPostService timelineGraphPostService) {
        this.f629a = tasksManager;
        this.f630b = abstractFbErrorReporter;
        this.f631c = timelineGraphPostService;
    }

    public final ListenableFuture<?> mo38a(CollectionUpdateResultListener collectionUpdateResultListener, SavableTimelineAppCollection savableTimelineAppCollection, UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
        Builder builder = new Builder(updateTimelineAppCollectionParams);
        builder.c = Action.ADD;
        return m719c(collectionUpdateResultListener, savableTimelineAppCollection, builder.a());
    }

    public final ListenableFuture<?> mo39b(CollectionUpdateResultListener collectionUpdateResultListener, SavableTimelineAppCollection savableTimelineAppCollection, UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
        Builder builder = new Builder(updateTimelineAppCollectionParams);
        builder.c = Action.REMOVE;
        return m719c(collectionUpdateResultListener, savableTimelineAppCollection, builder.a());
    }

    private ListenableFuture<?> m719c(final CollectionUpdateResultListener collectionUpdateResultListener, final SavableTimelineAppCollection savableTimelineAppCollection, final UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
        ListenableFuture<?> a = this.f631c.m4429a(updateTimelineAppCollectionParams);
        this.f629a.a("task_key_update_timeline_collection_" + updateTimelineAppCollectionParams.b + "_" + updateTimelineAppCollectionParams.h + "_" + updateTimelineAppCollectionParams.i, a, new OperationResultFutureCallback(this) {
            final /* synthetic */ AngoraCollectionUpdateRequestListener f627d;

            protected final void m714a(Object obj) {
                collectionUpdateResultListener.mo40a();
            }

            protected final void m713a(ServiceException serviceException) {
                collectionUpdateResultListener.mo41a(savableTimelineAppCollection, updateTimelineAppCollectionParams.c);
                this.f627d.f630b.a(this.f627d.getClass().getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Failed to add item to Timeline Collection due to server exception %s.", serviceException.toString()));
            }
        });
        return a;
    }
}
