package com.facebook.photos.pandora.common.ui.renderer.factories;

import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.data.model.PandoraDataModelType;
import com.facebook.photos.pandora.common.data.model.PandoraSinglePhotoModel;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererCaptionRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiPhotosRow;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererMultiPhotosRow.PandoraMultiPhotoStoryEntry;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.gms.cast.metadata.CREATION_DATE */
public class PandoraRendererSnowflakeRowFactory extends AbstractPandoraRendererSingleDataModelRowFactory {
    private static volatile PandoraRendererSnowflakeRowFactory f17495a;

    public static com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererSnowflakeRowFactory m21479a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17495a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererSnowflakeRowFactory.class;
        monitor-enter(r1);
        r0 = f17495a;	 Catch:{ all -> 0x0039 }
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
        r0 = m21478a();	 Catch:{ all -> 0x0034 }
        f17495a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f17495a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererSnowflakeRowFactory.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererSnowflakeRowFactory");
    }

    private static PandoraRendererSnowflakeRowFactory m21478a() {
        return new PandoraRendererSnowflakeRowFactory();
    }

    public final boolean mo1047a(PandoraDataModel pandoraDataModel) {
        return pandoraDataModel != null && pandoraDataModel.mo1041a() == PandoraDataModelType.SINGLE_PHOTO;
    }

    public final ImmutableList<? extends PandoraRendererRow> mo1046a(PandoraRendererCacheConfig pandoraRendererCacheConfig, PandoraDataModel pandoraDataModel) {
        if (pandoraDataModel == null || !mo1047a(pandoraDataModel)) {
            return RegularImmutableList.a;
        }
        PandoraSinglePhotoModel pandoraSinglePhotoModel = (PandoraSinglePhotoModel) pandoraDataModel;
        PandoraMultiPhotoStoryEntry pandoraMultiPhotoStoryEntry = new PandoraMultiPhotoStoryEntry(pandoraSinglePhotoModel, pandoraSinglePhotoModel.f17371a, 0.0d);
        String str = (pandoraSinglePhotoModel.f17371a == null || pandoraSinglePhotoModel.f17371a.au() == null) ? null : pandoraSinglePhotoModel.f17371a.au().a().toString();
        if (Strings.isNullOrEmpty(str)) {
            return ImmutableList.of(new PandoraRendererMultiPhotosRow(ImmutableList.of(pandoraMultiPhotoStoryEntry)));
        }
        return ImmutableList.of(new PandoraRendererMultiPhotosRow(ImmutableList.of(pandoraMultiPhotoStoryEntry)), new PandoraRendererCaptionRow(str));
    }
}
