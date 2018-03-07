package com.facebook.timeline.header;

import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.friends.cache.FriendshipStatusCache;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.ipc.profile.TimelineFriendParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.contextual.TimelineContextItemsData;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.event.TimelineFriendingEvents.SubscribeStatusChangedEvent;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemsConnectionFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.UserTimelineSelfQueryFieldsModel;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: friend_list_all_friends_seen */
public class TimelineHeaderUpdateDispatcher {
    private static volatile TimelineHeaderUpdateDispatcher f11436d;
    private final QeAccessor f11437a;
    public final Provider<FriendshipStatusCache> f11438b;
    private final TimelineHeaderEventBus f11439c;

    public static com.facebook.timeline.header.TimelineHeaderUpdateDispatcher m11484a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11436d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.header.TimelineHeaderUpdateDispatcher.class;
        monitor-enter(r1);
        r0 = f11436d;	 Catch:{ all -> 0x003a }
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
        r0 = m11487b(r0);	 Catch:{ all -> 0x0035 }
        f11436d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11436d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.header.TimelineHeaderUpdateDispatcher.a(com.facebook.inject.InjectorLike):com.facebook.timeline.header.TimelineHeaderUpdateDispatcher");
    }

    private static TimelineHeaderUpdateDispatcher m11487b(InjectorLike injectorLike) {
        return new TimelineHeaderUpdateDispatcher((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2076), TimelineHeaderEventBus.a(injectorLike));
    }

    @Inject
    public TimelineHeaderUpdateDispatcher(QeAccessor qeAccessor, Provider<FriendshipStatusCache> provider, TimelineHeaderEventBus timelineHeaderEventBus) {
        this.f11437a = qeAccessor;
        this.f11438b = provider;
        this.f11439c = timelineHeaderEventBus;
    }

    public final void m11488a(Object obj, DataFreshnessResult dataFreshnessResult, TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, TimelineContextualInfoData timelineContextualInfoData) {
        TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel = null;
        if (obj instanceof UserTimelineSelfQueryFieldsModel) {
            timelineHeaderUserFieldsModel = ((UserTimelineSelfQueryFieldsModel) obj).a();
        } else if (obj instanceof TimelineHeaderUserFieldsModel) {
            timelineHeaderUserFieldsModel = (TimelineHeaderUserFieldsModel) obj;
        }
        if (timelineHeaderUserData != null && timelineContext != null && timelineHeaderUserFieldsModel != null) {
            timelineHeaderUserData.f = dataFreshnessResult;
            timelineHeaderUserData.a(obj);
            m11485a(timelineContext, timelineHeaderUserData, timelineContextualInfoData);
            if (timelineContextualInfoData != null) {
                timelineContextualInfoData.h();
            }
            if (!StringUtil.a(timelineHeaderUserFieldsModel.p())) {
                GraphQLFriendshipStatus j = timelineHeaderUserFieldsModel.j();
                if (!(j == null || j == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
                    ((FriendshipStatusCache) this.f11438b.get()).a(Long.parseLong(timelineHeaderUserFieldsModel.p()), j);
                }
                m11486a(timelineHeaderUserFieldsModel, timelineContext, timelineHeaderUserData);
            }
        }
    }

    private void m11485a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, TimelineContextualInfoData timelineContextualInfoData) {
        if (this.f11437a.a(ExperimentsForTimelineAbTestModule.aj, false)) {
            if (timelineHeaderUserData.b != null && timelineHeaderUserData.b.g() != null && timelineContextualInfoData != null) {
                timelineContextualInfoData.m10468a(TimelineContextItemsData.m10452a(timelineHeaderUserData.b.g()), m11483a(timelineContext, timelineHeaderUserData));
            }
        } else if (timelineHeaderUserData.s().isPresent() && timelineContextualInfoData != null) {
            TimelineContextItemsData timelineContextItemsData;
            TimelineContextListItemsConnectionFieldsModel timelineContextListItemsConnectionFieldsModel = (TimelineContextListItemsConnectionFieldsModel) timelineHeaderUserData.s().get();
            if (timelineContextListItemsConnectionFieldsModel == null) {
                timelineContextItemsData = null;
            } else {
                timelineContextItemsData = new TimelineContextItemsData(timelineContextListItemsConnectionFieldsModel.a(), timelineContextListItemsConnectionFieldsModel.b());
            }
            timelineContextualInfoData.m10468a(timelineContextItemsData, m11483a(timelineContext, timelineHeaderUserData));
        }
    }

    private int m11483a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData) {
        if (this.f11437a.a(ExperimentsForTimelineAbTestModule.X, false)) {
            return 2;
        }
        if (timelineContext.i() || timelineHeaderUserData.B() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            return 1;
        }
        return 2;
    }

    private void m11486a(TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel, TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData) {
        GraphQLSubscribeStatus n = timelineHeaderUserFieldsModel.n();
        if (n != null && n != GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            this.f11439c.a(new SubscribeStatusChangedEvent(TimelineFriendParams.a(timelineContext, timelineHeaderUserData.N(), timelineHeaderUserData.C(), timelineHeaderUserData.B())));
        }
    }
}
