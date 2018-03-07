package com.facebook.photos.mediagallery;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.NodesMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.PhotosByCategoryMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.ReactionStoryMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.SetIdMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.SetTokenMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.CategoryQueryParam;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.query.param.MediaTypeQueryParam;
import com.facebook.photos.mediafetcher.query.param.MultiIdQueryParam;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: itemSelected */
public class MediaGalleryLauncherParamsFactory {
    private static volatile MediaGalleryLauncherParamsFactory f10675a;

    /* compiled from: itemSelected */
    public class Builder extends com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder<MediaMetadata> {
        public Builder(MediaFetcherConstructionRule mediaFetcherConstructionRule) {
            super(mediaFetcherConstructionRule);
        }

        public final Builder m12735b(ImmutableList<? extends SizeAwareMedia> immutableList) {
            Preconditions.checkNotNull(immutableList);
            Collection a = Lists.a();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                a.add(PhotosMetadataConversionHelper.b((SizeAwareMedia) immutableList.get(i)));
            }
            m12722a(ImmutableList.copyOf(a));
            return this;
        }
    }

    public static com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory m12745a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10675a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory.class;
        monitor-enter(r1);
        r0 = f10675a;	 Catch:{ all -> 0x0039 }
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
        r0 = m12744a();	 Catch:{ all -> 0x0034 }
        f10675a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10675a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory");
    }

    private static MediaGalleryLauncherParamsFactory m12744a() {
        return new MediaGalleryLauncherParamsFactory();
    }

    public static Builder m12736a(GraphQLAlbum graphQLAlbum) {
        Preconditions.checkNotNull(graphQLAlbum);
        return m12741a(graphQLAlbum.u());
    }

    public static Builder m12741a(String str) {
        Preconditions.checkNotNull(str);
        return new Builder(MediaFetcherConstructionRule.m12416a(SetIdMediaQueryProvider.class, new IdQueryParam(str)));
    }

    public static Builder m12737a(GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkNotNull(graphQLStoryAttachment);
        com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder builder = new Builder(MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(ImmutableList.of(graphQLStoryAttachment.r().b()))));
        MediaMetadataModel a = PhotosMetadataConversionHelper.a(graphQLStoryAttachment.r());
        builder.m12722a(ImmutableList.of(a));
        builder.m12723a(a.d());
        return builder;
    }

    public static Builder m12739a(ImmutableList<GraphQLStoryAttachment> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Collection a = Lists.a();
        Collection a2 = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) immutableList.get(i);
            if (!GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment)) {
                a.add(graphQLStoryAttachment.r().b());
                a2.add(PhotosMetadataConversionHelper.a(graphQLStoryAttachment.r()));
            }
        }
        com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder builder = new Builder(MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(ImmutableList.copyOf(a))));
        builder.m12722a(ImmutableList.copyOf(a2));
        return builder;
    }

    public static Builder m12740a(ImmutableList<GraphQLStoryAttachment> immutableList, int i) {
        com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder a = m12739a((ImmutableList) immutableList);
        if (i >= 0 && i < immutableList.size()) {
            GraphQLMedia r = ((GraphQLStoryAttachment) immutableList.get(i)).r();
            if (!(r == null || Strings.isNullOrEmpty(r.b()))) {
                a.m12723a(r.b());
            }
        }
        return a;
    }

    public static Builder m12743a(String str, @Nullable List<? extends SizeAwareMedia> list) {
        Builder builder = new Builder(MediaFetcherConstructionRule.m12416a(ReactionStoryMediaQueryProvider.class, new IdQueryParam(str)));
        if (list != null) {
            builder.m12735b(ImmutableList.copyOf(list));
        }
        return builder;
    }

    public static Builder m12746b(ImmutableList<GraphQLPhoto> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Collection a = Lists.a();
        Collection a2 = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) immutableList.get(i);
            a.add(graphQLPhoto.K());
            MediaMetadataModel mediaMetadataModel = null;
            if (graphQLPhoto != null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a3 = PhotosMetadataConversionHelper.a(flatBufferBuilder, graphQLPhoto);
                if (a3 != 0) {
                    flatBufferBuilder.d(a3);
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mediaMetadataModel = new MediaMetadataModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }
            a2.add(mediaMetadataModel);
        }
        com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder builder = new Builder(MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(ImmutableList.copyOf(a))));
        builder.m12722a(ImmutableList.copyOf(a2));
        return builder;
    }

    public static Builder m12748c(ImmutableList<? extends SizeAwareMedia> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Collection a = Lists.a();
        Collection a2 = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SizeAwareMedia sizeAwareMedia = (SizeAwareMedia) immutableList.get(i);
            a.add(sizeAwareMedia.d());
            a2.add(PhotosMetadataConversionHelper.b(sizeAwareMedia));
        }
        com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder builder = new Builder(MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(ImmutableList.copyOf(a))));
        builder.m12722a(ImmutableList.copyOf(a2));
        return builder;
    }

    public static MediaFetcherConstructionRule m12749d(ImmutableList<MediaMetadata> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Collection a = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.add(((MediaMetadata) immutableList.get(i)).d());
        }
        return MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(ImmutableList.copyOf(a)));
    }

    public static Builder m12738a(GraphQLStorySet graphQLStorySet) {
        Preconditions.checkNotNull(graphQLStorySet);
        Collection a = Lists.a();
        Collection a2 = Lists.a();
        if (graphQLStorySet.z() != null) {
            Preconditions.checkNotNull(graphQLStorySet.z().j());
            ImmutableList j = graphQLStorySet.z().j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                GraphQLStory graphQLStory = (GraphQLStory) j.get(i);
                Preconditions.checkNotNull(graphQLStory);
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                if (o != null) {
                    GraphQLMedia r = o.r();
                    Preconditions.checkNotNull(r);
                    a.add(PhotosMetadataConversionHelper.a(r));
                    a2.add(r.b());
                }
            }
        }
        com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder builder = new Builder(MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(ImmutableList.copyOf(a2))));
        builder.m12722a(ImmutableList.copyOf(a));
        return builder;
    }

    public static Builder m12747b(String str) {
        return new Builder(MediaFetcherConstructionRule.m12416a(SetTokenMediaQueryProvider.class, MediaTypeQueryParam.m12708b(str)));
    }

    public static Builder m12750f(ImmutableList<String> immutableList) {
        return new Builder(MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(immutableList)));
    }

    public static Builder m12742a(String str, CategoryInputCategoryName categoryInputCategoryName, String str2) {
        com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder builder = new Builder(MediaFetcherConstructionRule.m12416a(PhotosByCategoryMediaQueryProvider.class, new CategoryQueryParam(str, categoryInputCategoryName, str2)));
        builder.f10662n = false;
        return builder;
    }
}
