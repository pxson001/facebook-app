package com.facebook.localcontent.photos;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQL.PhotosByCategoryQueryString;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.PhotosByCategoryQueryModel;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.data.model.PandoraSingleMediaModel;
import com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.google.common.base.Function;
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
/* compiled from: dp */
public class PhotoCategoryFetchPhotosFutureGenerator extends PandoraPhotoCollageFetchPhotosFutureGenerator {
    private static volatile PhotoCategoryFetchPhotosFutureGenerator f15174d;
    private final ExecutorService f15175a;
    private final GraphQLQueryExecutor f15176b;
    private final PandoraGraphQLParamImageHelper f15177c;

    /* compiled from: dp */
    class GraphQLToPandoraResultConverterFunction implements Function<GraphQLResult<PhotosByCategoryQueryModel>, OperationResult> {
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return OperationResult.a(ErrorCode.API_ERROR);
            }
            ImmutableList immutableList;
            GraphQLPageInfo a;
            PhotosByCategoryQueryModel photosByCategoryQueryModel = (PhotosByCategoryQueryModel) graphQLResult.e;
            if (photosByCategoryQueryModel == null || photosByCategoryQueryModel.a() == null || photosByCategoryQueryModel.a().a().isEmpty()) {
                immutableList = RegularImmutableList.a;
            } else {
                Builder builder = ImmutableList.builder();
                ImmutableList a2 = photosByCategoryQueryModel.a().a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    builder.c(new PandoraSingleMediaModel((PandoraMediaModel) a2.get(i)));
                }
                immutableList = builder.b();
            }
            ImmutableList immutableList2 = immutableList;
            photosByCategoryQueryModel = (PhotosByCategoryQueryModel) graphQLResult.e;
            GraphQLPageInfo.Builder builder2 = new GraphQLPageInfo.Builder();
            if (photosByCategoryQueryModel == null || photosByCategoryQueryModel.a() == null || photosByCategoryQueryModel.a().j() == null) {
                a = builder2.a();
            } else {
                DefaultPageInfoFieldsModel j = photosByCategoryQueryModel.a().j();
                builder2.h = j.v_();
                builder2.e = j.a();
                builder2.f = j.b();
                builder2.g = j.c();
                a = builder2.a();
            }
            return OperationResult.a(new PandoraSlicedFeedResult(a, immutableList2));
        }
    }

    public static com.facebook.localcontent.photos.PhotoCategoryFetchPhotosFutureGenerator m17615a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15174d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.localcontent.photos.PhotoCategoryFetchPhotosFutureGenerator.class;
        monitor-enter(r1);
        r0 = f15174d;	 Catch:{ all -> 0x003a }
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
        r0 = m17616b(r0);	 Catch:{ all -> 0x0035 }
        f15174d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15174d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.localcontent.photos.PhotoCategoryFetchPhotosFutureGenerator.a(com.facebook.inject.InjectorLike):com.facebook.localcontent.photos.PhotoCategoryFetchPhotosFutureGenerator");
    }

    private static PhotoCategoryFetchPhotosFutureGenerator m17616b(InjectorLike injectorLike) {
        return new PhotoCategoryFetchPhotosFutureGenerator((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), PandoraGraphQLParamImageHelper.m21385a(injectorLike));
    }

    @Inject
    PhotoCategoryFetchPhotosFutureGenerator(ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, PandoraGraphQLParamImageHelper pandoraGraphQLParamImageHelper) {
        this.f15175a = executorService;
        this.f15176b = graphQLQueryExecutor;
        this.f15177c = pandoraGraphQLParamImageHelper;
    }

    public final ListenableFuture<OperationResult> mo903a(@Nullable String str, @Nullable String str2, PandoraInstanceId pandoraInstanceId, int i, boolean z) {
        String name;
        GraphQlQueryString photosByCategoryQueryString = new PhotosByCategoryQueryString();
        PhotosByCategoryPandoraInstanceId photosByCategoryPandoraInstanceId = (PhotosByCategoryPandoraInstanceId) pandoraInstanceId;
        GraphQLPhotosByCategoryEntryPoint graphQLPhotosByCategoryEntryPoint = photosByCategoryPandoraInstanceId.f15206d;
        Object obj = (graphQLPhotosByCategoryEntryPoint == null || GraphQLPhotosByCategoryEntryPoint.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.equals(graphQLPhotosByCategoryEntryPoint)) ? null : 1;
        GraphQlQueryString a = photosByCategoryQueryString.a("page_id", photosByCategoryPandoraInstanceId.f15203a).a("category", photosByCategoryPandoraInstanceId.f15205c);
        String str3 = "entry_point";
        if (obj != null) {
            name = graphQLPhotosByCategoryEntryPoint.name();
        } else {
            name = null;
        }
        a.a(str3, name).a("beforeCursor", str).a("afterCursor", str2).a("count", Integer.valueOf(i));
        this.f15177c.m21387a(photosByCategoryQueryString);
        return Futures.a(this.f15176b.a(GraphQLRequest.a(photosByCategoryQueryString).a(GraphQLCachePolicy.c).a(z ? RequestPriority.INTERACTIVE : RequestPriority.CAN_WAIT)), new GraphQLToPandoraResultConverterFunction(), this.f15175a);
    }
}
