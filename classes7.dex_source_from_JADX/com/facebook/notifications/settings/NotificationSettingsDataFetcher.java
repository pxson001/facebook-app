package com.facebook.notifications.settings;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQL.NotificationNodeSettingsQueryString;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotificationNodeSettingsQueryModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotificationUserSettingsFragmentModel;
import com.facebook.notifications.widget.NotificationSettingsFragment;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mobile_carrier_account */
public class NotificationSettingsDataFetcher {
    private static volatile NotificationSettingsDataFetcher f8718d;
    public final GraphQLQueryExecutor f8719a;
    public final GraphQLImageHelper f8720b;
    public final TasksManager<String> f8721c;

    /* compiled from: mobile_carrier_account */
    class NotifOptionSetsCallback extends AbstractDisposableFutureCallback<Map<String, NotificationNodeSettingsQueryModel>> {
        private List<String> f8715a;
        private NotificationSettingsFragment f8716b;

        protected final void m10680a(Object obj) {
            Map map = (Map) obj;
            List arrayList = new ArrayList();
            for (String str : this.f8715a) {
                if (map.containsKey(str)) {
                    arrayList.add(map.get(str));
                }
            }
            this.f8716b.m10874a(arrayList);
        }

        public NotifOptionSetsCallback(List<String> list, FetchCallback fetchCallback) {
            this.f8715a = list;
            this.f8716b = fetchCallback;
        }

        protected final void m10681a(Throwable th) {
        }
    }

    /* compiled from: mobile_carrier_account */
    public class NotificationSettingsCallback extends AbstractDisposableFutureCallback<GraphQLResult<NotificationUserSettingsFragmentModel>> {
        private NotificationSettingsFragment f8717a;

        protected final void m10682a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ((NotificationUserSettingsFragmentModel) graphQLResult.e).m10609a() != null && !CollectionUtil.a(((NotificationUserSettingsFragmentModel) graphQLResult.e).m10609a().m10605a()) && this.f8717a != null) {
                this.f8717a.m10874a(((NotificationUserSettingsFragmentModel) graphQLResult.e).m10609a().m10605a());
            }
        }

        public NotificationSettingsCallback(NotificationSettingsFragment notificationSettingsFragment) {
            this.f8717a = notificationSettingsFragment;
        }

        protected final void m10683a(Throwable th) {
        }
    }

    public static com.facebook.notifications.settings.NotificationSettingsDataFetcher m10684a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8718d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.settings.NotificationSettingsDataFetcher.class;
        monitor-enter(r1);
        r0 = f8718d;	 Catch:{ all -> 0x003a }
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
        r0 = m10685b(r0);	 Catch:{ all -> 0x0035 }
        f8718d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8718d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.settings.NotificationSettingsDataFetcher.a(com.facebook.inject.InjectorLike):com.facebook.notifications.settings.NotificationSettingsDataFetcher");
    }

    private static NotificationSettingsDataFetcher m10685b(InjectorLike injectorLike) {
        return new NotificationSettingsDataFetcher(TasksManager.b(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public NotificationSettingsDataFetcher(TasksManager tasksManager, GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f8719a = graphQLQueryExecutor;
        this.f8720b = graphQLImageHelper;
        this.f8721c = tasksManager;
    }

    public final void m10686a(ImmutableList<String> immutableList, FetchCallback fetchCallback) {
        GraphQlQueryString notificationNodeSettingsQueryString = new NotificationNodeSettingsQueryString();
        notificationNodeSettingsQueryString.a("image_height", this.f8720b.f());
        notificationNodeSettingsQueryString.a("image_width", this.f8720b.f());
        notificationNodeSettingsQueryString.a("icon_scale", GraphQlQueryDefaults.a());
        notificationNodeSettingsQueryString.a("ids", immutableList);
        this.f8721c.a("NOTIFICATION_SETTINGS_LOAD", GraphQLQueryExecutor.c(this.f8719a.a(GraphQLRequest.a(notificationNodeSettingsQueryString))), new NotifOptionSetsCallback(immutableList, fetchCallback));
    }
}
