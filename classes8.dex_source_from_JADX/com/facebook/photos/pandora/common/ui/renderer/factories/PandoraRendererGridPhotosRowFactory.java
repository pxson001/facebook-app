package com.facebook.photos.pandora.common.ui.renderer.factories;

import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.data.model.PandoraAlbumStoryModel;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.data.model.PandoraDataModelType;
import com.facebook.photos.pandora.common.data.model.PandoraMultiPhotoStoryModel;
import com.facebook.photos.pandora.common.data.model.PandoraSinglePhotoModel;
import com.facebook.photos.pandora.common.data.model.PandoraSinglePhotoStoryModel;
import com.facebook.photos.pandora.common.ui.renderer.highlights.PandoraHighlightsCalculator;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiPhotosRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiPhotosRow.PandoraMultiPhotoStoryEntry;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.gms.cast.metadata.LOCATION_LONGITUDE */
public class PandoraRendererGridPhotosRowFactory extends AbstractPandoraRendererSingleDataModelRowFactory {
    private static volatile PandoraRendererGridPhotosRowFactory f17483d;
    private final Lazy<PandoraGraphQLObjectExtractor> f17484a;
    private final Lazy<PandoraRendererMultiPhotosRowEntryCache> f17485b;
    private final Lazy<PandoraHighlightsCalculator> f17486c;

