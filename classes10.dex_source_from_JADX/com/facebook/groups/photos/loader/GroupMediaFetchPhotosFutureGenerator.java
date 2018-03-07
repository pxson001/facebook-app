package com.facebook.groups.photos.loader;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.photos.fragment.GroupAllPhotosFragment.C33221;
import com.facebook.groups.photos.protocol.FetchGroupPhotos.FetchGroupPhotosString;
import com.facebook.groups.photos.protocol.FetchGroupPhotosModels.FetchGroupPhotosModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;
import com.facebook.photos.pandora.common.data.model.PandoraSingleMediaModel;
import com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TOXICLE_PRIVATE_CANT_GO */
public class GroupMediaFetchPhotosFutureGenerator extends PandoraPhotoCollageFetchPhotosFutureGenerator {
    private static volatile GroupMediaFetchPhotosFutureGenerator f23049g;
    public String f23050a = "";
    private final GraphQLQueryExecutor f23051b;
    private final ExecutorService f23052c;
    private final PandoraGraphQLParamImageHelper f23053d;
    public C33221 f23054e;
    private AutomaticPhotoCaptioningUtils f23055f;

    /* compiled from: TOXICLE_PRIVATE_CANT_GO */
    class GraphQLToPandoraConverterFunction implements Function<GraphQLResult<FetchGroupPhotosModel>, OperationResult> {
        final /* synthetic */ GroupMediaFetchPhotosFutureGenerator f23048a;

        public GraphQLToPandoraConverterFunction(GroupMediaFetchPhotosFutureGenerator groupMediaFetchPhotosFutureGenerator) {
            this.f23048a = groupMediaFetchPhotosFutureGenerator;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return OperationResult.a(ErrorCode.API_ERROR);
            }
            String str;
            ImmutableList immutableList;
            GraphQLPageInfo a;
            GraphQLGroupVisibility k = ((FetchGroupPhotosModel) graphQLResult.e).m24411k();
            if (!(k == GraphQLGroupVisibility.OPEN || k == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || ((FetchGroupPhotosModel) graphQLResult.e).m24410j() == GraphQLGroupJoinState.MEMBER)) {
                C33221 c33221 = this.f23048a.f23054e;
                c33221.f23016a.aq.setText(c33221.f23016a.ar.m24421c());
            }
            GroupMediaFetchPhotosFutureGenerator groupMediaFetchPhotosFutureGenerator = this.f23048a;
            FetchGroupPhotosModel fetchGroupPhotosModel = (FetchGroupPhotosModel) graphQLResult.e;
            if (fetchGroupPhotosModel == null || fetchGroupPhotosModel.m24407a() == null) {
                str = "";
            } else {
                str = fetchGroupPhotosModel.m24407a().m24400j();
            }
            groupMediaFetchPhotosFutureGenerator.f23050a = str;
            fetchGroupPhotosModel = (FetchGroupPhotosModel) graphQLResult.e;
            if (fetchGroupPhotosModel == null || fetchGroupPhotosModel.m24407a() == null || fetchGroupPhotosModel.m24407a().m24401k() == null || fetchGroupPhotosModel.m24407a().m24401k().m24393a().isEmpty()) {
                immutableList = RegularImmutableList.a;
            } else {
                Builder builder = new Builder();
                for (int i = 0; i < fetchGroupPhotosModel.m24407a().m24401k().m24393a().size(); i++) {
                    builder.c(new PandoraSingleMediaModel((PandoraMediaModel) fetchGroupPhotosModel.m24407a().m24401k().m24393a().get(i)));
                }
                immutableList = builder.b();
            }
            ImmutableList immutableList2 = immutableList;
            fetchGroupPhotosModel = (FetchGroupPhotosModel) graphQLResult.e;
            GraphQLPageInfo.Builder builder2 = new GraphQLPageInfo.Builder();
            if (fetchGroupPhotosModel == null || fetchGroupPhotosModel.m24407a() == null || fetchGroupPhotosModel.m24407a().m24401k() == null || fetchGroupPhotosModel.m24407a().m24401k().m24393a().isEmpty()) {
                a = builder2.a();
            } else {
                builder2.h = fetchGroupPhotosModel.m24407a().m24401k().m24394j().v_();
                builder2.e = fetchGroupPhotosModel.m24407a().m24401k().m24394j().a();
                builder2.f = fetchGroupPhotosModel.m24407a().m24401k().m24394j().b();
                builder2.g = fetchGroupPhotosModel.m24407a().m24401k().m24394j().c();
                a = builder2.a();
            }
            return OperationResult.a(new PandoraSlicedFeedResult(a, immutableList2));
        }
    }

    public static com.facebook.groups.photos.loader.GroupMediaFetchPhotosFutureGenerator m24260a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23049g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.photos.loader.GroupMediaFetchPhotosFutureGenerator.class;
        monitor-enter(r1);
        r0 = f23049g;	 Catch:{ all -> 0x003a }
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
        r0 = m24262b(r0);	 Catch:{ all -> 0x0035 }
        f23049g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23049g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.photos.loader.GroupMediaFetchPhotosFutureGenerator.a(com.facebook.inject.InjectorLike):com.facebook.groups.photos.loader.GroupMediaFetchPhotosFutureGenerator");
    }

    private static GroupMediaFetchPhotosFutureGenerator m24262b(InjectorLike injectorLike) {
        return new GroupMediaFetchPhotosFutureGenerator((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), PandoraGraphQLParamImageHelper.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    @Inject
    public GroupMediaFetchPhotosFutureGenerator(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, PandoraGraphQLParamImageHelper pandoraGraphQLParamImageHelper, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f23052c = executorService;
        this.f23051b = graphQLQueryExecutor;
        this.f23053d = pandoraGraphQLParamImageHelper;
        this.f23055f = automaticPhotoCaptioningUtils;
    }

    public final ListenableFuture<OperationResult> m24263a(@Nullable String str, @Nullable String str2, PandoraInstanceId pandoraInstanceId, int i, boolean z) {
        RequestPriority requestPriority;
        GraphQLQueryExecutor graphQLQueryExecutor = this.f23051b;
        GraphQLRequest a = GraphQLRequest.a(m24261a(i, pandoraInstanceId, str, str2)).a(GraphQLCachePolicy.c);
        if (z) {
            requestPriority = RequestPriority.INTERACTIVE;
        } else {
            requestPriority = RequestPriority.CAN_WAIT;
        }
        return Futures.a(graphQLQueryExecutor.a(a.a(requestPriority)), new GraphQLToPandoraConverterFunction(this), this.f23052c);
    }

    private FetchGroupPhotosString m24261a(int i, PandoraInstanceId pandoraInstanceId, @Nullable String str, @Nullable String str2) {
        GraphQlQueryString fetchGroupPhotosString = new FetchGroupPhotosString();
        this.f23053d.a(fetchGroupPhotosString);
        fetchGroupPhotosString.a("group_id", ((SimplePandoraInstanceId) pandoraInstanceId).a);
        fetchGroupPhotosString.a("count", String.valueOf(i));
        fetchGroupPhotosString.a("automatic_photo_captioning_enabled", Boolean.toString(this.f23055f.a()));
        if (!Strings.isNullOrEmpty(str)) {
            fetchGroupPhotosString.a("before", str);
        }
        if (!Strings.isNullOrEmpty(str2)) {
            fetchGroupPhotosString.a("after", str2);
        }
        return fetchGroupPhotosString;
    }
}
