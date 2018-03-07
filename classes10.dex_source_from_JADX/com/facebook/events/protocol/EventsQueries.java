package com.facebook.events.protocol;

import android.content.ContentResolver;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.device.ScreenUtil;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.data.EventsProvider;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.FetchEventCommonQueryString;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: audio_clips_playback_start */
public class EventsQueries {
    private static volatile EventsQueries f19066h;
    public final ContentResolver f19067a;
    public final EventsCommonContract f19068b;
    public final GraphQLQueryExecutor f19069c;
    public final ListeningExecutorService f19070d;
    public final ScreenUtil f19071e;
    private final TasksManager f19072f;
    private final EventGraphQLModelHelper f19073g;

    public static com.facebook.events.protocol.EventsQueries m19293a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19066h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.protocol.EventsQueries.class;
        monitor-enter(r1);
        r0 = f19066h;	 Catch:{ all -> 0x003a }
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
        r0 = m19294b(r0);	 Catch:{ all -> 0x0035 }
        f19066h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19066h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.protocol.EventsQueries.a(com.facebook.inject.InjectorLike):com.facebook.events.protocol.EventsQueries");
    }

    private static EventsQueries m19294b(InjectorLike injectorLike) {
        return new EventsQueries(ContentResolverMethodAutoProvider.b(injectorLike), EventsCommonContract.b(injectorLike), EventGraphQLModelHelper.m19271a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ScreenUtil.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public EventsQueries(ContentResolver contentResolver, EventsCommonContract eventsCommonContract, EventGraphQLModelHelper eventGraphQLModelHelper, GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, ScreenUtil screenUtil, TasksManager tasksManager) {
        this.f19067a = contentResolver;
        this.f19068b = eventsCommonContract;
        this.f19073g = eventGraphQLModelHelper;
        this.f19069c = graphQLQueryExecutor;
        this.f19070d = listeningExecutorService;
        this.f19071e = screenUtil;
        this.f19072f = tasksManager;
    }

    public final void m19295a(final int i, final String str) {
        this.f19072f.a("tasks-fetchEventCommonFragment:" + str, new Callable<ListenableFuture<GraphQLResult<EventCommonFragmentModel>>>(this) {
            final /* synthetic */ EventsQueries f19063c;

            public Object call() {
                GraphQLRequest a = GraphQLRequest.a(EventsGraphQL.d());
                a.a(new FetchEventCommonQueryString().a("event_id", str).a("profile_image_size", String.valueOf(i)).a("cover_image_portrait_size", Integer.valueOf(this.f19063c.f19071e.f())).a("cover_image_landscape_size", Integer.valueOf(this.f19063c.f19071e.g())).a);
                return this.f19063c.f19069c.a(a);
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<EventCommonFragmentModel>>(this) {
            final /* synthetic */ EventsQueries f19065b;

            protected final void m19291a(Object obj) {
                EventCommonFragment eventCommonFragment = (EventCommonFragment) ((GraphQLResult) obj).e;
                if (eventCommonFragment != null) {
                    EventsProvider.a(this.f19065b.f19067a, this.f19065b.f19068b, EventGraphQLModelHelper.m19277b(eventCommonFragment), this.f19065b.f19070d);
                    return;
                }
                EventsProvider.a(this.f19065b.f19067a, this.f19065b.f19068b, str, this.f19065b.f19070d);
            }

            protected final void m19292a(Throwable th) {
            }
        });
    }
}
