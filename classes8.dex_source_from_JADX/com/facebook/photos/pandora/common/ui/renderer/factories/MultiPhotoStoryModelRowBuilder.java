package com.facebook.photos.pandora.common.ui.renderer.factories;

import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.data.model.PandoraMultiPhotoStoryModel;
import com.facebook.photos.pandora.common.ui.renderer.highlights.PandoraHighlightsCalculator;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiPhotosRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiPhotosRow.PandoraMultiPhotoStoryEntry;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiPhotosRow.PandoraMultiPhotoStoryEntry.PhotoEntryType;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.gms.cast.metadata.RELEASE_DATE */
public class MultiPhotoStoryModelRowBuilder {
    private static volatile MultiPhotoStoryModelRowBuilder f17475c;
    private final Lazy<PandoraHighlightsCalculator> f17476a;
    private final Lazy<PandoraGraphQLObjectExtractor> f17477b;

    public static com.facebook.photos.pandora.common.ui.renderer.factories.MultiPhotoStoryModelRowBuilder m21455a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17475c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.ui.renderer.factories.MultiPhotoStoryModelRowBuilder.class;
        monitor-enter(r1);
        r0 = f17475c;	 Catch:{ all -> 0x003a }
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
        r0 = m21456b(r0);	 Catch:{ all -> 0x0035 }
        f17475c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17475c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.ui.renderer.factories.MultiPhotoStoryModelRowBuilder.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.ui.renderer.factories.MultiPhotoStoryModelRowBuilder");
    }

    private static MultiPhotoStoryModelRowBuilder m21456b(InjectorLike injectorLike) {
        return new MultiPhotoStoryModelRowBuilder(IdBasedSingletonScopeProvider.b(injectorLike, 9392), IdBasedSingletonScopeProvider.b(injectorLike, 9393));
    }

    @Inject
    public MultiPhotoStoryModelRowBuilder(Lazy<PandoraHighlightsCalculator> lazy, Lazy<PandoraGraphQLObjectExtractor> lazy2) {
        this.f17476a = lazy;
        this.f17477b = lazy2;
    }

    public final ImmutableList<PandoraRendererRow> m21457a(PandoraMultiPhotoStoryModel pandoraMultiPhotoStoryModel) {
        int i;
        int i2;
        ImmutableList b = ((PandoraGraphQLObjectExtractor) this.f17477b.get()).m21546b(pandoraMultiPhotoStoryModel.f17369a);
        List<PandoraMultiPhotoStoryEntry> a = Lists.a();
        int size = b.size();
        for (i = 0; i < size; i++) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) b.get(i);
            this.f17476a.get();
            a.add(new PandoraMultiPhotoStoryEntry(pandoraMultiPhotoStoryModel, graphQLPhoto, PandoraHighlightsCalculator.m21482a(graphQLPhoto)));
        }
        i = 0;
        PandoraMultiPhotoStoryEntry pandoraMultiPhotoStoryEntry = null;
        for (PandoraMultiPhotoStoryEntry pandoraMultiPhotoStoryEntry2 : a) {
            PandoraMultiPhotoStoryEntry pandoraMultiPhotoStoryEntry3;
            if ((pandoraMultiPhotoStoryEntry == null || pandoraMultiPhotoStoryEntry.f17505c < pandoraMultiPhotoStoryEntry2.f17505c) && pandoraMultiPhotoStoryEntry2.f17505c > 1.0d) {
                pandoraMultiPhotoStoryEntry = pandoraMultiPhotoStoryEntry2;
            }
            i++;
            if (i != 6 && a.lastIndexOf(pandoraMultiPhotoStoryEntry2) != a.size() - 1) {
                i2 = i;
                pandoraMultiPhotoStoryEntry3 = pandoraMultiPhotoStoryEntry;
            } else if (pandoraMultiPhotoStoryEntry != null) {
                pandoraMultiPhotoStoryEntry.f17506d = true;
                i2 = 0;
                pandoraMultiPhotoStoryEntry3 = null;
            } else {
                i2 = 0;
                pandoraMultiPhotoStoryEntry3 = pandoraMultiPhotoStoryEntry;
            }
            pandoraMultiPhotoStoryEntry = pandoraMultiPhotoStoryEntry3;
            i = i2;
        }
        Builder builder = new Builder();
        Collection a2 = Lists.a();
        i = 3;
        for (PandoraMultiPhotoStoryEntry pandoraMultiPhotoStoryEntry22 : a) {
            if (pandoraMultiPhotoStoryEntry22.f17506d && pandoraMultiPhotoStoryEntry22.m21486a() == PhotoEntryType.LANDSCAPE) {
                builder.c(new PandoraRendererMultiPhotosRow(ImmutableList.of(pandoraMultiPhotoStoryEntry22)));
            } else {
                if (pandoraMultiPhotoStoryEntry22.f17506d && pandoraMultiPhotoStoryEntry22.m21486a() == PhotoEntryType.PORTRAIT) {
                    i = 4;
                }
                a2.add(pandoraMultiPhotoStoryEntry22);
                if (i == a2.size()) {
                    builder.c(new PandoraRendererMultiPhotosRow(ImmutableList.copyOf(a2)));
                    a2.clear();
                    i2 = 3;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (!a2.isEmpty()) {
            builder.c(new PandoraRendererMultiPhotosRow(ImmutableList.copyOf(a2)));
        }
        return builder.b();
    }
}
