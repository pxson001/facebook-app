package com.facebook.photos.pandora.common.futures.photocollage;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.data.model.PandoraSingleMediaModel;
import com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper;
import com.facebook.photos.pandora.protocols.PandoraModelConversionHelper;
import com.facebook.photos.pandora.protocols.PandoraQuery.PandoraProfileSuggestedPhotoQueryString;
import com.facebook.photos.pandora.protocols.PandoraQueryInterfaces.PandoraMediaImageWithFeedbackFields;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraProfileSuggestedPhotoQueryModel;
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
/* compiled from: commerce_carousel_interaction */
public class PandoraSuggestedProfilePhotosFutureGenerator extends PandoraPhotoCollageFetchPhotosFutureGenerator {
    private static volatile PandoraSuggestedProfilePhotosFutureGenerator f17425d;
    private final PandoraGraphQLParamImageHelper f17426a;
    private final GraphQLQueryExecutor f17427b;
    private final ExecutorService f17428c;

    /* compiled from: commerce_carousel_interaction */
    class GraphQLToPandoraConverterFunction implements Function<GraphQLResult<PandoraProfileSuggestedPhotoQueryModel>, OperationResult> {
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return OperationResult.a(ErrorCode.API_ERROR);
            }
            ImmutableList immutableList;
            GraphQLPageInfo a;
            PandoraProfileSuggestedPhotoQueryModel pandoraProfileSuggestedPhotoQueryModel = (PandoraProfileSuggestedPhotoQueryModel) graphQLResult.e;
            if (pandoraProfileSuggestedPhotoQueryModel == null || pandoraProfileSuggestedPhotoQueryModel.a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a().a().isEmpty()) {
                immutableList = RegularImmutableList.a;
            } else {
                Builder builder = new Builder();
                for (int i = 0; i < pandoraProfileSuggestedPhotoQueryModel.a().a().a().size(); i++) {
                    builder.c(new PandoraSingleMediaModel(PandoraModelConversionHelper.a((PandoraMediaImageWithFeedbackFields) pandoraProfileSuggestedPhotoQueryModel.a().a().a().get(i))));
                }
                immutableList = builder.b();
            }
            ImmutableList immutableList2 = immutableList;
            pandoraProfileSuggestedPhotoQueryModel = (PandoraProfileSuggestedPhotoQueryModel) graphQLResult.e;
            GraphQLPageInfo.Builder builder2 = new GraphQLPageInfo.Builder();
            if (pandoraProfileSuggestedPhotoQueryModel == null || pandoraProfileSuggestedPhotoQueryModel.a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a().j() == null) {
                a = builder2.a();
            } else {
                builder2.h = pandoraProfileSuggestedPhotoQueryModel.a().a().j().v_();
                builder2.e = pandoraProfileSuggestedPhotoQueryModel.a().a().j().a();
                builder2.f = false;
                builder2.g = pandoraProfileSuggestedPhotoQueryModel.a().a().j().c();
                a = builder2.a();
            }
            return OperationResult.a(new PandoraSlicedFeedResult(a, immutableList2));
        }
    }

    public static com.facebook.photos.pandora.common.futures.photocollage.PandoraSuggestedProfilePhotosFutureGenerator m21402a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17425d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.futures.photocollage.PandoraSuggestedProfilePhotosFutureGenerator.class;
        monitor-enter(r1);
        r0 = f17425d;	 Catch:{ all -> 0x003a }
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
        r0 = m21403b(r0);	 Catch:{ all -> 0x0035 }
        f17425d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17425d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.futures.photocollage.PandoraSuggestedProfilePhotosFutureGenerator.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.futures.photocollage.PandoraSuggestedProfilePhotosFutureGenerator");
    }

    private static PandoraSuggestedProfilePhotosFutureGenerator m21403b(InjectorLike injectorLike) {
        return new PandoraSuggestedProfilePhotosFutureGenerator((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PandoraGraphQLParamImageHelper.m21385a(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public PandoraSuggestedProfilePhotosFutureGenerator(ExecutorService executorService, PandoraGraphQLParamImageHelper pandoraGraphQLParamImageHelper, GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f17428c = executorService;
        this.f17426a = pandoraGraphQLParamImageHelper;
        this.f17427b = graphQLQueryExecutor;
    }

    public final ListenableFuture<OperationResult> mo903a(@Nullable String str, @Nullable String str2, PandoraInstanceId pandoraInstanceId, int i, boolean z) {
        GraphQlQueryString pandoraProfileSuggestedPhotoQueryString = new PandoraProfileSuggestedPhotoQueryString();
        pandoraProfileSuggestedPhotoQueryString.a("count", "20");
        if (!Strings.isNullOrEmpty(str)) {
            pandoraProfileSuggestedPhotoQueryString.a("before", str);
        }
        if (!Strings.isNullOrEmpty(str2)) {
            pandoraProfileSuggestedPhotoQueryString.a("after", str2);
        }
        this.f17426a.m21387a(pandoraProfileSuggestedPhotoQueryString);
        return Futures.a(this.f17427b.a(GraphQLRequest.a(pandoraProfileSuggestedPhotoQueryString).a(GraphQLCachePolicy.c).a(z ? RequestPriority.INTERACTIVE : RequestPriority.CAN_WAIT)), new GraphQLToPandoraConverterFunction(), this.f17428c);
    }
}