    public static com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererGridPhotosRowFactory m21458a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17483d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererGridPhotosRowFactory.class;
        monitor-enter(r1);
        r0 = f17483d;	 Catch:{ all -> 0x003a }
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
        r0 = m21461b(r0);	 Catch:{ all -> 0x0035 }
        f17483d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17483d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererGridPhotosRowFactory.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererGridPhotosRowFactory");
    }

    private static PandoraRendererGridPhotosRowFactory m21461b(InjectorLike injectorLike) {
        return new PandoraRendererGridPhotosRowFactory(IdBasedSingletonScopeProvider.b(injectorLike, 9390), IdBasedSingletonScopeProvider.b(injectorLike, 9393), IdBasedSingletonScopeProvider.b(injectorLike, 9392));
    }

    @Inject
    public PandoraRendererGridPhotosRowFactory(Lazy<PandoraRendererMultiPhotosRowEntryCache> lazy, Lazy<PandoraGraphQLObjectExtractor> lazy2, Lazy<PandoraHighlightsCalculator> lazy3) {
        this.f17484a = lazy2;
        this.f17485b = lazy;
        this.f17486c = lazy3;
    }

    public final boolean mo1047a(PandoraDataModel pandoraDataModel) {
        return pandoraDataModel != null;
    }

    public final ImmutableList<PandoraRendererRow> mo1046a(PandoraRendererCacheConfig pandoraRendererCacheConfig, PandoraDataModel pandoraDataModel) {
        int i = 0;
        if (!mo1047a(pandoraDataModel)) {
            return RegularImmutableList.a;
        }
        if (pandoraDataModel.mo1041a() == PandoraDataModelType.SINGLE_PHOTO_STORY) {
            PandoraSinglePhotoStoryModel pandoraSinglePhotoStoryModel = (PandoraSinglePhotoStoryModel) pandoraDataModel;
            m21459a(pandoraRendererCacheConfig, pandoraSinglePhotoStoryModel, pandoraSinglePhotoStoryModel.f17372a);
            return m21468b(pandoraRendererCacheConfig);
        } else if (pandoraDataModel.mo1041a() == PandoraDataModelType.ALBUM_POST_SECTION) {
            PandoraAlbumStoryModel pandoraAlbumStoryModel = (PandoraAlbumStoryModel) pandoraDataModel;
            ImmutableList immutableList = pandoraAlbumStoryModel.f17368a;
            int size = immutableList.size();
            while (i < size) {
                m21459a(pandoraRendererCacheConfig, pandoraAlbumStoryModel, (GraphQLStory) immutableList.get(i));
                i++;
            }
            return m21468b(pandoraRendererCacheConfig);
        } else if (pandoraDataModel.mo1041a() == PandoraDataModelType.SINGLE_PHOTO) {
            m21460a(pandoraRendererCacheConfig, (PandoraSinglePhotoModel) pandoraDataModel);
            return m21468b(pandoraRendererCacheConfig);
        } else {
            List d = m21463d(pandoraRendererCacheConfig);
            PandoraMultiPhotoStoryModel pandoraMultiPhotoStoryModel = (PandoraMultiPhotoStoryModel) pandoraDataModel;
            ImmutableList b = ((PandoraGraphQLObjectExtractor) this.f17484a.get()).m21546b(pandoraMultiPhotoStoryModel.f17369a);
            int size2 = b.size();
            while (i < size2) {
                GraphQLPhoto graphQLPhoto = (GraphQLPhoto) b.get(i);
                this.f17486c.get();
                d.add(new PandoraMultiPhotoStoryEntry(pandoraMultiPhotoStoryModel, graphQLPhoto, PandoraHighlightsCalculator.m21482a(graphQLPhoto)));
                i++;
            }
            return m21468b(pandoraRendererCacheConfig);
        }
    }

    public final boolean m21467a(PandoraRendererCacheConfig pandoraRendererCacheConfig) {
        return !m21463d(pandoraRendererCacheConfig).isEmpty();
    }

    public final ImmutableList<PandoraRendererRow> m21468b(PandoraRendererCacheConfig pandoraRendererCacheConfig) {
        if (m21462c(pandoraRendererCacheConfig)) {
            return m21465a(pandoraRendererCacheConfig, false);
        }
        return RegularImmutableList.a;
    }

    public final ImmutableList<PandoraRendererRow> m21465a(PandoraRendererCacheConfig pandoraRendererCacheConfig, boolean z) {
        int i;
        List<PandoraMultiPhotoStoryEntry> d = m21463d(pandoraRendererCacheConfig);
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        int i2 = 0;
        int i3 = 0;
        Builder builder3 = builder;
        for (PandoraMultiPhotoStoryEntry c : d) {
            Builder builder4;
            builder3.c(c);
            i3++;
            if (i3 % 3 == 0) {
                builder2.c(new PandoraRendererMultiPhotosRow(builder3.b()));
                i = i2 + 3;
                builder4 = new Builder();
            } else {
                i = i2;
                builder4 = builder3;
            }
            builder3 = builder4;
            i2 = i;
        }
        i3 = d.size();
        i = 0;
        while (i < i2 && i < i3) {
            d.remove(0);
            i++;
        }
        if (z) {
            PandoraRendererMultiPhotosRow pandoraRendererMultiPhotosRow = new PandoraRendererMultiPhotosRow(builder3.b());
            if (!pandoraRendererMultiPhotosRow.f17508a.isEmpty()) {
                builder2.c(pandoraRendererMultiPhotosRow);
            }
        }
        return builder2.b();
    }

    private boolean m21462c(PandoraRendererCacheConfig pandoraRendererCacheConfig) {
        return m21463d(pandoraRendererCacheConfig).size() >= 3;
    }

    private void m21459a(PandoraRendererCacheConfig pandoraRendererCacheConfig, PandoraDataModel pandoraDataModel, GraphQLStory graphQLStory) {
        GraphQLPhoto a = ((PandoraGraphQLObjectExtractor) this.f17484a.get()).m21545a(graphQLStory);
        if (a != null) {
            this.f17486c.get();
            m21463d(pandoraRendererCacheConfig).add(new PandoraMultiPhotoStoryEntry(pandoraDataModel, a, PandoraHighlightsCalculator.m21482a(a)));
        }
    }

    private void m21460a(PandoraRendererCacheConfig pandoraRendererCacheConfig, PandoraSinglePhotoModel pandoraSinglePhotoModel) {
        GraphQLPhoto graphQLPhoto = pandoraSinglePhotoModel.f17371a;
        if (graphQLPhoto != null) {
            this.f17486c.get();
            m21463d(pandoraRendererCacheConfig).add(new PandoraMultiPhotoStoryEntry(pandoraSinglePhotoModel, graphQLPhoto, PandoraHighlightsCalculator.m21482a(graphQLPhoto)));
        }
    }

    private List<PandoraMultiPhotoStoryEntry> m21463d(PandoraRendererCacheConfig pandoraRendererCacheConfig) {
        List<PandoraMultiPhotoStoryEntry> list;
        this.f17485b.get();
        if (pandoraRendererCacheConfig == null) {
            list = null;
        } else {
            list = (List) PandoraRendererMultiPhotosRowEntryCache.f17493a.a(pandoraRendererCacheConfig);
            if (list == null) {
                list = Lists.a();
            }
            PandoraRendererMultiPhotosRowEntryCache.f17493a.a(pandoraRendererCacheConfig, list);
        }
        return list;
    }
}
