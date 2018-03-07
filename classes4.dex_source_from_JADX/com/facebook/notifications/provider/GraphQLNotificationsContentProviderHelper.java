package com.facebook.notifications.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.Flattenable.VirtualFlattenableResolver;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifHighlightState;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.executor.cache.DiskCacheFlattenableHelper;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActor$Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLIcon;
import com.facebook.graphql.model.GraphQLImage$Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory$Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.VirtualFlattenableResolverImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.ipc.notifications.GraphQLNotificationsContract;
import com.facebook.ipc.notifications.GraphQLNotificationsContract.GraphQLNotificationsTable;
import com.facebook.ipc.notifications.GraphQLNotificationsContract.GraphQLNotificationsTable.Columns;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.languages.switchercommonex.LocaleChangeListener;
import com.facebook.notifications.cache.BaseListenableCache.OnChangeListener;
import com.facebook.notifications.cache.NotificationStoryCache;
import com.facebook.notifications.model.NotificationStories;
import com.facebook.notifications.module.C0370x4bdd3883;
import com.facebook.notifications.module.C0371x4c6b58f0;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.ImportanceReasonTextModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationHighlightOperationFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationOptionRowModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsDeltaFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsLikeCountGraphQLModels.FetchNotificationsLikeCountModel;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.facebook.notifications.util.NotificationsLikeCountHelper;
import com.facebook.notifications.util.NotificationsMutator;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: model_update */
public class GraphQLNotificationsContentProviderHelper implements IHaveUserData, DiskTrimmable {
    static final String[] f7572a = new String[]{Columns.f7591e.d, Columns.f7588b.d, Columns.f7606t.d, Columns.f7608v.d, Columns.f7609w.d};
    static final String[] f7573b = new String[]{Columns.f7590d.d, Columns.f7591e.d, Columns.f7593g.d, Columns.f7592f.d, Columns.f7596j.d, Columns.f7595i.d, Columns.f7597k.d, Columns.f7598l.d, Columns.f7588b.d, Columns.f7599m.d, Columns.f7600n.d, Columns.f7601o.d, Columns.f7602p.d, Columns.f7603q.d, Columns.f7604r.d, Columns.f7605s.d, Columns.f7606t.d, Columns.f7607u.d, Columns.f7608v.d, Columns.f7609w.d};
    private static volatile GraphQLNotificationsContentProviderHelper f7574o;
    private final QuickPerformanceLogger f7575c;
    public final GraphQLNotificationsContract f7576d;
    public final ContentResolver f7577e;
    private final NotificationsLastUpdatedUtil f7578f;
    public final NotificationStoryCache f7579g;
    public final NotificationStoryCache f7580h;
    private final AbstractFbErrorReporter f7581i;
    private final DefaultAndroidThreadUtil f7582j;
    public final ListeningExecutorService f7583k;
    private final TodayExperimentController f7584l;
    public final Map<String, Integer> f7585m = new HashMap();
    private final Map<String, Boolean> f7586n = new HashMap();

    /* compiled from: model_update */
    class C03721 implements LocaleChangeListener {
        final /* synthetic */ GraphQLNotificationsContentProviderHelper f7624a;

        C03721(GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper) {
            this.f7624a = graphQLNotificationsContentProviderHelper;
        }

        public final ListenableFuture m7961a(Locale locale) {
            return this.f7624a.f7583k.a(new 1(this));
        }
    }

