package com.facebook.events.photoreminder;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.JSONUtil;
import com.facebook.config.application.Product;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.photoreminder.EventPhotoReminderRequestSender.C26891;
import com.facebook.events.photoreminder.protocol.EventPhotoReminderMutations.EventSendSharePhotosReminderCoreMutationString;
import com.facebook.graphql.calls.EventSendSharePhotosReminderInputData;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.push.PushProperty;
import com.facebook.push.fbpushdata.BaseFbPushDataHandler;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: background_location_chat_context_disabled_miniphone_displayed */
public class EventPhotoUploadReminderPushDataHandler extends BaseFbPushDataHandler {
    public static final String f18973b = EventPhotoUploadReminderPushDataHandler.class.getSimpleName();
    private static volatile EventPhotoUploadReminderPushDataHandler f18974h;
    private final Lazy<Product> f18975c;
    public final Lazy<EventPhotoReminderUtil> f18976d;
    private Lazy<QeAccessor> f18977e;
    public final Lazy<FbErrorReporter> f18978f;
    public final Lazy<EventPhotoReminderRequestSender> f18979g;

    public static com.facebook.events.photoreminder.EventPhotoUploadReminderPushDataHandler m19206a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18974h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.photoreminder.EventPhotoUploadReminderPushDataHandler.class;
        monitor-enter(r1);
        r0 = f18974h;	 Catch:{ all -> 0x003a }
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
        r0 = m19207b(r0);	 Catch:{ all -> 0x0035 }
        f18974h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18974h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.photoreminder.EventPhotoUploadReminderPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.events.photoreminder.EventPhotoUploadReminderPushDataHandler");
    }

    private static EventPhotoUploadReminderPushDataHandler m19207b(InjectorLike injectorLike) {
        return new EventPhotoUploadReminderPushDataHandler(ReliabilityAnalyticsLogger.a(injectorLike), IdBasedLazy.a(injectorLike, 873), IdBasedSingletonScopeProvider.b(injectorLike, 3219), IdBasedSingletonScopeProvider.b(injectorLike, 5680), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 5679));
    }

    @Inject
    public EventPhotoUploadReminderPushDataHandler(ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, Lazy<Product> lazy, Lazy<QeAccessor> lazy2, Lazy<EventPhotoReminderUtil> lazy3, Lazy<FbErrorReporter> lazy4, Lazy<EventPhotoReminderRequestSender> lazy5) {
        super(reliabilityAnalyticsLogger);
        this.f18975c = lazy;
        this.f18977e = lazy2;
        this.f18976d = lazy3;
        this.f18978f = lazy4;
        this.f18979g = lazy5;
    }

    public final void m19208b(JsonNode jsonNode, PushProperty pushProperty) {
        if ("event_photo_check".equals(JSONUtil.b(jsonNode.b("type"))) && this.f18975c.get() == Product.FB4A && ((QeAccessor) this.f18977e.get()).a(Liveness.Live, ExperimentsForEventsGatingModule.o, false)) {
            JsonNode b = jsonNode.b("params");
            if (b != null) {
                JsonNode b2 = b.b("es");
                JsonNode b3 = b.b("ee");
                b = b.b("o");
                if (b2 != null && b3 != null && b != null) {
                    int C = b2.C();
                    int C2 = b3.C();
                    final String B = b.B();
                    if (C != 0 && C2 != 0 && !Strings.isNullOrEmpty(B)) {
                        ((EventPhotoReminderUtil) this.f18976d.get()).m19203a((long) C, (long) C2, new AbstractDisposableFutureCallback<Integer>(this) {
                            final /* synthetic */ EventPhotoUploadReminderPushDataHandler f18972b;

                            protected final void m19204a(Object obj) {
                                if (((Integer) obj).intValue() > 0) {
                                    EventPhotoReminderRequestSender eventPhotoReminderRequestSender = (EventPhotoReminderRequestSender) this.f18972b.f18979g.get();
                                    String str = B;
                                    GraphQlQueryString eventSendSharePhotosReminderCoreMutationString = new EventSendSharePhotosReminderCoreMutationString();
                                    EventSendSharePhotosReminderInputData eventSendSharePhotosReminderInputData = new EventSendSharePhotosReminderInputData();
                                    eventSendSharePhotosReminderInputData.a("event_id", str);
                                    eventSendSharePhotosReminderCoreMutationString.a("input", eventSendSharePhotosReminderInputData);
                                    Futures.a(eventPhotoReminderRequestSender.f18961c.a(new MutationRequest(eventSendSharePhotosReminderCoreMutationString)), new C26891(eventPhotoReminderRequestSender), MoreExecutors.a());
                                }
                            }

                            protected final void m19205a(Throwable th) {
                                ((AbstractFbErrorReporter) this.f18972b.f18978f.get()).a(EventPhotoUploadReminderPushDataHandler.f18973b, "Exception while fetching photo count.", th);
                            }
                        });
                    }
                }
            }
        }
    }
}
