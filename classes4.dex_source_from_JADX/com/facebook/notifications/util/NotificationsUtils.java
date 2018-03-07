package com.facebook.notifications.util;

import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.executor.LegacyConsistencyBridge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.server.NotificationsChangeSeenStateParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: modify_audio */
public class NotificationsUtils {
    private static final Class<?> f7557a = NotificationsUtils.class;
    private static volatile NotificationsUtils f7558i;
    public final DefaultBlueServiceOperationFactory f7559b;
    public final Lazy<GraphQLNotificationsContentProviderHelper> f7560c;
    public final ListeningExecutorService f7561d;
    private final ListeningExecutorService f7562e;
    public final DefaultAndroidThreadUtil f7563f;
    public boolean f7564g;
    public final LegacyConsistencyBridge f7565h;

    public static com.facebook.notifications.util.NotificationsUtils m7841a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7558i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsUtils.class;
        monitor-enter(r1);
        r0 = f7558i;	 Catch:{ all -> 0x003a }
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
        r0 = m7842b(r0);	 Catch:{ all -> 0x0035 }
        f7558i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7558i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsUtils.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsUtils");
    }

    private static NotificationsUtils m7842b(InjectorLike injectorLike) {
        return new NotificationsUtils(DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2820), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), LegacyConsistencyBridge.b(injectorLike));
    }

    @Inject
    public NotificationsUtils(BlueServiceOperationFactory blueServiceOperationFactory, Lazy<GraphQLNotificationsContentProviderHelper> lazy, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, AndroidThreadUtil androidThreadUtil, LegacyConsistencyBridge legacyConsistencyBridge) {
        this.f7560c = lazy;
        this.f7559b = blueServiceOperationFactory;
        this.f7561d = listeningExecutorService;
        this.f7562e = listeningExecutorService2;
        this.f7563f = androidThreadUtil;
        this.f7565h = legacyConsistencyBridge;
    }

    public final void m7846a(NotificationLogObject notificationLogObject) {
        if (notificationLogObject != null) {
            Object obj;
            if (StringUtil.a(notificationLogObject.f)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                obj = notificationLogObject.f;
            } else {
                obj = String.valueOf(notificationLogObject.e);
            }
            m7848a(ImmutableList.of(obj), GraphQLStorySeenState.SEEN_AND_READ);
        }
    }

    public final void m7849a(List<String> list, GraphQLStorySeenState graphQLStorySeenState, ViewerContext viewerContext) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(!list.isEmpty(), "Notification ID list can't be empty");
        Bundle bundle = new Bundle();
        bundle.putParcelable("graphNotifsUpdateSeenStatePrams", new NotificationsChangeSeenStateParams(list, graphQLStorySeenState));
        if (viewerContext != null) {
            bundle.putParcelable("overridden_viewer_context", viewerContext);
        }
        Operation a = BlueServiceOperationFactoryDetour.a(this.f7559b, "graphNotifUpdateSeenState", bundle, 860465450);
        a.a(true);
        a.a();
    }

    public final void m7848a(List<String> list, GraphQLStorySeenState graphQLStorySeenState) {
        m7849a(list, graphQLStorySeenState, null);
    }

    public final void m7845a(ViewerContext viewerContext) {
        if (viewerContext != null) {
            ExecutorDetour.a(this.f7561d, new 1(this, f7557a, "markStoredNotificationsAsSeen", Long.parseLong(viewerContext.mUserId), viewerContext), 705444072);
        }
    }

    public final void m7847a(Iterable<String> iterable, int i) {
        ExecutorDetour.a(this.f7561d, new 2(this, f7557a, "updateSeenStateSessionNumber", iterable, i), 1826045640);
    }

    public final ListenableFuture<GraphQLStory> m7844a(String str, String str2) {
        return this.f7562e.a(new 6(this, str, str2));
    }

    public final ImmutableList<String> m7843a(long j) {
        this.f7563f.b();
        return ((GraphQLNotificationsContentProviderHelper) this.f7560c.get()).m7914c(j);
    }
}
