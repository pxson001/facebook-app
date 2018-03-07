package com.facebook.privacy.checkup.photofeed.data;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupModels.FetchProfilePhotoCheckupMediaOnlyQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupModels.FetchProfilePhotoCheckupQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupModels.PhotoCheckupPOPMediaModel.PhotosModel;
import com.facebook.privacy.checkup.protocol.PrivacyCheckupClient;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams.BulkEditAlbumType;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams.BulkEditCaller;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams.ObjectPrivacyEdit;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SideloadingFb4aUpgradeWifiActiveGraphQlMutation */
public class PhotoCheckupManager {
    private static volatile PhotoCheckupManager f11073g;
    public final PrivacyCheckupClient f11074a;
    public final PrivacyOperationsClient f11075b;
    public final Clock f11076c;
    public final ExecutorService f11077d;
    public final PrivacyOptionsResultFactory f11078e;
    private final TasksManager f11079f;

    /* compiled from: SideloadingFb4aUpgradeWifiActiveGraphQlMutation */
    public final class GraphQLMorePhotosToCheckupDataTransform implements Function<GraphQLResult<FetchProfilePhotoCheckupMediaOnlyQueryModel>, Void> {
        POPPhotoCheckupData f11071a;

        @Nullable
        public final Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (!(graphQLResult == null || graphQLResult.e == null)) {
                FetchProfilePhotoCheckupMediaOnlyQueryModel fetchProfilePhotoCheckupMediaOnlyQueryModel = (FetchProfilePhotoCheckupMediaOnlyQueryModel) graphQLResult.e;
                if (!(fetchProfilePhotoCheckupMediaOnlyQueryModel.m5421a() == null || fetchProfilePhotoCheckupMediaOnlyQueryModel.m5421a().m5499a() == null)) {
                    PhotoCheckupManager.m11457b(fetchProfilePhotoCheckupMediaOnlyQueryModel.m5421a().m5499a(), this.f11071a);
                }
            }
            return null;
        }

        public GraphQLMorePhotosToCheckupDataTransform(POPPhotoCheckupData pOPPhotoCheckupData) {
            this.f11071a = pOPPhotoCheckupData;
        }
    }

    /* compiled from: SideloadingFb4aUpgradeWifiActiveGraphQlMutation */
    public final class GraphQLProfilePhotoToCheckupDataTransform implements Function<GraphQLResult<FetchProfilePhotoCheckupQueryModel>, Void> {
        POPPhotoCheckupData f11072a;

        @Nullable
        public final Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (!(graphQLResult == null || graphQLResult.e == null)) {
                PhotoCheckupManager.m11455a((FetchProfilePhotoCheckupQueryModel) graphQLResult.e, this.f11072a);
            }
            return null;
        }

        public GraphQLProfilePhotoToCheckupDataTransform(POPPhotoCheckupData pOPPhotoCheckupData) {
            this.f11072a = pOPPhotoCheckupData;
        }
    }

    /* compiled from: SideloadingFb4aUpgradeWifiActiveGraphQlMutation */
    enum Tasks {
        SEND_PRIVACY_EDITS,
        SEND_BULK_PRIVACY_EDIT
    }

    public static com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager m11454a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11073g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager.class;
        monitor-enter(r1);
        r0 = f11073g;	 Catch:{ all -> 0x003a }
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
        r0 = m11456b(r0);	 Catch:{ all -> 0x0035 }
        f11073g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11073g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager");
    }

    private static PhotoCheckupManager m11456b(InjectorLike injectorLike) {
        return new PhotoCheckupManager(PrivacyCheckupClient.m5808a(injectorLike), PrivacyOperationsClient.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PrivacyOptionsResultFactory.b(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public PhotoCheckupManager(PrivacyCheckupClient privacyCheckupClient, PrivacyOperationsClient privacyOperationsClient, Clock clock, ExecutorService executorService, PrivacyOptionsResultFactory privacyOptionsResultFactory, TasksManager tasksManager) {
        this.f11074a = privacyCheckupClient;
        this.f11075b = privacyOperationsClient;
        this.f11076c = clock;
        this.f11077d = executorService;
        this.f11078e = privacyOptionsResultFactory;
        this.f11079f = tasksManager;
    }

    public final boolean m11459a(Map<String, PrivacyOptionFieldsWithExplanation> map, AbstractDisposableFutureCallback<OperationResult> abstractDisposableFutureCallback) {
        final Builder builder = new Builder();
        for (Entry entry : map.entrySet()) {
            builder.c(new ObjectPrivacyEdit((String) entry.getKey(), this.f11076c.a(), GraphQLEditablePrivacyScopeType.ENT_CONTENT, ((PrivacyOptionFieldsWithExplanation) entry.getValue()).c()));
        }
        if (abstractDisposableFutureCallback != null) {
            return this.f11079f.a(Tasks.SEND_PRIVACY_EDITS, new Callable<ListenableFuture<OperationResult>>(this) {
                final /* synthetic */ PhotoCheckupManager f11065b;

                public Object call() {
                    return this.f11065b.f11075b.a("none", builder.b(), true);
                }
            }, abstractDisposableFutureCallback);
        }
        this.f11075b.a("none", builder.b(), true);
        return true;
    }

    public final void m11458a(@Nullable String str, BulkEditCaller bulkEditCaller, BulkEditAlbumType bulkEditAlbumType, String str2, AbstractDisposableFutureCallback<OperationResult> abstractDisposableFutureCallback) {
        final String str3 = str;
        final BulkEditCaller bulkEditCaller2 = bulkEditCaller;
        final BulkEditAlbumType bulkEditAlbumType2 = bulkEditAlbumType;
        final String str4 = str2;
        this.f11079f.a(Tasks.SEND_BULK_PRIVACY_EDIT, new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ PhotoCheckupManager f11070e;

            public Object call() {
                return this.f11070e.f11075b.a(str3, bulkEditCaller2, bulkEditAlbumType2, this.f11070e.f11076c.a(), str4);
            }
        }, abstractDisposableFutureCallback);
    }

    @VisibleForTesting
    static void m11455a(FetchProfilePhotoCheckupQueryModel fetchProfilePhotoCheckupQueryModel, POPPhotoCheckupData pOPPhotoCheckupData) {
        if (fetchProfilePhotoCheckupQueryModel != null && fetchProfilePhotoCheckupQueryModel.m5433a() != null && fetchProfilePhotoCheckupQueryModel.m5433a().m5429k() != null) {
            m11457b(fetchProfilePhotoCheckupQueryModel.m5433a().m5429k(), pOPPhotoCheckupData);
            pOPPhotoCheckupData.f11060e = fetchProfilePhotoCheckupQueryModel.m5433a().m5426a();
            pOPPhotoCheckupData.f11061f = fetchProfilePhotoCheckupQueryModel.m5433a().m5428j();
        }
    }

    public static void m11457b(PhotosModel photosModel, POPPhotoCheckupData pOPPhotoCheckupData) {
        Builder builder = new Builder();
        if (pOPPhotoCheckupData.f11058c != null) {
            builder.b(pOPPhotoCheckupData.f11058c);
        }
        builder.b(photosModel.m5494a());
        pOPPhotoCheckupData.f11058c = builder.b();
        MediaPageInfoModel j = photosModel.m5495j();
        if (j != null) {
            pOPPhotoCheckupData.f11062g = j.a();
            pOPPhotoCheckupData.f11063h = j.b();
        }
    }
}