    public static com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper m7861a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7574o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper.class;
        monitor-enter(r1);
        r0 = f7574o;	 Catch:{ all -> 0x003a }
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
        r0 = m7869b(r0);	 Catch:{ all -> 0x0035 }
        f7574o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7574o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper");
    }

    private static GraphQLNotificationsContentProviderHelper m7869b(InjectorLike injectorLike) {
        return new GraphQLNotificationsContentProviderHelper(GraphQLNotificationsContract.m7921b(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike.getApplicationInjector()), NotificationsLastUpdatedUtil.m7923b(injectorLike), C0370x4bdd3883.m7928b(injectorLike), C0371x4c6b58f0.m7960b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), DiskCacheManager.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), LocaleChangeController.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TodayExperimentController.a(injectorLike));
    }

    @Inject
    public GraphQLNotificationsContentProviderHelper(GraphQLNotificationsContract graphQLNotificationsContract, @NeedsApplicationInjector ContentResolver contentResolver, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil, NotificationStoryCache notificationStoryCache, NotificationStoryCache notificationStoryCache2, AbstractFbErrorReporter abstractFbErrorReporter, DefaultAndroidThreadUtil defaultAndroidThreadUtil, DiskCacheManager diskCacheManager, QuickPerformanceLogger quickPerformanceLogger, LocaleChangeController localeChangeController, ListeningExecutorService listeningExecutorService, TodayExperimentController todayExperimentController) {
        this.f7576d = (GraphQLNotificationsContract) Preconditions.checkNotNull(graphQLNotificationsContract);
        this.f7577e = (ContentResolver) Preconditions.checkNotNull(contentResolver);
        this.f7578f = notificationsLastUpdatedUtil;
        this.f7579g = notificationStoryCache;
        this.f7580h = notificationStoryCache2;
        this.f7581i = abstractFbErrorReporter;
        this.f7582j = defaultAndroidThreadUtil;
        this.f7575c = quickPerformanceLogger;
        this.f7583k = listeningExecutorService;
        this.f7579g.mo620g();
        this.f7580h.mo620g();
        this.f7584l = todayExperimentController;
        diskCacheManager.a(this);
        localeChangeController.a(new C03721(this));
    }

    public final void m7897a(OnChangeListener onChangeListener) {
        this.f7580h.m7944a(onChangeListener);
    }

    public final void m7909b(OnChangeListener onChangeListener) {
        this.f7580h.m7946b(onChangeListener);
    }

    @Nonnull
    public final FetchGraphQLNotificationsResult m7895a(@Nonnull FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams) {
        Preconditions.checkNotNull(fetchGraphQLNotificationsParams);
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        this.f7575c.b(3473409);
        Cursor a = m7857a(fetchGraphQLNotificationsParams.m8043k() ? fetchGraphQLNotificationsParams.m8041b() + fetchGraphQLNotificationsParams.m8045n() : fetchGraphQLNotificationsParams.m8041b(), f7573b, fetchGraphQLNotificationsParams.m8042f());
        this.f7575c.b(3473409, (short) 2);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    do {
                        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a2 = m7860a(a, false);
                        if (a2 == null) {
                            a2 = m7890p(a);
                            if (a2 != null) {
                                this.f7579g.m7954b(a2);
                            }
                        }
                        if (a2 != null) {
                            builder2.c(a2.mo822k().g());
                            builder.c(a2);
                        }
                    } while (a.moveToNext());
                }
            } catch (Throwable e) {
                this.f7581i.a("GraphQLNotificationsContentProviderHelper_fetch_error", "Error loading notifications", e);
                if (a != null) {
                    a.close();
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
            }
        }
        if (a != null) {
            a.close();
        }
        this.f7579g.m7952a(builder2.b());
        List b = builder.b();
        return new FetchGraphQLNotificationsResult(new NotificationStories(b), fetchGraphQLNotificationsParams.m8042f(), b.size() > 0 ? DataFreshnessResult.FROM_CACHE_UP_TO_DATE : DataFreshnessResult.NO_DATA, this.f7578f.m7924a());
    }

    public final FetchGraphQLNotificationsResult m7907b(FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams) {
        Preconditions.checkNotNull(fetchGraphQLNotificationsParams);
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        Cursor b = m7867b(null, m7883i(fetchGraphQLNotificationsParams.m8042f()));
        if (b != null) {
            try {
                if (b.moveToFirst()) {
                    do {
                        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a = m7860a(b, false);
                        if (a == null) {
                            a = m7890p(b);
                            if (a != null) {
                                this.f7579g.m7954b(a);
                            }
                        }
                        if (a != null) {
                            builder2.c(a.mo822k().g());
                            builder.c(a);
                        }
                    } while (b.moveToNext());
                }
            } catch (Throwable e) {
                this.f7581i.a("GraphQLNotificationsContentProviderHelper_unseen_fetch_error", "Error fetching unseen notifs", e);
                if (b != null) {
                    b.close();
                }
            } catch (Throwable th) {
                if (b != null) {
                    b.close();
                }
            }
        }
        if (b != null) {
            b.close();
        }
        if (!fetchGraphQLNotificationsParams.m8044m()) {
            this.f7579g.m7952a(builder2.b());
        }
        List b2 = builder.b();
        return new FetchGraphQLNotificationsResult(new NotificationStories(b2), fetchGraphQLNotificationsParams.m8042f(), !b2.isEmpty() ? DataFreshnessResult.FROM_CACHE_UP_TO_DATE : DataFreshnessResult.NO_DATA, this.f7578f.m7924a(), true);
    }

    public final Collection<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> m7915c() {
        return this.f7580h.m7950a();
    }

    public final boolean m7902a(String str, GraphQLStorySeenState graphQLStorySeenState) {
        this.f7580h.f7620b = false;
        boolean a = this.f7580h.m7936a(str, graphQLStorySeenState);
        this.f7580h.f7620b = true;
        return a;
    }

    public final boolean m7910b(String str, GraphQLStorySeenState graphQLStorySeenState) {
        return this.f7579g.m7936a(str, graphQLStorySeenState);
    }

    public final boolean m7903a(String str, String str2, long j, boolean z) {
        this.f7586n.put(str + String.valueOf(j), Boolean.valueOf(z));
        this.f7580h.f7620b = false;
        boolean a = this.f7580h.m7939a(str2, z);
        this.f7580h.f7620b = true;
        return a;
    }

    public final boolean m7911b(String str, String str2, long j, boolean z) {
        this.f7586n.put(str + String.valueOf(j), Boolean.valueOf(z));
        return this.f7579g.m7939a(str2, z);
    }

    public final boolean m7901a(long j, long j2) {
        return j2 < m7877f(j);
    }

    private long m7877f(long j) {
        Throwable e;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            long j2;
            Cursor query = this.f7577e.query(this.f7576d.f7611b, new String[]{Columns.f7591e.a()}, Columns.f7589c.a() + "=?", new String[]{String.valueOf(j)}, Columns.f7591e.a() + " asc LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        j2 = query.getLong(Columns.f7591e.a(query));
                        if (query != null) {
                            return j2;
                        }
                        query.close();
                        return j2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        this.f7581i.a("GraphQLNotificationsContentProviderHelper_oldest_notif_time_fetch_error", "Error fetching oldest notif", e);
                        if (cursor != null) {
                            return -1;
                        }
                        cursor.close();
                        return -1;
                    } catch (Throwable th) {
                        e = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw e;
                }
            }
            j2 = -1;
            if (query != null) {
                return j2;
            }
            query.close();
            return j2;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_oldest_notif_time_fetch_error", "Error fetching oldest notif", e);
            if (cursor != null) {
                return -1;
            }
            cursor.close();
            return -1;
        } catch (Throwable th3) {
            e = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw e;
        }
    }

    public final ImmutableList<String> m7896a(long j) {
        Builder builder = new Builder();
        Cursor a = m7857a(-1, GraphQLNotificationsTable.f7792a, j);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    int a2 = Columns.f7588b.a(a);
                    do {
                        try {
                            builder.c(a.getString(a2));
                        } catch (Throwable e) {
                            BLog.b("GraphQLNotificationsContentProviderHelper", e.getMessage(), e);
                        }
                    } while (a.moveToNext());
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
            }
        }
        if (a != null) {
            a.close();
        }
        return builder.b();
    }

    public final void ai_() {
        ImmutableList a = m7896a(-1);
        if (a.size() > 10) {
            m7899a(a.subList(10, a.size()), false);
        }
    }

    public final void m7908b() {
        ai_();
    }

    private void m7879g(long j) {
        ImmutableList a = m7896a(j);
        int size = a.size();
        if (size > 30) {
            List subList = a.subList(30, size);
            if (this.f7580h.m7955c() > 0) {
                m7871b((Iterable) subList);
            }
            m7899a(subList, true);
        }
    }

    public final void m7899a(List<String> list, boolean z) {
        if (this.f7582j.c()) {
            ExecutorDetour.a(this.f7583k, new 2(this, list, z), 414063562);
        } else {
            m7870b(this, list, z);
        }
    }

    public final int m7904b(long j) {
        return m7896a(j).size();
    }

    public final void m7898a(FetchGraphQLNotificationsResult fetchGraphQLNotificationsResult, boolean z) {
        if (fetchGraphQLNotificationsResult.f10826a != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields : m7863a(fetchGraphQLNotificationsResult.f10826a.newStories)) {
                FetchTimeMsHelper.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k(), fetchGraphQLNotificationsResult.b());
                arrayList2.add(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields);
            }
            boolean z2 = !arrayList2.isEmpty();
            if (fetchGraphQLNotificationsResult.f10826a.deltaStories != null) {
                for (NotificationsDeltaFieldsModel notificationsDeltaFieldsModel : m7863a(fetchGraphQLNotificationsResult.f10826a.deltaStories.m11277a())) {
                    FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a = notificationsDeltaFieldsModel.a();
                    if (a != null) {
                        int i;
                        int j = a.mo821j();
                        boolean gs_ = a.gs_();
                        if (a.mo822k() != null) {
                            int intValue;
                            String str = a.mo822k().c() + String.valueOf(a.mo822k().V());
                            if (this.f7585m.isEmpty() || this.f7586n.isEmpty()) {
                                m7881h(fetchGraphQLNotificationsResult.f10827b);
                            }
                            if (this.f7585m.containsKey(str)) {
                                intValue = ((Integer) this.f7585m.get(str)).intValue();
                            } else {
                                intValue = j;
                            }
                            if (this.f7586n.containsKey(str)) {
                                z2 = ((Boolean) this.f7586n.get(str)).booleanValue();
                            } else if (a.mo814b().isEmpty()) {
                                i = intValue;
                            } else {
                                z2 = !((NotificationHighlightOperationFragmentModel) a.mo814b().get(0)).c();
                            }
                            gs_ = z2;
                            i = intValue;
                        } else {
                            i = j;
                        }
                        FetchTimeMsHelper.a(a.mo822k(), fetchGraphQLNotificationsResult.b());
                        arrayList2.add(NotificationsMutator.a(a.mo822k(), a.mo823l(), a.mo813a(), a.mo815c(), a.mo816d(), a.gr_(), a.mo817g(), a.mo825n(), gs_, a.mo824m(), i, a.mo814b()));
                    } else if (!StringUtil.a(notificationsDeltaFieldsModel.j())) {
                        arrayList.add(notificationsDeltaFieldsModel.j());
                    }
                }
                z2 = !arrayList2.isEmpty();
                if (!arrayList.isEmpty()) {
                    m7899a(arrayList, z2);
                }
            }
            if (z2) {
                m7865a(arrayList2, fetchGraphQLNotificationsResult.f10827b, z);
            }
            this.f7578f.m7925a(fetchGraphQLNotificationsResult.b());
        }
    }

    private void m7881h(long j) {
        if (this.f7584l.L()) {
            this.f7585m.clear();
            this.f7586n.clear();
            Cursor a = m7857a(-1, f7572a, j);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        int a2 = Columns.f7591e.a(a);
                        int a3 = Columns.f7588b.a(a);
                        do {
                            try {
                                String str = a.getString(a3) + String.valueOf(a.getLong(a2));
                                this.f7586n.put(str, Boolean.valueOf(m7885k(a)));
                                this.f7585m.put(str, Integer.valueOf(m7882i(a)));
                            } catch (Throwable e) {
                                BLog.b("GraphQLNotificationsContentProviderHelper", e.getMessage(), e);
                            }
                        } while (a.moveToNext());
                    }
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        }
    }

    public final int m7892a(Iterable<String> iterable, GraphQLStorySeenState graphQLStorySeenState, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f7590d.a(), graphQLStorySeenState.name());
        Expression a = SqlExpression.a(Columns.f7588b.a(), iterable);
        Uri uri = this.f7576d.f7611b;
        if (z || graphQLStorySeenState.equals(GraphQLStorySeenState.SEEN_BUT_UNREAD)) {
            uri = this.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build();
        }
        try {
            return this.f7577e.update(uri, contentValues, a.a(), a.b());
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_updateSeenState", "Exception thrown when attempting to update seen state", e);
            return 0;
        }
    }

    public final int m7891a(Iterable<String> iterable, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f7608v.a(), Integer.valueOf(i));
        Expression a = SqlExpression.a(Columns.f7588b.a(), iterable);
        try {
            return this.f7577e.update(this.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build(), contentValues, a.a(), a.b());
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_updateSeenStateSessionNumber", "Exception thrown when attempting to update seen state session number", e);
            return 0;
        }
    }

    public final int m7912c(String str, ReactionUnitFragment reactionUnitFragment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f7605s.a(), m7866a(ReactionUnitFragmentModel.a(reactionUnitFragment), null));
        Expression a = SqlExpression.a(Columns.f7588b.a(), str);
        try {
            return this.f7577e.update(this.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build(), contentValues, a.a(), a.b());
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_updateReactionUnit", "Exception thrown when attempting to update reactionUnit", e);
            return 0;
        }
    }

    public final int m7894a(String str, boolean z) {
        int i = 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f7606t.a(), Integer.valueOf(z ? 1 : i));
        Expression a = SqlExpression.a(Columns.f7588b.a(), str);
        try {
            i = this.f7577e.update(this.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build(), contentValues, a.a(), a.b());
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_updateIsRichNotifCollapsed", "Exception thrown when attempting to update is rich notif collapsed", e);
        }
        return i;
    }

    public final int m7893a(String str, NotifOptionSetsModel notifOptionSetsModel) {
        int i = 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.f7607u.a(), m7866a(NotifOptionSetsModel.a(notifOptionSetsModel), null));
        Expression a = SqlExpression.a(Columns.f7588b.a(), new String[]{str});
        try {
            i = this.f7577e.update(this.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build(), contentValues, a.a(), a.b());
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_updateSeenStateSessionNumber", "Exception thrown when attempting to update selected option id", e);
        }
        return i;
    }

    private void m7865a(List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> list, long j, boolean z) {
        int b;
        Throwable th;
        int i = 0;
        Preconditions.checkArgument(!list.isEmpty(), "should be passed some notifs");
        if (z) {
            b = 30 - m7904b(j);
            if (b < 0) {
                b = 0;
            }
            if (b < list.size()) {
                m7864a(list.subList(b, list.size()));
                list = list.subList(0, b);
                if (b == 0) {
                    this.f7580h.m7948f();
                }
            }
            if (list.isEmpty()) {
                return;
            }
        }
        ContentValues[] contentValuesArr = new ContentValues[list.size()];
        for (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a : list) {
            try {
                b = i + 1;
                try {
                    contentValuesArr[i] = m7856a(a, j);
                    i = b;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    i = b;
                    th = th2;
                    this.f7581i.a("GraphQLNotificationsContentProviderHelper_content_values_error", "Exception thrown when converting GraphQL notification to ContentValues", th);
                }
            } catch (Exception e2) {
                th = e2;
                this.f7581i.a("GraphQLNotificationsContentProviderHelper_content_values_error", "Exception thrown when converting GraphQL notification to ContentValues", th);
            }
        }
        b = m7855a(contentValuesArr);
        if (b > 0) {
            m7879g(j);
            this.f7577e.notifyChange(this.f7576d.f7611b, null);
        }
        this.f7578f.m7927c(b);
    }

    private int m7855a(ContentValues... contentValuesArr) {
        Uri build = this.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build();
        int bulkInsert = this.f7577e.bulkInsert(build, contentValuesArr);
        if (bulkInsert == 0) {
            for (ContentValues insert : contentValuesArr) {
                if (this.f7577e.insert(build, insert) != null) {
                    bulkInsert++;
                }
            }
        }
        return bulkInsert;
    }

    public static void m7870b(GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, List list, boolean z) {
        if (!list.isEmpty()) {
            Expression a = SqlExpression.a(Columns.f7588b.d, list);
            graphQLNotificationsContentProviderHelper.f7577e.delete(z ? graphQLNotificationsContentProviderHelper.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build() : graphQLNotificationsContentProviderHelper.f7576d.f7611b, a.a(), a.b());
        }
    }

    public final ImmutableList<String> m7914c(long j) {
        return m7862a(j, 30);
    }

    private ImmutableList<String> m7862a(long j, int i) {
        Builder builder = new Builder();
        Cursor a = m7857a(i, new String[]{Columns.f7592f.a()}, j);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    int a2 = Columns.f7592f.a(a);
                    do {
                        try {
                            builder.c(a.getString(a2));
                        } catch (Throwable e) {
                            BLog.b("GraphQLNotificationsContentProviderHelper", e.getMessage(), e);
                        }
                    } while (a.moveToNext());
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
            }
        }
        if (a != null) {
            a.close();
        }
        return builder.b();
    }

    private Cursor m7857a(int i, String[] strArr, long j) {
        String a;
        String[] b;
        Uri uri = this.f7576d.f7611b;
        if (i > 0) {
            uri = uri.buildUpon().appendQueryParameter("LIMIT", String.valueOf(i)).build();
        }
        if (j != -1) {
            Expression a2 = SqlExpression.a(Columns.f7589c.a(), String.valueOf(j));
            a = a2.a();
            b = a2.b();
        } else {
            b = null;
            a = null;
        }
        try {
            return this.f7577e.query(uri, strArr, a, b, null);
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper", "failed trying to get cursor during query", e);
            BLog.b("GraphQLNotificationsContentProviderHelper", e.getMessage(), e);
            return null;
        }
    }

    private Cursor m7858a(String[] strArr, String str) {
        Uri uri = this.f7576d.f7611b;
        Expression a = SqlExpression.a(Columns.f7588b.d, str);
        return this.f7577e.query(uri, strArr, a.a(), a.b(), null);
    }

    private Cursor m7867b(String[] strArr, String str) {
        if (str == null) {
            return null;
        }
        Uri uri = this.f7576d.f7611b;
        Expression f = SqlExpression.f(Columns.f7591e.d, str);
        return this.f7577e.query(uri, strArr, f.a(), f.b(), null);
    }

    @Nullable
    public final GraphQLStory m7905b(@Nullable String str) {
        return m7906b(str, null);
    }

    @Nullable
    public final GraphQLStory m7906b(@Nullable String str, @Nullable String str2) {
        Throwable e;
        if (StringUtil.a(str)) {
            return null;
        }
        Cursor cursor = null;
        Cursor a;
        try {
            a = m7858a(null, str);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        GraphQLStory n = m7888n(a);
                        if (n != null) {
                            int a2 = Columns.f7593g.a(a);
                            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields e2 = m7874e(str2);
                            if (e2 != null) {
                                this.f7579g.m7954b(NotificationsMutator.a(n, e2.mo823l(), a.getString(a2), e2.mo815c(), e2.mo816d(), e2.gr_(), e2.mo817g(), e2.mo825n(), e2.gs_(), e2.mo824m(), e2.mo821j(), e2.mo814b()));
                            } else {
                                this.f7579g.m7954b(NotificationsMutator.a(n, m7872c(a), a.getString(a2), m7884j(a), m7875e(a), m7876f(a), m7878g(a), m7880h(a), m7885k(a), m7873d(a), m7882i(a), m7886l(a)));
                            }
                        }
                        if (a == null) {
                            return n;
                        }
                        a.close();
                        return n;
                    }
                } catch (IllegalStateException e3) {
                    e = e3;
                    cursor = a;
                    try {
                        this.f7581i.a("GraphQLNotificationsContentProviderHelper_cursor_error", e.getMessage(), e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        a = cursor;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw e;
                }
            }
            if (a != null) {
                a.close();
            }
            return null;
        } catch (IllegalStateException e4) {
            e = e4;
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_cursor_error", e.getMessage(), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            e = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
    }

    @Nullable
    public final GraphQLStory m7913c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.f7579g.m7957d(str);
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.f7580h.m7957d(str);
        }
        return (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null || fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k() == null || PropertyHelper.e(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k())) ? null : fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k();
    }

    @Nullable
    private FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields m7874e(@Nullable String str) {
        if (str == null) {
            return null;
        }
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.f7579g.m7957d(str);
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields == null) {
            return (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.f7580h.m7957d(str);
        }
        return fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
    }

    @Nullable
    private FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields m7860a(Cursor cursor, boolean z) {
        if (cursor == null) {
            return null;
        }
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a = this.f7579g.m7933a(cursor);
        if (a == null) {
            a = this.f7580h.m7933a(cursor);
        }
        if (a == null || a.mo822k() == null) {
            return null;
        }
        if (z && PropertyHelper.e(a.mo822k())) {
            return null;
        }
        return a;
    }

    @Nullable
    public final String m7917d(@Nonnull String str) {
        Preconditions.checkNotNull(str);
        String str2 = null;
        Cursor a = m7858a(new String[]{Columns.f7590d.a()}, str);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    str2 = a.getString(Columns.f7590d.a(a));
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
            }
        }
        if (a != null) {
            a.close();
        }
        return str2;
    }

    @Nullable
    public final String m7916d(long j) {
        String string;
        Cursor a = m7857a(1, new String[]{Columns.f7593g.a()}, j);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    try {
                        string = a.getString(Columns.f7593g.a(a));
                    } catch (Throwable e) {
                        BLog.b("GraphQLNotificationsContentProviderHelper", e.getMessage(), e);
                    }
                    if (a != null) {
                        a.close();
                    }
                    return string;
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
            }
        }
        string = null;
        if (a != null) {
            a.close();
        }
        return string;
    }

    private ContentValues m7856a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, long j) {
        int i;
        int i2 = 0;
        ContentValues contentValues = new ContentValues();
        Flattenable k = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k();
        contentValues.put(Columns.f7588b.d, k.c());
        contentValues.put(Columns.f7590d.d, k.au().name());
        contentValues.put(Columns.f7591e.d, Long.valueOf(k.V()));
        contentValues.put(Columns.f7604r.d, Integer.valueOf(NotificationsLikeCountHelper.m7850a((GraphQLStory) k)));
        contentValues.put(Columns.f7592f.d, k.g());
        contentValues.put(Columns.f7589c.d, Long.valueOf(j));
        contentValues.put(Columns.f7593g.d, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo813a());
        GraphQLActor b = StoryActorHelper.b(k);
        if (!(b == null || b.ai() == null)) {
            contentValues.put(Columns.f7595i.d, b.ai().b());
        }
        if (k.ad() != null) {
            contentValues.put(Columns.f7596j.d, k.ad().k());
        }
        contentValues.put(Columns.f7594h.d, m7866a(k, VirtualFlattenableResolverImpl.a));
        Flattenable aI = k.aI();
        if (aI == null) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_summary_null", "Notification story text is null for notification ID: " + k.g());
            aI = GraphQLHelper.a("");
        }
        contentValues.put(Columns.f7597k.d, m7866a(aI, VirtualFlattenableResolverImpl.a));
        if (k.aw() != null) {
            contentValues.put(Columns.f7598l.d, m7866a(k.aw(), VirtualFlattenableResolverImpl.a));
        }
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l() != null) {
            List arrayList = new ArrayList();
            ImmutableList l = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo823l();
            int size = l.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(NotificationOptionRowModel.a((NotificationOptionRowModel) l.get(i3)));
            }
            contentValues.put(Columns.f7599m.d, DiskCacheFlattenableHelper.a(arrayList));
        }
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo815c() != null) {
            contentValues.put(Columns.f7600n.d, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo815c().name());
        }
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo816d() != null) {
            contentValues.put(Columns.f7601o.d, m7866a(ImportanceReasonTextModel.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo816d()), null));
        }
        contentValues.put(Columns.f7602p.d, Integer.valueOf(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.gr_()));
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo817g() != null) {
            contentValues.put(Columns.f7603q.d, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo817g().name());
        }
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo825n() != null) {
            contentValues.put(Columns.f7605s.d, m7866a(ReactionUnitFragmentModel.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo825n()), null));
        }
        String str = Columns.f7606t.d;
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.gs_()) {
            i = 1;
        } else {
            i = 0;
        }
        contentValues.put(str, Integer.valueOf(i));
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m() != null) {
            contentValues.put(Columns.f7607u.d, m7866a(NotifOptionSetsModel.a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo824m()), null));
        }
        contentValues.put(Columns.f7608v.d, Integer.valueOf(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo821j()));
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo814b() != null) {
            List arrayList2 = new ArrayList();
            ImmutableList b2 = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo814b();
            int size2 = b2.size();
            while (i2 < size2) {
                arrayList2.add(NotificationHighlightOperationFragmentModel.a((NotificationHighlightOperationFragmentModel) b2.get(i2)));
                i2++;
            }
            contentValues.put(Columns.f7609w.d, DiskCacheFlattenableHelper.a(arrayList2));
        }
        return contentValues;
    }

    private byte[] m7866a(Flattenable flattenable, @Nullable VirtualFlattenableResolver virtualFlattenableResolver) {
        try {
            return FlatBufferBuilder.b(flattenable, virtualFlattenableResolver);
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper", "Failed to serialize object as flatbuffer", e);
            return null;
        }
    }

    @Nullable
    private GraphQLTextWithEntities m7859a(Cursor cursor) {
        int a = Columns.f7597k.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without a summary text gql column?");
        GraphQLTextWithEntities graphQLTextWithEntities;
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            graphQLTextWithEntities = (GraphQLTextWithEntities) MutableFlatBuffer.a(ByteBuffer.wrap(blob), VirtualFlattenableResolverImpl.a, null);
            return graphQLTextWithEntities;
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading notification text from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            graphQLTextWithEntities = null;
        }
    }

    @Nullable
    private GraphQLTextWithEntities m7868b(Cursor cursor) {
        int a = Columns.f7598l.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without a short summary text gql column?");
        GraphQLTextWithEntities graphQLTextWithEntities;
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            graphQLTextWithEntities = (GraphQLTextWithEntities) MutableFlatBuffer.a(ByteBuffer.wrap(blob), VirtualFlattenableResolverImpl.a, null);
            return graphQLTextWithEntities;
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading notification short summary text from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            graphQLTextWithEntities = null;
        }
    }

    @Nullable
    private ImmutableList<NotificationOptionRowModel> m7872c(Cursor cursor) {
        boolean z = false;
        int a = Columns.f7599m.a(cursor);
        if (a != -1) {
            z = true;
        }
        Preconditions.checkArgument(z, "Passing a cursor without a notif option row column?");
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            return DiskCacheFlattenableHelper.a(ByteBuffer.wrap(blob), NotificationOptionRowModel.class, null, null, false, null);
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading notifOptionRow from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            return null;
        }
    }

    @Nullable
    private NotifOptionSetsModel m7873d(Cursor cursor) {
        int a = Columns.f7607u.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without a notif option set column?");
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            return (NotifOptionSetsModel) MutableFlatBuffer.a(ByteBuffer.wrap(blob), NotifOptionSetsModel.class, null);
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading notifOptionSets from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            return null;
        }
    }

    @Nullable
    private ImportanceReasonTextModel m7875e(Cursor cursor) {
        if (!this.f7584l.C()) {
            return null;
        }
        int a = Columns.f7601o.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without an importance reason text column?");
        ImportanceReasonTextModel importanceReasonTextModel;
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            importanceReasonTextModel = (ImportanceReasonTextModel) MutableFlatBuffer.a(ByteBuffer.wrap(blob), ImportanceReasonTextModel.class, null);
            return importanceReasonTextModel;
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading importance reason text from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            importanceReasonTextModel = null;
        }
    }

    @Nullable
    private int m7876f(Cursor cursor) {
        boolean z = false;
        if (!this.f7584l.C()) {
            return 0;
        }
        int a = Columns.f7602p.a(cursor);
        if (a != -1) {
            z = true;
        }
        Preconditions.checkArgument(z, "Passing a cursor without an importance score column?");
        try {
            return cursor.getInt(a);
        } catch (Throwable e) {
            String str = "Error reading importance score from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, e);
            return -1;
        }
    }

    @Nullable
    private GraphQLNotifImportanceType m7878g(Cursor cursor) {
        if (!this.f7584l.C()) {
            return null;
        }
        GraphQLNotifImportanceType valueOf;
        int a = Columns.f7603q.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without an importance type column?");
        try {
            valueOf = GraphQLNotifImportanceType.valueOf(cursor.getString(a));
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading importance type from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            valueOf = null;
        }
        return valueOf;
    }

    @Nullable
    private ReactionUnitFragmentModel m7880h(Cursor cursor) {
        int a = Columns.f7605s.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without a reaction unit column?");
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            return (ReactionUnitFragmentModel) MutableFlatBuffer.a(ByteBuffer.wrap(blob), ReactionUnitFragmentModel.class, null);
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading reaction unit from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            return null;
        }
    }

    @Nullable
    private int m7882i(Cursor cursor) {
        int i;
        boolean z = false;
        int a = Columns.f7608v.a(cursor);
        Preconditions.checkArgument(a != -1 ? true : z, "Passing a cursor without an seeen state session number column?");
        try {
            i = cursor.getInt(a);
        } catch (Throwable e) {
            String str = "Error reading seen state session number from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, e);
        }
        return i;
    }

    @Nullable
    private GraphQLNotifHighlightState m7884j(Cursor cursor) {
        int a = Columns.f7600n.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without a highlight state column?");
        try {
            return GraphQLNotifHighlightState.valueOf(cursor.getString(a));
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading highlightState from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            return null;
        }
    }

    private boolean m7885k(Cursor cursor) {
        int a = Columns.f7606t.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without a is rich notif collapsed column?");
        try {
            if (cursor.getInt(a) != 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            String str = "Error reading is rich notif collapsed from cursor.";
            a = Columns.f7592f.a(cursor);
            if (a != -1) {
                str = str + " CacheId: " + cursor.getString(a);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, e);
            return false;
        }
    }

    @Nullable
    private ImmutableList<NotificationHighlightOperationFragmentModel> m7886l(Cursor cursor) {
        boolean z = false;
        int a = Columns.f7609w.a(cursor);
        if (a != -1) {
            z = true;
        }
        Preconditions.checkArgument(z, "Passing a cursor without a highlight operation column?");
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            return DiskCacheFlattenableHelper.a(ByteBuffer.wrap(blob), NotificationHighlightOperationFragmentModel.class, null, null, false, null);
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading highlightOperations from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            return null;
        }
    }

    @Nullable
    private GraphQLStory m7887m(Cursor cursor) {
        int a = Columns.f7594h.a(cursor);
        Preconditions.checkArgument(a != -1, "Passing a cursor without a gql payload column?");
        GraphQLStory graphQLStory;
        try {
            byte[] blob = cursor.getBlob(a);
            if (blob == null || blob.length == 0) {
                return null;
            }
            graphQLStory = (GraphQLStory) MutableFlatBuffer.a(ByteBuffer.wrap(blob), VirtualFlattenableResolverImpl.a, null);
            return graphQLStory;
        } catch (Throwable e) {
            Throwable th = e;
            String str = "Error reading notification story from cursor.";
            int a2 = Columns.f7592f.a(cursor);
            if (a2 != -1) {
                str = str + " CacheId: " + cursor.getString(a2);
            }
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_deserialize_error", str, th);
            graphQLStory = null;
        }
    }

    @Nullable
    private GraphQLStory m7888n(Cursor cursor) {
        int a = Columns.f7590d.a(cursor);
        int a2 = Columns.f7591e.a(cursor);
        this.f7575c.b(3473414);
        GraphQLStory m = m7887m(cursor);
        if (m != null) {
            m = NotificationsMutator.a(m, GraphQLStorySeenState.valueOf(cursor.getString(a)), cursor.getLong(a2));
            this.f7575c.b(3473414, (short) 2);
            return m;
        }
        this.f7575c.b(3473414, (short) 3);
        return m;
    }

    private GraphQLStory m7889o(Cursor cursor) {
        int a = Columns.f7590d.a(cursor);
        int a2 = Columns.f7591e.a(cursor);
        int a3 = Columns.f7595i.a(cursor);
        int a4 = Columns.f7596j.a(cursor);
        int a5 = Columns.f7588b.a(cursor);
        int a6 = Columns.f7592f.a(cursor);
        int a7 = Columns.f7604r.a(cursor);
        GraphQLStory$Builder graphQLStory$Builder = new GraphQLStory$Builder();
        graphQLStory$Builder.f3212o = cursor.getString(a6);
        GraphQLStory$Builder graphQLStory$Builder2 = graphQLStory$Builder;
        graphQLStory$Builder2.f3185K = cursor.getString(a5);
        GraphQLStory$Builder graphQLStory$Builder3 = graphQLStory$Builder2;
        GraphQLIcon.Builder builder = new GraphQLIcon.Builder();
        builder.f = cursor.getString(a4);
        graphQLStory$Builder3.f3184J = new GraphQLIcon(builder);
        GraphQLStory$Builder graphQLStory$Builder4 = graphQLStory$Builder3;
        GraphQLActor$Builder graphQLActor$Builder = new GraphQLActor$Builder();
        GraphQLImage$Builder graphQLImage$Builder = new GraphQLImage$Builder();
        graphQLImage$Builder.f3057g = cursor.getString(a3);
        graphQLActor$Builder.ad = graphQLImage$Builder.m3384a();
        graphQLStory$Builder4.f3203f = ImmutableList.of(graphQLActor$Builder.m3389a());
        GraphQLStory$Builder a8 = graphQLStory$Builder4.m3410a(GraphQLStorySeenState.valueOf(cursor.getString(a)));
        a8.f3221x = cursor.getLong(a2);
        a8 = a8;
        a8.az = m7859a(cursor);
        a8 = a8;
        a8.am = m7868b(cursor);
        GraphQLStory a9 = a8.m3419a();
        PropertyHelper.a(a9).t = true;
        PropertyHelper.a(a9, cursor.getInt(a7));
        return a9;
    }

    @Nullable
    @VisibleForTesting
    private FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields m7890p(Cursor cursor) {
        GraphQLStory o = m7889o(cursor);
        if (o == null) {
            return null;
        }
        return NotificationsMutator.a(o, m7872c(cursor), cursor.getString(Columns.f7593g.a(cursor)), m7884j(cursor), m7875e(cursor), m7876f(cursor), m7878g(cursor), m7880h(cursor), m7885k(cursor), m7873d(cursor), m7882i(cursor), m7886l(cursor));
    }

    private static <T> Iterable<T> m7863a(@Nullable Iterable<T> iterable) {
        return iterable == null ? Collections.emptyList() : iterable;
    }

    public void clearUserData() {
        this.f7582j.b();
        getClass();
        try {
            this.f7579g.m7958d();
            this.f7580h.m7958d();
            this.f7585m.clear();
            this.f7586n.clear();
            this.f7577e.delete(this.f7576d.f7611b, null, null);
        } catch (Throwable e) {
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_clearUserData", "Exception thrown when attempting to delete from db", e);
        }
    }

    public final boolean m7918d() {
        return this.f7579g.m7955c() <= 0;
    }

    public final ImmutableList<String> m7919e(long j) {
        Throwable e;
        Cursor cursor = null;
        this.f7582j.b();
        Builder builder = ImmutableList.builder();
        Cursor query;
        try {
            query = this.f7577e.query(this.f7576d.f7611b, new String[]{Columns.f7588b.a()}, Columns.f7589c.a() + "=? AND " + Columns.f7590d.a() + "=?", new String[]{String.valueOf(j), GraphQLStorySeenState.UNSEEN_AND_UNREAD.name()}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int a = Columns.f7588b.a(query);
                        do {
                            builder.c(query.getString(a));
                        } while (query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        this.f7581i.a("GraphQLNotificationsContentProviderHelper_unseen_ids_fetch_error", "Error fetching unseen notif Ids", e);
                        if (query != null) {
                            query.close();
                        }
                        return builder.b();
                    } catch (Throwable th) {
                        e = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_unseen_ids_fetch_error", "Error fetching unseen notif Ids", e);
            if (query != null) {
                query.close();
            }
            return builder.b();
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        return builder.b();
    }

    private String m7883i(long j) {
        Cursor query;
        Throwable e;
        Cursor cursor = null;
        this.f7582j.b();
        try {
            String string;
            query = this.f7577e.query(this.f7576d.f7611b, new String[]{Columns.f7591e.a()}, Columns.f7589c.a() + "=? AND " + Columns.f7590d.a() + "=?", new String[]{String.valueOf(j), GraphQLStorySeenState.UNSEEN_AND_UNREAD.name()}, Columns.f7591e.a() + " asc LIMIT 1");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        string = query.getString(Columns.f7591e.a(query));
                        if (query != null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        this.f7581i.a("GraphQLNotificationsContentProviderHelper_oldest_unseen_notif_time_fetch_error", "Error fetching oldest unseen notif", e);
                        if (query != null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            string = null;
            if (query != null) {
                return string;
            }
            query.close();
            return string;
        } catch (Exception e3) {
            e = e3;
            query = null;
            this.f7581i.a("GraphQLNotificationsContentProviderHelper_oldest_unseen_notif_time_fetch_error", "Error fetching oldest unseen notif", e);
            if (query != null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
    }

    public final void m7900a(Map<String, FetchNotificationsLikeCountModel> map) {
        this.f7582j.b();
        if (map != null && !map.isEmpty()) {
            Uri build = this.f7576d.f7611b.buildUpon().appendQueryParameter("NO_NOTIFY", "1").build();
            for (Entry entry : map.entrySet()) {
                FetchNotificationsLikeCountModel fetchNotificationsLikeCountModel = (FetchNotificationsLikeCountModel) entry.getValue();
                int a = (fetchNotificationsLikeCountModel == null || fetchNotificationsLikeCountModel.k() == null || fetchNotificationsLikeCountModel.k().a() == null) ? (fetchNotificationsLikeCountModel.j() == null || fetchNotificationsLikeCountModel.j().a() == null || fetchNotificationsLikeCountModel.j().a().a() == null) ? 0 : fetchNotificationsLikeCountModel.j().a().a().a() : fetchNotificationsLikeCountModel.k().a().a();
                ContentValues contentValues = new ContentValues();
                contentValues.put(Columns.f7604r.a(), Integer.valueOf(a));
                Expression a2 = SqlExpression.a(Columns.f7588b.a(), (String) entry.getKey());
                try {
                    this.f7577e.update(build, contentValues, a2.a(), a2.b());
                } catch (Throwable e) {
                    this.f7581i.a("GraphQLNotificationsContentProviderHelper_updateLikeCounts", "Exception thrown when attempting to update like count", e);
                }
            }
            this.f7577e.notifyChange(this.f7576d.f7611b, null);
        }
    }

    private void m7864a(Collection<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> collection) {
        this.f7580h.m7951a((Iterable) collection);
    }

    private void m7871b(Iterable<String> iterable) {
        this.f7580h.m7945a(false);
        for (String a : iterable) {
            Cursor a2 = m7858a(f7573b, a);
            if (a2 != null) {
                try {
                    if (a2.moveToFirst()) {
                        Object a3 = m7860a(a2, false);
                        if (a3 == null) {
                            a3 = m7890p(a2);
                        }
                        if (a3 != null) {
                            this.f7580h.m7954b(a3);
                        }
                        if (a2 != null) {
                            a2.close();
                        }
                    }
                } catch (Throwable th) {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
            if (a2 != null) {
                a2.close();
            }
        }
        this.f7580h.m7948f();
        this.f7580h.m7945a(true);
    }
}
