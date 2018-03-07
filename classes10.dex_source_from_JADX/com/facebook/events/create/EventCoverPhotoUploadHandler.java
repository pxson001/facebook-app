package com.facebook.events.create;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.debug.log.BLog;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.protocol.EventCreationMutations;
import com.facebook.events.create.protocol.EventCreationMutations.EditEventCoreMutationString;
import com.facebook.events.create.protocol.EventCreationMutationsModels.EditEventCoreMutationFieldsModel;
import com.facebook.events.create.protocol.EventCreationMutationsModels.EditEventCoreMutationFieldsModel.EventModel;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.eventsevents.EventsEvents.EventUpdatedEvent;
import com.facebook.graphql.calls.EventEditInputData;
import com.facebook.graphql.calls.EventEditInputData.Context;
import com.facebook.graphql.calls.EventEditInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventEditInputData.CoverPhotoInfo;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.upload.module.ImmediateRetryPolicyMethodAutoProvider;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoParams.Builder;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader.DirectUploadListener;
import com.facebook.photos.upload.uploaders.MediaUploadCancelHandler;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: contact_upload_failed_retry */
public class EventCoverPhotoUploadHandler {
    private static volatile EventCoverPhotoUploadHandler f16070j;
    public final DirectPhotoUploader f16071a;
    public final EventsEventBus f16072b;
    private final ExecutorService f16073c;
    public final AbstractFbErrorReporter f16074d;
    private final GraphQLQueryExecutor f16075e;
    public final ImmediateRetryPolicy f16076f;
    private final MediaItemFactory f16077g;
    public final DefaultPhotoFlowLogger f16078h;
    private final TasksManager f16079i;

    public static com.facebook.events.create.EventCoverPhotoUploadHandler m16454a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16070j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.create.EventCoverPhotoUploadHandler.class;
        monitor-enter(r1);
        r0 = f16070j;	 Catch:{ all -> 0x003a }
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
        r0 = m16457b(r0);	 Catch:{ all -> 0x0035 }
        f16070j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16070j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.create.EventCoverPhotoUploadHandler.a(com.facebook.inject.InjectorLike):com.facebook.events.create.EventCoverPhotoUploadHandler");
    }

    private static EventCoverPhotoUploadHandler m16457b(InjectorLike injectorLike) {
        return new EventCoverPhotoUploadHandler(DirectPhotoUploader.b(injectorLike), EventsEventBus.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ImmediateRetryPolicyMethodAutoProvider.b(injectorLike), MediaItemFactory.b(injectorLike), DefaultPhotoFlowLogger.b(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public EventCoverPhotoUploadHandler(DirectPhotoUploader directPhotoUploader, EventsEventBus eventsEventBus, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ImmediateRetryPolicy immediateRetryPolicy, MediaItemFactory mediaItemFactory, DefaultPhotoFlowLogger defaultPhotoFlowLogger, TasksManager tasksManager) {
        this.f16071a = directPhotoUploader;
        this.f16074d = abstractFbErrorReporter;
        this.f16072b = eventsEventBus;
        this.f16073c = executorService;
        this.f16075e = graphQLQueryExecutor;
        this.f16076f = immediateRetryPolicy;
        this.f16077g = mediaItemFactory;
        this.f16078h = defaultPhotoFlowLogger;
        this.f16079i = tasksManager;
    }

    public final ListenableFuture<String> m16458a(Handler handler, Uri uri, long j, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        SettableFuture f = SettableFuture.f();
        try {
            MediaItem a = this.f16077g.a(uri, FallbackMediaId.DEFAULT);
            this.f16078h.a(SafeUUIDGenerator.a().toString());
            HashSet a2 = Sets.a(new UploadPhotoParams[]{new Builder(new UploadPhotoSource(a.e(), a.o())).a()});
            final Handler handler2 = handler;
            final long j2 = j;
            final EventAnalyticsParams eventAnalyticsParams2 = eventAnalyticsParams;
            final ActionMechanism actionMechanism2 = actionMechanism;
            C22401 c22401 = new DirectUploadListener(this) {
                final /* synthetic */ EventCoverPhotoUploadHandler f16062e;

                public final void m16451a(UploadPhotoParams uploadPhotoParams, final UploadRecord uploadRecord) {
                    HandlerDetour.a(handler2, new Runnable(this) {
                        final /* synthetic */ C22401 f16057b;

                        public void run() {
                            this.f16057b.f16062e.m16455a(j2, Long.toString(uploadRecord.fbid), eventAnalyticsParams2, actionMechanism2);
                        }
                    }, -1731635665);
                }
            };
            final MediaUploadCancelHandler mediaUploadCancelHandler = new MediaUploadCancelHandler();
            final HashSet hashSet = a2;
            final DirectUploadListener directUploadListener = c22401;
            final SettableFuture settableFuture = f;
            ExecutorDetour.a(this.f16073c, new Runnable(this) {
                final /* synthetic */ EventCoverPhotoUploadHandler f16067e;

                public void run() {
                    try {
                        this.f16067e.f16071a.a(hashSet, directUploadListener, mediaUploadCancelHandler, this.f16067e.f16078h, this.f16067e.f16078h.j("2.0"), null, this.f16067e.f16076f);
                    } catch (Throwable e) {
                        this.f16067e.f16074d.a(EventCoverPhotoUploadHandler.class.getName(), "Failed to upload group cover photo");
                        settableFuture.a(e);
                    }
                }
            }, 792405724);
        } catch (Throwable th) {
            this.f16074d.a(EventCoverPhotoUploadHandler.class.getName(), "Failed to upload event cover photo");
            f.a(th);
        }
        return f;
    }

    private void m16455a(final long j, String str, EventAnalyticsParams eventAnalyticsParams, ActionMechanism actionMechanism) {
        List of;
        CoverPhotoInfo coverPhotoInfo = new CoverPhotoInfo();
        coverPhotoInfo.a(str);
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a(eventAnalyticsParams.d);
        if (eventAnalyticsParams.c == null) {
            of = ImmutableList.of(eventActionHistory);
        } else {
            EventActionHistory eventActionHistory2 = new EventActionHistory();
            eventActionHistory2.a(eventAnalyticsParams.c);
            if (actionMechanism != null) {
                eventActionHistory2.b(actionMechanism.toString());
            }
            of = ImmutableList.of(eventActionHistory2, eventActionHistory);
        }
        Context context = new Context();
        context.a(of);
        EventEditInputData a = new EventEditInputData().a(context);
        a.a(Long.toString(j)).a(coverPhotoInfo);
        this.f16079i.a("tasks-editEvent:" + j, this.f16075e.a(GraphQLRequest.a((EditEventCoreMutationString) EventCreationMutations.m16643b().a("input", a))), new AbstractDisposableFutureCallback<GraphQLResult<EditEventCoreMutationFieldsModel>>(this) {
            final /* synthetic */ EventCoverPhotoUploadHandler f16069b;

            protected final void m16452a(Object obj) {
                EventModel a = ((EditEventCoreMutationFieldsModel) ((GraphQLResult) obj).e).m16668a();
                if (!(a == null || a.m16665j() == null)) {
                    a.m16665j().equals(Long.toString(j));
                }
                this.f16069b.f16072b.a(new EventUpdatedEvent(Long.toString(j)));
            }

            protected final void m16453a(Throwable th) {
                BLog.b(EventCoverPhotoUploadHandler.class, "Error editing event: ", th);
            }
        });
    }
}
