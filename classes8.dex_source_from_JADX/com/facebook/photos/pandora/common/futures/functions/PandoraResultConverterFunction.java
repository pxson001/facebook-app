package com.facebook.photos.pandora.common.futures.functions;

import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.data.model.PandoraSingleMediaModel;
import com.facebook.photos.pandora.protocols.PandoraModelConversionHelper;
import com.facebook.photos.pandora.protocols.PandoraQueryInterfaces.PandoraMediaImageWithFeedbackFields;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraAlbumQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediasetQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraProfileSuggestedPhotoQueryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraTaggedMediasetQueryModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: commercial_break_length_ms */
public class PandoraResultConverterFunction implements Function<GraphQLResult<?>, OperationResult> {
    private static volatile PandoraResultConverterFunction f17414a;

    public static com.facebook.photos.pandora.common.futures.functions.PandoraResultConverterFunction m21395a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f17414a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.futures.functions.PandoraResultConverterFunction.class;
        monitor-enter(r1);
        r0 = f17414a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m21394a();	 Catch:{ all -> 0x0034 }
        f17414a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f17414a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.futures.functions.PandoraResultConverterFunction.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.futures.functions.PandoraResultConverterFunction");
    }

    private static PandoraResultConverterFunction m21394a() {
        return new PandoraResultConverterFunction();
    }

    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null) {
            return OperationResult.a(ErrorCode.API_ERROR);
        }
        if (!(graphQLResult.e instanceof PandoraTaggedMediasetQueryModel) && !(graphQLResult.e instanceof PandoraMediasetQueryModel) && !(graphQLResult.e instanceof PandoraAlbumQueryModel) && !(graphQLResult.e instanceof PandoraProfileSuggestedPhotoQueryModel)) {
            return OperationResult.a(ErrorCode.API_ERROR);
        }
        ImmutableList immutableList;
        GraphQLPageInfo graphQLPageInfo;
        ImmutableList immutableList2;
        Builder builder;
        int i;
        GraphQLPageInfo.Builder builder2;
        GraphQLPageInfo a;
        if (graphQLResult.e instanceof PandoraTaggedMediasetQueryModel) {
            PandoraTaggedMediasetQueryModel pandoraTaggedMediasetQueryModel = (PandoraTaggedMediasetQueryModel) graphQLResult.e;
            if (pandoraTaggedMediasetQueryModel == null || pandoraTaggedMediasetQueryModel.a() == null || pandoraTaggedMediasetQueryModel.a().a() == null || pandoraTaggedMediasetQueryModel.a().a().a().isEmpty()) {
                immutableList2 = RegularImmutableList.a;
            } else {
                builder = new Builder();
                for (i = 0; i < pandoraTaggedMediasetQueryModel.a().a().a().size(); i++) {
                    builder.c(new PandoraSingleMediaModel((PandoraMediaModel) pandoraTaggedMediasetQueryModel.a().a().a().get(i)));
                }
                immutableList2 = builder.b();
            }
            immutableList = immutableList2;
            pandoraTaggedMediasetQueryModel = (PandoraTaggedMediasetQueryModel) graphQLResult.e;
            builder2 = new GraphQLPageInfo.Builder();
            if (pandoraTaggedMediasetQueryModel == null || pandoraTaggedMediasetQueryModel.a() == null || pandoraTaggedMediasetQueryModel.a().a() == null || pandoraTaggedMediasetQueryModel.a().a().j() == null) {
                a = builder2.a();
            } else {
                builder2.h = pandoraTaggedMediasetQueryModel.a().a().j().v_();
                builder2.e = pandoraTaggedMediasetQueryModel.a().a().j().a();
                builder2.f = pandoraTaggedMediasetQueryModel.a().a().j().b();
                builder2.g = pandoraTaggedMediasetQueryModel.a().a().j().c();
                a = builder2.a();
            }
            graphQLPageInfo = a;
        } else if (graphQLResult.e instanceof PandoraMediasetQueryModel) {
            immutableList = m21396a((PandoraMediasetQueryModel) graphQLResult.e);
            graphQLPageInfo = m21397b((PandoraMediasetQueryModel) graphQLResult.e);
        } else if (graphQLResult.e instanceof PandoraProfileSuggestedPhotoQueryModel) {
            PandoraProfileSuggestedPhotoQueryModel pandoraProfileSuggestedPhotoQueryModel = (PandoraProfileSuggestedPhotoQueryModel) graphQLResult.e;
            if (pandoraProfileSuggestedPhotoQueryModel == null || pandoraProfileSuggestedPhotoQueryModel.a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a().a().isEmpty()) {
                immutableList2 = RegularImmutableList.a;
            } else {
                builder = new Builder();
                for (i = 0; i < pandoraProfileSuggestedPhotoQueryModel.a().a().a().size(); i++) {
                    builder.c(new PandoraSingleMediaModel(PandoraModelConversionHelper.a((PandoraMediaImageWithFeedbackFields) pandoraProfileSuggestedPhotoQueryModel.a().a().a().get(i))));
                }
                immutableList2 = builder.b();
            }
            immutableList = immutableList2;
            pandoraProfileSuggestedPhotoQueryModel = (PandoraProfileSuggestedPhotoQueryModel) graphQLResult.e;
            builder2 = new GraphQLPageInfo.Builder();
            if (pandoraProfileSuggestedPhotoQueryModel == null || pandoraProfileSuggestedPhotoQueryModel.a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a() == null || pandoraProfileSuggestedPhotoQueryModel.a().a().j() == null) {
                a = builder2.a();
            } else {
                builder2.h = pandoraProfileSuggestedPhotoQueryModel.a().a().j().v_();
                builder2.e = pandoraProfileSuggestedPhotoQueryModel.a().a().j().a();
                builder2.f = false;
                builder2.g = pandoraProfileSuggestedPhotoQueryModel.a().a().j().c();
                a = builder2.a();
            }
            graphQLPageInfo = a;
        } else {
            PandoraAlbumQueryModel pandoraAlbumQueryModel = (PandoraAlbumQueryModel) graphQLResult.e;
            if (pandoraAlbumQueryModel == null || pandoraAlbumQueryModel.a() == null || pandoraAlbumQueryModel.a().a().isEmpty()) {
                immutableList2 = RegularImmutableList.a;
            } else {
                builder = new Builder();
                for (i = 0; i < pandoraAlbumQueryModel.a().a().size(); i++) {
                    builder.c(new PandoraSingleMediaModel((PandoraMediaModel) pandoraAlbumQueryModel.a().a().get(i)));
                }
                immutableList2 = builder.b();
            }
            immutableList = immutableList2;
            pandoraAlbumQueryModel = (PandoraAlbumQueryModel) graphQLResult.e;
            builder2 = new GraphQLPageInfo.Builder();
            if (pandoraAlbumQueryModel == null || pandoraAlbumQueryModel.a() == null || pandoraAlbumQueryModel.a().a() == null || pandoraAlbumQueryModel.a().a().isEmpty()) {
                a = builder2.a();
            } else {
                builder2.h = pandoraAlbumQueryModel.a().j().v_();
                builder2.e = pandoraAlbumQueryModel.a().j().a();
                builder2.f = pandoraAlbumQueryModel.a().j().b();
                builder2.g = pandoraAlbumQueryModel.a().j().c();
                a = builder2.a();
            }
            graphQLPageInfo = a;
        }
        return OperationResult.a(new PandoraSlicedFeedResult(graphQLPageInfo, immutableList));
    }

    public static ImmutableList<PandoraDataModel> m21396a(PandoraMediasetQueryModel pandoraMediasetQueryModel) {
        if (pandoraMediasetQueryModel == null || pandoraMediasetQueryModel.a() == null || pandoraMediasetQueryModel.a().a().isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        for (int i = 0; i < pandoraMediasetQueryModel.a().a().size(); i++) {
            builder.c(new PandoraSingleMediaModel((PandoraMediaModel) pandoraMediasetQueryModel.a().a().get(i)));
        }
        return builder.b();
    }

    public static GraphQLPageInfo m21397b(PandoraMediasetQueryModel pandoraMediasetQueryModel) {
        GraphQLPageInfo.Builder builder = new GraphQLPageInfo.Builder();
        if (pandoraMediasetQueryModel == null || pandoraMediasetQueryModel.a() == null || pandoraMediasetQueryModel.a().j() == null) {
            return builder.a();
        }
        builder.h = pandoraMediasetQueryModel.a().j().v_();
        builder.e = pandoraMediasetQueryModel.a().j().a();
        builder.f = pandoraMediasetQueryModel.a().j().b();
        builder.g = pandoraMediasetQueryModel.a().j().c();
        return builder.a();
    }
}
